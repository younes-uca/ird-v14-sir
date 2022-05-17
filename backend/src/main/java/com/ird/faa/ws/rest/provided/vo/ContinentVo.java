package  com.ird.faa.ws.rest.provided.vo;


public class ContinentVo {

    private String id ;
    private String libelle ;
    private String code ;

    /* TODO add fields */
    private String idGraph;
    /* TODO fin: add fields */





    public ContinentVo(){
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

		public String getIdGraph() {
			return idGraph;
		}

		public void setIdGraph(String idGraph) {
			this.idGraph = idGraph;
		}





            }
