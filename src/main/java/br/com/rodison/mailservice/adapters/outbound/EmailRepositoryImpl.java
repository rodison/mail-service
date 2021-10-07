package br.com.rodison.mailservice.adapters.outbound;

import br.com.rodison.mailservice.adapters.outbound.dto.PostgresErrorCode;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static br.com.rodison.mailservice.db.jooq.generated.tables.RegisteredConsumer.REGISTERED_CONSUMER;

@Model
public class EmailRepositoryImpl implements EmailRepository {

	@Inject
	DSLContext dsl;

	@Override
	public void registerConsumer(String consumerName) {
		try {
			UUID uuid = UUID.randomUUID();
			LocalDateTime now = LocalDateTime.now();
			dsl.insertInto(REGISTERED_CONSUMER)
					.set(REGISTERED_CONSUMER.ID, uuid)
					.set(REGISTERED_CONSUMER.CONSUMER_NAME, consumerName)
					.set(REGISTERED_CONSUMER.DATE_CREATE, now)
					.set(REGISTERED_CONSUMER.DATE_UPDATE, now)
					.execute();
		} catch (DataAccessException e) {
			Optional<PostgresErrorCode> postgresErrorCode = PostgresErrorCode.byCode(e.sqlState());
			postgresErrorCode.ifPresentOrElse((errorEnum) -> System.out.println(errorEnum.message()),
					() -> {
						e.printStackTrace();
						throw e;
					});
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
