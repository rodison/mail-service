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

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index FLYWAY_SCHEMA_HISTORY_S_IDX = Internal.createIndex(DSL.name("flyway_schema_history_s_idx"), FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, new OrderField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.SUCCESS }, false);
    public static final Index MAIL_ATTACHMENT_DT_UPDATE_IX = Internal.createIndex(DSL.name("mail_attachment_dt_update_ix"), MailAttachment.MAIL_ATTACHMENT, new OrderField[] { MailAttachment.MAIL_ATTACHMENT.DATE_UPDATE }, false);
    public static final Index MAIL_CC_DT_UPDATE_IX = Internal.createIndex(DSL.name("mail_cc_dt_update_ix"), MailCc.MAIL_CC, new OrderField[] { MailCc.MAIL_CC.DATE_UPDATE }, false);
    public static final Index MAIL_CCO_DT_UPDATE_IX = Internal.createIndex(DSL.name("mail_cco_dt_update_ix"), MailCco.MAIL_CCO, new OrderField[] { MailCco.MAIL_CCO.DATE_UPDATE }, false);
    public static final Index MAIL_LOG_DT_UPDATE_IX = Internal.createIndex(DSL.name("mail_log_dt_update_ix"), MailLog.MAIL_LOG, new OrderField[] { MailLog.MAIL_LOG.DATE_UPDATE }, false);
    public static final Index MAIL_TO_DT_UPDATE_IX = Internal.createIndex(DSL.name("mail_to_dt_update_ix"), MailTo.MAIL_TO, new OrderField[] { MailTo.MAIL_TO.DATE_UPDATE }, false);
    public static final Index REGISTERED_CONSUMER_DT_UPDATE_IX = Internal.createIndex(DSL.name("registered_consumer_dt_update_ix"), RegisteredConsumer.REGISTERED_CONSUMER, new OrderField[] { RegisteredConsumer.REGISTERED_CONSUMER.DATE_UPDATE }, false);
    public static final Index REGISTERED_CONSUMER_UK = Internal.createIndex(DSL.name("registered_consumer_uk"), RegisteredConsumer.REGISTERED_CONSUMER, new OrderField[] { RegisteredConsumer.REGISTERED_CONSUMER.CONSUMER_NAME }, true);
}
