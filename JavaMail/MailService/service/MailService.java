/*
1.	go to ur mail account https://myaccount.google.com/security and turn on access to less scure apps.
2.	add activation.jar and mail.jar to WEB-INF\lib\.
3.	and add dsn.jar, imap.jar, mailapi.jar, pop3.jar, smtp.jar to ur project build path.
*/

package com.jlc.service;

import java.io.*;
import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MailService {
	private static String UNAME = "rohitsachan333@gmail.com";
	private static String PASSWORD = "8115717904007143";
	
	private static Message getMessageForMail(){
		Authenticator auth = new MyPasswordAuthenticator();
		Properties p = new Properties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.port", "465");
		Session sess = Session.getInstance(p, auth);
		Message msg = new MimeMessage(sess);

		return msg;
	}
	
	
	public static void sendMail(String to, String sub, String data){
		try{
			Message msg = getMessageForMail();
			msg.setSubject(sub);
			msg.setFrom(new InternetAddress(UNAME, "JLC"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setRecipient(Message.RecipientType.BCC, new InternetAddress("sachanrohit11@gmail.com"));
			msg.setSentDate(new Date());
			msg.setContent(data, "text/html");
			Transport.send(msg);

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	public static void sendMailWithAttachment(String to, String sub, String data, List<File> files){
		try{
			Message msg = getMessageForMail();
			msg.setSubject(sub);
			msg.setFrom(new InternetAddress(UNAME, "JLC"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		//	msg.setRecipient(Message.RecipientType.BCC, new InternetAddress("sachanrohit11@gmail.com"));
			msg.setSentDate(new Date());

			Multipart body = new MimeMultipart();
			BodyPart part1 = new MimeBodyPart();
			part1.setContent(data, "text/html");
			body.addBodyPart(part1);

			if(files != null){
				for(File f : files){
					BodyPart part = new MimeBodyPart();
					part.setFileName(f.getName());
					DataSource source = new FileDataSource(f);
					DataHandler handler = new DataHandler(source);
					part.setDataHandler(handler);
					body.addBodyPart(part);
				}
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static class MyPasswordAuthenticator extends Authenticator {
		protected PasswordAuthentication getPasswordAuthentication(){
			System.out.println("\n-- getPasswordAuthentication called--");
			return new PasswordAuthentication(UNAME, PASSWORD);
			
		}
	}

}


