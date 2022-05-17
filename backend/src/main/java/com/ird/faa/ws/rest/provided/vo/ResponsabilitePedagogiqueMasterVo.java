package  com.ird.faa.ws.rest.provided.vo;

    import java.math.BigDecimal;

public class ResponsabilitePedagogiqueMasterVo {

    private String id ;
    private String annee ;
    private String tempsEstimePourCetteAnnne ;
    private String appelServiceRenforcementCapaciteSud ;
    private String masterInternational ;


            private String anneeMax ;
            private String anneeMin ;
            private String tempsEstimePourCetteAnnneMax ;
            private String tempsEstimePourCetteAnnneMin ;

        private StatutMasterVo statutMasterVo ;
        private MasterVo masterVo ;
        private EtablissementVo etablissementVo ;
        private EtatEtapeCampagneVo etatEtapeCampagneVo ;
        private ChercheurVo chercheurVo ;
        private CampagneVo campagneVo ;


    public ResponsabilitePedagogiqueMasterVo(){
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
        public String getMasterInternational(){
        return this.masterInternational;
        }

        public void setMasterInternational(String masterInternational){
        this.masterInternational = masterInternational;
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


        public StatutMasterVo getStatutMasterVo(){
        return this.statutMasterVo;
        }

        public void setStatutMasterVo(StatutMasterVo statutMasterVo){
        this.statutMasterVo = statutMasterVo;
        }
        public MasterVo getMasterVo(){
        return this.masterVo;
        }

        public void setMasterVo(MasterVo masterVo){
        this.masterVo = masterVo;
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
