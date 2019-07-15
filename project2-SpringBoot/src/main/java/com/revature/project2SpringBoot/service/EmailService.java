package com.revature.project2SpringBoot.service;

public interface EmailService {
	
	public void sendSimpleMessage(String to, String subject, String text);
	
}
