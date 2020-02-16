-- DROP TABLE IF EXISTS pack CASCADE;
-- DROP TABLE IF EXISTS recipient CASCADE;
-- DROP TABLE IF EXISTS routing CASCADE;
-- DROP SEQUENCE IF EXISTS pack_id_seq;
-- DROP SEQUENCE IF EXISTS recipient_id_seq;
-- DROP SEQUENCE IF EXISTS routing_id_seq;
CREATE SEQUENCE recipient_id_seq START WITH 1;
CREATE SEQUENCE pack_id_seq START WITH 1;
CREATE SEQUENCE routing_id_seq START WITH 1;

CREATE TABLE recipient (
    /*id              INTEGER NOT NULL default nextval('recipient_id_seq'),*/
    id              BIGSERIAL NOT NULL,
    name            VARCHAR(150) not null unique,
    first_name      VARCHAR(30),
    last_name       VARCHAR(30),
    email           VARCHAR(50),
    address         VARCHAR(150)
);
ALTER TABLE recipient ADD CONSTRAINT recipient_pk PRIMARY KEY ( id );

CREATE TABLE routing (
    /*id                INTEGER NOT NULL default nextval('routing_id_seq'), */
    id                BIGSERIAL NOT NULL,
    pirority          VARCHAR(150),
    area              VARCHAR(150)
);
ALTER TABLE routing ADD CONSTRAINT routing_pk PRIMARY KEY ( id );

CREATE TABLE pack (
    /*trackingid                INTEGER NOT NULL default nextval('pack_id_seq'), */
--  id is primary key and add tracking_id as unique column
    id               BIGSERIAL NOT NULL,
    tracking_id      VARCHAR(100),
    category         VARCHAR(100),
    destination      VARCHAR(100),
    recipient_id     bigint,
    routing_id       bigint

);
ALTER TABLE pack ADD CONSTRAINT pack_pk PRIMARY KEY ( id );
ALTER TABLE pack
   ADD CONSTRAINT pack_recipient_fk FOREIGN KEY (recipient_id) REFERENCES recipient (id);
ALTER TABLE pack
   ADD CONSTRAINT pack_routing_fk FOREIGN KEY (routing_id) REFERENCES routing (id);