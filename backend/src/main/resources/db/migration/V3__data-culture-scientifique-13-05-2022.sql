
INSERT INTO public.nature_activite_grand_publique(id,code,libelle) VALUES (10000, 'rencontreJeunePublic', 'Une rencontre ou action réalisée avec ou pour des jeunes, des scolaires ou du grand public (portes ouvertes, démonstration-animation, projection de film, conférence, café-science, intervention en classe, etc.)');
INSERT INTO public.nature_activite_grand_publique(id,code,libelle) VALUES (10001, 'media', 'Une rencontre-média grand public (TV, radio, interview presse grand public, etc.) ?');
INSERT INTO public.nature_activite_grand_publique(id,code,libelle) VALUES (10002, 'outil', 'La description d’un outil de médiation culturelle, d’un instrument pédagogique à destination de jeunes, de scolaires ou du grand public et société civile (jeu, exposition, pièce de théâtre, etc.)');


INSERT INTO public.format_rencontre(id,code,libelle) VALUES (10000, 'presentiel', 'présentiel');
INSERT INTO public.format_rencontre(id,code,libelle)  VALUES (10001, 'numerique', 'numérique ');
INSERT INTO public.format_rencontre(id,code,libelle)  VALUES (10002, 'mixte', 'mixte ');

INSERT INTO public.langue(id,code,libelle) VALUES (10000, 'fr', 'français');
INSERT INTO public.langue(id,code,libelle) VALUES (10001, 'en', 'anglais');
INSERT INTO public.langue(id,code,libelle) VALUES (10002, 'es', 'espagnol');

INSERT INTO public.type_publique(id,code,libelle) VALUES (10003, 'grandpublic', 'grand public');

INSERT INTO public.type_instrument_ird(id,code,libelle) VALUES (10001,'type2','type2');
INSERT INTO public.type_instrument_ird(id,code,libelle) VALUES (10000,'type1','type1');
INSERT INTO public.type_instrument_ird(id,code,libelle) VALUES (10002,'type3','type3');
INSERT INTO public.type_instrument_ird(id,code,libelle) VALUES (10003,'type4','type4');

INSERT INTO public.instrument_ird(id,code,libelle,type_instrument_ird_id) VALUES (10000,'instrument1','instrument1', 10000);
INSERT INTO public.instrument_ird(id,code,libelle,type_instrument_ird_id) VALUES (10001,'instrument2','instrument2', 10000);
INSERT INTO public.instrument_ird(id,code,libelle,type_instrument_ird_id) VALUES (10002,'instrument3','instrument3', 10001);
INSERT INTO public.instrument_ird(id,code,libelle,type_instrument_ird_id) VALUES (10003,'instrument4','instrument4', 10001);
INSERT INTO public.instrument_ird(id,code,libelle,type_instrument_ird_id) VALUES (10004,'instrument5','instrument5', 10002);
INSERT INTO public.instrument_ird(id,code,libelle,type_instrument_ird_id) VALUES (10005,'instrument6','instrument6', 10002);
INSERT INTO public.instrument_ird(id,code,libelle,type_instrument_ird_id) VALUES (10006,'instrument7','instrument7', 10003);
INSERT INTO public.instrument_ird(id,code,libelle,type_instrument_ird_id) VALUES (10007,'instrument8','instrument8', 10003);

INSERT INTO public.public_cible(id,code,libelle) VALUES (10000, 'public1', 'public1');
INSERT INTO public.public_cible(id,code,libelle) VALUES (10001, 'public2', 'public2');

-- INSERT INTO public.type_publique VALUES (10000, 'type1', 'type1');
-- INSERT INTO public.type_publique VALUES (10001, 'type2', 'type2');
-- INSERT INTO public.type_publique VALUES (10002, 'type3', 'type3');

--
-- INSERT INTO public.enjeux_ird VALUES (682, 'enjeux1', NULL, 'enjeux1');
-- INSERT INTO public.enjeux_ird VALUES (683, 'enjeux2', NULL, 'enjeux2');
-- INSERT INTO public.enjeux_ird VALUES (684, 'enjeux3', NULL, 'enjeux3');
--
-- INSERT INTO public.discipline_scientifique VALUES (688, 'discipline1', 'discipline1');
-- INSERT INTO public.discipline_scientifique VALUES (689, 'discipline2', 'discipline2');
-- INSERT INTO public.discipline_scientifique VALUES (690, 'discipline3', 'discipline3');
--
-- INSERT INTO public.pays VALUES (698, 'fr', NULL, 'France', NULL);
-- INSERT INTO public.pays VALUES (699, 'ma', NULL, 'Maroc', NULL);
-- INSERT INTO public.pays VALUES (700, 'bel', NULL, 'Belgique', NULL);
--
-- INSERT INTO public.public_cible VALUES (704, 'public1', 'public1');
-- INSERT INTO public.public_cible VALUES (705, 'public2', 'public2');
--
-- INSERT INTO public.type_outil VALUES (707, 'typeoutil2', 'type outil2', false);
-- INSERT INTO public.type_outil VALUES (706, 'typeoutil1', 'type outil 1', true);
-- INSERT INTO public.type_outil VALUES (708, 'typeoutil3', 'type outil3', false);

