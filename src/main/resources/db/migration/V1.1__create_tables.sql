CREATE TABLE routing (
    /*id                INTEGER NOT NULL default nextval('routing_id_seq'), */
    id                BIGSERIAL NOT NULL,
    category          VARCHAR(50),
    pirority          VARCHAR(150),
    area              VARCHAR(150),
    trackingid       bigint
);
ALTER TABLE routing ADD CONSTRAINT routing_pk PRIMARY KEY ( id );
ALTER TABLE routing ADD CONSTRAINT routing_fk FOREIGN KEY (trackingid) REFERENCES pack (trackingid);;