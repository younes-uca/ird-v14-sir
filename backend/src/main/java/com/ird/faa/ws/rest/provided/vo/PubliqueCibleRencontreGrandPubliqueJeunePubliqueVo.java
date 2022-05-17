package  com.ird.faa.ws.rest.provided.vo;


public class PubliqueCibleRencontreGrandPubliqueJeunePubliqueVo {

    private String id ;



        private PubliqueCibleRencontreVo publiqueCibleRencontreVo ;
        private RencontreGrandPubliqueJeunePubliqueVo rencontreGrandPubliqueJeunePubliqueVo ;


    public PubliqueCibleRencontreGrandPubliqueJeunePubliqueVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public PubliqueCibleRencontreVo getPubliqueCibleRencontreVo(){
        return this.publiqueCibleRencontreVo;
        }

        public void setPubliqueCibleRencontreVo(PubliqueCibleRencontreVo publiqueCibleRencontreVo){
        this.publiqueCibleRencontreVo = publiqueCibleRencontreVo;
        }
        public RencontreGrandPubliqueJeunePubliqueVo getRencontreGrandPubliqueJeunePubliqueVo(){
        return this.rencontreGrandPubliqueJeunePubliqueVo;
        }

        public void setRencontreGrandPubliqueJeunePubliqueVo(RencontreGrandPubliqueJeunePubliqueVo rencontreGrandPubliqueJeunePubliqueVo){
        this.rencontreGrandPubliqueJeunePubliqueVo = rencontreGrandPubliqueJeunePubliqueVo;
        }


            }
