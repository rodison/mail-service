package br.com.rodison.mailservice.adapters.outbound;

import br.com.rodison.mailservice.adapters.inbound.dto.EmailDTO;

public interface EmailRepository {
	void registerConsumer(String consumerName);

	void sendEmail(EmailDTO email);
}
