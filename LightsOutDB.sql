--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: problem; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.problem (
    id integer NOT NULL,
    dimension integer NOT NULL,
    description integer[] NOT NULL
);


ALTER TABLE public.problem OWNER TO postgres;

--
-- Name: problem_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.problem ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.problem_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: solution; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.solution (
    id integer NOT NULL,
    problem_id integer NOT NULL,
    steps_nr integer
);


ALTER TABLE public.solution OWNER TO postgres;

--
-- Name: solution_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.solution ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.solution_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: solution_step; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.solution_step (
    id integer NOT NULL,
    solution_id integer,
    step integer[],
    step_ix integer NOT NULL
);


ALTER TABLE public.solution_step OWNER TO postgres;

--
-- Name: solution_step_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.solution_step ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.solution_step_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: problem; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.problem (id, dimension, description) FROM stdin;
1	3	{1,1,0,1,0,0,0,0,0}
2	4	{0,0,1,0,0,1,1,1,0,0,1,0,0,0,0,0}
\.


--
-- Data for Name: solution; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.solution (id, problem_id, steps_nr) FROM stdin;
1	1	1
2	2	1
\.


--
-- Data for Name: solution_step; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.solution_step (id, solution_id, step, step_ix) FROM stdin;
1	1	{1,0,0,0,0,0,0,0,0}	1
2	2	{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0}	1
\.


--
-- Name: problem_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.problem_id_seq', 2, true);


--
-- Name: solution_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.solution_id_seq', 2, true);


--
-- Name: solution_step_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.solution_step_id_seq', 2, true);


--
-- Name: problem problem_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.problem
    ADD CONSTRAINT problem_pkey PRIMARY KEY (id);


--
-- Name: solution solution_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solution
    ADD CONSTRAINT solution_pkey PRIMARY KEY (id);


--
-- Name: solution_step solution_step_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solution_step
    ADD CONSTRAINT solution_step_pkey PRIMARY KEY (id);


--
-- Name: solution problem_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solution
    ADD CONSTRAINT problem_id_fkey FOREIGN KEY (problem_id) REFERENCES public.problem(id) ON DELETE RESTRICT;


--
-- Name: solution_step solution_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solution_step
    ADD CONSTRAINT solution_id_fkey FOREIGN KEY (solution_id) REFERENCES public.solution(id) ON DELETE RESTRICT;


--
-- PostgreSQL database dump complete
--

