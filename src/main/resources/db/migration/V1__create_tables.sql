DROP TABLE IF EXISTS pack CASCADE;
DROP TABLE IF EXISTS recipient CASCADE;
DROP TABLE IF EXISTS routing CASCADE;
DROP SEQUENCE IF EXISTS pack_id_seq;
DROP SEQUENCE IF EXISTS recipient_id_seq;
DROP SEQUENCE IF EXISTS routing_id_seq;
CREATE SEQUENCE pack_id_seq START WITH 1;
CREATE SEQUENCE recipient_id_seq START WITH 1;
CREATE SEQUENCE routing_id_seq START WITH 1;

CREATE TABLE pack (
    /*trackingid                INTEGER NOT NULL default nextval('pack_id_seq'), */
    trackingid       BIGSERIAL NOT NULL,
    type              VARCHAR(100),
    destination       VARCHAR(100)
);
ALTER TABLE pack ADD CONSTRAINT pack_pk PRIMARY KEY ( trackingid );

CREATE TABLE recipient (
    /*id              INTEGER NOT NULL default nextval('recipient_id_seq'),*/
    id              BIGSERIAL NOT NULL,
    name            VARCHAR(150) not null unique,
    first_name      VARCHAR(30),
    last_name       VARCHAR(30),
    email           VARCHAR(50),
    address         VARCHAR(150),
    trackingid      bigint
);
ALTER TABLE recipient ADD CONSTRAINT recipient_pk PRIMARY KEY ( id );
ALTER TABLE recipient ADD CONSTRAINT recipient_fk FOREIGN KEY (trackingid) REFERENCES pack (trackingid);