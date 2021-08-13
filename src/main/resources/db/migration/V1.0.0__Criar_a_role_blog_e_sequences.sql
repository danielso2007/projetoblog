-- Role: blog
-- DROP ROLE blog;

DO
$do$
BEGIN
   IF NOT EXISTS (
      SELECT FROM pg_catalog.pg_roles  -- SELECT list can be empty for this
      WHERE  rolname = 'blog') THEN

      CREATE ROLE blog WITH
          LOGIN
          SUPERUSER
          INHERIT
          CREATEDB
          CREATEROLE
          REPLICATION
          ENCRYPTED PASSWORD 'md5a3097ef3b96741e897b5966dd5d9ca6c';
   END IF;
END
$do$;

-- SEQUENCE: public.album_id_seq
-- DROP SEQUENCE public.album_id_seq;

CREATE SEQUENCE public.album_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.album_id_seq
    OWNER TO blog;

-- SEQUENCE: public.comentario_id_seq
-- DROP SEQUENCE public.comentario_id_seq;

CREATE SEQUENCE public.comentario_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.comentario_id_seq
    OWNER TO blog;

-- SEQUENCE: public.foto_id_seq
-- DROP SEQUENCE public.foto_id_seq;

CREATE SEQUENCE public.foto_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.foto_id_seq
    OWNER TO blog;

-- SEQUENCE: public.imagem_id_seq
-- DROP SEQUENCE public.imagem_id_seq;

CREATE SEQUENCE public.imagem_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.imagem_id_seq
    OWNER TO blog;

-- SEQUENCE: public.link_id_seq
-- DROP SEQUENCE public.link_id_seq;

CREATE SEQUENCE public.link_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.link_id_seq
    OWNER TO blog;

-- SEQUENCE: public.perfil_id_seq
-- DROP SEQUENCE public.perfil_id_seq;

CREATE SEQUENCE public.perfil_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.perfil_id_seq
    OWNER TO blog;

-- SEQUENCE: public.post_id_seq
-- DROP SEQUENCE public.post_id_seq;

CREATE SEQUENCE public.post_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.post_id_seq
    OWNER TO blog;

-- SEQUENCE: public.usuario_id_seq
-- DROP SEQUENCE public.usuario_id_seq;

CREATE SEQUENCE public.usuario_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.usuario_id_seq
    OWNER TO blog;
