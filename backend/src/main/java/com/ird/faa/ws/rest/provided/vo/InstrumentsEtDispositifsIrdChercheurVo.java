package  com.ird.faa.ws.rest.provided.vo;


public class InstrumentsEtDispositifsIrdChercheurVo {

    private String id ;



        private TypeInstrumentsEtDispositifsIrdVo typeInstrumentsEtDispositifsIrdVo ;
        private ChercheurVo chercheurVo ;


    public InstrumentsEtDispositifsIrdChercheurVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public TypeInstrumentsEtDispositifsIrdVo getTypeInstrumentsEtDispositifsIrdVo(){
        return this.typeInstrumentsEtDispositifsIrdVo;
        }

        public void setTypeInstrumentsEtDispositifsIrdVo(TypeInstrumentsEtDispositifsIrdVo typeInstrumentsEtDispositifsIrdVo){
        this.typeInstrumentsEtDispositifsIrdVo = typeInstrumentsEtDispositifsIrdVo;
        }
        public ChercheurVo getChercheurVo(){
        return this.chercheurVo;
        }

        public void setChercheurVo(ChercheurVo chercheurVo){
        this.chercheurVo = chercheurVo;
        }


            }
