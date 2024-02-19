-- Table: newsletter.User

-- DROP TABLE IF EXISTS newsletter."User";

CREATE TABLE IF NOT EXISTS newsletter."User"
(
    user_id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    subscribed boolean NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    surname character varying COLLATE pg_catalog."default",
    CONSTRAINT user_pkey PRIMARY KEY (user_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS newsletter."User"
    OWNER to "user";