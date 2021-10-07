package br.com.rodison.mailservice.adapters.inbound;

import br.com.rodison.mailservice.application.services.EmailService;
import br.com.rodison.mailservice.db.jooq.generated.tables.records.RegisteredConsumerRecord;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.jooq.exception.DataAccessException;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@RegisterForReflection(targets={RegisteredConsumerRecord.class})
@Path("email")
public class EmailController {

	@Inject
	EmailService emailService;

	@POST
	@Path("/registerConsumer/{consumerName}")
	public Response registerConsumer(@PathParam("consumerName") String consumerName) {
		System.out.println("EmailController.registerConsumer - begin");
		long tempoInicio = System.currentTimeMillis();
		try {
			this.emailService.registerConsumer(consumerName);
			System.out.println("EmailController.registerConsumer - end. ms: " + (System.currentTimeMillis() - tempoInicio));
			return Response.status(Response.Status.CREATED.getStatusCode(), consumerName).build();
		} catch (Exception e) {
			System.out.println("EmailController.registerConsumer - error: " + e);
			e.printStackTrace();
			return Response.serverError().entity("Unknown error on registerConsumer. Error: " + e).build();
		}
	}

}
