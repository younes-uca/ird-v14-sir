package  com.ird.faa.ws.rest.provided.vo;


public class EtablissementEncadrementDoctorantVo {

    private String id ;



        private EtablissementVo etablissementVo ;
        private EncadrementDoctorantVo encadrementDoctorantVo ;


    public EtablissementEncadrementDoctorantVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public EtablissementVo getEtablissementVo(){
        return this.etablissementVo;
        }

        public void setEtablissementVo(EtablissementVo etablissementVo){
        this.etablissementVo = etablissementVo;
        }
        public EncadrementDoctorantVo getEncadrementDoctorantVo(){
        return this.encadrementDoctorantVo;
        }

        public void setEncadrementDoctorantVo(EncadrementDoctorantVo encadrementDoctorantVo){
        this.encadrementDoctorantVo = encadrementDoctorantVo;
        }


            }
