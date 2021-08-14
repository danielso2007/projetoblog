-- Table: public.link
-- DROP TABLE public.link;

CREATE TABLE IF NOT EXISTS public.link
(
    id bigint NOT NULL DEFAULT nextval('link_id_seq'::regclass),
    data_atualizacao timestamp without time zone NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    titulo character varying(200) COLLATE pg_catalog."default",
    url character varying(600) COLLATE pg_catalog."default" NOT NULL,
    id_post bigint NOT NULL,
    CONSTRAINT link_pkey PRIMARY KEY (id),
    CONSTRAINT link_post_id_fk FOREIGN KEY (id_post)
        REFERENCES public.post (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.link
    OWNER to blog;

-- Index: indexlinkpostid
-- DROP INDEX public.indexlinkpostid;

CREATE INDEX indexlinkpostid
    ON public.link USING btree
    (id_post ASC NULLS LAST)
    TABLESPACE pg_default;