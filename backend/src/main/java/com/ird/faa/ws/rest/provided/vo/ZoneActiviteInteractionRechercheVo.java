package  com.ird.faa.ws.rest.provided.vo;


public class ZoneActiviteInteractionRechercheVo {

    private String id ;



        private PaysVo paysVo ;
        private ChercheurVo chercheurVo ;


    public ZoneActiviteInteractionRechercheVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public PaysVo getPaysVo(){
        return this.paysVo;
        }

        public void setPaysVo(PaysVo paysVo){
        this.paysVo = paysVo;
        }
        public ChercheurVo getChercheurVo(){
        return this.chercheurVo;
        }

        public void setChercheurVo(ChercheurVo chercheurVo){
        this.chercheurVo = chercheurVo;
        }


            }
