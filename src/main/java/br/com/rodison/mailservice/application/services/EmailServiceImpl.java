package br.com.rodison.mailservice.application.services;

import br.com.rodison.mailservice.adapters.inbound.dto.EmailDTO;
import br.com.rodison.mailservice.adapters.outbound.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import javax.enterprise.inject.Model;
// import javax.inject.Inject;

//@Model
@Service
public class EmailServiceImpl implements EmailService {

	// @Inject
	@Autowired
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

	@Override
	public void sendEmail(EmailDTO email) {
		try {
			this.emailRepository.sendEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
