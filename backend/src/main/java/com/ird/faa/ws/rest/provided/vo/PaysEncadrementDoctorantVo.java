package  com.ird.faa.ws.rest.provided.vo;


public class PaysEncadrementDoctorantVo {

    private String id ;



        private PaysVo paysVo ;
        private EncadrementDoctorantVo encadrementDoctorantVo ;


    public PaysEncadrementDoctorantVo(){
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
        public EncadrementDoctorantVo getEncadrementDoctorantVo(){
        return this.encadrementDoctorantVo;
        }

        public void setEncadrementDoctorantVo(EncadrementDoctorantVo encadrementDoctorantVo){
        this.encadrementDoctorantVo = encadrementDoctorantVo;
        }


            }
