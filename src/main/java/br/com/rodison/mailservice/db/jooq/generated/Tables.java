/*
 * This file is generated by jOOQ.
 */
package br.com.rodison.mailservice.db.jooq.generated;


import br.com.rodison.mailservice.db.jooq.generated.tables.FlywaySchemaHistory;
import br.com.rodison.mailservice.db.jooq.generated.tables.MailAttachment;
import br.com.rodison.mailservice.db.jooq.generated.tables.MailCc;
import br.com.rodison.mailservice.db.jooq.generated.tables.MailCco;
import br.com.rodison.mailservice.db.jooq.generated.tables.MailLog;
import br.com.rodison.mailservice.db.jooq.generated.tables.MailTo;
import br.com.rodison.mailservice.db.jooq.generated.tables.RegisteredConsumer;


/**
 * Convenience access to all tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.flyway_schema_history</code>.
     */
    public static final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * The table <code>public.mail_attachment</code>.
     */
    public static final MailAttachment MAIL_ATTACHMENT = MailAttachment.MAIL_ATTACHMENT;

    /**
     * The table <code>public.mail_cc</code>.
     */
    public static final MailCc MAIL_CC = MailCc.MAIL_CC;

    /**
     * The table <code>public.mail_cco</code>.
     */
    public static final MailCco MAIL_CCO = MailCco.MAIL_CCO;

    /**
     * The table <code>public.mail_log</code>.
     */
    public static final MailLog MAIL_LOG = MailLog.MAIL_LOG;

    /**
     * The table <code>public.mail_to</code>.
     */
    public static final MailTo MAIL_TO = MailTo.MAIL_TO;

    /**
     * The table <code>public.registered_consumer</code>.
     */
    public static final RegisteredConsumer REGISTERED_CONSUMER = RegisteredConsumer.REGISTERED_CONSUMER;
}
