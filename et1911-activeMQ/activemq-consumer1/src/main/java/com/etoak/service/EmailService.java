package com.etoak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.etoak.bean.Email;

@Service
public class EmailService {
	@Autowired
	SimpleMailMessage mailMessage;
	@Autowired
	JavaMailSenderImpl mailSender;
	@Autowired
	ThreadPoolTaskExecutor executor;
	
	
	public void sendEmail(Email email) {
		//使用SimpleMailMessage封装邮件
		mailMessage.setTo(email.getReceiver());
		mailMessage.setSubject(email.getSubject());
		mailMessage.setText(email.getContent());
		mailMessage.setCc("17854208596@163.com");
		executor.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("开始下发邮件");
				mailSender.send(mailMessage);
				System.out.println("发送完成");
			}
		});
	}
}
