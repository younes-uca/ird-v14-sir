package  com.ird.faa.ws.rest.provided.vo;


public class OrganismeVo {

    private String id ;
    private String intitule ;
    private String code ;
    private String description ;
    private PaysVo paysVo ;





    public OrganismeVo(){
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
        public String getCode(){
        return this.code;
        }

        public void setCode(String code){
        this.code = code;
        }
        public String getDescription(){
        return this.description;
        }

        public void setDescription(String description){
        this.description = description;
        }

		public PaysVo getPaysVo() {
			return paysVo;
		}

		public void setPaysVo(PaysVo paysVo) {
			this.paysVo = paysVo;
		}





            }
