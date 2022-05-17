package  com.ird.faa.ws.rest.provided.vo;


public class DomaineScientifiqueChercheurVo {

    private String id ;



        private DomaineScientifiqueVo domaineScientifiqueVo ;
        private ChercheurVo chercheurVo ;


    public DomaineScientifiqueChercheurVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public DomaineScientifiqueVo getDomaineScientifiqueVo(){
        return this.domaineScientifiqueVo;
        }

        public void setDomaineScientifiqueVo(DomaineScientifiqueVo domaineScientifiqueVo){
        this.domaineScientifiqueVo = domaineScientifiqueVo;
        }
        public ChercheurVo getChercheurVo(){
        return this.chercheurVo;
        }

        public void setChercheurVo(ChercheurVo chercheurVo){
        this.chercheurVo = chercheurVo;
        }


            }
