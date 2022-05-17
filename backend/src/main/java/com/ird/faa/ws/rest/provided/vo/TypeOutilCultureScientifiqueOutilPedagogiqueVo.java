package  com.ird.faa.ws.rest.provided.vo;


public class TypeOutilCultureScientifiqueOutilPedagogiqueVo {

    private String id ;



        private CultureScientifiqueOutilPedagogiqueVo cultureScientifiqueOutilPedagogiqueVo ;
        private TypeOutilVo typeOutilVo ;


    public TypeOutilCultureScientifiqueOutilPedagogiqueVo(){
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
        public TypeOutilVo getTypeOutilVo(){
        return this.typeOutilVo;
        }

        public void setTypeOutilVo(TypeOutilVo typeOutilVo){
        this.typeOutilVo = typeOutilVo;
        }


            }
