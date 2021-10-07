package br.com.rodison.mailservice.application.services;

import br.com.rodison.mailservice.adapters.outbound.EmailRepository;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class EmailServiceImpl implements EmailService {

	@Inject
	EmailRepository emailRepository;

	@Override
	public void registerConsumer(String consumerName) {
		try {
			this.emailRepository.registerConsumer(consumerName);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
