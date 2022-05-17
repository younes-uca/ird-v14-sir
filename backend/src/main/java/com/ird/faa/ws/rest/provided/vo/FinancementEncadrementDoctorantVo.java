package  com.ird.faa.ws.rest.provided.vo;


public class FinancementEncadrementDoctorantVo {

    private String id ;



        private FinancementDoctorantVo financementDoctorantVo ;
        private EncadrementDoctorantVo encadrementDoctorantVo ;


    public FinancementEncadrementDoctorantVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public FinancementDoctorantVo getFinancementDoctorantVo(){
        return this.financementDoctorantVo;
        }

        public void setFinancementDoctorantVo(FinancementDoctorantVo financementDoctorantVo){
        this.financementDoctorantVo = financementDoctorantVo;
        }
        public EncadrementDoctorantVo getEncadrementDoctorantVo(){
        return this.encadrementDoctorantVo;
        }

        public void setEncadrementDoctorantVo(EncadrementDoctorantVo encadrementDoctorantVo){
        this.encadrementDoctorantVo = encadrementDoctorantVo;
        }


            }
