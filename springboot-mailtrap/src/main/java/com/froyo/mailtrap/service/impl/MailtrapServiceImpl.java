package com.froyo.mailtrap.service.impl;

import com.froyo.mailtrap.config.properties.EmailConfig;
import com.froyo.mailtrap.dto.FeedbackDTO;
import com.froyo.mailtrap.dto.inout.SendFeedbackResponse;
import com.froyo.mailtrap.service.MailtrapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service("mailtrapServiceImpl")
public class MailtrapServiceImpl implements MailtrapService {

    private static final Logger log = LoggerFactory.getLogger(MailtrapServiceImpl.class);

    private final EmailConfig emailConfig;

    public MailtrapServiceImpl(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    @Override
    public SendFeedbackResponse sendFeedback(FeedbackDTO feedbackDTO) {
        SendFeedbackResponse sendFeedbackResponse = new SendFeedbackResponse();

        // Create a mail sender
        var javaMailSenderImpl = new JavaMailSenderImpl();
        javaMailSenderImpl.setHost(emailConfig.getHost());
        javaMailSenderImpl.setPort(emailConfig.getPort());
        javaMailSenderImpl.setUsername(emailConfig.getUserName());
        javaMailSenderImpl.setPassword(emailConfig.getPassword());

        // Create an email instance
        var simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(feedbackDTO.email());
        simpleMailMessage.setTo("57a591e416-d85bfd@inbox.mailtrap.io");
        simpleMailMessage.setSubject(String.format("New feedback from %s ", feedbackDTO.name()));
        simpleMailMessage.setText(feedbackDTO.feedback());

        // Send mail
        javaMailSenderImpl.send(simpleMailMessage);

        return sendFeedbackResponse;
    }

}
