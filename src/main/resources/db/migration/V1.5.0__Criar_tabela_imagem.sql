-- Table: public.imagem
-- DROP TABLE public.imagem;

CREATE TABLE IF NOT EXISTS public.imagem
(
    id bigint NOT NULL DEFAULT nextval('imagem_id_seq'::regclass),
    arquivo character varying(200) COLLATE pg_catalog."default" NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    path character varying(600) COLLATE pg_catalog."default" NOT NULL,
    titulo character varying(200) COLLATE pg_catalog."default",
    id_post bigint NOT NULL,
    CONSTRAINT imagem_pkey PRIMARY KEY (id),
    CONSTRAINT imagem_post_id_fk FOREIGN KEY (id_post)
        REFERENCES public.post (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.imagem
    OWNER to blog;

-- Index: indeximagempostid
-- DROP INDEX public.indeximagempostid;

CREATE INDEX indeximagempostid
    ON public.imagem USING btree
    (id_post ASC NULLS LAST)
    TABLESPACE pg_default;