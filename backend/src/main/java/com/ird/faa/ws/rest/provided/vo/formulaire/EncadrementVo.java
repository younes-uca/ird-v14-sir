package main.java.com.ird.faa.ws.rest.provided.vo.formulaire;

    import java.util.List;
    import java.math.BigDecimal;

public class EncadrementVo {

    private String id ;
    private String annee ;
    private String tempsEstimePourCetteAnnne ;


            private String anneeMax ;
            private String anneeMin ;
            private String tempsEstimePourCetteAnnneMax ;
            private String tempsEstimePourCetteAnnneMin ;

        private CampagneVo campagneVo ;
        private ChercheurVo chercheurVo ;
        private EtatEtapeCampagneVo etatEtapeCampagneVo ;

    private List<EncadrementEtudiantVo> encadrementEtudiantsVo ;
    private List<EncadrementDoctorantVo> encadrementDoctorantsVo ;

    public EncadrementVo(){
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
        public EtatEtapeCampagneVo getEtatEtapeCampagneVo(){
        return this.etatEtapeCampagneVo;
        }

        public void setEtatEtapeCampagneVo(EtatEtapeCampagneVo etatEtapeCampagneVo){
        this.etatEtapeCampagneVo = etatEtapeCampagneVo;
        }


        public List<EncadrementEtudiantVo> getEncadrementEtudiantsVo(){
        return this.encadrementEtudiantsVo;
        }

        public void setEncadrementEtudiantsVo(List<EncadrementEtudiantVo> encadrementEtudiantsVo){
            this.encadrementEtudiantsVo = encadrementEtudiantsVo;
            }

        public List<EncadrementDoctorantVo> getEncadrementDoctorantsVo(){
        return this.encadrementDoctorantsVo;
        }

        public void setEncadrementDoctorantsVo(List<EncadrementDoctorantVo> encadrementDoctorantsVo){
            this.encadrementDoctorantsVo = encadrementDoctorantsVo;
            }

            }
