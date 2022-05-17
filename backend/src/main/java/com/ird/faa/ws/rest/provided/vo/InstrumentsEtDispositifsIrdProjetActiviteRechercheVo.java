package  com.ird.faa.ws.rest.provided.vo;


public class InstrumentsEtDispositifsIrdProjetActiviteRechercheVo {

    private String id ;



        private ProjetActiviteRechercheVo projetActiviteRechercheVo ;
        private InstrumentsEtDispositifsIrdVo instrumentsEtDispositifsIrdVo ;


    public InstrumentsEtDispositifsIrdProjetActiviteRechercheVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public ProjetActiviteRechercheVo getProjetActiviteRechercheVo(){
        return this.projetActiviteRechercheVo;
        }

        public void setProjetActiviteRechercheVo(ProjetActiviteRechercheVo projetActiviteRechercheVo){
        this.projetActiviteRechercheVo = projetActiviteRechercheVo;
        }
        public InstrumentsEtDispositifsIrdVo getInstrumentsEtDispositifsIrdVo(){
        return this.instrumentsEtDispositifsIrdVo;
        }

        public void setInstrumentsEtDispositifsIrdVo(InstrumentsEtDispositifsIrdVo instrumentsEtDispositifsIrdVo){
        this.instrumentsEtDispositifsIrdVo = instrumentsEtDispositifsIrdVo;
        }


            }
