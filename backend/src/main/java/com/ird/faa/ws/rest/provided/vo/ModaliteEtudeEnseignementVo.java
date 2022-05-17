package  com.ird.faa.ws.rest.provided.vo;


public class ModaliteEtudeEnseignementVo {

    private String id ;



        private ModaliteEtudeVo modaliteEtudeVo ;
        private EnseignementVo enseignementVo ;


    public ModaliteEtudeEnseignementVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public ModaliteEtudeVo getModaliteEtudeVo(){
        return this.modaliteEtudeVo;
        }

        public void setModaliteEtudeVo(ModaliteEtudeVo modaliteEtudeVo){
        this.modaliteEtudeVo = modaliteEtudeVo;
        }
        public EnseignementVo getEnseignementVo(){
        return this.enseignementVo;
        }

        public void setEnseignementVo(EnseignementVo enseignementVo){
        this.enseignementVo = enseignementVo;
        }


            }
