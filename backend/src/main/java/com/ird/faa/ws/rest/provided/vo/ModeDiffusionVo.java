package  com.ird.faa.ws.rest.provided.vo;


public class ModeDiffusionVo {

    private String id ;
    private String libelle ;
    private String code ;



        private TypeSavoirVo typeSavoirVo ;


    public ModeDiffusionVo(){
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



        public TypeSavoirVo getTypeSavoirVo(){
        return this.typeSavoirVo;
        }

        public void setTypeSavoirVo(TypeSavoirVo typeSavoirVo){
        this.typeSavoirVo = typeSavoirVo;
        }


            }
