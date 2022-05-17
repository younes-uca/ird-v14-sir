package  com.ird.faa.ws.rest.provided.vo;


public class EtablissementCultureScientifiqueOutilPedagogiqueVo {

    private String id ;



        private CultureScientifiqueOutilPedagogiqueVo cultureScientifiqueOutilPedagogiqueVo ;
        private EtablissementVo etablissementVo ;


    public EtablissementCultureScientifiqueOutilPedagogiqueVo(){
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
        public EtablissementVo getEtablissementVo(){
        return this.etablissementVo;
        }

        public void setEtablissementVo(EtablissementVo etablissementVo){
        this.etablissementVo = etablissementVo;
        }


            }
