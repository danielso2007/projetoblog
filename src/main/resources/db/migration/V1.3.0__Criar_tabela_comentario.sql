-- Table: public.comentario
-- DROP TABLE public.comentario;

CREATE TABLE IF NOT EXISTS public.comentario
(
    id bigint NOT NULL DEFAULT nextval('comentario_id_seq'::regclass),
    data_atualizacao timestamp without time zone NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    texto character varying(300) COLLATE pg_catalog."default" NOT NULL,
    id_post bigint NOT NULL,
    id_usuario bigint NOT NULL,
    CONSTRAINT comentario_pkey PRIMARY KEY (id),
    CONSTRAINT comentario_usuario_id_fk FOREIGN KEY (id_usuario)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT comentario_post_id_fk FOREIGN KEY (id_post)
        REFERENCES public.post (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.comentario
    OWNER to blog;

-- Index: indexcomentariopostid
-- DROP INDEX public.indexcomentariopostid;

CREATE INDEX indexcomentariopostid
    ON public.comentario USING btree
    (id_post ASC NULLS LAST)
    TABLESPACE pg_default;

-- Index: indexcomentariousuarioid
-- DROP INDEX public.indexcomentariousuarioid;

CREATE INDEX indexcomentariousuarioid
    ON public.comentario USING btree
    (id_usuario ASC NULLS LAST)
    TABLESPACE pg_default;