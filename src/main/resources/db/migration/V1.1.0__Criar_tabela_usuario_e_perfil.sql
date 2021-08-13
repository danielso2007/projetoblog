-- Table: public.usuario
-- DROP TABLE public.usuario;

CREATE TABLE IF NOT EXISTS public.usuario
(
    id bigint NOT NULL DEFAULT nextval('usuario_id_seq'::regclass),
    data_atualizacao timestamp without time zone NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    email character varying(400) COLLATE pg_catalog."default" NOT NULL,
    enabled boolean NOT NULL,
    nome character varying(400) COLLATE pg_catalog."default" NOT NULL,
    senha character varying(100) COLLATE pg_catalog."default" NOT NULL,
    ultimo_acesso timestamp without time zone,
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT uniqueusurioemail UNIQUE (email)
)

TABLESPACE pg_default;

ALTER TABLE public.usuario
    OWNER to blog;
-- Index: indexusuarioemail
-- DROP INDEX public.indexusuarioemail;

CREATE INDEX indexusuarioemail
    ON public.usuario USING btree
    (email COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;

-- Table: public.perfil
-- DROP TABLE public.perfil;

CREATE TABLE IF NOT EXISTS public.perfil
(
    id bigint NOT NULL DEFAULT nextval('perfil_id_seq'::regclass),
    nome character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT perfil_pkey PRIMARY KEY (id),
    CONSTRAINT uniqueperfilnome UNIQUE (nome)
)

TABLESPACE pg_default;

ALTER TABLE public.perfil
    OWNER to blog;

-- Index: indexperfilnome
-- DROP INDEX public.indexperfilnome;

CREATE INDEX indexperfilnome
    ON public.perfil USING btree
    (nome COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;

-- Table: public.usuario_perfis
-- DROP TABLE public.usuario_perfis;

CREATE TABLE IF NOT EXISTS public.usuario_perfis
(
    usuario_id bigint NOT NULL,
    perfis_id bigint NOT NULL,
    CONSTRAINT usuario_perfil_perfis_fk FOREIGN KEY (perfis_id)
        REFERENCES public.perfil (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT usuario_perfil_usuarios_fk FOREIGN KEY (usuario_id)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.usuario_perfis
    OWNER to blog;