-- INSERT INTO public.langue VALUES (10000, 'fr', 'français');
-- INSERT INTO public.langue VALUES (10001, 'en', 'anglais');
-- INSERT INTO public.langue VALUES (10002, 'es', 'espagnol');
-- INSERT INTO public.langue VALUES (10003, 'de', 'almagne');
--
-- INSERT INTO public.etablissement VALUES (696, NULL, NULL, 'etab2',NULL, 'etab2', NULL, NULL, NULL, NULL, NULL, NULL);
-- INSERT INTO public.etablissement VALUES (697, NULL, NULL, 'etab3', NULL, 'etab3', NULL, NULL, NULL, NULL, NULL, NULL);
-- INSERT INTO public.etablissement VALUES (695, NULL, NULL, 'etab1',NULL, 'etab1', NULL, NULL, NULL, NULL, 698, NULL);

-- Référentien niveau_formation_post_bac

INSERT INTO public.niveau_formation_post_bac (id, admin, archive, code, date_archivage, date_creation, libelle, username, visible) VALUES (1, true, false, '1', NULL, NULL, 'BAC+2', NULL, true);
INSERT INTO public.niveau_formation_post_bac (id, admin, archive, code, date_archivage, date_creation, libelle, username, visible) VALUES (2, true, false, '2', NULL, NULL, 'BAC+5', NULL, true);

-- Réferentiel disciplines scientifiques

INSERT INTO public.discipline_scientifique (id, admin, archive, code, date_archivage, date_creation, libelle_eng, libelle_fr, niveau, username, visible, discipline_scientifique_id, libelle) VALUES (16, false, false, 'D2', NULL, NULL, NULL, NULL, NULL, NULL, true, NULL, 'Discipline 2');
INSERT INTO public.discipline_scientifique (id, admin, archive, code, date_archivage, date_creation, libelle_eng, libelle_fr, niveau, username, visible, discipline_scientifique_id, libelle) VALUES (17, false, false, 'D3', NULL, NULL, NULL, NULL, NULL, NULL, true, NULL, 'Discipline 3');
INSERT INTO public.discipline_scientifique (id, admin, archive, code, date_archivage, date_creation, libelle_eng, libelle_fr, niveau, username, visible, discipline_scientifique_id, libelle) VALUES (15, false, false, 'D1', NULL, NULL, NULL, NULL, NULL, NULL, true, NULL, 'Discipline 1');

-- Réferentiel enjeux IRD

INSERT INTO public.enjeux_ird (id, admin, archive, code, date_archivage, date_creation, description, libelle, username, visible) VALUES (12, false, false, 'EN1', NULL, NULL, '81351', 'Enjeux IRD 1', NULL, true);
INSERT INTO public.enjeux_ird (id, admin, archive, code, date_archivage, date_creation, description, libelle, username, visible) VALUES (13, false, false, 'EN2', NULL, NULL, '81352', 'Enjeux IRD 2', NULL, true);
INSERT INTO public.enjeux_ird (id, admin, archive, code, date_archivage, date_creation, description, libelle, username, visible) VALUES (14, false, false, 'EN3', NULL, NULL, '81353', 'Enjeux IRD 3', NULL, true);

-- Réferentiel responsabilité encadrement étudiant

INSERT INTO public.responsabilite_encadrement_doctorant (id, admin, archive, code, date_archivage, date_creation, libelle, username, visible) VALUES (4, false, false, 'R1', NULL, NULL, 'Encadrement', NULL, true);
INSERT INTO public.responsabilite_encadrement_doctorant (id, admin, archive, code, date_archivage, date_creation, libelle, username, visible) VALUES (5, false, false, 'R2', NULL, NULL, 'Direction', NULL, true);
INSERT INTO public.responsabilite_encadrement_doctorant (id, admin, archive, code, date_archivage, date_creation, libelle, username, visible) VALUES (6, false, false, 'R3', NULL, NULL, 'Non précisé', NULL, true);

