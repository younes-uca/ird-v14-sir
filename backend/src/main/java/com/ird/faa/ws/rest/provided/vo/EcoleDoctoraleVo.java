package  com.ird.faa.ws.rest.provided.vo;


public class EcoleDoctoraleVo {

    private String id ;
    private String intitule ;
    private String international ;



        private PaysVo paysVo ;


    public EcoleDoctoraleVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getIntitule(){
        return this.intitule;
        }

        public void setIntitule(String intitule){
        this.intitule = intitule;
        }
        public String getInternational(){
        return this.international;
        }

        public void setInternational(String international){
        this.international = international;
        }



        public PaysVo getPaysVo(){
        return this.paysVo;
        }

        public void setPaysVo(PaysVo paysVo){
        this.paysVo = paysVo;
        }


            }
