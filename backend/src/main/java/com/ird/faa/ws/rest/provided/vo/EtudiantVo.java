package  com.ird.faa.ws.rest.provided.vo;

public class EtudiantVo {

    private String id ;
    private String nom ;
    private String prenom ;
	private Boolean archive;
	private String dateArchivage;


	private String dateArchivageMax;
	private String dateArchivageMin;

        private SexeVo sexeVo ;
        private PaysVo paysVo ;


    public EtudiantVo(){
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

	public Boolean getArchive() {
		return this.archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public String getDateArchivage() {
		return this.dateArchivage;
        }

	public void setDateArchivage(String dateArchivage) {
		this.dateArchivage = dateArchivage;
        }


	public String getDateArchivageMax() {
		return this.dateArchivageMax;
            }

	public String getDateArchivageMin() {
		return this.dateArchivageMin;
            }

	public void setDateArchivageMax(String dateArchivageMax) {
		this.dateArchivageMax = dateArchivageMax;
            }

	public void setDateArchivageMin(String dateArchivageMin) {
		this.dateArchivageMin = dateArchivageMin;
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


            }
