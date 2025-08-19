-- Diseñar las tablas para un sistema que permita llevar registro
-- de un campeonato de futbol tipo MUNDIAL. Con equipos, grupos,
-- partidos, resultados, fases.

BEGIN;


CREATE TABLE IF NOT EXISTS public."Equipo"
(
    id serial NOT NULL,
    "id_Grupo" integer NOT NULL,
    "id_Fase" integer NOT NULL,
    "Nombre" text NOT NULL,
    "Pais" text NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public."Grupo"
(
    id serial NOT NULL,
    "NombreGrupo" text NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public."Fase"
(
    id serial NOT NULL,
    "Titulo" text NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public."Partido"
(
    id serial NOT NULL,
    "id_EquipoA" integer NOT NULL,
    "id_EquipoB" integer NOT NULL,
    "Fecha" date NOT NULL,
    "Estadio" text NOT NULL,
    "GolesA" integer NOT NULL,
    "GolesB" integer NOT NULL,
    "id_Resultado" integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public."Resultado"
(
    id serial NOT NULL,
    "Finalizado" boolean NOT NULL,
    "Resultado" text NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public."Equipo"
    ADD FOREIGN KEY ("id_Grupo")
    REFERENCES public."Grupo" (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Equipo"
    ADD FOREIGN KEY ("id_Fase")
    REFERENCES public."Fase" (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Partido"
    ADD FOREIGN KEY ("id_EquipoA")
    REFERENCES public."Equipo" (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Partido"
    ADD FOREIGN KEY ("id_EquipoB")
    REFERENCES public."Equipo" (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Partido"
    ADD FOREIGN KEY ("id_Resultado")
    REFERENCES public."Resultado" (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

END;