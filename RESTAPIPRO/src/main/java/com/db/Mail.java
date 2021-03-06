package com.db;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	public void sendMail(String mailId, String feedback, String farmerName){
		String recipient= mailId;
		Properties properties=new Properties();
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","587");
		final String myAccountEmail="Farmbeefarmer@gmail.com";
		final String password="shynk@147";
		Session session=Session.getInstance(properties,new Authenticator(){
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(myAccountEmail, password);
		}
		});
		try {
		Message message=new MimeMessage(session);
		message.setFrom(new InternetAddress(myAccountEmail));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		message.setSubject("Your recent feedback to FarmBee");
		String htmlCode="<h4>Hey "+farmerName+" ,<br><br> Thank you for joining our FarmBee family and showing love with your Feedback<br><br></h4><h4>Your Feedback<br><br>"+feedback+"<br><br></h2>With Love,<br>FarmBee family!";
		message.setContent(htmlCode,"text/html");
		Transport.send(message);
		System.out.println("Mail Sent Successfully!");
		} catch (MessagingException e) {
		e.printStackTrace();
		}



		
	}

}