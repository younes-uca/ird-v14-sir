package  com.ird.faa.ws.rest.provided.vo;


public class PublicCibleCultureScientifiqueOutilPedagogiqueVo {

    private String id ;



        private PublicCibleVo publicCibleVo ;
        private CultureScientifiqueOutilPedagogiqueVo cultureScientifiqueOutilPedagogiqueVo ;
        private PaysVo paysVo ;


    public PublicCibleCultureScientifiqueOutilPedagogiqueVo(){
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
        public CultureScientifiqueOutilPedagogiqueVo getCultureScientifiqueOutilPedagogiqueVo(){
        return this.cultureScientifiqueOutilPedagogiqueVo;
        }

        public void setCultureScientifiqueOutilPedagogiqueVo(CultureScientifiqueOutilPedagogiqueVo cultureScientifiqueOutilPedagogiqueVo){
        this.cultureScientifiqueOutilPedagogiqueVo = cultureScientifiqueOutilPedagogiqueVo;
        }
        public PaysVo getPaysVo(){
        return this.paysVo;
        }

        public void setPaysVo(PaysVo paysVo){
        this.paysVo = paysVo;
        }


            }
