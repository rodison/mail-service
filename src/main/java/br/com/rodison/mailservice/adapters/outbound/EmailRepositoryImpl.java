package br.com.rodison.mailservice.adapters.outbound;

import br.com.rodison.mailservice.adapters.inbound.dto.EmailDTO;
import br.com.rodison.mailservice.adapters.outbound.dto.PostgresErrorCode;

import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.stereotype.Repository;

//import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static br.com.rodison.mailservice.db.jooq.generated.tables.MailLog.MAIL_LOG;
import static br.com.rodison.mailservice.db.jooq.generated.tables.RegisteredConsumer.REGISTERED_CONSUMER;

//@Model
@Repository
public class EmailRepositoryImpl implements EmailRepository {

	@Inject
	DSLContext dsl;

	@Override
	public void registerConsumer(String consumerName) {
		try {
			UUID uuid = UUID.randomUUID();
			LocalDateTime now = LocalDateTime.now();
			dsl.insertInto(REGISTERED_CONSUMER).set(REGISTERED_CONSUMER.ID, uuid)
					.set(REGISTERED_CONSUMER.CONSUMER_NAME, consumerName).set(REGISTERED_CONSUMER.DATE_CREATE, now)
					.set(REGISTERED_CONSUMER.DATE_UPDATE, now).execute();
		} catch (DataAccessException e) {
			Optional<PostgresErrorCode> postgresErrorCode = PostgresErrorCode.byCode(e.sqlState());
			postgresErrorCode.ifPresentOrElse((errorEnum) -> System.out.println(errorEnum.message()), () -> {
				e.printStackTrace();
				throw e;
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void sendEmail(EmailDTO email) {
		try {
			UUID uuid = UUID.randomUUID();
			LocalDateTime now = LocalDateTime.now();
			// @formatter:off
			dsl.insertInto(MAIL_LOG)
				.set(MAIL_LOG.ID, uuid)
				.set(MAIL_LOG.ID_REGISTERED_CONSUMER, email.getIdRegisteredConsumer())
				.set(MAIL_LOG.FROM_MAIL, email.getFromMail())
				.set(MAIL_LOG.SUBJECT, email.getSubject())
				.set(MAIL_LOG.BODY, email.getBody())
				.set(MAIL_LOG.DATE_CREATE, now)
				.set(MAIL_LOG.DATE_UPDATE, now)
				.execute();
			// @formatter:on
		} catch (DataAccessException e) {
			Optional<PostgresErrorCode> postgresErrorCode = PostgresErrorCode.byCode(e.sqlState());
			postgresErrorCode.ifPresentOrElse((errorEnum) -> System.out.println(errorEnum.message()), () -> {
				e.printStackTrace();
				throw e;
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
