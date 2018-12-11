package action;

import com.sun.mail.smtp.SMTPSaslAuthenticator;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class EmailSender extends Authenticator {
    public void sender() {

        final String toMail = "schedulead@gmail.com";
        final String fromMail = "anikina.olga.m@yandex.ru";
        final String password = "q9w8e7r6";

        System.out.println("SSLEmail Start");
        Properties mailProperties = new Properties();
        mailProperties.setProperty("mail.transport.protocol", "smtp");
        mailProperties.put("mail.smtp.host", "smtp.gmail.com");
        mailProperties.put("mail.smtp.auth", "true"); // Enabling SMTP Authentication
        mailProperties.put("mail.smtp.port", "587"); //tls
        mailProperties.put("mail.debug", "true");
        mailProperties.put("mail.smtp.socketFactory.port", "465"); //ssl
        mailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        mailProperties.put("mail.smtp.socketFactory.fallback", "false");
        mailProperties.put("mail.smtp.starttls.enable", "true");


        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(toMail, password);
            }
        };

        Session session = Session.getDefaultInstance(mailProperties, auth);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromMail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
            message.setSubject("Servlet's email sender");
            message.setText("If you give that message, you input your e-mail in servlet applicarion!");
            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}

