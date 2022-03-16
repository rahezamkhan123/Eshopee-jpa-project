package com.alzoharshopee.webservice.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void send(String toAddress, String fromAddress, String subject, String content) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setFrom(fromAddress);
		helper.setTo(toAddress);
		helper.setSubject(subject);
		helper.setText(content, true);
		helper.setSentDate(new Date());
		javaMailSender.send(mimeMessage);
	}
}
