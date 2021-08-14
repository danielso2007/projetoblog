-- Table: public.foto
-- DROP TABLE public.foto;

CREATE TABLE IF NOT EXISTS public.foto
(
    id bigint NOT NULL DEFAULT nextval('foto_id_seq'::regclass),
    arquivo character varying(200) COLLATE pg_catalog."default" NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    path character varying(600) COLLATE pg_catalog."default" NOT NULL,
    id_album bigint NOT NULL,
    CONSTRAINT foto_pkey PRIMARY KEY (id),
    CONSTRAINT foto_album_id_fk FOREIGN KEY (id_album)
        REFERENCES public.album (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.foto
    OWNER to blog;

-- Index: indexfotoalbumid
-- DROP INDEX public.indexfotoalbumid;

CREATE INDEX indexfotoalbumid
    ON public.foto USING btree
    (id_album ASC NULLS LAST)
    TABLESPACE pg_default;