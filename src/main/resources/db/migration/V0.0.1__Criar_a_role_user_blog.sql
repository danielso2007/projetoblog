-- Role: user_blog
-- DROP ROLE user_blog;

DO
$do$
BEGIN
   IF NOT EXISTS (
      SELECT FROM pg_catalog.pg_roles  -- SELECT list can be empty for this
      WHERE  rolname = 'user_blog') THEN

      CREATE ROLE user_blog WITH
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
