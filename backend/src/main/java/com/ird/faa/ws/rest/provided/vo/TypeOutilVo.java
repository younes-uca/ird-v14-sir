package  com.ird.faa.ws.rest.provided.vo;


public class TypeOutilVo {

    private String id ;
    private String libelle ;
    private String code ;
    private Boolean numerique ;






    public Boolean getNumerique() {
		return numerique;
	}

	public void setNumerique(Boolean numerique) {
		this.numerique = numerique;
	}

	public TypeOutilVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getLibelle(){
        return this.libelle;
        }

        public void setLibelle(String libelle){
        this.libelle = libelle;
        }
        public String getCode(){
        return this.code;
        }

        public void setCode(String code){
        this.code = code;
        }





            }
