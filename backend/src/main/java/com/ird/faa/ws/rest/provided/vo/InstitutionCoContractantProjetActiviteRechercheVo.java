package  com.ird.faa.ws.rest.provided.vo;


public class InstitutionCoContractantProjetActiviteRechercheVo {

    private String id ;



        private InstitutionCoContractantVo institutionCoContractantVo ;
        private ProjetActiviteRechercheVo projetActiviteRechercheVo ;


    public InstitutionCoContractantProjetActiviteRechercheVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public InstitutionCoContractantVo getInstitutionCoContractantVo(){
        return this.institutionCoContractantVo;
        }

        public void setInstitutionCoContractantVo(InstitutionCoContractantVo institutionCoContractantVo){
        this.institutionCoContractantVo = institutionCoContractantVo;
        }
        public ProjetActiviteRechercheVo getProjetActiviteRechercheVo(){
        return this.projetActiviteRechercheVo;
        }

        public void setProjetActiviteRechercheVo(ProjetActiviteRechercheVo projetActiviteRechercheVo){
        this.projetActiviteRechercheVo = projetActiviteRechercheVo;
        }


            }
