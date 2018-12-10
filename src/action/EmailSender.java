package action;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class EmailSender {
    public static void sender() {

        String toMail = "scheduleadm@yandex.ru";
        String fromMail = "anikina.olga.m@yandex.ru";
        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.host", "smtp.yandex.ru");
        mailProperties.put("mail.smtp.port", "465");
        mailProperties.put("mail.smtp.auth", "true");
        mailProperties.put("mail.smtp.socketFactory.port", "465");
        mailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");


        Session session = Session.getDefaultInstance(mailProperties);

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

