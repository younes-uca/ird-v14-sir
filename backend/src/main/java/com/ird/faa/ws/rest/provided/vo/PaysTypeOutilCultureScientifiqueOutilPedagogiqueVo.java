package  com.ird.faa.ws.rest.provided.vo;


public class PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo {

    private String id ;



        private CultureScientifiqueOutilPedagogiqueVo cultureScientifiqueOutilPedagogiqueVo ;
        private PaysVo paysVo ;


    public PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
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
