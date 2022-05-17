package  com.ird.faa.ws.rest.provided.vo;


public class InstitutionCoContractantVo {

    private String id ;



        private ChercheurVo chercheurVo ;
        private InstitutionVo institutionVo ;


    public InstitutionCoContractantVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public ChercheurVo getChercheurVo(){
        return this.chercheurVo;
        }

        public void setChercheurVo(ChercheurVo chercheurVo){
        this.chercheurVo = chercheurVo;
        }
        public InstitutionVo getInstitutionVo(){
        return this.institutionVo;
        }

        public void setInstitutionVo(InstitutionVo institutionVo){
        this.institutionVo = institutionVo;
        }


            }
