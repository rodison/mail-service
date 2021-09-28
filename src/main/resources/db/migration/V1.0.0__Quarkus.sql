CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE registered_consumer
(
	id UUID NOT NULL PRIMARY KEY,
	consumer_name VARCHAR NOT NULL,
	date_create TIMESTAMP NOT NULL,
	date_update TIMESTAMP NOT NULL
);

CREATE UNIQUE INDEX registered_consumer_uk ON registered_consumer(consumer_name);

CREATE INDEX registered_consumer_dt_update_ix ON registered_consumer(date_update);



CREATE TABLE mail_log
(
	id UUID NOT NULL PRIMARY KEY,
	id_registered_consumer UUID NOT NULL,
	from_mail VARCHAR NOT NULL,
	subject TEXT NULL,
	body TEXT NULL,
	date_create TIMESTAMP NOT NULL,
	date_update TIMESTAMP NOT NULL
);

ALTER TABLE mail_log 
	ADD CONSTRAINT mail_log_reg_consumer_fk 
	FOREIGN KEY (id_registered_consumer)
	REFERENCES registered_consumer(id)
	ON DELETE CASCADE;

CREATE INDEX mail_log_dt_update_ix ON mail_log(date_update);



CREATE TABLE mail_to
(
	id UUID NOT NULL PRIMARY KEY,
	id_mail_log UUID,
	to_mail VARCHAR NOT NULL,
	date_create TIMESTAMP NOT NULL,
	date_update TIMESTAMP NOT NULL
);

ALTER TABLE mail_to 
	ADD CONSTRAINT mail_to_mail_log_fk 
	FOREIGN KEY (id_mail_log)
	REFERENCES mail_log(id)
	ON DELETE CASCADE;

CREATE INDEX mail_to_dt_update_ix ON mail_to(date_update);



CREATE TABLE mail_cc
(
	id UUID NOT NULL PRIMARY KEY,
	id_mail_log UUID,
	to_mail VARCHAR NOT NULL,
	date_create TIMESTAMP NOT NULL,
	date_update TIMESTAMP NOT NULL
);

ALTER TABLE mail_cc
	ADD CONSTRAINT mail_cc_mail_log_fk 
	FOREIGN KEY (id_mail_log)
	REFERENCES mail_log(id)
	ON DELETE CASCADE;

CREATE INDEX mail_cc_dt_update_ix ON mail_cc(date_update);



CREATE TABLE mail_cco
(
	id UUID NOT NULL PRIMARY KEY,
	id_mail_log UUID,
	to_mail VARCHAR NOT NULL,
	date_create TIMESTAMP NOT NULL,
	date_update TIMESTAMP NOT NULL
);

ALTER TABLE mail_cco
	ADD CONSTRAINT mail_cco_mail_log_fk 
	FOREIGN KEY (id_mail_log)
	REFERENCES mail_log(id)
	ON DELETE CASCADE;

CREATE INDEX mail_cco_dt_update_ix ON mail_cco(date_update);



CREATE TABLE mail_attachment
(
	id UUID NOT NULL PRIMARY KEY,
	id_mail_log UUID,
	attachment bytea NOT NULL,
	date_create TIMESTAMP NOT NULL,
	date_update TIMESTAMP NOT NULL
);

ALTER TABLE mail_attachment
	ADD CONSTRAINT mail_attachment_mail_log_fk 
	FOREIGN KEY (id_mail_log)
	REFERENCES mail_log(id)
	ON DELETE CASCADE;

CREATE INDEX mail_attachment_dt_update_ix ON mail_attachment(date_update);
