package  com.ird.faa.ws.rest.provided.vo;


public class PaysVo {

    private String id ;
    private String libelle ;
    private String code ;
    /* TODO:add fields*/
    private String idGraph;
    /* TODO: fin add fields*/



        private ContinentVo continentVo ;


    public PaysVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getLibelle(){
        return this.libelle;
        }

        public void setLibelle(String libelle){
        this.libelle = libelle;
        }
        public String getCode(){
        return this.code;
        }

        public void setCode(String code){
        this.code = code;
        }



        public ContinentVo getContinentVo(){
        return this.continentVo;
        }

        public void setContinentVo(ContinentVo continentVo){
        this.continentVo = continentVo;
        }

		public String getIdGraph() {
			return idGraph;
		}

		public void setIdGraph(String idGraph) {
			this.idGraph = idGraph;
		}


            }
