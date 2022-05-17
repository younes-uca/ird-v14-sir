package  com.ird.faa.ws.rest.provided.vo;


public class EntiteAdministrativeVo {

    private String id ;
    private String libelle ;
    private String code ;
    private String description ;



        private TypeEntiteAdministrativeVo typeEntiteAdministrativeVo ;


    public EntiteAdministrativeVo(){
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
        public String getDescription(){
        return this.description;
        }

        public void setDescription(String description){
        this.description = description;
        }



        public TypeEntiteAdministrativeVo getTypeEntiteAdministrativeVo(){
        return this.typeEntiteAdministrativeVo;
        }

        public void setTypeEntiteAdministrativeVo(TypeEntiteAdministrativeVo typeEntiteAdministrativeVo){
        this.typeEntiteAdministrativeVo = typeEntiteAdministrativeVo;
        }


            }
