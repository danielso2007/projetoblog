-- Table: public.album
-- DROP TABLE public.album;

CREATE TABLE IF NOT EXISTS public.album
(
    id bigint NOT NULL DEFAULT nextval('album_id_seq'::regclass),
    data_atualizacao timestamp without time zone NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    descricao character varying(600) COLLATE pg_catalog."default",
    titulo character varying(200) COLLATE pg_catalog."default" NOT NULL,
    id_usuario bigint NOT NULL,
    CONSTRAINT album_pkey PRIMARY KEY (id),
    CONSTRAINT album_usuario_id_fk FOREIGN KEY (id_usuario)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.album
    OWNER to blog;

-- Index: indexalbumusuarioid
-- DROP INDEX public.indexalbumusuarioid;

CREATE INDEX indexalbumusuarioid
    ON public.album USING btree
    (id_usuario ASC NULLS LAST)
    TABLESPACE pg_default;