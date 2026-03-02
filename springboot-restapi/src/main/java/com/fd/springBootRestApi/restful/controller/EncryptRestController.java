package com.fd.springBootRestApi.restful.controller;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://www.baeldung.com/jasypt
 *
 * @author Froy
 */
@RestController
public class EncryptRestController {

    private final Environment environment;

    public EncryptRestController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("test")
    public String test() {
        return environment.getProperty("encryptedv3.property"); // "Password@3"
    }

    @GetMapping("testBasicTextEncryptor")
    public String testBasicTextEncryptor() {

        String privateData = "secret-data";

        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPasswordCharArray("ESTE_ES_LA_LLAVE".toCharArray());

        String myEncryptedText = textEncryptor.encrypt(privateData);
        String plainText = textEncryptor.decrypt(myEncryptedText);

        // assertNotSame(privateData, myEncryptedText);

        // ------------------------------------------------

        String password = "secret-pass";
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword(password);

        boolean result = passwordEncryptor.checkPassword("secret-spass", encryptedPassword);

        // assertTrue(result);

        /// -------------------------

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        String privateData2 = "secret-dataFroy";
        encryptor.setPassword("some-random-passwprd");
        encryptor.setAlgorithm("PBEWithMD5AndTripleDES");

        String encryptedText2 = encryptor.encrypt(privateData2);
        // assertNotSame(privateData, encryptedText);

        String plainText2 = encryptor.decrypt(encryptedText2);
        // assertEquals(plainText, privateData);

        // ------------------------------pool
        String privateData3 = "secret-dataFroyDaniel";
        PooledPBEStringEncryptor encryptor3 = new PooledPBEStringEncryptor();
        encryptor3.setPoolSize(4);
        encryptor3.setPassword("some-random-data");
        encryptor3.setAlgorithm("PBEWithMD5AndTripleDES");

        String encryptedText3 = encryptor3.encrypt(privateData3);

        String plainText3 = encryptor3.decrypt(encryptedText3);

        return encryptedText3 + " " + plainText3;
    }

}
