package com.alok.aut.project.Util;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;
/**//**
 * @author 
 *
 *//*
*/public class MailSender {
	public static void send (String fromEmail, String toEmail, String subject, String body, String fileNamePath, String ccEmail, String bccEmail) {
		try {

			// 1) get the session object

			String recipient = toEmail;
			Properties props = new Properties ();
			props.put ("mail.smtp.host", MapUI.smtpHost);
			props.put ("mail.from", MapUI.mailFrom);
			props.put ("mail.smtp.starttls.enable", MapUI.smtp_enable);
			props.put ("mail.smtp.port", MapUI.smtp_port);
			Session session = Session.getInstance (props, null);
			MimeMessage message = new MimeMessage (session);
			message.setRecipients (Message.RecipientType.TO, recipient);
			message.setFrom (new InternetAddress (fromEmail));
			for (String eachTo : toEmail.split (",")) {
				message.addRecipient (Message.RecipientType.TO, new InternetAddress (eachTo));
			}
			if (ccEmail != null) {
				message.addRecipient (Message.RecipientType.CC, new InternetAddress (ccEmail));
			}
			if (bccEmail != null) {
				message.addRecipient (Message.RecipientType.BCC, new InternetAddress (bccEmail));
			}
			message.setSubject (subject);
			//message.setContent(message, "text/html");
			// 3) create MimeBodyPart object and set your message text
			BodyPart bodyPart = new MimeBodyPart ();
			bodyPart.setContent (body, "text/html; charset=utf-8");
			//bodyPart.setContent(arg0, arg1);;
			// 4) create new MimeBodyPart object and set DataHandler object to this object
			MimeBodyPart attachmentPart = new MimeBodyPart ();
			DataSource source = new FileDataSource (fileNamePath);
			attachmentPart.setDataHandler (new DataHandler (source));
			attachmentPart.setFileName (source.getName ());
			attachmentPart.setDisposition ("attachment");
			attachmentPart.setFileName (source.getName ());
			attachmentPart.setHeader ("Content-Transfer-Encoding", "base64");
			attachmentPart.setHeader ("Content-type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			// 5) create Multipart object and add MimeBodyPart objects to this object
			Multipart multipart = new MimeMultipart ();
			multipart.addBodyPart (attachmentPart);
			multipart.addBodyPart (bodyPart);

			// 6) set the multiplart object to the message object
			message.setContent (multipart);

			// 7) send message
			Transport transport = session.getTransport ("smtp");
			transport.sendMessage (message, message.getAllRecipients ());
			transport.close ();
		} catch (Exception e) {
			e.printStackTrace ();
		}
	}
	public static void SendMailToGroup(String filePath,String suiteName) throws IOException {

		String message = "<p style=\"font-size: 1.2em;\">Team,</p>";
		message += "<p style=\"font-size: 1.2em;\">Find attached automation execution report for "+ suiteName +
				"&nbsp;</p>";
		message +="<p>&nbsp;</p>";
		message += "<p style=\"font-size: 1.2em;\">Below is the summary report .&nbsp;</p>";
		message +="<table class=\"ResultTable\" style=\"height: 48px; width: 347px; float: left;\" border=\"2\"";
		message +="<tbody>";
		message +="<tr>";
		message +="<td style=\"width: 126px;\"><strong>SuiteName</strong></td>";
		message +="<td style=\"width: 100px;\"><strong>Pass</strong></td>";
		message +="<td style=\"width: 100px;\"></strong>Fail</td>";
		message +="</tr>";
		message +="<td style=\"width: 126px;\"><strong>"+"VOS"+"</strong></td>";
		message +="<td style=\"width: 100px;\"><strong>"+"TestPass"+"</strong></td>";
		message +="<td style=\"width: 100px;\"></strong>"+"TestFail"+"</td>";
		message +="</tr>";
		message +="</tbody>";
		message +="</table>";
		message +="<p>&nbsp;</p>";
		message +="<p>Thanks</p>";
		message +="<p>QE Team.</p>";
		String subject=" automation execution report";
		MailSender.send(MapUI.FromMailId,MapUI.ToMailId, MapUI.SubjectLine, message, filePath, null, null);

	}

}

