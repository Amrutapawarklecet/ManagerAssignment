package com.email.service;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public boolean sendEmail(String subject, String message, String to) {

		boolean f=false;
		// From
		String from = "amruta.pawar@maralabs.com";

		// variable for email
		String host = "smtp.gmail.com";

		// get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES" + properties);

		// setting important information to properties object

		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mai.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true"); // ssl- secure socket layer
		properties.put("mail.smtp.auth", "true");

		// Step1: to get the session object...
		Session session = Session.getInstance(properties, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("amruta23pawar@gmail.com", "9343682323");
			}

		});

		session.setDebug(true);

		// step2: compose the message {test, multi media}

		MimeMessage m = new MimeMessage(session);

		try {

			// from email
			m.setFrom(from);

			// adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// adding subject to message
			m.setSubject(subject);

			// adding text to message
			m.setText(message);

			// send

			// Step 3: Send the message

			Transport.send(m);

			System.out.println("Send Sucess...");
			f=true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	//email using attachment file
	public boolean sendAttachmentEmail(String subject, String message, String to) {

		// From
		String from = "amruta.pawar@maralabs.com";
		
		boolean f=false;


		// variable for email
		String host = "smtp.gmail.com";

		// get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES" + properties);

		// setting important information to properties object

		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mai.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true"); // ssl- secure socket layer
		properties.put("mail.smtp.auth", "true");

		// Step1: to get the session object...
		Session session = Session.getInstance(properties, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("amruta23pawar@gmail.com", "9343682323");
			}

		});

		session.setDebug(true);

		// step2: compose the message {test, multi media}

		MimeMessage m = new MimeMessage(session);

		try {

			// from email
			m.setFrom(from);

			// adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// adding subject to message
			m.setSubject(subject);

			// attachment...

			// file path
			String path = "C:\\Users\\Amruta.Pawar\\Desktop\\pexels-luck-galindo-544268.jpg";

			MimeMultipart mimeMultipart = new MimeMultipart();
			// text
			// file

			MimeBodyPart textMime = new MimeBodyPart(); // text

			MimeBodyPart fileMime = new MimeBodyPart(); // file

			try {

				textMime.setText(message);

				File file = new File(path);
				fileMime.attachFile(file);

				mimeMultipart.addBodyPart(textMime);
				mimeMultipart.addBodyPart(fileMime);
			} catch (Exception e) {
			}
			m.setContent(mimeMultipart);

			// Step 3: send Message
			Transport.send(m);
			System.out.println("Send Sucess...");
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
