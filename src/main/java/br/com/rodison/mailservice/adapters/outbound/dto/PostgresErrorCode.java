package br.com.rodison.mailservice.adapters.outbound.dto;

import java.util.Arrays;
import java.util.Optional;

public enum PostgresErrorCode {
	REGISTER_ALREADY_EXISTS("23505", "Register to be saved already exists.");

	private String code;
	private String message;

	PostgresErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String code() {
		return code;
	}

	public String message() {
		return message;
	}

	public static Optional<PostgresErrorCode> byCode(String codeParam) {
		return Arrays.stream(PostgresErrorCode.values())
				.filter(element -> element.code().equals(codeParam))
				.findAny();
	}

}
