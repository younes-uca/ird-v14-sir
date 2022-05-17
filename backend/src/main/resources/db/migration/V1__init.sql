--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

-- Started on 2022-05-12 14:49:36

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
-- TOC entry 209 (class 1259 OID 90793)
-- Name: affectation_structurelle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.affectation_structurelle (
                                                 id bigint NOT NULL,
                                                 code character varying(500),
                                                 libelle_court character varying(500),
                                                 libelle_long character varying(500)
);


ALTER TABLE public.affectation_structurelle OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 90798)
-- Name: affectation_structurelle_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.affectation_structurelle_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.affectation_structurelle_seq OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 90799)
-- Name: bourse; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bourse (
                               id bigint NOT NULL,
                               date_obtention date,
                               duree_en_mois integer,
                               intitule character varying(255),
                               montant numeric(19,2),
                               participation_individuelle boolean,
                               campagne_id bigint,
                               chercheur_id bigint,
                               projet_activite_recherche_id bigint
);


ALTER TABLE public.bourse OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 90802)
-- Name: campagne; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.campagne (
                                 id bigint NOT NULL,
                                 annee bigint,
                                 code character varying(500),
                                 date_depart date,
                                 date_fin date,
                                 libelle character varying(500),
                                 message_cloture text,
                                 message_ouverture text,
                                 objet_cloture character varying(500),
                                 objet_ouverture character varying(500),
                                 etat_campagne_id bigint,
                                 template_cloture_id bigint,
                                 template_ouverture_id bigint
);


ALTER TABLE public.campagne OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 90807)
-- Name: campagne_chercheur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.campagne_chercheur (
                                           id bigint NOT NULL,
                                           avancement numeric(19,2),
                                           message_fermeture character varying(255),
                                           message_ouverture character varying(255),
                                           objet_fermeture character varying(255),
                                           objet_ouverture character varying(255),
                                           campagne_id bigint,
                                           chercheur_id bigint,
                                           etat_campagne_chercheur_id bigint
);


ALTER TABLE public.campagne_chercheur OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 90812)
-- Name: campagne_chercheur_fermeture; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.campagne_chercheur_fermeture (
                                                     id bigint NOT NULL,
                                                     date_envoi date,
                                                     envoye boolean DEFAULT false,
                                                     message text,
                                                     objet character varying(500),
                                                     campagne_id bigint,
                                                     chercheur_id bigint
);


ALTER TABLE public.campagne_chercheur_fermeture OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 90818)
-- Name: campagne_chercheur_fermeture_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.campagne_chercheur_fermeture_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.campagne_chercheur_fermeture_seq OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 90819)
-- Name: campagne_chercheur_ouverture; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.campagne_chercheur_ouverture (
                                                     id bigint NOT NULL,
                                                     avancement numeric(19,2),
                                                     date_envoi date,
                                                     envoye boolean DEFAULT false,
                                                     message text,
                                                     objet character varying(500),
                                                     campagne_id bigint,
                                                     chercheur_id bigint,
                                                     etat_campagne_chercheur_id bigint
);


ALTER TABLE public.campagne_chercheur_ouverture OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 90825)
-- Name: campagne_chercheur_ouverture_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.campagne_chercheur_ouverture_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.campagne_chercheur_ouverture_seq OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 90826)
-- Name: campagne_rappel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.campagne_rappel (
                                        id bigint NOT NULL,
                                        date_rappel date,
                                        message_rappel text,
                                        objet_rappel character varying(500),
                                        campagne_id bigint,
                                        template_rappel_id bigint
);


ALTER TABLE public.campagne_rappel OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 90831)
-- Name: campagne_rappel_chercheur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.campagne_rappel_chercheur (
                                                  id bigint NOT NULL,
                                                  date_envoi date,
                                                  envoye boolean DEFAULT false,
                                                  message text,
                                                  objet character varying(500),
                                                  campagne_rappel_id bigint,
                                                  chercheur_id bigint
);


ALTER TABLE public.campagne_rappel_chercheur OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 90837)
-- Name: campagne_rappel_chercheur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.campagne_rappel_chercheur_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.campagne_rappel_chercheur_seq OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 90838)
-- Name: campagne_rappel_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.campagne_rappel_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.campagne_rappel_seq OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 90839)
-- Name: campagne_relance; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.campagne_relance (
                                         id bigint NOT NULL,
                                         date_relance date,
                                         message_relance text,
                                         objet_relance character varying(500),
                                         campagne_id bigint,
                                         template_relance_id bigint
);


ALTER TABLE public.campagne_relance OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 90844)
-- Name: campagne_relance_chercheur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.campagne_relance_chercheur (
                                                   id bigint NOT NULL,
                                                   date_envoi date,
                                                   envoye boolean DEFAULT false,
                                                   message text,
                                                   objet character varying(500),
                                                   campagne_relance_id bigint,
                                                   chercheur_id bigint
);


ALTER TABLE public.campagne_relance_chercheur OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 90850)
-- Name: campagne_relance_chercheur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.campagne_relance_chercheur_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.campagne_relance_chercheur_seq OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 90851)
-- Name: campagne_relance_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.campagne_relance_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.campagne_relance_seq OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 90852)
-- Name: campagne_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.campagne_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.campagne_seq OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 90853)
-- Name: caracterisation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.caracterisation (
                                        id bigint NOT NULL,
                                        admin boolean DEFAULT false,
                                        archive boolean DEFAULT false,
                                        code character varying(500),
                                        date_archivage date,
                                        date_creation date,
                                        libelle character varying(500),
                                        username character varying(500),
                                        visible boolean DEFAULT true
);


ALTER TABLE public.caracterisation OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 90861)
-- Name: caracterisation_dev_de_savoir_et_innov; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.caracterisation_dev_de_savoir_et_innov (
                                                               id bigint NOT NULL,
                                                               caracterisation_id bigint,
                                                               developpement_de_savoir_et_innovation_scientifique_id bigint
);


ALTER TABLE public.caracterisation_dev_de_savoir_et_innov OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 90864)
-- Name: caracterisation_dev_de_savoir_et_innov_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.caracterisation_dev_de_savoir_et_innov_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.caracterisation_dev_de_savoir_et_innov_seq OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 90865)
-- Name: caracterisation_developpement_de_savoir_et_innovation_scientifi; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.caracterisation_developpement_de_savoir_et_innovation_scientifi (
                                                                                        id bigint NOT NULL,
                                                                                        caracterisation_id bigint,
                                                                                        developpement_de_savoir_et_innovation_scientifique_id bigint
);


ALTER TABLE public.caracterisation_developpement_de_savoir_et_innovation_scientifi OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 90868)
-- Name: caracterisation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.caracterisation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.caracterisation_seq OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 90869)
-- Name: categorie_faq; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categorie_faq (
                                      id bigint NOT NULL,
                                      admin boolean DEFAULT false,
                                      archive boolean DEFAULT false,
                                      date_archivage date,
                                      date_creation date,
                                      libelle character varying(500),
                                      ordre integer,
                                      username character varying(500),
                                      visible boolean DEFAULT true
);


ALTER TABLE public.categorie_faq OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 90877)
-- Name: categorie_faq_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categorie_faq_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categorie_faq_seq OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 90878)
-- Name: categorie_notification; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categorie_notification (
                                               id bigint NOT NULL,
                                               code character varying(500),
                                               libelle character varying(500)
);


ALTER TABLE public.categorie_notification OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 90883)
-- Name: categorie_notification_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categorie_notification_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categorie_notification_seq OWNER TO postgres;

--
-- TOC entry 236 (class 1259 OID 90884)
-- Name: chercheur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.chercheur (
                                  id bigint NOT NULL,
                                  account_non_expired boolean NOT NULL,
                                  account_non_locked boolean NOT NULL,
                                  created_at timestamp without time zone,
                                  credentials_non_expired boolean NOT NULL,
                                  email character varying(255),
                                  enabled boolean NOT NULL,
                                  nom character varying(255),
                                  password character varying(255),
                                  password_changed boolean NOT NULL,
                                  prenom character varying(255),
                                  updated_at timestamp without time zone,
                                  username character varying(255),
                                  base_horizon character varying(500),
                                  consentement_rgpd boolean DEFAULT false,
                                  email_principale character varying(500),
                                  formation_en_management boolean DEFAULT false,
                                  nature_implication character varying(500),
                                  numero_matricule character varying(500),
                                  resume text,
                                  affectation_structurelle_id bigint,
                                  commission_scientifique_id bigint,
                                  corps_id bigint,
                                  departement_scientifique_id bigint,
                                  entite_administrative_id bigint,
                                  grade_id bigint,
                                  pays_id bigint,
                                  sexe_id bigint,
                                  type_entite_administrative_id bigint,
                                  ville_id bigint,
                                  id_graph character varying(255),
                                  civilite character varying(50),
                                  intitule_poste character varying(255),
                                  sorgho boolean,
                                  valide boolean,
                                  type_effectif character varying(255),
                                  domaine_activite character varying(255),
                                  nom_naissance character varying(255),
                                  date_de_naissance date,
                                  lieu_de_naissance character varying(255),
                                  telephone character varying(50),
                                  identifiant_cas character varying(255),
                                  commentaire_desactivation character varying(255),
                                  date_creation date,
                                  date_modification date,
                                  role character varying(255)
);


ALTER TABLE public.chercheur OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 90891)
-- Name: chercheur_email; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.chercheur_email (
                                        id bigint NOT NULL,
                                        email character varying(500),
                                        principale boolean DEFAULT false,
                                        chercheur_id bigint
);


ALTER TABLE public.chercheur_email OWNER TO postgres;

--
-- TOC entry 238 (class 1259 OID 90897)
-- Name: chercheur_email_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.chercheur_email_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.chercheur_email_seq OWNER TO postgres;

--
-- TOC entry 239 (class 1259 OID 90898)
-- Name: comite_et_commission_evaluation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.comite_et_commission_evaluation (
                                                        id bigint NOT NULL,
                                                        commentaire text,
                                                        nom character varying(500),
                                                        nom_revue_ou_editeur character varying(500),
                                                        nombre_jour_dedie numeric(19,2),
                                                        reliee_instruments_ird boolean DEFAULT false,
                                                        role character varying(500),
                                                        etat_etape_campagne_id bigint,
                                                        expertise_id bigint,
                                                        nature_expertise_id bigint
);


ALTER TABLE public.comite_et_commission_evaluation OWNER TO postgres;

--
-- TOC entry 240 (class 1259 OID 90904)
-- Name: comite_et_commission_evaluation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.comite_et_commission_evaluation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comite_et_commission_evaluation_seq OWNER TO postgres;

--
-- TOC entry 241 (class 1259 OID 90905)
-- Name: commanditaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commanditaire (
                                      id bigint NOT NULL,
                                      admin boolean DEFAULT false,
                                      archive boolean DEFAULT false,
                                      code character varying(500),
                                      date_archivage date,
                                      date_creation date,
                                      description text,
                                      libelle character varying(500),
                                      username character varying(500),
                                      visible boolean DEFAULT true,
                                      pays_id bigint
);


ALTER TABLE public.commanditaire OWNER TO postgres;

--
-- TOC entry 242 (class 1259 OID 90913)
-- Name: commanditaire_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commanditaire_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commanditaire_seq OWNER TO postgres;

--
-- TOC entry 243 (class 1259 OID 90914)
-- Name: commission_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commission_scientifique (
                                                id bigint NOT NULL,
                                                admin boolean DEFAULT false,
                                                archive boolean DEFAULT false,
                                                code character varying(500),
                                                date_archivage date,
                                                date_creation date,
                                                libelle_court character varying(500),
                                                libelle_long character varying(500),
                                                username character varying(500),
                                                visible boolean DEFAULT true,
                                                libelle character varying(255)
);


ALTER TABLE public.commission_scientifique OWNER TO postgres;

--
-- TOC entry 244 (class 1259 OID 90922)
-- Name: commission_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commission_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commission_scientifique_seq OWNER TO postgres;

--
-- TOC entry 245 (class 1259 OID 90923)
-- Name: communaute_savoir; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.communaute_savoir (
                                          id bigint NOT NULL,
                                          admin boolean DEFAULT false,
                                          archive boolean DEFAULT false,
                                          code character varying(500),
                                          date_archivage date,
                                          date_creation date,
                                          libelle character varying(500),
                                          username character varying(500),
                                          visible boolean DEFAULT true
);


ALTER TABLE public.communaute_savoir OWNER TO postgres;

--
-- TOC entry 246 (class 1259 OID 90931)
-- Name: communaute_savoir_chercheur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.communaute_savoir_chercheur (
                                                    id bigint NOT NULL,
                                                    chercheur_id bigint,
                                                    communaute_savoir_id bigint
);


ALTER TABLE public.communaute_savoir_chercheur OWNER TO postgres;

--
-- TOC entry 247 (class 1259 OID 90934)
-- Name: communaute_savoir_chercheur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.communaute_savoir_chercheur_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.communaute_savoir_chercheur_seq OWNER TO postgres;

--
-- TOC entry 248 (class 1259 OID 90935)
-- Name: communaute_savoir_conseil_et_comite_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.communaute_savoir_conseil_et_comite_scientifique (
                                                                         id bigint NOT NULL,
                                                                         communaute_savoir_id bigint,
                                                                         conseil_et_comite_scientifique_id bigint
);


ALTER TABLE public.communaute_savoir_conseil_et_comite_scientifique OWNER TO postgres;

--
-- TOC entry 249 (class 1259 OID 90938)
-- Name: communaute_savoir_conseil_et_comite_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.communaute_savoir_conseil_et_comite_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.communaute_savoir_conseil_et_comite_scientifique_seq OWNER TO postgres;

--
-- TOC entry 250 (class 1259 OID 90939)
-- Name: communaute_savoir_encadrement_doctorant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.communaute_savoir_encadrement_doctorant (
                                                                id bigint NOT NULL,
                                                                communaute_savoir_id bigint,
                                                                encadrement_doctorant_id bigint
);


ALTER TABLE public.communaute_savoir_encadrement_doctorant OWNER TO postgres;

--
-- TOC entry 251 (class 1259 OID 90942)
-- Name: communaute_savoir_encadrement_doctorant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.communaute_savoir_encadrement_doctorant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.communaute_savoir_encadrement_doctorant_seq OWNER TO postgres;

--
-- TOC entry 252 (class 1259 OID 90943)
-- Name: communaute_savoir_encadrement_etudiant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.communaute_savoir_encadrement_etudiant (
                                                               id bigint NOT NULL,
                                                               communaute_savoir_id bigint,
                                                               encadrement_etudiant_id bigint
);


ALTER TABLE public.communaute_savoir_encadrement_etudiant OWNER TO postgres;

--
-- TOC entry 253 (class 1259 OID 90946)
-- Name: communaute_savoir_encadrement_etudiant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.communaute_savoir_encadrement_etudiant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.communaute_savoir_encadrement_etudiant_seq OWNER TO postgres;

--
-- TOC entry 254 (class 1259 OID 90947)
-- Name: communaute_savoir_evaluation_recherche_universitaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.communaute_savoir_evaluation_recherche_universitaire (
                                                                             id bigint NOT NULL,
                                                                             communaute_savoir_id bigint,
                                                                             evaluation_recherche_universitaire_id bigint
);


ALTER TABLE public.communaute_savoir_evaluation_recherche_universitaire OWNER TO postgres;

--
-- TOC entry 255 (class 1259 OID 90950)
-- Name: communaute_savoir_evenement_colloque_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.communaute_savoir_evenement_colloque_scientifique (
                                                                          id bigint NOT NULL,
                                                                          communaute_savoir_id bigint,
                                                                          evenement_colloque_scienntifique_id bigint
);


ALTER TABLE public.communaute_savoir_evenement_colloque_scientifique OWNER TO postgres;

--
-- TOC entry 256 (class 1259 OID 90953)
-- Name: communaute_savoir_evenement_colloque_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.communaute_savoir_evenement_colloque_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.communaute_savoir_evenement_colloque_scientifique_seq OWNER TO postgres;

--
-- TOC entry 257 (class 1259 OID 90954)
-- Name: communaute_savoir_expertise_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.communaute_savoir_expertise_scientifique (
                                                                 id bigint NOT NULL,
                                                                 communaute_savoir_id bigint,
                                                                 expertise_scientifique_id bigint
);


ALTER TABLE public.communaute_savoir_expertise_scientifique OWNER TO postgres;

--
-- TOC entry 258 (class 1259 OID 90957)
-- Name: communaute_savoir_expertise_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.communaute_savoir_expertise_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.communaute_savoir_expertise_scientifique_seq OWNER TO postgres;

--
-- TOC entry 259 (class 1259 OID 90958)
-- Name: communaute_savoir_projet_activite_recherche; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.communaute_savoir_projet_activite_recherche (
                                                                    id bigint NOT NULL,
                                                                    communaute_savoir_id bigint,
                                                                    projet_activite_recherche_id bigint
);


ALTER TABLE public.communaute_savoir_projet_activite_recherche OWNER TO postgres;

--
-- TOC entry 260 (class 1259 OID 90961)
-- Name: communaute_savoir_projet_activite_recherche_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.communaute_savoir_projet_activite_recherche_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.communaute_savoir_projet_activite_recherche_seq OWNER TO postgres;

--
-- TOC entry 261 (class 1259 OID 90962)
-- Name: communaute_savoir_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.communaute_savoir_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.communaute_savoir_seq OWNER TO postgres;

--
-- TOC entry 262 (class 1259 OID 90963)
-- Name: conseil_et_comite_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.conseil_et_comite_scientifique (
                                                       id bigint NOT NULL,
                                                       intitule character varying(500),
                                                       nombre_jours_par_annee numeric(19,2),
                                                       temps_estime_pour_cette_annne numeric(19,2),
                                                       campagne_id bigint,
                                                       chercheur_id bigint,
                                                       etablissement_id bigint,
                                                       etat_etape_campagne_id bigint,
                                                       pays_id bigint,
                                                       annee integer
);


ALTER TABLE public.conseil_et_comite_scientifique OWNER TO postgres;

--
-- TOC entry 263 (class 1259 OID 90968)
-- Name: conseil_et_comite_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.conseil_et_comite_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.conseil_et_comite_scientifique_seq OWNER TO postgres;

--
-- TOC entry 264 (class 1259 OID 90969)
-- Name: conseils_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.conseils_scientifique (
                                              id bigint NOT NULL,
                                              intitule character varying(500),
                                              nombre_jours_consacres bigint,
                                              etat_etape_campagne_id bigint,
                                              expertise_id bigint,
                                              nature_expertise_id bigint,
                                              type_expertise_id bigint
);


ALTER TABLE public.conseils_scientifique OWNER TO postgres;

--
-- TOC entry 265 (class 1259 OID 90974)
-- Name: conseils_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.conseils_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.conseils_scientifique_seq OWNER TO postgres;

--
-- TOC entry 266 (class 1259 OID 90975)
-- Name: consultance_scientifique_ponctuelle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.consultance_scientifique_ponctuelle (
                                                            id bigint NOT NULL,
                                                            commentaire text,
                                                            date_fin date,
                                                            nombre_jour_dedie numeric(19,2),
                                                            reliee_instruments_ird boolean DEFAULT false,
                                                            sujet_expertise character varying(500),
                                                            etat_etape_campagne_id bigint,
                                                            expertise_id bigint,
                                                            nature_expertise_id bigint,
                                                            type_expertise_id bigint
);


ALTER TABLE public.consultance_scientifique_ponctuelle OWNER TO postgres;

--
-- TOC entry 267 (class 1259 OID 90981)
-- Name: consultance_scientifique_ponctuelle_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.consultance_scientifique_ponctuelle_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.consultance_scientifique_ponctuelle_seq OWNER TO postgres;

--
-- TOC entry 268 (class 1259 OID 90982)
-- Name: contexte; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contexte (
                                 id bigint NOT NULL,
                                 admin boolean DEFAULT false,
                                 archive boolean DEFAULT false,
                                 code character varying(500),
                                 date_archivage date,
                                 date_creation date,
                                 libelle character varying(500),
                                 username character varying(500),
                                 visible boolean DEFAULT true
);


ALTER TABLE public.contexte OWNER TO postgres;

--
-- TOC entry 269 (class 1259 OID 90990)
-- Name: contexte_culture_scientifique_recontre_grand_public_jeune_publi; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contexte_culture_scientifique_recontre_grand_public_jeune_publi (
                                                                                        id bigint NOT NULL,
                                                                                        contexte_id bigint,
                                                                                        culture_scientifique_recontre_grand_public_jeune_public_id bigint
);


ALTER TABLE public.contexte_culture_scientifique_recontre_grand_public_jeune_publi OWNER TO postgres;

--
-- TOC entry 270 (class 1259 OID 90993)
-- Name: contexte_rencontre_grand_publique_jeune_publique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contexte_rencontre_grand_publique_jeune_publique (
                                                                         id bigint NOT NULL,
                                                                         contexte_id bigint,
                                                                         rencontre_grand_publique_jeune_publique_id bigint
);


ALTER TABLE public.contexte_rencontre_grand_publique_jeune_publique OWNER TO postgres;

--
-- TOC entry 271 (class 1259 OID 90996)
-- Name: contexte_rencontre_grand_publique_jeune_publique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contexte_rencontre_grand_publique_jeune_publique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contexte_rencontre_grand_publique_jeune_publique_seq OWNER TO postgres;

--
-- TOC entry 272 (class 1259 OID 90997)
-- Name: contexte_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contexte_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contexte_seq OWNER TO postgres;

--
-- TOC entry 273 (class 1259 OID 90998)
-- Name: continent; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.continent (
                                  id bigint NOT NULL,
                                  code character varying(255),
                                  id_graph character varying(255),
                                  libelle character varying(255)
);


ALTER TABLE public.continent OWNER TO postgres;

--
-- TOC entry 274 (class 1259 OID 91003)
-- Name: contrat_et_convention_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contrat_et_convention_ird (
                                                  id bigint NOT NULL,
                                                  date_contrat date,
                                                  description text,
                                                  intitule character varying(500),
                                                  numero character varying(500),
                                                  etat_etape_campagne_id bigint,
                                                  savoir_et_innovation_id bigint,
                                                  status_contrat_et_convention_id bigint,
                                                  date_creation_contrat date,
                                                  date_entree_en_vigueur date,
                                                  date_fin date,
                                                  duree_en_mois integer NOT NULL,
                                                  num_matricule_porteur character varying(255),
                                                  programme_financement character varying(255)
);


ALTER TABLE public.contrat_et_convention_ird OWNER TO postgres;

--
-- TOC entry 275 (class 1259 OID 91008)
-- Name: contrat_et_convention_ird_partenaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contrat_et_convention_ird_partenaire (
                                                             id bigint NOT NULL,
                                                             contrat_et_convention_ird_id bigint,
                                                             partenaire_id bigint
);


ALTER TABLE public.contrat_et_convention_ird_partenaire OWNER TO postgres;

--
-- TOC entry 276 (class 1259 OID 91011)
-- Name: contrat_et_convention_ird_partenaire_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contrat_et_convention_ird_partenaire_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contrat_et_convention_ird_partenaire_seq OWNER TO postgres;

--
-- TOC entry 277 (class 1259 OID 91012)
-- Name: contrat_et_convention_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contrat_et_convention_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contrat_et_convention_ird_seq OWNER TO postgres;

--
-- TOC entry 278 (class 1259 OID 91013)
-- Name: corps; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.corps (
                              id bigint NOT NULL,
                              admin boolean DEFAULT false,
                              archive boolean DEFAULT false,
                              code character varying(500),
                              date_archivage date,
                              date_creation date,
                              description text,
                              libelle character varying(500),
                              username character varying(500),
                              visible boolean DEFAULT true,
                              id_graph character varying(255)
);


ALTER TABLE public.corps OWNER TO postgres;

--
-- TOC entry 279 (class 1259 OID 91021)
-- Name: corps_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.corps_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.corps_seq OWNER TO postgres;

--
-- TOC entry 280 (class 1259 OID 91022)
-- Name: culture_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.culture_scientifique (
                                             id bigint NOT NULL,
                                             annee bigint,
                                             temps_estime_pour_cette_annne numeric(19,2),
                                             campagne_id bigint,
                                             chercheur_id bigint,
                                             etat_etape_campagne_id bigint,
                                             nature_activite_grand_publique_id bigint
);


ALTER TABLE public.culture_scientifique OWNER TO postgres;

--
-- TOC entry 281 (class 1259 OID 91025)
-- Name: culture_scientifique_outil_pedagogique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.culture_scientifique_outil_pedagogique (
                                                               id bigint NOT NULL,
                                                               lien_web character varying(255),
                                                               nom_outil character varying(255),
                                                               role character varying(255),
                                                               sortie_annee integer,
                                                               sortie_mois integer,
                                                               campagne_id bigint,
                                                               chercheur_id bigint,
                                                               etat_etape_campagne_id bigint
);


ALTER TABLE public.culture_scientifique_outil_pedagogique OWNER TO postgres;

--
-- TOC entry 282 (class 1259 OID 91030)
-- Name: culture_scientifique_recontre_grand_public_jeune_public; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.culture_scientifique_recontre_grand_public_jeune_public (
                                                                                id bigint NOT NULL,
                                                                                evenement_grand_public boolean,
                                                                                intitule_sujet character varying(255),
                                                                                lien_web character varying(255),
                                                                                periode_annee integer,
                                                                                periode_mois integer,
                                                                                temps_estime_pour_cette_annne numeric(19,2),
                                                                                volume_public numeric(19,2),
                                                                                campagne_id bigint,
                                                                                chercheur_id bigint,
                                                                                format_rencontre_id bigint
);


ALTER TABLE public.culture_scientifique_recontre_grand_public_jeune_public OWNER TO postgres;

--
-- TOC entry 283 (class 1259 OID 91035)
-- Name: culture_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.culture_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.culture_scientifique_seq OWNER TO postgres;

--
-- TOC entry 284 (class 1259 OID 91036)
-- Name: departement_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.departement_scientifique (
                                                 id bigint NOT NULL,
                                                 admin boolean DEFAULT false,
                                                 archive boolean DEFAULT false,
                                                 code character varying(500),
                                                 date_archivage date,
                                                 date_creation date,
                                                 libelle character varying(500),
                                                 username character varying(500),
                                                 visible boolean DEFAULT true
);


ALTER TABLE public.departement_scientifique OWNER TO postgres;

--
-- TOC entry 285 (class 1259 OID 91044)
-- Name: departement_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.departement_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.departement_scientifique_seq OWNER TO postgres;

--
-- TOC entry 286 (class 1259 OID 91045)
-- Name: dev_savoir_innov_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dev_savoir_innov_scientifique (
                                                      id bigint NOT NULL,
                                                      annee_mise_en_oeuvre integer,
                                                      lien_web character varying(500),
                                                      titre_instrument character varying(500),
                                                      etat_etape_campagne_id bigint,
                                                      role_developpement_de_savoir_id bigint,
                                                      savoir_et_innovation_id bigint
);


ALTER TABLE public.dev_savoir_innov_scientifique OWNER TO postgres;

--
-- TOC entry 287 (class 1259 OID 91050)
-- Name: dev_savoir_innov_scientifique_discipline_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dev_savoir_innov_scientifique_discipline_scientifique (
                                                                              id bigint NOT NULL,
                                                                              developpement_de_savoir_et_innovation_scientifique_id bigint,
                                                                              discipline_scientifique_id bigint
);


ALTER TABLE public.dev_savoir_innov_scientifique_discipline_scientifique OWNER TO postgres;

--
-- TOC entry 288 (class 1259 OID 91053)
-- Name: dev_savoir_innov_scientifique_discipline_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dev_savoir_innov_scientifique_discipline_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dev_savoir_innov_scientifique_discipline_scientifique_seq OWNER TO postgres;

--
-- TOC entry 289 (class 1259 OID 91054)
-- Name: dev_savoir_innov_scientifique_enjeux_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dev_savoir_innov_scientifique_enjeux_ird (
                                                                 id bigint NOT NULL,
                                                                 developpement_de_savoir_et_innovation_scientifique_id bigint,
                                                                 enjeux_ird_id bigint
);


ALTER TABLE public.dev_savoir_innov_scientifique_enjeux_ird OWNER TO postgres;

--
-- TOC entry 290 (class 1259 OID 91057)
-- Name: dev_savoir_innov_scientifique_enjeux_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dev_savoir_innov_scientifique_enjeux_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dev_savoir_innov_scientifique_enjeux_ird_seq OWNER TO postgres;

--
-- TOC entry 291 (class 1259 OID 91058)
-- Name: dev_savoir_innov_scientifique_instrument_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dev_savoir_innov_scientifique_instrument_ird (
                                                                     id bigint NOT NULL,
                                                                     developpement_de_savoir_et_innovation_scientifique_id bigint,
                                                                     instrument_ird_id bigint
);


ALTER TABLE public.dev_savoir_innov_scientifique_instrument_ird OWNER TO postgres;

--
-- TOC entry 292 (class 1259 OID 91061)
-- Name: dev_savoir_innov_scientifique_instrument_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dev_savoir_innov_scientifique_instrument_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dev_savoir_innov_scientifique_instrument_ird_seq OWNER TO postgres;

--
-- TOC entry 293 (class 1259 OID 91062)
-- Name: dev_savoir_innov_scientifique_mode_diffusion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dev_savoir_innov_scientifique_mode_diffusion (
                                                                     id bigint NOT NULL,
                                                                     developpement_de_savoir_et_innovation_scientifique_id bigint,
                                                                     mode_diffusion_id bigint
);


ALTER TABLE public.dev_savoir_innov_scientifique_mode_diffusion OWNER TO postgres;

--
-- TOC entry 294 (class 1259 OID 91065)
-- Name: dev_savoir_innov_scientifique_mode_diffusion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dev_savoir_innov_scientifique_mode_diffusion_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dev_savoir_innov_scientifique_mode_diffusion_seq OWNER TO postgres;

--
-- TOC entry 295 (class 1259 OID 91066)
-- Name: dev_savoir_innov_scientifique_pays; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dev_savoir_innov_scientifique_pays (
                                                           id bigint NOT NULL,
                                                           developpement_de_savoir_et_innovation_scientifique_id bigint,
                                                           pays_id bigint
);


ALTER TABLE public.dev_savoir_innov_scientifique_pays OWNER TO postgres;

--
-- TOC entry 296 (class 1259 OID 91069)
-- Name: dev_savoir_innov_scientifique_pays_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dev_savoir_innov_scientifique_pays_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dev_savoir_innov_scientifique_pays_seq OWNER TO postgres;

--
-- TOC entry 297 (class 1259 OID 91070)
-- Name: dev_savoir_innov_scientifique_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dev_savoir_innov_scientifique_role (
                                                           id bigint NOT NULL,
                                                           developpement_de_savoir_et_innovation_scientifique_id bigint,
                                                           role_developpement_de_savoir_id bigint
);


ALTER TABLE public.dev_savoir_innov_scientifique_role OWNER TO postgres;

--
-- TOC entry 298 (class 1259 OID 91073)
-- Name: dev_savoir_innov_scientifique_role_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dev_savoir_innov_scientifique_role_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dev_savoir_innov_scientifique_role_seq OWNER TO postgres;

--
-- TOC entry 299 (class 1259 OID 91074)
-- Name: dev_savoir_innov_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dev_savoir_innov_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dev_savoir_innov_scientifique_seq OWNER TO postgres;

--
-- TOC entry 300 (class 1259 OID 91075)
-- Name: developpement_de_savoir_et_innovation_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.developpement_de_savoir_et_innovation_scientifique (
                                                                           id bigint NOT NULL,
                                                                           annee_mise_en_oeuvre integer,
                                                                           lien_web character varying(500),
                                                                           titre_instrument character varying(500),
                                                                           etat_etape_campagne_id bigint,
                                                                           role_developpement_de_savoir_id bigint,
                                                                           savoir_et_innovation_id bigint
);


ALTER TABLE public.developpement_de_savoir_et_innovation_scientifique OWNER TO postgres;

--
-- TOC entry 301 (class 1259 OID 91080)
-- Name: developpement_de_savoir_et_innovation_scientifique_communaute_s; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.developpement_de_savoir_et_innovation_scientifique_communaute_s
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.developpement_de_savoir_et_innovation_scientifique_communaute_s OWNER TO postgres;

--
-- TOC entry 302 (class 1259 OID 91081)
-- Name: developpement_de_savoir_et_innovation_scientifique_discipline_s; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.developpement_de_savoir_et_innovation_scientifique_discipline_s
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.developpement_de_savoir_et_innovation_scientifique_discipline_s OWNER TO postgres;

--
-- TOC entry 303 (class 1259 OID 91082)
-- Name: developpement_de_savoir_et_innovation_scientifique_enjeux_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.developpement_de_savoir_et_innovation_scientifique_enjeux_ird (
                                                                                      id bigint NOT NULL,
                                                                                      developpement_de_savoir_et_innovation_scientifique_id bigint,
                                                                                      enjeux_ird_id bigint
);


ALTER TABLE public.developpement_de_savoir_et_innovation_scientifique_enjeux_ird OWNER TO postgres;

--
-- TOC entry 304 (class 1259 OID 91085)
-- Name: developpement_de_savoir_et_innovation_scientifique_enjeux_ird_s; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.developpement_de_savoir_et_innovation_scientifique_enjeux_ird_s
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.developpement_de_savoir_et_innovation_scientifique_enjeux_ird_s OWNER TO postgres;

--
-- TOC entry 305 (class 1259 OID 91086)
-- Name: developpement_de_savoir_et_innovation_scientifique_etablissemen; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.developpement_de_savoir_et_innovation_scientifique_etablissemen
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.developpement_de_savoir_et_innovation_scientifique_etablissemen OWNER TO postgres;

--
-- TOC entry 306 (class 1259 OID 91087)
-- Name: developpement_de_savoir_et_innovation_scientifique_mode_diffusi; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.developpement_de_savoir_et_innovation_scientifique_mode_diffusi
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.developpement_de_savoir_et_innovation_scientifique_mode_diffusi OWNER TO postgres;

--
-- TOC entry 307 (class 1259 OID 91088)
-- Name: developpement_de_savoir_et_innovation_scientifique_pays; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.developpement_de_savoir_et_innovation_scientifique_pays (
                                                                                id bigint NOT NULL,
                                                                                developpement_de_savoir_et_innovation_scientifique_id bigint,
                                                                                pays_id bigint
);


ALTER TABLE public.developpement_de_savoir_et_innovation_scientifique_pays OWNER TO postgres;

--
-- TOC entry 308 (class 1259 OID 91091)
-- Name: developpement_de_savoir_et_innovation_scientifique_pays_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.developpement_de_savoir_et_innovation_scientifique_pays_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.developpement_de_savoir_et_innovation_scientifique_pays_seq OWNER TO postgres;

--
-- TOC entry 309 (class 1259 OID 91092)
-- Name: developpement_de_savoir_et_innovation_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.developpement_de_savoir_et_innovation_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.developpement_de_savoir_et_innovation_scientifique_seq OWNER TO postgres;

--
-- TOC entry 310 (class 1259 OID 91093)
-- Name: developpement_de_savoir_et_innovation_scientifique_type_savoir; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.developpement_de_savoir_et_innovation_scientifique_type_savoir (
                                                                                       id bigint NOT NULL,
                                                                                       developpement_de_savoir_et_innovation_scientifique_id bigint,
                                                                                       type_savoir_id bigint
);


ALTER TABLE public.developpement_de_savoir_et_innovation_scientifique_type_savoir OWNER TO postgres;

--
-- TOC entry 311 (class 1259 OID 91096)
-- Name: discipline_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discipline_scientifique (
                                                id bigint NOT NULL,
                                                admin boolean DEFAULT false,
                                                archive boolean DEFAULT false,
                                                code character varying(500),
                                                date_archivage date,
                                                date_creation date,
                                                libelle_eng character varying(500),
                                                libelle_fr character varying(500),
                                                niveau bigint,
                                                username character varying(500),
                                                visible boolean DEFAULT true,
                                                discipline_scientifique_id bigint,
                                                libelle character varying(255)
);


ALTER TABLE public.discipline_scientifique OWNER TO postgres;

--
-- TOC entry 312 (class 1259 OID 91104)
-- Name: discipline_scientifique_chercheur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discipline_scientifique_chercheur (
                                                          id bigint NOT NULL,
                                                          chercheur_id bigint,
                                                          discipline_scientifique_id bigint,
                                                          discipline_scientifique_erc_id bigint
);


ALTER TABLE public.discipline_scientifique_chercheur OWNER TO postgres;

--
-- TOC entry 313 (class 1259 OID 91107)
-- Name: discipline_scientifique_chercheur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.discipline_scientifique_chercheur_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.discipline_scientifique_chercheur_seq OWNER TO postgres;

--
-- TOC entry 314 (class 1259 OID 91108)
-- Name: discipline_scientifique_comite_et_commission_evaluation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discipline_scientifique_comite_et_commission_evaluation (
                                                                                id bigint NOT NULL,
                                                                                comite_et_commission_evaluation_id bigint,
                                                                                discipline_scientifique_id bigint
);


ALTER TABLE public.discipline_scientifique_comite_et_commission_evaluation OWNER TO postgres;

--
-- TOC entry 315 (class 1259 OID 91111)
-- Name: discipline_scientifique_comite_et_commission_evaluation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.discipline_scientifique_comite_et_commission_evaluation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.discipline_scientifique_comite_et_commission_evaluation_seq OWNER TO postgres;

--
-- TOC entry 316 (class 1259 OID 91112)
-- Name: discipline_scientifique_conseil_et_comite_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discipline_scientifique_conseil_et_comite_scientifique (
                                                                               id bigint NOT NULL,
                                                                               conseil_et_comite_scientifique_id bigint,
                                                                               discipline_scientifique_id bigint
);


ALTER TABLE public.discipline_scientifique_conseil_et_comite_scientifique OWNER TO postgres;

--
-- TOC entry 317 (class 1259 OID 91115)
-- Name: discipline_scientifique_conseil_et_comite_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.discipline_scientifique_conseil_et_comite_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.discipline_scientifique_conseil_et_comite_scientifique_seq OWNER TO postgres;

--
-- TOC entry 318 (class 1259 OID 91116)
-- Name: discipline_scientifique_conseils_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discipline_scientifique_conseils_scientifique (
                                                                      id bigint NOT NULL,
                                                                      conseils_scientifique_id bigint,
                                                                      discipline_scientifique_id bigint
);


ALTER TABLE public.discipline_scientifique_conseils_scientifique OWNER TO postgres;

--
-- TOC entry 319 (class 1259 OID 91119)
-- Name: discipline_scientifique_conseils_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.discipline_scientifique_conseils_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.discipline_scientifique_conseils_scientifique_seq OWNER TO postgres;

--
-- TOC entry 320 (class 1259 OID 91120)
-- Name: discipline_scientifique_consultance_scientifique_ponctuelle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discipline_scientifique_consultance_scientifique_ponctuelle (
                                                                                    id bigint NOT NULL,
                                                                                    consultance_scientifique_ponctuelle_id bigint,
                                                                                    discipline_scientifique_id bigint
);


ALTER TABLE public.discipline_scientifique_consultance_scientifique_ponctuelle OWNER TO postgres;

--
-- TOC entry 321 (class 1259 OID 91123)
-- Name: discipline_scientifique_consultance_scientifique_ponctuelle_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.discipline_scientifique_consultance_scientifique_ponctuelle_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.discipline_scientifique_consultance_scientifique_ponctuelle_seq OWNER TO postgres;

--
-- TOC entry 322 (class 1259 OID 91124)
-- Name: discipline_scientifique_direction_encadrement_doctorant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discipline_scientifique_direction_encadrement_doctorant (
                                                                                id bigint NOT NULL,
                                                                                discipline_scientifique_id bigint,
                                                                                encadrement_doctorant_id bigint
);


ALTER TABLE public.discipline_scientifique_direction_encadrement_doctorant OWNER TO postgres;

--
-- TOC entry 323 (class 1259 OID 91127)
-- Name: discipline_scientifique_encadrement_doctorant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discipline_scientifique_encadrement_doctorant (
                                                                      id bigint NOT NULL,
                                                                      discipline_scientifique_id bigint,
                                                                      encadrement_doctorant_id bigint
);


ALTER TABLE public.discipline_scientifique_encadrement_doctorant OWNER TO postgres;

--
-- TOC entry 324 (class 1259 OID 91130)
-- Name: discipline_scientifique_encadrement_doctorant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.discipline_scientifique_encadrement_doctorant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.discipline_scientifique_encadrement_doctorant_seq OWNER TO postgres;

--
-- TOC entry 325 (class 1259 OID 91131)
-- Name: discipline_scientifique_encadrement_etudiant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discipline_scientifique_encadrement_etudiant (
                                                                     id bigint NOT NULL,
                                                                     discipline_scientifique_id bigint,
                                                                     encadrement_etudiant_id bigint
);


ALTER TABLE public.discipline_scientifique_encadrement_etudiant OWNER TO postgres;

--
-- TOC entry 326 (class 1259 OID 91134)
-- Name: discipline_scientifique_encadrement_etudiant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.discipline_scientifique_encadrement_etudiant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.discipline_scientifique_encadrement_etudiant_seq OWNER TO postgres;

--
-- TOC entry 327 (class 1259 OID 91135)
-- Name: discipline_scientifique_erc; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discipline_scientifique_erc (
                                                    id bigint NOT NULL,
                                                    admin boolean DEFAULT false,
                                                    archive boolean DEFAULT false,
                                                    code character varying(500),
                                                    date_archivage date,
                                                    date_creation date,
                                                    libelle_eng character varying(500),
                                                    libelle_fr character varying(500),
                                                    niveau bigint,
                                                    username character varying(500),
                                                    visible boolean DEFAULT true,
                                                    discipline_scientifique_erc_id bigint
);


ALTER TABLE public.discipline_scientifique_erc OWNER TO postgres;

--
-- TOC entry 328 (class 1259 OID 91143)
-- Name: discipline_scientifique_erc_association; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discipline_scientifique_erc_association (
                                                                id bigint NOT NULL,
                                                                discipline_scientifique_id bigint,
                                                                discipline_scientifique_erc_id bigint,
                                                                semantic_relationship_id bigint
);


ALTER TABLE public.discipline_scientifique_erc_association OWNER TO postgres;

--
-- TOC entry 329 (class 1259 OID 91146)
-- Name: discipline_scientifique_erc_association_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.discipline_scientifique_erc_association_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.discipline_scientifique_erc_association_seq OWNER TO postgres;

--
-- TOC entry 330 (class 1259 OID 91147)
-- Name: discipline_scientifique_erc_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.discipline_scientifique_erc_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.discipline_scientifique_erc_seq OWNER TO postgres;

--
-- TOC entry 331 (class 1259 OID 91148)
-- Name: discipline_scientifique_evaluation_recherche_universitaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discipline_scientifique_evaluation_recherche_universitaire (
                                                                                   id bigint NOT NULL,
                                                                                   discipline_scientifique_id bigint,
                                                                                   evaluation_recherche_universitaire_id bigint
);


ALTER TABLE public.discipline_scientifique_evaluation_recherche_universitaire OWNER TO postgres;

--
-- TOC entry 332 (class 1259 OID 91151)
-- Name: discipline_scientifique_evenement_colloque_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discipline_scientifique_evenement_colloque_scientifique (
                                                                                id bigint NOT NULL,
                                                                                discipline_scientifique_id bigint,
                                                                                evenement_colloque_scienntifique_id bigint
);


ALTER TABLE public.discipline_scientifique_evenement_colloque_scientifique OWNER TO postgres;

--
-- TOC entry 333 (class 1259 OID 91154)
-- Name: discipline_scientifique_evenement_colloque_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.discipline_scientifique_evenement_colloque_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.discipline_scientifique_evenement_colloque_scientifique_seq OWNER TO postgres;

--
-- TOC entry 334 (class 1259 OID 91155)
-- Name: discipline_scientifique_expertise_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discipline_scientifique_expertise_scientifique (
                                                                       id bigint NOT NULL,
                                                                       discipline_scientifique_id bigint,
                                                                       expertise_scientifique_id bigint
);


ALTER TABLE public.discipline_scientifique_expertise_scientifique OWNER TO postgres;

--
-- TOC entry 335 (class 1259 OID 91158)
-- Name: discipline_scientifique_expertise_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.discipline_scientifique_expertise_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.discipline_scientifique_expertise_scientifique_seq OWNER TO postgres;

--
-- TOC entry 336 (class 1259 OID 91159)
-- Name: discipline_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.discipline_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.discipline_scientifique_seq OWNER TO postgres;

--
-- TOC entry 337 (class 1259 OID 91160)
-- Name: distinction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.distinction (
                                    id bigint NOT NULL,
                                    date_obtention date,
                                    intitule character varying(500),
                                    campagne_id bigint,
                                    chercheur_id bigint,
                                    etat_etape_campagne_id bigint,
                                    pays_id bigint,
                                    type_participation_id bigint
);


ALTER TABLE public.distinction OWNER TO postgres;

--
-- TOC entry 338 (class 1259 OID 91165)
-- Name: distinction_etablissement_pays; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.distinction_etablissement_pays (
                                                       id bigint NOT NULL,
                                                       distinction_id bigint,
                                                       etablissement_id bigint,
                                                       pays_id bigint
);


ALTER TABLE public.distinction_etablissement_pays OWNER TO postgres;

--
-- TOC entry 339 (class 1259 OID 91168)
-- Name: distinction_etablissement_pays_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.distinction_etablissement_pays_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.distinction_etablissement_pays_seq OWNER TO postgres;

--
-- TOC entry 340 (class 1259 OID 91169)
-- Name: distinction_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.distinction_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.distinction_seq OWNER TO postgres;

--
-- TOC entry 341 (class 1259 OID 91170)
-- Name: doctorant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.doctorant (
                                  id bigint NOT NULL,
                                  admin boolean DEFAULT false,
                                  annee_naissance bigint,
                                  archive boolean DEFAULT false,
                                  civilite character varying(500),
                                  date_archivage date,
                                  date_creation date,
                                  nom character varying(500),
                                  prenom character varying(500),
                                  username character varying(500),
                                  visible boolean DEFAULT true,
                                  pays_id bigint,
                                  sexe_id bigint
);


ALTER TABLE public.doctorant OWNER TO postgres;

--
-- TOC entry 342 (class 1259 OID 91178)
-- Name: doctorant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.doctorant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.doctorant_seq OWNER TO postgres;

--
-- TOC entry 343 (class 1259 OID 91179)
-- Name: domaine_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.domaine_scientifique (
                                             id bigint NOT NULL,
                                             code character varying(255),
                                             description text,
                                             libelle character varying(255)
);


ALTER TABLE public.domaine_scientifique OWNER TO postgres;

--
-- TOC entry 344 (class 1259 OID 91184)
-- Name: domaine_scientifique_chercheur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.domaine_scientifique_chercheur (
                                                       id bigint NOT NULL,
                                                       chercheur_id bigint,
                                                       domaine_scientifique_id bigint
);


ALTER TABLE public.domaine_scientifique_chercheur OWNER TO postgres;

--
-- TOC entry 345 (class 1259 OID 91187)
-- Name: ecole_doctorale; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ecole_doctorale (
                                        id bigint NOT NULL,
                                        international boolean,
                                        intitule character varying(255),
                                        pays_id bigint
);


ALTER TABLE public.ecole_doctorale OWNER TO postgres;

--
-- TOC entry 346 (class 1259 OID 91190)
-- Name: encadrement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.encadrement (
                                    id bigint NOT NULL,
                                    annee bigint,
                                    temps_estime_pour_cette_annne numeric(19,2),
                                    campagne_id bigint,
                                    chercheur_id bigint,
                                    etat_etape_campagne_id bigint
);


ALTER TABLE public.encadrement OWNER TO postgres;

--
-- TOC entry 347 (class 1259 OID 91193)
-- Name: encadrement_doctorant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.encadrement_doctorant (
                                              id bigint NOT NULL,
                                              codirection_internationale boolean DEFAULT false,
                                              cursus boolean DEFAULT false,
                                              date_debut_these date,
                                              date_prevu_soutenance_these date,
                                              intitule_ecole_doctorale character varying(500),
                                              sujet_these character varying(500),
                                              doctorant_id bigint,
                                              encadrement_id bigint,
                                              etablissement_id bigint,
                                              etat_etape_campagne_id bigint,
                                              financement_doctorant_id bigint,
                                              pays_id bigint,
                                              responsabilite_encadrement_doctorant_id bigint,
                                              directeur character varying(500)
);


ALTER TABLE public.encadrement_doctorant OWNER TO postgres;

--
-- TOC entry 348 (class 1259 OID 91200)
-- Name: encadrement_doctorant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.encadrement_doctorant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.encadrement_doctorant_seq OWNER TO postgres;

--
-- TOC entry 349 (class 1259 OID 91201)
-- Name: encadrement_etudiant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.encadrement_etudiant (
                                             id bigint NOT NULL,
                                             cursus character varying(500),
                                             sujet_etude character varying(500),
                                             encadrement_id bigint,
                                             etablissement_id bigint,
                                             etat_etape_campagne_id bigint,
                                             etudiant_id bigint,
                                             niveau_formation_post_bac_id bigint,
                                             pays_id bigint,
                                             responsabilite_direction_encadrement_etudiant_id bigint,
                                             responsabilite_encadrement_etudiant_id bigint
);


ALTER TABLE public.encadrement_etudiant OWNER TO postgres;

--
-- TOC entry 350 (class 1259 OID 91206)
-- Name: encadrement_etudiant_discipline_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.encadrement_etudiant_discipline_scientifique (
                                                                     id bigint NOT NULL,
                                                                     discipline_scientifique_id bigint,
                                                                     encadrement_etudiant_id bigint
);


ALTER TABLE public.encadrement_etudiant_discipline_scientifique OWNER TO postgres;

--
-- TOC entry 351 (class 1259 OID 91209)
-- Name: encadrement_etudiant_discipline_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.encadrement_etudiant_discipline_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.encadrement_etudiant_discipline_scientifique_seq OWNER TO postgres;

--
-- TOC entry 352 (class 1259 OID 91210)
-- Name: encadrement_etudiant_enjeux_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.encadrement_etudiant_enjeux_ird (
                                                        id bigint NOT NULL,
                                                        encadrement_etudiant_id bigint,
                                                        enjeux_ird_id bigint
);


ALTER TABLE public.encadrement_etudiant_enjeux_ird OWNER TO postgres;

--
-- TOC entry 353 (class 1259 OID 91213)
-- Name: encadrement_etudiant_enjeux_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.encadrement_etudiant_enjeux_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.encadrement_etudiant_enjeux_ird_seq OWNER TO postgres;

--
-- TOC entry 354 (class 1259 OID 91214)
-- Name: encadrement_etudiant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.encadrement_etudiant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.encadrement_etudiant_seq OWNER TO postgres;

--
-- TOC entry 355 (class 1259 OID 91215)
-- Name: encadrement_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.encadrement_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.encadrement_seq OWNER TO postgres;

--
-- TOC entry 356 (class 1259 OID 91216)
-- Name: enjeux_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enjeux_ird (
                                   id bigint NOT NULL,
                                   admin boolean DEFAULT false,
                                   archive boolean DEFAULT false,
                                   code character varying(500),
                                   date_archivage date,
                                   date_creation date,
                                   description text,
                                   libelle character varying(500),
                                   username character varying(500),
                                   visible boolean DEFAULT true
);


ALTER TABLE public.enjeux_ird OWNER TO postgres;

--
-- TOC entry 357 (class 1259 OID 91224)
-- Name: enjeux_ird_chercheur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enjeux_ird_chercheur (
                                             id bigint NOT NULL,
                                             chercheur_id bigint,
                                             enjeux_ird_id bigint
);


ALTER TABLE public.enjeux_ird_chercheur OWNER TO postgres;

--
-- TOC entry 358 (class 1259 OID 91227)
-- Name: enjeux_ird_chercheur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.enjeux_ird_chercheur_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enjeux_ird_chercheur_seq OWNER TO postgres;

--
-- TOC entry 359 (class 1259 OID 91228)
-- Name: enjeux_ird_comite_et_commission_evaluation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enjeux_ird_comite_et_commission_evaluation (
                                                                   id bigint NOT NULL,
                                                                   comite_et_commission_evaluation_id bigint,
                                                                   enjeux_ird_id bigint
);


ALTER TABLE public.enjeux_ird_comite_et_commission_evaluation OWNER TO postgres;

--
-- TOC entry 360 (class 1259 OID 91231)
-- Name: enjeux_ird_comite_et_commission_evaluation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.enjeux_ird_comite_et_commission_evaluation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enjeux_ird_comite_et_commission_evaluation_seq OWNER TO postgres;

--
-- TOC entry 361 (class 1259 OID 91232)
-- Name: enjeux_ird_conseils_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enjeux_ird_conseils_scientifique (
                                                         id bigint NOT NULL,
                                                         conseils_scientifique_id bigint,
                                                         enjeux_ird_id bigint
);


ALTER TABLE public.enjeux_ird_conseils_scientifique OWNER TO postgres;

--
-- TOC entry 362 (class 1259 OID 91235)
-- Name: enjeux_ird_conseils_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.enjeux_ird_conseils_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enjeux_ird_conseils_scientifique_seq OWNER TO postgres;

--
-- TOC entry 363 (class 1259 OID 91236)
-- Name: enjeux_ird_consultance_scientifique_ponctuelle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enjeux_ird_consultance_scientifique_ponctuelle (
                                                                       id bigint NOT NULL,
                                                                       consultance_scientifique_ponctuelle_id bigint,
                                                                       enjeux_ird_id bigint
);


ALTER TABLE public.enjeux_ird_consultance_scientifique_ponctuelle OWNER TO postgres;

--
-- TOC entry 364 (class 1259 OID 91239)
-- Name: enjeux_ird_consultance_scientifique_ponctuelle_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.enjeux_ird_consultance_scientifique_ponctuelle_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enjeux_ird_consultance_scientifique_ponctuelle_seq OWNER TO postgres;

--
-- TOC entry 365 (class 1259 OID 91240)
-- Name: enjeux_ird_encadrement_doctorant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enjeux_ird_encadrement_doctorant (
                                                         id bigint NOT NULL,
                                                         encadrement_doctorant_id bigint,
                                                         enjeux_ird_id bigint
);


ALTER TABLE public.enjeux_ird_encadrement_doctorant OWNER TO postgres;

--
-- TOC entry 366 (class 1259 OID 91243)
-- Name: enjeux_ird_encadrement_doctorant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.enjeux_ird_encadrement_doctorant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enjeux_ird_encadrement_doctorant_seq OWNER TO postgres;

--
-- TOC entry 367 (class 1259 OID 91244)
-- Name: enjeux_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.enjeux_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enjeux_ird_seq OWNER TO postgres;

--
-- TOC entry 368 (class 1259 OID 91245)
-- Name: enseignement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enseignement (
                                     id bigint NOT NULL,
                                     etabilssement_non_reconnu boolean DEFAULT false,
                                     intitule character varying(500),
                                     nombre_heure numeric(19,2),
                                     enseignement_et_formation_id bigint,
                                     etat_etape_campagne_id bigint,
                                     modalite_etude_id bigint,
                                     annee integer,
                                     denomination_enseignement character varying(255),
                                     nombre_heure_dispensees_dans_annee numeric(19,2),
                                     temps_estime_pour_cette_annne numeric(19,2),
                                     campagne_id bigint,
                                     chercheur_id bigint,
                                     pays_id bigint,
                                     type_enseignement_dispense_id bigint
);


ALTER TABLE public.enseignement OWNER TO postgres;

--
-- TOC entry 369 (class 1259 OID 91251)
-- Name: enseignement_discipline_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enseignement_discipline_scientifique (
                                                             id bigint NOT NULL,
                                                             discipline_scientifique_id bigint,
                                                             enseignement_id bigint
);


ALTER TABLE public.enseignement_discipline_scientifique OWNER TO postgres;

--
-- TOC entry 370 (class 1259 OID 91254)
-- Name: enseignement_discipline_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.enseignement_discipline_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enseignement_discipline_scientifique_seq OWNER TO postgres;

--
-- TOC entry 371 (class 1259 OID 91255)
-- Name: enseignement_enjeux_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enseignement_enjeux_ird (
                                                id bigint NOT NULL,
                                                enjeux_ird_id bigint,
                                                enseignement_id bigint
);


ALTER TABLE public.enseignement_enjeux_ird OWNER TO postgres;

--
-- TOC entry 372 (class 1259 OID 91258)
-- Name: enseignement_enjeux_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.enseignement_enjeux_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enseignement_enjeux_ird_seq OWNER TO postgres;

--
-- TOC entry 373 (class 1259 OID 91259)
-- Name: enseignement_et_formation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enseignement_et_formation (
                                                  id bigint NOT NULL,
                                                  annee bigint,
                                                  temps_estime_pour_cette_annne numeric(19,2),
                                                  campagne_id bigint,
                                                  chercheur_id bigint,
                                                  etat_etape_campagne_id bigint
);


ALTER TABLE public.enseignement_et_formation OWNER TO postgres;

--
-- TOC entry 374 (class 1259 OID 91262)
-- Name: enseignement_et_formation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.enseignement_et_formation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enseignement_et_formation_seq OWNER TO postgres;

--
-- TOC entry 375 (class 1259 OID 91263)
-- Name: enseignement_nature; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enseignement_nature (
                                            id bigint NOT NULL,
                                            enseignement_id bigint,
                                            nature_enseignement_id bigint
);


ALTER TABLE public.enseignement_nature OWNER TO postgres;

--
-- TOC entry 376 (class 1259 OID 91266)
-- Name: enseignement_nature_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.enseignement_nature_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enseignement_nature_seq OWNER TO postgres;

--
-- TOC entry 377 (class 1259 OID 91267)
-- Name: enseignement_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.enseignement_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enseignement_seq OWNER TO postgres;

--
-- TOC entry 378 (class 1259 OID 91268)
-- Name: enseignement_zone_geographique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enseignement_zone_geographique (
                                                       id bigint NOT NULL,
                                                       enseignement_id bigint,
                                                       pays_id bigint,
                                                       zone_geographique_id bigint
);


ALTER TABLE public.enseignement_zone_geographique OWNER TO postgres;

--
-- TOC entry 379 (class 1259 OID 91271)
-- Name: enseignement_zone_geographique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.enseignement_zone_geographique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enseignement_zone_geographique_seq OWNER TO postgres;

--
-- TOC entry 380 (class 1259 OID 91272)
-- Name: entite_administrative; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.entite_administrative (
                                              id bigint NOT NULL,
                                              admin boolean DEFAULT false,
                                              archive boolean DEFAULT false,
                                              code character varying(500),
                                              date_archivage date,
                                              date_creation date,
                                              description text,
                                              identifiant_national character varying(500),
                                              libelle character varying(500),
                                              libelle_court character varying(500),
                                              libelle_long character varying(500),
                                              site_web character varying(500),
                                              username character varying(500),
                                              visible boolean DEFAULT true,
                                              type_entite_administrative_id bigint
);


ALTER TABLE public.entite_administrative OWNER TO postgres;

--
-- TOC entry 381 (class 1259 OID 91280)
-- Name: entite_administrative_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.entite_administrative_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.entite_administrative_seq OWNER TO postgres;

--
-- TOC entry 382 (class 1259 OID 91281)
-- Name: etablissement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etablissement (
                                      id bigint NOT NULL,
                                      admin boolean DEFAULT false,
                                      anciens_nom character varying(500),
                                      archive boolean DEFAULT false,
                                      champ_intervention character varying(500),
                                      code character varying(500),
                                      date_archivage date,
                                      date_creation date,
                                      description text,
                                      libelle character varying(500),
                                      nom_en_francais character varying(500),
                                      sigle_en_francais character varying(500),
                                      sigle_officiel character varying(500),
                                      username character varying(500),
                                      valide boolean DEFAULT false,
                                      visible boolean DEFAULT true,
                                      pays_id bigint,
                                      ville_id bigint
);


ALTER TABLE public.etablissement OWNER TO postgres;

--
-- TOC entry 383 (class 1259 OID 91290)
-- Name: etablissement_comite_et_commission_evaluation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etablissement_comite_et_commission_evaluation (
                                                                      id bigint NOT NULL,
                                                                      comite_et_commission_evaluation_id bigint,
                                                                      etablissement_id bigint
);


ALTER TABLE public.etablissement_comite_et_commission_evaluation OWNER TO postgres;

--
-- TOC entry 384 (class 1259 OID 91293)
-- Name: etablissement_comite_et_commission_evaluation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.etablissement_comite_et_commission_evaluation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etablissement_comite_et_commission_evaluation_seq OWNER TO postgres;

--
-- TOC entry 385 (class 1259 OID 91294)
-- Name: etablissement_conseils_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etablissement_conseils_scientifique (
                                                            id bigint NOT NULL,
                                                            conseils_scientifique_id bigint,
                                                            etablissement_id bigint
);


ALTER TABLE public.etablissement_conseils_scientifique OWNER TO postgres;

--
-- TOC entry 386 (class 1259 OID 91297)
-- Name: etablissement_conseils_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.etablissement_conseils_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etablissement_conseils_scientifique_seq OWNER TO postgres;

--
-- TOC entry 387 (class 1259 OID 91298)
-- Name: etablissement_consultance_scientifique_ponctuelle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etablissement_consultance_scientifique_ponctuelle (
                                                                          id bigint NOT NULL,
                                                                          consultance_scientifique_ponctuelle_id bigint,
                                                                          etablissement_id bigint
);


ALTER TABLE public.etablissement_consultance_scientifique_ponctuelle OWNER TO postgres;

--
-- TOC entry 388 (class 1259 OID 91301)
-- Name: etablissement_consultance_scientifique_ponctuelle_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.etablissement_consultance_scientifique_ponctuelle_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etablissement_consultance_scientifique_ponctuelle_seq OWNER TO postgres;

--
-- TOC entry 389 (class 1259 OID 91302)
-- Name: etablissement_culture_scientifique_outil_pedagogique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etablissement_culture_scientifique_outil_pedagogique (
                                                                             id bigint NOT NULL,
                                                                             culture_scientifique_outil_pedagogique_id bigint,
                                                                             etablissement_id bigint
);


ALTER TABLE public.etablissement_culture_scientifique_outil_pedagogique OWNER TO postgres;

--
-- TOC entry 390 (class 1259 OID 91305)
-- Name: etablissement_culture_scientifique_recontre_grand_public_jeune_; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etablissement_culture_scientifique_recontre_grand_public_jeune_ (
                                                                                        id bigint NOT NULL,
                                                                                        culture_scientifique_recontre_grand_public_jeune_public_id bigint,
                                                                                        etablissement_id bigint
);


ALTER TABLE public.etablissement_culture_scientifique_recontre_grand_public_jeune_ OWNER TO postgres;

--
-- TOC entry 391 (class 1259 OID 91308)
-- Name: etablissement_encadrement_doctorant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etablissement_encadrement_doctorant (
                                                            id bigint NOT NULL,
                                                            encadrement_doctorant_id bigint,
                                                            etablissement_id bigint
);


ALTER TABLE public.etablissement_encadrement_doctorant OWNER TO postgres;

--
-- TOC entry 392 (class 1259 OID 91311)
-- Name: etablissement_encadrement_doctorant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.etablissement_encadrement_doctorant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etablissement_encadrement_doctorant_seq OWNER TO postgres;

--
-- TOC entry 393 (class 1259 OID 91312)
-- Name: etablissement_encadrement_etudiant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etablissement_encadrement_etudiant (
                                                           id bigint NOT NULL,
                                                           encadrement_etudiant_id bigint,
                                                           etablissement_id bigint
);


ALTER TABLE public.etablissement_encadrement_etudiant OWNER TO postgres;

--
-- TOC entry 394 (class 1259 OID 91315)
-- Name: etablissement_encadrement_etudiant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.etablissement_encadrement_etudiant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etablissement_encadrement_etudiant_seq OWNER TO postgres;

--
-- TOC entry 395 (class 1259 OID 91316)
-- Name: etablissement_enseignement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etablissement_enseignement (
                                                   id bigint NOT NULL,
                                                   enseignement_id bigint,
                                                   etablissement_id bigint
);


ALTER TABLE public.etablissement_enseignement OWNER TO postgres;

--
-- TOC entry 396 (class 1259 OID 91319)
-- Name: etablissement_enseignement_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.etablissement_enseignement_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etablissement_enseignement_seq OWNER TO postgres;

--
-- TOC entry 397 (class 1259 OID 91320)
-- Name: etablissement_partenaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etablissement_partenaire (
                                                 id bigint NOT NULL,
                                                 admin boolean DEFAULT false,
                                                 archive boolean DEFAULT false,
                                                 code character varying(500),
                                                 date_archivage date,
                                                 date_creation date,
                                                 description text,
                                                 libelle character varying(500),
                                                 username character varying(500),
                                                 visible boolean DEFAULT true
);


ALTER TABLE public.etablissement_partenaire OWNER TO postgres;

--
-- TOC entry 398 (class 1259 OID 91328)
-- Name: etablissement_partenaire_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.etablissement_partenaire_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etablissement_partenaire_seq OWNER TO postgres;

--
-- TOC entry 399 (class 1259 OID 91329)
-- Name: etablissement_projet; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etablissement_projet (
                                             id bigint NOT NULL,
                                             admin boolean DEFAULT false,
                                             anciens_nom character varying(500),
                                             archive boolean DEFAULT false,
                                             champ_intervention character varying(500),
                                             code character varying(500),
                                             date_archivage date,
                                             date_creation date,
                                             description text,
                                             libelle character varying(500),
                                             nom_en_francais character varying(500),
                                             sigle_en_francais character varying(500),
                                             sigle_officiel character varying(500),
                                             username character varying(500),
                                             valide boolean DEFAULT false,
                                             visible boolean DEFAULT true,
                                             pays_id bigint,
                                             ville_id bigint
);


ALTER TABLE public.etablissement_projet OWNER TO postgres;

--
-- TOC entry 400 (class 1259 OID 91338)
-- Name: etablissement_projet_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.etablissement_projet_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etablissement_projet_seq OWNER TO postgres;

--
-- TOC entry 401 (class 1259 OID 91339)
-- Name: etablissement_rencontre_grand_publique_jeune_publique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etablissement_rencontre_grand_publique_jeune_publique (
                                                                              id bigint NOT NULL,
                                                                              etablissement_id bigint,
                                                                              rencontre_grand_publique_jeune_publique_id bigint
);


ALTER TABLE public.etablissement_rencontre_grand_publique_jeune_publique OWNER TO postgres;

--
-- TOC entry 402 (class 1259 OID 91342)
-- Name: etablissement_rencontre_grand_publique_jeune_publique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.etablissement_rencontre_grand_publique_jeune_publique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etablissement_rencontre_grand_publique_jeune_publique_seq OWNER TO postgres;

--
-- TOC entry 403 (class 1259 OID 91343)
-- Name: etablissement_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.etablissement_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etablissement_seq OWNER TO postgres;

--
-- TOC entry 404 (class 1259 OID 91344)
-- Name: etablissements_inconnus; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etablissements_inconnus (
                                                "NOM" character varying(255),
                                                "CODE_ETAB" character varying(255)
);


ALTER TABLE public.etablissements_inconnus OWNER TO postgres;

--
-- TOC entry 405 (class 1259 OID 91349)
-- Name: etat_campagne; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etat_campagne (
                                      id bigint NOT NULL,
                                      admin boolean DEFAULT false,
                                      archive boolean DEFAULT false,
                                      code character varying(500),
                                      date_archivage date,
                                      date_creation date,
                                      libelle character varying(500),
                                      ordre integer,
                                      username character varying(500),
                                      visible boolean DEFAULT true
);


ALTER TABLE public.etat_campagne OWNER TO postgres;

--
-- TOC entry 406 (class 1259 OID 91357)
-- Name: etat_campagne_chercheur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etat_campagne_chercheur (
                                                id bigint NOT NULL,
                                                code character varying(500),
                                                libelle character varying(500),
                                                ordre integer
);


ALTER TABLE public.etat_campagne_chercheur OWNER TO postgres;

--
-- TOC entry 407 (class 1259 OID 91362)
-- Name: etat_campagne_chercheur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.etat_campagne_chercheur_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etat_campagne_chercheur_seq OWNER TO postgres;

--
-- TOC entry 408 (class 1259 OID 91363)
-- Name: etat_campagne_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.etat_campagne_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etat_campagne_seq OWNER TO postgres;

--
-- TOC entry 409 (class 1259 OID 91364)
-- Name: etat_etape_campagne; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etat_etape_campagne (
                                            id bigint NOT NULL,
                                            code character varying(500),
                                            libelle character varying(500),
                                            ordre integer
);


ALTER TABLE public.etat_etape_campagne OWNER TO postgres;

--
-- TOC entry 410 (class 1259 OID 91369)
-- Name: etat_etape_campagne_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.etat_etape_campagne_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etat_etape_campagne_seq OWNER TO postgres;

--
-- TOC entry 411 (class 1259 OID 91370)
-- Name: etat_reclamation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etat_reclamation (
                                         id bigint NOT NULL,
                                         code character varying(500),
                                         libelle character varying(500),
                                         ordre integer
);


ALTER TABLE public.etat_reclamation OWNER TO postgres;

--
-- TOC entry 412 (class 1259 OID 91375)
-- Name: etat_reclamation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.etat_reclamation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etat_reclamation_seq OWNER TO postgres;

--
-- TOC entry 413 (class 1259 OID 91376)
-- Name: etudiant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etudiant (
                                 id bigint NOT NULL,
                                 admin boolean DEFAULT false,
                                 annee_naissance bigint,
                                 archive boolean DEFAULT false,
                                 date_archivage date,
                                 date_creation date,
                                 nom character varying(500),
                                 prenom character varying(500),
                                 username character varying(500),
                                 visible boolean DEFAULT true,
                                 pays_id bigint,
                                 sexe_id bigint
);


ALTER TABLE public.etudiant OWNER TO postgres;

--
-- TOC entry 414 (class 1259 OID 91384)
-- Name: etudiant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.etudiant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etudiant_seq OWNER TO postgres;

--
-- TOC entry 415 (class 1259 OID 91385)
-- Name: evaluation_encadrement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.evaluation_encadrement (
                                               id bigint NOT NULL,
                                               code character varying(255),
                                               libelle character varying(255)
);


ALTER TABLE public.evaluation_encadrement OWNER TO postgres;

--
-- TOC entry 416 (class 1259 OID 91390)
-- Name: evaluation_recherche_universitaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.evaluation_recherche_universitaire (
                                                           id bigint NOT NULL,
                                                           annee integer,
                                                           commentaire character varying(255),
                                                           nombre_jour_consacre_pour_cette_annee numeric(19,2),
                                                           campagne_id bigint,
                                                           chercheur_id bigint,
                                                           etablissement_id bigint,
                                                           etat_etape_campagne_id bigint,
                                                           pays_id bigint,
                                                           role_evaluation_recherche_universitaire_id bigint,
                                                           type_expert_id bigint
);


ALTER TABLE public.evaluation_recherche_universitaire OWNER TO postgres;

--
-- TOC entry 417 (class 1259 OID 91393)
-- Name: evenement_colloque_scienntifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.evenement_colloque_scienntifique (
                                                         id bigint NOT NULL,
                                                         date_evenement date,
                                                         diplomatie_stategique boolean DEFAULT false,
                                                         intitule character varying(500),
                                                         type_de_participation character varying(500),
                                                         volume_participant numeric(19,2),
                                                         etat_etape_campagne_id bigint,
                                                         modalite_id bigint,
                                                         modalite_intervention_id bigint,
                                                         savoir_et_innovation_id bigint,
                                                         campagne_id bigint
);


ALTER TABLE public.evenement_colloque_scienntifique OWNER TO postgres;

--
-- TOC entry 418 (class 1259 OID 91399)
-- Name: evenement_colloque_scienntifique_enjeux_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.evenement_colloque_scienntifique_enjeux_ird (
                                                                    id bigint NOT NULL,
                                                                    enjeux_ird_id bigint,
                                                                    evenement_colloque_scienntifique_id bigint
);


ALTER TABLE public.evenement_colloque_scienntifique_enjeux_ird OWNER TO postgres;

--
-- TOC entry 419 (class 1259 OID 91402)
-- Name: evenement_colloque_scienntifique_enjeux_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.evenement_colloque_scienntifique_enjeux_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.evenement_colloque_scienntifique_enjeux_ird_seq OWNER TO postgres;

--
-- TOC entry 420 (class 1259 OID 91403)
-- Name: evenement_colloque_scienntifique_pays; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.evenement_colloque_scienntifique_pays (
                                                              id bigint NOT NULL,
                                                              evenement_colloque_scienntifique_id bigint,
                                                              pays_id bigint
);


ALTER TABLE public.evenement_colloque_scienntifique_pays OWNER TO postgres;

--
-- TOC entry 421 (class 1259 OID 91406)
-- Name: evenement_colloque_scienntifique_pays_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.evenement_colloque_scienntifique_pays_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.evenement_colloque_scienntifique_pays_seq OWNER TO postgres;

--
-- TOC entry 422 (class 1259 OID 91407)
-- Name: evenement_colloque_scienntifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.evenement_colloque_scienntifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.evenement_colloque_scienntifique_seq OWNER TO postgres;

--
-- TOC entry 423 (class 1259 OID 91408)
-- Name: evenement_colloque_scientifique_instrument_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.evenement_colloque_scientifique_instrument_ird (
                                                                       id bigint NOT NULL,
                                                                       evenement_colloque_scienntifique_id bigint,
                                                                       instrument_ird_id bigint
);


ALTER TABLE public.evenement_colloque_scientifique_instrument_ird OWNER TO postgres;

--
-- TOC entry 424 (class 1259 OID 91411)
-- Name: evenement_colloque_scientifique_instrument_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.evenement_colloque_scientifique_instrument_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.evenement_colloque_scientifique_instrument_ird_seq OWNER TO postgres;

--
-- TOC entry 425 (class 1259 OID 91412)
-- Name: expertise; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.expertise (
                                  id bigint NOT NULL,
                                  annee bigint,
                                  temps_estime_pour_cette_annne numeric(19,2),
                                  campagne_id bigint,
                                  chercheur_id bigint,
                                  etat_etape_campagne_id bigint
);


ALTER TABLE public.expertise OWNER TO postgres;

--
-- TOC entry 426 (class 1259 OID 91415)
-- Name: expertise_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.expertise_scientifique (
                                               id bigint NOT NULL,
                                               annee bigint,
                                               commentaires_eventuels text,
                                               intitule character varying(500),
                                               nombre_jour_consacre_pour_cette_annee numeric(19,2),
                                               periode_remise_rapport_annee integer,
                                               periode_remise_rapport_mois integer,
                                               campagne_id bigint,
                                               chercheur_id bigint,
                                               etablissement_id bigint,
                                               etat_etape_campagne_id bigint,
                                               pays_id bigint,
                                               type_expertise_id bigint
);


ALTER TABLE public.expertise_scientifique OWNER TO postgres;

--
-- TOC entry 427 (class 1259 OID 91420)
-- Name: expertise_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.expertise_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.expertise_scientifique_seq OWNER TO postgres;

--
-- TOC entry 428 (class 1259 OID 91421)
-- Name: expertise_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.expertise_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.expertise_seq OWNER TO postgres;

--
-- TOC entry 429 (class 1259 OID 91422)
-- Name: faq; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.faq (
                            id bigint NOT NULL,
                            archive boolean DEFAULT false,
                            contact character varying(500),
                            dernier_misajour date,
                            lien character varying(500),
                            ordre integer,
                            question character varying(500),
                            reponse text,
                            categorie_faq_id bigint
);


ALTER TABLE public.faq OWNER TO postgres;

--
-- TOC entry 430 (class 1259 OID 91428)
-- Name: faq_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.faq_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.faq_seq OWNER TO postgres;

--
-- TOC entry 431 (class 1259 OID 91429)
-- Name: financement_correction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.financement_correction (
                                               libelle_incorrect character varying(255),
                                               libelle_correct character varying(255)
);


ALTER TABLE public.financement_correction OWNER TO postgres;

--
-- TOC entry 432 (class 1259 OID 91434)
-- Name: financement_doctorant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.financement_doctorant (
                                              id bigint NOT NULL,
                                              admin boolean DEFAULT false,
                                              archive boolean DEFAULT false,
                                              code character varying(500),
                                              date_archivage date,
                                              date_creation date,
                                              libelle character varying(500),
                                              username character varying(500),
                                              visible boolean DEFAULT true
);


ALTER TABLE public.financement_doctorant OWNER TO postgres;

--
-- TOC entry 433 (class 1259 OID 91442)
-- Name: financement_doctorant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.financement_doctorant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.financement_doctorant_seq OWNER TO postgres;

--
-- TOC entry 434 (class 1259 OID 91443)
-- Name: financement_encadrement_doctorant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.financement_encadrement_doctorant (
                                                          id bigint NOT NULL,
                                                          encadrement_doctorant_id bigint,
                                                          financement_id bigint
);


ALTER TABLE public.financement_encadrement_doctorant OWNER TO postgres;

--
-- TOC entry 435 (class 1259 OID 91446)
-- Name: financement_encadrement_doctorant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.financement_encadrement_doctorant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.financement_encadrement_doctorant_seq OWNER TO postgres;

--
-- TOC entry 436 (class 1259 OID 91447)
-- Name: format_rencontre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.format_rencontre (
                                         id bigint NOT NULL,
                                         admin boolean DEFAULT false,
                                         archive boolean DEFAULT false,
                                         code character varying(500),
                                         date_archivage date,
                                         date_creation date,
                                         libelle character varying(500),
                                         username character varying(500),
                                         visible boolean DEFAULT true
);


ALTER TABLE public.format_rencontre OWNER TO postgres;

--
-- TOC entry 437 (class 1259 OID 91455)
-- Name: format_rencontre_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.format_rencontre_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.format_rencontre_seq OWNER TO postgres;

--
-- TOC entry 438 (class 1259 OID 91456)
-- Name: formation_continue; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.formation_continue (
                                           id bigint NOT NULL,
                                           intitule character varying(500),
                                           nombre_heures_dispensees_dans_annee numeric(19,2),
                                           enseignement_et_formation_id bigint,
                                           etat_etape_campagne_id bigint,
                                           modalite_formation_continue_id bigint,
                                           annee integer,
                                           intitule_exact character varying(255),
                                           temps_estime_pour_cette_annne numeric(19,2),
                                           campagne_id bigint,
                                           chercheur_id bigint,
                                           etablissement_id bigint,
                                           outil_formation_continue_id bigint,
                                           pays_id bigint
);


ALTER TABLE public.formation_continue OWNER TO postgres;

--
-- TOC entry 439 (class 1259 OID 91461)
-- Name: formation_continue_commanditaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.formation_continue_commanditaire (
                                                         id bigint NOT NULL,
                                                         commanditaire_id bigint,
                                                         formation_continue_id bigint,
                                                         pays_id bigint
);


ALTER TABLE public.formation_continue_commanditaire OWNER TO postgres;

--
-- TOC entry 440 (class 1259 OID 91464)
-- Name: formation_continue_commanditaire_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.formation_continue_commanditaire_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.formation_continue_commanditaire_seq OWNER TO postgres;

--
-- TOC entry 441 (class 1259 OID 91465)
-- Name: formation_continue_discipline_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.formation_continue_discipline_scientifique (
                                                                   id bigint NOT NULL,
                                                                   discipline_scientifique_id bigint,
                                                                   formation_continue_id bigint
);


ALTER TABLE public.formation_continue_discipline_scientifique OWNER TO postgres;

--
-- TOC entry 442 (class 1259 OID 91468)
-- Name: formation_continue_discipline_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.formation_continue_discipline_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.formation_continue_discipline_scientifique_seq OWNER TO postgres;

--
-- TOC entry 443 (class 1259 OID 91469)
-- Name: formation_continue_enjeux_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.formation_continue_enjeux_ird (
                                                      id bigint NOT NULL,
                                                      enjeux_ird_id bigint,
                                                      formation_continue_id bigint
);


ALTER TABLE public.formation_continue_enjeux_ird OWNER TO postgres;

--
-- TOC entry 444 (class 1259 OID 91472)
-- Name: formation_continue_enjeux_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.formation_continue_enjeux_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.formation_continue_enjeux_ird_seq OWNER TO postgres;

--
-- TOC entry 445 (class 1259 OID 91473)
-- Name: formation_continue_objet_formation_generique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.formation_continue_objet_formation_generique (
                                                                     id bigint NOT NULL,
                                                                     formation_continue_id bigint,
                                                                     objet_formation_generique_id bigint
);


ALTER TABLE public.formation_continue_objet_formation_generique OWNER TO postgres;

--
-- TOC entry 446 (class 1259 OID 91476)
-- Name: formation_continue_objet_formation_generique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.formation_continue_objet_formation_generique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.formation_continue_objet_formation_generique_seq OWNER TO postgres;

--
-- TOC entry 447 (class 1259 OID 91477)
-- Name: formation_continue_publique_professionel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.formation_continue_publique_professionel (
                                                                 id bigint NOT NULL,
                                                                 formation_continue_id bigint,
                                                                 publique_professionel_id bigint
);


ALTER TABLE public.formation_continue_publique_professionel OWNER TO postgres;

--
-- TOC entry 448 (class 1259 OID 91480)
-- Name: formation_continue_publique_professionel_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.formation_continue_publique_professionel_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.formation_continue_publique_professionel_seq OWNER TO postgres;

--
-- TOC entry 449 (class 1259 OID 91481)
-- Name: formation_continue_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.formation_continue_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.formation_continue_seq OWNER TO postgres;

--
-- TOC entry 450 (class 1259 OID 91482)
-- Name: fournisseur_appel_projet_recherche; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fournisseur_appel_projet_recherche (
                                                           id bigint NOT NULL,
                                                           admin boolean DEFAULT false,
                                                           archive boolean DEFAULT false,
                                                           code character varying(500),
                                                           date_archivage date,
                                                           date_creation date,
                                                           description text,
                                                           libelle character varying(500),
                                                           username character varying(500),
                                                           visible boolean DEFAULT true,
                                                           pays_id bigint
);


ALTER TABLE public.fournisseur_appel_projet_recherche OWNER TO postgres;

--
-- TOC entry 451 (class 1259 OID 91490)
-- Name: fournisseur_appel_projet_recherche_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.fournisseur_appel_projet_recherche_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.fournisseur_appel_projet_recherche_seq OWNER TO postgres;

--
-- TOC entry 452 (class 1259 OID 91491)
-- Name: gestion_equipe; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.gestion_equipe (
                                       id bigint NOT NULL,
                                       temps_estime_pour_cette_annne numeric(19,2),
                                       campagne_id bigint,
                                       chercheur_id bigint,
                                       etat_etape_campagne_id bigint,
                                       annee bigint
);


ALTER TABLE public.gestion_equipe OWNER TO postgres;

--
-- TOC entry 453 (class 1259 OID 91494)
-- Name: gestion_equipe_detail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.gestion_equipe_detail (
                                              id bigint NOT NULL,
                                              formation_management boolean DEFAULT false,
                                              nombre_personne_encadre integer,
                                              nombre_personne_hors_ird integer,
                                              nombre_personne_sous_conventions integer,
                                              gestion_equipe_id bigint,
                                              etat_etape_campagne_id bigint
);


ALTER TABLE public.gestion_equipe_detail OWNER TO postgres;

--
-- TOC entry 454 (class 1259 OID 91498)
-- Name: gestion_equipe_detail_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.gestion_equipe_detail_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.gestion_equipe_detail_seq OWNER TO postgres;

--
-- TOC entry 455 (class 1259 OID 91499)
-- Name: gestion_equipe_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.gestion_equipe_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.gestion_equipe_seq OWNER TO postgres;

--
-- TOC entry 456 (class 1259 OID 91500)
-- Name: grade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.grade (
                              id bigint NOT NULL,
                              admin boolean DEFAULT false,
                              archive boolean DEFAULT false,
                              code character varying(500),
                              date_archivage date,
                              date_creation date,
                              description text,
                              libelle character varying(500),
                              username character varying(500),
                              visible boolean DEFAULT true,
                              id_graph character varying(255)
);


ALTER TABLE public.grade OWNER TO postgres;

--
-- TOC entry 457 (class 1259 OID 91508)
-- Name: grade_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.grade_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.grade_seq OWNER TO postgres;

--
-- TOC entry 458 (class 1259 OID 91509)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 459 (class 1259 OID 91510)
-- Name: identifiant_auteur_expert; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.identifiant_auteur_expert (
                                                  id bigint NOT NULL,
                                                  valeur character varying(500),
                                                  chercheur_id bigint,
                                                  identifiant_recherche_id bigint
);


ALTER TABLE public.identifiant_auteur_expert OWNER TO postgres;

--
-- TOC entry 460 (class 1259 OID 91515)
-- Name: identifiant_auteur_expert_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.identifiant_auteur_expert_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.identifiant_auteur_expert_seq OWNER TO postgres;

--
-- TOC entry 461 (class 1259 OID 91516)
-- Name: identifiant_recherche; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.identifiant_recherche (
                                              id bigint NOT NULL,
                                              admin boolean DEFAULT false,
                                              archive boolean DEFAULT false,
                                              code character varying(500),
                                              date_archivage date,
                                              date_creation date,
                                              description text,
                                              libelle character varying(500),
                                              username character varying(500),
                                              visible boolean DEFAULT true
);


ALTER TABLE public.identifiant_recherche OWNER TO postgres;

--
-- TOC entry 462 (class 1259 OID 91524)
-- Name: identifiant_recherche_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.identifiant_recherche_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.identifiant_recherche_seq OWNER TO postgres;

--
-- TOC entry 463 (class 1259 OID 91525)
-- Name: institution; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.institution (
                                    id bigint NOT NULL,
                                    admin boolean DEFAULT false,
                                    archive boolean DEFAULT false,
                                    code character varying(500),
                                    date_archivage date,
                                    date_creation date,
                                    libelle character varying(500),
                                    username character varying(500),
                                    visible boolean DEFAULT true
);


ALTER TABLE public.institution OWNER TO postgres;

--
-- TOC entry 464 (class 1259 OID 91533)
-- Name: institution_co_contractant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.institution_co_contractant (
                                                   id bigint NOT NULL,
                                                   chercheur_id bigint,
                                                   institution_id bigint
);


ALTER TABLE public.institution_co_contractant OWNER TO postgres;

--
-- TOC entry 465 (class 1259 OID 91536)
-- Name: institution_co_contractant_projet_activite_recherche; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.institution_co_contractant_projet_activite_recherche (
                                                                             id bigint NOT NULL,
                                                                             institution_co_contractant_id bigint,
                                                                             projet_activite_recherche_id bigint
);


ALTER TABLE public.institution_co_contractant_projet_activite_recherche OWNER TO postgres;

--
-- TOC entry 466 (class 1259 OID 91539)
-- Name: institution_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.institution_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.institution_seq OWNER TO postgres;

--
-- TOC entry 467 (class 1259 OID 91540)
-- Name: instrument_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.instrument_ird (
                                       id bigint NOT NULL,
                                       admin boolean DEFAULT false,
                                       archive boolean DEFAULT false,
                                       code character varying(500),
                                       date_archivage date,
                                       date_creation date,
                                       libelle character varying(500),
                                       username character varying(500),
                                       visible boolean DEFAULT true,
                                       type_instrument_ird_id bigint
);


ALTER TABLE public.instrument_ird OWNER TO postgres;

--
-- TOC entry 468 (class 1259 OID 91548)
-- Name: instrument_ird_chercheur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.instrument_ird_chercheur (
                                                 id bigint NOT NULL,
                                                 nature_implication character varying(500),
                                                 chercheur_id bigint,
                                                 instrument_ird_id bigint
);


ALTER TABLE public.instrument_ird_chercheur OWNER TO postgres;

--
-- TOC entry 469 (class 1259 OID 91553)
-- Name: instrument_ird_chercheur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.instrument_ird_chercheur_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.instrument_ird_chercheur_seq OWNER TO postgres;

--
-- TOC entry 470 (class 1259 OID 91554)
-- Name: instrument_ird_comite_et_commission_evaluation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.instrument_ird_comite_et_commission_evaluation (
                                                                       id bigint NOT NULL,
                                                                       comite_et_commission_evaluation_id bigint,
                                                                       instrument_ird_id bigint,
                                                                       type_instrument_ird_id bigint
);


ALTER TABLE public.instrument_ird_comite_et_commission_evaluation OWNER TO postgres;

--
-- TOC entry 471 (class 1259 OID 91557)
-- Name: instrument_ird_comite_et_commission_evaluation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.instrument_ird_comite_et_commission_evaluation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.instrument_ird_comite_et_commission_evaluation_seq OWNER TO postgres;

--
-- TOC entry 472 (class 1259 OID 91558)
-- Name: instrument_ird_consultance_scientifique_ponctuelle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.instrument_ird_consultance_scientifique_ponctuelle (
                                                                           id bigint NOT NULL,
                                                                           existe boolean DEFAULT false,
                                                                           consultance_scientifique_ponctuelle_id bigint,
                                                                           instrument_ird_id bigint
);


ALTER TABLE public.instrument_ird_consultance_scientifique_ponctuelle OWNER TO postgres;

--
-- TOC entry 473 (class 1259 OID 91562)
-- Name: instrument_ird_consultance_scientifique_ponctuelle_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.instrument_ird_consultance_scientifique_ponctuelle_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.instrument_ird_consultance_scientifique_ponctuelle_seq OWNER TO postgres;

--
-- TOC entry 474 (class 1259 OID 91563)
-- Name: instrument_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.instrument_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.instrument_ird_seq OWNER TO postgres;

--
-- TOC entry 475 (class 1259 OID 91564)
-- Name: instruments_et_dispositifs_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.instruments_et_dispositifs_ird (
                                                       id bigint NOT NULL,
                                                       code character varying(500),
                                                       description text,
                                                       libelle character varying(500),
                                                       numerique boolean DEFAULT false,
                                                       campagne_id bigint,
                                                       chercheur_id bigint
);


ALTER TABLE public.instruments_et_dispositifs_ird OWNER TO postgres;

--
-- TOC entry 476 (class 1259 OID 91570)
-- Name: instruments_et_dispositifs_ird_chercheur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.instruments_et_dispositifs_ird_chercheur (
                                                                 id bigint NOT NULL,
                                                                 chercheur_id bigint,
                                                                 type_instruments_et_dispositifs_ird_id bigint
);


ALTER TABLE public.instruments_et_dispositifs_ird_chercheur OWNER TO postgres;

--
-- TOC entry 477 (class 1259 OID 91573)
-- Name: instruments_et_dispositifs_ird_projet_activite_recherche; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.instruments_et_dispositifs_ird_projet_activite_recherche (
                                                                                 id bigint NOT NULL,
                                                                                 instruments_et_dispositifs_ird_id bigint,
                                                                                 projet_activite_recherche_id bigint
);


ALTER TABLE public.instruments_et_dispositifs_ird_projet_activite_recherche OWNER TO postgres;

--
-- TOC entry 478 (class 1259 OID 91576)
-- Name: instruments_et_dispositifs_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.instruments_et_dispositifs_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.instruments_et_dispositifs_ird_seq OWNER TO postgres;

--
-- TOC entry 479 (class 1259 OID 91577)
-- Name: key_word; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.key_word (
                                 id bigint NOT NULL,
                                 code character varying(500),
                                 libelle_eng character varying(500),
                                 libelle_fr character varying(500)
);


ALTER TABLE public.key_word OWNER TO postgres;

--
-- TOC entry 480 (class 1259 OID 91582)
-- Name: key_word_discipline_scientifique_erc; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.key_word_discipline_scientifique_erc (
                                                             id bigint NOT NULL,
                                                             discipline_scientifique_erc_id bigint,
                                                             key_word_id bigint
);


ALTER TABLE public.key_word_discipline_scientifique_erc OWNER TO postgres;

--
-- TOC entry 481 (class 1259 OID 91585)
-- Name: key_word_discipline_scientifique_erc_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.key_word_discipline_scientifique_erc_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.key_word_discipline_scientifique_erc_seq OWNER TO postgres;

--
-- TOC entry 482 (class 1259 OID 91586)
-- Name: key_word_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.key_word_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.key_word_seq OWNER TO postgres;

--
-- TOC entry 483 (class 1259 OID 91587)
-- Name: langue; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.langue (
                               id bigint NOT NULL,
                               code character varying(500),
                               libelle character varying(500)
);


ALTER TABLE public.langue OWNER TO postgres;

--
-- TOC entry 484 (class 1259 OID 91592)
-- Name: langue_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.langue_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.langue_seq OWNER TO postgres;

--
-- TOC entry 485 (class 1259 OID 91593)
-- Name: master; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.master (
                               id bigint NOT NULL,
                               code character varying(255),
                               international boolean,
                               intitule character varying(255),
                               pays_id bigint
);


ALTER TABLE public.master OWNER TO postgres;

--
-- TOC entry 486 (class 1259 OID 91598)
-- Name: master_international; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.master_international (
                                             id bigint NOT NULL,
                                             admin boolean DEFAULT false,
                                             archive boolean DEFAULT false,
                                             code character varying(500),
                                             date_archivage date,
                                             date_creation date,
                                             libelle character varying(500),
                                             username character varying(500),
                                             visible boolean DEFAULT true
);


ALTER TABLE public.master_international OWNER TO postgres;

--
-- TOC entry 487 (class 1259 OID 91606)
-- Name: master_international_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.master_international_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.master_international_seq OWNER TO postgres;

--
-- TOC entry 488 (class 1259 OID 91607)
-- Name: modalite; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.modalite (
                                 id bigint NOT NULL,
                                 admin boolean DEFAULT false,
                                 archive boolean DEFAULT false,
                                 code character varying(500),
                                 date_archivage date,
                                 date_creation date,
                                 libelle character varying(500),
                                 username character varying(500),
                                 visible boolean DEFAULT true
);


ALTER TABLE public.modalite OWNER TO postgres;

--
-- TOC entry 489 (class 1259 OID 91615)
-- Name: modalite_etude; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.modalite_etude (
                                       id bigint NOT NULL,
                                       admin boolean DEFAULT false,
                                       archive boolean DEFAULT false,
                                       code character varying(500),
                                       date_archivage date,
                                       date_creation date,
                                       description text,
                                       libelle character varying(500),
                                       username character varying(500),
                                       visible boolean DEFAULT true
);


ALTER TABLE public.modalite_etude OWNER TO postgres;

--
-- TOC entry 490 (class 1259 OID 91623)
-- Name: modalite_etude_enseignement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.modalite_etude_enseignement (
                                                    id bigint NOT NULL,
                                                    enseignement_id bigint,
                                                    modalite_etude_id bigint
);


ALTER TABLE public.modalite_etude_enseignement OWNER TO postgres;

--
-- TOC entry 491 (class 1259 OID 91626)
-- Name: modalite_etude_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.modalite_etude_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.modalite_etude_seq OWNER TO postgres;

--
-- TOC entry 492 (class 1259 OID 91627)
-- Name: modalite_formation_continue; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.modalite_formation_continue (
                                                    id bigint NOT NULL,
                                                    admin boolean DEFAULT false,
                                                    archive boolean DEFAULT false,
                                                    code character varying(500),
                                                    date_archivage date,
                                                    date_creation date,
                                                    libelle character varying(500),
                                                    username character varying(500),
                                                    visible boolean DEFAULT true
);


ALTER TABLE public.modalite_formation_continue OWNER TO postgres;

--
-- TOC entry 493 (class 1259 OID 91635)
-- Name: modalite_formation_continue_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.modalite_formation_continue_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.modalite_formation_continue_seq OWNER TO postgres;

--
-- TOC entry 494 (class 1259 OID 91636)
-- Name: modalite_intervention; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.modalite_intervention (
                                              id bigint NOT NULL,
                                              admin boolean DEFAULT false,
                                              archive boolean DEFAULT false,
                                              code character varying(500),
                                              date_archivage date,
                                              date_creation date,
                                              description text,
                                              libelle character varying(500),
                                              username character varying(500),
                                              visible boolean DEFAULT true
);


ALTER TABLE public.modalite_intervention OWNER TO postgres;

--
-- TOC entry 495 (class 1259 OID 91644)
-- Name: modalite_intervention_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.modalite_intervention_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.modalite_intervention_seq OWNER TO postgres;

--
-- TOC entry 496 (class 1259 OID 91645)
-- Name: modalite_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.modalite_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.modalite_seq OWNER TO postgres;

--
-- TOC entry 497 (class 1259 OID 91646)
-- Name: mode_diffusion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mode_diffusion (
                                       id bigint NOT NULL,
                                       admin boolean DEFAULT false,
                                       archive boolean DEFAULT false,
                                       code character varying(500),
                                       date_archivage date,
                                       date_creation date,
                                       libelle character varying(500),
                                       username character varying(500),
                                       visible boolean DEFAULT true,
                                       type_savoir_id bigint
);


ALTER TABLE public.mode_diffusion OWNER TO postgres;

--
-- TOC entry 498 (class 1259 OID 91654)
-- Name: mode_diffusion_developpement_de_savoir_et_innovation_scientifiq; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mode_diffusion_developpement_de_savoir_et_innovation_scientifiq (
                                                                                        id bigint NOT NULL,
                                                                                        developpement_de_savoir_et_innovation_scientifique_id bigint,
                                                                                        mode_diffusion_id bigint
);


ALTER TABLE public.mode_diffusion_developpement_de_savoir_et_innovation_scientifiq OWNER TO postgres;

--
-- TOC entry 499 (class 1259 OID 91657)
-- Name: mode_diffusion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.mode_diffusion_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.mode_diffusion_seq OWNER TO postgres;

--
-- TOC entry 500 (class 1259 OID 91658)
-- Name: nationalite; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nationalite (
                                    id bigint NOT NULL,
                                    admin boolean DEFAULT false,
                                    archive boolean DEFAULT false,
                                    code character varying(500),
                                    date_archivage date,
                                    date_creation date,
                                    libelle character varying(500),
                                    username character varying(500),
                                    visible boolean DEFAULT true
);


ALTER TABLE public.nationalite OWNER TO postgres;

--
-- TOC entry 501 (class 1259 OID 91666)
-- Name: nationalite_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nationalite_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nationalite_seq OWNER TO postgres;

--
-- TOC entry 502 (class 1259 OID 91667)
-- Name: nature_activite_grand_publique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nature_activite_grand_publique (
                                                       id bigint NOT NULL,
                                                       code character varying(500),
                                                       libelle character varying(500)
);


ALTER TABLE public.nature_activite_grand_publique OWNER TO postgres;

--
-- TOC entry 503 (class 1259 OID 91672)
-- Name: nature_activite_grand_publique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nature_activite_grand_publique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nature_activite_grand_publique_seq OWNER TO postgres;

--
-- TOC entry 504 (class 1259 OID 91673)
-- Name: nature_enseignement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nature_enseignement (
                                            id bigint NOT NULL,
                                            admin boolean DEFAULT false,
                                            archive boolean DEFAULT false,
                                            code character varying(500),
                                            date_archivage date,
                                            date_creation date,
                                            description text,
                                            libelle character varying(500),
                                            username character varying(500),
                                            visible boolean DEFAULT true,
                                            enseignement_id bigint,
                                            nature_etude_id bigint
);


ALTER TABLE public.nature_enseignement OWNER TO postgres;

--
-- TOC entry 505 (class 1259 OID 91681)
-- Name: nature_enseignement_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nature_enseignement_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nature_enseignement_seq OWNER TO postgres;

--
-- TOC entry 506 (class 1259 OID 91682)
-- Name: nature_etude; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nature_etude (
                                     id bigint NOT NULL,
                                     admin boolean DEFAULT false,
                                     archive boolean DEFAULT false,
                                     code character varying(500),
                                     date_archivage date,
                                     date_creation date,
                                     libelle character varying(500),
                                     username character varying(500),
                                     visible boolean DEFAULT true
);


ALTER TABLE public.nature_etude OWNER TO postgres;

--
-- TOC entry 507 (class 1259 OID 91690)
-- Name: nature_etude_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nature_etude_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nature_etude_seq OWNER TO postgres;

--
-- TOC entry 508 (class 1259 OID 91691)
-- Name: nature_expertise; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nature_expertise (
                                         id bigint NOT NULL,
                                         admin boolean DEFAULT false,
                                         archive boolean DEFAULT false,
                                         code character varying(500),
                                         date_archivage date,
                                         date_creation date,
                                         description text,
                                         libelle character varying(500),
                                         username character varying(500),
                                         visible boolean DEFAULT true
);


ALTER TABLE public.nature_expertise OWNER TO postgres;

--
-- TOC entry 509 (class 1259 OID 91699)
-- Name: nature_expertise_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nature_expertise_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nature_expertise_seq OWNER TO postgres;

--
-- TOC entry 510 (class 1259 OID 91700)
-- Name: niveau_etude; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.niveau_etude (
                                     id bigint NOT NULL,
                                     admin boolean DEFAULT false,
                                     archive boolean DEFAULT false,
                                     code character varying(500),
                                     date_archivage date,
                                     date_creation date,
                                     libelle character varying(500),
                                     username character varying(500),
                                     visible boolean DEFAULT true
);


ALTER TABLE public.niveau_etude OWNER TO postgres;

--
-- TOC entry 511 (class 1259 OID 91708)
-- Name: niveau_etude_enseignement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.niveau_etude_enseignement (
                                                  id bigint NOT NULL,
                                                  enseignement_id bigint,
                                                  niveau_etude_id bigint
);


ALTER TABLE public.niveau_etude_enseignement OWNER TO postgres;

--
-- TOC entry 512 (class 1259 OID 91711)
-- Name: niveau_etude_enseignement_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.niveau_etude_enseignement_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.niveau_etude_enseignement_seq OWNER TO postgres;

--
-- TOC entry 513 (class 1259 OID 91712)
-- Name: niveau_etude_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.niveau_etude_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.niveau_etude_seq OWNER TO postgres;

--
-- TOC entry 514 (class 1259 OID 91713)
-- Name: niveau_formation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.niveau_formation (
                                         id bigint NOT NULL,
                                         admin boolean DEFAULT false,
                                         archive boolean DEFAULT false,
                                         code character varying(500),
                                         date_archivage date,
                                         date_creation date,
                                         libelle_macro character varying(500),
                                         libelle_micro character varying(500),
                                         username character varying(500),
                                         visible boolean DEFAULT true,
                                         libelle character varying(255)
);


ALTER TABLE public.niveau_formation OWNER TO postgres;

--
-- TOC entry 515 (class 1259 OID 91721)
-- Name: niveau_formation_post_bac; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.niveau_formation_post_bac (
                                                  id bigint NOT NULL,
                                                  admin boolean DEFAULT false,
                                                  archive boolean DEFAULT false,
                                                  code character varying(500),
                                                  date_archivage date,
                                                  date_creation date,
                                                  libelle character varying(500),
                                                  username character varying(500),
                                                  visible boolean DEFAULT true
);


ALTER TABLE public.niveau_formation_post_bac OWNER TO postgres;

--
-- TOC entry 516 (class 1259 OID 91729)
-- Name: niveau_formation_post_bac_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.niveau_formation_post_bac_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.niveau_formation_post_bac_seq OWNER TO postgres;

--
-- TOC entry 517 (class 1259 OID 91730)
-- Name: niveau_formation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.niveau_formation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.niveau_formation_seq OWNER TO postgres;

--
-- TOC entry 518 (class 1259 OID 91731)
-- Name: niveau_responsabilite_pedagogique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.niveau_responsabilite_pedagogique (
                                                          id bigint NOT NULL,
                                                          code character varying(500),
                                                          libelle character varying(500)
);


ALTER TABLE public.niveau_responsabilite_pedagogique OWNER TO postgres;

--
-- TOC entry 519 (class 1259 OID 91736)
-- Name: niveau_responsabilite_pedagogique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.niveau_responsabilite_pedagogique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.niveau_responsabilite_pedagogique_seq OWNER TO postgres;

--
-- TOC entry 520 (class 1259 OID 91737)
-- Name: notification; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.notification (
                                     id bigint NOT NULL,
                                     date_lecture date,
                                     date_notification date,
                                     description text,
                                     libelle character varying(500),
                                     vu boolean DEFAULT false,
                                     categorie_notification_id bigint,
                                     chercheur_id bigint
);


ALTER TABLE public.notification OWNER TO postgres;

--
-- TOC entry 521 (class 1259 OID 91743)
-- Name: notification_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.notification_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.notification_seq OWNER TO postgres;

--
-- TOC entry 522 (class 1259 OID 91744)
-- Name: objet_formation_generique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.objet_formation_generique (
                                                  id bigint NOT NULL,
                                                  admin boolean DEFAULT false,
                                                  archive boolean DEFAULT false,
                                                  code character varying(500),
                                                  date_archivage date,
                                                  date_creation date,
                                                  libelle character varying(500),
                                                  username character varying(500),
                                                  visible boolean DEFAULT true
);


ALTER TABLE public.objet_formation_generique OWNER TO postgres;

--
-- TOC entry 523 (class 1259 OID 91752)
-- Name: objet_formation_generique_de_responsabilite_pedagogique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.objet_formation_generique_de_responsabilite_pedagogique (
                                                                                id bigint NOT NULL,
                                                                                objet_formation_generique_id bigint,
                                                                                responsabilite_pedagogique_id bigint
);


ALTER TABLE public.objet_formation_generique_de_responsabilite_pedagogique OWNER TO postgres;

--
-- TOC entry 524 (class 1259 OID 91755)
-- Name: objet_formation_generique_de_responsabilite_pedagogique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.objet_formation_generique_de_responsabilite_pedagogique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.objet_formation_generique_de_responsabilite_pedagogique_seq OWNER TO postgres;

--
-- TOC entry 525 (class 1259 OID 91756)
-- Name: objet_formation_generique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.objet_formation_generique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.objet_formation_generique_seq OWNER TO postgres;

--
-- TOC entry 526 (class 1259 OID 91757)
-- Name: objet_global; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.objet_global (
                                     id bigint NOT NULL,
                                     code character varying(255),
                                     libelle character varying(255)
);


ALTER TABLE public.objet_global OWNER TO postgres;

--
-- TOC entry 527 (class 1259 OID 91762)
-- Name: objet_global_de_formation_continue; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.objet_global_de_formation_continue (
                                                           id bigint NOT NULL,
                                                           formation_continue_id bigint,
                                                           objet_global_id bigint
);


ALTER TABLE public.objet_global_de_formation_continue OWNER TO postgres;

--
-- TOC entry 528 (class 1259 OID 91765)
-- Name: objet_global_formation_continue; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.objet_global_formation_continue (
                                                        id bigint NOT NULL,
                                                        formation_continue_id bigint,
                                                        objet_global_id bigint
);


ALTER TABLE public.objet_global_formation_continue OWNER TO postgres;

--
-- TOC entry 529 (class 1259 OID 91768)
-- Name: organisme; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.organisme (
                                  id bigint NOT NULL,
                                  code character varying(255),
                                  description text,
                                  intitule character varying(255),
                                  pays_id bigint
);


ALTER TABLE public.organisme OWNER TO postgres;

--
-- TOC entry 530 (class 1259 OID 91773)
-- Name: outil_formation_continue; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.outil_formation_continue (
                                                 id bigint NOT NULL,
                                                 code character varying(255),
                                                 libelle character varying(255)
);


ALTER TABLE public.outil_formation_continue OWNER TO postgres;

--
-- TOC entry 531 (class 1259 OID 91778)
-- Name: outil_pedagogique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.outil_pedagogique (
                                          id bigint NOT NULL,
                                          date_diffusion date,
                                          disponnible_numerique boolean DEFAULT false,
                                          lien_instrument_ird boolean DEFAULT false,
                                          lien_web character varying(500),
                                          nom character varying(500),
                                          partenaire_eventuel character varying(500),
                                          remarque text,
                                          role_outil_pedagogique character varying(500),
                                          culture_scientifique_id bigint,
                                          etat_etape_campagne_id bigint
);


ALTER TABLE public.outil_pedagogique OWNER TO postgres;

--
-- TOC entry 532 (class 1259 OID 91785)
-- Name: outil_pedagogique_discipline_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.outil_pedagogique_discipline_scientifique (
                                                                  id bigint NOT NULL,
                                                                  discipline_scientifique_id bigint,
                                                                  outil_pedagogique_id bigint
);


ALTER TABLE public.outil_pedagogique_discipline_scientifique OWNER TO postgres;

--
-- TOC entry 533 (class 1259 OID 91788)
-- Name: outil_pedagogique_discipline_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.outil_pedagogique_discipline_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.outil_pedagogique_discipline_scientifique_seq OWNER TO postgres;

--
-- TOC entry 534 (class 1259 OID 91789)
-- Name: outil_pedagogique_enjeux_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.outil_pedagogique_enjeux_ird (
                                                     id bigint NOT NULL,
                                                     enjeux_ird_id bigint,
                                                     outil_pedagogique_id bigint
);


ALTER TABLE public.outil_pedagogique_enjeux_ird OWNER TO postgres;

--
-- TOC entry 535 (class 1259 OID 91792)
-- Name: outil_pedagogique_enjeux_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.outil_pedagogique_enjeux_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.outil_pedagogique_enjeux_ird_seq OWNER TO postgres;

--
-- TOC entry 536 (class 1259 OID 91793)
-- Name: outil_pedagogique_instrument_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.outil_pedagogique_instrument_ird (
                                                         id bigint NOT NULL,
                                                         instrument_ird_id bigint,
                                                         outil_pedagogique_id bigint
);


ALTER TABLE public.outil_pedagogique_instrument_ird OWNER TO postgres;

--
-- TOC entry 537 (class 1259 OID 91796)
-- Name: outil_pedagogique_instrument_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.outil_pedagogique_instrument_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.outil_pedagogique_instrument_ird_seq OWNER TO postgres;

--
-- TOC entry 538 (class 1259 OID 91797)
-- Name: outil_pedagogique_langue; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.outil_pedagogique_langue (
                                                 id bigint NOT NULL,
                                                 langue_id bigint,
                                                 outil_pedagogique_id bigint
);


ALTER TABLE public.outil_pedagogique_langue OWNER TO postgres;

--
-- TOC entry 539 (class 1259 OID 91800)
-- Name: outil_pedagogique_langue_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.outil_pedagogique_langue_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.outil_pedagogique_langue_seq OWNER TO postgres;

--
-- TOC entry 540 (class 1259 OID 91801)
-- Name: outil_pedagogique_pays_conception; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.outil_pedagogique_pays_conception (
                                                          id bigint NOT NULL,
                                                          outil_pedagogique_id bigint,
                                                          pays_id bigint
);


ALTER TABLE public.outil_pedagogique_pays_conception OWNER TO postgres;

--
-- TOC entry 541 (class 1259 OID 91804)
-- Name: outil_pedagogique_pays_conception_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.outil_pedagogique_pays_conception_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.outil_pedagogique_pays_conception_seq OWNER TO postgres;

--
-- TOC entry 542 (class 1259 OID 91805)
-- Name: outil_pedagogique_pays_diffusion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.outil_pedagogique_pays_diffusion (
                                                         id bigint NOT NULL,
                                                         outil_pedagogique_id bigint,
                                                         pays_id bigint
);


ALTER TABLE public.outil_pedagogique_pays_diffusion OWNER TO postgres;

--
-- TOC entry 543 (class 1259 OID 91808)
-- Name: outil_pedagogique_pays_diffusion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.outil_pedagogique_pays_diffusion_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.outil_pedagogique_pays_diffusion_seq OWNER TO postgres;

--
-- TOC entry 544 (class 1259 OID 91809)
-- Name: outil_pedagogique_periode; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.outil_pedagogique_periode (
                                                  id bigint NOT NULL,
                                                  date_diffusion date,
                                                  outil_pedagogique_id bigint
);


ALTER TABLE public.outil_pedagogique_periode OWNER TO postgres;

--
-- TOC entry 545 (class 1259 OID 91812)
-- Name: outil_pedagogique_periode_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.outil_pedagogique_periode_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.outil_pedagogique_periode_seq OWNER TO postgres;

--
-- TOC entry 546 (class 1259 OID 91813)
-- Name: outil_pedagogique_public_cible; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.outil_pedagogique_public_cible (
                                                       id bigint NOT NULL,
                                                       outil_pedagogique_id bigint,
                                                       public_cible_id bigint
);


ALTER TABLE public.outil_pedagogique_public_cible OWNER TO postgres;

--
-- TOC entry 547 (class 1259 OID 91816)
-- Name: outil_pedagogique_public_cible_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.outil_pedagogique_public_cible_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.outil_pedagogique_public_cible_seq OWNER TO postgres;

--
-- TOC entry 548 (class 1259 OID 91817)
-- Name: outil_pedagogique_publique_cible; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.outil_pedagogique_publique_cible (
                                                         id bigint NOT NULL,
                                                         outil_pedagogique_id bigint,
                                                         publique_cible_id bigint
);


ALTER TABLE public.outil_pedagogique_publique_cible OWNER TO postgres;

--
-- TOC entry 549 (class 1259 OID 91820)
-- Name: outil_pedagogique_publique_cible_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.outil_pedagogique_publique_cible_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.outil_pedagogique_publique_cible_seq OWNER TO postgres;

--
-- TOC entry 550 (class 1259 OID 91821)
-- Name: outil_pedagogique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.outil_pedagogique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.outil_pedagogique_seq OWNER TO postgres;

--
-- TOC entry 551 (class 1259 OID 91822)
-- Name: outil_pedagogique_type_instrument_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.outil_pedagogique_type_instrument_ird (
                                                              id bigint NOT NULL,
                                                              outil_pedagogique_id bigint,
                                                              type_instrument_ird_id bigint
);


ALTER TABLE public.outil_pedagogique_type_instrument_ird OWNER TO postgres;

--
-- TOC entry 552 (class 1259 OID 91825)
-- Name: outil_pedagogique_type_instrument_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.outil_pedagogique_type_instrument_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.outil_pedagogique_type_instrument_ird_seq OWNER TO postgres;

--
-- TOC entry 553 (class 1259 OID 91826)
-- Name: partenaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.partenaire (
                                   id bigint NOT NULL,
                                   adresse character varying(255),
                                   id_graph_ql character varying(255),
                                   nom_officel character varying(255),
                                   sigle_officel character varying(255),
                                   type_partenaire character varying(255),
                                   pays_partenaire_id bigint
);


ALTER TABLE public.partenaire OWNER TO postgres;

--
-- TOC entry 554 (class 1259 OID 91831)
-- Name: partenaire_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.partenaire_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.partenaire_seq OWNER TO postgres;

--
-- TOC entry 555 (class 1259 OID 91832)
-- Name: pays; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pays (
                             id bigint NOT NULL,
                             admin boolean DEFAULT false,
                             archive boolean DEFAULT false,
                             code character varying(500),
                             date_archivage date,
                             date_creation date,
                             libelle character varying(500),
                             username character varying(500),
                             visible boolean DEFAULT true,
                             id_graph character varying(255),
                             continent_id bigint,
                             nom_majuscule character varying(255)
);


ALTER TABLE public.pays OWNER TO postgres;

--
-- TOC entry 556 (class 1259 OID 91840)
-- Name: pays_commanditaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pays_commanditaire (
                                           id bigint NOT NULL,
                                           consultance_scientifique_ponctuelle_id bigint,
                                           pays_id bigint
);


ALTER TABLE public.pays_commanditaire OWNER TO postgres;

--
-- TOC entry 557 (class 1259 OID 91843)
-- Name: pays_commanditaire_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pays_commanditaire_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pays_commanditaire_seq OWNER TO postgres;

--
-- TOC entry 558 (class 1259 OID 91844)
-- Name: pays_culture_scientifique_recontre_grand_public_jeune_public; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pays_culture_scientifique_recontre_grand_public_jeune_public (
                                                                                     id bigint NOT NULL,
                                                                                     culture_scientifique_recontre_grand_public_jeune_public_id bigint,
                                                                                     pays_id bigint
);


ALTER TABLE public.pays_culture_scientifique_recontre_grand_public_jeune_public OWNER TO postgres;

--
-- TOC entry 559 (class 1259 OID 91847)
-- Name: pays_encadrement_doctorant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pays_encadrement_doctorant (
                                                   id bigint NOT NULL,
                                                   encadrement_doctorant_id bigint,
                                                   pays_id bigint
);


ALTER TABLE public.pays_encadrement_doctorant OWNER TO postgres;

--
-- TOC entry 560 (class 1259 OID 91850)
-- Name: pays_encadrement_doctorant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pays_encadrement_doctorant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pays_encadrement_doctorant_seq OWNER TO postgres;

--
-- TOC entry 561 (class 1259 OID 91851)
-- Name: pays_encadrement_etudiant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pays_encadrement_etudiant (
                                                  id bigint NOT NULL,
                                                  encadrement_etudiant_id bigint,
                                                  pays_id bigint
);


ALTER TABLE public.pays_encadrement_etudiant OWNER TO postgres;

--
-- TOC entry 562 (class 1259 OID 91854)
-- Name: pays_encadrement_etudiant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pays_encadrement_etudiant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pays_encadrement_etudiant_seq OWNER TO postgres;

--
-- TOC entry 563 (class 1259 OID 91855)
-- Name: pays_formation_continue; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pays_formation_continue (
                                                id bigint NOT NULL,
                                                formation_continue_id bigint,
                                                pays_id bigint
);


ALTER TABLE public.pays_formation_continue OWNER TO postgres;

--
-- TOC entry 564 (class 1259 OID 91858)
-- Name: pays_formation_continue_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pays_formation_continue_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pays_formation_continue_seq OWNER TO postgres;

--
-- TOC entry 565 (class 1259 OID 91859)
-- Name: pays_organisateur_rencontre_grand_publique_jeune_publique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pays_organisateur_rencontre_grand_publique_jeune_publique (
                                                                                  id bigint NOT NULL,
                                                                                  pays_id bigint,
                                                                                  rencontre_grand_publique_jeune_publique_id bigint
);


ALTER TABLE public.pays_organisateur_rencontre_grand_publique_jeune_publique OWNER TO postgres;

--
-- TOC entry 566 (class 1259 OID 91862)
-- Name: pays_organisateur_rencontre_grand_publique_jeune_publique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pays_organisateur_rencontre_grand_publique_jeune_publique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pays_organisateur_rencontre_grand_publique_jeune_publique_seq OWNER TO postgres;

--
-- TOC entry 567 (class 1259 OID 91863)
-- Name: pays_projet_recherche; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pays_projet_recherche (
                                              id bigint NOT NULL,
                                              pays_id bigint,
                                              projet_activite_recherche_id bigint
);


ALTER TABLE public.pays_projet_recherche OWNER TO postgres;

--
-- TOC entry 568 (class 1259 OID 91866)
-- Name: pays_rencontre_grand_publique_jeune_publique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pays_rencontre_grand_publique_jeune_publique (
                                                                     id bigint NOT NULL,
                                                                     pays_id bigint,
                                                                     rencontre_grand_publique_jeune_publique_id bigint
);


ALTER TABLE public.pays_rencontre_grand_publique_jeune_publique OWNER TO postgres;

--
-- TOC entry 569 (class 1259 OID 91869)
-- Name: pays_rencontre_grand_publique_jeune_publique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pays_rencontre_grand_publique_jeune_publique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pays_rencontre_grand_publique_jeune_publique_seq OWNER TO postgres;

--
-- TOC entry 570 (class 1259 OID 91870)
-- Name: pays_rencontre_media; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pays_rencontre_media (
                                             id bigint NOT NULL,
                                             pays_id bigint,
                                             rencontre_media_id bigint
);


ALTER TABLE public.pays_rencontre_media OWNER TO postgres;

--
-- TOC entry 571 (class 1259 OID 91873)
-- Name: pays_rencontre_media_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pays_rencontre_media_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pays_rencontre_media_seq OWNER TO postgres;

--
-- TOC entry 572 (class 1259 OID 91874)
-- Name: pays_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pays_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pays_seq OWNER TO postgres;

--
-- TOC entry 573 (class 1259 OID 91875)
-- Name: pays_type_outil_culture_scientifique_outil_pedagogique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pays_type_outil_culture_scientifique_outil_pedagogique (
                                                                               id bigint NOT NULL,
                                                                               culture_scientifique_outil_pedagogique_id bigint,
                                                                               pays_id bigint
);


ALTER TABLE public.pays_type_outil_culture_scientifique_outil_pedagogique OWNER TO postgres;

--
-- TOC entry 574 (class 1259 OID 91878)
-- Name: pays_zone_geographique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pays_zone_geographique (
                                               id bigint NOT NULL,
                                               pays_id bigint,
                                               zone_geographique_id bigint
);


ALTER TABLE public.pays_zone_geographique OWNER TO postgres;

--
-- TOC entry 575 (class 1259 OID 91881)
-- Name: pays_zone_geographique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pays_zone_geographique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pays_zone_geographique_seq OWNER TO postgres;

--
-- TOC entry 576 (class 1259 OID 91882)
-- Name: permission; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.permission (
                                   id bigint NOT NULL,
                                   name character varying(255)
);


ALTER TABLE public.permission OWNER TO postgres;

--
-- TOC entry 577 (class 1259 OID 91885)
-- Name: projet_activite_recherche; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.projet_activite_recherche (
                                                  id bigint NOT NULL,
                                                  annee bigint,
                                                  temps_estime_pour_cette_annne numeric(19,2),
                                                  campagne_id bigint,
                                                  chercheur_id bigint,
                                                  etat_etape_campagne_id bigint
);


ALTER TABLE public.projet_activite_recherche OWNER TO postgres;

--
-- TOC entry 578 (class 1259 OID 91888)
-- Name: projet_activite_recherche_detail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.projet_activite_recherche_detail (
                                                         id bigint NOT NULL,
                                                         duree_prevu_en_mois integer,
                                                         financement_specifique boolean DEFAULT false,
                                                         montant_financement_prevu numeric(19,2),
                                                         sujet_intitule_reponse character varying(500),
                                                         etablissement_id bigint,
                                                         etat_etape_campagne_id bigint,
                                                         pays_id bigint,
                                                         projet_activite_recherche_id bigint,
                                                         role_projet_id bigint,
                                                         status_projet_id bigint
);


ALTER TABLE public.projet_activite_recherche_detail OWNER TO postgres;

--
-- TOC entry 579 (class 1259 OID 91894)
-- Name: projet_activite_recherche_detail_enjeux_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.projet_activite_recherche_detail_enjeux_ird (
                                                                    id bigint NOT NULL,
                                                                    enjeux_ird_id bigint,
                                                                    projet_activite_recherche_detail_id bigint
);


ALTER TABLE public.projet_activite_recherche_detail_enjeux_ird OWNER TO postgres;

--
-- TOC entry 580 (class 1259 OID 91897)
-- Name: projet_activite_recherche_detail_enjeux_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.projet_activite_recherche_detail_enjeux_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.projet_activite_recherche_detail_enjeux_ird_seq OWNER TO postgres;

--
-- TOC entry 581 (class 1259 OID 91898)
-- Name: projet_activite_recherche_detail_etablissement_financeur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.projet_activite_recherche_detail_etablissement_financeur (
                                                                                 id bigint NOT NULL,
                                                                                 etablissement_id bigint,
                                                                                 projet_activite_recherche_detail_id bigint
);


ALTER TABLE public.projet_activite_recherche_detail_etablissement_financeur OWNER TO postgres;

--
-- TOC entry 582 (class 1259 OID 91901)
-- Name: projet_activite_recherche_detail_etablissement_financeur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.projet_activite_recherche_detail_etablissement_financeur_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.projet_activite_recherche_detail_etablissement_financeur_seq OWNER TO postgres;

--
-- TOC entry 583 (class 1259 OID 91902)
-- Name: projet_activite_recherche_detail_etablissement_lanceur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.projet_activite_recherche_detail_etablissement_lanceur (
                                                                               id bigint NOT NULL,
                                                                               etablissement_id bigint,
                                                                               projet_activite_recherche_detail_id bigint
);


ALTER TABLE public.projet_activite_recherche_detail_etablissement_lanceur OWNER TO postgres;

--
-- TOC entry 584 (class 1259 OID 91905)
-- Name: projet_activite_recherche_detail_etablissement_lanceur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.projet_activite_recherche_detail_etablissement_lanceur_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.projet_activite_recherche_detail_etablissement_lanceur_seq OWNER TO postgres;

--
-- TOC entry 585 (class 1259 OID 91906)
-- Name: projet_activite_recherche_detail_institution_co_contractant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.projet_activite_recherche_detail_institution_co_contractant (
                                                                                    id bigint NOT NULL,
                                                                                    etablissement_id bigint,
                                                                                    projet_activite_recherche_detail_id bigint
);


ALTER TABLE public.projet_activite_recherche_detail_institution_co_contractant OWNER TO postgres;

--
-- TOC entry 586 (class 1259 OID 91909)
-- Name: projet_activite_recherche_detail_institution_co_contractant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.projet_activite_recherche_detail_institution_co_contractant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.projet_activite_recherche_detail_institution_co_contractant_seq OWNER TO postgres;

--
-- TOC entry 587 (class 1259 OID 91910)
-- Name: projet_activite_recherche_detail_instrument_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.projet_activite_recherche_detail_instrument_ird (
                                                                        id bigint NOT NULL,
                                                                        instrument_ird_id bigint,
                                                                        projet_activite_recherche_detail_id bigint
);


ALTER TABLE public.projet_activite_recherche_detail_instrument_ird OWNER TO postgres;

--
-- TOC entry 588 (class 1259 OID 91913)
-- Name: projet_activite_recherche_detail_instrument_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.projet_activite_recherche_detail_instrument_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.projet_activite_recherche_detail_instrument_ird_seq OWNER TO postgres;

--
-- TOC entry 589 (class 1259 OID 91914)
-- Name: projet_activite_recherche_detail_pays; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.projet_activite_recherche_detail_pays (
                                                              id bigint NOT NULL,
                                                              pays_id bigint,
                                                              projet_activite_recherche_detail_id bigint
);


ALTER TABLE public.projet_activite_recherche_detail_pays OWNER TO postgres;

--
-- TOC entry 590 (class 1259 OID 91917)
-- Name: projet_activite_recherche_detail_pays_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.projet_activite_recherche_detail_pays_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.projet_activite_recherche_detail_pays_seq OWNER TO postgres;

--
-- TOC entry 591 (class 1259 OID 91918)
-- Name: projet_activite_recherche_detail_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.projet_activite_recherche_detail_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.projet_activite_recherche_detail_seq OWNER TO postgres;

--
-- TOC entry 592 (class 1259 OID 91919)
-- Name: projet_activite_recherche_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.projet_activite_recherche_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.projet_activite_recherche_seq OWNER TO postgres;

--
-- TOC entry 593 (class 1259 OID 91920)
-- Name: public_cible; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.public_cible (
                                     id bigint NOT NULL,
                                     code character varying(255),
                                     libelle character varying(255)
);


ALTER TABLE public.public_cible OWNER TO postgres;

--
-- TOC entry 594 (class 1259 OID 91925)
-- Name: public_cible_culture_scientifique_outil_pedagogique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.public_cible_culture_scientifique_outil_pedagogique (
                                                                            id bigint NOT NULL,
                                                                            culture_scientifique_outil_pedagogique_id bigint,
                                                                            pays_id bigint,
                                                                            public_cible_id bigint
);


ALTER TABLE public.public_cible_culture_scientifique_outil_pedagogique OWNER TO postgres;

--
-- TOC entry 595 (class 1259 OID 91928)
-- Name: public_cible_culture_scientifique_recontre_grand_public; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.public_cible_culture_scientifique_recontre_grand_public (
                                                                                id bigint NOT NULL,
                                                                                culture_scientifique_recontre_grand_public_jeune_public_id bigint,
                                                                                pays_id bigint,
                                                                                public_cible_id bigint
);


ALTER TABLE public.public_cible_culture_scientifique_recontre_grand_public OWNER TO postgres;

--
-- TOC entry 596 (class 1259 OID 91931)
-- Name: publique_cible; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.publique_cible (
                                       id bigint NOT NULL,
                                       admin boolean DEFAULT false,
                                       archive boolean DEFAULT false,
                                       code character varying(500),
                                       date_archivage date,
                                       date_creation date,
                                       libelle character varying(500),
                                       username character varying(500),
                                       visible boolean DEFAULT true
);


ALTER TABLE public.publique_cible OWNER TO postgres;

--
-- TOC entry 597 (class 1259 OID 91939)
-- Name: publique_cible_rencontre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.publique_cible_rencontre (
                                                 id bigint NOT NULL,
                                                 archive boolean DEFAULT false,
                                                 code character varying(255),
                                                 date_archivage date,
                                                 description text,
                                                 libelle character varying(255)
);


ALTER TABLE public.publique_cible_rencontre OWNER TO postgres;

--
-- TOC entry 598 (class 1259 OID 91945)
-- Name: publique_cible_rencontre_grand_publique_jeune_publique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.publique_cible_rencontre_grand_publique_jeune_publique (
                                                                               id bigint NOT NULL,
                                                                               publique_cible_rencontre_id bigint,
                                                                               rencontre_grand_publique_jeune_publique_id bigint
);


ALTER TABLE public.publique_cible_rencontre_grand_publique_jeune_publique OWNER TO postgres;

--
-- TOC entry 599 (class 1259 OID 91948)
-- Name: publique_cible_rencontre_grand_publique_jeune_publique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.publique_cible_rencontre_grand_publique_jeune_publique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.publique_cible_rencontre_grand_publique_jeune_publique_seq OWNER TO postgres;

--
-- TOC entry 600 (class 1259 OID 91949)
-- Name: publique_cible_rencontre_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.publique_cible_rencontre_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.publique_cible_rencontre_seq OWNER TO postgres;

--
-- TOC entry 601 (class 1259 OID 91950)
-- Name: publique_cible_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.publique_cible_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.publique_cible_seq OWNER TO postgres;

--
-- TOC entry 602 (class 1259 OID 91951)
-- Name: publique_formation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.publique_formation (
                                           id bigint NOT NULL,
                                           admin boolean DEFAULT false,
                                           archive boolean DEFAULT false,
                                           code character varying(500),
                                           date_archivage date,
                                           date_creation date,
                                           libelle character varying(500),
                                           username character varying(500),
                                           visible boolean DEFAULT true
);


ALTER TABLE public.publique_formation OWNER TO postgres;

--
-- TOC entry 603 (class 1259 OID 91959)
-- Name: publique_formation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.publique_formation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.publique_formation_seq OWNER TO postgres;

--
-- TOC entry 604 (class 1259 OID 91960)
-- Name: publique_principal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.publique_principal (
                                           id bigint NOT NULL,
                                           code character varying(255),
                                           libelle character varying(255)
);


ALTER TABLE public.publique_principal OWNER TO postgres;

--
-- TOC entry 605 (class 1259 OID 91965)
-- Name: publique_principal_conceme_formation_continue; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.publique_principal_conceme_formation_continue (
                                                                      id bigint NOT NULL,
                                                                      formation_continue_id bigint,
                                                                      publique_principal_id bigint
);


ALTER TABLE public.publique_principal_conceme_formation_continue OWNER TO postgres;

--
-- TOC entry 606 (class 1259 OID 91968)
-- Name: publique_professionel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.publique_professionel (
                                              id bigint NOT NULL,
                                              admin boolean DEFAULT false,
                                              archive boolean DEFAULT false,
                                              code character varying(500),
                                              date_archivage date,
                                              date_creation date,
                                              libelle character varying(500),
                                              username character varying(500),
                                              visible boolean DEFAULT true
);


ALTER TABLE public.publique_professionel OWNER TO postgres;

--
-- TOC entry 607 (class 1259 OID 91976)
-- Name: publique_professionel_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.publique_professionel_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.publique_professionel_seq OWNER TO postgres;

--
-- TOC entry 608 (class 1259 OID 91977)
-- Name: reclamation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reclamation (
                                    id bigint NOT NULL,
                                    date_reclamation date,
                                    date_traitement date,
                                    message text,
                                    objet character varying(500),
                                    chercheur_id bigint,
                                    etat_reclamation_id bigint,
                                    type_reclamation_id bigint
);


ALTER TABLE public.reclamation OWNER TO postgres;

--
-- TOC entry 609 (class 1259 OID 91982)
-- Name: reclamation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reclamation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reclamation_seq OWNER TO postgres;

--
-- TOC entry 610 (class 1259 OID 91983)
-- Name: rencontre_grand_publique_jeune_publique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rencontre_grand_publique_jeune_publique (
                                                                id bigint NOT NULL,
                                                                intitule_sujet character varying(500),
                                                                lien_instrument_ird boolean DEFAULT false,
                                                                lien_web character varying(500),
                                                                nombre_personne_estime numeric(19,2),
                                                                remarque text,
                                                                contexte_id bigint,
                                                                culture_scientifique_id bigint,
                                                                etat_etape_campagne_id bigint,
                                                                format_rencontre_id bigint,
                                                                pays_id bigint
);


ALTER TABLE public.rencontre_grand_publique_jeune_publique OWNER TO postgres;

--
-- TOC entry 611 (class 1259 OID 91989)
-- Name: rencontre_grand_publique_jeune_publique_discipline; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rencontre_grand_publique_jeune_publique_discipline (
                                                                           id bigint NOT NULL,
                                                                           discipline_scientifique_id bigint,
                                                                           rencontre_grand_publique_jeune_publique_id bigint
);


ALTER TABLE public.rencontre_grand_publique_jeune_publique_discipline OWNER TO postgres;

--
-- TOC entry 612 (class 1259 OID 91992)
-- Name: rencontre_grand_publique_jeune_publique_discipline_scientifique; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rencontre_grand_publique_jeune_publique_discipline_scientifique
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rencontre_grand_publique_jeune_publique_discipline_scientifique OWNER TO postgres;

--
-- TOC entry 613 (class 1259 OID 91993)
-- Name: rencontre_grand_publique_jeune_publique_enjeux_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rencontre_grand_publique_jeune_publique_enjeux_ird (
                                                                           id bigint NOT NULL,
                                                                           enjeux_ird_id bigint,
                                                                           rencontre_grand_publique_jeune_publique_id bigint
);


ALTER TABLE public.rencontre_grand_publique_jeune_publique_enjeux_ird OWNER TO postgres;

--
-- TOC entry 614 (class 1259 OID 91996)
-- Name: rencontre_grand_publique_jeune_publique_enjeux_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rencontre_grand_publique_jeune_publique_enjeux_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rencontre_grand_publique_jeune_publique_enjeux_ird_seq OWNER TO postgres;

--
-- TOC entry 615 (class 1259 OID 91997)
-- Name: rencontre_grand_publique_jeune_publique_instrument_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rencontre_grand_publique_jeune_publique_instrument_ird (
                                                                               id bigint NOT NULL,
                                                                               instrument_ird_id bigint,
                                                                               rencontre_grand_publique_jeune_publique_id bigint
);


ALTER TABLE public.rencontre_grand_publique_jeune_publique_instrument_ird OWNER TO postgres;

--
-- TOC entry 616 (class 1259 OID 92000)
-- Name: rencontre_grand_publique_jeune_publique_instrument_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rencontre_grand_publique_jeune_publique_instrument_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rencontre_grand_publique_jeune_publique_instrument_ird_seq OWNER TO postgres;

--
-- TOC entry 617 (class 1259 OID 92001)
-- Name: rencontre_grand_publique_jeune_publique_periode; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rencontre_grand_publique_jeune_publique_periode (
                                                                        id bigint NOT NULL,
                                                                        date_rencontre date,
                                                                        rencontre_grand_publique_jeune_publique_id bigint
);


ALTER TABLE public.rencontre_grand_publique_jeune_publique_periode OWNER TO postgres;

--
-- TOC entry 618 (class 1259 OID 92004)
-- Name: rencontre_grand_publique_jeune_publique_periode_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rencontre_grand_publique_jeune_publique_periode_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rencontre_grand_publique_jeune_publique_periode_seq OWNER TO postgres;

--
-- TOC entry 619 (class 1259 OID 92005)
-- Name: rencontre_grand_publique_jeune_publique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rencontre_grand_publique_jeune_publique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rencontre_grand_publique_jeune_publique_seq OWNER TO postgres;

--
-- TOC entry 620 (class 1259 OID 92006)
-- Name: rencontre_grand_publique_jeune_publique_type_instrument_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rencontre_grand_publique_jeune_publique_type_instrument_ird (
                                                                                    id bigint NOT NULL,
                                                                                    rencontre_grand_publique_jeune_publique_id bigint,
                                                                                    type_instrument_ird_id bigint
);


ALTER TABLE public.rencontre_grand_publique_jeune_publique_type_instrument_ird OWNER TO postgres;

--
-- TOC entry 621 (class 1259 OID 92009)
-- Name: rencontre_grand_publique_jeune_publique_type_instrument_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rencontre_grand_publique_jeune_publique_type_instrument_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rencontre_grand_publique_jeune_publique_type_instrument_ird_seq OWNER TO postgres;

--
-- TOC entry 622 (class 1259 OID 92010)
-- Name: rencontre_media; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rencontre_media (
                                        id bigint NOT NULL,
                                        intitule_sujet character varying(500),
                                        lien_web character varying(500),
                                        remarque text,
                                        culture_scientifique_id bigint,
                                        etat_etape_campagne_id bigint,
                                        format_rencontre_id bigint,
                                        nom_media character varying(250)
);


ALTER TABLE public.rencontre_media OWNER TO postgres;

--
-- TOC entry 623 (class 1259 OID 92015)
-- Name: rencontre_media_discipline_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rencontre_media_discipline_scientifique (
                                                                id bigint NOT NULL,
                                                                discipline_scientifique_id bigint,
                                                                rencontre_media_id bigint
);


ALTER TABLE public.rencontre_media_discipline_scientifique OWNER TO postgres;

--
-- TOC entry 624 (class 1259 OID 92018)
-- Name: rencontre_media_discipline_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rencontre_media_discipline_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rencontre_media_discipline_scientifique_seq OWNER TO postgres;

--
-- TOC entry 625 (class 1259 OID 92019)
-- Name: rencontre_media_enjeux_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rencontre_media_enjeux_ird (
                                                   id bigint NOT NULL,
                                                   enjeux_ird_id bigint,
                                                   rencontre_media_id bigint
);


ALTER TABLE public.rencontre_media_enjeux_ird OWNER TO postgres;

--
-- TOC entry 626 (class 1259 OID 92022)
-- Name: rencontre_media_enjeux_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rencontre_media_enjeux_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rencontre_media_enjeux_ird_seq OWNER TO postgres;

--
-- TOC entry 627 (class 1259 OID 92023)
-- Name: rencontre_media_periode; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rencontre_media_periode (
                                                id bigint NOT NULL,
                                                date_rencontre date,
                                                rencontre_media_id bigint
);


ALTER TABLE public.rencontre_media_periode OWNER TO postgres;

--
-- TOC entry 628 (class 1259 OID 92026)
-- Name: rencontre_media_periode_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rencontre_media_periode_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rencontre_media_periode_seq OWNER TO postgres;

--
-- TOC entry 629 (class 1259 OID 92027)
-- Name: rencontre_media_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rencontre_media_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rencontre_media_seq OWNER TO postgres;

--
-- TOC entry 630 (class 1259 OID 92028)
-- Name: responsabilite_direction_encadrement_etudiant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.responsabilite_direction_encadrement_etudiant (
                                                                      id bigint NOT NULL,
                                                                      admin boolean DEFAULT false,
                                                                      archive boolean DEFAULT false,
                                                                      code character varying(500),
                                                                      date_archivage date,
                                                                      date_creation date,
                                                                      libelle character varying(500),
                                                                      username character varying(500),
                                                                      visible boolean DEFAULT true
);


ALTER TABLE public.responsabilite_direction_encadrement_etudiant OWNER TO postgres;

--
-- TOC entry 631 (class 1259 OID 92036)
-- Name: responsabilite_direction_encadrement_etudiant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.responsabilite_direction_encadrement_etudiant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.responsabilite_direction_encadrement_etudiant_seq OWNER TO postgres;

--
-- TOC entry 632 (class 1259 OID 92037)
-- Name: responsabilite_encadrement_doctorant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.responsabilite_encadrement_doctorant (
                                                             id bigint NOT NULL,
                                                             admin boolean DEFAULT false,
                                                             archive boolean DEFAULT false,
                                                             code character varying(500),
                                                             date_archivage date,
                                                             date_creation date,
                                                             libelle character varying(500),
                                                             username character varying(500),
                                                             visible boolean DEFAULT true
);


ALTER TABLE public.responsabilite_encadrement_doctorant OWNER TO postgres;

--
-- TOC entry 633 (class 1259 OID 92045)
-- Name: responsabilite_encadrement_doctorant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.responsabilite_encadrement_doctorant_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.responsabilite_encadrement_doctorant_seq OWNER TO postgres;

--
-- TOC entry 634 (class 1259 OID 92046)
-- Name: responsabilite_encadrement_etudiant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.responsabilite_encadrement_etudiant (
                                                            id bigint NOT NULL,
                                                            code character varying(255),
                                                            libelle character varying(255)
);


ALTER TABLE public.responsabilite_encadrement_etudiant OWNER TO postgres;

--
-- TOC entry 635 (class 1259 OID 92051)
-- Name: responsabilite_pedagogique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.responsabilite_pedagogique (
                                                   id bigint NOT NULL,
                                                   cursus_construit_avec_etablissements boolean DEFAULT false,
                                                   intitule_cursus character varying(500),
                                                   service_renforcement_capacite boolean DEFAULT false,
                                                   enseignement_et_formation_id bigint,
                                                   etat_etape_campagne_id bigint,
                                                   niveau_responsabilite_pedagogique_id bigint,
                                                   status_cursus_id bigint
);


ALTER TABLE public.responsabilite_pedagogique OWNER TO postgres;

--
-- TOC entry 636 (class 1259 OID 92058)
-- Name: responsabilite_pedagogique_ecole_doctorale; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.responsabilite_pedagogique_ecole_doctorale (
                                                                   id bigint NOT NULL,
                                                                   annee integer,
                                                                   appel_service_renforcement_capacite_sud boolean,
                                                                   ecole_doctorale_international boolean,
                                                                   temps_estime_pour_cette_annne numeric(19,2),
                                                                   campagne_id bigint,
                                                                   chercheur_id bigint,
                                                                   ecole_doctorale_id bigint,
                                                                   etablissement_id bigint,
                                                                   etat_etape_campagne_id bigint,
                                                                   statut_ecole_doctorale_id bigint
);


ALTER TABLE public.responsabilite_pedagogique_ecole_doctorale OWNER TO postgres;

--
-- TOC entry 637 (class 1259 OID 92061)
-- Name: responsabilite_pedagogique_enjeux_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.responsabilite_pedagogique_enjeux_ird (
                                                              id bigint NOT NULL,
                                                              enjeux_ird_id bigint,
                                                              responsabilite_pedagogique_id bigint
);


ALTER TABLE public.responsabilite_pedagogique_enjeux_ird OWNER TO postgres;

--
-- TOC entry 638 (class 1259 OID 92064)
-- Name: responsabilite_pedagogique_enjeux_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.responsabilite_pedagogique_enjeux_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.responsabilite_pedagogique_enjeux_ird_seq OWNER TO postgres;

--
-- TOC entry 639 (class 1259 OID 92065)
-- Name: responsabilite_pedagogique_etablissement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.responsabilite_pedagogique_etablissement (
                                                                 id bigint NOT NULL,
                                                                 etablissement_id bigint,
                                                                 pays_id bigint,
                                                                 responsabilite_pedagogique_id bigint
);


ALTER TABLE public.responsabilite_pedagogique_etablissement OWNER TO postgres;

--
-- TOC entry 640 (class 1259 OID 92068)
-- Name: responsabilite_pedagogique_etablissement_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.responsabilite_pedagogique_etablissement_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.responsabilite_pedagogique_etablissement_seq OWNER TO postgres;

--
-- TOC entry 641 (class 1259 OID 92069)
-- Name: responsabilite_pedagogique_master; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.responsabilite_pedagogique_master (
                                                          id bigint NOT NULL,
                                                          annee integer,
                                                          appel_service_renforcement_capacite_sud boolean,
                                                          master_international boolean,
                                                          temps_estime_pour_cette_annne numeric(19,2),
                                                          campagne_id bigint,
                                                          chercheur_id bigint,
                                                          etablissement_id bigint,
                                                          etat_etape_campagne_id bigint,
                                                          master_id bigint,
                                                          statut_master_id bigint
);


ALTER TABLE public.responsabilite_pedagogique_master OWNER TO postgres;

--
-- TOC entry 642 (class 1259 OID 92072)
-- Name: responsabilite_pedagogique_pays; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.responsabilite_pedagogique_pays (
                                                        id bigint NOT NULL,
                                                        pays_id bigint,
                                                        responsabilite_pedagogique_id bigint
);


ALTER TABLE public.responsabilite_pedagogique_pays OWNER TO postgres;

--
-- TOC entry 643 (class 1259 OID 92075)
-- Name: responsabilite_pedagogique_pays_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.responsabilite_pedagogique_pays_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.responsabilite_pedagogique_pays_seq OWNER TO postgres;

--
-- TOC entry 644 (class 1259 OID 92076)
-- Name: responsabilite_pedagogique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.responsabilite_pedagogique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.responsabilite_pedagogique_seq OWNER TO postgres;

--
-- TOC entry 645 (class 1259 OID 92077)
-- Name: role_app; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role_app (
                                 id bigint NOT NULL,
                                 authority character varying(255),
                                 created_at timestamp without time zone,
                                 updated_at timestamp without time zone
);


ALTER TABLE public.role_app OWNER TO postgres;

--
-- TOC entry 646 (class 1259 OID 92080)
-- Name: role_comite_et_commission_evaluation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role_comite_et_commission_evaluation (
                                                             id bigint NOT NULL,
                                                             comite_et_commission_evaluation_id bigint,
                                                             role_evaluation_id bigint
);


ALTER TABLE public.role_comite_et_commission_evaluation OWNER TO postgres;

--
-- TOC entry 647 (class 1259 OID 92083)
-- Name: role_comite_et_commission_evaluation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_comite_et_commission_evaluation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_comite_et_commission_evaluation_seq OWNER TO postgres;

--
-- TOC entry 648 (class 1259 OID 92084)
-- Name: role_developpement_de_savoir; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role_developpement_de_savoir (
                                                     id bigint NOT NULL,
                                                     code character varying(500),
                                                     libelle character varying(500)
);


ALTER TABLE public.role_developpement_de_savoir OWNER TO postgres;

--
-- TOC entry 649 (class 1259 OID 92089)
-- Name: role_developpement_de_savoir_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_developpement_de_savoir_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_developpement_de_savoir_seq OWNER TO postgres;

--
-- TOC entry 650 (class 1259 OID 92090)
-- Name: role_evaluation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role_evaluation (
                                        id bigint NOT NULL,
                                        admin boolean DEFAULT false,
                                        archive boolean DEFAULT false,
                                        code character varying(500),
                                        date_archivage date,
                                        date_creation date,
                                        libelle character varying(500),
                                        username character varying(500),
                                        visible boolean DEFAULT true
);


ALTER TABLE public.role_evaluation OWNER TO postgres;

--
-- TOC entry 651 (class 1259 OID 92098)
-- Name: role_evaluation_recherche_universitaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role_evaluation_recherche_universitaire (
                                                                id bigint NOT NULL,
                                                                code character varying(255),
                                                                description text,
                                                                libelle character varying(255)
);


ALTER TABLE public.role_evaluation_recherche_universitaire OWNER TO postgres;

--
-- TOC entry 652 (class 1259 OID 92103)
-- Name: role_evaluation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_evaluation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_evaluation_seq OWNER TO postgres;

--
-- TOC entry 653 (class 1259 OID 92104)
-- Name: role_projet; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role_projet (
                                    id bigint NOT NULL,
                                    admin boolean DEFAULT false,
                                    archive boolean DEFAULT false,
                                    code character varying(500),
                                    date_archivage date,
                                    date_creation date,
                                    description text,
                                    libelle character varying(500),
                                    username character varying(500),
                                    visible boolean DEFAULT true
);


ALTER TABLE public.role_projet OWNER TO postgres;

--
-- TOC entry 654 (class 1259 OID 92112)
-- Name: role_projet_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_projet_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_projet_seq OWNER TO postgres;

--
-- TOC entry 655 (class 1259 OID 92113)
-- Name: roles_permissions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles_permissions (
                                          role_id bigint NOT NULL,
                                          permission_id bigint NOT NULL
);


ALTER TABLE public.roles_permissions OWNER TO postgres;

--
-- TOC entry 656 (class 1259 OID 92116)
-- Name: savoir_et_innovation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.savoir_et_innovation (
                                             id bigint NOT NULL,
                                             annee bigint,
                                             temps_estime_pour_cette_annne numeric(19,2),
                                             campagne_id bigint,
                                             chercheur_id bigint,
                                             etat_etape_campagne_id bigint
);


ALTER TABLE public.savoir_et_innovation OWNER TO postgres;

--
-- TOC entry 657 (class 1259 OID 92119)
-- Name: savoir_et_innovation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.savoir_et_innovation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.savoir_et_innovation_seq OWNER TO postgres;

--
-- TOC entry 658 (class 1259 OID 92120)
-- Name: semantic_relationship; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.semantic_relationship (
                                              id bigint NOT NULL,
                                              code character varying(500),
                                              libelle character varying(500),
                                              niveau_exactitude bigint
);


ALTER TABLE public.semantic_relationship OWNER TO postgres;

--
-- TOC entry 659 (class 1259 OID 92125)
-- Name: semantic_relationship_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.semantic_relationship_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.semantic_relationship_seq OWNER TO postgres;

--
-- TOC entry 755 (class 1259 OID 95576)
-- Name: seq_doctorant; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_doctorant
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_doctorant OWNER TO postgres;

--
-- TOC entry 756 (class 1259 OID 95577)
-- Name: seq_etudiant; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_etudiant
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_etudiant OWNER TO postgres;

--
-- TOC entry 660 (class 1259 OID 92126)
-- Name: sexe; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sexe (
                             id bigint NOT NULL,
                             admin boolean DEFAULT false,
                             archive boolean DEFAULT false,
                             code character varying(500),
                             date_archivage date,
                             date_creation date,
                             libelle character varying(500),
                             username character varying(500),
                             visible boolean DEFAULT true
);


ALTER TABLE public.sexe OWNER TO postgres;

--
-- TOC entry 661 (class 1259 OID 92134)
-- Name: sexe_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sexe_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sexe_seq OWNER TO postgres;

--
-- TOC entry 662 (class 1259 OID 92135)
-- Name: status_contrat_et_convention; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.status_contrat_et_convention (
                                                     id bigint NOT NULL,
                                                     code character varying(500),
                                                     libelle character varying(500)
);


ALTER TABLE public.status_contrat_et_convention OWNER TO postgres;

--
-- TOC entry 663 (class 1259 OID 92140)
-- Name: status_contrat_et_convention_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.status_contrat_et_convention_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.status_contrat_et_convention_seq OWNER TO postgres;

--
-- TOC entry 664 (class 1259 OID 92141)
-- Name: status_cursus; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.status_cursus (
                                      id bigint NOT NULL,
                                      admin boolean DEFAULT false,
                                      archive boolean DEFAULT false,
                                      code character varying(500),
                                      date_archivage date,
                                      date_creation date,
                                      libelle character varying(500),
                                      username character varying(500),
                                      visible boolean DEFAULT true
);


ALTER TABLE public.status_cursus OWNER TO postgres;

--
-- TOC entry 665 (class 1259 OID 92149)
-- Name: status_cursus_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.status_cursus_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.status_cursus_seq OWNER TO postgres;

--
-- TOC entry 666 (class 1259 OID 92150)
-- Name: status_projet; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.status_projet (
                                      id bigint NOT NULL,
                                      admin boolean DEFAULT false,
                                      archive boolean DEFAULT false,
                                      code character varying(500),
                                      date_archivage date,
                                      date_creation date,
                                      libelle character varying(500),
                                      username character varying(500),
                                      visible boolean DEFAULT true
);


ALTER TABLE public.status_projet OWNER TO postgres;

--
-- TOC entry 667 (class 1259 OID 92158)
-- Name: status_projet_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.status_projet_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.status_projet_seq OWNER TO postgres;

--
-- TOC entry 668 (class 1259 OID 92159)
-- Name: statut_ecole_doctorale; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.statut_ecole_doctorale (
                                               id bigint NOT NULL,
                                               code character varying(255),
                                               libelle character varying(255)
);


ALTER TABLE public.statut_ecole_doctorale OWNER TO postgres;

--
-- TOC entry 669 (class 1259 OID 92164)
-- Name: statut_master; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.statut_master (
                                      id bigint NOT NULL,
                                      code character varying(255),
                                      libelle character varying(255)
);


ALTER TABLE public.statut_master OWNER TO postgres;

--
-- TOC entry 670 (class 1259 OID 92169)
-- Name: structure_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.structure_ird (
                                      id bigint NOT NULL,
                                      admin boolean DEFAULT false,
                                      archive boolean DEFAULT false,
                                      code character varying(500),
                                      date_archivage date,
                                      date_creation date,
                                      libelle character varying(500),
                                      username character varying(500),
                                      visible boolean DEFAULT true
);


ALTER TABLE public.structure_ird OWNER TO postgres;

--
-- TOC entry 671 (class 1259 OID 92177)
-- Name: structure_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.structure_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.structure_ird_seq OWNER TO postgres;

--
-- TOC entry 672 (class 1259 OID 92178)
-- Name: structure_oganisatrice; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.structure_oganisatrice (
                                               id bigint NOT NULL,
                                               etablissement_id bigint,
                                               rencontre_grand_publique_jeune_publique_id bigint
);


ALTER TABLE public.structure_oganisatrice OWNER TO postgres;

--
-- TOC entry 673 (class 1259 OID 92181)
-- Name: structure_oganisatrice_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.structure_oganisatrice_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.structure_oganisatrice_seq OWNER TO postgres;

--
-- TOC entry 674 (class 1259 OID 92182)
-- Name: template_cloture; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.template_cloture (
                                         id bigint NOT NULL,
                                         admin boolean DEFAULT false,
                                         archive boolean DEFAULT false,
                                         code character varying(500),
                                         date_archivage date,
                                         date_creation date,
                                         message text,
                                         objet character varying(500),
                                         username character varying(500),
                                         visible boolean DEFAULT true
);


ALTER TABLE public.template_cloture OWNER TO postgres;

--
-- TOC entry 675 (class 1259 OID 92190)
-- Name: template_cloture_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.template_cloture_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.template_cloture_seq OWNER TO postgres;

--
-- TOC entry 676 (class 1259 OID 92191)
-- Name: template_ouverture; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.template_ouverture (
                                           id bigint NOT NULL,
                                           admin boolean DEFAULT false,
                                           archive boolean DEFAULT false,
                                           code character varying(500),
                                           date_archivage date,
                                           date_creation date,
                                           message text,
                                           objet character varying(500),
                                           username character varying(500),
                                           visible boolean DEFAULT true
);


ALTER TABLE public.template_ouverture OWNER TO postgres;

--
-- TOC entry 677 (class 1259 OID 92199)
-- Name: template_ouverture_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.template_ouverture_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.template_ouverture_seq OWNER TO postgres;

--
-- TOC entry 678 (class 1259 OID 92200)
-- Name: template_rappel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.template_rappel (
                                        id bigint NOT NULL,
                                        admin boolean DEFAULT false,
                                        archive boolean DEFAULT false,
                                        code character varying(500),
                                        date_archivage date,
                                        date_creation date,
                                        message text,
                                        objet character varying(500),
                                        username character varying(500),
                                        visible boolean DEFAULT true
);


ALTER TABLE public.template_rappel OWNER TO postgres;

--
-- TOC entry 679 (class 1259 OID 92208)
-- Name: template_rappel_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.template_rappel_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.template_rappel_seq OWNER TO postgres;

--
-- TOC entry 680 (class 1259 OID 92209)
-- Name: template_relance; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.template_relance (
                                         id bigint NOT NULL,
                                         admin boolean DEFAULT false,
                                         archive boolean DEFAULT false,
                                         code character varying(500),
                                         date_archivage date,
                                         date_creation date,
                                         message text,
                                         objet character varying(500),
                                         username character varying(500),
                                         visible boolean DEFAULT true
);


ALTER TABLE public.template_relance OWNER TO postgres;

--
-- TOC entry 681 (class 1259 OID 92217)
-- Name: template_relance_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.template_relance_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.template_relance_seq OWNER TO postgres;

--
-- TOC entry 682 (class 1259 OID 92218)
-- Name: type_enseignement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_enseignement (
                                          id bigint NOT NULL,
                                          admin boolean DEFAULT false,
                                          archive boolean DEFAULT false,
                                          code character varying(500),
                                          date_archivage date,
                                          date_creation date,
                                          libelle character varying(500),
                                          username character varying(500),
                                          visible boolean DEFAULT true
);


ALTER TABLE public.type_enseignement OWNER TO postgres;

--
-- TOC entry 683 (class 1259 OID 92226)
-- Name: type_enseignement_dispense; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_enseignement_dispense (
                                                   id bigint NOT NULL,
                                                   code character varying(255),
                                                   libelle character varying(255)
);


ALTER TABLE public.type_enseignement_dispense OWNER TO postgres;

--
-- TOC entry 684 (class 1259 OID 92231)
-- Name: type_enseignement_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_enseignement_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_enseignement_seq OWNER TO postgres;

--
-- TOC entry 685 (class 1259 OID 92232)
-- Name: type_entite_administrative; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_entite_administrative (
                                                   id bigint NOT NULL,
                                                   admin boolean DEFAULT false,
                                                   archive boolean DEFAULT false,
                                                   code character varying(500),
                                                   date_archivage date,
                                                   date_creation date,
                                                   libelle character varying(500),
                                                   username character varying(500),
                                                   visible boolean DEFAULT true
);


ALTER TABLE public.type_entite_administrative OWNER TO postgres;

--
-- TOC entry 686 (class 1259 OID 92240)
-- Name: type_entite_administrative_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_entite_administrative_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_entite_administrative_seq OWNER TO postgres;

--
-- TOC entry 687 (class 1259 OID 92241)
-- Name: type_etude; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_etude (
                                   id bigint NOT NULL,
                                   admin boolean DEFAULT false,
                                   archive boolean DEFAULT false,
                                   code character varying(500),
                                   date_archivage date,
                                   date_creation date,
                                   description text,
                                   libelle character varying(500),
                                   username character varying(500),
                                   visible boolean DEFAULT true
);


ALTER TABLE public.type_etude OWNER TO postgres;

--
-- TOC entry 688 (class 1259 OID 92249)
-- Name: type_etude_enseignement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_etude_enseignement (
                                                id bigint NOT NULL,
                                                enseignement_id bigint,
                                                type_etude_id bigint
);


ALTER TABLE public.type_etude_enseignement OWNER TO postgres;

--
-- TOC entry 689 (class 1259 OID 92252)
-- Name: type_etude_enseignement_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_etude_enseignement_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_etude_enseignement_seq OWNER TO postgres;

--
-- TOC entry 690 (class 1259 OID 92253)
-- Name: type_etude_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_etude_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_etude_seq OWNER TO postgres;

--
-- TOC entry 691 (class 1259 OID 92254)
-- Name: type_expert; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_expert (
                                    id bigint NOT NULL,
                                    admin boolean DEFAULT false,
                                    archive boolean DEFAULT false,
                                    code character varying(500),
                                    date_archivage date,
                                    date_creation date,
                                    libelle character varying(500),
                                    username character varying(500),
                                    visible boolean DEFAULT true
);


ALTER TABLE public.type_expert OWNER TO postgres;

--
-- TOC entry 692 (class 1259 OID 92262)
-- Name: type_expert_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_expert_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_expert_seq OWNER TO postgres;

--
-- TOC entry 693 (class 1259 OID 92263)
-- Name: type_expertise; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_expertise (
                                       id bigint NOT NULL,
                                       admin boolean DEFAULT false,
                                       archive boolean DEFAULT false,
                                       code character varying(500),
                                       date_archivage date,
                                       date_creation date,
                                       libelle character varying(500),
                                       username character varying(500),
                                       visible boolean DEFAULT true
);


ALTER TABLE public.type_expertise OWNER TO postgres;

--
-- TOC entry 694 (class 1259 OID 92271)
-- Name: type_expertise_evaluation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_expertise_evaluation (
                                                  id bigint NOT NULL,
                                                  admin boolean DEFAULT false,
                                                  archive boolean DEFAULT false,
                                                  code character varying(500),
                                                  date_archivage date,
                                                  date_creation date,
                                                  libelle character varying(500),
                                                  username character varying(500),
                                                  visible boolean DEFAULT true
);


ALTER TABLE public.type_expertise_evaluation OWNER TO postgres;

--
-- TOC entry 695 (class 1259 OID 92279)
-- Name: type_expertise_evaluation_comite_et_commission_evaluation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_expertise_evaluation_comite_et_commission_evaluation (
                                                                                  id bigint NOT NULL,
                                                                                  comite_et_commission_evaluation_id bigint,
                                                                                  type_expertise_evaluation_id bigint
);


ALTER TABLE public.type_expertise_evaluation_comite_et_commission_evaluation OWNER TO postgres;

--
-- TOC entry 696 (class 1259 OID 92282)
-- Name: type_expertise_evaluation_comite_et_commission_evaluation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_expertise_evaluation_comite_et_commission_evaluation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_expertise_evaluation_comite_et_commission_evaluation_seq OWNER TO postgres;

--
-- TOC entry 697 (class 1259 OID 92283)
-- Name: type_expertise_evaluation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_expertise_evaluation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_expertise_evaluation_seq OWNER TO postgres;

--
-- TOC entry 698 (class 1259 OID 92284)
-- Name: type_expertise_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_expertise_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_expertise_seq OWNER TO postgres;

--
-- TOC entry 699 (class 1259 OID 92285)
-- Name: type_instance; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_instance (
                                      id bigint NOT NULL,
                                      admin boolean DEFAULT false,
                                      archive boolean DEFAULT false,
                                      code character varying(500),
                                      date_archivage date,
                                      date_creation date,
                                      libelle character varying(500),
                                      username character varying(500),
                                      visible boolean DEFAULT true
);


ALTER TABLE public.type_instance OWNER TO postgres;

--
-- TOC entry 700 (class 1259 OID 92293)
-- Name: type_instance_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_instance_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_instance_seq OWNER TO postgres;

--
-- TOC entry 701 (class 1259 OID 92294)
-- Name: type_instrument_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_instrument_ird (
                                            id bigint NOT NULL,
                                            admin boolean DEFAULT false,
                                            archive boolean DEFAULT false,
                                            code character varying(500),
                                            date_archivage date,
                                            date_creation date,
                                            libelle character varying(500),
                                            username character varying(500),
                                            visible boolean DEFAULT true
);


ALTER TABLE public.type_instrument_ird OWNER TO postgres;

--
-- TOC entry 702 (class 1259 OID 92302)
-- Name: type_instrument_ird_chercheur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_instrument_ird_chercheur (
                                                      id bigint NOT NULL,
                                                      chercheur_id bigint,
                                                      type_instrument_ird_id bigint
);


ALTER TABLE public.type_instrument_ird_chercheur OWNER TO postgres;

--
-- TOC entry 703 (class 1259 OID 92305)
-- Name: type_instrument_ird_chercheur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_instrument_ird_chercheur_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_instrument_ird_chercheur_seq OWNER TO postgres;

--
-- TOC entry 704 (class 1259 OID 92306)
-- Name: type_instrument_ird_consultance_scientifique_ponctuelle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_instrument_ird_consultance_scientifique_ponctuelle (
                                                                                id bigint NOT NULL,
                                                                                consultance_scientifique_ponctuelle_id bigint,
                                                                                type_instrument_ird_id bigint
);


ALTER TABLE public.type_instrument_ird_consultance_scientifique_ponctuelle OWNER TO postgres;

--
-- TOC entry 705 (class 1259 OID 92309)
-- Name: type_instrument_ird_consultance_scientifique_ponctuelle_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_instrument_ird_consultance_scientifique_ponctuelle_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_instrument_ird_consultance_scientifique_ponctuelle_seq OWNER TO postgres;

--
-- TOC entry 706 (class 1259 OID 92310)
-- Name: type_instrument_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_instrument_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_instrument_ird_seq OWNER TO postgres;

--
-- TOC entry 707 (class 1259 OID 92311)
-- Name: type_instruments_et_dispositifs_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_instruments_et_dispositifs_ird (
                                                            id bigint NOT NULL,
                                                            code character varying(255),
                                                            libelle character varying(255)
);


ALTER TABLE public.type_instruments_et_dispositifs_ird OWNER TO postgres;

--
-- TOC entry 708 (class 1259 OID 92316)
-- Name: type_outil; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_outil (
                                   id bigint NOT NULL,
                                   admin boolean DEFAULT false,
                                   archive boolean DEFAULT false,
                                   code character varying(500),
                                   date_archivage date,
                                   date_creation date,
                                   libelle character varying(500),
                                   numerique boolean DEFAULT false,
                                   username character varying(500),
                                   visible boolean DEFAULT true
);


ALTER TABLE public.type_outil OWNER TO postgres;

--
-- TOC entry 709 (class 1259 OID 92325)
-- Name: type_outil_culture_scientifique_outil_pedagogique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_outil_culture_scientifique_outil_pedagogique (
                                                                          id bigint NOT NULL,
                                                                          culture_scientifique_outil_pedagogique_id bigint,
                                                                          type_outil_id bigint
);


ALTER TABLE public.type_outil_culture_scientifique_outil_pedagogique OWNER TO postgres;

--
-- TOC entry 710 (class 1259 OID 92328)
-- Name: type_outil_pedagogique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_outil_pedagogique (
                                               id bigint NOT NULL,
                                               outil_pedagogique_id bigint,
                                               type_outil_id bigint
);


ALTER TABLE public.type_outil_pedagogique OWNER TO postgres;

--
-- TOC entry 711 (class 1259 OID 92331)
-- Name: type_outil_pedagogique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_outil_pedagogique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_outil_pedagogique_seq OWNER TO postgres;

--
-- TOC entry 712 (class 1259 OID 92332)
-- Name: type_outil_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_outil_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_outil_seq OWNER TO postgres;

--
-- TOC entry 713 (class 1259 OID 92333)
-- Name: type_participation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_participation (
                                           id bigint NOT NULL,
                                           code character varying(500),
                                           libelle character varying(500)
);


ALTER TABLE public.type_participation OWNER TO postgres;

--
-- TOC entry 714 (class 1259 OID 92338)
-- Name: type_participation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_participation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_participation_seq OWNER TO postgres;

--
-- TOC entry 715 (class 1259 OID 92339)
-- Name: type_publique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_publique (
                                      id bigint NOT NULL,
                                      code character varying(500),
                                      libelle character varying(500)
);


ALTER TABLE public.type_publique OWNER TO postgres;

--
-- TOC entry 716 (class 1259 OID 92344)
-- Name: type_publique_culture_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_publique_culture_scientifique (
                                                           id bigint NOT NULL,
                                                           admin boolean DEFAULT false,
                                                           archive boolean DEFAULT false,
                                                           code character varying(500),
                                                           date_archivage date,
                                                           date_creation date,
                                                           libelle character varying(500),
                                                           username character varying(500),
                                                           visible boolean DEFAULT true
);


ALTER TABLE public.type_publique_culture_scientifique OWNER TO postgres;

--
-- TOC entry 717 (class 1259 OID 92352)
-- Name: type_publique_culture_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_publique_culture_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_publique_culture_scientifique_seq OWNER TO postgres;

--
-- TOC entry 718 (class 1259 OID 92353)
-- Name: type_publique_rencontre_grand_publique_jeune_publique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_publique_rencontre_grand_publique_jeune_publique (
                                                                              id bigint NOT NULL,
                                                                              rencontre_grand_publique_jeune_publique_id bigint,
                                                                              type_publique_id bigint
);


ALTER TABLE public.type_publique_rencontre_grand_publique_jeune_publique OWNER TO postgres;

--
-- TOC entry 719 (class 1259 OID 92356)
-- Name: type_publique_rencontre_grand_publique_jeune_publique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_publique_rencontre_grand_publique_jeune_publique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_publique_rencontre_grand_publique_jeune_publique_seq OWNER TO postgres;

--
-- TOC entry 720 (class 1259 OID 92357)
-- Name: type_publique_rencontre_media; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_publique_rencontre_media (
                                                      id bigint NOT NULL,
                                                      rencontre_media_id bigint,
                                                      type_publique_id bigint
);


ALTER TABLE public.type_publique_rencontre_media OWNER TO postgres;

--
-- TOC entry 721 (class 1259 OID 92360)
-- Name: type_publique_rencontre_media_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_publique_rencontre_media_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_publique_rencontre_media_seq OWNER TO postgres;

--
-- TOC entry 722 (class 1259 OID 92361)
-- Name: type_publique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_publique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_publique_seq OWNER TO postgres;

--
-- TOC entry 723 (class 1259 OID 92362)
-- Name: type_reclamation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_reclamation (
                                         id bigint NOT NULL,
                                         admin boolean DEFAULT false,
                                         archive boolean DEFAULT false,
                                         code character varying(500),
                                         date_archivage date,
                                         date_creation date,
                                         libelle character varying(500),
                                         username character varying(500),
                                         visible boolean DEFAULT true
);


ALTER TABLE public.type_reclamation OWNER TO postgres;

--
-- TOC entry 724 (class 1259 OID 92370)
-- Name: type_reclamation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_reclamation_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_reclamation_seq OWNER TO postgres;

--
-- TOC entry 725 (class 1259 OID 92371)
-- Name: type_savoir; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_savoir (
                                    id bigint NOT NULL,
                                    admin boolean DEFAULT false,
                                    archive boolean DEFAULT false,
                                    code character varying(500),
                                    date_archivage date,
                                    date_creation date,
                                    libelle character varying(500),
                                    username character varying(500),
                                    visible boolean DEFAULT true
);


ALTER TABLE public.type_savoir OWNER TO postgres;

--
-- TOC entry 726 (class 1259 OID 92379)
-- Name: type_savoir_developpement_de_savoir_et_innovation_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_savoir_developpement_de_savoir_et_innovation_scientifique (
                                                                                       id bigint NOT NULL,
                                                                                       developpement_de_savoir_et_innovation_scientifique_id bigint,
                                                                                       type_savoir_id bigint
);


ALTER TABLE public.type_savoir_developpement_de_savoir_et_innovation_scientifique OWNER TO postgres;

--
-- TOC entry 727 (class 1259 OID 92382)
-- Name: type_savoir_developpement_de_savoir_et_innovation_scientifique_; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_savoir_developpement_de_savoir_et_innovation_scientifique_
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_savoir_developpement_de_savoir_et_innovation_scientifique_ OWNER TO postgres;

--
-- TOC entry 728 (class 1259 OID 92383)
-- Name: type_savoir_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_savoir_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_savoir_seq OWNER TO postgres;

--
-- TOC entry 729 (class 1259 OID 92384)
-- Name: type_utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_utilisateur (
                                         id bigint NOT NULL,
                                         admin boolean DEFAULT false,
                                         archive boolean DEFAULT false,
                                         code character varying(500),
                                         date_archivage date,
                                         date_creation date,
                                         libelle character varying(500),
                                         username character varying(500),
                                         visible boolean DEFAULT true
);


ALTER TABLE public.type_utilisateur OWNER TO postgres;

--
-- TOC entry 730 (class 1259 OID 92392)
-- Name: type_utilisateur_savoir_concu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_utilisateur_savoir_concu (
                                                      id bigint NOT NULL,
                                                      developpement_de_savoir_et_innovation_scientifique_id bigint,
                                                      type_utilisateur_id bigint
);


ALTER TABLE public.type_utilisateur_savoir_concu OWNER TO postgres;

--
-- TOC entry 731 (class 1259 OID 92395)
-- Name: type_utilisateur_savoir_concu_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_utilisateur_savoir_concu_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_utilisateur_savoir_concu_seq OWNER TO postgres;

--
-- TOC entry 732 (class 1259 OID 92396)
-- Name: type_utilisateur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_utilisateur_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_utilisateur_seq OWNER TO postgres;

--
-- TOC entry 733 (class 1259 OID 92397)
-- Name: user_app; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_app (
                                 id bigint NOT NULL,
                                 account_non_expired boolean NOT NULL,
                                 account_non_locked boolean NOT NULL,
                                 created_at timestamp without time zone,
                                 credentials_non_expired boolean NOT NULL,
                                 email character varying(255),
                                 enabled boolean NOT NULL,
                                 nom character varying(255),
                                 password character varying(255),
                                 password_changed boolean NOT NULL,
                                 prenom character varying(255),
                                 updated_at timestamp without time zone,
                                 username character varying(255)
);


ALTER TABLE public.user_app OWNER TO postgres;

--
-- TOC entry 734 (class 1259 OID 92402)
-- Name: users_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_roles (
                                    user_id bigint NOT NULL,
                                    role_id bigint NOT NULL
);


ALTER TABLE public.users_roles OWNER TO postgres;

--
-- TOC entry 735 (class 1259 OID 92405)
-- Name: vie_institutionnelle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vie_institutionnelle (
                                             id bigint NOT NULL,
                                             annee bigint,
                                             temps_estime numeric(19,2),
                                             campagne_id bigint,
                                             chercheur_id bigint,
                                             etat_etape_campagne_id bigint
);


ALTER TABLE public.vie_institutionnelle OWNER TO postgres;

--
-- TOC entry 736 (class 1259 OID 92408)
-- Name: vie_institutionnelle_detail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vie_institutionnelle_detail (
                                                    id bigint NOT NULL,
                                                    coorele_instrument_ird boolean DEFAULT false,
                                                    coorele_structure_ird boolean DEFAULT false,
                                                    libelle character varying(500),
                                                    pays_id bigint,
                                                    structure_ird_id bigint,
                                                    type_instance_id bigint,
                                                    vie_institutionnelle_id bigint
);


ALTER TABLE public.vie_institutionnelle_detail OWNER TO postgres;

--
-- TOC entry 737 (class 1259 OID 92415)
-- Name: vie_institutionnelle_detail_etablissement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vie_institutionnelle_detail_etablissement (
                                                                  id bigint NOT NULL,
                                                                  etablissement_id bigint,
                                                                  vie_institutionnelle_detail_id bigint
);


ALTER TABLE public.vie_institutionnelle_detail_etablissement OWNER TO postgres;

--
-- TOC entry 738 (class 1259 OID 92418)
-- Name: vie_institutionnelle_detail_etablissement_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vie_institutionnelle_detail_etablissement_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vie_institutionnelle_detail_etablissement_seq OWNER TO postgres;

--
-- TOC entry 739 (class 1259 OID 92419)
-- Name: vie_institutionnelle_detail_instrument_ird; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vie_institutionnelle_detail_instrument_ird (
                                                                   id bigint NOT NULL,
                                                                   instrument_ird_id bigint,
                                                                   vie_institutionnelle_detail_id bigint
);


ALTER TABLE public.vie_institutionnelle_detail_instrument_ird OWNER TO postgres;

--
-- TOC entry 740 (class 1259 OID 92422)
-- Name: vie_institutionnelle_detail_instrument_ird_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vie_institutionnelle_detail_instrument_ird_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vie_institutionnelle_detail_instrument_ird_seq OWNER TO postgres;

--
-- TOC entry 741 (class 1259 OID 92423)
-- Name: vie_institutionnelle_detail_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vie_institutionnelle_detail_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vie_institutionnelle_detail_seq OWNER TO postgres;

--
-- TOC entry 742 (class 1259 OID 92424)
-- Name: vie_institutionnelle_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vie_institutionnelle_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vie_institutionnelle_seq OWNER TO postgres;

--
-- TOC entry 743 (class 1259 OID 92425)
-- Name: ville; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ville (
                              id bigint NOT NULL,
                              admin boolean DEFAULT false,
                              archive boolean DEFAULT false,
                              code character varying(500),
                              date_archivage date,
                              date_creation date,
                              libelle character varying(500),
                              username character varying(500),
                              visible boolean DEFAULT true,
                              pays_id bigint
);


ALTER TABLE public.ville OWNER TO postgres;

--
-- TOC entry 744 (class 1259 OID 92433)
-- Name: ville_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ville_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ville_seq OWNER TO postgres;

--
-- TOC entry 745 (class 1259 OID 92434)
-- Name: zone_activite_interaction_recherche; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.zone_activite_interaction_recherche (
                                                            id bigint NOT NULL,
                                                            chercheur_id bigint,
                                                            pays_id bigint,
                                                            zone_geographique_id bigint
);


ALTER TABLE public.zone_activite_interaction_recherche OWNER TO postgres;

--
-- TOC entry 746 (class 1259 OID 92437)
-- Name: zone_activite_interaction_recherche_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.zone_activite_interaction_recherche_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.zone_activite_interaction_recherche_seq OWNER TO postgres;

--
-- TOC entry 747 (class 1259 OID 92438)
-- Name: zone_geographique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.zone_geographique (
                                          id bigint NOT NULL,
                                          admin boolean DEFAULT false,
                                          archive boolean DEFAULT false,
                                          code character varying(500),
                                          date_archivage date,
                                          date_creation date,
                                          libelle character varying(500),
                                          username character varying(500),
                                          visible boolean DEFAULT true,
                                          nom_majuscule character varying(255)
);


ALTER TABLE public.zone_geographique OWNER TO postgres;

--
-- TOC entry 748 (class 1259 OID 92446)
-- Name: zone_geographique_conseils_scientifique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.zone_geographique_conseils_scientifique (
                                                                id bigint NOT NULL,
                                                                libelle character varying(500),
                                                                conseils_scientifique_id bigint,
                                                                pays_id bigint,
                                                                zone_geographique_id bigint
);


ALTER TABLE public.zone_geographique_conseils_scientifique OWNER TO postgres;

--
-- TOC entry 749 (class 1259 OID 92451)
-- Name: zone_geographique_conseils_scientifique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.zone_geographique_conseils_scientifique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.zone_geographique_conseils_scientifique_seq OWNER TO postgres;

--
-- TOC entry 750 (class 1259 OID 92452)
-- Name: zone_geographique_consultance_scientifique_ponctuelle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.zone_geographique_consultance_scientifique_ponctuelle (
                                                                              id bigint NOT NULL,
                                                                              consultance_scientifique_ponctuelle_id bigint,
                                                                              pays_id bigint,
                                                                              zone_geographique_id bigint
);


ALTER TABLE public.zone_geographique_consultance_scientifique_ponctuelle OWNER TO postgres;

--
-- TOC entry 751 (class 1259 OID 92455)
-- Name: zone_geographique_consultance_scientifique_ponctuelle_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.zone_geographique_consultance_scientifique_ponctuelle_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.zone_geographique_consultance_scientifique_ponctuelle_seq OWNER TO postgres;

--
-- TOC entry 752 (class 1259 OID 92456)
-- Name: zone_geographique_formation_continue; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.zone_geographique_formation_continue (
                                                             id bigint NOT NULL,
                                                             formation_continue_id bigint,
                                                             pays_id bigint,
                                                             zone_geographique_id bigint
);


ALTER TABLE public.zone_geographique_formation_continue OWNER TO postgres;

--
-- TOC entry 753 (class 1259 OID 92459)
-- Name: zone_geographique_formation_continue_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.zone_geographique_formation_continue_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.zone_geographique_formation_continue_seq OWNER TO postgres;

--
-- TOC entry 754 (class 1259 OID 92460)
-- Name: zone_geographique_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.zone_geographique_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.zone_geographique_seq OWNER TO postgres;

--
-- TOC entry 4842 (class 2606 OID 92462)
-- Name: affectation_structurelle affectation_structurelle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.affectation_structurelle
    ADD CONSTRAINT affectation_structurelle_pkey PRIMARY KEY (id);


--
-- TOC entry 4844 (class 2606 OID 92464)
-- Name: bourse bourse_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bourse
    ADD CONSTRAINT bourse_pkey PRIMARY KEY (id);


--
-- TOC entry 4850 (class 2606 OID 92466)
-- Name: campagne_chercheur_fermeture campagne_chercheur_fermeture_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_chercheur_fermeture
    ADD CONSTRAINT campagne_chercheur_fermeture_pkey PRIMARY KEY (id);


--
-- TOC entry 4852 (class 2606 OID 92468)
-- Name: campagne_chercheur_ouverture campagne_chercheur_ouverture_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_chercheur_ouverture
    ADD CONSTRAINT campagne_chercheur_ouverture_pkey PRIMARY KEY (id);


--
-- TOC entry 4848 (class 2606 OID 92470)
-- Name: campagne_chercheur campagne_chercheur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_chercheur
    ADD CONSTRAINT campagne_chercheur_pkey PRIMARY KEY (id);


--
-- TOC entry 4846 (class 2606 OID 92472)
-- Name: campagne campagne_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne
    ADD CONSTRAINT campagne_pkey PRIMARY KEY (id);


--
-- TOC entry 4856 (class 2606 OID 92474)
-- Name: campagne_rappel_chercheur campagne_rappel_chercheur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_rappel_chercheur
    ADD CONSTRAINT campagne_rappel_chercheur_pkey PRIMARY KEY (id);


--
-- TOC entry 4854 (class 2606 OID 92476)
-- Name: campagne_rappel campagne_rappel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_rappel
    ADD CONSTRAINT campagne_rappel_pkey PRIMARY KEY (id);


--
-- TOC entry 4860 (class 2606 OID 92478)
-- Name: campagne_relance_chercheur campagne_relance_chercheur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_relance_chercheur
    ADD CONSTRAINT campagne_relance_chercheur_pkey PRIMARY KEY (id);


--
-- TOC entry 4858 (class 2606 OID 92480)
-- Name: campagne_relance campagne_relance_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_relance
    ADD CONSTRAINT campagne_relance_pkey PRIMARY KEY (id);


--
-- TOC entry 4864 (class 2606 OID 92482)
-- Name: caracterisation_dev_de_savoir_et_innov caracterisation_dev_de_savoir_et_innov_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracterisation_dev_de_savoir_et_innov
    ADD CONSTRAINT caracterisation_dev_de_savoir_et_innov_pkey PRIMARY KEY (id);


--
-- TOC entry 4866 (class 2606 OID 92484)
-- Name: caracterisation_developpement_de_savoir_et_innovation_scientifi caracterisation_developpement_de_savoir_et_innovation_scie_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracterisation_developpement_de_savoir_et_innovation_scientifi
    ADD CONSTRAINT caracterisation_developpement_de_savoir_et_innovation_scie_pkey PRIMARY KEY (id);


--
-- TOC entry 4862 (class 2606 OID 92486)
-- Name: caracterisation caracterisation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracterisation
    ADD CONSTRAINT caracterisation_pkey PRIMARY KEY (id);


--
-- TOC entry 4868 (class 2606 OID 92488)
-- Name: categorie_faq categorie_faq_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categorie_faq
    ADD CONSTRAINT categorie_faq_pkey PRIMARY KEY (id);


--
-- TOC entry 4870 (class 2606 OID 92490)
-- Name: categorie_notification categorie_notification_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categorie_notification
    ADD CONSTRAINT categorie_notification_pkey PRIMARY KEY (id);


--
-- TOC entry 4874 (class 2606 OID 92492)
-- Name: chercheur_email chercheur_email_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chercheur_email
    ADD CONSTRAINT chercheur_email_pkey PRIMARY KEY (id);


--
-- TOC entry 4872 (class 2606 OID 92494)
-- Name: chercheur chercheur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chercheur
    ADD CONSTRAINT chercheur_pkey PRIMARY KEY (id);


--
-- TOC entry 4876 (class 2606 OID 92496)
-- Name: comite_et_commission_evaluation comite_et_commission_evaluation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comite_et_commission_evaluation
    ADD CONSTRAINT comite_et_commission_evaluation_pkey PRIMARY KEY (id);


--
-- TOC entry 4878 (class 2606 OID 92498)
-- Name: commanditaire commanditaire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commanditaire
    ADD CONSTRAINT commanditaire_pkey PRIMARY KEY (id);


--
-- TOC entry 4880 (class 2606 OID 92500)
-- Name: commission_scientifique commission_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commission_scientifique
    ADD CONSTRAINT commission_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4884 (class 2606 OID 92502)
-- Name: communaute_savoir_chercheur communaute_savoir_chercheur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_chercheur
    ADD CONSTRAINT communaute_savoir_chercheur_pkey PRIMARY KEY (id);


--
-- TOC entry 4886 (class 2606 OID 92504)
-- Name: communaute_savoir_conseil_et_comite_scientifique communaute_savoir_conseil_et_comite_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_conseil_et_comite_scientifique
    ADD CONSTRAINT communaute_savoir_conseil_et_comite_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4888 (class 2606 OID 92506)
-- Name: communaute_savoir_encadrement_doctorant communaute_savoir_encadrement_doctorant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_encadrement_doctorant
    ADD CONSTRAINT communaute_savoir_encadrement_doctorant_pkey PRIMARY KEY (id);


--
-- TOC entry 4890 (class 2606 OID 92508)
-- Name: communaute_savoir_encadrement_etudiant communaute_savoir_encadrement_etudiant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_encadrement_etudiant
    ADD CONSTRAINT communaute_savoir_encadrement_etudiant_pkey PRIMARY KEY (id);


--
-- TOC entry 4892 (class 2606 OID 92510)
-- Name: communaute_savoir_evaluation_recherche_universitaire communaute_savoir_evaluation_recherche_universitaire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_evaluation_recherche_universitaire
    ADD CONSTRAINT communaute_savoir_evaluation_recherche_universitaire_pkey PRIMARY KEY (id);


--
-- TOC entry 4894 (class 2606 OID 92512)
-- Name: communaute_savoir_evenement_colloque_scientifique communaute_savoir_evenement_colloque_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_evenement_colloque_scientifique
    ADD CONSTRAINT communaute_savoir_evenement_colloque_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4896 (class 2606 OID 92514)
-- Name: communaute_savoir_expertise_scientifique communaute_savoir_expertise_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_expertise_scientifique
    ADD CONSTRAINT communaute_savoir_expertise_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4882 (class 2606 OID 92516)
-- Name: communaute_savoir communaute_savoir_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir
    ADD CONSTRAINT communaute_savoir_pkey PRIMARY KEY (id);


--
-- TOC entry 4898 (class 2606 OID 92518)
-- Name: communaute_savoir_projet_activite_recherche communaute_savoir_projet_activite_recherche_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_projet_activite_recherche
    ADD CONSTRAINT communaute_savoir_projet_activite_recherche_pkey PRIMARY KEY (id);


--
-- TOC entry 4900 (class 2606 OID 92520)
-- Name: conseil_et_comite_scientifique conseil_et_comite_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.conseil_et_comite_scientifique
    ADD CONSTRAINT conseil_et_comite_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4902 (class 2606 OID 92522)
-- Name: conseils_scientifique conseils_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.conseils_scientifique
    ADD CONSTRAINT conseils_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4904 (class 2606 OID 92524)
-- Name: consultance_scientifique_ponctuelle consultance_scientifique_ponctuelle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultance_scientifique_ponctuelle
    ADD CONSTRAINT consultance_scientifique_ponctuelle_pkey PRIMARY KEY (id);


--
-- TOC entry 4908 (class 2606 OID 92526)
-- Name: contexte_culture_scientifique_recontre_grand_public_jeune_publi contexte_culture_scientifique_recontre_grand_public_jeune__pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contexte_culture_scientifique_recontre_grand_public_jeune_publi
    ADD CONSTRAINT contexte_culture_scientifique_recontre_grand_public_jeune__pkey PRIMARY KEY (id);


--
-- TOC entry 4906 (class 2606 OID 92528)
-- Name: contexte contexte_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contexte
    ADD CONSTRAINT contexte_pkey PRIMARY KEY (id);


--
-- TOC entry 4910 (class 2606 OID 92530)
-- Name: contexte_rencontre_grand_publique_jeune_publique contexte_rencontre_grand_publique_jeune_publique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contexte_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT contexte_rencontre_grand_publique_jeune_publique_pkey PRIMARY KEY (id);


--
-- TOC entry 4912 (class 2606 OID 92532)
-- Name: continent continent_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.continent
    ADD CONSTRAINT continent_pkey PRIMARY KEY (id);


--
-- TOC entry 4916 (class 2606 OID 92534)
-- Name: contrat_et_convention_ird_partenaire contrat_et_convention_ird_partenaire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contrat_et_convention_ird_partenaire
    ADD CONSTRAINT contrat_et_convention_ird_partenaire_pkey PRIMARY KEY (id);


--
-- TOC entry 4914 (class 2606 OID 92536)
-- Name: contrat_et_convention_ird contrat_et_convention_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contrat_et_convention_ird
    ADD CONSTRAINT contrat_et_convention_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 4918 (class 2606 OID 92538)
-- Name: corps corps_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.corps
    ADD CONSTRAINT corps_pkey PRIMARY KEY (id);


--
-- TOC entry 4922 (class 2606 OID 92540)
-- Name: culture_scientifique_outil_pedagogique culture_scientifique_outil_pedagogique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.culture_scientifique_outil_pedagogique
    ADD CONSTRAINT culture_scientifique_outil_pedagogique_pkey PRIMARY KEY (id);


--
-- TOC entry 4920 (class 2606 OID 92542)
-- Name: culture_scientifique culture_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.culture_scientifique
    ADD CONSTRAINT culture_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4924 (class 2606 OID 92544)
-- Name: culture_scientifique_recontre_grand_public_jeune_public culture_scientifique_recontre_grand_public_jeune_public_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.culture_scientifique_recontre_grand_public_jeune_public
    ADD CONSTRAINT culture_scientifique_recontre_grand_public_jeune_public_pkey PRIMARY KEY (id);


--
-- TOC entry 4926 (class 2606 OID 92546)
-- Name: departement_scientifique departement_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departement_scientifique
    ADD CONSTRAINT departement_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4930 (class 2606 OID 92548)
-- Name: dev_savoir_innov_scientifique_discipline_scientifique dev_savoir_innov_scientifique_discipline_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_discipline_scientifique
    ADD CONSTRAINT dev_savoir_innov_scientifique_discipline_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4932 (class 2606 OID 92550)
-- Name: dev_savoir_innov_scientifique_enjeux_ird dev_savoir_innov_scientifique_enjeux_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_enjeux_ird
    ADD CONSTRAINT dev_savoir_innov_scientifique_enjeux_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 4934 (class 2606 OID 92552)
-- Name: dev_savoir_innov_scientifique_instrument_ird dev_savoir_innov_scientifique_instrument_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_instrument_ird
    ADD CONSTRAINT dev_savoir_innov_scientifique_instrument_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 4936 (class 2606 OID 92554)
-- Name: dev_savoir_innov_scientifique_mode_diffusion dev_savoir_innov_scientifique_mode_diffusion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_mode_diffusion
    ADD CONSTRAINT dev_savoir_innov_scientifique_mode_diffusion_pkey PRIMARY KEY (id);


--
-- TOC entry 4938 (class 2606 OID 92556)
-- Name: dev_savoir_innov_scientifique_pays dev_savoir_innov_scientifique_pays_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_pays
    ADD CONSTRAINT dev_savoir_innov_scientifique_pays_pkey PRIMARY KEY (id);


--
-- TOC entry 4928 (class 2606 OID 92558)
-- Name: dev_savoir_innov_scientifique dev_savoir_innov_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique
    ADD CONSTRAINT dev_savoir_innov_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4940 (class 2606 OID 92560)
-- Name: dev_savoir_innov_scientifique_role dev_savoir_innov_scientifique_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_role
    ADD CONSTRAINT dev_savoir_innov_scientifique_role_pkey PRIMARY KEY (id);


--
-- TOC entry 4944 (class 2606 OID 92562)
-- Name: developpement_de_savoir_et_innovation_scientifique_enjeux_ird developpement_de_savoir_et_innovation_scientifique_enjeux__pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developpement_de_savoir_et_innovation_scientifique_enjeux_ird
    ADD CONSTRAINT developpement_de_savoir_et_innovation_scientifique_enjeux__pkey PRIMARY KEY (id);


--
-- TOC entry 4946 (class 2606 OID 92564)
-- Name: developpement_de_savoir_et_innovation_scientifique_pays developpement_de_savoir_et_innovation_scientifique_pays_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developpement_de_savoir_et_innovation_scientifique_pays
    ADD CONSTRAINT developpement_de_savoir_et_innovation_scientifique_pays_pkey PRIMARY KEY (id);


--
-- TOC entry 4942 (class 2606 OID 92566)
-- Name: developpement_de_savoir_et_innovation_scientifique developpement_de_savoir_et_innovation_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developpement_de_savoir_et_innovation_scientifique
    ADD CONSTRAINT developpement_de_savoir_et_innovation_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4948 (class 2606 OID 92568)
-- Name: developpement_de_savoir_et_innovation_scientifique_type_savoir developpement_de_savoir_et_innovation_scientifique_type_sa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developpement_de_savoir_et_innovation_scientifique_type_savoir
    ADD CONSTRAINT developpement_de_savoir_et_innovation_scientifique_type_sa_pkey PRIMARY KEY (id);


--
-- TOC entry 4952 (class 2606 OID 92570)
-- Name: discipline_scientifique_chercheur discipline_scientifique_chercheur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_chercheur
    ADD CONSTRAINT discipline_scientifique_chercheur_pkey PRIMARY KEY (id);


--
-- TOC entry 4954 (class 2606 OID 92572)
-- Name: discipline_scientifique_comite_et_commission_evaluation discipline_scientifique_comite_et_commission_evaluation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_comite_et_commission_evaluation
    ADD CONSTRAINT discipline_scientifique_comite_et_commission_evaluation_pkey PRIMARY KEY (id);


--
-- TOC entry 4956 (class 2606 OID 92574)
-- Name: discipline_scientifique_conseil_et_comite_scientifique discipline_scientifique_conseil_et_comite_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_conseil_et_comite_scientifique
    ADD CONSTRAINT discipline_scientifique_conseil_et_comite_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4958 (class 2606 OID 92576)
-- Name: discipline_scientifique_conseils_scientifique discipline_scientifique_conseils_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_conseils_scientifique
    ADD CONSTRAINT discipline_scientifique_conseils_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4960 (class 2606 OID 92578)
-- Name: discipline_scientifique_consultance_scientifique_ponctuelle discipline_scientifique_consultance_scientifique_ponctuell_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_consultance_scientifique_ponctuelle
    ADD CONSTRAINT discipline_scientifique_consultance_scientifique_ponctuell_pkey PRIMARY KEY (id);


--
-- TOC entry 4962 (class 2606 OID 92580)
-- Name: discipline_scientifique_direction_encadrement_doctorant discipline_scientifique_direction_encadrement_doctorant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_direction_encadrement_doctorant
    ADD CONSTRAINT discipline_scientifique_direction_encadrement_doctorant_pkey PRIMARY KEY (id);


--
-- TOC entry 4964 (class 2606 OID 92582)
-- Name: discipline_scientifique_encadrement_doctorant discipline_scientifique_encadrement_doctorant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_encadrement_doctorant
    ADD CONSTRAINT discipline_scientifique_encadrement_doctorant_pkey PRIMARY KEY (id);


--
-- TOC entry 4966 (class 2606 OID 92584)
-- Name: discipline_scientifique_encadrement_etudiant discipline_scientifique_encadrement_etudiant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_encadrement_etudiant
    ADD CONSTRAINT discipline_scientifique_encadrement_etudiant_pkey PRIMARY KEY (id);


--
-- TOC entry 4970 (class 2606 OID 92586)
-- Name: discipline_scientifique_erc_association discipline_scientifique_erc_association_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_erc_association
    ADD CONSTRAINT discipline_scientifique_erc_association_pkey PRIMARY KEY (id);


--
-- TOC entry 4968 (class 2606 OID 92588)
-- Name: discipline_scientifique_erc discipline_scientifique_erc_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_erc
    ADD CONSTRAINT discipline_scientifique_erc_pkey PRIMARY KEY (id);


--
-- TOC entry 4972 (class 2606 OID 92590)
-- Name: discipline_scientifique_evaluation_recherche_universitaire discipline_scientifique_evaluation_recherche_universitaire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_evaluation_recherche_universitaire
    ADD CONSTRAINT discipline_scientifique_evaluation_recherche_universitaire_pkey PRIMARY KEY (id);


--
-- TOC entry 4974 (class 2606 OID 92592)
-- Name: discipline_scientifique_evenement_colloque_scientifique discipline_scientifique_evenement_colloque_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_evenement_colloque_scientifique
    ADD CONSTRAINT discipline_scientifique_evenement_colloque_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4976 (class 2606 OID 92594)
-- Name: discipline_scientifique_expertise_scientifique discipline_scientifique_expertise_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_expertise_scientifique
    ADD CONSTRAINT discipline_scientifique_expertise_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4950 (class 2606 OID 92596)
-- Name: discipline_scientifique discipline_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique
    ADD CONSTRAINT discipline_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4980 (class 2606 OID 92598)
-- Name: distinction_etablissement_pays distinction_etablissement_pays_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.distinction_etablissement_pays
    ADD CONSTRAINT distinction_etablissement_pays_pkey PRIMARY KEY (id);


--
-- TOC entry 4978 (class 2606 OID 92600)
-- Name: distinction distinction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.distinction
    ADD CONSTRAINT distinction_pkey PRIMARY KEY (id);


--
-- TOC entry 4982 (class 2606 OID 92602)
-- Name: doctorant doctorant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.doctorant
    ADD CONSTRAINT doctorant_pkey PRIMARY KEY (id);


--
-- TOC entry 4986 (class 2606 OID 92604)
-- Name: domaine_scientifique_chercheur domaine_scientifique_chercheur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.domaine_scientifique_chercheur
    ADD CONSTRAINT domaine_scientifique_chercheur_pkey PRIMARY KEY (id);


--
-- TOC entry 4984 (class 2606 OID 92606)
-- Name: domaine_scientifique domaine_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.domaine_scientifique
    ADD CONSTRAINT domaine_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4988 (class 2606 OID 92608)
-- Name: ecole_doctorale ecole_doctorale_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ecole_doctorale
    ADD CONSTRAINT ecole_doctorale_pkey PRIMARY KEY (id);


--
-- TOC entry 4992 (class 2606 OID 92610)
-- Name: encadrement_doctorant encadrement_doctorant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_doctorant
    ADD CONSTRAINT encadrement_doctorant_pkey PRIMARY KEY (id);


--
-- TOC entry 4996 (class 2606 OID 92612)
-- Name: encadrement_etudiant_discipline_scientifique encadrement_etudiant_discipline_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_etudiant_discipline_scientifique
    ADD CONSTRAINT encadrement_etudiant_discipline_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 4998 (class 2606 OID 92614)
-- Name: encadrement_etudiant_enjeux_ird encadrement_etudiant_enjeux_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_etudiant_enjeux_ird
    ADD CONSTRAINT encadrement_etudiant_enjeux_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 4994 (class 2606 OID 92616)
-- Name: encadrement_etudiant encadrement_etudiant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_etudiant
    ADD CONSTRAINT encadrement_etudiant_pkey PRIMARY KEY (id);


--
-- TOC entry 4990 (class 2606 OID 92618)
-- Name: encadrement encadrement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement
    ADD CONSTRAINT encadrement_pkey PRIMARY KEY (id);


--
-- TOC entry 5002 (class 2606 OID 92620)
-- Name: enjeux_ird_chercheur enjeux_ird_chercheur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enjeux_ird_chercheur
    ADD CONSTRAINT enjeux_ird_chercheur_pkey PRIMARY KEY (id);


--
-- TOC entry 5004 (class 2606 OID 92622)
-- Name: enjeux_ird_comite_et_commission_evaluation enjeux_ird_comite_et_commission_evaluation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enjeux_ird_comite_et_commission_evaluation
    ADD CONSTRAINT enjeux_ird_comite_et_commission_evaluation_pkey PRIMARY KEY (id);


--
-- TOC entry 5006 (class 2606 OID 92624)
-- Name: enjeux_ird_conseils_scientifique enjeux_ird_conseils_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enjeux_ird_conseils_scientifique
    ADD CONSTRAINT enjeux_ird_conseils_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 5008 (class 2606 OID 92626)
-- Name: enjeux_ird_consultance_scientifique_ponctuelle enjeux_ird_consultance_scientifique_ponctuelle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enjeux_ird_consultance_scientifique_ponctuelle
    ADD CONSTRAINT enjeux_ird_consultance_scientifique_ponctuelle_pkey PRIMARY KEY (id);


--
-- TOC entry 5010 (class 2606 OID 92628)
-- Name: enjeux_ird_encadrement_doctorant enjeux_ird_encadrement_doctorant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enjeux_ird_encadrement_doctorant
    ADD CONSTRAINT enjeux_ird_encadrement_doctorant_pkey PRIMARY KEY (id);


--
-- TOC entry 5000 (class 2606 OID 92630)
-- Name: enjeux_ird enjeux_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enjeux_ird
    ADD CONSTRAINT enjeux_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5014 (class 2606 OID 92632)
-- Name: enseignement_discipline_scientifique enseignement_discipline_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_discipline_scientifique
    ADD CONSTRAINT enseignement_discipline_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 5016 (class 2606 OID 92634)
-- Name: enseignement_enjeux_ird enseignement_enjeux_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_enjeux_ird
    ADD CONSTRAINT enseignement_enjeux_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5018 (class 2606 OID 92636)
-- Name: enseignement_et_formation enseignement_et_formation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_et_formation
    ADD CONSTRAINT enseignement_et_formation_pkey PRIMARY KEY (id);


--
-- TOC entry 5020 (class 2606 OID 92638)
-- Name: enseignement_nature enseignement_nature_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_nature
    ADD CONSTRAINT enseignement_nature_pkey PRIMARY KEY (id);


--
-- TOC entry 5012 (class 2606 OID 92640)
-- Name: enseignement enseignement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement
    ADD CONSTRAINT enseignement_pkey PRIMARY KEY (id);


--
-- TOC entry 5022 (class 2606 OID 92642)
-- Name: enseignement_zone_geographique enseignement_zone_geographique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_zone_geographique
    ADD CONSTRAINT enseignement_zone_geographique_pkey PRIMARY KEY (id);


--
-- TOC entry 5024 (class 2606 OID 92644)
-- Name: entite_administrative entite_administrative_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entite_administrative
    ADD CONSTRAINT entite_administrative_pkey PRIMARY KEY (id);


--
-- TOC entry 5028 (class 2606 OID 92646)
-- Name: etablissement_comite_et_commission_evaluation etablissement_comite_et_commission_evaluation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_comite_et_commission_evaluation
    ADD CONSTRAINT etablissement_comite_et_commission_evaluation_pkey PRIMARY KEY (id);


--
-- TOC entry 5030 (class 2606 OID 92648)
-- Name: etablissement_conseils_scientifique etablissement_conseils_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_conseils_scientifique
    ADD CONSTRAINT etablissement_conseils_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 5032 (class 2606 OID 92650)
-- Name: etablissement_consultance_scientifique_ponctuelle etablissement_consultance_scientifique_ponctuelle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_consultance_scientifique_ponctuelle
    ADD CONSTRAINT etablissement_consultance_scientifique_ponctuelle_pkey PRIMARY KEY (id);


--
-- TOC entry 5034 (class 2606 OID 92652)
-- Name: etablissement_culture_scientifique_outil_pedagogique etablissement_culture_scientifique_outil_pedagogique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_culture_scientifique_outil_pedagogique
    ADD CONSTRAINT etablissement_culture_scientifique_outil_pedagogique_pkey PRIMARY KEY (id);


--
-- TOC entry 5036 (class 2606 OID 92654)
-- Name: etablissement_culture_scientifique_recontre_grand_public_jeune_ etablissement_culture_scientifique_recontre_grand_public_j_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_culture_scientifique_recontre_grand_public_jeune_
    ADD CONSTRAINT etablissement_culture_scientifique_recontre_grand_public_j_pkey PRIMARY KEY (id);


--
-- TOC entry 5038 (class 2606 OID 92656)
-- Name: etablissement_encadrement_doctorant etablissement_encadrement_doctorant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_encadrement_doctorant
    ADD CONSTRAINT etablissement_encadrement_doctorant_pkey PRIMARY KEY (id);


--
-- TOC entry 5040 (class 2606 OID 92658)
-- Name: etablissement_encadrement_etudiant etablissement_encadrement_etudiant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_encadrement_etudiant
    ADD CONSTRAINT etablissement_encadrement_etudiant_pkey PRIMARY KEY (id);


--
-- TOC entry 5042 (class 2606 OID 92660)
-- Name: etablissement_enseignement etablissement_enseignement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_enseignement
    ADD CONSTRAINT etablissement_enseignement_pkey PRIMARY KEY (id);


--
-- TOC entry 5044 (class 2606 OID 92662)
-- Name: etablissement_partenaire etablissement_partenaire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_partenaire
    ADD CONSTRAINT etablissement_partenaire_pkey PRIMARY KEY (id);


--
-- TOC entry 5026 (class 2606 OID 92664)
-- Name: etablissement etablissement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement
    ADD CONSTRAINT etablissement_pkey PRIMARY KEY (id);


--
-- TOC entry 5046 (class 2606 OID 92666)
-- Name: etablissement_projet etablissement_projet_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_projet
    ADD CONSTRAINT etablissement_projet_pkey PRIMARY KEY (id);


--
-- TOC entry 5048 (class 2606 OID 92668)
-- Name: etablissement_rencontre_grand_publique_jeune_publique etablissement_rencontre_grand_publique_jeune_publique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT etablissement_rencontre_grand_publique_jeune_publique_pkey PRIMARY KEY (id);


--
-- TOC entry 5052 (class 2606 OID 92670)
-- Name: etat_campagne_chercheur etat_campagne_chercheur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etat_campagne_chercheur
    ADD CONSTRAINT etat_campagne_chercheur_pkey PRIMARY KEY (id);


--
-- TOC entry 5050 (class 2606 OID 92672)
-- Name: etat_campagne etat_campagne_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etat_campagne
    ADD CONSTRAINT etat_campagne_pkey PRIMARY KEY (id);


--
-- TOC entry 5054 (class 2606 OID 92674)
-- Name: etat_etape_campagne etat_etape_campagne_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etat_etape_campagne
    ADD CONSTRAINT etat_etape_campagne_pkey PRIMARY KEY (id);


--
-- TOC entry 5056 (class 2606 OID 92676)
-- Name: etat_reclamation etat_reclamation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etat_reclamation
    ADD CONSTRAINT etat_reclamation_pkey PRIMARY KEY (id);


--
-- TOC entry 5058 (class 2606 OID 92678)
-- Name: etudiant etudiant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etudiant
    ADD CONSTRAINT etudiant_pkey PRIMARY KEY (id);


--
-- TOC entry 5060 (class 2606 OID 92680)
-- Name: evaluation_encadrement evaluation_encadrement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation_encadrement
    ADD CONSTRAINT evaluation_encadrement_pkey PRIMARY KEY (id);


--
-- TOC entry 5062 (class 2606 OID 92682)
-- Name: evaluation_recherche_universitaire evaluation_recherche_universitaire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation_recherche_universitaire
    ADD CONSTRAINT evaluation_recherche_universitaire_pkey PRIMARY KEY (id);


--
-- TOC entry 5066 (class 2606 OID 92684)
-- Name: evenement_colloque_scienntifique_enjeux_ird evenement_colloque_scienntifique_enjeux_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement_colloque_scienntifique_enjeux_ird
    ADD CONSTRAINT evenement_colloque_scienntifique_enjeux_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5068 (class 2606 OID 92686)
-- Name: evenement_colloque_scienntifique_pays evenement_colloque_scienntifique_pays_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement_colloque_scienntifique_pays
    ADD CONSTRAINT evenement_colloque_scienntifique_pays_pkey PRIMARY KEY (id);


--
-- TOC entry 5064 (class 2606 OID 92688)
-- Name: evenement_colloque_scienntifique evenement_colloque_scienntifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement_colloque_scienntifique
    ADD CONSTRAINT evenement_colloque_scienntifique_pkey PRIMARY KEY (id);


--
-- TOC entry 5070 (class 2606 OID 92690)
-- Name: evenement_colloque_scientifique_instrument_ird evenement_colloque_scientifique_instrument_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement_colloque_scientifique_instrument_ird
    ADD CONSTRAINT evenement_colloque_scientifique_instrument_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5072 (class 2606 OID 92692)
-- Name: expertise expertise_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expertise
    ADD CONSTRAINT expertise_pkey PRIMARY KEY (id);


--
-- TOC entry 5074 (class 2606 OID 92694)
-- Name: expertise_scientifique expertise_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expertise_scientifique
    ADD CONSTRAINT expertise_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 5076 (class 2606 OID 92696)
-- Name: faq faq_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.faq
    ADD CONSTRAINT faq_pkey PRIMARY KEY (id);


--
-- TOC entry 5078 (class 2606 OID 92698)
-- Name: financement_doctorant financement_doctorant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.financement_doctorant
    ADD CONSTRAINT financement_doctorant_pkey PRIMARY KEY (id);


--
-- TOC entry 5080 (class 2606 OID 92700)
-- Name: financement_encadrement_doctorant financement_encadrement_doctorant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.financement_encadrement_doctorant
    ADD CONSTRAINT financement_encadrement_doctorant_pkey PRIMARY KEY (id);


--
-- TOC entry 5082 (class 2606 OID 92702)
-- Name: format_rencontre format_rencontre_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.format_rencontre
    ADD CONSTRAINT format_rencontre_pkey PRIMARY KEY (id);


--
-- TOC entry 5086 (class 2606 OID 92704)
-- Name: formation_continue_commanditaire formation_continue_commanditaire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue_commanditaire
    ADD CONSTRAINT formation_continue_commanditaire_pkey PRIMARY KEY (id);


--
-- TOC entry 5088 (class 2606 OID 92706)
-- Name: formation_continue_discipline_scientifique formation_continue_discipline_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue_discipline_scientifique
    ADD CONSTRAINT formation_continue_discipline_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 5090 (class 2606 OID 92708)
-- Name: formation_continue_enjeux_ird formation_continue_enjeux_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue_enjeux_ird
    ADD CONSTRAINT formation_continue_enjeux_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5092 (class 2606 OID 92710)
-- Name: formation_continue_objet_formation_generique formation_continue_objet_formation_generique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue_objet_formation_generique
    ADD CONSTRAINT formation_continue_objet_formation_generique_pkey PRIMARY KEY (id);


--
-- TOC entry 5084 (class 2606 OID 92712)
-- Name: formation_continue formation_continue_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue
    ADD CONSTRAINT formation_continue_pkey PRIMARY KEY (id);


--
-- TOC entry 5094 (class 2606 OID 92714)
-- Name: formation_continue_publique_professionel formation_continue_publique_professionel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue_publique_professionel
    ADD CONSTRAINT formation_continue_publique_professionel_pkey PRIMARY KEY (id);


--
-- TOC entry 5096 (class 2606 OID 92716)
-- Name: fournisseur_appel_projet_recherche fournisseur_appel_projet_recherche_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fournisseur_appel_projet_recherche
    ADD CONSTRAINT fournisseur_appel_projet_recherche_pkey PRIMARY KEY (id);


--
-- TOC entry 5100 (class 2606 OID 92718)
-- Name: gestion_equipe_detail gestion_equipe_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gestion_equipe_detail
    ADD CONSTRAINT gestion_equipe_detail_pkey PRIMARY KEY (id);


--
-- TOC entry 5098 (class 2606 OID 92720)
-- Name: gestion_equipe gestion_equipe_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gestion_equipe
    ADD CONSTRAINT gestion_equipe_pkey PRIMARY KEY (id);


--
-- TOC entry 5102 (class 2606 OID 92722)
-- Name: grade grade_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grade
    ADD CONSTRAINT grade_pkey PRIMARY KEY (id);


--
-- TOC entry 5104 (class 2606 OID 92724)
-- Name: identifiant_auteur_expert identifiant_auteur_expert_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.identifiant_auteur_expert
    ADD CONSTRAINT identifiant_auteur_expert_pkey PRIMARY KEY (id);


--
-- TOC entry 5106 (class 2606 OID 92726)
-- Name: identifiant_recherche identifiant_recherche_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.identifiant_recherche
    ADD CONSTRAINT identifiant_recherche_pkey PRIMARY KEY (id);


--
-- TOC entry 5110 (class 2606 OID 92728)
-- Name: institution_co_contractant institution_co_contractant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.institution_co_contractant
    ADD CONSTRAINT institution_co_contractant_pkey PRIMARY KEY (id);


--
-- TOC entry 5112 (class 2606 OID 92730)
-- Name: institution_co_contractant_projet_activite_recherche institution_co_contractant_projet_activite_recherche_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.institution_co_contractant_projet_activite_recherche
    ADD CONSTRAINT institution_co_contractant_projet_activite_recherche_pkey PRIMARY KEY (id);


--
-- TOC entry 5108 (class 2606 OID 92732)
-- Name: institution institution_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.institution
    ADD CONSTRAINT institution_pkey PRIMARY KEY (id);


--
-- TOC entry 5116 (class 2606 OID 92734)
-- Name: instrument_ird_chercheur instrument_ird_chercheur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instrument_ird_chercheur
    ADD CONSTRAINT instrument_ird_chercheur_pkey PRIMARY KEY (id);


--
-- TOC entry 5118 (class 2606 OID 92736)
-- Name: instrument_ird_comite_et_commission_evaluation instrument_ird_comite_et_commission_evaluation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instrument_ird_comite_et_commission_evaluation
    ADD CONSTRAINT instrument_ird_comite_et_commission_evaluation_pkey PRIMARY KEY (id);


--
-- TOC entry 5120 (class 2606 OID 92738)
-- Name: instrument_ird_consultance_scientifique_ponctuelle instrument_ird_consultance_scientifique_ponctuelle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instrument_ird_consultance_scientifique_ponctuelle
    ADD CONSTRAINT instrument_ird_consultance_scientifique_ponctuelle_pkey PRIMARY KEY (id);


--
-- TOC entry 5114 (class 2606 OID 92740)
-- Name: instrument_ird instrument_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instrument_ird
    ADD CONSTRAINT instrument_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5124 (class 2606 OID 92742)
-- Name: instruments_et_dispositifs_ird_chercheur instruments_et_dispositifs_ird_chercheur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instruments_et_dispositifs_ird_chercheur
    ADD CONSTRAINT instruments_et_dispositifs_ird_chercheur_pkey PRIMARY KEY (id);


--
-- TOC entry 5122 (class 2606 OID 92744)
-- Name: instruments_et_dispositifs_ird instruments_et_dispositifs_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instruments_et_dispositifs_ird
    ADD CONSTRAINT instruments_et_dispositifs_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5126 (class 2606 OID 92746)
-- Name: instruments_et_dispositifs_ird_projet_activite_recherche instruments_et_dispositifs_ird_projet_activite_recherche_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instruments_et_dispositifs_ird_projet_activite_recherche
    ADD CONSTRAINT instruments_et_dispositifs_ird_projet_activite_recherche_pkey PRIMARY KEY (id);


--
-- TOC entry 5130 (class 2606 OID 92748)
-- Name: key_word_discipline_scientifique_erc key_word_discipline_scientifique_erc_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_word_discipline_scientifique_erc
    ADD CONSTRAINT key_word_discipline_scientifique_erc_pkey PRIMARY KEY (id);


--
-- TOC entry 5128 (class 2606 OID 92750)
-- Name: key_word key_word_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_word
    ADD CONSTRAINT key_word_pkey PRIMARY KEY (id);


--
-- TOC entry 5132 (class 2606 OID 92752)
-- Name: langue langue_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.langue
    ADD CONSTRAINT langue_pkey PRIMARY KEY (id);


--
-- TOC entry 5136 (class 2606 OID 92754)
-- Name: master_international master_international_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.master_international
    ADD CONSTRAINT master_international_pkey PRIMARY KEY (id);


--
-- TOC entry 5134 (class 2606 OID 92756)
-- Name: master master_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.master
    ADD CONSTRAINT master_pkey PRIMARY KEY (id);


--
-- TOC entry 5142 (class 2606 OID 92758)
-- Name: modalite_etude_enseignement modalite_etude_enseignement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modalite_etude_enseignement
    ADD CONSTRAINT modalite_etude_enseignement_pkey PRIMARY KEY (id);


--
-- TOC entry 5140 (class 2606 OID 92760)
-- Name: modalite_etude modalite_etude_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modalite_etude
    ADD CONSTRAINT modalite_etude_pkey PRIMARY KEY (id);


--
-- TOC entry 5144 (class 2606 OID 92762)
-- Name: modalite_formation_continue modalite_formation_continue_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modalite_formation_continue
    ADD CONSTRAINT modalite_formation_continue_pkey PRIMARY KEY (id);


--
-- TOC entry 5146 (class 2606 OID 92764)
-- Name: modalite_intervention modalite_intervention_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modalite_intervention
    ADD CONSTRAINT modalite_intervention_pkey PRIMARY KEY (id);


--
-- TOC entry 5138 (class 2606 OID 92766)
-- Name: modalite modalite_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modalite
    ADD CONSTRAINT modalite_pkey PRIMARY KEY (id);


--
-- TOC entry 5150 (class 2606 OID 92768)
-- Name: mode_diffusion_developpement_de_savoir_et_innovation_scientifiq mode_diffusion_developpement_de_savoir_et_innovation_scien_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mode_diffusion_developpement_de_savoir_et_innovation_scientifiq
    ADD CONSTRAINT mode_diffusion_developpement_de_savoir_et_innovation_scien_pkey PRIMARY KEY (id);


--
-- TOC entry 5148 (class 2606 OID 92770)
-- Name: mode_diffusion mode_diffusion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mode_diffusion
    ADD CONSTRAINT mode_diffusion_pkey PRIMARY KEY (id);


--
-- TOC entry 5152 (class 2606 OID 92772)
-- Name: nationalite nationalite_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nationalite
    ADD CONSTRAINT nationalite_pkey PRIMARY KEY (id);


--
-- TOC entry 5154 (class 2606 OID 92774)
-- Name: nature_activite_grand_publique nature_activite_grand_publique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nature_activite_grand_publique
    ADD CONSTRAINT nature_activite_grand_publique_pkey PRIMARY KEY (id);


--
-- TOC entry 5156 (class 2606 OID 92776)
-- Name: nature_enseignement nature_enseignement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nature_enseignement
    ADD CONSTRAINT nature_enseignement_pkey PRIMARY KEY (id);


--
-- TOC entry 5158 (class 2606 OID 92778)
-- Name: nature_etude nature_etude_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nature_etude
    ADD CONSTRAINT nature_etude_pkey PRIMARY KEY (id);


--
-- TOC entry 5160 (class 2606 OID 92780)
-- Name: nature_expertise nature_expertise_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nature_expertise
    ADD CONSTRAINT nature_expertise_pkey PRIMARY KEY (id);


--
-- TOC entry 5164 (class 2606 OID 92782)
-- Name: niveau_etude_enseignement niveau_etude_enseignement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.niveau_etude_enseignement
    ADD CONSTRAINT niveau_etude_enseignement_pkey PRIMARY KEY (id);


--
-- TOC entry 5162 (class 2606 OID 92784)
-- Name: niveau_etude niveau_etude_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.niveau_etude
    ADD CONSTRAINT niveau_etude_pkey PRIMARY KEY (id);


--
-- TOC entry 5166 (class 2606 OID 92786)
-- Name: niveau_formation niveau_formation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.niveau_formation
    ADD CONSTRAINT niveau_formation_pkey PRIMARY KEY (id);


--
-- TOC entry 5168 (class 2606 OID 92788)
-- Name: niveau_formation_post_bac niveau_formation_post_bac_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.niveau_formation_post_bac
    ADD CONSTRAINT niveau_formation_post_bac_pkey PRIMARY KEY (id);


--
-- TOC entry 5170 (class 2606 OID 92790)
-- Name: niveau_responsabilite_pedagogique niveau_responsabilite_pedagogique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.niveau_responsabilite_pedagogique
    ADD CONSTRAINT niveau_responsabilite_pedagogique_pkey PRIMARY KEY (id);


--
-- TOC entry 5172 (class 2606 OID 92792)
-- Name: notification notification_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification
    ADD CONSTRAINT notification_pkey PRIMARY KEY (id);


--
-- TOC entry 5176 (class 2606 OID 92794)
-- Name: objet_formation_generique_de_responsabilite_pedagogique objet_formation_generique_de_responsabilite_pedagogique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.objet_formation_generique_de_responsabilite_pedagogique
    ADD CONSTRAINT objet_formation_generique_de_responsabilite_pedagogique_pkey PRIMARY KEY (id);


--
-- TOC entry 5174 (class 2606 OID 92796)
-- Name: objet_formation_generique objet_formation_generique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.objet_formation_generique
    ADD CONSTRAINT objet_formation_generique_pkey PRIMARY KEY (id);


--
-- TOC entry 5180 (class 2606 OID 92798)
-- Name: objet_global_de_formation_continue objet_global_de_formation_continue_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.objet_global_de_formation_continue
    ADD CONSTRAINT objet_global_de_formation_continue_pkey PRIMARY KEY (id);


--
-- TOC entry 5182 (class 2606 OID 92800)
-- Name: objet_global_formation_continue objet_global_formation_continue_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.objet_global_formation_continue
    ADD CONSTRAINT objet_global_formation_continue_pkey PRIMARY KEY (id);


--
-- TOC entry 5178 (class 2606 OID 92802)
-- Name: objet_global objet_global_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.objet_global
    ADD CONSTRAINT objet_global_pkey PRIMARY KEY (id);


--
-- TOC entry 5184 (class 2606 OID 92804)
-- Name: organisme organisme_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.organisme
    ADD CONSTRAINT organisme_pkey PRIMARY KEY (id);


--
-- TOC entry 5186 (class 2606 OID 92806)
-- Name: outil_formation_continue outil_formation_continue_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_formation_continue
    ADD CONSTRAINT outil_formation_continue_pkey PRIMARY KEY (id);


--
-- TOC entry 5190 (class 2606 OID 92808)
-- Name: outil_pedagogique_discipline_scientifique outil_pedagogique_discipline_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_discipline_scientifique
    ADD CONSTRAINT outil_pedagogique_discipline_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 5192 (class 2606 OID 92810)
-- Name: outil_pedagogique_enjeux_ird outil_pedagogique_enjeux_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_enjeux_ird
    ADD CONSTRAINT outil_pedagogique_enjeux_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5194 (class 2606 OID 92812)
-- Name: outil_pedagogique_instrument_ird outil_pedagogique_instrument_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_instrument_ird
    ADD CONSTRAINT outil_pedagogique_instrument_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5196 (class 2606 OID 92814)
-- Name: outil_pedagogique_langue outil_pedagogique_langue_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_langue
    ADD CONSTRAINT outil_pedagogique_langue_pkey PRIMARY KEY (id);


--
-- TOC entry 5198 (class 2606 OID 92816)
-- Name: outil_pedagogique_pays_conception outil_pedagogique_pays_conception_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_pays_conception
    ADD CONSTRAINT outil_pedagogique_pays_conception_pkey PRIMARY KEY (id);


--
-- TOC entry 5200 (class 2606 OID 92818)
-- Name: outil_pedagogique_pays_diffusion outil_pedagogique_pays_diffusion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_pays_diffusion
    ADD CONSTRAINT outil_pedagogique_pays_diffusion_pkey PRIMARY KEY (id);


--
-- TOC entry 5202 (class 2606 OID 92820)
-- Name: outil_pedagogique_periode outil_pedagogique_periode_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_periode
    ADD CONSTRAINT outil_pedagogique_periode_pkey PRIMARY KEY (id);


--
-- TOC entry 5188 (class 2606 OID 92822)
-- Name: outil_pedagogique outil_pedagogique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique
    ADD CONSTRAINT outil_pedagogique_pkey PRIMARY KEY (id);


--
-- TOC entry 5204 (class 2606 OID 92824)
-- Name: outil_pedagogique_public_cible outil_pedagogique_public_cible_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_public_cible
    ADD CONSTRAINT outil_pedagogique_public_cible_pkey PRIMARY KEY (id);


--
-- TOC entry 5206 (class 2606 OID 92826)
-- Name: outil_pedagogique_publique_cible outil_pedagogique_publique_cible_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_publique_cible
    ADD CONSTRAINT outil_pedagogique_publique_cible_pkey PRIMARY KEY (id);


--
-- TOC entry 5208 (class 2606 OID 92828)
-- Name: outil_pedagogique_type_instrument_ird outil_pedagogique_type_instrument_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_type_instrument_ird
    ADD CONSTRAINT outil_pedagogique_type_instrument_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5210 (class 2606 OID 92830)
-- Name: partenaire partenaire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partenaire
    ADD CONSTRAINT partenaire_pkey PRIMARY KEY (id);


--
-- TOC entry 5214 (class 2606 OID 92832)
-- Name: pays_commanditaire pays_commanditaire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_commanditaire
    ADD CONSTRAINT pays_commanditaire_pkey PRIMARY KEY (id);


--
-- TOC entry 5216 (class 2606 OID 92834)
-- Name: pays_culture_scientifique_recontre_grand_public_jeune_public pays_culture_scientifique_recontre_grand_public_jeune_publ_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_culture_scientifique_recontre_grand_public_jeune_public
    ADD CONSTRAINT pays_culture_scientifique_recontre_grand_public_jeune_publ_pkey PRIMARY KEY (id);


--
-- TOC entry 5218 (class 2606 OID 92836)
-- Name: pays_encadrement_doctorant pays_encadrement_doctorant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_encadrement_doctorant
    ADD CONSTRAINT pays_encadrement_doctorant_pkey PRIMARY KEY (id);


--
-- TOC entry 5220 (class 2606 OID 92838)
-- Name: pays_encadrement_etudiant pays_encadrement_etudiant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_encadrement_etudiant
    ADD CONSTRAINT pays_encadrement_etudiant_pkey PRIMARY KEY (id);


--
-- TOC entry 5222 (class 2606 OID 92840)
-- Name: pays_formation_continue pays_formation_continue_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_formation_continue
    ADD CONSTRAINT pays_formation_continue_pkey PRIMARY KEY (id);


--
-- TOC entry 5224 (class 2606 OID 92842)
-- Name: pays_organisateur_rencontre_grand_publique_jeune_publique pays_organisateur_rencontre_grand_publique_jeune_publique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_organisateur_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT pays_organisateur_rencontre_grand_publique_jeune_publique_pkey PRIMARY KEY (id);


--
-- TOC entry 5212 (class 2606 OID 92844)
-- Name: pays pays_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays
    ADD CONSTRAINT pays_pkey PRIMARY KEY (id);


--
-- TOC entry 5226 (class 2606 OID 92846)
-- Name: pays_projet_recherche pays_projet_recherche_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_projet_recherche
    ADD CONSTRAINT pays_projet_recherche_pkey PRIMARY KEY (id);


--
-- TOC entry 5228 (class 2606 OID 92848)
-- Name: pays_rencontre_grand_publique_jeune_publique pays_rencontre_grand_publique_jeune_publique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT pays_rencontre_grand_publique_jeune_publique_pkey PRIMARY KEY (id);


--
-- TOC entry 5230 (class 2606 OID 92850)
-- Name: pays_rencontre_media pays_rencontre_media_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_rencontre_media
    ADD CONSTRAINT pays_rencontre_media_pkey PRIMARY KEY (id);


--
-- TOC entry 5232 (class 2606 OID 92852)
-- Name: pays_type_outil_culture_scientifique_outil_pedagogique pays_type_outil_culture_scientifique_outil_pedagogique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_type_outil_culture_scientifique_outil_pedagogique
    ADD CONSTRAINT pays_type_outil_culture_scientifique_outil_pedagogique_pkey PRIMARY KEY (id);


--
-- TOC entry 5234 (class 2606 OID 92854)
-- Name: pays_zone_geographique pays_zone_geographique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_zone_geographique
    ADD CONSTRAINT pays_zone_geographique_pkey PRIMARY KEY (id);


--
-- TOC entry 5236 (class 2606 OID 92856)
-- Name: permission permission_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permission
    ADD CONSTRAINT permission_pkey PRIMARY KEY (id);


--
-- TOC entry 5242 (class 2606 OID 92858)
-- Name: projet_activite_recherche_detail_enjeux_ird projet_activite_recherche_detail_enjeux_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_enjeux_ird
    ADD CONSTRAINT projet_activite_recherche_detail_enjeux_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5244 (class 2606 OID 92860)
-- Name: projet_activite_recherche_detail_etablissement_financeur projet_activite_recherche_detail_etablissement_financeur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_etablissement_financeur
    ADD CONSTRAINT projet_activite_recherche_detail_etablissement_financeur_pkey PRIMARY KEY (id);


--
-- TOC entry 5246 (class 2606 OID 92862)
-- Name: projet_activite_recherche_detail_etablissement_lanceur projet_activite_recherche_detail_etablissement_lanceur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_etablissement_lanceur
    ADD CONSTRAINT projet_activite_recherche_detail_etablissement_lanceur_pkey PRIMARY KEY (id);


--
-- TOC entry 5248 (class 2606 OID 92864)
-- Name: projet_activite_recherche_detail_institution_co_contractant projet_activite_recherche_detail_institution_co_contractan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_institution_co_contractant
    ADD CONSTRAINT projet_activite_recherche_detail_institution_co_contractan_pkey PRIMARY KEY (id);


--
-- TOC entry 5250 (class 2606 OID 92866)
-- Name: projet_activite_recherche_detail_instrument_ird projet_activite_recherche_detail_instrument_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_instrument_ird
    ADD CONSTRAINT projet_activite_recherche_detail_instrument_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5252 (class 2606 OID 92868)
-- Name: projet_activite_recherche_detail_pays projet_activite_recherche_detail_pays_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_pays
    ADD CONSTRAINT projet_activite_recherche_detail_pays_pkey PRIMARY KEY (id);


--
-- TOC entry 5240 (class 2606 OID 92870)
-- Name: projet_activite_recherche_detail projet_activite_recherche_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail
    ADD CONSTRAINT projet_activite_recherche_detail_pkey PRIMARY KEY (id);


--
-- TOC entry 5238 (class 2606 OID 92872)
-- Name: projet_activite_recherche projet_activite_recherche_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche
    ADD CONSTRAINT projet_activite_recherche_pkey PRIMARY KEY (id);


--
-- TOC entry 5256 (class 2606 OID 92874)
-- Name: public_cible_culture_scientifique_outil_pedagogique public_cible_culture_scientifique_outil_pedagogique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_cible_culture_scientifique_outil_pedagogique
    ADD CONSTRAINT public_cible_culture_scientifique_outil_pedagogique_pkey PRIMARY KEY (id);


--
-- TOC entry 5258 (class 2606 OID 92876)
-- Name: public_cible_culture_scientifique_recontre_grand_public public_cible_culture_scientifique_recontre_grand_public_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_cible_culture_scientifique_recontre_grand_public
    ADD CONSTRAINT public_cible_culture_scientifique_recontre_grand_public_pkey PRIMARY KEY (id);


--
-- TOC entry 5254 (class 2606 OID 92878)
-- Name: public_cible public_cible_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_cible
    ADD CONSTRAINT public_cible_pkey PRIMARY KEY (id);


--
-- TOC entry 5260 (class 2606 OID 92880)
-- Name: publique_cible publique_cible_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publique_cible
    ADD CONSTRAINT publique_cible_pkey PRIMARY KEY (id);


--
-- TOC entry 5264 (class 2606 OID 92882)
-- Name: publique_cible_rencontre_grand_publique_jeune_publique publique_cible_rencontre_grand_publique_jeune_publique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publique_cible_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT publique_cible_rencontre_grand_publique_jeune_publique_pkey PRIMARY KEY (id);


--
-- TOC entry 5262 (class 2606 OID 92884)
-- Name: publique_cible_rencontre publique_cible_rencontre_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publique_cible_rencontre
    ADD CONSTRAINT publique_cible_rencontre_pkey PRIMARY KEY (id);


--
-- TOC entry 5266 (class 2606 OID 92886)
-- Name: publique_formation publique_formation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publique_formation
    ADD CONSTRAINT publique_formation_pkey PRIMARY KEY (id);


--
-- TOC entry 5270 (class 2606 OID 92888)
-- Name: publique_principal_conceme_formation_continue publique_principal_conceme_formation_continue_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publique_principal_conceme_formation_continue
    ADD CONSTRAINT publique_principal_conceme_formation_continue_pkey PRIMARY KEY (id);


--
-- TOC entry 5268 (class 2606 OID 92890)
-- Name: publique_principal publique_principal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publique_principal
    ADD CONSTRAINT publique_principal_pkey PRIMARY KEY (id);


--
-- TOC entry 5272 (class 2606 OID 92892)
-- Name: publique_professionel publique_professionel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publique_professionel
    ADD CONSTRAINT publique_professionel_pkey PRIMARY KEY (id);


--
-- TOC entry 5274 (class 2606 OID 92894)
-- Name: reclamation reclamation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reclamation
    ADD CONSTRAINT reclamation_pkey PRIMARY KEY (id);


--
-- TOC entry 5278 (class 2606 OID 92896)
-- Name: rencontre_grand_publique_jeune_publique_discipline rencontre_grand_publique_jeune_publique_discipline_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique_discipline
    ADD CONSTRAINT rencontre_grand_publique_jeune_publique_discipline_pkey PRIMARY KEY (id);


--
-- TOC entry 5280 (class 2606 OID 92898)
-- Name: rencontre_grand_publique_jeune_publique_enjeux_ird rencontre_grand_publique_jeune_publique_enjeux_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique_enjeux_ird
    ADD CONSTRAINT rencontre_grand_publique_jeune_publique_enjeux_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5282 (class 2606 OID 92900)
-- Name: rencontre_grand_publique_jeune_publique_instrument_ird rencontre_grand_publique_jeune_publique_instrument_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique_instrument_ird
    ADD CONSTRAINT rencontre_grand_publique_jeune_publique_instrument_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5284 (class 2606 OID 92902)
-- Name: rencontre_grand_publique_jeune_publique_periode rencontre_grand_publique_jeune_publique_periode_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique_periode
    ADD CONSTRAINT rencontre_grand_publique_jeune_publique_periode_pkey PRIMARY KEY (id);


--
-- TOC entry 5276 (class 2606 OID 92904)
-- Name: rencontre_grand_publique_jeune_publique rencontre_grand_publique_jeune_publique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT rencontre_grand_publique_jeune_publique_pkey PRIMARY KEY (id);


--
-- TOC entry 5286 (class 2606 OID 92906)
-- Name: rencontre_grand_publique_jeune_publique_type_instrument_ird rencontre_grand_publique_jeune_publique_type_instrument_ir_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique_type_instrument_ird
    ADD CONSTRAINT rencontre_grand_publique_jeune_publique_type_instrument_ir_pkey PRIMARY KEY (id);


--
-- TOC entry 5290 (class 2606 OID 92908)
-- Name: rencontre_media_discipline_scientifique rencontre_media_discipline_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_media_discipline_scientifique
    ADD CONSTRAINT rencontre_media_discipline_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 5292 (class 2606 OID 92910)
-- Name: rencontre_media_enjeux_ird rencontre_media_enjeux_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_media_enjeux_ird
    ADD CONSTRAINT rencontre_media_enjeux_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5294 (class 2606 OID 92912)
-- Name: rencontre_media_periode rencontre_media_periode_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_media_periode
    ADD CONSTRAINT rencontre_media_periode_pkey PRIMARY KEY (id);


--
-- TOC entry 5288 (class 2606 OID 92914)
-- Name: rencontre_media rencontre_media_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_media
    ADD CONSTRAINT rencontre_media_pkey PRIMARY KEY (id);


--
-- TOC entry 5296 (class 2606 OID 92916)
-- Name: responsabilite_direction_encadrement_etudiant responsabilite_direction_encadrement_etudiant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_direction_encadrement_etudiant
    ADD CONSTRAINT responsabilite_direction_encadrement_etudiant_pkey PRIMARY KEY (id);


--
-- TOC entry 5298 (class 2606 OID 92918)
-- Name: responsabilite_encadrement_doctorant responsabilite_encadrement_doctorant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_encadrement_doctorant
    ADD CONSTRAINT responsabilite_encadrement_doctorant_pkey PRIMARY KEY (id);


--
-- TOC entry 5300 (class 2606 OID 92920)
-- Name: responsabilite_encadrement_etudiant responsabilite_encadrement_etudiant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_encadrement_etudiant
    ADD CONSTRAINT responsabilite_encadrement_etudiant_pkey PRIMARY KEY (id);


--
-- TOC entry 5304 (class 2606 OID 92922)
-- Name: responsabilite_pedagogique_ecole_doctorale responsabilite_pedagogique_ecole_doctorale_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_ecole_doctorale
    ADD CONSTRAINT responsabilite_pedagogique_ecole_doctorale_pkey PRIMARY KEY (id);


--
-- TOC entry 5306 (class 2606 OID 92924)
-- Name: responsabilite_pedagogique_enjeux_ird responsabilite_pedagogique_enjeux_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_enjeux_ird
    ADD CONSTRAINT responsabilite_pedagogique_enjeux_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5308 (class 2606 OID 92926)
-- Name: responsabilite_pedagogique_etablissement responsabilite_pedagogique_etablissement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_etablissement
    ADD CONSTRAINT responsabilite_pedagogique_etablissement_pkey PRIMARY KEY (id);


--
-- TOC entry 5310 (class 2606 OID 92928)
-- Name: responsabilite_pedagogique_master responsabilite_pedagogique_master_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_master
    ADD CONSTRAINT responsabilite_pedagogique_master_pkey PRIMARY KEY (id);


--
-- TOC entry 5312 (class 2606 OID 92930)
-- Name: responsabilite_pedagogique_pays responsabilite_pedagogique_pays_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_pays
    ADD CONSTRAINT responsabilite_pedagogique_pays_pkey PRIMARY KEY (id);


--
-- TOC entry 5302 (class 2606 OID 92932)
-- Name: responsabilite_pedagogique responsabilite_pedagogique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique
    ADD CONSTRAINT responsabilite_pedagogique_pkey PRIMARY KEY (id);


--
-- TOC entry 5314 (class 2606 OID 92934)
-- Name: role_app role_app_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_app
    ADD CONSTRAINT role_app_pkey PRIMARY KEY (id);


--
-- TOC entry 5316 (class 2606 OID 92936)
-- Name: role_comite_et_commission_evaluation role_comite_et_commission_evaluation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_comite_et_commission_evaluation
    ADD CONSTRAINT role_comite_et_commission_evaluation_pkey PRIMARY KEY (id);


--
-- TOC entry 5318 (class 2606 OID 92938)
-- Name: role_developpement_de_savoir role_developpement_de_savoir_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_developpement_de_savoir
    ADD CONSTRAINT role_developpement_de_savoir_pkey PRIMARY KEY (id);


--
-- TOC entry 5320 (class 2606 OID 92940)
-- Name: role_evaluation role_evaluation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_evaluation
    ADD CONSTRAINT role_evaluation_pkey PRIMARY KEY (id);


--
-- TOC entry 5322 (class 2606 OID 92942)
-- Name: role_evaluation_recherche_universitaire role_evaluation_recherche_universitaire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_evaluation_recherche_universitaire
    ADD CONSTRAINT role_evaluation_recherche_universitaire_pkey PRIMARY KEY (id);


--
-- TOC entry 5324 (class 2606 OID 92944)
-- Name: role_projet role_projet_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_projet
    ADD CONSTRAINT role_projet_pkey PRIMARY KEY (id);


--
-- TOC entry 5326 (class 2606 OID 92946)
-- Name: savoir_et_innovation savoir_et_innovation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.savoir_et_innovation
    ADD CONSTRAINT savoir_et_innovation_pkey PRIMARY KEY (id);


--
-- TOC entry 5328 (class 2606 OID 92948)
-- Name: semantic_relationship semantic_relationship_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.semantic_relationship
    ADD CONSTRAINT semantic_relationship_pkey PRIMARY KEY (id);


--
-- TOC entry 5330 (class 2606 OID 92950)
-- Name: sexe sexe_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sexe
    ADD CONSTRAINT sexe_pkey PRIMARY KEY (id);


--
-- TOC entry 5332 (class 2606 OID 92952)
-- Name: status_contrat_et_convention status_contrat_et_convention_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.status_contrat_et_convention
    ADD CONSTRAINT status_contrat_et_convention_pkey PRIMARY KEY (id);


--
-- TOC entry 5334 (class 2606 OID 92954)
-- Name: status_cursus status_cursus_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.status_cursus
    ADD CONSTRAINT status_cursus_pkey PRIMARY KEY (id);


--
-- TOC entry 5336 (class 2606 OID 92956)
-- Name: status_projet status_projet_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.status_projet
    ADD CONSTRAINT status_projet_pkey PRIMARY KEY (id);


--
-- TOC entry 5338 (class 2606 OID 92958)
-- Name: statut_ecole_doctorale statut_ecole_doctorale_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.statut_ecole_doctorale
    ADD CONSTRAINT statut_ecole_doctorale_pkey PRIMARY KEY (id);


--
-- TOC entry 5340 (class 2606 OID 92960)
-- Name: statut_master statut_master_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.statut_master
    ADD CONSTRAINT statut_master_pkey PRIMARY KEY (id);


--
-- TOC entry 5342 (class 2606 OID 92962)
-- Name: structure_ird structure_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.structure_ird
    ADD CONSTRAINT structure_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5344 (class 2606 OID 92964)
-- Name: structure_oganisatrice structure_oganisatrice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.structure_oganisatrice
    ADD CONSTRAINT structure_oganisatrice_pkey PRIMARY KEY (id);


--
-- TOC entry 5346 (class 2606 OID 92966)
-- Name: template_cloture template_cloture_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.template_cloture
    ADD CONSTRAINT template_cloture_pkey PRIMARY KEY (id);


--
-- TOC entry 5348 (class 2606 OID 92968)
-- Name: template_ouverture template_ouverture_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.template_ouverture
    ADD CONSTRAINT template_ouverture_pkey PRIMARY KEY (id);


--
-- TOC entry 5350 (class 2606 OID 92970)
-- Name: template_rappel template_rappel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.template_rappel
    ADD CONSTRAINT template_rappel_pkey PRIMARY KEY (id);


--
-- TOC entry 5352 (class 2606 OID 92972)
-- Name: template_relance template_relance_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.template_relance
    ADD CONSTRAINT template_relance_pkey PRIMARY KEY (id);


--
-- TOC entry 5356 (class 2606 OID 92974)
-- Name: type_enseignement_dispense type_enseignement_dispense_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_enseignement_dispense
    ADD CONSTRAINT type_enseignement_dispense_pkey PRIMARY KEY (id);


--
-- TOC entry 5354 (class 2606 OID 92976)
-- Name: type_enseignement type_enseignement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_enseignement
    ADD CONSTRAINT type_enseignement_pkey PRIMARY KEY (id);


--
-- TOC entry 5358 (class 2606 OID 92978)
-- Name: type_entite_administrative type_entite_administrative_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_entite_administrative
    ADD CONSTRAINT type_entite_administrative_pkey PRIMARY KEY (id);


--
-- TOC entry 5362 (class 2606 OID 92980)
-- Name: type_etude_enseignement type_etude_enseignement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_etude_enseignement
    ADD CONSTRAINT type_etude_enseignement_pkey PRIMARY KEY (id);


--
-- TOC entry 5360 (class 2606 OID 92982)
-- Name: type_etude type_etude_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_etude
    ADD CONSTRAINT type_etude_pkey PRIMARY KEY (id);


--
-- TOC entry 5364 (class 2606 OID 92984)
-- Name: type_expert type_expert_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_expert
    ADD CONSTRAINT type_expert_pkey PRIMARY KEY (id);


--
-- TOC entry 5370 (class 2606 OID 92986)
-- Name: type_expertise_evaluation_comite_et_commission_evaluation type_expertise_evaluation_comite_et_commission_evaluation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_expertise_evaluation_comite_et_commission_evaluation
    ADD CONSTRAINT type_expertise_evaluation_comite_et_commission_evaluation_pkey PRIMARY KEY (id);


--
-- TOC entry 5368 (class 2606 OID 92988)
-- Name: type_expertise_evaluation type_expertise_evaluation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_expertise_evaluation
    ADD CONSTRAINT type_expertise_evaluation_pkey PRIMARY KEY (id);


--
-- TOC entry 5366 (class 2606 OID 92990)
-- Name: type_expertise type_expertise_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_expertise
    ADD CONSTRAINT type_expertise_pkey PRIMARY KEY (id);


--
-- TOC entry 5372 (class 2606 OID 92992)
-- Name: type_instance type_instance_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_instance
    ADD CONSTRAINT type_instance_pkey PRIMARY KEY (id);


--
-- TOC entry 5376 (class 2606 OID 92994)
-- Name: type_instrument_ird_chercheur type_instrument_ird_chercheur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_instrument_ird_chercheur
    ADD CONSTRAINT type_instrument_ird_chercheur_pkey PRIMARY KEY (id);


--
-- TOC entry 5378 (class 2606 OID 92996)
-- Name: type_instrument_ird_consultance_scientifique_ponctuelle type_instrument_ird_consultance_scientifique_ponctuelle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_instrument_ird_consultance_scientifique_ponctuelle
    ADD CONSTRAINT type_instrument_ird_consultance_scientifique_ponctuelle_pkey PRIMARY KEY (id);


--
-- TOC entry 5374 (class 2606 OID 92998)
-- Name: type_instrument_ird type_instrument_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_instrument_ird
    ADD CONSTRAINT type_instrument_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5380 (class 2606 OID 93000)
-- Name: type_instruments_et_dispositifs_ird type_instruments_et_dispositifs_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_instruments_et_dispositifs_ird
    ADD CONSTRAINT type_instruments_et_dispositifs_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5384 (class 2606 OID 93002)
-- Name: type_outil_culture_scientifique_outil_pedagogique type_outil_culture_scientifique_outil_pedagogique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_outil_culture_scientifique_outil_pedagogique
    ADD CONSTRAINT type_outil_culture_scientifique_outil_pedagogique_pkey PRIMARY KEY (id);


--
-- TOC entry 5386 (class 2606 OID 93004)
-- Name: type_outil_pedagogique type_outil_pedagogique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_outil_pedagogique
    ADD CONSTRAINT type_outil_pedagogique_pkey PRIMARY KEY (id);


--
-- TOC entry 5382 (class 2606 OID 93006)
-- Name: type_outil type_outil_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_outil
    ADD CONSTRAINT type_outil_pkey PRIMARY KEY (id);


--
-- TOC entry 5388 (class 2606 OID 93008)
-- Name: type_participation type_participation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_participation
    ADD CONSTRAINT type_participation_pkey PRIMARY KEY (id);


--
-- TOC entry 5392 (class 2606 OID 93010)
-- Name: type_publique_culture_scientifique type_publique_culture_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_publique_culture_scientifique
    ADD CONSTRAINT type_publique_culture_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 5390 (class 2606 OID 93012)
-- Name: type_publique type_publique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_publique
    ADD CONSTRAINT type_publique_pkey PRIMARY KEY (id);


--
-- TOC entry 5394 (class 2606 OID 93014)
-- Name: type_publique_rencontre_grand_publique_jeune_publique type_publique_rencontre_grand_publique_jeune_publique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_publique_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT type_publique_rencontre_grand_publique_jeune_publique_pkey PRIMARY KEY (id);


--
-- TOC entry 5396 (class 2606 OID 93016)
-- Name: type_publique_rencontre_media type_publique_rencontre_media_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_publique_rencontre_media
    ADD CONSTRAINT type_publique_rencontre_media_pkey PRIMARY KEY (id);


--
-- TOC entry 5398 (class 2606 OID 93018)
-- Name: type_reclamation type_reclamation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_reclamation
    ADD CONSTRAINT type_reclamation_pkey PRIMARY KEY (id);


--
-- TOC entry 5402 (class 2606 OID 93020)
-- Name: type_savoir_developpement_de_savoir_et_innovation_scientifique type_savoir_developpement_de_savoir_et_innovation_scientif_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_savoir_developpement_de_savoir_et_innovation_scientifique
    ADD CONSTRAINT type_savoir_developpement_de_savoir_et_innovation_scientif_pkey PRIMARY KEY (id);


--
-- TOC entry 5400 (class 2606 OID 93022)
-- Name: type_savoir type_savoir_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_savoir
    ADD CONSTRAINT type_savoir_pkey PRIMARY KEY (id);


--
-- TOC entry 5404 (class 2606 OID 93024)
-- Name: type_utilisateur type_utilisateur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_utilisateur
    ADD CONSTRAINT type_utilisateur_pkey PRIMARY KEY (id);


--
-- TOC entry 5406 (class 2606 OID 93026)
-- Name: type_utilisateur_savoir_concu type_utilisateur_savoir_concu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_utilisateur_savoir_concu
    ADD CONSTRAINT type_utilisateur_savoir_concu_pkey PRIMARY KEY (id);


--
-- TOC entry 5408 (class 2606 OID 93028)
-- Name: user_app user_app_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_app
    ADD CONSTRAINT user_app_pkey PRIMARY KEY (id);


--
-- TOC entry 5414 (class 2606 OID 93030)
-- Name: vie_institutionnelle_detail_etablissement vie_institutionnelle_detail_etablissement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vie_institutionnelle_detail_etablissement
    ADD CONSTRAINT vie_institutionnelle_detail_etablissement_pkey PRIMARY KEY (id);


--
-- TOC entry 5416 (class 2606 OID 93032)
-- Name: vie_institutionnelle_detail_instrument_ird vie_institutionnelle_detail_instrument_ird_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vie_institutionnelle_detail_instrument_ird
    ADD CONSTRAINT vie_institutionnelle_detail_instrument_ird_pkey PRIMARY KEY (id);


--
-- TOC entry 5412 (class 2606 OID 93034)
-- Name: vie_institutionnelle_detail vie_institutionnelle_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vie_institutionnelle_detail
    ADD CONSTRAINT vie_institutionnelle_detail_pkey PRIMARY KEY (id);


--
-- TOC entry 5410 (class 2606 OID 93036)
-- Name: vie_institutionnelle vie_institutionnelle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vie_institutionnelle
    ADD CONSTRAINT vie_institutionnelle_pkey PRIMARY KEY (id);


--
-- TOC entry 5418 (class 2606 OID 93038)
-- Name: ville ville_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville
    ADD CONSTRAINT ville_pkey PRIMARY KEY (id);


--
-- TOC entry 5420 (class 2606 OID 93040)
-- Name: zone_activite_interaction_recherche zone_activite_interaction_recherche_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_activite_interaction_recherche
    ADD CONSTRAINT zone_activite_interaction_recherche_pkey PRIMARY KEY (id);


--
-- TOC entry 5424 (class 2606 OID 93042)
-- Name: zone_geographique_conseils_scientifique zone_geographique_conseils_scientifique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_geographique_conseils_scientifique
    ADD CONSTRAINT zone_geographique_conseils_scientifique_pkey PRIMARY KEY (id);


--
-- TOC entry 5426 (class 2606 OID 93044)
-- Name: zone_geographique_consultance_scientifique_ponctuelle zone_geographique_consultance_scientifique_ponctuelle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_geographique_consultance_scientifique_ponctuelle
    ADD CONSTRAINT zone_geographique_consultance_scientifique_ponctuelle_pkey PRIMARY KEY (id);


--
-- TOC entry 5428 (class 2606 OID 93046)
-- Name: zone_geographique_formation_continue zone_geographique_formation_continue_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_geographique_formation_continue
    ADD CONSTRAINT zone_geographique_formation_continue_pkey PRIMARY KEY (id);


--
-- TOC entry 5422 (class 2606 OID 93048)
-- Name: zone_geographique zone_geographique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_geographique
    ADD CONSTRAINT zone_geographique_pkey PRIMARY KEY (id);


--
-- TOC entry 5851 (class 2606 OID 93049)
-- Name: rencontre_media_discipline_scientifique fk13x266xkg7oksdqh21loe5cfg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_media_discipline_scientifique
    ADD CONSTRAINT fk13x266xkg7oksdqh21loe5cfg FOREIGN KEY (rencontre_media_id) REFERENCES public.rencontre_media(id);


--
-- TOC entry 5680 (class 2606 OID 93054)
-- Name: expertise_scientifique fk16aho2d60rcsft4hsl6yv5nhr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expertise_scientifique
    ADD CONSTRAINT fk16aho2d60rcsft4hsl6yv5nhr FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5917 (class 2606 OID 93059)
-- Name: vie_institutionnelle_detail_etablissement fk17gjjvwjheeonh0209dw9my9n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vie_institutionnelle_detail_etablissement
    ADD CONSTRAINT fk17gjjvwjheeonh0209dw9my9n FOREIGN KEY (vie_institutionnelle_detail_id) REFERENCES public.vie_institutionnelle_detail(id);


--
-- TOC entry 5508 (class 2606 OID 93064)
-- Name: culture_scientifique fk17ukyqcw8w03ls3bs9d82c64l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.culture_scientifique
    ADD CONSTRAINT fk17ukyqcw8w03ls3bs9d82c64l FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5455 (class 2606 OID 93069)
-- Name: chercheur fk18vf6ikw9busq3mmptgb95bd7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chercheur
    ADD CONSTRAINT fk18vf6ikw9busq3mmptgb95bd7 FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5655 (class 2606 OID 93074)
-- Name: etablissement_rencontre_grand_publique_jeune_publique fk1cmfv4l3yq9vlfavpeo3ecvoj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fk1cmfv4l3yq9vlfavpeo3ecvoj FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5813 (class 2606 OID 93079)
-- Name: projet_activite_recherche_detail_etablissement_lanceur fk1d1fno2u25cdih41i51ghneqq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_etablissement_lanceur
    ADD CONSTRAINT fk1d1fno2u25cdih41i51ghneqq FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5512 (class 2606 OID 93084)
-- Name: culture_scientifique_outil_pedagogique fk1d3p7yie7rydu1pl3vm4qnghl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.culture_scientifique_outil_pedagogique
    ADD CONSTRAINT fk1d3p7yie7rydu1pl3vm4qnghl FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5609 (class 2606 OID 93089)
-- Name: enjeux_ird_conseils_scientifique fk1egh5n6um7gc3y8vxapr50gdu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enjeux_ird_conseils_scientifique
    ADD CONSTRAINT fk1egh5n6um7gc3y8vxapr50gdu FOREIGN KEY (enjeux_ird_id) REFERENCES public.enjeux_ird(id);


--
-- TOC entry 5689 (class 2606 OID 93094)
-- Name: formation_continue fk1frvsqsy5x9vvg8qtgjqbldpd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue
    ADD CONSTRAINT fk1frvsqsy5x9vvg8qtgjqbldpd FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5834 (class 2606 OID 93099)
-- Name: rencontre_grand_publique_jeune_publique fk1lq3afpq3j0jpcnqq4xdso4ed; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fk1lq3afpq3j0jpcnqq4xdso4ed FOREIGN KEY (format_rencontre_id) REFERENCES public.format_rencontre(id);


--
-- TOC entry 5846 (class 2606 OID 93104)
-- Name: rencontre_grand_publique_jeune_publique_type_instrument_ird fk1nfo30cg7u7644c8yaek6yjdd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique_type_instrument_ird
    ADD CONSTRAINT fk1nfo30cg7u7644c8yaek6yjdd FOREIGN KEY (rencontre_grand_publique_jeune_publique_id) REFERENCES public.rencontre_grand_publique_jeune_publique(id);


--
-- TOC entry 5486 (class 2606 OID 93109)
-- Name: conseil_et_comite_scientifique fk1nx784ef6od35f77imydf1tmd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.conseil_et_comite_scientifique
    ADD CONSTRAINT fk1nx784ef6od35f77imydf1tmd FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5815 (class 2606 OID 93114)
-- Name: projet_activite_recherche_detail_institution_co_contractant fk1ph9g27wfo30n1osv470u4fpx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_institution_co_contractant
    ADD CONSTRAINT fk1ph9g27wfo30n1osv470u4fpx FOREIGN KEY (projet_activite_recherche_detail_id) REFERENCES public.projet_activite_recherche_detail(id);


--
-- TOC entry 5666 (class 2606 OID 93119)
-- Name: evenement_colloque_scienntifique fk1r3g38rlqo4iwekn5r2yara4d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement_colloque_scienntifique
    ADD CONSTRAINT fk1r3g38rlqo4iwekn5r2yara4d FOREIGN KEY (modalite_id) REFERENCES public.modalite(id);


--
-- TOC entry 5635 (class 2606 OID 93124)
-- Name: etablissement fk1vrpg4msiytjjbgf3tq9j401f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement
    ADD CONSTRAINT fk1vrpg4msiytjjbgf3tq9j401f FOREIGN KEY (ville_id) REFERENCES public.ville(id);


--
-- TOC entry 5763 (class 2606 OID 93129)
-- Name: outil_pedagogique_langue fk1xwdpwveju573yrkqs9fxed5r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_langue
    ADD CONSTRAINT fk1xwdpwveju573yrkqs9fxed5r FOREIGN KEY (langue_id) REFERENCES public.langue(id);


--
-- TOC entry 5716 (class 2606 OID 93134)
-- Name: institution_co_contractant fk1yf4fp0pt4qwfylsddv5wf0kl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.institution_co_contractant
    ADD CONSTRAINT fk1yf4fp0pt4qwfylsddv5wf0kl FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5931 (class 2606 OID 93139)
-- Name: zone_geographique_formation_continue fk272j8a2a70nmi91qtlnr47u12; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_geographique_formation_continue
    ADD CONSTRAINT fk272j8a2a70nmi91qtlnr47u12 FOREIGN KEY (formation_continue_id) REFERENCES public.formation_continue(id);


--
-- TOC entry 5732 (class 2606 OID 93144)
-- Name: instruments_et_dispositifs_ird_projet_activite_recherche fk2756onljvg272o2hk3pd79ymk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instruments_et_dispositifs_ird_projet_activite_recherche
    ADD CONSTRAINT fk2756onljvg272o2hk3pd79ymk FOREIGN KEY (projet_activite_recherche_id) REFERENCES public.projet_activite_recherche(id);


--
-- TOC entry 5495 (class 2606 OID 93149)
-- Name: consultance_scientifique_ponctuelle fk28kq6xjrp3ldxtcunxcfhmoy8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultance_scientifique_ponctuelle
    ADD CONSTRAINT fk28kq6xjrp3ldxtcunxcfhmoy8 FOREIGN KEY (type_expertise_id) REFERENCES public.type_expertise(id);


--
-- TOC entry 5527 (class 2606 OID 93154)
-- Name: dev_savoir_innov_scientifique_mode_diffusion fk29a0l1bkdkwrv5cilhnv21wj6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_mode_diffusion
    ADD CONSTRAINT fk29a0l1bkdkwrv5cilhnv21wj6 FOREIGN KEY (developpement_de_savoir_et_innovation_scientifique_id) REFERENCES public.dev_savoir_innov_scientifique(id);


--
-- TOC entry 5754 (class 2606 OID 93159)
-- Name: organisme fk2a74re6wm2678u3wkm28oabpw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.organisme
    ADD CONSTRAINT fk2a74re6wm2678u3wkm28oabpw FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5593 (class 2606 OID 93164)
-- Name: encadrement_etudiant fk2el75t3ohq1w6eq28uvh3233n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_etudiant
    ADD CONSTRAINT fk2el75t3ohq1w6eq28uvh3233n FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5892 (class 2606 OID 93169)
-- Name: type_instrument_ird_chercheur fk2f7gctd174pxi7r5uudm6wvd0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_instrument_ird_chercheur
    ADD CONSTRAINT fk2f7gctd174pxi7r5uudm6wvd0 FOREIGN KEY (type_instrument_ird_id) REFERENCES public.type_instrument_ird(id);


--
-- TOC entry 5723 (class 2606 OID 93174)
-- Name: instrument_ird_comite_et_commission_evaluation fk2fw1xuos62ctvpt7rcb4s22w2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instrument_ird_comite_et_commission_evaluation
    ADD CONSTRAINT fk2fw1xuos62ctvpt7rcb4s22w2 FOREIGN KEY (comite_et_commission_evaluation_id) REFERENCES public.comite_et_commission_evaluation(id);


--
-- TOC entry 5515 (class 2606 OID 93179)
-- Name: culture_scientifique_recontre_grand_public_jeune_public fk2h90tvekaw2jhcghxnin4t4kk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.culture_scientifique_recontre_grand_public_jeune_public
    ADD CONSTRAINT fk2h90tvekaw2jhcghxnin4t4kk FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5792 (class 2606 OID 93184)
-- Name: pays_rencontre_grand_publique_jeune_publique fk2i58v8h4r9qmgj3upsbn453yy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fk2i58v8h4r9qmgj3upsbn453yy FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5554 (class 2606 OID 93189)
-- Name: discipline_scientifique_direction_encadrement_doctorant fk2kcwewp47o9lyhtm18wvu40ou; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_direction_encadrement_doctorant
    ADD CONSTRAINT fk2kcwewp47o9lyhtm18wvu40ou FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5476 (class 2606 OID 93194)
-- Name: communaute_savoir_encadrement_etudiant fk2mq6t8kslixgeog9iq6kvws2c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_encadrement_etudiant
    ADD CONSTRAINT fk2mq6t8kslixgeog9iq6kvws2c FOREIGN KEY (encadrement_etudiant_id) REFERENCES public.encadrement_etudiant(id);


--
-- TOC entry 5835 (class 2606 OID 93199)
-- Name: rencontre_grand_publique_jeune_publique fk2pr7ubywebax20vv0dx8kmn0v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fk2pr7ubywebax20vv0dx8kmn0v FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5429 (class 2606 OID 93204)
-- Name: bourse fk2qni81ood10fs68gpvuimpb6t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bourse
    ADD CONSTRAINT fk2qni81ood10fs68gpvuimpb6t FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5561 (class 2606 OID 93209)
-- Name: discipline_scientifique_erc_association fk2qres4lwp4uxtmgt7y6tujg5a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_erc_association
    ADD CONSTRAINT fk2qres4lwp4uxtmgt7y6tujg5a FOREIGN KEY (semantic_relationship_id) REFERENCES public.semantic_relationship(id);


--
-- TOC entry 5759 (class 2606 OID 93214)
-- Name: outil_pedagogique_enjeux_ird fk2rcslp0cqi1idjqk4fdqg8ox4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_enjeux_ird
    ADD CONSTRAINT fk2rcslp0cqi1idjqk4fdqg8ox4 FOREIGN KEY (enjeux_ird_id) REFERENCES public.enjeux_ird(id);


--
-- TOC entry 5586 (class 2606 OID 93219)
-- Name: encadrement_doctorant fk2rot50o90nhwbrn2sqk7qgnqp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_doctorant
    ADD CONSTRAINT fk2rot50o90nhwbrn2sqk7qgnqp FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5811 (class 2606 OID 93224)
-- Name: projet_activite_recherche_detail_etablissement_financeur fk2s1xxcne1pn2nu7kutgc4ohus; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_etablissement_financeur
    ADD CONSTRAINT fk2s1xxcne1pn2nu7kutgc4ohus FOREIGN KEY (projet_activite_recherche_detail_id) REFERENCES public.projet_activite_recherche_detail(id);


--
-- TOC entry 5536 (class 2606 OID 93229)
-- Name: developpement_de_savoir_et_innovation_scientifique_enjeux_ird fk2xfp4s8eume6idtppyhn5a1q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developpement_de_savoir_et_innovation_scientifique_enjeux_ird
    ADD CONSTRAINT fk2xfp4s8eume6idtppyhn5a1q FOREIGN KEY (developpement_de_savoir_et_innovation_scientifique_id) REFERENCES public.developpement_de_savoir_et_innovation_scientifique(id);


--
-- TOC entry 5784 (class 2606 OID 93234)
-- Name: pays_encadrement_etudiant fk320umlrexu0k837wm8tslmo1b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_encadrement_etudiant
    ADD CONSTRAINT fk320umlrexu0k837wm8tslmo1b FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5443 (class 2606 OID 93239)
-- Name: campagne_rappel fk32n5i6di6naefb16yctsbuxe5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_rappel
    ADD CONSTRAINT fk32n5i6di6naefb16yctsbuxe5 FOREIGN KEY (template_rappel_id) REFERENCES public.template_rappel(id);


--
-- TOC entry 5469 (class 2606 OID 93244)
-- Name: commanditaire fk33ue2qf06nu4l5eawrredob62; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commanditaire
    ADD CONSTRAINT fk33ue2qf06nu4l5eawrredob62 FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5883 (class 2606 OID 93249)
-- Name: savoir_et_innovation fk35l36rb5hit57thy6qi97fhwl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.savoir_et_innovation
    ADD CONSTRAINT fk35l36rb5hit57thy6qi97fhwl FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5922 (class 2606 OID 93254)
-- Name: zone_activite_interaction_recherche fk38ffb7jfovf9awxelrt866j04; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_activite_interaction_recherche
    ADD CONSTRAINT fk38ffb7jfovf9awxelrt866j04 FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5721 (class 2606 OID 93259)
-- Name: instrument_ird_chercheur fk3abye6iye26jmmn9ynj00lp75; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instrument_ird_chercheur
    ADD CONSTRAINT fk3abye6iye26jmmn9ynj00lp75 FOREIGN KEY (instrument_ird_id) REFERENCES public.instrument_ird(id);


--
-- TOC entry 5706 (class 2606 OID 93264)
-- Name: formation_continue_publique_professionel fk3aok74qc2yeg52m8ggi1nhmjq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue_publique_professionel
    ADD CONSTRAINT fk3aok74qc2yeg52m8ggi1nhmjq FOREIGN KEY (formation_continue_id) REFERENCES public.formation_continue(id);


--
-- TOC entry 5673 (class 2606 OID 93269)
-- Name: evenement_colloque_scienntifique_pays fk3c4soktuhybslepyaxf2l95ts; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement_colloque_scienntifique_pays
    ADD CONSTRAINT fk3c4soktuhybslepyaxf2l95ts FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5853 (class 2606 OID 93274)
-- Name: rencontre_media_enjeux_ird fk3f0adalbgjhahqr2gp44j4mom; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_media_enjeux_ird
    ADD CONSTRAINT fk3f0adalbgjhahqr2gp44j4mom FOREIGN KEY (rencontre_media_id) REFERENCES public.rencontre_media(id);


--
-- TOC entry 5893 (class 2606 OID 93279)
-- Name: type_instrument_ird_chercheur fk3fb3phol41dpsei951pgpiwu8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_instrument_ird_chercheur
    ADD CONSTRAINT fk3fb3phol41dpsei951pgpiwu8 FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5570 (class 2606 OID 93284)
-- Name: distinction fk3fjhpc72bw4nsqvyv797m5wd4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.distinction
    ADD CONSTRAINT fk3fjhpc72bw4nsqvyv797m5wd4 FOREIGN KEY (type_participation_id) REFERENCES public.type_participation(id);


--
-- TOC entry 5918 (class 2606 OID 93289)
-- Name: vie_institutionnelle_detail_etablissement fk3hlepolwr3264om24e2r2nk7s; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vie_institutionnelle_detail_etablissement
    ADD CONSTRAINT fk3hlepolwr3264om24e2r2nk7s FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5484 (class 2606 OID 93294)
-- Name: communaute_savoir_projet_activite_recherche fk3j14lbr5b7vsadb3xol2od2e; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_projet_activite_recherche
    ADD CONSTRAINT fk3j14lbr5b7vsadb3xol2od2e FOREIGN KEY (communaute_savoir_id) REFERENCES public.communaute_savoir(id);


--
-- TOC entry 5843 (class 2606 OID 93299)
-- Name: rencontre_grand_publique_jeune_publique_instrument_ird fk3mf2xnxorrb46vbpj3iw4srim; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique_instrument_ird
    ADD CONSTRAINT fk3mf2xnxorrb46vbpj3iw4srim FOREIGN KEY (instrument_ird_id) REFERENCES public.instrument_ird(id);


--
-- TOC entry 5677 (class 2606 OID 93304)
-- Name: expertise fk3myefbpwrvsb7g112uk8cgeb2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expertise
    ADD CONSTRAINT fk3myefbpwrvsb7g112uk8cgeb2 FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5523 (class 2606 OID 93309)
-- Name: dev_savoir_innov_scientifique_enjeux_ird fk3pd3yr28pb1gy0q0ryu6wm6sd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_enjeux_ird
    ADD CONSTRAINT fk3pd3yr28pb1gy0q0ryu6wm6sd FOREIGN KEY (developpement_de_savoir_et_innovation_scientifique_id) REFERENCES public.dev_savoir_innov_scientifique(id);


--
-- TOC entry 5932 (class 2606 OID 93314)
-- Name: zone_geographique_formation_continue fk3px8jikupob3wiwauod6ukx8h; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_geographique_formation_continue
    ADD CONSTRAINT fk3px8jikupob3wiwauod6ukx8h FOREIGN KEY (zone_geographique_id) REFERENCES public.zone_geographique(id);


--
-- TOC entry 5881 (class 2606 OID 93319)
-- Name: roles_permissions fk3q3rt3at2wf4ooe7npa3et6yb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles_permissions
    ADD CONSTRAINT fk3q3rt3at2wf4ooe7npa3et6yb FOREIGN KEY (role_id) REFERENCES public.role_app(id);


--
-- TOC entry 5531 (class 2606 OID 93324)
-- Name: dev_savoir_innov_scientifique_role fk3sl8h8h5ntbyl9i9dp447y94t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_role
    ADD CONSTRAINT fk3sl8h8h5ntbyl9i9dp447y94t FOREIGN KEY (role_developpement_de_savoir_id) REFERENCES public.role_developpement_de_savoir(id);


--
-- TOC entry 5605 (class 2606 OID 93329)
-- Name: enjeux_ird_chercheur fk3swkikba39fqle5hn7icxpoye; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enjeux_ird_chercheur
    ADD CONSTRAINT fk3swkikba39fqle5hn7icxpoye FOREIGN KEY (enjeux_ird_id) REFERENCES public.enjeux_ird(id);


--
-- TOC entry 5449 (class 2606 OID 93334)
-- Name: campagne_relance_chercheur fk3u9msl4c0ej0jc0jhyhwydo3e; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_relance_chercheur
    ADD CONSTRAINT fk3u9msl4c0ej0jc0jhyhwydo3e FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5906 (class 2606 OID 93339)
-- Name: type_utilisateur_savoir_concu fk3w6xkgurrbk351pt54y2dhlj4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_utilisateur_savoir_concu
    ADD CONSTRAINT fk3w6xkgurrbk351pt54y2dhlj4 FOREIGN KEY (developpement_de_savoir_et_innovation_scientifique_id) REFERENCES public.dev_savoir_innov_scientifique(id);


--
-- TOC entry 5594 (class 2606 OID 93344)
-- Name: encadrement_etudiant fk3wcivayirs0bxjpk607p9260y; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_etudiant
    ADD CONSTRAINT fk3wcivayirs0bxjpk607p9260y FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5629 (class 2606 OID 93349)
-- Name: enseignement_nature fk46amyfpunmnrgexs178hf0smo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_nature
    ADD CONSTRAINT fk46amyfpunmnrgexs178hf0smo FOREIGN KEY (nature_enseignement_id) REFERENCES public.nature_enseignement(id);


--
-- TOC entry 5724 (class 2606 OID 93354)
-- Name: instrument_ird_comite_et_commission_evaluation fk46ffld68tt9cmfsfulhgg2gnt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instrument_ird_comite_et_commission_evaluation
    ADD CONSTRAINT fk46ffld68tt9cmfsfulhgg2gnt FOREIGN KEY (instrument_ird_id) REFERENCES public.instrument_ird(id);


--
-- TOC entry 5919 (class 2606 OID 93359)
-- Name: vie_institutionnelle_detail_instrument_ird fk46of4vw3i6dcvfyt0phip5cmr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vie_institutionnelle_detail_instrument_ird
    ADD CONSTRAINT fk46of4vw3i6dcvfyt0phip5cmr FOREIGN KEY (vie_institutionnelle_detail_id) REFERENCES public.vie_institutionnelle_detail(id);


--
-- TOC entry 5737 (class 2606 OID 93364)
-- Name: modalite_etude_enseignement fk4adl2u61lex2efvntvdvg0prf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modalite_etude_enseignement
    ADD CONSTRAINT fk4adl2u61lex2efvntvdvg0prf FOREIGN KEY (enseignement_id) REFERENCES public.enseignement(id);


--
-- TOC entry 5714 (class 2606 OID 93369)
-- Name: identifiant_auteur_expert fk4aftri2emt44b7lglaq2i5y3g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.identifiant_auteur_expert
    ADD CONSTRAINT fk4aftri2emt44b7lglaq2i5y3g FOREIGN KEY (identifiant_recherche_id) REFERENCES public.identifiant_recherche(id);


--
-- TOC entry 5499 (class 2606 OID 93374)
-- Name: contexte_culture_scientifique_recontre_grand_public_jeune_publi fk4ak92ek4pvl9ddbgr4qy3dmoe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contexte_culture_scientifique_recontre_grand_public_jeune_publi
    ADD CONSTRAINT fk4ak92ek4pvl9ddbgr4qy3dmoe FOREIGN KEY (culture_scientifique_recontre_grand_public_jeune_public_id) REFERENCES public.culture_scientifique_recontre_grand_public_jeune_public(id);


--
-- TOC entry 5595 (class 2606 OID 93379)
-- Name: encadrement_etudiant fk4bnfu9hgan479a42d45dctf4l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_etudiant
    ADD CONSTRAINT fk4bnfu9hgan479a42d45dctf4l FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5909 (class 2606 OID 93384)
-- Name: users_roles fk4e8pdqeupv69eukb2bvy2ftbd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fk4e8pdqeupv69eukb2bvy2ftbd FOREIGN KEY (role_id) REFERENCES public.role_app(id);


--
-- TOC entry 5671 (class 2606 OID 93389)
-- Name: evenement_colloque_scienntifique_enjeux_ird fk4f6shsp2jbwqwidy2c89nvb2o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement_colloque_scienntifique_enjeux_ird
    ADD CONSTRAINT fk4f6shsp2jbwqwidy2c89nvb2o FOREIGN KEY (evenement_colloque_scienntifique_id) REFERENCES public.evenement_colloque_scienntifique(id);


--
-- TOC entry 5432 (class 2606 OID 93394)
-- Name: campagne fk4hx88fmyabctlov22fsusa4jk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne
    ADD CONSTRAINT fk4hx88fmyabctlov22fsusa4jk FOREIGN KEY (template_cloture_id) REFERENCES public.template_cloture(id);


--
-- TOC entry 5860 (class 2606 OID 93399)
-- Name: responsabilite_pedagogique_ecole_doctorale fk4igku82g2dl35164wfjql8w8d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_ecole_doctorale
    ADD CONSTRAINT fk4igku82g2dl35164wfjql8w8d FOREIGN KEY (statut_ecole_doctorale_id) REFERENCES public.statut_ecole_doctorale(id);


--
-- TOC entry 5798 (class 2606 OID 93404)
-- Name: pays_zone_geographique fk4l57r1tla4coj2xfymtorhypp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_zone_geographique
    ADD CONSTRAINT fk4l57r1tla4coj2xfymtorhypp FOREIGN KEY (zone_geographique_id) REFERENCES public.zone_geographique(id);


--
-- TOC entry 5641 (class 2606 OID 93409)
-- Name: etablissement_consultance_scientifique_ponctuelle fk4lb1nrc24po24rslha9faluji; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_consultance_scientifique_ponctuelle
    ADD CONSTRAINT fk4lb1nrc24po24rslha9faluji FOREIGN KEY (consultance_scientifique_ponctuelle_id) REFERENCES public.consultance_scientifique_ponctuelle(id);


--
-- TOC entry 5571 (class 2606 OID 93414)
-- Name: distinction fk4lyql7gwj7gkix20diri4qts1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.distinction
    ADD CONSTRAINT fk4lyql7gwj7gkix20diri4qts1 FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5624 (class 2606 OID 93419)
-- Name: enseignement_enjeux_ird fk4ncx19k8v2enj1gvtlp54ef9a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_enjeux_ird
    ADD CONSTRAINT fk4ncx19k8v2enj1gvtlp54ef9a FOREIGN KEY (enjeux_ird_id) REFERENCES public.enjeux_ird(id);


--
-- TOC entry 5509 (class 2606 OID 93424)
-- Name: culture_scientifique fk4nxydbg56hsy7b0nu6773yt3m; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.culture_scientifique
    ADD CONSTRAINT fk4nxydbg56hsy7b0nu6773yt3m FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5800 (class 2606 OID 93429)
-- Name: projet_activite_recherche fk4s5pu7ymsi7c87geok79adwar; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche
    ADD CONSTRAINT fk4s5pu7ymsi7c87geok79adwar FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5816 (class 2606 OID 93434)
-- Name: projet_activite_recherche_detail_institution_co_contractant fk4tk2e6bfus5ec2ojw7cvriqrs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_institution_co_contractant
    ADD CONSTRAINT fk4tk2e6bfus5ec2ojw7cvriqrs FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5529 (class 2606 OID 93439)
-- Name: dev_savoir_innov_scientifique_pays fk4tn4h5vm19kd9f27hr22q6rj8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_pays
    ADD CONSTRAINT fk4tn4h5vm19kd9f27hr22q6rj8 FOREIGN KEY (developpement_de_savoir_et_innovation_scientifique_id) REFERENCES public.dev_savoir_innov_scientifique(id);


--
-- TOC entry 5615 (class 2606 OID 93444)
-- Name: enseignement fk55rtk2dcp1a1ei0oxsdrxksob; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement
    ADD CONSTRAINT fk55rtk2dcp1a1ei0oxsdrxksob FOREIGN KEY (modalite_etude_id) REFERENCES public.modalite_etude(id);


--
-- TOC entry 5622 (class 2606 OID 93449)
-- Name: enseignement_discipline_scientifique fk57hhyno742wtc334f36ss7g5l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_discipline_scientifique
    ADD CONSTRAINT fk57hhyno742wtc334f36ss7g5l FOREIGN KEY (enseignement_id) REFERENCES public.enseignement(id);


--
-- TOC entry 5921 (class 2606 OID 93454)
-- Name: ville fk5ak72iyy65hfya4frs9pkprin; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville
    ADD CONSTRAINT fk5ak72iyy65hfya4frs9pkprin FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5801 (class 2606 OID 93459)
-- Name: projet_activite_recherche fk5guo7bkfyo8uon9nd1en866d2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche
    ADD CONSTRAINT fk5guo7bkfyo8uon9nd1en866d2 FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5578 (class 2606 OID 93464)
-- Name: doctorant fk5hahscf3qj3eih5nl7v6vps0j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.doctorant
    ADD CONSTRAINT fk5hahscf3qj3eih5nl7v6vps0j FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5746 (class 2606 OID 93469)
-- Name: notification fk5igfrt85nmstr5fbhb1p6gmn2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification
    ADD CONSTRAINT fk5igfrt85nmstr5fbhb1p6gmn2 FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5659 (class 2606 OID 93474)
-- Name: evaluation_recherche_universitaire fk5kk1o2a9s6ipvwye1p95k42pj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation_recherche_universitaire
    ADD CONSTRAINT fk5kk1o2a9s6ipvwye1p95k42pj FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5564 (class 2606 OID 93479)
-- Name: discipline_scientifique_evaluation_recherche_universitaire fk5ogv52wgxdhmra9kmr2objud; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_evaluation_recherche_universitaire
    ADD CONSTRAINT fk5ogv52wgxdhmra9kmr2objud FOREIGN KEY (evaluation_recherche_universitaire_id) REFERENCES public.evaluation_recherche_universitaire(id);


--
-- TOC entry 5643 (class 2606 OID 93484)
-- Name: etablissement_culture_scientifique_outil_pedagogique fk5ojxspjupnmximerxyws6g7ry; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_culture_scientifique_outil_pedagogique
    ADD CONSTRAINT fk5ojxspjupnmximerxyws6g7ry FOREIGN KEY (culture_scientifique_outil_pedagogique_id) REFERENCES public.culture_scientifique_outil_pedagogique(id);


--
-- TOC entry 5587 (class 2606 OID 93489)
-- Name: encadrement_doctorant fk5p4w8y3q2ktiupi6ij9rvw9n5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_doctorant
    ADD CONSTRAINT fk5p4w8y3q2ktiupi6ij9rvw9n5 FOREIGN KEY (doctorant_id) REFERENCES public.doctorant(id);


--
-- TOC entry 5548 (class 2606 OID 93494)
-- Name: discipline_scientifique_conseil_et_comite_scientifique fk5pedsqjpylbdwoly69qug3qqo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_conseil_et_comite_scientifique
    ADD CONSTRAINT fk5pedsqjpylbdwoly69qug3qqo FOREIGN KEY (conseil_et_comite_scientifique_id) REFERENCES public.conseil_et_comite_scientifique(id);


--
-- TOC entry 5550 (class 2606 OID 93499)
-- Name: discipline_scientifique_conseils_scientifique fk5rmv23olu6hcuhf5u58p9gdya; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_conseils_scientifique
    ADD CONSTRAINT fk5rmv23olu6hcuhf5u58p9gdya FOREIGN KEY (conseils_scientifique_id) REFERENCES public.conseils_scientifique(id);


--
-- TOC entry 5687 (class 2606 OID 93504)
-- Name: financement_encadrement_doctorant fk60qv2w012xvebw4q64iffxbbc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.financement_encadrement_doctorant
    ADD CONSTRAINT fk60qv2w012xvebw4q64iffxbbc FOREIGN KEY (financement_id) REFERENCES public.financement_doctorant(id);


--
-- TOC entry 5925 (class 2606 OID 93509)
-- Name: zone_geographique_conseils_scientifique fk61c9026oyxnl8leohi3svkm95; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_geographique_conseils_scientifique
    ADD CONSTRAINT fk61c9026oyxnl8leohi3svkm95 FOREIGN KEY (zone_geographique_id) REFERENCES public.zone_geographique(id);


--
-- TOC entry 5667 (class 2606 OID 93514)
-- Name: evenement_colloque_scienntifique fk64iwhhkw2vmgx02gasu8cbrf6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement_colloque_scienntifique
    ADD CONSTRAINT fk64iwhhkw2vmgx02gasu8cbrf6 FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5656 (class 2606 OID 93519)
-- Name: etablissement_rencontre_grand_publique_jeune_publique fk657wm7w0bfqeo2a6l7xp49qh9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fk657wm7w0bfqeo2a6l7xp49qh9 FOREIGN KEY (rencontre_grand_publique_jeune_publique_id) REFERENCES public.rencontre_grand_publique_jeune_publique(id);


--
-- TOC entry 5616 (class 2606 OID 93524)
-- Name: enseignement fk6ax3xog1g19s3f91mvgbi6adc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement
    ADD CONSTRAINT fk6ax3xog1g19s3f91mvgbi6adc FOREIGN KEY (enseignement_et_formation_id) REFERENCES public.enseignement_et_formation(id);


--
-- TOC entry 5803 (class 2606 OID 93529)
-- Name: projet_activite_recherche_detail fk6fm1pwvls322co0j3xpdjj22p; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail
    ADD CONSTRAINT fk6fm1pwvls322co0j3xpdjj22p FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5491 (class 2606 OID 93534)
-- Name: conseils_scientifique fk6g3i2btn1oygmev3xvb7v49ka; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.conseils_scientifique
    ADD CONSTRAINT fk6g3i2btn1oygmev3xvb7v49ka FOREIGN KEY (expertise_id) REFERENCES public.expertise(id);


--
-- TOC entry 5827 (class 2606 OID 93539)
-- Name: publique_cible_rencontre_grand_publique_jeune_publique fk6gc7ys90ovg0au21gifyljgkq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publique_cible_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fk6gc7ys90ovg0au21gifyljgkq FOREIGN KEY (rencontre_grand_publique_jeune_publique_id) REFERENCES public.rencontre_grand_publique_jeune_publique(id);


--
-- TOC entry 5558 (class 2606 OID 93544)
-- Name: discipline_scientifique_encadrement_etudiant fk6hygm6t83e0uq0fcvbu85x8fv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_encadrement_etudiant
    ADD CONSTRAINT fk6hygm6t83e0uq0fcvbu85x8fv FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5456 (class 2606 OID 93549)
-- Name: chercheur fk6kfn7e51ldevi47bh1lom3r9a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chercheur
    ADD CONSTRAINT fk6kfn7e51ldevi47bh1lom3r9a FOREIGN KEY (departement_scientifique_id) REFERENCES public.departement_scientifique(id);


--
-- TOC entry 5907 (class 2606 OID 93554)
-- Name: type_utilisateur_savoir_concu fk6krsgdm0edqvsl73glh5d3jl0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_utilisateur_savoir_concu
    ADD CONSTRAINT fk6krsgdm0edqvsl73glh5d3jl0 FOREIGN KEY (developpement_de_savoir_et_innovation_scientifique_id) REFERENCES public.developpement_de_savoir_et_innovation_scientifique(id);


--
-- TOC entry 5617 (class 2606 OID 93559)
-- Name: enseignement fk6lcs3ocykoxftd43lv84a0u1f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement
    ADD CONSTRAINT fk6lcs3ocykoxftd43lv84a0u1f FOREIGN KEY (type_enseignement_dispense_id) REFERENCES public.type_enseignement_dispense(id);


--
-- TOC entry 5774 (class 2606 OID 93564)
-- Name: outil_pedagogique_type_instrument_ird fk6lur2lovtc1i6btei3ismbyej; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_type_instrument_ird
    ADD CONSTRAINT fk6lur2lovtc1i6btei3ismbyej FOREIGN KEY (outil_pedagogique_id) REFERENCES public.outil_pedagogique(id);


--
-- TOC entry 5690 (class 2606 OID 93569)
-- Name: formation_continue fk6onkh5s5u24g0ws7ugqfih6q0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue
    ADD CONSTRAINT fk6onkh5s5u24g0ws7ugqfih6q0 FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5588 (class 2606 OID 93574)
-- Name: encadrement_doctorant fk6rau8tbkhwp5f2mb3lrlvobvj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_doctorant
    ADD CONSTRAINT fk6rau8tbkhwp5f2mb3lrlvobvj FOREIGN KEY (encadrement_id) REFERENCES public.encadrement(id);


--
-- TOC entry 5824 (class 2606 OID 93579)
-- Name: public_cible_culture_scientifique_recontre_grand_public fk6tu9vssbga2kl6n5xp0klu5ym; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_cible_culture_scientifique_recontre_grand_public
    ADD CONSTRAINT fk6tu9vssbga2kl6n5xp0klu5ym FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5691 (class 2606 OID 93584)
-- Name: formation_continue fk75lp3bo31ckxqp1y7w3u198q4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue
    ADD CONSTRAINT fk75lp3bo31ckxqp1y7w3u198q4 FOREIGN KEY (modalite_formation_continue_id) REFERENCES public.modalite_formation_continue(id);


--
-- TOC entry 5533 (class 2606 OID 93589)
-- Name: developpement_de_savoir_et_innovation_scientifique fk7ck9nslb5k2loh68brur51uln; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developpement_de_savoir_et_innovation_scientifique
    ADD CONSTRAINT fk7ck9nslb5k2loh68brur51uln FOREIGN KEY (role_developpement_de_savoir_id) REFERENCES public.role_developpement_de_savoir(id);


--
-- TOC entry 5610 (class 2606 OID 93594)
-- Name: enjeux_ird_conseils_scientifique fk7e0s7x0rvndbojni0om3xpq17; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enjeux_ird_conseils_scientifique
    ADD CONSTRAINT fk7e0s7x0rvndbojni0om3xpq17 FOREIGN KEY (conseils_scientifique_id) REFERENCES public.conseils_scientifique(id);


--
-- TOC entry 5630 (class 2606 OID 93599)
-- Name: enseignement_nature fk7gehuc48i2g3sddvfk4t0asbp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_nature
    ADD CONSTRAINT fk7gehuc48i2g3sddvfk4t0asbp FOREIGN KEY (enseignement_id) REFERENCES public.enseignement(id);


--
-- TOC entry 5480 (class 2606 OID 93604)
-- Name: communaute_savoir_evenement_colloque_scientifique fk7i7stk0843ehufs0k8plhuf0n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_evenement_colloque_scientifique
    ADD CONSTRAINT fk7i7stk0843ehufs0k8plhuf0n FOREIGN KEY (communaute_savoir_id) REFERENCES public.communaute_savoir(id);


--
-- TOC entry 5543 (class 2606 OID 93609)
-- Name: discipline_scientifique_chercheur fk7k4wb2cefpehoh7hslvxq26w7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_chercheur
    ADD CONSTRAINT fk7k4wb2cefpehoh7hslvxq26w7 FOREIGN KEY (discipline_scientifique_erc_id) REFERENCES public.discipline_scientifique_erc(id);


--
-- TOC entry 5902 (class 2606 OID 93614)
-- Name: type_publique_rencontre_media fk7mix7xssfv0tta178b2kqelhf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_publique_rencontre_media
    ADD CONSTRAINT fk7mix7xssfv0tta178b2kqelhf FOREIGN KEY (type_publique_id) REFERENCES public.type_publique(id);


--
-- TOC entry 5767 (class 2606 OID 93619)
-- Name: outil_pedagogique_pays_diffusion fk7mu8r0jxhnvgn11fjo809g94s; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_pays_diffusion
    ADD CONSTRAINT fk7mu8r0jxhnvgn11fjo809g94s FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5474 (class 2606 OID 93624)
-- Name: communaute_savoir_encadrement_doctorant fk7p4y6c7rc5pwooc6bp70nqd0d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_encadrement_doctorant
    ADD CONSTRAINT fk7p4y6c7rc5pwooc6bp70nqd0d FOREIGN KEY (communaute_savoir_id) REFERENCES public.communaute_savoir(id);


--
-- TOC entry 5700 (class 2606 OID 93629)
-- Name: formation_continue_discipline_scientifique fk7rw9kq6fx77hxfj4v0yeflvd6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue_discipline_scientifique
    ADD CONSTRAINT fk7rw9kq6fx77hxfj4v0yeflvd6 FOREIGN KEY (formation_continue_id) REFERENCES public.formation_continue(id);


--
-- TOC entry 5718 (class 2606 OID 93634)
-- Name: institution_co_contractant_projet_activite_recherche fk7v6jbbl7pijx8s0ew5mnk7wc7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.institution_co_contractant_projet_activite_recherche
    ADD CONSTRAINT fk7v6jbbl7pijx8s0ew5mnk7wc7 FOREIGN KEY (institution_co_contractant_id) REFERENCES public.institution_co_contractant(id);


--
-- TOC entry 5583 (class 2606 OID 93639)
-- Name: encadrement fk7wd9quvr8he15v53coc0h48cs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement
    ADD CONSTRAINT fk7wd9quvr8he15v53coc0h48cs FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5506 (class 2606 OID 93644)
-- Name: contrat_et_convention_ird_partenaire fk7xrt0jtc3fkqmscjd6cujpr24; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contrat_et_convention_ird_partenaire
    ADD CONSTRAINT fk7xrt0jtc3fkqmscjd6cujpr24 FOREIGN KEY (partenaire_id) REFERENCES public.partenaire(id);


--
-- TOC entry 5510 (class 2606 OID 93649)
-- Name: culture_scientifique fk81gnsbg68wcv3kri3rtqbgy9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.culture_scientifique
    ADD CONSTRAINT fk81gnsbg68wcv3kri3rtqbgy9 FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5780 (class 2606 OID 93654)
-- Name: pays_culture_scientifique_recontre_grand_public_jeune_public fk85u9kx6s8yuvh0b52ak1urb5x; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_culture_scientifique_recontre_grand_public_jeune_public
    ADD CONSTRAINT fk85u9kx6s8yuvh0b52ak1urb5x FOREIGN KEY (culture_scientifique_recontre_grand_public_jeune_public_id) REFERENCES public.culture_scientifique_recontre_grand_public_jeune_public(id);


--
-- TOC entry 5657 (class 2606 OID 93659)
-- Name: etudiant fk862uhnp71whp9m46kn1wuh1f8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etudiant
    ADD CONSTRAINT fk862uhnp71whp9m46kn1wuh1f8 FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5790 (class 2606 OID 93664)
-- Name: pays_projet_recherche fk865ipu288un0rluxd38d34x3r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_projet_recherche
    ADD CONSTRAINT fk865ipu288un0rluxd38d34x3r FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5482 (class 2606 OID 93669)
-- Name: communaute_savoir_expertise_scientifique fk8g22xis14g8pmfq6y39xk5jbe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_expertise_scientifique
    ADD CONSTRAINT fk8g22xis14g8pmfq6y39xk5jbe FOREIGN KEY (expertise_scientifique_id) REFERENCES public.expertise_scientifique(id);


--
-- TOC entry 5649 (class 2606 OID 93674)
-- Name: etablissement_encadrement_etudiant fk8inxmrwhlyskigldwfex2o12u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_encadrement_etudiant
    ADD CONSTRAINT fk8inxmrwhlyskigldwfex2o12u FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5704 (class 2606 OID 93679)
-- Name: formation_continue_objet_formation_generique fk8lxe9ju5318kn8e4txw8kpe68; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue_objet_formation_generique
    ADD CONSTRAINT fk8lxe9ju5318kn8e4txw8kpe68 FOREIGN KEY (formation_continue_id) REFERENCES public.formation_continue(id);


--
-- TOC entry 5634 (class 2606 OID 93684)
-- Name: entite_administrative fk8nhotcfrhyevvnxdyha6kr9yc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entite_administrative
    ADD CONSTRAINT fk8nhotcfrhyevvnxdyha6kr9yc FOREIGN KEY (type_entite_administrative_id) REFERENCES public.type_entite_administrative(id);


--
-- TOC entry 5761 (class 2606 OID 93689)
-- Name: outil_pedagogique_instrument_ird fk8ohneat6r37tesspiufxvnrdh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_instrument_ird
    ADD CONSTRAINT fk8ohneat6r37tesspiufxvnrdh FOREIGN KEY (instrument_ird_id) REFERENCES public.instrument_ird(id);


--
-- TOC entry 5450 (class 2606 OID 93694)
-- Name: campagne_relance_chercheur fk8olngswcubc2hoxa5vux3hd6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_relance_chercheur
    ADD CONSTRAINT fk8olngswcubc2hoxa5vux3hd6 FOREIGN KEY (campagne_relance_id) REFERENCES public.campagne_relance(id);


--
-- TOC entry 5868 (class 2606 OID 93699)
-- Name: responsabilite_pedagogique_etablissement fk8pkr6vv5pktub054p8yhxl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_etablissement
    ADD CONSTRAINT fk8pkr6vv5pktub054p8yhxl FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5744 (class 2606 OID 93704)
-- Name: niveau_etude_enseignement fk8v7lv9lib2uexptgpdlm16n26; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.niveau_etude_enseignement
    ADD CONSTRAINT fk8v7lv9lib2uexptgpdlm16n26 FOREIGN KEY (niveau_etude_id) REFERENCES public.niveau_etude(id);


--
-- TOC entry 5430 (class 2606 OID 93709)
-- Name: bourse fk8wo4985rfy4hdg2xdecmk4bwd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bourse
    ADD CONSTRAINT fk8wo4985rfy4hdg2xdecmk4bwd FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5913 (class 2606 OID 93714)
-- Name: vie_institutionnelle_detail fk904ufurydjp0vsfwm7wwjlf1g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vie_institutionnelle_detail
    ADD CONSTRAINT fk904ufurydjp0vsfwm7wwjlf1g FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5709 (class 2606 OID 93719)
-- Name: gestion_equipe fk921eikxpcrltffj9onpkfw4dr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gestion_equipe
    ADD CONSTRAINT fk921eikxpcrltffj9onpkfw4dr FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5606 (class 2606 OID 93724)
-- Name: enjeux_ird_chercheur fk941q4ssh5v9g2qlotkl41m2hd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enjeux_ird_chercheur
    ADD CONSTRAINT fk941q4ssh5v9g2qlotkl41m2hd FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5804 (class 2606 OID 93729)
-- Name: projet_activite_recherche_detail fk952hq0o368vjo4jinip9gmoo7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail
    ADD CONSTRAINT fk952hq0o368vjo4jinip9gmoo7 FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5710 (class 2606 OID 93734)
-- Name: gestion_equipe fk95jwy4vi6tak70fudol7nqvyn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gestion_equipe
    ADD CONSTRAINT fk95jwy4vi6tak70fudol7nqvyn FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5435 (class 2606 OID 93739)
-- Name: campagne_chercheur fk99ij81xcraxkec7elf3skr5lu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_chercheur
    ADD CONSTRAINT fk99ij81xcraxkec7elf3skr5lu FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5856 (class 2606 OID 93744)
-- Name: responsabilite_pedagogique fk9fi3slpbfcr7r9xorfha4wqy2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique
    ADD CONSTRAINT fk9fi3slpbfcr7r9xorfha4wqy2 FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5540 (class 2606 OID 93749)
-- Name: developpement_de_savoir_et_innovation_scientifique_type_savoir fk9figs97jmg96r213grp0lok32; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developpement_de_savoir_et_innovation_scientifique_type_savoir
    ADD CONSTRAINT fk9figs97jmg96r213grp0lok32 FOREIGN KEY (developpement_de_savoir_et_innovation_scientifique_id) REFERENCES public.dev_savoir_innov_scientifique(id);


--
-- TOC entry 5672 (class 2606 OID 93754)
-- Name: evenement_colloque_scienntifique_enjeux_ird fk9g5vtvlqqt29j3dskmgujh973; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement_colloque_scienntifique_enjeux_ird
    ADD CONSTRAINT fk9g5vtvlqqt29j3dskmgujh973 FOREIGN KEY (enjeux_ird_id) REFERENCES public.enjeux_ird(id);


--
-- TOC entry 5794 (class 2606 OID 93759)
-- Name: pays_rencontre_media fk9ipft1llt6ywk59qdmn4s6dq2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_rencontre_media
    ADD CONSTRAINT fk9ipft1llt6ywk59qdmn4s6dq2 FOREIGN KEY (rencontre_media_id) REFERENCES public.rencontre_media(id);


--
-- TOC entry 5472 (class 2606 OID 93764)
-- Name: communaute_savoir_conseil_et_comite_scientifique fk9u2asjbqjp4w7j5buhnnnm80d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_conseil_et_comite_scientifique
    ADD CONSTRAINT fk9u2asjbqjp4w7j5buhnnnm80d FOREIGN KEY (conseil_et_comite_scientifique_id) REFERENCES public.conseil_et_comite_scientifique(id);


--
-- TOC entry 5879 (class 2606 OID 93769)
-- Name: role_comite_et_commission_evaluation fk9vhcuyc3gbadwr0e2qv0q5qha; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_comite_et_commission_evaluation
    ADD CONSTRAINT fk9vhcuyc3gbadwr0e2qv0q5qha FOREIGN KEY (role_evaluation_id) REFERENCES public.role_evaluation(id);


--
-- TOC entry 5831 (class 2606 OID 93774)
-- Name: reclamation fk9wwpj9my8ajo4w8ddgvr6h8ji; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reclamation
    ADD CONSTRAINT fk9wwpj9my8ajo4w8ddgvr6h8ji FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5740 (class 2606 OID 93779)
-- Name: mode_diffusion_developpement_de_savoir_et_innovation_scientifiq fka12f0hmlu2rsigdiab9gh4qrq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mode_diffusion_developpement_de_savoir_et_innovation_scientifiq
    ADD CONSTRAINT fka12f0hmlu2rsigdiab9gh4qrq FOREIGN KEY (mode_diffusion_id) REFERENCES public.mode_diffusion(id);


--
-- TOC entry 5778 (class 2606 OID 93784)
-- Name: pays_commanditaire fka3dvju76wd5kt17dlmgd75j1k; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_commanditaire
    ADD CONSTRAINT fka3dvju76wd5kt17dlmgd75j1k FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5898 (class 2606 OID 93789)
-- Name: type_outil_pedagogique fka48juflrqxyufd5f90biav2sc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_outil_pedagogique
    ADD CONSTRAINT fka48juflrqxyufd5f90biav2sc FOREIGN KEY (type_outil_id) REFERENCES public.type_outil(id);


--
-- TOC entry 5549 (class 2606 OID 93794)
-- Name: discipline_scientifique_conseil_et_comite_scientifique fka4v2kvj52xe2cwb7x9210g4bn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_conseil_et_comite_scientifique
    ADD CONSTRAINT fka4v2kvj52xe2cwb7x9210g4bn FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5914 (class 2606 OID 93799)
-- Name: vie_institutionnelle_detail fka537vsx0wr59gucjyqehc991n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vie_institutionnelle_detail
    ADD CONSTRAINT fka537vsx0wr59gucjyqehc991n FOREIGN KEY (type_instance_id) REFERENCES public.type_instance(id);


--
-- TOC entry 5802 (class 2606 OID 93804)
-- Name: projet_activite_recherche fkacamjdgv18pjeffmi4fjxvjta; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche
    ADD CONSTRAINT fkacamjdgv18pjeffmi4fjxvjta FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5500 (class 2606 OID 93809)
-- Name: contexte_culture_scientifique_recontre_grand_public_jeune_publi fkadxwg0g17s7eee9cjsn2pjlju; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contexte_culture_scientifique_recontre_grand_public_jeune_publi
    ADD CONSTRAINT fkadxwg0g17s7eee9cjsn2pjlju FOREIGN KEY (contexte_id) REFERENCES public.contexte(id);


--
-- TOC entry 5618 (class 2606 OID 93814)
-- Name: enseignement fkafw2l3aagwcamcildkfblxqr7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement
    ADD CONSTRAINT fkafw2l3aagwcamcildkfblxqr7 FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5639 (class 2606 OID 93819)
-- Name: etablissement_conseils_scientifique fkat6pptfvqdl86qp7lwvvyfx5u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_conseils_scientifique
    ADD CONSTRAINT fkat6pptfvqdl86qp7lwvvyfx5u FOREIGN KEY (conseils_scientifique_id) REFERENCES public.conseils_scientifique(id);


--
-- TOC entry 5559 (class 2606 OID 93824)
-- Name: discipline_scientifique_encadrement_etudiant fkau38ncov3bghptmcnu30tfcbx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_encadrement_etudiant
    ADD CONSTRAINT fkau38ncov3bghptmcnu30tfcbx FOREIGN KEY (encadrement_etudiant_id) REFERENCES public.encadrement_etudiant(id);


--
-- TOC entry 5478 (class 2606 OID 93829)
-- Name: communaute_savoir_evaluation_recherche_universitaire fkaxsdem4cxc9f2pa0yua8pohtv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_evaluation_recherche_universitaire
    ADD CONSTRAINT fkaxsdem4cxc9f2pa0yua8pohtv FOREIGN KEY (communaute_savoir_id) REFERENCES public.communaute_savoir(id);


--
-- TOC entry 5839 (class 2606 OID 93834)
-- Name: rencontre_grand_publique_jeune_publique_discipline fkay6h1c7iabwtbihm4lm4lc5uv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique_discipline
    ADD CONSTRAINT fkay6h1c7iabwtbihm4lm4lc5uv FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5568 (class 2606 OID 93839)
-- Name: discipline_scientifique_expertise_scientifique fkb14x59ydsjaoux9c1fo020ebv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_expertise_scientifique
    ADD CONSTRAINT fkb14x59ydsjaoux9c1fo020ebv FOREIGN KEY (expertise_scientifique_id) REFERENCES public.expertise_scientifique(id);


--
-- TOC entry 5748 (class 2606 OID 93844)
-- Name: objet_formation_generique_de_responsabilite_pedagogique fkb53jrg3ttcw8ckvhq33ea1rni; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.objet_formation_generique_de_responsabilite_pedagogique
    ADD CONSTRAINT fkb53jrg3ttcw8ckvhq33ea1rni FOREIGN KEY (responsabilite_pedagogique_id) REFERENCES public.responsabilite_pedagogique(id);


--
-- TOC entry 5848 (class 2606 OID 93849)
-- Name: rencontre_media fkbacnfab0c0cgidd7effqubhuj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_media
    ADD CONSTRAINT fkbacnfab0c0cgidd7effqubhuj FOREIGN KEY (format_rencontre_id) REFERENCES public.format_rencontre(id);


--
-- TOC entry 5750 (class 2606 OID 93854)
-- Name: objet_global_de_formation_continue fkbc7fv8nhp5n044va9ok34nkw8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.objet_global_de_formation_continue
    ADD CONSTRAINT fkbc7fv8nhp5n044va9ok34nkw8 FOREIGN KEY (objet_global_id) REFERENCES public.objet_global(id);


--
-- TOC entry 5619 (class 2606 OID 93859)
-- Name: enseignement fkbe883wnmvpuya8wrw7kanmd6f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement
    ADD CONSTRAINT fkbe883wnmvpuya8wrw7kanmd6f FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5819 (class 2606 OID 93864)
-- Name: projet_activite_recherche_detail_pays fkbhgd9h1h5orl5ryt1d5c3cw3o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_pays
    ADD CONSTRAINT fkbhgd9h1h5orl5ryt1d5c3cw3o FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5470 (class 2606 OID 93869)
-- Name: communaute_savoir_chercheur fkbhy38sjnb9fjlijsr3ul8ab1f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_chercheur
    ADD CONSTRAINT fkbhy38sjnb9fjlijsr3ul8ab1f FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5589 (class 2606 OID 93874)
-- Name: encadrement_doctorant fkbl456g18x25ksy98sirle8pih; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_doctorant
    ADD CONSTRAINT fkbl456g18x25ksy98sirle8pih FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5847 (class 2606 OID 93879)
-- Name: rencontre_grand_publique_jeune_publique_type_instrument_ird fkbmor4rffvtet4c4ws7i3koi76; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique_type_instrument_ird
    ADD CONSTRAINT fkbmor4rffvtet4c4ws7i3koi76 FOREIGN KEY (type_instrument_ird_id) REFERENCES public.type_instrument_ird(id);


--
-- TOC entry 5920 (class 2606 OID 93884)
-- Name: vie_institutionnelle_detail_instrument_ird fkbnfkxpp3x129vhmhanyb0lrh7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vie_institutionnelle_detail_instrument_ird
    ADD CONSTRAINT fkbnfkxpp3x129vhmhanyb0lrh7 FOREIGN KEY (instrument_ird_id) REFERENCES public.instrument_ird(id);


--
-- TOC entry 5882 (class 2606 OID 93889)
-- Name: roles_permissions fkboeuhl31go7wer3bpy6so7exi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles_permissions
    ADD CONSTRAINT fkboeuhl31go7wer3bpy6so7exi FOREIGN KEY (permission_id) REFERENCES public.permission(id);


--
-- TOC entry 5492 (class 2606 OID 93894)
-- Name: conseils_scientifique fkbq3adct447net7kki3gng2gnw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.conseils_scientifique
    ADD CONSTRAINT fkbq3adct447net7kki3gng2gnw FOREIGN KEY (nature_expertise_id) REFERENCES public.nature_expertise(id);


--
-- TOC entry 5457 (class 2606 OID 93899)
-- Name: chercheur fkbrkyxomqarvdc6oi4lnrnbm7a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chercheur
    ADD CONSTRAINT fkbrkyxomqarvdc6oi4lnrnbm7a FOREIGN KEY (commission_scientifique_id) REFERENCES public.commission_scientifique(id);


--
-- TOC entry 5572 (class 2606 OID 93904)
-- Name: distinction fkbs4au7ecqyccexqpegrltojnm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.distinction
    ADD CONSTRAINT fkbs4au7ecqyccexqpegrltojnm FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5566 (class 2606 OID 93909)
-- Name: discipline_scientifique_evenement_colloque_scientifique fkbsp2o2j831ikf57e6ywu2swy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_evenement_colloque_scientifique
    ADD CONSTRAINT fkbsp2o2j831ikf57e6ywu2swy FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5596 (class 2606 OID 93914)
-- Name: encadrement_etudiant fkbt4bu921wfefr06tmjp6rrng6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_etudiant
    ADD CONSTRAINT fkbt4bu921wfefr06tmjp6rrng6 FOREIGN KEY (etudiant_id) REFERENCES public.etudiant(id);


--
-- TOC entry 5933 (class 2606 OID 93919)
-- Name: zone_geographique_formation_continue fkbx0wwktixgo1vgiy6g6ueaj32; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_geographique_formation_continue
    ADD CONSTRAINT fkbx0wwktixgo1vgiy6g6ueaj32 FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5451 (class 2606 OID 93924)
-- Name: caracterisation_dev_de_savoir_et_innov fkc2iu2sop2moq9x9hkkl67th42; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracterisation_dev_de_savoir_et_innov
    ADD CONSTRAINT fkc2iu2sop2moq9x9hkkl67th42 FOREIGN KEY (developpement_de_savoir_et_innovation_scientifique_id) REFERENCES public.developpement_de_savoir_et_innovation_scientifique(id);


--
-- TOC entry 5579 (class 2606 OID 93929)
-- Name: doctorant fkc4i16yjeo2i5x7li947qm2qvd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.doctorant
    ADD CONSTRAINT fkc4i16yjeo2i5x7li947qm2qvd FOREIGN KEY (sexe_id) REFERENCES public.sexe(id);


--
-- TOC entry 5551 (class 2606 OID 93934)
-- Name: discipline_scientifique_conseils_scientifique fkc571bibmon8h77gxjjytiyxr0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_conseils_scientifique
    ADD CONSTRAINT fkc571bibmon8h77gxjjytiyxr0 FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5869 (class 2606 OID 93939)
-- Name: responsabilite_pedagogique_etablissement fkc5gc28fufqwv1owlmn7pju0w5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_etablissement
    ADD CONSTRAINT fkc5gc28fufqwv1owlmn7pju0w5 FOREIGN KEY (responsabilite_pedagogique_id) REFERENCES public.responsabilite_pedagogique(id);


--
-- TOC entry 5861 (class 2606 OID 93944)
-- Name: responsabilite_pedagogique_ecole_doctorale fkc7vvmt2o45modxcx6uw2txqia; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_ecole_doctorale
    ADD CONSTRAINT fkc7vvmt2o45modxcx6uw2txqia FOREIGN KEY (ecole_doctorale_id) REFERENCES public.ecole_doctorale(id);


--
-- TOC entry 5458 (class 2606 OID 93949)
-- Name: chercheur fkc8bw361c0l7fjw29ypdl035n8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chercheur
    ADD CONSTRAINT fkc8bw361c0l7fjw29ypdl035n8 FOREIGN KEY (ville_id) REFERENCES public.ville(id);


--
-- TOC entry 5821 (class 2606 OID 93954)
-- Name: public_cible_culture_scientifique_outil_pedagogique fkcdldr9snix7wyx2ypj7ap2tle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_cible_culture_scientifique_outil_pedagogique
    ADD CONSTRAINT fkcdldr9snix7wyx2ypj7ap2tle FOREIGN KEY (culture_scientifique_outil_pedagogique_id) REFERENCES public.culture_scientifique_outil_pedagogique(id);


--
-- TOC entry 5734 (class 2606 OID 93959)
-- Name: key_word_discipline_scientifique_erc fkcf9e0ef0dnl80hi8vjkfscsvp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_word_discipline_scientifique_erc
    ADD CONSTRAINT fkcf9e0ef0dnl80hi8vjkfscsvp FOREIGN KEY (discipline_scientifique_erc_id) REFERENCES public.discipline_scientifique_erc(id);


--
-- TOC entry 5459 (class 2606 OID 93964)
-- Name: chercheur fkch81ias64h7o2c2rp4wu5vp0w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chercheur
    ADD CONSTRAINT fkch81ias64h7o2c2rp4wu5vp0w FOREIGN KEY (type_entite_administrative_id) REFERENCES public.type_entite_administrative(id);


--
-- TOC entry 5904 (class 2606 OID 93969)
-- Name: type_savoir_developpement_de_savoir_et_innovation_scientifique fkchjpqv9o6shvkfr5iylrgayqe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_savoir_developpement_de_savoir_et_innovation_scientifique
    ADD CONSTRAINT fkchjpqv9o6shvkfr5iylrgayqe FOREIGN KEY (type_savoir_id) REFERENCES public.type_savoir(id);


--
-- TOC entry 5903 (class 2606 OID 93974)
-- Name: type_publique_rencontre_media fkclwguauy4pat6nk40frxuv4r7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_publique_rencontre_media
    ADD CONSTRAINT fkclwguauy4pat6nk40frxuv4r7 FOREIGN KEY (rencontre_media_id) REFERENCES public.rencontre_media(id);


--
-- TOC entry 5580 (class 2606 OID 93979)
-- Name: domaine_scientifique_chercheur fkclyvuxqridku58kunaou7bn6h; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.domaine_scientifique_chercheur
    ADD CONSTRAINT fkclyvuxqridku58kunaou7bn6h FOREIGN KEY (domaine_scientifique_id) REFERENCES public.domaine_scientifique(id);


--
-- TOC entry 5692 (class 2606 OID 93984)
-- Name: formation_continue fkcm2oc6ch3kfvonj06mametse6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue
    ADD CONSTRAINT fkcm2oc6ch3kfvonj06mametse6 FOREIGN KEY (outil_formation_continue_id) REFERENCES public.outil_formation_continue(id);


--
-- TOC entry 5658 (class 2606 OID 93989)
-- Name: etudiant fkcmrg5rb1j2lgg72dw37p31cmi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etudiant
    ADD CONSTRAINT fkcmrg5rb1j2lgg72dw37p31cmi FOREIGN KEY (sexe_id) REFERENCES public.sexe(id);


--
-- TOC entry 5751 (class 2606 OID 93994)
-- Name: objet_global_de_formation_continue fkcn2at2kb1mfddduw2gxcuyawm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.objet_global_de_formation_continue
    ADD CONSTRAINT fkcn2at2kb1mfddduw2gxcuyawm FOREIGN KEY (formation_continue_id) REFERENCES public.formation_continue(id);


--
-- TOC entry 5674 (class 2606 OID 93999)
-- Name: evenement_colloque_scienntifique_pays fkcnpx5iwkyhw6rqk1q38puxbsp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement_colloque_scienntifique_pays
    ADD CONSTRAINT fkcnpx5iwkyhw6rqk1q38puxbsp FOREIGN KEY (evenement_colloque_scienntifique_id) REFERENCES public.evenement_colloque_scienntifique(id);


--
-- TOC entry 5820 (class 2606 OID 94004)
-- Name: projet_activite_recherche_detail_pays fkcoy5frsswvkwqs8ei68bmp3w3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_pays
    ADD CONSTRAINT fkcoy5frsswvkwqs8ei68bmp3w3 FOREIGN KEY (projet_activite_recherche_detail_id) REFERENCES public.projet_activite_recherche_detail(id);


--
-- TOC entry 5910 (class 2606 OID 94009)
-- Name: vie_institutionnelle fkcth0baweb2dii9lly0mg6p8ir; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vie_institutionnelle
    ADD CONSTRAINT fkcth0baweb2dii9lly0mg6p8ir FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5686 (class 2606 OID 94014)
-- Name: faq fkcti11wirn97fe0ece9xxkfrs3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.faq
    ADD CONSTRAINT fkcti11wirn97fe0ece9xxkfrs3 FOREIGN KEY (categorie_faq_id) REFERENCES public.categorie_faq(id);


--
-- TOC entry 5770 (class 2606 OID 94019)
-- Name: outil_pedagogique_public_cible fkcwmhm9ic08xp8py9a2o5w63ps; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_public_cible
    ADD CONSTRAINT fkcwmhm9ic08xp8py9a2o5w63ps FOREIGN KEY (outil_pedagogique_id) REFERENCES public.outil_pedagogique(id);


--
-- TOC entry 5760 (class 2606 OID 94024)
-- Name: outil_pedagogique_enjeux_ird fkd1l5pdwhowl12wert9jox15cy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_enjeux_ird
    ADD CONSTRAINT fkd1l5pdwhowl12wert9jox15cy FOREIGN KEY (outil_pedagogique_id) REFERENCES public.outil_pedagogique(id);


--
-- TOC entry 5828 (class 2606 OID 94029)
-- Name: publique_cible_rencontre_grand_publique_jeune_publique fkd2etsktuhxtb4oeytpo28ld13; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publique_cible_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fkd2etsktuhxtb4oeytpo28ld13 FOREIGN KEY (publique_cible_rencontre_id) REFERENCES public.publique_cible_rencontre(id);


--
-- TOC entry 5645 (class 2606 OID 94034)
-- Name: etablissement_culture_scientifique_recontre_grand_public_jeune_ fkd3kt6fiu35tqu14byyg93re1h; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_culture_scientifique_recontre_grand_public_jeune_
    ADD CONSTRAINT fkd3kt6fiu35tqu14byyg93re1h FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5460 (class 2606 OID 94039)
-- Name: chercheur fkd635bkcx7daly57e5k19tm1x1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chercheur
    ADD CONSTRAINT fkd635bkcx7daly57e5k19tm1x1 FOREIGN KEY (corps_id) REFERENCES public.corps(id);


--
-- TOC entry 5693 (class 2606 OID 94044)
-- Name: formation_continue fkd6x5tlg1fwstw4t39g2irek7g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue
    ADD CONSTRAINT fkd6x5tlg1fwstw4t39g2irek7g FOREIGN KEY (enseignement_et_formation_id) REFERENCES public.enseignement_et_formation(id);


--
-- TOC entry 5741 (class 2606 OID 94049)
-- Name: mode_diffusion_developpement_de_savoir_et_innovation_scientifiq fkd8s61smk4ngvecbo3um54g2dr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mode_diffusion_developpement_de_savoir_et_innovation_scientifiq
    ADD CONSTRAINT fkd8s61smk4ngvecbo3um54g2dr FOREIGN KEY (developpement_de_savoir_et_innovation_scientifique_id) REFERENCES public.dev_savoir_innov_scientifique(id);


--
-- TOC entry 5805 (class 2606 OID 94054)
-- Name: projet_activite_recherche_detail fkd9x52s1fd4buupo4gadlja27v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail
    ADD CONSTRAINT fkd9x52s1fd4buupo4gadlja27v FOREIGN KEY (projet_activite_recherche_id) REFERENCES public.projet_activite_recherche(id);


--
-- TOC entry 5777 (class 2606 OID 94059)
-- Name: pays fkdd9p98vkaf6labqqhuo4nkxkv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays
    ADD CONSTRAINT fkdd9p98vkaf6labqqhuo4nkxkv FOREIGN KEY (continent_id) REFERENCES public.continent(id);


--
-- TOC entry 5447 (class 2606 OID 94064)
-- Name: campagne_relance fkdefve3as1xv5jqkrs16o5jc5g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_relance
    ADD CONSTRAINT fkdefve3as1xv5jqkrs16o5jc5g FOREIGN KEY (template_relance_id) REFERENCES public.template_relance(id);


--
-- TOC entry 5552 (class 2606 OID 94069)
-- Name: discipline_scientifique_consultance_scientifique_ponctuelle fkdfigeh3bjmwyisnduq74ia0h0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_consultance_scientifique_ponctuelle
    ADD CONSTRAINT fkdfigeh3bjmwyisnduq74ia0h0 FOREIGN KEY (consultance_scientifique_ponctuelle_id) REFERENCES public.consultance_scientifique_ponctuelle(id);


--
-- TOC entry 5466 (class 2606 OID 94074)
-- Name: comite_et_commission_evaluation fkdgw4d1236td13nhcjs0e4o2bk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comite_et_commission_evaluation
    ADD CONSTRAINT fkdgw4d1236td13nhcjs0e4o2bk FOREIGN KEY (nature_expertise_id) REFERENCES public.nature_expertise(id);


--
-- TOC entry 5785 (class 2606 OID 94079)
-- Name: pays_encadrement_etudiant fkdkebrffykyb7iibiebpj2v81j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_encadrement_etudiant
    ADD CONSTRAINT fkdkebrffykyb7iibiebpj2v81j FOREIGN KEY (encadrement_etudiant_id) REFERENCES public.encadrement_etudiant(id);


--
-- TOC entry 5840 (class 2606 OID 94084)
-- Name: rencontre_grand_publique_jeune_publique_discipline fkdkfoa9s67bj4mfu8imlu65qmf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique_discipline
    ADD CONSTRAINT fkdkfoa9s67bj4mfu8imlu65qmf FOREIGN KEY (rencontre_grand_publique_jeune_publique_id) REFERENCES public.rencontre_grand_publique_jeune_publique(id);


--
-- TOC entry 5445 (class 2606 OID 94089)
-- Name: campagne_rappel_chercheur fkdlbhdc0ok352c01wre2tpwbnj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_rappel_chercheur
    ADD CONSTRAINT fkdlbhdc0ok352c01wre2tpwbnj FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5928 (class 2606 OID 94094)
-- Name: zone_geographique_consultance_scientifique_ponctuelle fkdlmpme0be0r7fbg2d259p847h; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_geographique_consultance_scientifique_ponctuelle
    ADD CONSTRAINT fkdlmpme0be0r7fbg2d259p847h FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5681 (class 2606 OID 94099)
-- Name: expertise_scientifique fkdntd9h1uurimubptcr3rxtbcf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expertise_scientifique
    ADD CONSTRAINT fkdntd9h1uurimubptcr3rxtbcf FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5530 (class 2606 OID 94104)
-- Name: dev_savoir_innov_scientifique_pays fkdsrujbepj8fnsjkg8qcxadmxp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_pays
    ADD CONSTRAINT fkdsrujbepj8fnsjkg8qcxadmxp FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5501 (class 2606 OID 94109)
-- Name: contexte_rencontre_grand_publique_jeune_publique fkducewy7wd9390xjcgbq379ydq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contexte_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fkducewy7wd9390xjcgbq379ydq FOREIGN KEY (rencontre_grand_publique_jeune_publique_id) REFERENCES public.rencontre_grand_publique_jeune_publique(id);


--
-- TOC entry 5453 (class 2606 OID 94114)
-- Name: caracterisation_developpement_de_savoir_et_innovation_scientifi fkdwlsqjkdibryvqvnujvggbq86; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracterisation_developpement_de_savoir_et_innovation_scientifi
    ADD CONSTRAINT fkdwlsqjkdibryvqvnujvggbq86 FOREIGN KEY (developpement_de_savoir_et_innovation_scientifique_id) REFERENCES public.dev_savoir_innov_scientifique(id);


--
-- TOC entry 5565 (class 2606 OID 94119)
-- Name: discipline_scientifique_evaluation_recherche_universitaire fkdxlsn8orn1cdjbx21wsomr6jn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_evaluation_recherche_universitaire
    ADD CONSTRAINT fkdxlsn8orn1cdjbx21wsomr6jn FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5809 (class 2606 OID 94124)
-- Name: projet_activite_recherche_detail_enjeux_ird fkdyl9cutkhpy7c4fuukkuinc21; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_enjeux_ird
    ADD CONSTRAINT fkdyl9cutkhpy7c4fuukkuinc21 FOREIGN KEY (enjeux_ird_id) REFERENCES public.enjeux_ird(id);


--
-- TOC entry 5926 (class 2606 OID 94129)
-- Name: zone_geographique_conseils_scientifique fkdyq7hbpyc8fblwv0h0clj280g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_geographique_conseils_scientifique
    ADD CONSTRAINT fkdyq7hbpyc8fblwv0h0clj280g FOREIGN KEY (conseils_scientifique_id) REFERENCES public.conseils_scientifique(id);


--
-- TOC entry 5597 (class 2606 OID 94134)
-- Name: encadrement_etudiant fke0ra9hustgrquall7hy0kh7vn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_etudiant
    ADD CONSTRAINT fke0ra9hustgrquall7hy0kh7vn FOREIGN KEY (responsabilite_encadrement_etudiant_id) REFERENCES public.responsabilite_encadrement_etudiant(id);


--
-- TOC entry 5736 (class 2606 OID 94139)
-- Name: master fke253qac6j6px178e7mngms4pd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.master
    ADD CONSTRAINT fke253qac6j6px178e7mngms4pd FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5518 (class 2606 OID 94144)
-- Name: dev_savoir_innov_scientifique fke9814flmye56faojtclaovfih; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique
    ADD CONSTRAINT fke9814flmye56faojtclaovfih FOREIGN KEY (savoir_et_innovation_id) REFERENCES public.savoir_et_innovation(id);


--
-- TOC entry 5647 (class 2606 OID 94149)
-- Name: etablissement_encadrement_doctorant fke9k7oe9rtof6o76m83ip8d6n1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_encadrement_doctorant
    ADD CONSTRAINT fke9k7oe9rtof6o76m83ip8d6n1 FOREIGN KEY (encadrement_doctorant_id) REFERENCES public.encadrement_doctorant(id);


--
-- TOC entry 5697 (class 2606 OID 94154)
-- Name: formation_continue_commanditaire fkeauccydhybd16c5o6jxna2rqr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue_commanditaire
    ADD CONSTRAINT fkeauccydhybd16c5o6jxna2rqr FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5573 (class 2606 OID 94159)
-- Name: distinction fkedbldcdj0yyywg23jdt7issa3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.distinction
    ADD CONSTRAINT fkedbldcdj0yyywg23jdt7issa3 FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5516 (class 2606 OID 94164)
-- Name: culture_scientifique_recontre_grand_public_jeune_public fkefgloifbqffr2si6vuksj1apy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.culture_scientifique_recontre_grand_public_jeune_public
    ADD CONSTRAINT fkefgloifbqffr2si6vuksj1apy FOREIGN KEY (format_rencontre_id) REFERENCES public.format_rencontre(id);


--
-- TOC entry 5574 (class 2606 OID 94169)
-- Name: distinction fkefwct8pavrpk9r1heurmmy2jp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.distinction
    ADD CONSTRAINT fkefwct8pavrpk9r1heurmmy2jp FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5660 (class 2606 OID 94174)
-- Name: evaluation_recherche_universitaire fkeg5pkh1irii5li4dfhb1pnrxa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation_recherche_universitaire
    ADD CONSTRAINT fkeg5pkh1irii5li4dfhb1pnrxa FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5880 (class 2606 OID 94179)
-- Name: role_comite_et_commission_evaluation fkehtmyqdweygcq54g52v8wfi4r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_comite_et_commission_evaluation
    ADD CONSTRAINT fkehtmyqdweygcq54g52v8wfi4r FOREIGN KEY (comite_et_commission_evaluation_id) REFERENCES public.comite_et_commission_evaluation(id);


--
-- TOC entry 5896 (class 2606 OID 94184)
-- Name: type_outil_culture_scientifique_outil_pedagogique fkep1ed46guyy808muehsgor781; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_outil_culture_scientifique_outil_pedagogique
    ADD CONSTRAINT fkep1ed46guyy808muehsgor781 FOREIGN KEY (type_outil_id) REFERENCES public.type_outil(id);


--
-- TOC entry 5742 (class 2606 OID 94189)
-- Name: nature_enseignement fkeq7evxuywlub82saccbqwqkdl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nature_enseignement
    ADD CONSTRAINT fkeq7evxuywlub82saccbqwqkdl FOREIGN KEY (enseignement_id) REFERENCES public.enseignement(id);


--
-- TOC entry 5481 (class 2606 OID 94194)
-- Name: communaute_savoir_evenement_colloque_scientifique fkeqp1qpqkfhd797l54exx5ork0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_evenement_colloque_scientifique
    ADD CONSTRAINT fkeqp1qpqkfhd797l54exx5ork0 FOREIGN KEY (evenement_colloque_scienntifique_id) REFERENCES public.evenement_colloque_scienntifique(id);


--
-- TOC entry 5870 (class 2606 OID 94199)
-- Name: responsabilite_pedagogique_etablissement fkex78xdhii8gw55f4hm96v4pet; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_etablissement
    ADD CONSTRAINT fkex78xdhii8gw55f4hm96v4pet FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5544 (class 2606 OID 94204)
-- Name: discipline_scientifique_chercheur fkexnd1646vstge1qce6nwgtqbk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_chercheur
    ADD CONSTRAINT fkexnd1646vstge1qce6nwgtqbk FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5884 (class 2606 OID 94209)
-- Name: savoir_et_innovation fkf525g3go6efqvkiqxxpvfevw6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.savoir_et_innovation
    ADD CONSTRAINT fkf525g3go6efqvkiqxxpvfevw6 FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5503 (class 2606 OID 94214)
-- Name: contrat_et_convention_ird fkf775oqanig9coucn19lxjjdju; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contrat_et_convention_ird
    ADD CONSTRAINT fkf775oqanig9coucn19lxjjdju FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5636 (class 2606 OID 94219)
-- Name: etablissement fkfa96yw47t1er9vusleq92lsin; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement
    ADD CONSTRAINT fkfa96yw47t1er9vusleq92lsin FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5862 (class 2606 OID 94224)
-- Name: responsabilite_pedagogique_ecole_doctorale fkfapkqx1tx7vfexauklu6uf7qu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_ecole_doctorale
    ADD CONSTRAINT fkfapkqx1tx7vfexauklu6uf7qu FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5637 (class 2606 OID 94229)
-- Name: etablissement_comite_et_commission_evaluation fkff765dw9pmnnlmugsrdb19qdb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_comite_et_commission_evaluation
    ADD CONSTRAINT fkff765dw9pmnnlmugsrdb19qdb FOREIGN KEY (comite_et_commission_evaluation_id) REFERENCES public.comite_et_commission_evaluation(id);


--
-- TOC entry 5836 (class 2606 OID 94234)
-- Name: rencontre_grand_publique_jeune_publique fkfim4it7wnp28gf9irxq4novuu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fkfim4it7wnp28gf9irxq4novuu FOREIGN KEY (culture_scientifique_id) REFERENCES public.culture_scientifique(id);


--
-- TOC entry 5590 (class 2606 OID 94239)
-- Name: encadrement_doctorant fkfji8qnhiv90ct9rsq6rjmp6t4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_doctorant
    ADD CONSTRAINT fkfji8qnhiv90ct9rsq6rjmp6t4 FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5504 (class 2606 OID 94244)
-- Name: contrat_et_convention_ird fkfng9myvskwj0nne2mseq21p6e; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contrat_et_convention_ird
    ADD CONSTRAINT fkfng9myvskwj0nne2mseq21p6e FOREIGN KEY (savoir_et_innovation_id) REFERENCES public.savoir_et_innovation(id);


--
-- TOC entry 5908 (class 2606 OID 94249)
-- Name: type_utilisateur_savoir_concu fkfrkws38do4e2y7lr59idt3ss2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_utilisateur_savoir_concu
    ADD CONSTRAINT fkfrkws38do4e2y7lr59idt3ss2 FOREIGN KEY (type_utilisateur_id) REFERENCES public.type_utilisateur(id);


--
-- TOC entry 5829 (class 2606 OID 94254)
-- Name: publique_principal_conceme_formation_continue fkfsb4x8s9v5uknhbwbs77yxpyv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publique_principal_conceme_formation_continue
    ADD CONSTRAINT fkfsb4x8s9v5uknhbwbs77yxpyv FOREIGN KEY (publique_principal_id) REFERENCES public.publique_principal(id);


--
-- TOC entry 5493 (class 2606 OID 94259)
-- Name: conseils_scientifique fkfsrmjwqicdh6jv1n7565pmbym; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.conseils_scientifique
    ADD CONSTRAINT fkfsrmjwqicdh6jv1n7565pmbym FOREIGN KEY (type_expertise_id) REFERENCES public.type_expertise(id);


--
-- TOC entry 5900 (class 2606 OID 94264)
-- Name: type_publique_rencontre_grand_publique_jeune_publique fkfu7mfwdge4a03u2wf67xix164; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_publique_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fkfu7mfwdge4a03u2wf67xix164 FOREIGN KEY (type_publique_id) REFERENCES public.type_publique(id);


--
-- TOC entry 5885 (class 2606 OID 94269)
-- Name: savoir_et_innovation fkg3rc2rc6y9gi38hola4pr4aw3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.savoir_et_innovation
    ADD CONSTRAINT fkg3rc2rc6y9gi38hola4pr4aw3 FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5888 (class 2606 OID 94274)
-- Name: type_etude_enseignement fkg6cthqjo6bmlwoqwyppqtg44w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_etude_enseignement
    ADD CONSTRAINT fkg6cthqjo6bmlwoqwyppqtg44w FOREIGN KEY (type_etude_id) REFERENCES public.type_etude(id);


--
-- TOC entry 5854 (class 2606 OID 94279)
-- Name: rencontre_media_enjeux_ird fkg8k5k8s3sykxrc42blkfgkfyf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_media_enjeux_ird
    ADD CONSTRAINT fkg8k5k8s3sykxrc42blkfgkfyf FOREIGN KEY (enjeux_ird_id) REFERENCES public.enjeux_ird(id);


--
-- TOC entry 5866 (class 2606 OID 94284)
-- Name: responsabilite_pedagogique_enjeux_ird fkgg1hwdvadtudsp59ndb3npegb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_enjeux_ird
    ADD CONSTRAINT fkgg1hwdvadtudsp59ndb3npegb FOREIGN KEY (responsabilite_pedagogique_id) REFERENCES public.responsabilite_pedagogique(id);


--
-- TOC entry 5640 (class 2606 OID 94289)
-- Name: etablissement_conseils_scientifique fkgjn05oueu8jnelp1xhfx9drja; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_conseils_scientifique
    ADD CONSTRAINT fkgjn05oueu8jnelp1xhfx9drja FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5726 (class 2606 OID 94294)
-- Name: instrument_ird_consultance_scientifique_ponctuelle fkgkgi4htkjieqna587cbwdjf9f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instrument_ird_consultance_scientifique_ponctuelle
    ADD CONSTRAINT fkgkgi4htkjieqna587cbwdjf9f FOREIGN KEY (consultance_scientifique_ponctuelle_id) REFERENCES public.consultance_scientifique_ponctuelle(id);


--
-- TOC entry 5532 (class 2606 OID 94299)
-- Name: dev_savoir_innov_scientifique_role fkgl2wg4m74y1bo1n3orrmngfqa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_role
    ADD CONSTRAINT fkgl2wg4m74y1bo1n3orrmngfqa FOREIGN KEY (developpement_de_savoir_et_innovation_scientifique_id) REFERENCES public.dev_savoir_innov_scientifique(id);


--
-- TOC entry 5471 (class 2606 OID 94304)
-- Name: communaute_savoir_chercheur fkgl6bonqlf3u6sq981ko85uq8y; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_chercheur
    ADD CONSTRAINT fkgl6bonqlf3u6sq981ko85uq8y FOREIGN KEY (communaute_savoir_id) REFERENCES public.communaute_savoir(id);


--
-- TOC entry 5461 (class 2606 OID 94309)
-- Name: chercheur fkglb8ely4itguml9o10xgqx25y; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chercheur
    ADD CONSTRAINT fkglb8ely4itguml9o10xgqx25y FOREIGN KEY (entite_administrative_id) REFERENCES public.entite_administrative(id);


--
-- TOC entry 5653 (class 2606 OID 94314)
-- Name: etablissement_projet fkguuf1d9mq38i2awy2n366c0h0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_projet
    ADD CONSTRAINT fkguuf1d9mq38i2awy2n366c0h0 FOREIGN KEY (ville_id) REFERENCES public.ville(id);


--
-- TOC entry 5475 (class 2606 OID 94319)
-- Name: communaute_savoir_encadrement_doctorant fkgxadsyi1opiu907ynfn947t0q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_encadrement_doctorant
    ADD CONSTRAINT fkgxadsyi1opiu907ynfn947t0q FOREIGN KEY (encadrement_doctorant_id) REFERENCES public.encadrement_doctorant(id);


--
-- TOC entry 5712 (class 2606 OID 94324)
-- Name: gestion_equipe_detail fkgyrcd284wiglmee18mihwa9s5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gestion_equipe_detail
    ADD CONSTRAINT fkgyrcd284wiglmee18mihwa9s5 FOREIGN KEY (gestion_equipe_id) REFERENCES public.gestion_equipe(id);


--
-- TOC entry 5446 (class 2606 OID 94329)
-- Name: campagne_rappel_chercheur fkh41bqirw7yv4vvlw465sp0ebx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_rappel_chercheur
    ADD CONSTRAINT fkh41bqirw7yv4vvlw465sp0ebx FOREIGN KEY (campagne_rappel_id) REFERENCES public.campagne_rappel(id);


--
-- TOC entry 5764 (class 2606 OID 94334)
-- Name: outil_pedagogique_langue fkh4ao7l0mmschkm3r73uy40tuk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_langue
    ADD CONSTRAINT fkh4ao7l0mmschkm3r73uy40tuk FOREIGN KEY (outil_pedagogique_id) REFERENCES public.outil_pedagogique(id);


--
-- TOC entry 5626 (class 2606 OID 94339)
-- Name: enseignement_et_formation fkh85adrq1yhi8spjjxrv3jfnn1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_et_formation
    ADD CONSTRAINT fkh85adrq1yhi8spjjxrv3jfnn1 FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5601 (class 2606 OID 94344)
-- Name: encadrement_etudiant_discipline_scientifique fkhc3almtcwkvodw9m9tjx97d22; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_etudiant_discipline_scientifique
    ADD CONSTRAINT fkhc3almtcwkvodw9m9tjx97d22 FOREIGN KEY (encadrement_etudiant_id) REFERENCES public.encadrement_etudiant(id);


--
-- TOC entry 5438 (class 2606 OID 94349)
-- Name: campagne_chercheur_fermeture fkhcmnquxa3r540sf0ftcwj2abv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_chercheur_fermeture
    ADD CONSTRAINT fkhcmnquxa3r540sf0ftcwj2abv FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5863 (class 2606 OID 94354)
-- Name: responsabilite_pedagogique_ecole_doctorale fkhdhwxgapap0ysymdmbgibn4fw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_ecole_doctorale
    ADD CONSTRAINT fkhdhwxgapap0ysymdmbgibn4fw FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5496 (class 2606 OID 94359)
-- Name: consultance_scientifique_ponctuelle fkhemfbo80ov3xy3qdisl9xko1v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultance_scientifique_ponctuelle
    ADD CONSTRAINT fkhemfbo80ov3xy3qdisl9xko1v FOREIGN KEY (nature_expertise_id) REFERENCES public.nature_expertise(id);


--
-- TOC entry 5661 (class 2606 OID 94364)
-- Name: evaluation_recherche_universitaire fkhh9h4byhfy3ofviaa0v9by66l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation_recherche_universitaire
    ADD CONSTRAINT fkhh9h4byhfy3ofviaa0v9by66l FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5894 (class 2606 OID 94369)
-- Name: type_instrument_ird_consultance_scientifique_ponctuelle fkhkpkd4tyajmvkfy4e79j1dw29; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_instrument_ird_consultance_scientifique_ponctuelle
    ADD CONSTRAINT fkhkpkd4tyajmvkfy4e79j1dw29 FOREIGN KEY (consultance_scientifique_ponctuelle_id) REFERENCES public.consultance_scientifique_ponctuelle(id);


--
-- TOC entry 5521 (class 2606 OID 94374)
-- Name: dev_savoir_innov_scientifique_discipline_scientifique fkhl50fsm3vxi1wfbeewo7hfdlr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_discipline_scientifique
    ADD CONSTRAINT fkhl50fsm3vxi1wfbeewo7hfdlr FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5915 (class 2606 OID 94379)
-- Name: vie_institutionnelle_detail fkhlc599w59yvsas2pghdhsb04m; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vie_institutionnelle_detail
    ADD CONSTRAINT fkhlc599w59yvsas2pghdhsb04m FOREIGN KEY (structure_ird_id) REFERENCES public.structure_ird(id);


--
-- TOC entry 5462 (class 2606 OID 94384)
-- Name: chercheur fkhsi3birx18x4v0m4gca5my9jn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chercheur
    ADD CONSTRAINT fkhsi3birx18x4v0m4gca5my9jn FOREIGN KEY (affectation_structurelle_id) REFERENCES public.affectation_structurelle(id);


--
-- TOC entry 5782 (class 2606 OID 94389)
-- Name: pays_encadrement_doctorant fkhug1ifhac5n6aqelnur1d4dfw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_encadrement_doctorant
    ADD CONSTRAINT fkhug1ifhac5n6aqelnur1d4dfw FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5837 (class 2606 OID 94394)
-- Name: rencontre_grand_publique_jeune_publique fkhw06iqpvy2uij1v0ntodvr8vm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fkhw06iqpvy2uij1v0ntodvr8vm FOREIGN KEY (contexte_id) REFERENCES public.contexte(id);


--
-- TOC entry 5581 (class 2606 OID 94399)
-- Name: domaine_scientifique_chercheur fkhw4fxtwb4uvw6atnjv9umh47s; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.domaine_scientifique_chercheur
    ADD CONSTRAINT fkhw4fxtwb4uvw6atnjv9umh47s FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5871 (class 2606 OID 94404)
-- Name: responsabilite_pedagogique_master fkhwclwqlb7vgslad5dwofxjdp7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_master
    ADD CONSTRAINT fkhwclwqlb7vgslad5dwofxjdp7 FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5487 (class 2606 OID 94409)
-- Name: conseil_et_comite_scientifique fkhwwc3ktvveu60fdb3k2iqyafp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.conseil_et_comite_scientifique
    ADD CONSTRAINT fkhwwc3ktvveu60fdb3k2iqyafp FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5822 (class 2606 OID 94414)
-- Name: public_cible_culture_scientifique_outil_pedagogique fkhxg07yasfn3tw5xl56y6eiv2k; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_cible_culture_scientifique_outil_pedagogique
    ADD CONSTRAINT fkhxg07yasfn3tw5xl56y6eiv2k FOREIGN KEY (public_cible_id) REFERENCES public.public_cible(id);


--
-- TOC entry 5473 (class 2606 OID 94419)
-- Name: communaute_savoir_conseil_et_comite_scientifique fkhxiopi1jak0m7ha3f5bvh842y; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_conseil_et_comite_scientifique
    ADD CONSTRAINT fkhxiopi1jak0m7ha3f5bvh842y FOREIGN KEY (communaute_savoir_id) REFERENCES public.communaute_savoir(id);


--
-- TOC entry 5620 (class 2606 OID 94424)
-- Name: enseignement fki1a10yrwi0nifav3pyfplo6du; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement
    ADD CONSTRAINT fki1a10yrwi0nifav3pyfplo6du FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5682 (class 2606 OID 94429)
-- Name: expertise_scientifique fki5n0ku8ixfj9kd2h5vh98p5jy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expertise_scientifique
    ADD CONSTRAINT fki5n0ku8ixfj9kd2h5vh98p5jy FOREIGN KEY (type_expertise_id) REFERENCES public.type_expertise(id);


--
-- TOC entry 5757 (class 2606 OID 94434)
-- Name: outil_pedagogique_discipline_scientifique fki7lyqvsi9eivam8ew10jommvx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_discipline_scientifique
    ADD CONSTRAINT fki7lyqvsi9eivam8ew10jommvx FOREIGN KEY (outil_pedagogique_id) REFERENCES public.outil_pedagogique(id);


--
-- TOC entry 5872 (class 2606 OID 94439)
-- Name: responsabilite_pedagogique_master fki8vx7tndgn4btk5imfhglyh65; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_master
    ADD CONSTRAINT fki8vx7tndgn4btk5imfhglyh65 FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5627 (class 2606 OID 94444)
-- Name: enseignement_et_formation fkia3v7tbk8wbqv25bjsv3eaj1e; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_et_formation
    ADD CONSTRAINT fkia3v7tbk8wbqv25bjsv3eaj1e FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5852 (class 2606 OID 94449)
-- Name: rencontre_media_discipline_scientifique fkib0icghvyjyeyhsbp1qo97bvc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_media_discipline_scientifique
    ADD CONSTRAINT fkib0icghvyjyeyhsbp1qo97bvc FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5768 (class 2606 OID 94454)
-- Name: outil_pedagogique_pays_diffusion fkic6y5m0y5kbaesp64djh7dpho; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_pays_diffusion
    ADD CONSTRAINT fkic6y5m0y5kbaesp64djh7dpho FOREIGN KEY (outil_pedagogique_id) REFERENCES public.outil_pedagogique(id);


--
-- TOC entry 5467 (class 2606 OID 94459)
-- Name: comite_et_commission_evaluation fkidk281ugp6jlgufuk6uuf9lgc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comite_et_commission_evaluation
    ADD CONSTRAINT fkidk281ugp6jlgufuk6uuf9lgc FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5569 (class 2606 OID 94464)
-- Name: discipline_scientifique_expertise_scientifique fkidqjqpw243tq00cfptguts967; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_expertise_scientifique
    ADD CONSTRAINT fkidqjqpw243tq00cfptguts967 FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5749 (class 2606 OID 94469)
-- Name: objet_formation_generique_de_responsabilite_pedagogique fkieptxo8bje3qyp481krnc59as; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.objet_formation_generique_de_responsabilite_pedagogique
    ADD CONSTRAINT fkieptxo8bje3qyp481krnc59as FOREIGN KEY (objet_formation_generique_id) REFERENCES public.objet_formation_generique(id);


--
-- TOC entry 5765 (class 2606 OID 94474)
-- Name: outil_pedagogique_pays_conception fkif3xkgfnxndd63w0y8rb1vohw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_pays_conception
    ADD CONSTRAINT fkif3xkgfnxndd63w0y8rb1vohw FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5507 (class 2606 OID 94479)
-- Name: contrat_et_convention_ird_partenaire fkif8jmmcib16sgbh5gjv2tdbe2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contrat_et_convention_ird_partenaire
    ADD CONSTRAINT fkif8jmmcib16sgbh5gjv2tdbe2 FOREIGN KEY (contrat_et_convention_ird_id) REFERENCES public.contrat_et_convention_ird(id);


--
-- TOC entry 5867 (class 2606 OID 94484)
-- Name: responsabilite_pedagogique_enjeux_ird fkifhvcpbtc1wayn08qcbqo5tob; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_enjeux_ird
    ADD CONSTRAINT fkifhvcpbtc1wayn08qcbqo5tob FOREIGN KEY (enjeux_ird_id) REFERENCES public.enjeux_ird(id);


--
-- TOC entry 5603 (class 2606 OID 94489)
-- Name: encadrement_etudiant_enjeux_ird fkig7eqiifnch3n4jy1g6wx0g0u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_etudiant_enjeux_ird
    ADD CONSTRAINT fkig7eqiifnch3n4jy1g6wx0g0u FOREIGN KEY (enjeux_ird_id) REFERENCES public.enjeux_ird(id);


--
-- TOC entry 5542 (class 2606 OID 94494)
-- Name: discipline_scientifique fkik12r73pj0wbtt4cd4j0smnw2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique
    ADD CONSTRAINT fkik12r73pj0wbtt4cd4j0smnw2 FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5762 (class 2606 OID 94499)
-- Name: outil_pedagogique_instrument_ird fkimb2jxp7sk97t94fjx667cdrb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_instrument_ird
    ADD CONSTRAINT fkimb2jxp7sk97t94fjx667cdrb FOREIGN KEY (outil_pedagogique_id) REFERENCES public.outil_pedagogique(id);


--
-- TOC entry 5431 (class 2606 OID 94504)
-- Name: bourse fkimvps0bccinvyvj2gdmnhxw4x; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bourse
    ADD CONSTRAINT fkimvps0bccinvyvj2gdmnhxw4x FOREIGN KEY (projet_activite_recherche_id) REFERENCES public.projet_activite_recherche(id);


--
-- TOC entry 5783 (class 2606 OID 94509)
-- Name: pays_encadrement_doctorant fkimypt1s4lcjxnc5w0757myud6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_encadrement_doctorant
    ADD CONSTRAINT fkimypt1s4lcjxnc5w0757myud6 FOREIGN KEY (encadrement_doctorant_id) REFERENCES public.encadrement_doctorant(id);


--
-- TOC entry 5701 (class 2606 OID 94514)
-- Name: formation_continue_discipline_scientifique fkinejf9qs4800ij2w09533wd8j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue_discipline_scientifique
    ADD CONSTRAINT fkinejf9qs4800ij2w09533wd8j FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5694 (class 2606 OID 94519)
-- Name: formation_continue fkirascqsbona5j7rrgrjg3oiw5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue
    ADD CONSTRAINT fkirascqsbona5j7rrgrjg3oiw5 FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5812 (class 2606 OID 94524)
-- Name: projet_activite_recherche_detail_etablissement_financeur fkisyyrjvc42ns6jx6qnrij2yu1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_etablissement_financeur
    ADD CONSTRAINT fkisyyrjvc42ns6jx6qnrij2yu1 FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5546 (class 2606 OID 94529)
-- Name: discipline_scientifique_comite_et_commission_evaluation fkitclf3365610qnf8x5vjsm440; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_comite_et_commission_evaluation
    ADD CONSTRAINT fkitclf3365610qnf8x5vjsm440 FOREIGN KEY (comite_et_commission_evaluation_id) REFERENCES public.comite_et_commission_evaluation(id);


--
-- TOC entry 5719 (class 2606 OID 94534)
-- Name: institution_co_contractant_projet_activite_recherche fkitytbwd7c0bww9r9ibn6xwjig; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.institution_co_contractant_projet_activite_recherche
    ADD CONSTRAINT fkitytbwd7c0bww9r9ibn6xwjig FOREIGN KEY (projet_activite_recherche_id) REFERENCES public.projet_activite_recherche(id);


--
-- TOC entry 5598 (class 2606 OID 94539)
-- Name: encadrement_etudiant fkiu95fv0hl54i5ygjrmo65pkyw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_etudiant
    ADD CONSTRAINT fkiu95fv0hl54i5ygjrmo65pkyw FOREIGN KEY (encadrement_id) REFERENCES public.encadrement(id);


--
-- TOC entry 5465 (class 2606 OID 94544)
-- Name: chercheur_email fkivwotf0yhjr211a9qlygiq247; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chercheur_email
    ADD CONSTRAINT fkivwotf0yhjr211a9qlygiq247 FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5488 (class 2606 OID 94549)
-- Name: conseil_et_comite_scientifique fkiwg2umyrere7ba7h8dd37f44f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.conseil_et_comite_scientifique
    ADD CONSTRAINT fkiwg2umyrere7ba7h8dd37f44f FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5668 (class 2606 OID 94554)
-- Name: evenement_colloque_scienntifique fkixuwnitsrgcv469tdqevuqlr1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement_colloque_scienntifique
    ADD CONSTRAINT fkixuwnitsrgcv469tdqevuqlr1 FOREIGN KEY (savoir_et_innovation_id) REFERENCES public.savoir_et_innovation(id);


--
-- TOC entry 5814 (class 2606 OID 94559)
-- Name: projet_activite_recherche_detail_etablissement_lanceur fkj44uq762l6v6wxqg06oit55jg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_etablissement_lanceur
    ADD CONSTRAINT fkj44uq762l6v6wxqg06oit55jg FOREIGN KEY (projet_activite_recherche_detail_id) REFERENCES public.projet_activite_recherche_detail(id);


--
-- TOC entry 5766 (class 2606 OID 94564)
-- Name: outil_pedagogique_pays_conception fkj565ndg3olae7w4qomen1w0op; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_pays_conception
    ADD CONSTRAINT fkj565ndg3olae7w4qomen1w0op FOREIGN KEY (outil_pedagogique_id) REFERENCES public.outil_pedagogique(id);


--
-- TOC entry 5779 (class 2606 OID 94569)
-- Name: pays_commanditaire fkj5bav85pec0xf82klesuxvan9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_commanditaire
    ADD CONSTRAINT fkj5bav85pec0xf82klesuxvan9 FOREIGN KEY (consultance_scientifique_ponctuelle_id) REFERENCES public.consultance_scientifique_ponctuelle(id);


--
-- TOC entry 5662 (class 2606 OID 94574)
-- Name: evaluation_recherche_universitaire fkjdeyval9f2k33u4ci85f9ohsy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation_recherche_universitaire
    ADD CONSTRAINT fkjdeyval9f2k33u4ci85f9ohsy FOREIGN KEY (role_evaluation_recherche_universitaire_id) REFERENCES public.role_evaluation_recherche_universitaire(id);


--
-- TOC entry 5786 (class 2606 OID 94579)
-- Name: pays_formation_continue fkjf4l4951mt5lncpivwyaowts7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_formation_continue
    ADD CONSTRAINT fkjf4l4951mt5lncpivwyaowts7 FOREIGN KEY (formation_continue_id) REFERENCES public.formation_continue(id);


--
-- TOC entry 5747 (class 2606 OID 94584)
-- Name: notification fkjgvoup8p0lavawg6fdan6v6x6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification
    ADD CONSTRAINT fkjgvoup8p0lavawg6fdan6v6x6 FOREIGN KEY (categorie_notification_id) REFERENCES public.categorie_notification(id);


--
-- TOC entry 5711 (class 2606 OID 94589)
-- Name: gestion_equipe fkjjrentghfqpbuk03oj7r8hmh8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gestion_equipe
    ADD CONSTRAINT fkjjrentghfqpbuk03oj7r8hmh8 FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5454 (class 2606 OID 94594)
-- Name: caracterisation_developpement_de_savoir_et_innovation_scientifi fkjoent2emy15j8uqf1engp3t1x; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracterisation_developpement_de_savoir_et_innovation_scientifi
    ADD CONSTRAINT fkjoent2emy15j8uqf1engp3t1x FOREIGN KEY (caracterisation_id) REFERENCES public.caracterisation(id);


--
-- TOC entry 5886 (class 2606 OID 94599)
-- Name: structure_oganisatrice fkjoln0acr9w683cfwnc6b5d1eb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.structure_oganisatrice
    ADD CONSTRAINT fkjoln0acr9w683cfwnc6b5d1eb FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5567 (class 2606 OID 94604)
-- Name: discipline_scientifique_evenement_colloque_scientifique fkjqogy0996qg8akhor3bfidavb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_evenement_colloque_scientifique
    ADD CONSTRAINT fkjqogy0996qg8akhor3bfidavb FOREIGN KEY (evenement_colloque_scienntifique_id) REFERENCES public.evenement_colloque_scienntifique(id);


--
-- TOC entry 5517 (class 2606 OID 94609)
-- Name: culture_scientifique_recontre_grand_public_jeune_public fkjujtotxqr2cv0lsvy9bwui7tq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.culture_scientifique_recontre_grand_public_jeune_public
    ADD CONSTRAINT fkjujtotxqr2cv0lsvy9bwui7tq FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5923 (class 2606 OID 94614)
-- Name: zone_activite_interaction_recherche fkjulrcxbh8u32lfydvvq6ws432; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_activite_interaction_recherche
    ADD CONSTRAINT fkjulrcxbh8u32lfydvvq6ws432 FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5463 (class 2606 OID 94619)
-- Name: chercheur fkjwhln718i50xkvvgeqx1vxmuk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chercheur
    ADD CONSTRAINT fkjwhln718i50xkvvgeqx1vxmuk FOREIGN KEY (grade_id) REFERENCES public.grade(id);


--
-- TOC entry 5890 (class 2606 OID 94624)
-- Name: type_expertise_evaluation_comite_et_commission_evaluation fkjx4hoexoj9x4ijqail298x5bo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_expertise_evaluation_comite_et_commission_evaluation
    ADD CONSTRAINT fkjx4hoexoj9x4ijqail298x5bo FOREIGN KEY (comite_et_commission_evaluation_id) REFERENCES public.comite_et_commission_evaluation(id);


--
-- TOC entry 5891 (class 2606 OID 94629)
-- Name: type_expertise_evaluation_comite_et_commission_evaluation fkjymepuifaqw1lfdxv9sj9535h; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_expertise_evaluation_comite_et_commission_evaluation
    ADD CONSTRAINT fkjymepuifaqw1lfdxv9sj9535h FOREIGN KEY (type_expertise_evaluation_id) REFERENCES public.type_expertise_evaluation(id);


--
-- TOC entry 5613 (class 2606 OID 94634)
-- Name: enjeux_ird_encadrement_doctorant fkk063pnquafwnx4p7kpvkwmrd6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enjeux_ird_encadrement_doctorant
    ADD CONSTRAINT fkk063pnquafwnx4p7kpvkwmrd6 FOREIGN KEY (encadrement_doctorant_id) REFERENCES public.encadrement_doctorant(id);


--
-- TOC entry 5705 (class 2606 OID 94639)
-- Name: formation_continue_objet_formation_generique fkk12iw31cmi4x5kefstpebigwn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue_objet_formation_generique
    ADD CONSTRAINT fkk12iw31cmi4x5kefstpebigwn FOREIGN KEY (objet_formation_generique_id) REFERENCES public.objet_formation_generique(id);


--
-- TOC entry 5525 (class 2606 OID 94644)
-- Name: dev_savoir_innov_scientifique_instrument_ird fkk2u88xshic730g9kdt9ngjjhr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_instrument_ird
    ADD CONSTRAINT fkk2u88xshic730g9kdt9ngjjhr FOREIGN KEY (instrument_ird_id) REFERENCES public.instrument_ird(id);


--
-- TOC entry 5817 (class 2606 OID 94649)
-- Name: projet_activite_recherche_detail_instrument_ird fkk3w6gg4dlrw19xpvd5c4ek1pq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_instrument_ird
    ADD CONSTRAINT fkk3w6gg4dlrw19xpvd5c4ek1pq FOREIGN KEY (projet_activite_recherche_detail_id) REFERENCES public.projet_activite_recherche_detail(id);


--
-- TOC entry 5728 (class 2606 OID 94654)
-- Name: instruments_et_dispositifs_ird fkk9h60gorvms2rm6reanhgires; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instruments_et_dispositifs_ird
    ADD CONSTRAINT fkk9h60gorvms2rm6reanhgires FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5793 (class 2606 OID 94659)
-- Name: pays_rencontre_grand_publique_jeune_publique fkka4mchqlugb9sdxf9svm6ie9b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fkka4mchqlugb9sdxf9svm6ie9b FOREIGN KEY (rencontre_grand_publique_jeune_publique_id) REFERENCES public.rencontre_grand_publique_jeune_publique(id);


--
-- TOC entry 5440 (class 2606 OID 94664)
-- Name: campagne_chercheur_ouverture fkkaabs3iywx37ipqrofd7hm57i; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_chercheur_ouverture
    ADD CONSTRAINT fkkaabs3iywx37ipqrofd7hm57i FOREIGN KEY (etat_campagne_chercheur_id) REFERENCES public.etat_campagne_chercheur(id);


--
-- TOC entry 5877 (class 2606 OID 94669)
-- Name: responsabilite_pedagogique_pays fkkbgavjymjb6m7v7erceohtror; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_pays
    ADD CONSTRAINT fkkbgavjymjb6m7v7erceohtror FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5644 (class 2606 OID 94674)
-- Name: etablissement_culture_scientifique_outil_pedagogique fkkd9kt14jvuylpq41mofoenrtu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_culture_scientifique_outil_pedagogique
    ADD CONSTRAINT fkkd9kt14jvuylpq41mofoenrtu FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5799 (class 2606 OID 94679)
-- Name: pays_zone_geographique fkkfeyecpnevld3g5x9h7xive06; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_zone_geographique
    ADD CONSTRAINT fkkfeyecpnevld3g5x9h7xive06 FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5733 (class 2606 OID 94684)
-- Name: instruments_et_dispositifs_ird_projet_activite_recherche fkkfyhm66jvf4va67san221jmt2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instruments_et_dispositifs_ird_projet_activite_recherche
    ADD CONSTRAINT fkkfyhm66jvf4va67san221jmt2 FOREIGN KEY (instruments_et_dispositifs_ird_id) REFERENCES public.instruments_et_dispositifs_ird(id);


--
-- TOC entry 5513 (class 2606 OID 94689)
-- Name: culture_scientifique_outil_pedagogique fkkijawijv38i26hifpa3hk1ehy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.culture_scientifique_outil_pedagogique
    ADD CONSTRAINT fkkijawijv38i26hifpa3hk1ehy FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5623 (class 2606 OID 94694)
-- Name: enseignement_discipline_scientifique fkknqetpcd13dqv4bg4jowx7wae; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_discipline_scientifique
    ADD CONSTRAINT fkknqetpcd13dqv4bg4jowx7wae FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5479 (class 2606 OID 94699)
-- Name: communaute_savoir_evaluation_recherche_universitaire fkkpaph624pw47o5rqyddv8n3re; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_evaluation_recherche_universitaire
    ADD CONSTRAINT fkkpaph624pw47o5rqyddv8n3re FOREIGN KEY (evaluation_recherche_universitaire_id) REFERENCES public.evaluation_recherche_universitaire(id);


--
-- TOC entry 5916 (class 2606 OID 94704)
-- Name: vie_institutionnelle_detail fkkpdyw8lgoi2efgwkqx9axm7mg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vie_institutionnelle_detail
    ADD CONSTRAINT fkkpdyw8lgoi2efgwkqx9axm7mg FOREIGN KEY (vie_institutionnelle_id) REFERENCES public.vie_institutionnelle(id);


--
-- TOC entry 5745 (class 2606 OID 94709)
-- Name: niveau_etude_enseignement fkkuwur67xas80pcfywastjlq9s; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.niveau_etude_enseignement
    ADD CONSTRAINT fkkuwur67xas80pcfywastjlq9s FOREIGN KEY (enseignement_id) REFERENCES public.enseignement(id);


--
-- TOC entry 5911 (class 2606 OID 94714)
-- Name: vie_institutionnelle fkkuydl1c2nw42gvdfseu3r38x1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vie_institutionnelle
    ADD CONSTRAINT fkkuydl1c2nw42gvdfseu3r38x1 FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5519 (class 2606 OID 94719)
-- Name: dev_savoir_innov_scientifique fkkv0ufgmlon6bvaqucp68jjpde; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique
    ADD CONSTRAINT fkkv0ufgmlon6bvaqucp68jjpde FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5929 (class 2606 OID 94724)
-- Name: zone_geographique_consultance_scientifique_ponctuelle fkkwhab82r0v9plswcrb5vqm16b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_geographique_consultance_scientifique_ponctuelle
    ADD CONSTRAINT fkkwhab82r0v9plswcrb5vqm16b FOREIGN KEY (zone_geographique_id) REFERENCES public.zone_geographique(id);


--
-- TOC entry 5873 (class 2606 OID 94729)
-- Name: responsabilite_pedagogique_master fkkwip4but83ff8qrhuji79u30o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_master
    ADD CONSTRAINT fkkwip4but83ff8qrhuji79u30o FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5528 (class 2606 OID 94734)
-- Name: dev_savoir_innov_scientifique_mode_diffusion fkl4f4unllnp4p28uf1ax4u2aii; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_mode_diffusion
    ADD CONSTRAINT fkl4f4unllnp4p28uf1ax4u2aii FOREIGN KEY (mode_diffusion_id) REFERENCES public.mode_diffusion(id);


--
-- TOC entry 5864 (class 2606 OID 94739)
-- Name: responsabilite_pedagogique_ecole_doctorale fkl8qogcmanlgjkhbnxsxv7y7qp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_ecole_doctorale
    ADD CONSTRAINT fkl8qogcmanlgjkhbnxsxv7y7qp FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5591 (class 2606 OID 94744)
-- Name: encadrement_doctorant fkl965rqo1ma0hyoufivhup5siw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_doctorant
    ADD CONSTRAINT fkl965rqo1ma0hyoufivhup5siw FOREIGN KEY (responsabilite_encadrement_doctorant_id) REFERENCES public.responsabilite_encadrement_doctorant(id);


--
-- TOC entry 5448 (class 2606 OID 94749)
-- Name: campagne_relance fklit31hnc1h0bwopx04pewi78m; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_relance
    ADD CONSTRAINT fklit31hnc1h0bwopx04pewi78m FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5725 (class 2606 OID 94754)
-- Name: instrument_ird_comite_et_commission_evaluation fklshei0gt3fbiobpb3rxgy7r8x; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instrument_ird_comite_et_commission_evaluation
    ADD CONSTRAINT fklshei0gt3fbiobpb3rxgy7r8x FOREIGN KEY (type_instrument_ird_id) REFERENCES public.type_instrument_ird(id);


--
-- TOC entry 5865 (class 2606 OID 94759)
-- Name: responsabilite_pedagogique_ecole_doctorale fkltcsqje3n5s2quj2r9op0b75m; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_ecole_doctorale
    ADD CONSTRAINT fkltcsqje3n5s2quj2r9op0b75m FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5485 (class 2606 OID 94764)
-- Name: communaute_savoir_projet_activite_recherche fkluonfopl6d5uqjx75a2vnl9f3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_projet_activite_recherche
    ADD CONSTRAINT fkluonfopl6d5uqjx75a2vnl9f3 FOREIGN KEY (projet_activite_recherche_id) REFERENCES public.projet_activite_recherche(id);


--
-- TOC entry 5738 (class 2606 OID 94769)
-- Name: modalite_etude_enseignement fklvvw0h4smik4plams8y0ywkp0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modalite_etude_enseignement
    ADD CONSTRAINT fklvvw0h4smik4plams8y0ywkp0 FOREIGN KEY (modalite_etude_id) REFERENCES public.modalite_etude(id);


--
-- TOC entry 5638 (class 2606 OID 94774)
-- Name: etablissement_comite_et_commission_evaluation fklw6nk9wn9q2fh1lwcc10ynoca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_comite_et_commission_evaluation
    ADD CONSTRAINT fklw6nk9wn9q2fh1lwcc10ynoca FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5775 (class 2606 OID 94779)
-- Name: outil_pedagogique_type_instrument_ird fkly3m0ujl7n0xcjnidh7m4555a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_type_instrument_ird
    ADD CONSTRAINT fkly3m0ujl7n0xcjnidh7m4555a FOREIGN KEY (type_instrument_ird_id) REFERENCES public.type_instrument_ird(id);


--
-- TOC entry 5717 (class 2606 OID 94784)
-- Name: institution_co_contractant fkm06m5vo91ji603dyyara3jvux; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.institution_co_contractant
    ADD CONSTRAINT fkm06m5vo91ji603dyyara3jvux FOREIGN KEY (institution_id) REFERENCES public.institution(id);


--
-- TOC entry 5614 (class 2606 OID 94789)
-- Name: enjeux_ird_encadrement_doctorant fkm270vkwsvpkgm4ouv90fpenje; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enjeux_ird_encadrement_doctorant
    ADD CONSTRAINT fkm270vkwsvpkgm4ouv90fpenje FOREIGN KEY (enjeux_ird_id) REFERENCES public.enjeux_ird(id);


--
-- TOC entry 5729 (class 2606 OID 94794)
-- Name: instruments_et_dispositifs_ird fkm3aqv0drnj00xg4fagxd5r1tp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instruments_et_dispositifs_ird
    ADD CONSTRAINT fkm3aqv0drnj00xg4fagxd5r1tp FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5752 (class 2606 OID 94799)
-- Name: objet_global_formation_continue fkm4xc2hhli05iewex97jlpya2o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.objet_global_formation_continue
    ADD CONSTRAINT fkm4xc2hhli05iewex97jlpya2o FOREIGN KEY (objet_global_id) REFERENCES public.objet_global(id);


--
-- TOC entry 5582 (class 2606 OID 94804)
-- Name: ecole_doctorale fkmcmarm3lxvjux0a6yghpi7snc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ecole_doctorale
    ADD CONSTRAINT fkmcmarm3lxvjux0a6yghpi7snc FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5832 (class 2606 OID 94809)
-- Name: reclamation fkmitswsumwjvq2j958f4gt3axi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reclamation
    ADD CONSTRAINT fkmitswsumwjvq2j958f4gt3axi FOREIGN KEY (type_reclamation_id) REFERENCES public.type_reclamation(id);


--
-- TOC entry 5650 (class 2606 OID 94814)
-- Name: etablissement_encadrement_etudiant fkmiuk4tum7553xb8ky7djtgnnq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_encadrement_etudiant
    ADD CONSTRAINT fkmiuk4tum7553xb8ky7djtgnnq FOREIGN KEY (encadrement_etudiant_id) REFERENCES public.encadrement_etudiant(id);


--
-- TOC entry 5683 (class 2606 OID 94819)
-- Name: expertise_scientifique fkmjjw9q7lfrlvj2nu60qrqgmar; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expertise_scientifique
    ADD CONSTRAINT fkmjjw9q7lfrlvj2nu60qrqgmar FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5452 (class 2606 OID 94824)
-- Name: caracterisation_dev_de_savoir_et_innov fkmnuk4c0adsn4ilecujqmgcs9o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracterisation_dev_de_savoir_et_innov
    ADD CONSTRAINT fkmnuk4c0adsn4ilecujqmgcs9o FOREIGN KEY (caracterisation_id) REFERENCES public.caracterisation(id);


--
-- TOC entry 5788 (class 2606 OID 94829)
-- Name: pays_organisateur_rencontre_grand_publique_jeune_publique fkmp6yluj4xh0lk69vodfio5715; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_organisateur_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fkmp6yluj4xh0lk69vodfio5715 FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5713 (class 2606 OID 94834)
-- Name: gestion_equipe_detail fkmqkcqvpga98l9vwwhj2n6mewy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gestion_equipe_detail
    ADD CONSTRAINT fkmqkcqvpga98l9vwwhj2n6mewy FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5806 (class 2606 OID 94839)
-- Name: projet_activite_recherche_detail fkmrcr1nm3gmeaaysh0lmj0tw2p; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail
    ADD CONSTRAINT fkmrcr1nm3gmeaaysh0lmj0tw2p FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5497 (class 2606 OID 94844)
-- Name: consultance_scientifique_ponctuelle fkmsnu9n9oeyhd223sew6d9ovev; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultance_scientifique_ponctuelle
    ADD CONSTRAINT fkmsnu9n9oeyhd223sew6d9ovev FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5441 (class 2606 OID 94849)
-- Name: campagne_chercheur_ouverture fkmt4hhb0ovqg1mvo4m14dcrre4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_chercheur_ouverture
    ADD CONSTRAINT fkmt4hhb0ovqg1mvo4m14dcrre4 FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5849 (class 2606 OID 94854)
-- Name: rencontre_media fkmvasrld8hlg6eohhju0vmwucf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_media
    ADD CONSTRAINT fkmvasrld8hlg6eohhju0vmwucf FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5541 (class 2606 OID 94859)
-- Name: developpement_de_savoir_et_innovation_scientifique_type_savoir fkmviy1wm5lkkh50yklr8t7axsw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developpement_de_savoir_et_innovation_scientifique_type_savoir
    ADD CONSTRAINT fkmviy1wm5lkkh50yklr8t7axsw FOREIGN KEY (type_savoir_id) REFERENCES public.type_savoir(id);


--
-- TOC entry 5444 (class 2606 OID 94864)
-- Name: campagne_rappel fkmw93dc5b7c4tythji5cvv8vqf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_rappel
    ADD CONSTRAINT fkmw93dc5b7c4tythji5cvv8vqf FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5878 (class 2606 OID 94869)
-- Name: responsabilite_pedagogique_pays fkmxg14gja6mr3dcs0y4e7qbkiv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_pays
    ADD CONSTRAINT fkmxg14gja6mr3dcs0y4e7qbkiv FOREIGN KEY (responsabilite_pedagogique_id) REFERENCES public.responsabilite_pedagogique(id);


--
-- TOC entry 5584 (class 2606 OID 94874)
-- Name: encadrement fkn1wbdd3rw8dfvdhyb13ue9x0a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement
    ADD CONSTRAINT fkn1wbdd3rw8dfvdhyb13ue9x0a FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5433 (class 2606 OID 94879)
-- Name: campagne fkn4wkpth5t7obr3caxs6w5uksn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne
    ADD CONSTRAINT fkn4wkpth5t7obr3caxs6w5uksn FOREIGN KEY (template_ouverture_id) REFERENCES public.template_ouverture(id);


--
-- TOC entry 5720 (class 2606 OID 94884)
-- Name: instrument_ird fkn6nactt5uor9jladp4c85tyjp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instrument_ird
    ADD CONSTRAINT fkn6nactt5uor9jladp4c85tyjp FOREIGN KEY (type_instrument_ird_id) REFERENCES public.type_instrument_ird(id);


--
-- TOC entry 5796 (class 2606 OID 94889)
-- Name: pays_type_outil_culture_scientifique_outil_pedagogique fknayx3a07ypjjtj9n995lkisno; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_type_outil_culture_scientifique_outil_pedagogique
    ADD CONSTRAINT fknayx3a07ypjjtj9n995lkisno FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5555 (class 2606 OID 94894)
-- Name: discipline_scientifique_direction_encadrement_doctorant fknbc06pb4ohs38rhd1n37pqtgh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_direction_encadrement_doctorant
    ADD CONSTRAINT fknbc06pb4ohs38rhd1n37pqtgh FOREIGN KEY (encadrement_doctorant_id) REFERENCES public.encadrement_doctorant(id);


--
-- TOC entry 5514 (class 2606 OID 94899)
-- Name: culture_scientifique_outil_pedagogique fknhjmy8687bqshk5k9xbxyqx68; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.culture_scientifique_outil_pedagogique
    ADD CONSTRAINT fknhjmy8687bqshk5k9xbxyqx68 FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5825 (class 2606 OID 94904)
-- Name: public_cible_culture_scientifique_recontre_grand_public fknhwmx78o1d9tfcn448qyhk83q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_cible_culture_scientifique_recontre_grand_public
    ADD CONSTRAINT fknhwmx78o1d9tfcn448qyhk83q FOREIGN KEY (public_cible_id) REFERENCES public.public_cible(id);


--
-- TOC entry 5698 (class 2606 OID 94909)
-- Name: formation_continue_commanditaire fkniimjw32chxnon1o8viusw54q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue_commanditaire
    ADD CONSTRAINT fkniimjw32chxnon1o8viusw54q FOREIGN KEY (formation_continue_id) REFERENCES public.formation_continue(id);


--
-- TOC entry 5585 (class 2606 OID 94914)
-- Name: encadrement fknjksn8tflpq8kd11iaklqygj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement
    ADD CONSTRAINT fknjksn8tflpq8kd11iaklqygj FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5841 (class 2606 OID 94919)
-- Name: rencontre_grand_publique_jeune_publique_enjeux_ird fknlibavred6bhsrebdrubbock4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique_enjeux_ird
    ADD CONSTRAINT fknlibavred6bhsrebdrubbock4 FOREIGN KEY (rencontre_grand_publique_jeune_publique_id) REFERENCES public.rencontre_grand_publique_jeune_publique(id);


--
-- TOC entry 5702 (class 2606 OID 94924)
-- Name: formation_continue_enjeux_ird fknmv8xv7kxq0ilf2f9r318orl8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue_enjeux_ird
    ADD CONSTRAINT fknmv8xv7kxq0ilf2f9r318orl8 FOREIGN KEY (enjeux_ird_id) REFERENCES public.enjeux_ird(id);


--
-- TOC entry 5874 (class 2606 OID 94929)
-- Name: responsabilite_pedagogique_master fknmvwjp707oqhbkis6kbwsi2rg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_master
    ADD CONSTRAINT fknmvwjp707oqhbkis6kbwsi2rg FOREIGN KEY (master_id) REFERENCES public.master(id);


--
-- TOC entry 5468 (class 2606 OID 94934)
-- Name: comite_et_commission_evaluation fknqjxw80w451ctfdessmbojfsv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comite_et_commission_evaluation
    ADD CONSTRAINT fknqjxw80w451ctfdessmbojfsv FOREIGN KEY (expertise_id) REFERENCES public.expertise(id);


--
-- TOC entry 5538 (class 2606 OID 94939)
-- Name: developpement_de_savoir_et_innovation_scientifique_pays fknqme6csmcb2a4iljbeyw66m1r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developpement_de_savoir_et_innovation_scientifique_pays
    ADD CONSTRAINT fknqme6csmcb2a4iljbeyw66m1r FOREIGN KEY (developpement_de_savoir_et_innovation_scientifique_id) REFERENCES public.developpement_de_savoir_et_innovation_scientifique(id);


--
-- TOC entry 5722 (class 2606 OID 94944)
-- Name: instrument_ird_chercheur fknucystgo1yfv29ymepled5aj7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instrument_ird_chercheur
    ADD CONSTRAINT fknucystgo1yfv29ymepled5aj7 FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5628 (class 2606 OID 94949)
-- Name: enseignement_et_formation fknv6afln66efhvug75phpoynv6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_et_formation
    ADD CONSTRAINT fknv6afln66efhvug75phpoynv6 FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5483 (class 2606 OID 94954)
-- Name: communaute_savoir_expertise_scientifique fknviwlkmu5hs6q003ui00g96x3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_expertise_scientifique
    ADD CONSTRAINT fknviwlkmu5hs6q003ui00g96x3 FOREIGN KEY (communaute_savoir_id) REFERENCES public.communaute_savoir(id);


--
-- TOC entry 5602 (class 2606 OID 94959)
-- Name: encadrement_etudiant_discipline_scientifique fknwooiwe4wsa23x7v789ay7ay8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_etudiant_discipline_scientifique
    ADD CONSTRAINT fknwooiwe4wsa23x7v789ay7ay8 FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5889 (class 2606 OID 94964)
-- Name: type_etude_enseignement fko18a9f4x9pq9phkiidjsc1d9q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_etude_enseignement
    ADD CONSTRAINT fko18a9f4x9pq9phkiidjsc1d9q FOREIGN KEY (enseignement_id) REFERENCES public.enseignement(id);


--
-- TOC entry 5607 (class 2606 OID 94969)
-- Name: enjeux_ird_comite_et_commission_evaluation fko3dta5lgxdxwcphr8mq4fduwf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enjeux_ird_comite_et_commission_evaluation
    ADD CONSTRAINT fko3dta5lgxdxwcphr8mq4fduwf FOREIGN KEY (comite_et_commission_evaluation_id) REFERENCES public.comite_et_commission_evaluation(id);


--
-- TOC entry 5707 (class 2606 OID 94974)
-- Name: formation_continue_publique_professionel fko6xp1fieve9nm0r68aalvr2jm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue_publique_professionel
    ADD CONSTRAINT fko6xp1fieve9nm0r68aalvr2jm FOREIGN KEY (publique_professionel_id) REFERENCES public.publique_professionel(id);


--
-- TOC entry 5791 (class 2606 OID 94979)
-- Name: pays_projet_recherche fko7mra79egi0krgxvco6uh2dvf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_projet_recherche
    ADD CONSTRAINT fko7mra79egi0krgxvco6uh2dvf FOREIGN KEY (projet_activite_recherche_id) REFERENCES public.projet_activite_recherche(id);


--
-- TOC entry 5534 (class 2606 OID 94984)
-- Name: developpement_de_savoir_et_innovation_scientifique fko8acdi0lyboa20rm33nhifk6j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developpement_de_savoir_et_innovation_scientifique
    ADD CONSTRAINT fko8acdi0lyboa20rm33nhifk6j FOREIGN KEY (savoir_et_innovation_id) REFERENCES public.savoir_et_innovation(id);


--
-- TOC entry 5631 (class 2606 OID 94989)
-- Name: enseignement_zone_geographique fkocwxh80qycx5ttxj91mktn2s0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_zone_geographique
    ADD CONSTRAINT fkocwxh80qycx5ttxj91mktn2s0 FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5442 (class 2606 OID 94994)
-- Name: campagne_chercheur_ouverture fkogcu1cwm3fphci2sdamr15it5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_chercheur_ouverture
    ADD CONSTRAINT fkogcu1cwm3fphci2sdamr15it5 FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5560 (class 2606 OID 94999)
-- Name: discipline_scientifique_erc fkojp5tiy2kvda8oaipmcei1qfj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_erc
    ADD CONSTRAINT fkojp5tiy2kvda8oaipmcei1qfj FOREIGN KEY (discipline_scientifique_erc_id) REFERENCES public.discipline_scientifique_erc(id);


--
-- TOC entry 5651 (class 2606 OID 95004)
-- Name: etablissement_enseignement fkojrmj54rykhbs133kw5tmtkrv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_enseignement
    ADD CONSTRAINT fkojrmj54rykhbs133kw5tmtkrv FOREIGN KEY (enseignement_id) REFERENCES public.enseignement(id);


--
-- TOC entry 5611 (class 2606 OID 95009)
-- Name: enjeux_ird_consultance_scientifique_ponctuelle fkool2a36deu38hfos1jklfsvmu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enjeux_ird_consultance_scientifique_ponctuelle
    ADD CONSTRAINT fkool2a36deu38hfos1jklfsvmu FOREIGN KEY (consultance_scientifique_ponctuelle_id) REFERENCES public.consultance_scientifique_ponctuelle(id);


--
-- TOC entry 5439 (class 2606 OID 95014)
-- Name: campagne_chercheur_fermeture fkooyu07d0uro1twac38vtj18ht; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_chercheur_fermeture
    ADD CONSTRAINT fkooyu07d0uro1twac38vtj18ht FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5807 (class 2606 OID 95019)
-- Name: projet_activite_recherche_detail fkop6h1mvufefd930xi6s5h8c3e; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail
    ADD CONSTRAINT fkop6h1mvufefd930xi6s5h8c3e FOREIGN KEY (role_projet_id) REFERENCES public.role_projet(id);


--
-- TOC entry 5897 (class 2606 OID 95024)
-- Name: type_outil_culture_scientifique_outil_pedagogique fkoqywtxr7fgw1oyi5xta9j0yj5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_outil_culture_scientifique_outil_pedagogique
    ADD CONSTRAINT fkoqywtxr7fgw1oyi5xta9j0yj5 FOREIGN KEY (culture_scientifique_outil_pedagogique_id) REFERENCES public.culture_scientifique_outil_pedagogique(id);


--
-- TOC entry 5575 (class 2606 OID 95029)
-- Name: distinction_etablissement_pays fkoriyvtohi35y3x44tr9uqjf4j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.distinction_etablissement_pays
    ADD CONSTRAINT fkoriyvtohi35y3x44tr9uqjf4j FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5434 (class 2606 OID 95034)
-- Name: campagne fkorpr5qg0laepu5apruhrjwihq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne
    ADD CONSTRAINT fkorpr5qg0laepu5apruhrjwihq FOREIGN KEY (etat_campagne_id) REFERENCES public.etat_campagne(id);


--
-- TOC entry 5562 (class 2606 OID 95039)
-- Name: discipline_scientifique_erc_association fkosdu5pklhtaa2tr1g9g6x8ndn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_erc_association
    ADD CONSTRAINT fkosdu5pklhtaa2tr1g9g6x8ndn FOREIGN KEY (discipline_scientifique_erc_id) REFERENCES public.discipline_scientifique_erc(id);


--
-- TOC entry 5789 (class 2606 OID 95044)
-- Name: pays_organisateur_rencontre_grand_publique_jeune_publique fkou4burjtv3uql5cmtnhe0p52g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_organisateur_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fkou4burjtv3uql5cmtnhe0p52g FOREIGN KEY (rencontre_grand_publique_jeune_publique_id) REFERENCES public.rencontre_grand_publique_jeune_publique(id);


--
-- TOC entry 5663 (class 2606 OID 95049)
-- Name: evaluation_recherche_universitaire fkoumh7iukymieb5pjp0h9hs8p4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation_recherche_universitaire
    ADD CONSTRAINT fkoumh7iukymieb5pjp0h9hs8p4 FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5576 (class 2606 OID 95054)
-- Name: distinction_etablissement_pays fkovuu56x0hw9tnm685yacjmdj8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.distinction_etablissement_pays
    ADD CONSTRAINT fkovuu56x0hw9tnm685yacjmdj8 FOREIGN KEY (distinction_id) REFERENCES public.distinction(id);


--
-- TOC entry 5545 (class 2606 OID 95059)
-- Name: discipline_scientifique_chercheur fkp110x6a1jkdinmqxagwau705e; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_chercheur
    ADD CONSTRAINT fkp110x6a1jkdinmqxagwau705e FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5927 (class 2606 OID 95064)
-- Name: zone_geographique_conseils_scientifique fkp365t9skng3jfl7v18ixv9g5f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_geographique_conseils_scientifique
    ADD CONSTRAINT fkp365t9skng3jfl7v18ixv9g5f FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5436 (class 2606 OID 95069)
-- Name: campagne_chercheur fkp5jxf7rrpv2xgruydqrr1w43x; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_chercheur
    ADD CONSTRAINT fkp5jxf7rrpv2xgruydqrr1w43x FOREIGN KEY (etat_campagne_chercheur_id) REFERENCES public.etat_campagne_chercheur(id);


--
-- TOC entry 5838 (class 2606 OID 95074)
-- Name: rencontre_grand_publique_jeune_publique fkp7flix61rgorqc0jg3ln8c2kd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fkp7flix61rgorqc0jg3ln8c2kd FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5664 (class 2606 OID 95079)
-- Name: evaluation_recherche_universitaire fkp9n2ifrspbhx35bk3heua48yt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation_recherche_universitaire
    ADD CONSTRAINT fkp9n2ifrspbhx35bk3heua48yt FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5753 (class 2606 OID 95084)
-- Name: objet_global_formation_continue fkpajn13nv989tbr9btmo0lax6t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.objet_global_formation_continue
    ADD CONSTRAINT fkpajn13nv989tbr9btmo0lax6t FOREIGN KEY (formation_continue_id) REFERENCES public.formation_continue(id);


--
-- TOC entry 5850 (class 2606 OID 95089)
-- Name: rencontre_media fkpbwxvbuk6ngoei9o1tb9wr9r6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_media
    ADD CONSTRAINT fkpbwxvbuk6ngoei9o1tb9wr9r6 FOREIGN KEY (culture_scientifique_id) REFERENCES public.culture_scientifique(id);


--
-- TOC entry 5708 (class 2606 OID 95094)
-- Name: fournisseur_appel_projet_recherche fkpc2u0io7romwujnb5bm3fh00r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fournisseur_appel_projet_recherche
    ADD CONSTRAINT fkpc2u0io7romwujnb5bm3fh00r FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5795 (class 2606 OID 95099)
-- Name: pays_rencontre_media fkpc76p73x35g2v286wltv07tyi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_rencontre_media
    ADD CONSTRAINT fkpc76p73x35g2v286wltv07tyi FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5781 (class 2606 OID 95104)
-- Name: pays_culture_scientifique_recontre_grand_public_jeune_public fkpea9weg0hcdb5aaarxmbuktta; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_culture_scientifique_recontre_grand_public_jeune_public
    ADD CONSTRAINT fkpea9weg0hcdb5aaarxmbuktta FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5771 (class 2606 OID 95109)
-- Name: outil_pedagogique_public_cible fkpf7wf6pwnekj3w471srupfhm1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_public_cible
    ADD CONSTRAINT fkpf7wf6pwnekj3w471srupfhm1 FOREIGN KEY (public_cible_id) REFERENCES public.public_cible(id);


--
-- TOC entry 5535 (class 2606 OID 95114)
-- Name: developpement_de_savoir_et_innovation_scientifique fkph9uqs60vvmtvihadfm25qp8x; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developpement_de_savoir_et_innovation_scientifique
    ADD CONSTRAINT fkph9uqs60vvmtvihadfm25qp8x FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5654 (class 2606 OID 95119)
-- Name: etablissement_projet fkphevq46x76s91b4r9cwfvs8x3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_projet
    ADD CONSTRAINT fkphevq46x76s91b4r9cwfvs8x3 FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5735 (class 2606 OID 95124)
-- Name: key_word_discipline_scientifique_erc fkpi898srdsmyc2xs0eg4hbqtyk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_word_discipline_scientifique_erc
    ADD CONSTRAINT fkpi898srdsmyc2xs0eg4hbqtyk FOREIGN KEY (key_word_id) REFERENCES public.key_word(id);


--
-- TOC entry 5437 (class 2606 OID 95129)
-- Name: campagne_chercheur fkpimpk1xtrsr90yui27nhnok4a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campagne_chercheur
    ADD CONSTRAINT fkpimpk1xtrsr90yui27nhnok4a FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5684 (class 2606 OID 95134)
-- Name: expertise_scientifique fkpjdnt3s8qmoe4xh8gmbu0umic; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expertise_scientifique
    ADD CONSTRAINT fkpjdnt3s8qmoe4xh8gmbu0umic FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5895 (class 2606 OID 95139)
-- Name: type_instrument_ird_consultance_scientifique_ponctuelle fkpjo8etba0295wk0scxwc1egr0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_instrument_ird_consultance_scientifique_ponctuelle
    ADD CONSTRAINT fkpjo8etba0295wk0scxwc1egr0 FOREIGN KEY (type_instrument_ird_id) REFERENCES public.type_instrument_ird(id);


--
-- TOC entry 5912 (class 2606 OID 95144)
-- Name: vie_institutionnelle fkplb21siarfrkssphi3c9etsv4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vie_institutionnelle
    ADD CONSTRAINT fkplb21siarfrkssphi3c9etsv4 FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5703 (class 2606 OID 95149)
-- Name: formation_continue_enjeux_ird fkplonl44omuvhyx0qa4t3o5ly0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue_enjeux_ird
    ADD CONSTRAINT fkplonl44omuvhyx0qa4t3o5ly0 FOREIGN KEY (formation_continue_id) REFERENCES public.formation_continue(id);


--
-- TOC entry 5755 (class 2606 OID 95154)
-- Name: outil_pedagogique fkpm9v9jyqxhdv8jy3d1011lmo0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique
    ADD CONSTRAINT fkpm9v9jyqxhdv8jy3d1011lmo0 FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5772 (class 2606 OID 95159)
-- Name: outil_pedagogique_publique_cible fkpo9p4c496icr5i89tens1wrvg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_publique_cible
    ADD CONSTRAINT fkpo9p4c496icr5i89tens1wrvg FOREIGN KEY (outil_pedagogique_id) REFERENCES public.outil_pedagogique(id);


--
-- TOC entry 5769 (class 2606 OID 95164)
-- Name: outil_pedagogique_periode fkpr1af8vwxkykjdp0l6c6fwpdi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_periode
    ADD CONSTRAINT fkpr1af8vwxkykjdp0l6c6fwpdi FOREIGN KEY (outil_pedagogique_id) REFERENCES public.outil_pedagogique(id);


--
-- TOC entry 5577 (class 2606 OID 95169)
-- Name: distinction_etablissement_pays fkps4ona0j1hgyob7iyidgxkxpt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.distinction_etablissement_pays
    ADD CONSTRAINT fkps4ona0j1hgyob7iyidgxkxpt FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5625 (class 2606 OID 95174)
-- Name: enseignement_enjeux_ird fkpxxtljyoc514cs57xx98loc9s; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_enjeux_ird
    ADD CONSTRAINT fkpxxtljyoc514cs57xx98loc9s FOREIGN KEY (enseignement_id) REFERENCES public.enseignement(id);


--
-- TOC entry 5553 (class 2606 OID 95179)
-- Name: discipline_scientifique_consultance_scientifique_ponctuelle fkq0f17bjvuarml43fayb2fbitg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_consultance_scientifique_ponctuelle
    ADD CONSTRAINT fkq0f17bjvuarml43fayb2fbitg FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5489 (class 2606 OID 95184)
-- Name: conseil_et_comite_scientifique fkq1s3n8r30vud968fflj5dekua; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.conseil_et_comite_scientifique
    ADD CONSTRAINT fkq1s3n8r30vud968fflj5dekua FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5556 (class 2606 OID 95189)
-- Name: discipline_scientifique_encadrement_doctorant fkq3nh63b17aq4eiqv5q4adyye5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_encadrement_doctorant
    ADD CONSTRAINT fkq3nh63b17aq4eiqv5q4adyye5 FOREIGN KEY (encadrement_doctorant_id) REFERENCES public.encadrement_doctorant(id);


--
-- TOC entry 5857 (class 2606 OID 95194)
-- Name: responsabilite_pedagogique fkq5vm28ht8nc6kl9slcvvs0h11; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique
    ADD CONSTRAINT fkq5vm28ht8nc6kl9slcvvs0h11 FOREIGN KEY (status_cursus_id) REFERENCES public.status_cursus(id);


--
-- TOC entry 5833 (class 2606 OID 95199)
-- Name: reclamation fkq6g56k00xmvbmnrjw9t5kbhgj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reclamation
    ADD CONSTRAINT fkq6g56k00xmvbmnrjw9t5kbhgj FOREIGN KEY (etat_reclamation_id) REFERENCES public.etat_reclamation(id);


--
-- TOC entry 5675 (class 2606 OID 95204)
-- Name: evenement_colloque_scientifique_instrument_ird fkq78vo11qhgyc2v8flp6ddmxxc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement_colloque_scientifique_instrument_ird
    ADD CONSTRAINT fkq78vo11qhgyc2v8flp6ddmxxc FOREIGN KEY (evenement_colloque_scienntifique_id) REFERENCES public.evenement_colloque_scienntifique(id);


--
-- TOC entry 5810 (class 2606 OID 95209)
-- Name: projet_activite_recherche_detail_enjeux_ird fkq8dc1bc7sdfpp71ccaflau8l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_enjeux_ird
    ADD CONSTRAINT fkq8dc1bc7sdfpp71ccaflau8l FOREIGN KEY (projet_activite_recherche_detail_id) REFERENCES public.projet_activite_recherche_detail(id);


--
-- TOC entry 5642 (class 2606 OID 95214)
-- Name: etablissement_consultance_scientifique_ponctuelle fkqb707s0eflcs9f9lns9d6x6b4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_consultance_scientifique_ponctuelle
    ADD CONSTRAINT fkqb707s0eflcs9f9lns9d6x6b4 FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5685 (class 2606 OID 95219)
-- Name: expertise_scientifique fkqcs9ao2gcfjo0qyx9qknejo64; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expertise_scientifique
    ADD CONSTRAINT fkqcs9ao2gcfjo0qyx9qknejo64 FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5773 (class 2606 OID 95224)
-- Name: outil_pedagogique_publique_cible fkqg2502djce0w643njib12jmoi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_publique_cible
    ADD CONSTRAINT fkqg2502djce0w643njib12jmoi FOREIGN KEY (publique_cible_id) REFERENCES public.publique_cible(id);


--
-- TOC entry 5490 (class 2606 OID 95229)
-- Name: conseil_et_comite_scientifique fkqhik89dhtyaayiyqpy1bngvlq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.conseil_et_comite_scientifique
    ADD CONSTRAINT fkqhik89dhtyaayiyqpy1bngvlq FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5727 (class 2606 OID 95234)
-- Name: instrument_ird_consultance_scientifique_ponctuelle fkql3rvwajqc9cckkbp6kfsyyso; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instrument_ird_consultance_scientifique_ponctuelle
    ADD CONSTRAINT fkql3rvwajqc9cckkbp6kfsyyso FOREIGN KEY (instrument_ird_id) REFERENCES public.instrument_ird(id);


--
-- TOC entry 5477 (class 2606 OID 95239)
-- Name: communaute_savoir_encadrement_etudiant fkql3s3ubdko8fk6p4sm814ad5i; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.communaute_savoir_encadrement_etudiant
    ADD CONSTRAINT fkql3s3ubdko8fk6p4sm814ad5i FOREIGN KEY (communaute_savoir_id) REFERENCES public.communaute_savoir(id);


--
-- TOC entry 5502 (class 2606 OID 95244)
-- Name: contexte_rencontre_grand_publique_jeune_publique fkqnc9oecjv3xwc51prt0t5e83y; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contexte_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fkqnc9oecjv3xwc51prt0t5e83y FOREIGN KEY (contexte_id) REFERENCES public.contexte(id);


--
-- TOC entry 5505 (class 2606 OID 95249)
-- Name: contrat_et_convention_ird fkqnv5sppu6wkq0gy0rlcunln2i; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contrat_et_convention_ird
    ADD CONSTRAINT fkqnv5sppu6wkq0gy0rlcunln2i FOREIGN KEY (status_contrat_et_convention_id) REFERENCES public.status_contrat_et_convention(id);


--
-- TOC entry 5823 (class 2606 OID 95254)
-- Name: public_cible_culture_scientifique_outil_pedagogique fkqqia2g2qlyetotv9w4bp235tr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_cible_culture_scientifique_outil_pedagogique
    ADD CONSTRAINT fkqqia2g2qlyetotv9w4bp235tr FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5599 (class 2606 OID 95259)
-- Name: encadrement_etudiant fkqrlcyvibf6v2wikrgyuwqiqet; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_etudiant
    ADD CONSTRAINT fkqrlcyvibf6v2wikrgyuwqiqet FOREIGN KEY (responsabilite_direction_encadrement_etudiant_id) REFERENCES public.responsabilite_direction_encadrement_etudiant(id);


--
-- TOC entry 5756 (class 2606 OID 95264)
-- Name: outil_pedagogique fkqrq0ot8nm4bokkbb8cfgvqxwy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique
    ADD CONSTRAINT fkqrq0ot8nm4bokkbb8cfgvqxwy FOREIGN KEY (culture_scientifique_id) REFERENCES public.culture_scientifique(id);


--
-- TOC entry 5524 (class 2606 OID 95269)
-- Name: dev_savoir_innov_scientifique_enjeux_ird fkqrq49hclsnm94i0ybc6hfyr9u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_enjeux_ird
    ADD CONSTRAINT fkqrq49hclsnm94i0ybc6hfyr9u FOREIGN KEY (enjeux_ird_id) REFERENCES public.enjeux_ird(id);


--
-- TOC entry 5842 (class 2606 OID 95274)
-- Name: rencontre_grand_publique_jeune_publique_enjeux_ird fkqs6q1j64wp8d5wq28gy0gcl94; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique_enjeux_ird
    ADD CONSTRAINT fkqs6q1j64wp8d5wq28gy0gcl94 FOREIGN KEY (enjeux_ird_id) REFERENCES public.enjeux_ird(id);


--
-- TOC entry 5730 (class 2606 OID 95279)
-- Name: instruments_et_dispositifs_ird_chercheur fkqucgji3e9wukr3046epcn3fpu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instruments_et_dispositifs_ird_chercheur
    ADD CONSTRAINT fkqucgji3e9wukr3046epcn3fpu FOREIGN KEY (type_instruments_et_dispositifs_ird_id) REFERENCES public.type_instruments_et_dispositifs_ird(id);


--
-- TOC entry 5818 (class 2606 OID 95284)
-- Name: projet_activite_recherche_detail_instrument_ird fkqw1hukeu8wtsqrb1m6i2hy25b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail_instrument_ird
    ADD CONSTRAINT fkqw1hukeu8wtsqrb1m6i2hy25b FOREIGN KEY (instrument_ird_id) REFERENCES public.instrument_ird(id);


--
-- TOC entry 5758 (class 2606 OID 95289)
-- Name: outil_pedagogique_discipline_scientifique fkr0wsp12n6sw73jn27autv63p1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.outil_pedagogique_discipline_scientifique
    ADD CONSTRAINT fkr0wsp12n6sw73jn27autv63p1 FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5699 (class 2606 OID 95294)
-- Name: formation_continue_commanditaire fkr16lavyirvwat2pk13putopw3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue_commanditaire
    ADD CONSTRAINT fkr16lavyirvwat2pk13putopw3 FOREIGN KEY (commanditaire_id) REFERENCES public.commanditaire(id);


--
-- TOC entry 5695 (class 2606 OID 95299)
-- Name: formation_continue fkr1a1gpl6mf89k30cdyt0jr7n7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue
    ADD CONSTRAINT fkr1a1gpl6mf89k30cdyt0jr7n7 FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5678 (class 2606 OID 95304)
-- Name: expertise fkr20hmrwj7jhk76pd12f9djeiy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expertise
    ADD CONSTRAINT fkr20hmrwj7jhk76pd12f9djeiy FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5715 (class 2606 OID 95309)
-- Name: identifiant_auteur_expert fkr29435vwuu7x1klkfk1g264pu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.identifiant_auteur_expert
    ADD CONSTRAINT fkr29435vwuu7x1klkfk1g264pu FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5875 (class 2606 OID 95314)
-- Name: responsabilite_pedagogique_master fkr2pefnijga1karo3q6qlw5jl4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_master
    ADD CONSTRAINT fkr2pefnijga1karo3q6qlw5jl4 FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5537 (class 2606 OID 95319)
-- Name: developpement_de_savoir_et_innovation_scientifique_enjeux_ird fkr4wddq0uuc5u32qvug471m54k; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developpement_de_savoir_et_innovation_scientifique_enjeux_ird
    ADD CONSTRAINT fkr4wddq0uuc5u32qvug471m54k FOREIGN KEY (enjeux_ird_id) REFERENCES public.enjeux_ird(id);


--
-- TOC entry 5646 (class 2606 OID 95324)
-- Name: etablissement_culture_scientifique_recontre_grand_public_jeune_ fkr68j8p3mesoqq892q38lrpf0t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_culture_scientifique_recontre_grand_public_jeune_
    ADD CONSTRAINT fkr68j8p3mesoqq892q38lrpf0t FOREIGN KEY (culture_scientifique_recontre_grand_public_jeune_public_id) REFERENCES public.culture_scientifique_recontre_grand_public_jeune_public(id);


--
-- TOC entry 5612 (class 2606 OID 95329)
-- Name: enjeux_ird_consultance_scientifique_ponctuelle fkr6a0li83e92m8urbc4rtquubm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enjeux_ird_consultance_scientifique_ponctuelle
    ADD CONSTRAINT fkr6a0li83e92m8urbc4rtquubm FOREIGN KEY (enjeux_ird_id) REFERENCES public.enjeux_ird(id);


--
-- TOC entry 5899 (class 2606 OID 95334)
-- Name: type_outil_pedagogique fkr6s6y754q8mpp7wwxoaikp7os; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_outil_pedagogique
    ADD CONSTRAINT fkr6s6y754q8mpp7wwxoaikp7os FOREIGN KEY (outil_pedagogique_id) REFERENCES public.outil_pedagogique(id);


--
-- TOC entry 5901 (class 2606 OID 95339)
-- Name: type_publique_rencontre_grand_publique_jeune_publique fkr9i92kkswos3out5jcja2kqpp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_publique_rencontre_grand_publique_jeune_publique
    ADD CONSTRAINT fkr9i92kkswos3out5jcja2kqpp FOREIGN KEY (rencontre_grand_publique_jeune_publique_id) REFERENCES public.rencontre_grand_publique_jeune_publique(id);


--
-- TOC entry 5830 (class 2606 OID 95344)
-- Name: publique_principal_conceme_formation_continue fkrbfcc705e007juj7dgqm6fwsg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publique_principal_conceme_formation_continue
    ADD CONSTRAINT fkrbfcc705e007juj7dgqm6fwsg FOREIGN KEY (formation_continue_id) REFERENCES public.formation_continue(id);


--
-- TOC entry 5844 (class 2606 OID 95349)
-- Name: rencontre_grand_publique_jeune_publique_instrument_ird fkrbuc0o7o3t3llcc5eo38wigp2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique_instrument_ird
    ADD CONSTRAINT fkrbuc0o7o3t3llcc5eo38wigp2 FOREIGN KEY (rencontre_grand_publique_jeune_publique_id) REFERENCES public.rencontre_grand_publique_jeune_publique(id);


--
-- TOC entry 5858 (class 2606 OID 95354)
-- Name: responsabilite_pedagogique fkrffbi0te2bq1bcvwu4t2isp0l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique
    ADD CONSTRAINT fkrffbi0te2bq1bcvwu4t2isp0l FOREIGN KEY (niveau_responsabilite_pedagogique_id) REFERENCES public.niveau_responsabilite_pedagogique(id);


--
-- TOC entry 5632 (class 2606 OID 95359)
-- Name: enseignement_zone_geographique fkrg8hhj3cjqoic1ru96xv55d5t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_zone_geographique
    ADD CONSTRAINT fkrg8hhj3cjqoic1ru96xv55d5t FOREIGN KEY (enseignement_id) REFERENCES public.enseignement(id);


--
-- TOC entry 5743 (class 2606 OID 95364)
-- Name: nature_enseignement fkrhkda5qiogdy88hdhyrdlsdcb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nature_enseignement
    ADD CONSTRAINT fkrhkda5qiogdy88hdhyrdlsdcb FOREIGN KEY (nature_etude_id) REFERENCES public.nature_etude(id);


--
-- TOC entry 5688 (class 2606 OID 95369)
-- Name: financement_encadrement_doctorant fkrqasa4nwk4fsbbnmnstdsnidn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.financement_encadrement_doctorant
    ADD CONSTRAINT fkrqasa4nwk4fsbbnmnstdsnidn FOREIGN KEY (encadrement_doctorant_id) REFERENCES public.encadrement_doctorant(id);


--
-- TOC entry 5876 (class 2606 OID 95374)
-- Name: responsabilite_pedagogique_master fkruiki8nuuuncesq14d4qokuxx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique_master
    ADD CONSTRAINT fkruiki8nuuuncesq14d4qokuxx FOREIGN KEY (statut_master_id) REFERENCES public.statut_master(id);


--
-- TOC entry 5511 (class 2606 OID 95379)
-- Name: culture_scientifique fkrvdj2c57fq7o9a12omgleytfh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.culture_scientifique
    ADD CONSTRAINT fkrvdj2c57fq7o9a12omgleytfh FOREIGN KEY (nature_activite_grand_publique_id) REFERENCES public.nature_activite_grand_publique(id);


--
-- TOC entry 5859 (class 2606 OID 95384)
-- Name: responsabilite_pedagogique fkrw8ur6ice9rwgtljfjtcuedj0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsabilite_pedagogique
    ADD CONSTRAINT fkrw8ur6ice9rwgtljfjtcuedj0 FOREIGN KEY (enseignement_et_formation_id) REFERENCES public.enseignement_et_formation(id);


--
-- TOC entry 5739 (class 2606 OID 95389)
-- Name: mode_diffusion fkrwcdlml22pxdlpbac7n0tvksl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mode_diffusion
    ADD CONSTRAINT fkrwcdlml22pxdlpbac7n0tvksl FOREIGN KEY (type_savoir_id) REFERENCES public.type_savoir(id);


--
-- TOC entry 5887 (class 2606 OID 95394)
-- Name: structure_oganisatrice fkrxg54i8g2a91i4vguywu28flo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.structure_oganisatrice
    ADD CONSTRAINT fkrxg54i8g2a91i4vguywu28flo FOREIGN KEY (rencontre_grand_publique_jeune_publique_id) REFERENCES public.rencontre_grand_publique_jeune_publique(id);


--
-- TOC entry 5845 (class 2606 OID 95399)
-- Name: rencontre_grand_publique_jeune_publique_periode fks10koafx8y7322dwvxxlat4kl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_grand_publique_jeune_publique_periode
    ADD CONSTRAINT fks10koafx8y7322dwvxxlat4kl FOREIGN KEY (rencontre_grand_publique_jeune_publique_id) REFERENCES public.rencontre_grand_publique_jeune_publique(id);


--
-- TOC entry 5498 (class 2606 OID 95404)
-- Name: consultance_scientifique_ponctuelle fks42qdtgcxx4fctqwd5toff1r0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultance_scientifique_ponctuelle
    ADD CONSTRAINT fks42qdtgcxx4fctqwd5toff1r0 FOREIGN KEY (expertise_id) REFERENCES public.expertise(id);


--
-- TOC entry 5776 (class 2606 OID 95409)
-- Name: partenaire fks8nptdmpoutqi7sx4rwcc318d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partenaire
    ADD CONSTRAINT fks8nptdmpoutqi7sx4rwcc318d FOREIGN KEY (pays_partenaire_id) REFERENCES public.pays(id);


--
-- TOC entry 5592 (class 2606 OID 95414)
-- Name: encadrement_doctorant fksadoknkel8veblo5jqk70dnna; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_doctorant
    ADD CONSTRAINT fksadoknkel8veblo5jqk70dnna FOREIGN KEY (financement_doctorant_id) REFERENCES public.financement_doctorant(id);


--
-- TOC entry 5539 (class 2606 OID 95419)
-- Name: developpement_de_savoir_et_innovation_scientifique_pays fkscbpap390aur2dlhyvmd14pk6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developpement_de_savoir_et_innovation_scientifique_pays
    ADD CONSTRAINT fkscbpap390aur2dlhyvmd14pk6 FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5557 (class 2606 OID 95424)
-- Name: discipline_scientifique_encadrement_doctorant fkscg2rnek6t7a4v5c3181f47wj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_encadrement_doctorant
    ADD CONSTRAINT fkscg2rnek6t7a4v5c3181f47wj FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5679 (class 2606 OID 95429)
-- Name: expertise fksgdy67kmjxt6g3ecl5xr2giuj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expertise
    ADD CONSTRAINT fksgdy67kmjxt6g3ecl5xr2giuj FOREIGN KEY (campagne_id) REFERENCES public.campagne(id);


--
-- TOC entry 5600 (class 2606 OID 95434)
-- Name: encadrement_etudiant fksilfsd3qblrli24xijrl83vo3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_etudiant
    ADD CONSTRAINT fksilfsd3qblrli24xijrl83vo3 FOREIGN KEY (niveau_formation_post_bac_id) REFERENCES public.niveau_formation_post_bac(id);


--
-- TOC entry 5924 (class 2606 OID 95439)
-- Name: zone_activite_interaction_recherche fkskuh08uq7annj2hoc80cdgnhq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_activite_interaction_recherche
    ADD CONSTRAINT fkskuh08uq7annj2hoc80cdgnhq FOREIGN KEY (zone_geographique_id) REFERENCES public.zone_geographique(id);


--
-- TOC entry 5696 (class 2606 OID 95444)
-- Name: formation_continue fksph2nbmfw7aajf4tljv6eruab; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formation_continue
    ADD CONSTRAINT fksph2nbmfw7aajf4tljv6eruab FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5652 (class 2606 OID 95449)
-- Name: etablissement_enseignement fkspkfif4xuxhrtl12pwp8erh0e; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_enseignement
    ADD CONSTRAINT fkspkfif4xuxhrtl12pwp8erh0e FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5547 (class 2606 OID 95454)
-- Name: discipline_scientifique_comite_et_commission_evaluation fksrgamsevhu6gb3br276nkru9m; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_comite_et_commission_evaluation
    ADD CONSTRAINT fksrgamsevhu6gb3br276nkru9m FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5787 (class 2606 OID 95459)
-- Name: pays_formation_continue fksrv150qbnyonal1ont9s28ws; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_formation_continue
    ADD CONSTRAINT fksrv150qbnyonal1ont9s28ws FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 5464 (class 2606 OID 95464)
-- Name: chercheur fkstpgf32280yiebckds1h5r9hf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chercheur
    ADD CONSTRAINT fkstpgf32280yiebckds1h5r9hf FOREIGN KEY (sexe_id) REFERENCES public.sexe(id);


--
-- TOC entry 5731 (class 2606 OID 95469)
-- Name: instruments_et_dispositifs_ird_chercheur fkswhop69h5t4w98ql80mn0g3yg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instruments_et_dispositifs_ird_chercheur
    ADD CONSTRAINT fkswhop69h5t4w98ql80mn0g3yg FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5855 (class 2606 OID 95474)
-- Name: rencontre_media_periode fkswurbuovu4dmc8pvqi5orh5o9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rencontre_media_periode
    ADD CONSTRAINT fkswurbuovu4dmc8pvqi5orh5o9 FOREIGN KEY (rencontre_media_id) REFERENCES public.rencontre_media(id);


--
-- TOC entry 5930 (class 2606 OID 95479)
-- Name: zone_geographique_consultance_scientifique_ponctuelle fksye4d91ve6fy0dve4qy9e8eg5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zone_geographique_consultance_scientifique_ponctuelle
    ADD CONSTRAINT fksye4d91ve6fy0dve4qy9e8eg5 FOREIGN KEY (consultance_scientifique_ponctuelle_id) REFERENCES public.consultance_scientifique_ponctuelle(id);


--
-- TOC entry 5633 (class 2606 OID 95484)
-- Name: enseignement_zone_geographique fkt4ias4k38v9gmg2n4rsm0oadx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement_zone_geographique
    ADD CONSTRAINT fkt4ias4k38v9gmg2n4rsm0oadx FOREIGN KEY (zone_geographique_id) REFERENCES public.zone_geographique(id);


--
-- TOC entry 5608 (class 2606 OID 95489)
-- Name: enjeux_ird_comite_et_commission_evaluation fkt55jf7tbbicwmpkk07khss5vw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enjeux_ird_comite_et_commission_evaluation
    ADD CONSTRAINT fkt55jf7tbbicwmpkk07khss5vw FOREIGN KEY (enjeux_ird_id) REFERENCES public.enjeux_ird(id);


--
-- TOC entry 5665 (class 2606 OID 95494)
-- Name: evaluation_recherche_universitaire fkt5rxq2x92xyxjk7qds0pc121w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation_recherche_universitaire
    ADD CONSTRAINT fkt5rxq2x92xyxjk7qds0pc121w FOREIGN KEY (type_expert_id) REFERENCES public.type_expert(id);


--
-- TOC entry 5648 (class 2606 OID 95499)
-- Name: etablissement_encadrement_doctorant fktg3w8udgobskrghm7b99i5ruk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etablissement_encadrement_doctorant
    ADD CONSTRAINT fktg3w8udgobskrghm7b99i5ruk FOREIGN KEY (etablissement_id) REFERENCES public.etablissement(id);


--
-- TOC entry 5494 (class 2606 OID 95504)
-- Name: conseils_scientifique fktg9ra6wc77xj7hdnpesh3vou4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.conseils_scientifique
    ADD CONSTRAINT fktg9ra6wc77xj7hdnpesh3vou4 FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5905 (class 2606 OID 95509)
-- Name: type_savoir_developpement_de_savoir_et_innovation_scientifique fktk1s6m5usueqxqtmpeyq9phmg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_savoir_developpement_de_savoir_et_innovation_scientifique
    ADD CONSTRAINT fktk1s6m5usueqxqtmpeyq9phmg FOREIGN KEY (developpement_de_savoir_et_innovation_scientifique_id) REFERENCES public.developpement_de_savoir_et_innovation_scientifique(id);


--
-- TOC entry 5563 (class 2606 OID 95514)
-- Name: discipline_scientifique_erc_association fktkxrai59i4tqqmy0990kduexx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline_scientifique_erc_association
    ADD CONSTRAINT fktkxrai59i4tqqmy0990kduexx FOREIGN KEY (discipline_scientifique_id) REFERENCES public.discipline_scientifique(id);


--
-- TOC entry 5797 (class 2606 OID 95519)
-- Name: pays_type_outil_culture_scientifique_outil_pedagogique fktl61yu3g9ie0iphr6bopc13wp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays_type_outil_culture_scientifique_outil_pedagogique
    ADD CONSTRAINT fktl61yu3g9ie0iphr6bopc13wp FOREIGN KEY (culture_scientifique_outil_pedagogique_id) REFERENCES public.culture_scientifique_outil_pedagogique(id);


--
-- TOC entry 5808 (class 2606 OID 95524)
-- Name: projet_activite_recherche_detail fktl6mh8lt206yqthm2wln7gsbr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projet_activite_recherche_detail
    ADD CONSTRAINT fktl6mh8lt206yqthm2wln7gsbr FOREIGN KEY (status_projet_id) REFERENCES public.status_projet(id);


--
-- TOC entry 5604 (class 2606 OID 95529)
-- Name: encadrement_etudiant_enjeux_ird fktox4jc3ss4r6ji3rt79ro6jen; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encadrement_etudiant_enjeux_ird
    ADD CONSTRAINT fktox4jc3ss4r6ji3rt79ro6jen FOREIGN KEY (encadrement_etudiant_id) REFERENCES public.encadrement_etudiant(id);


--
-- TOC entry 5621 (class 2606 OID 95534)
-- Name: enseignement fktp0uehst9ontmlvb277xpwxk5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignement
    ADD CONSTRAINT fktp0uehst9ontmlvb277xpwxk5 FOREIGN KEY (chercheur_id) REFERENCES public.chercheur(id);


--
-- TOC entry 5676 (class 2606 OID 95539)
-- Name: evenement_colloque_scientifique_instrument_ird fktpi5ycfwwyu74jv87y9s5fyqh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement_colloque_scientifique_instrument_ird
    ADD CONSTRAINT fktpi5ycfwwyu74jv87y9s5fyqh FOREIGN KEY (instrument_ird_id) REFERENCES public.instrument_ird(id);


--
-- TOC entry 5522 (class 2606 OID 95544)
-- Name: dev_savoir_innov_scientifique_discipline_scientifique fktr97at4nk8950jubxi6sv99pu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_discipline_scientifique
    ADD CONSTRAINT fktr97at4nk8950jubxi6sv99pu FOREIGN KEY (developpement_de_savoir_et_innovation_scientifique_id) REFERENCES public.dev_savoir_innov_scientifique(id);


--
-- TOC entry 5669 (class 2606 OID 95549)
-- Name: evenement_colloque_scienntifique fku1f7n2ptob17ctntmnwokuwj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement_colloque_scienntifique
    ADD CONSTRAINT fku1f7n2ptob17ctntmnwokuwj FOREIGN KEY (etat_etape_campagne_id) REFERENCES public.etat_etape_campagne(id);


--
-- TOC entry 5526 (class 2606 OID 95554)
-- Name: dev_savoir_innov_scientifique_instrument_ird fkuukmk4ygl45qyoy4i3igprru; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique_instrument_ird
    ADD CONSTRAINT fkuukmk4ygl45qyoy4i3igprru FOREIGN KEY (developpement_de_savoir_et_innovation_scientifique_id) REFERENCES public.dev_savoir_innov_scientifique(id);


--
-- TOC entry 5670 (class 2606 OID 95559)
-- Name: evenement_colloque_scienntifique fkuvdx3pf48dl1kvw2bhr4no7i; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement_colloque_scienntifique
    ADD CONSTRAINT fkuvdx3pf48dl1kvw2bhr4no7i FOREIGN KEY (modalite_intervention_id) REFERENCES public.modalite_intervention(id);


--
-- TOC entry 5520 (class 2606 OID 95564)
-- Name: dev_savoir_innov_scientifique fky351rskvtkl2pyiyp7pwuv9q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dev_savoir_innov_scientifique
    ADD CONSTRAINT fky351rskvtkl2pyiyp7pwuv9q FOREIGN KEY (role_developpement_de_savoir_id) REFERENCES public.role_developpement_de_savoir(id);


--
-- TOC entry 5826 (class 2606 OID 95569)
-- Name: public_cible_culture_scientifique_recontre_grand_public fkyaxon11701s8g6w1w7n89rft; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_cible_culture_scientifique_recontre_grand_public
    ADD CONSTRAINT fkyaxon11701s8g6w1w7n89rft FOREIGN KEY (culture_scientifique_recontre_grand_public_jeune_public_id) REFERENCES public.culture_scientifique_recontre_grand_public_jeune_public(id);


-- Completed on 2022-05-12 14:49:38

--
-- PostgreSQL database dump complete
--

