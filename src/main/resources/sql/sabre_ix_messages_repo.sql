
CREATE SEQUENCE IF NOT EXISTS sabre_ix_messages_repo_id_seq;

CREATE TABLE  IF NOT EXISTS SABRE_IX_MESSAGES_REPO(
            id bigint NOT NULL DEFAULT nextval('sabre_ix_messages_repo_id_seq'),
            message TEXT,
            type VARCHAR NOT NULL,
            status VARCHAR,  
            validationStatus VARCHAR,
            validationError VARCHAR, 
            comments VARCHAR, 
            updated timestamp without time zone DEFAULT now(),
            created timestamp without time zone DEFAULT now()
)PARTITION BY LIST(type);

CREATE TABLE SABRE_IX_MESSAGES_REPO_PASSENGERS_LIST PARTITION OF SABRE_IX_MESSAGES_REPO FOR VALUES IN ('PASSENGERS_LIST');
CREATE TABLE SABRE_IX_MESSAGES_REPO_VOICE_COMM_NOTIFICATION PARTITION OF SABRE_IX_MESSAGES_REPO FOR VALUES IN ('VOICE_COMM_NOTIFICATION');
CREATE TABLE SABRE_IX_MESSAGES_REPO_OTHER_TYPES PARTITION OF SABRE_IX_MESSAGES_REPO  DEFAULT;

ALTER SEQUENCE sabre_ix_messages_repo_id_seq OWNED BY SABRE_IX_MESSAGES_REPO.id;


CREATE INDEX IF NOT EXISTS  sabre_ix_messages_repo_validationStatus_idx
    ON SABRE_IX_MESSAGES_REPO USING btree
    (validationStatus)
    TABLESPACE pg_default;

CREATE INDEX IF NOT EXISTS  sabre_ix_messages_repo_status_idx
    ON SABRE_IX_MESSAGES_REPO USING btree
    (status)
    TABLESPACE pg_default;

CREATE INDEX IF NOT EXISTS  sabre_ix_messages_repo_messages_type_idx
    ON SABRE_IX_MESSAGES_REPO USING btree
    (type)
    TABLESPACE pg_default;

CREATE INDEX IF NOT EXISTS  sabre_ix_messages_repo_created_idx
    ON SABRE_IX_MESSAGES_REPO USING btree
    (created)
    TABLESPACE pg_default;	
	
 