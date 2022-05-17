package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class CampagneRelanceChercheurVo {

    private String id ;
    private String objet ;
    private String message ;
    private String envoye ;
    private String dateEnvoi ;


            private String dateEnvoiMax ;
            private String dateEnvoiMin ;

        private ChercheurVo chercheurVo ;
        private CampagneRelanceVo campagneRelanceVo ;


    public CampagneRelanceChercheurVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getObjet(){
        return this.objet;
        }

        public void setObjet(String objet){
        this.objet = objet;
        }
        public String getMessage(){
        return this.message;
        }

        public void setMessage(String message){
        this.message = message;
        }
        public String getEnvoye(){
        return this.envoye;
        }

        public void setEnvoye(String envoye){
        this.envoye = envoye;
        }
        public String getDateEnvoi(){
        return this.dateEnvoi;
        }

        public void setDateEnvoi(String dateEnvoi){
        this.dateEnvoi = dateEnvoi;
        }


            public String getDateEnvoiMax(){
            return this.dateEnvoiMax;
            }

            public String getDateEnvoiMin(){
            return this.dateEnvoiMin;
            }

            public void setDateEnvoiMax(String dateEnvoiMax){
            this.dateEnvoiMax = dateEnvoiMax;
            }

            public void setDateEnvoiMin(String dateEnvoiMin){
            this.dateEnvoiMin = dateEnvoiMin;
            }


        public ChercheurVo getChercheurVo(){
        return this.chercheurVo;
        }

        public void setChercheurVo(ChercheurVo chercheurVo){
        this.chercheurVo = chercheurVo;
        }
        public CampagneRelanceVo getCampagneRelanceVo(){
        return this.campagneRelanceVo;
        }

        public void setCampagneRelanceVo(CampagneRelanceVo campagneRelanceVo){
        this.campagneRelanceVo = campagneRelanceVo;
        }


            }
