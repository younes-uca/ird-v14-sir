package  com.ird.faa.ws.rest.provided.vo;


public class OutilPedagogiquePubliqueCibleVo {

    private String id ;



        private PublicCibleVo publicCibleVo ;
        private OutilPedagogiqueVo outilPedagogiqueVo ;


    public OutilPedagogiquePubliqueCibleVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }

        public PublicCibleVo getPublicCibleVo() {
			return publicCibleVo;
		}

		public void setPublicCibleVo(PublicCibleVo publicCibleVo) {
			this.publicCibleVo = publicCibleVo;
		}

		public OutilPedagogiqueVo getOutilPedagogiqueVo(){
        return this.outilPedagogiqueVo;
        }

        public void setOutilPedagogiqueVo(OutilPedagogiqueVo outilPedagogiqueVo){
        this.outilPedagogiqueVo = outilPedagogiqueVo;
        }


            }
