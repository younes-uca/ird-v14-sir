package  com.ird.faa.ws.rest.provided.vo;


public class PublicCibleCultureScientifiqueRecontreGrandPublicVo {

    private String id ;



        private PublicCibleVo publicCibleVo ;
        private PaysVo paysVo ;
        private CultureScientifiqueRecontreGrandPublicJeunePublicVo cultureScientifiqueRecontreGrandPublicJeunePublicVo ;


    public PublicCibleCultureScientifiqueRecontreGrandPublicVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public PublicCibleVo getPublicCibleVo(){
        return this.publicCibleVo;
        }

        public void setPublicCibleVo(PublicCibleVo publicCibleVo){
        this.publicCibleVo = publicCibleVo;
        }
        public PaysVo getPaysVo(){
        return this.paysVo;
        }

        public void setPaysVo(PaysVo paysVo){
        this.paysVo = paysVo;
        }
        public CultureScientifiqueRecontreGrandPublicJeunePublicVo getCultureScientifiqueRecontreGrandPublicJeunePublicVo(){
        return this.cultureScientifiqueRecontreGrandPublicJeunePublicVo;
        }

        public void setCultureScientifiqueRecontreGrandPublicJeunePublicVo(CultureScientifiqueRecontreGrandPublicJeunePublicVo cultureScientifiqueRecontreGrandPublicJeunePublicVo){
        this.cultureScientifiqueRecontreGrandPublicJeunePublicVo = cultureScientifiqueRecontreGrandPublicJeunePublicVo;
        }


            }
