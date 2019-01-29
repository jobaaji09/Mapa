--
-- PostgreSQL database dump
--

-- Dumped from database version 10.6 (Ubuntu 10.6-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.6 (Ubuntu 10.6-0ubuntu0.18.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: marcador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.marcador (
    idmarcador integer NOT NULL,
    longitud double precision,
    latitud double precision,
    usuarioid integer
);


ALTER TABLE public.marcador OWNER TO postgres;

--
-- Name: marcador_idmarcador_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.marcador_idmarcador_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.marcador_idmarcador_seq OWNER TO postgres;

--
-- Name: marcador_idmarcador_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.marcador_idmarcador_seq OWNED BY public.marcador.idmarcador;


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    nombre character varying,
    idusuario integer NOT NULL,
    foto character varying,
    correo character varying,
    fnacimiento date,
    contrasenia character varying
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- Name: usuario_idusuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_idusuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_idusuario_seq OWNER TO postgres;

--
-- Name: usuario_idusuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_idusuario_seq OWNED BY public.usuario.idusuario;


--
-- Name: marcador idmarcador; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marcador ALTER COLUMN idmarcador SET DEFAULT nextval('public.marcador_idmarcador_seq'::regclass);


--
-- Name: usuario idusuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN idusuario SET DEFAULT nextval('public.usuario_idusuario_seq'::regclass);


--
-- Data for Name: marcador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.marcador (idmarcador, longitud, latitud, usuarioid) FROM stdin;
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (nombre, idusuario, foto, correo, fnacimiento, contrasenia) FROM stdin;
jhon	5	imagenes/user.png	jhon@correocaliente.com	1995-03-16	qwerty
\.


--
-- Name: marcador_idmarcador_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.marcador_idmarcador_seq', 1, false);


--
-- Name: usuario_idusuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_idusuario_seq', 5, true);


--
-- Name: marcador marcador_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marcador
    ADD CONSTRAINT marcador_pkey PRIMARY KEY (idmarcador);


--
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (idusuario);


--
-- Name: marcador marcador_usuarioid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marcador
    ADD CONSTRAINT marcador_usuarioid_fkey FOREIGN KEY (usuarioid) REFERENCES public.usuario(idusuario);


--
-- PostgreSQL database dump complete
--

