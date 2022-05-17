package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import java.math.BigDecimal;

public class BourseVo {

    private String id ;
    private String dateObtention ;
    private String intitule ;
    private String participationIndividuelle ;
    private String montant ;
    private String dureeEnMois ;


            private String dateObtentionMax ;
            private String dateObtentionMin ;
            private String montantMax ;
            private String montantMin ;
            private String dureeEnMoisMax ;
            private String dureeEnMoisMin ;

        private ProjetActiviteRechercheVo projetActiviteRechercheVo ;
        private CampagneVo campagneVo ;
        private ChercheurVo chercheurVo ;


    public BourseVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getDateObtention(){
        return this.dateObtention;
        }

        public void setDateObtention(String dateObtention){
        this.dateObtention = dateObtention;
        }
        public String getIntitule(){
        return this.intitule;
        }

        public void setIntitule(String intitule){
        this.intitule = intitule;
        }
        public String getParticipationIndividuelle(){
        return this.participationIndividuelle;
        }

        public void setParticipationIndividuelle(String participationIndividuelle){
        this.participationIndividuelle = participationIndividuelle;
        }
        public String getMontant(){
        return this.montant;
        }

        public void setMontant(String montant){
        this.montant = montant;
        }
        public String getDureeEnMois(){
        return this.dureeEnMois;
        }

        public void setDureeEnMois(String dureeEnMois){
        this.dureeEnMois = dureeEnMois;
        }


            public String getDateObtentionMax(){
            return this.dateObtentionMax;
            }

            public String getDateObtentionMin(){
            return this.dateObtentionMin;
            }

            public void setDateObtentionMax(String dateObtentionMax){
            this.dateObtentionMax = dateObtentionMax;
            }

            public void setDateObtentionMin(String dateObtentionMin){
            this.dateObtentionMin = dateObtentionMin;
            }

            public String getMontantMax(){
            return this.montantMax;
            }

            public String getMontantMin(){
            return this.montantMin;
            }

            public void setMontantMax(String montantMax){
            this.montantMax = montantMax;
            }

            public void setMontantMin(String montantMin){
            this.montantMin = montantMin;
            }

            public String getDureeEnMoisMax(){
            return this.dureeEnMoisMax;
            }

            public String getDureeEnMoisMin(){
            return this.dureeEnMoisMin;
            }

            public void setDureeEnMoisMax(String dureeEnMoisMax){
            this.dureeEnMoisMax = dureeEnMoisMax;
            }

            public void setDureeEnMoisMin(String dureeEnMoisMin){
            this.dureeEnMoisMin = dureeEnMoisMin;
            }


        public ProjetActiviteRechercheVo getProjetActiviteRechercheVo(){
        return this.projetActiviteRechercheVo;
        }

        public void setProjetActiviteRechercheVo(ProjetActiviteRechercheVo projetActiviteRechercheVo){
        this.projetActiviteRechercheVo = projetActiviteRechercheVo;
        }
        public CampagneVo getCampagneVo(){
        return this.campagneVo;
        }

        public void setCampagneVo(CampagneVo campagneVo){
        this.campagneVo = campagneVo;
        }
        public ChercheurVo getChercheurVo(){
        return this.chercheurVo;
        }

        public void setChercheurVo(ChercheurVo chercheurVo){
        this.chercheurVo = chercheurVo;
        }


            }
