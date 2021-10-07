package br.com.rodison.mailservice;

import br.com.rodison.mailservice.db.jooq.generated.tables.records.RegisteredConsumerRecord;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

import static br.com.rodison.mailservice.db.jooq.generated.tables.RegisteredConsumer.REGISTERED_CONSUMER;

@RegisterForReflection(targets={RegisteredConsumerRecord.class})
@Path("/hello")
public class GreetingResource {

	@Inject
	DSLContext dsl;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		long tempoInicio = System.currentTimeMillis();
		System.out.println("GrettingResource.hello - begin");
		this.jooqer();
		System.out.println("GrettingResource.hello - end. ms: " + (System.currentTimeMillis() - tempoInicio));
		return "Hello RESTEasy";
	}

	private void jooqer() {
//		String userName = "mailservice";
//		String password = "mailservice";
//		String url = "jdbc:postgresql://localhost:5432/mailservice";

		// Connection is the only JDBC resource that we need
		// PreparedStatement and ResultSet are handled by jOOQ, internally
//		try (Connection conn = DriverManager.getConnection(url, userName, password)) {
		try {
//			DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
			Result<Record> result = dsl.select().from(REGISTERED_CONSUMER).fetch();
			System.out.println("pegou result");

			for (Record r : result) {
				UUID id = r.getValue(REGISTERED_CONSUMER.ID);
				String name = r.getValue(REGISTERED_CONSUMER.CONSUMER_NAME);
				System.out.println("ID: " + id + " name: " + name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}