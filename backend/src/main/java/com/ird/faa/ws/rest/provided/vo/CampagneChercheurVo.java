package  com.ird.faa.ws.rest.provided.vo;

    import java.math.BigDecimal;

public class CampagneChercheurVo {

    private String id ;
    private String avancement ;


            private String avancementMax ;
            private String avancementMin ;

        private ChercheurVo chercheurVo ;
        private CampagneVo campagneVo ;
        private EtatCampagneChercheurVo etatCampagneChercheurVo ;


    public CampagneChercheurVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getAvancement(){
        return this.avancement;
        }

        public void setAvancement(String avancement){
        this.avancement = avancement;
        }


            public String getAvancementMax(){
            return this.avancementMax;
            }

            public String getAvancementMin(){
            return this.avancementMin;
            }

            public void setAvancementMax(String avancementMax){
            this.avancementMax = avancementMax;
            }

            public void setAvancementMin(String avancementMin){
            this.avancementMin = avancementMin;
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
        public EtatCampagneChercheurVo getEtatCampagneChercheurVo(){
        return this.etatCampagneChercheurVo;
        }

        public void setEtatCampagneChercheurVo(EtatCampagneChercheurVo etatCampagneChercheurVo){
        this.etatCampagneChercheurVo = etatCampagneChercheurVo;
        }


            }
