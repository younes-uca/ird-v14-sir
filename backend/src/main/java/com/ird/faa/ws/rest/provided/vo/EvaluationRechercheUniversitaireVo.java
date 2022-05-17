package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;
    import java.math.BigDecimal;

public class EvaluationRechercheUniversitaireVo {

    private String id ;
    private String annee ;
    private String nombreJourConsacrePourCetteAnnee ;
    private String commentaire ;


            private String anneeMax ;
            private String anneeMin ;
            private String nombreJourConsacrePourCetteAnneeMax ;
            private String nombreJourConsacrePourCetteAnneeMin ;

        private TypeExpertVo typeExpertVo ;
        private RoleEvaluationRechercheUniversitaireVo roleEvaluationRechercheUniversitaireVo ;
        private PaysVo paysVo ;
        private EtablissementVo etablissementVo ;
        private ChercheurVo chercheurVo ;
        private CampagneVo campagneVo ;
        private EtatEtapeCampagneVo etatEtapeCampagneVo ;

    private List<CommunauteSavoirEvaluationRechercheUniversitaireVo> communauteSavoirEvaluationRechercheUniversitairesVo ;
    private List<DisciplineScientifiqueEvaluationRechercheUniversitaireVo> disciplineScientifiqueEvaluationRechercheUniversitairesVo ;

    public EvaluationRechercheUniversitaireVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getAnnee(){
        return this.annee;
        }

        public void setAnnee(String annee){
        this.annee = annee;
        }
        public String getNombreJourConsacrePourCetteAnnee(){
        return this.nombreJourConsacrePourCetteAnnee;
        }

        public void setNombreJourConsacrePourCetteAnnee(String nombreJourConsacrePourCetteAnnee){
        this.nombreJourConsacrePourCetteAnnee = nombreJourConsacrePourCetteAnnee;
        }
        public String getCommentaire(){
        return this.commentaire;
        }

        public void setCommentaire(String commentaire){
        this.commentaire = commentaire;
        }


            public String getAnneeMax(){
            return this.anneeMax;
            }

            public String getAnneeMin(){
            return this.anneeMin;
            }

            public void setAnneeMax(String anneeMax){
            this.anneeMax = anneeMax;
            }

            public void setAnneeMin(String anneeMin){
            this.anneeMin = anneeMin;
            }

            public String getNombreJourConsacrePourCetteAnneeMax(){
            return this.nombreJourConsacrePourCetteAnneeMax;
            }

            public String getNombreJourConsacrePourCetteAnneeMin(){
            return this.nombreJourConsacrePourCetteAnneeMin;
            }

            public void setNombreJourConsacrePourCetteAnneeMax(String nombreJourConsacrePourCetteAnneeMax){
            this.nombreJourConsacrePourCetteAnneeMax = nombreJourConsacrePourCetteAnneeMax;
            }

            public void setNombreJourConsacrePourCetteAnneeMin(String nombreJourConsacrePourCetteAnneeMin){
            this.nombreJourConsacrePourCetteAnneeMin = nombreJourConsacrePourCetteAnneeMin;
            }


        public TypeExpertVo getTypeExpertVo(){
        return this.typeExpertVo;
        }

        public void setTypeExpertVo(TypeExpertVo typeExpertVo){
        this.typeExpertVo = typeExpertVo;
        }
        public RoleEvaluationRechercheUniversitaireVo getRoleEvaluationRechercheUniversitaireVo(){
        return this.roleEvaluationRechercheUniversitaireVo;
        }

        public void setRoleEvaluationRechercheUniversitaireVo(RoleEvaluationRechercheUniversitaireVo roleEvaluationRechercheUniversitaireVo){
        this.roleEvaluationRechercheUniversitaireVo = roleEvaluationRechercheUniversitaireVo;
        }
        public PaysVo getPaysVo(){
        return this.paysVo;
        }

        public void setPaysVo(PaysVo paysVo){
        this.paysVo = paysVo;
        }
        public EtablissementVo getEtablissementVo(){
        return this.etablissementVo;
        }

        public void setEtablissementVo(EtablissementVo etablissementVo){
        this.etablissementVo = etablissementVo;
        }
        public ChercheurVo getChercheurVo(){
        return this.chercheurVo;
        }

        public void setChercheurVo(ChercheurVo chercheurVo){
        this.chercheurVo = chercheurVo;
        }
        public CampagneVo getCampagneVo(){
        return this.campagneVo;
        }

        public void setCampagneVo(CampagneVo campagneVo){
        this.campagneVo = campagneVo;
        }
        public EtatEtapeCampagneVo getEtatEtapeCampagneVo(){
        return this.etatEtapeCampagneVo;
        }

        public void setEtatEtapeCampagneVo(EtatEtapeCampagneVo etatEtapeCampagneVo){
        this.etatEtapeCampagneVo = etatEtapeCampagneVo;
        }


        public List<CommunauteSavoirEvaluationRechercheUniversitaireVo> getCommunauteSavoirEvaluationRechercheUniversitairesVo(){
        return this.communauteSavoirEvaluationRechercheUniversitairesVo;
        }

        public void setCommunauteSavoirEvaluationRechercheUniversitairesVo(List<CommunauteSavoirEvaluationRechercheUniversitaireVo> communauteSavoirEvaluationRechercheUniversitairesVo){
            this.communauteSavoirEvaluationRechercheUniversitairesVo = communauteSavoirEvaluationRechercheUniversitairesVo;
            }

        public List<DisciplineScientifiqueEvaluationRechercheUniversitaireVo> getDisciplineScientifiqueEvaluationRechercheUniversitairesVo(){
        return this.disciplineScientifiqueEvaluationRechercheUniversitairesVo;
        }

        public void setDisciplineScientifiqueEvaluationRechercheUniversitairesVo(List<DisciplineScientifiqueEvaluationRechercheUniversitaireVo> disciplineScientifiqueEvaluationRechercheUniversitairesVo){
            this.disciplineScientifiqueEvaluationRechercheUniversitairesVo = disciplineScientifiqueEvaluationRechercheUniversitairesVo;
            }

            }
