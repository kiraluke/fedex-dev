CREATE TABLE images(
    id                 BIGSERIAL NOT NULL,
    user_id            BIGINT NOT NULL,
    upload_time        VARCHAR(150),
    s3key              VARCHAR(150),
    file_name          VARCHAR(150)
);
ALTER TABLE images ADD CONSTRAINT images_pk PRIMARY KEY ( id );

ALTER TABLE images
    ADD CONSTRAINT images_user_fk FOREIGN KEY ( user_id )
        REFERENCES users ( id );