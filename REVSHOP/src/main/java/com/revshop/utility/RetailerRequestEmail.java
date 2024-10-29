package com.revshop.utility;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class RetailerRequestEmail {
	
    private static final String USERNAME = "puchakayalayogananda22@gmail.com";
    private static final String PASSWORD = "jkuobiftuhsnztvk";
    private static final String HOST = "smtp.gmail.com";
    private static final String PORT = "587";

    public static void sendConfirmationEmail(String recipientEmail) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Thankyou for your Registration.");
            message.setText("Dear Retailer,\n\nThank you for registering with RevShop.\n\nWe have received your registration request and will contact you soon.\n\nBest regards,\nRevShop Team");

            Transport.send(message);
            System.out.println("Email sent successfully to " + recipientEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
    }
}
