package br.com.rodison.mailservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.rodison.mailservice.db.jooq.generated.tables.MailAttachment;
import br.com.rodison.mailservice.db.jooq.generated.tables.MailCc;

@Path("/hello")
public class GreetingResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		new MailCc();
		new MailAttachment();
		return "Hello RESTEasy";
	}
}