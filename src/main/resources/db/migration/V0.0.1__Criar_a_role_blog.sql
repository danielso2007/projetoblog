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
