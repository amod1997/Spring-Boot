package com.send.mail.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.send.mail.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	@Value("${spring.mail.username}")
	private String userName;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public String sendEmail(String userEmail) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(userName);
		simpleMailMessage.setTo(userEmail);
		simpleMailMessage.setSubject("Password Reset");
		String otp = createOtp();
		simpleMailMessage.setText(otp);
		javaMailSender.send(simpleMailMessage);
		return otp;
	}

	private String createOtp() {
		Random random = new Random();
		return String.format("%04d", random.nextInt(1000));
	}

}
