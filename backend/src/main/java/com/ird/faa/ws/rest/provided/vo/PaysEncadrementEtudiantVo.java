package  com.ird.faa.ws.rest.provided.vo;


public class PaysEncadrementEtudiantVo {

    private String id ;



        private PaysVo paysVo ;
        private EncadrementEtudiantVo encadrementEtudiantVo ;


    public PaysEncadrementEtudiantVo(){
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
        public EncadrementEtudiantVo getEncadrementEtudiantVo(){
        return this.encadrementEtudiantVo;
        }

        public void setEncadrementEtudiantVo(EncadrementEtudiantVo encadrementEtudiantVo){
        this.encadrementEtudiantVo = encadrementEtudiantVo;
        }


            }
