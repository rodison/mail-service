package br.com.rodison.mailservice.adapters.inbound.dto;

import java.util.Objects;
import java.util.UUID;

public class EmailDTO {

	private UUID id;
	private UUID idRegisteredConsumer;
	private String fromMail;
	private String subject;
	private String body;

	public EmailDTO() {
	}

	public EmailDTO(UUID id, UUID idRegisteredConsumer, String fromMail, String subject, String body) {
		this.id = id;
		this.idRegisteredConsumer = idRegisteredConsumer;
		this.fromMail = fromMail;
		this.subject = subject;
		this.body = body;
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getIdRegisteredConsumer() {
		return this.idRegisteredConsumer;
	}

	public void setIdRegisteredConsumer(UUID idRegisteredConsumer) {
		this.idRegisteredConsumer = idRegisteredConsumer;
	}

	public String getFromMail() {
		return this.fromMail;
	}

	public void setFromMail(String fromMail) {
		this.fromMail = fromMail;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public EmailDTO id(UUID id) {
		setId(id);
		return this;
	}

	public EmailDTO idRegisteredConsumer(UUID idRegisteredConsumer) {
		setIdRegisteredConsumer(idRegisteredConsumer);
		return this;
	}

	public EmailDTO fromMail(String fromMail) {
		setFromMail(fromMail);
		return this;
	}

	public EmailDTO subject(String subject) {
		setSubject(subject);
		return this;
	}

	public EmailDTO body(String body) {
		setBody(body);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof EmailDTO)) {
			return false;
		}
		EmailDTO emailDTO = (EmailDTO) o;
		return Objects.equals(id, emailDTO.id) && Objects.equals(idRegisteredConsumer, emailDTO.idRegisteredConsumer)
				&& Objects.equals(fromMail, emailDTO.fromMail) && Objects.equals(subject, emailDTO.subject)
				&& Objects.equals(body, emailDTO.body);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, idRegisteredConsumer, fromMail, subject, body);
	}

	@Override
	public String toString() {
		return "{" + " id='" + getId() + "'" + ", idRegisteredConsumer='" + getIdRegisteredConsumer() + "'"
				+ ", fromMail='" + getFromMail() + "'" + ", subject='" + getSubject() + "'" + ", body='" + getBody()
				+ "'" + "}";
	}

	public String toSimpleString() {
		return "{" + " id='" + getId() + "'" + ", idRegisteredConsumer='" + getIdRegisteredConsumer() + "'"
				+ ", fromMail='" + getFromMail() + "'" + ", subject='" + getSubject() + "'" + "}";
	}

}
