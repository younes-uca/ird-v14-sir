package  com.ird.faa.ws.rest.provided.vo;


public class PubliquePrincipalConcemeFormationContinueVo {

    private String id ;



        private PubliquePrincipalVo publiquePrincipalVo ;
        private FormationContinueVo formationContinueVo ;


    public PubliquePrincipalConcemeFormationContinueVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public PubliquePrincipalVo getPubliquePrincipalVo(){
        return this.publiquePrincipalVo;
        }

        public void setPubliquePrincipalVo(PubliquePrincipalVo publiquePrincipalVo){
        this.publiquePrincipalVo = publiquePrincipalVo;
        }
        public FormationContinueVo getFormationContinueVo(){
        return this.formationContinueVo;
        }

        public void setFormationContinueVo(FormationContinueVo formationContinueVo){
        this.formationContinueVo = formationContinueVo;
        }


            }
