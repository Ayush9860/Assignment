package com.ign_hub.emailsender;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

	public static void main(String[] args) {
		// Sender's email address
		String senderEmail = "ayushpardhi800@gmail.com";
		// Sender's email password (you may need an application-specific password)
		String senderPassword = "hvsv pimx mbci fdiy";
		// Recipient's email address
		String recipientEmail = "hr@ignitershub.com";
		// Email subject
		String subject = "Challenge 3 Completed";
		// Email body
		String body = "Name : Ayush Pardhi \nYOP : 2023 \nBranch : Information Technology \n";

		// Set up mail server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com"); // Update with your SMTP server
		properties.put("mail.smtp.port", "587"); // Update with your SMTP port

		// Get the default Session object
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		});

		try {
			// Create a default MimeMessage object
			MimeMessage message = new MimeMessage(session);

			// Set the sender and recipient addresses
			message.setFrom(new InternetAddress(senderEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));

			// Set the email subject and body
			message.setSubject(subject);

			// Create the message body part for text
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText(body);

			// Create the message body part for the image
			MimeBodyPart imagePart = new MimeBodyPart();
			// Specify the path to your image file
			String imagePath = "C:\\Users\\ayush\\Downloads\\RESUME_page-0001.jpg";
			imagePart.attachFile(imagePath);

			// Create a multipart message and add the text and image parts
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(textPart);
			multipart.addBodyPart(imagePart);

			// Set the message content to the multipart
			message.setContent(multipart);

			// Send the message
			Transport.send(message);

			System.out.println("Email with attachment sent successfully!");

		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}