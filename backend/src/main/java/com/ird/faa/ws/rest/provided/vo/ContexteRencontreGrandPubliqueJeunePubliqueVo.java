package  com.ird.faa.ws.rest.provided.vo;


public class ContexteRencontreGrandPubliqueJeunePubliqueVo {

    private String id ;



        private RencontreGrandPubliqueJeunePubliqueVo rencontreGrandPubliqueJeunePubliqueVo ;
        private ContexteVo contexteVo ;


    public ContexteRencontreGrandPubliqueJeunePubliqueVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public RencontreGrandPubliqueJeunePubliqueVo getRencontreGrandPubliqueJeunePubliqueVo(){
        return this.rencontreGrandPubliqueJeunePubliqueVo;
        }

        public void setRencontreGrandPubliqueJeunePubliqueVo(RencontreGrandPubliqueJeunePubliqueVo rencontreGrandPubliqueJeunePubliqueVo){
        this.rencontreGrandPubliqueJeunePubliqueVo = rencontreGrandPubliqueJeunePubliqueVo;
        }
        public ContexteVo getContexteVo(){
        return this.contexteVo;
        }

        public void setContexteVo(ContexteVo contexteVo){
        this.contexteVo = contexteVo;
        }


            }
