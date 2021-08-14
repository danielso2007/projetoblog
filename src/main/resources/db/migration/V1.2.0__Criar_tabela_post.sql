-- Table: public.post
-- DROP TABLE public.post;

CREATE TABLE IF NOT EXISTS public.post
(
    id bigint NOT NULL DEFAULT nextval('post_id_seq'::regclass),
    data_atualizacao timestamp without time zone NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    texto character varying(600) COLLATE pg_catalog."default" NOT NULL,
    id_usuario bigint NOT NULL,
    CONSTRAINT post_pkey PRIMARY KEY (id),
    CONSTRAINT post_usuario_id_fk FOREIGN KEY (id_usuario)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.post
    OWNER to blog;

-- Index: indexpostusuarioid
-- DROP INDEX public.indexpostusuarioid;

CREATE INDEX indexpostusuarioid
    ON public.post USING btree
    (id_usuario ASC NULLS LAST)
    TABLESPACE pg_default;