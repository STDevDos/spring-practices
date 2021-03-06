package com.froyo.springBootRestApi.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import java.io.File;

@AllArgsConstructor
@Log4j2
@Service("emailService")
public class EmailService {

    private final JavaMailSender mailSender;
    private final SimpleMailMessage preConfiguredMessage;

    public void sendMail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    public void sendPreConfiguredMail(String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }

    public void sendMailWithAttachment(String to, String subject, String body, String fileToAttach) {
        MimeMessagePreparator preparator = mimeMessage -> {
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setFrom(new InternetAddress("from@gmail.com"));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(body);

            FileSystemResource file = new FileSystemResource(new File(fileToAttach));
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.addAttachment("logo.jpg", file);
        };

        try {
            mailSender.send(preparator);
        } catch (MailException ex) {
            log.error("@@@ sendMailWithAttachment() ", ex);
        }
    }

    public void sendMailWithInlineResources(String to, String subject, String fileToAttach) {
        MimeMessagePreparator preparator = mimeMessage -> {
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setFrom(new InternetAddress("from@gmail.com"));
            mimeMessage.setSubject(subject);

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setText("<html><body><img src='cid:identifier1234'></body></html>", true);

            FileSystemResource res = new FileSystemResource(new File(fileToAttach));
            helper.addInline("identifier1234", res);
        };

        try {
            mailSender.send(preparator);
        } catch (MailException ex) {
            log.error("@@@ sendMailWithInlineResources() ", ex);
        }
    }
}
