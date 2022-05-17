package  com.ird.faa.ws.rest.provided.vo;


public class DoctorantVo {

    private String id ;
    private String civilite;
    private String nom ;
    private String prenom ;
    private String anneeNaissance ;


            private String anneeNaissanceMax ;
            private String anneeNaissanceMin ;

        private SexeVo sexeVo ;
        private PaysVo paysVo ;


    public DoctorantVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getNom(){
        return this.nom;
        }

        public void setNom(String nom){
        this.nom = nom;
        }
        public String getPrenom(){
        return this.prenom;
        }

        public void setPrenom(String prenom){
        this.prenom = prenom;
        }
        public String getAnneeNaissance(){
        return this.anneeNaissance;
        }

        public void setAnneeNaissance(String anneeNaissance){
        this.anneeNaissance = anneeNaissance;
        }


            public String getAnneeNaissanceMax(){
            return this.anneeNaissanceMax;
            }

            public String getAnneeNaissanceMin(){
            return this.anneeNaissanceMin;
            }

            public void setAnneeNaissanceMax(String anneeNaissanceMax){
            this.anneeNaissanceMax = anneeNaissanceMax;
            }

            public void setAnneeNaissanceMin(String anneeNaissanceMin){
            this.anneeNaissanceMin = anneeNaissanceMin;
            }


        public SexeVo getSexeVo(){
        return this.sexeVo;
        }

        public void setSexeVo(SexeVo sexeVo){
        this.sexeVo = sexeVo;
        }
        public PaysVo getPaysVo(){
        return this.paysVo;
        }

        public void setPaysVo(PaysVo paysVo){
        this.paysVo = paysVo;
        }

		public String getCivilite() {
			return civilite;
		}

		public void setCivilite(String civilite) {
			this.civilite = civilite;
		}

        

            }
