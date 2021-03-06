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
import br.com.rodison.mailservice.db.jooq.generated.tables.records.FlywaySchemaHistoryRecord;
import br.com.rodison.mailservice.db.jooq.generated.tables.records.MailAttachmentRecord;
import br.com.rodison.mailservice.db.jooq.generated.tables.records.MailCcRecord;
import br.com.rodison.mailservice.db.jooq.generated.tables.records.MailCcoRecord;
import br.com.rodison.mailservice.db.jooq.generated.tables.records.MailLogRecord;
import br.com.rodison.mailservice.db.jooq.generated.tables.records.MailToRecord;
import br.com.rodison.mailservice.db.jooq.generated.tables.records.RegisteredConsumerRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, DSL.name("flyway_schema_history_pk"), new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
    public static final UniqueKey<MailAttachmentRecord> MAIL_ATTACHMENT_PKEY = Internal.createUniqueKey(MailAttachment.MAIL_ATTACHMENT, DSL.name("mail_attachment_pkey"), new TableField[] { MailAttachment.MAIL_ATTACHMENT.ID }, true);
    public static final UniqueKey<MailCcRecord> MAIL_CC_PKEY = Internal.createUniqueKey(MailCc.MAIL_CC, DSL.name("mail_cc_pkey"), new TableField[] { MailCc.MAIL_CC.ID }, true);
    public static final UniqueKey<MailCcoRecord> MAIL_CCO_PKEY = Internal.createUniqueKey(MailCco.MAIL_CCO, DSL.name("mail_cco_pkey"), new TableField[] { MailCco.MAIL_CCO.ID }, true);
    public static final UniqueKey<MailLogRecord> MAIL_LOG_PKEY = Internal.createUniqueKey(MailLog.MAIL_LOG, DSL.name("mail_log_pkey"), new TableField[] { MailLog.MAIL_LOG.ID }, true);
    public static final UniqueKey<MailToRecord> MAIL_TO_PKEY = Internal.createUniqueKey(MailTo.MAIL_TO, DSL.name("mail_to_pkey"), new TableField[] { MailTo.MAIL_TO.ID }, true);
    public static final UniqueKey<RegisteredConsumerRecord> REGISTERED_CONSUMER_PKEY = Internal.createUniqueKey(RegisteredConsumer.REGISTERED_CONSUMER, DSL.name("registered_consumer_pkey"), new TableField[] { RegisteredConsumer.REGISTERED_CONSUMER.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<MailAttachmentRecord, MailLogRecord> MAIL_ATTACHMENT__MAIL_ATTACHMENT_MAIL_LOG_FK = Internal.createForeignKey(MailAttachment.MAIL_ATTACHMENT, DSL.name("mail_attachment_mail_log_fk"), new TableField[] { MailAttachment.MAIL_ATTACHMENT.ID_MAIL_LOG }, Keys.MAIL_LOG_PKEY, new TableField[] { MailLog.MAIL_LOG.ID }, true);
    public static final ForeignKey<MailCcRecord, MailLogRecord> MAIL_CC__MAIL_CC_MAIL_LOG_FK = Internal.createForeignKey(MailCc.MAIL_CC, DSL.name("mail_cc_mail_log_fk"), new TableField[] { MailCc.MAIL_CC.ID_MAIL_LOG }, Keys.MAIL_LOG_PKEY, new TableField[] { MailLog.MAIL_LOG.ID }, true);
    public static final ForeignKey<MailCcoRecord, MailLogRecord> MAIL_CCO__MAIL_CCO_MAIL_LOG_FK = Internal.createForeignKey(MailCco.MAIL_CCO, DSL.name("mail_cco_mail_log_fk"), new TableField[] { MailCco.MAIL_CCO.ID_MAIL_LOG }, Keys.MAIL_LOG_PKEY, new TableField[] { MailLog.MAIL_LOG.ID }, true);
    public static final ForeignKey<MailLogRecord, RegisteredConsumerRecord> MAIL_LOG__MAIL_LOG_REG_CONSUMER_FK = Internal.createForeignKey(MailLog.MAIL_LOG, DSL.name("mail_log_reg_consumer_fk"), new TableField[] { MailLog.MAIL_LOG.ID_REGISTERED_CONSUMER }, Keys.REGISTERED_CONSUMER_PKEY, new TableField[] { RegisteredConsumer.REGISTERED_CONSUMER.ID }, true);
    public static final ForeignKey<MailToRecord, MailLogRecord> MAIL_TO__MAIL_TO_MAIL_LOG_FK = Internal.createForeignKey(MailTo.MAIL_TO, DSL.name("mail_to_mail_log_fk"), new TableField[] { MailTo.MAIL_TO.ID_MAIL_LOG }, Keys.MAIL_LOG_PKEY, new TableField[] { MailLog.MAIL_LOG.ID }, true);
}
