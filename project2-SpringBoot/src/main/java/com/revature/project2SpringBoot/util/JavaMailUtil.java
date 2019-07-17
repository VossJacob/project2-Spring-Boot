package com.revature.project2SpringBoot.util;

import java.util.Properties;
import java.util.logging.Level;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.istack.logging.Logger;

public class JavaMailUtil {
	
	public static void sendRecoveryEmail(String email, String recoveryPassword) throws Exception {
	    System.out.println("Preparing to send email");
	    Properties properties = new Properties();//Later used in Session variable to 
	    
	    properties.put("mail.smtp.auth", true);
	    properties.put("mail.smtp.starttls.enable", "true");
	    properties.put("mail.smtp.host", "smtp.gmail.com");//The host where the email is sent FROM.
	    properties.put("mail.smtp.port", "587");
	    
	    //Specify who to send the email to.  
	    String myAccountEmail = "CJPJavaMail@gmail.com";
	    String password = "Orioles123";
	    //Session session1 = Session.
	    //Java Mail has a Session class that makes a mail session.  
	    Session session = Session.getInstance(properties, new Authenticator(){
	        @Override
	        protected PasswordAuthentication getPasswordAuthentication() {
	            //return new PasswordAuthentication(email, password);//Callback function to get password authentication.
	        	return new PasswordAuthentication(myAccountEmail,password);
	        }
	    });
//	    
	    Message message = prepareMassage(session, myAccountEmail, recoveryPassword);//
	    Transport.send(message);
	    System.out.println("Message sent successfully!");
	}
	//prepare the session variable, the email to send FROM, and TO.
	private static Message prepareMassage(Session session, String recipient, String recoveryPassword) {
	    try {
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("smtp.gmail.com"));
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
	        message.setSubject("Test Message");
	        String test = "<h2> Hello!</h2><br>"
	                + "Your password is <b>" + recoveryPassword + "</b> <br/>"
	                + "Please log in using your username, and the password above."	+ "<br/>"
	                + "Thank you!<br/>";
	        message.setContent(test, "text/html");//Allows for HTML content to be sent.
	        return message;
	    } catch(Exception e) {
	        Logger.getLogger(JavaMailUtil.class.getName(), null).log(Level.SEVERE, null);
	    }
	    return null;
	}
//	@Bean
//	public JavaMailSender getJavaMailSender() {
//	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	    mailSender.setHost("smtp.gmail.com");
//	    mailSender.setPort(587);
//	    
////	    mailSender.setUsername("my.gmail@gmail.com");
////	    mailSender.setPassword("password");
//	     
//	    Properties props = mailSender.getJavaMailProperties();
//	    props.put("mail.transport.protocol", "smtp");
//	    props.put("mail.smtp.auth", "true");
//	    props.put("mail.smtp.starttls.enable", "true");
//	    props.put("mail.debug", "true");
//	     
//	    return mailSender;
//	}
}
