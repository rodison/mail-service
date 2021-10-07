package br.com.rodison.mailservice.application.services;

import javax.inject.Named;

public interface EmailService {
	void registerConsumer(String consumerName);
}
