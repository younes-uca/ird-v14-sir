package  com.ird.faa.ws.rest.provided.vo;

    import java.math.BigDecimal;

public class ResponsabilitePedagogiqueEcoleDoctoraleVo {

    private String id ;
    private String annee ;
    private String tempsEstimePourCetteAnnne ;
    private String appelServiceRenforcementCapaciteSud ;
    private String ecoleDoctoraleInternational ;


            private String anneeMax ;
            private String anneeMin ;
            private String tempsEstimePourCetteAnnneMax ;
            private String tempsEstimePourCetteAnnneMin ;

        private StatutEcoleDoctoraleVo statutEcoleDoctoraleVo ;
        private EcoleDoctoraleVo ecoleDoctoraleVo ;
        private EtablissementVo etablissementVo ;
        private EtatEtapeCampagneVo etatEtapeCampagneVo ;
        private ChercheurVo chercheurVo ;
        private CampagneVo campagneVo ;


    public ResponsabilitePedagogiqueEcoleDoctoraleVo(){
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
        public String getTempsEstimePourCetteAnnne(){
        return this.tempsEstimePourCetteAnnne;
        }

        public void setTempsEstimePourCetteAnnne(String tempsEstimePourCetteAnnne){
        this.tempsEstimePourCetteAnnne = tempsEstimePourCetteAnnne;
        }
        public String getAppelServiceRenforcementCapaciteSud(){
        return this.appelServiceRenforcementCapaciteSud;
        }

        public void setAppelServiceRenforcementCapaciteSud(String appelServiceRenforcementCapaciteSud){
        this.appelServiceRenforcementCapaciteSud = appelServiceRenforcementCapaciteSud;
        }
        public String getEcoleDoctoraleInternational(){
        return this.ecoleDoctoraleInternational;
        }

        public void setEcoleDoctoraleInternational(String ecoleDoctoraleInternational){
        this.ecoleDoctoraleInternational = ecoleDoctoraleInternational;
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

            public String getTempsEstimePourCetteAnnneMax(){
            return this.tempsEstimePourCetteAnnneMax;
            }

            public String getTempsEstimePourCetteAnnneMin(){
            return this.tempsEstimePourCetteAnnneMin;
            }

            public void setTempsEstimePourCetteAnnneMax(String tempsEstimePourCetteAnnneMax){
            this.tempsEstimePourCetteAnnneMax = tempsEstimePourCetteAnnneMax;
            }

            public void setTempsEstimePourCetteAnnneMin(String tempsEstimePourCetteAnnneMin){
            this.tempsEstimePourCetteAnnneMin = tempsEstimePourCetteAnnneMin;
            }


        public StatutEcoleDoctoraleVo getStatutEcoleDoctoraleVo(){
        return this.statutEcoleDoctoraleVo;
        }

        public void setStatutEcoleDoctoraleVo(StatutEcoleDoctoraleVo statutEcoleDoctoraleVo){
        this.statutEcoleDoctoraleVo = statutEcoleDoctoraleVo;
        }
        public EcoleDoctoraleVo getEcoleDoctoraleVo(){
        return this.ecoleDoctoraleVo;
        }

        public void setEcoleDoctoraleVo(EcoleDoctoraleVo ecoleDoctoraleVo){
        this.ecoleDoctoraleVo = ecoleDoctoraleVo;
        }
        public EtablissementVo getEtablissementVo(){
        return this.etablissementVo;
        }

        public void setEtablissementVo(EtablissementVo etablissementVo){
        this.etablissementVo = etablissementVo;
        }
        public EtatEtapeCampagneVo getEtatEtapeCampagneVo(){
        return this.etatEtapeCampagneVo;
        }

        public void setEtatEtapeCampagneVo(EtatEtapeCampagneVo etatEtapeCampagneVo){
        this.etatEtapeCampagneVo = etatEtapeCampagneVo;
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


            }
