package com.alzoharshopee.webservice.services;

import javax.mail.MessagingException;

public interface MailService {

	public void send(String toAdrdress, String fromAddress, String subject, String content) throws MessagingException;
}
