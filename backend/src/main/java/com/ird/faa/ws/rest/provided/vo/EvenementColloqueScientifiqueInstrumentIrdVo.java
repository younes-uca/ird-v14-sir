package  com.ird.faa.ws.rest.provided.vo;


public class EvenementColloqueScientifiqueInstrumentIrdVo {

    private String id ;



        private EvenementColloqueScienntifiqueVo evenementColloqueScienntifiqueVo ;
        private InstrumentIrdVo instrumentIrdVo ;


    public EvenementColloqueScientifiqueInstrumentIrdVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public EvenementColloqueScienntifiqueVo getEvenementColloqueScienntifiqueVo(){
        return this.evenementColloqueScienntifiqueVo;
        }

        public void setEvenementColloqueScienntifiqueVo(EvenementColloqueScienntifiqueVo evenementColloqueScienntifiqueVo){
        this.evenementColloqueScienntifiqueVo = evenementColloqueScienntifiqueVo;
        }
        public InstrumentIrdVo getInstrumentIrdVo(){
        return this.instrumentIrdVo;
        }

        public void setInstrumentIrdVo(InstrumentIrdVo instrumentIrdVo){
        this.instrumentIrdVo = instrumentIrdVo;
        }


            }
