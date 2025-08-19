
-- 1- Diseñar las tablas necesarias para hacer un BLOG.

BEGIN;


CREATE TABLE IF NOT EXISTS public."Usuario"
(
    id serial NOT NULL,
    "Nombre" text NOT NULL,
    "Correo" text NOT NULL,
    "Contrasena" text NOT NULL,
    "Activo" boolean NOT NULL,
    "FechaNacimiento" date NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public."Posteos"
(
    id serial NOT NULL,
    "id_Usuario" integer NOT NULL,
    "Titulo" text NOT NULL,
    "Contenido" text NOT NULL,
    "FechaPublicacion" date NOT NULL,
    "EstaPublicado" boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public."Comentario"
(
    id serial NOT NULL,
    "id_Posteo" integer NOT NULL,
    "id_Usuario" integer NOT NULL,
    "Contenido" text NOT NULL,
    "FechaCreacion" date NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public."Posteos"
    ADD FOREIGN KEY ("id_Usuario")
    REFERENCES public."Usuario" (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Posteos"
    ADD FOREIGN KEY ("id_Usuario")
    REFERENCES public."Usuario" (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Comentario"
    ADD FOREIGN KEY ("id_Usuario")
    REFERENCES public."Usuario" (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Comentario"
    ADD FOREIGN KEY ("id_Posteo")
    REFERENCES public."Posteos" (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

END;