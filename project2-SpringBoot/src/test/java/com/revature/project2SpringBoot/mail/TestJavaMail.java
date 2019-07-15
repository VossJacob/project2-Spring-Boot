package com.revature.project2SpringBoot.mail;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.project2SpringBoot.service.EmailService;
import com.revature.project2SpringBoot.util.JavaMailUtil;

public class TestJavaMail {

	@Autowired
	private static EmailService email;
	
	public static void main(String[] args) {
		//JavaMailUtil javaMail = new JavaMailUtil();
		try {
			JavaMailUtil.sendRecoveryEmail("CJPJavamail@gmail.com", "random Password");//Who this email will be sent to.
		}catch(Exception e) {
			System.out.println("Email could not be sent.");
		}
		//email.sendSimpleMessage("","Java Spring Mail Test","");
	}

}
