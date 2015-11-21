package com.tutorialspoint.struts2;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * This is NOT an action class, its just a test java class I created to get
 * sending emails to work, then I moved this logic into the Emailer action
 * class.
 * 
 * @author jay
 *
 */
public class SendMailTLS {

	public static void main(String[] args) {

		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				// Add your email and password here.
				return new PasswordAuthentication("jay.schrock@gmail.com", "YourGmailPassword"); 
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("jay.schrock@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler tst," + "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			System.out.println("Error");
			throw new RuntimeException(e);
		}
	}
}