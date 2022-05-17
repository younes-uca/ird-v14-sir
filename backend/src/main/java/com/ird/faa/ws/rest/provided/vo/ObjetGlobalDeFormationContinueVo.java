package  com.ird.faa.ws.rest.provided.vo;


public class ObjetGlobalDeFormationContinueVo {

    private String id ;



        private ObjetGlobalVo objetGlobalVo ;
        private FormationContinueVo formationContinueVo ;


    public ObjetGlobalDeFormationContinueVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public ObjetGlobalVo getObjetGlobalVo(){
        return this.objetGlobalVo;
        }

        public void setObjetGlobalVo(ObjetGlobalVo objetGlobalVo){
        this.objetGlobalVo = objetGlobalVo;
        }
        public FormationContinueVo getFormationContinueVo(){
        return this.formationContinueVo;
        }

        public void setFormationContinueVo(FormationContinueVo formationContinueVo){
        this.formationContinueVo = formationContinueVo;
        }


            }
