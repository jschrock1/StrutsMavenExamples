package com.tutorialspoint.struts2;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionSupport;

public class Emailer extends ActionSupport {

	/**
	 * Example if sending an email... Tried various examples until I found this
	 * one that actually works, was puzzled why others didn't but oh well.
	 */

	public String from;
	public String to;
	public String password;
	public String subject;
	public String body;

	public String execute() {

		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		{
			String ret = SUCCESS;
			try {
				Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from, password);
					}
				});

				Message message = new MimeMessage(session);

				// below line should be my email, but it works without changing
				// this.
				// perhaps it knows the from is me with my from and password
				// passed
				// in in the passwordAuthentication line above...

				message.setFrom(new InternetAddress("from-email@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				message.setSubject(subject);
				message.setText(body);

				Transport.send(message);

				System.out.println("Done");
			} catch (MessagingException e) {
				ret = ERROR;
				e.printStackTrace();
			}
			return ret;
		}
	}
}
