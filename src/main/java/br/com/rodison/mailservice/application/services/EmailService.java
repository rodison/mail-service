package br.com.rodison.mailservice.application.services;

import br.com.rodison.mailservice.adapters.inbound.dto.EmailDTO;

public interface EmailService {
	void registerConsumer(String consumerName);

	void sendEmail(EmailDTO email);
}
