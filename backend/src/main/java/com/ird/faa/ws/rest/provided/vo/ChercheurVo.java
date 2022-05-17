package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;
    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class ChercheurVo {

    private String id ;
    private String numeroMatricule ;
    private String email ;
    private String natureImplication ;
    private String resume ;
    private String formationEnManagement ;
    private String credentialsNonExpired ;
    private String enabled ;
    private String createdAt ;
    private String updatedAt ;
    private String accountNonExpired ;
    private String accountNonLocked ;
    private String username ;
    private String password ;
    private String prenom ;
    private String nom ;
    private String role ;
    private String passwordChanged ;


            private String createdAtMax ;
            private String createdAtMin ;
            private String updatedAtMax ;
            private String updatedAtMin ;

            /*TODO: debut Added fields */
            private String idGraph;
            private String civilite;
            //usage est un nom
            //matricule est numeroMatricule
            private String intitulePoste;
            private Boolean sorgho;
        	private Boolean valide;
        	private String typeEffectif;
        	private String domaineActivite;
        	private String nomNaissance;
        	private Date dateDeNaissance;
        	private String lieuDeNaissance;
        	private String telephone;
        	private String identifiantCas;
        	//courriel est email
        	private String commentaireDesactivation;
        	private Boolean anonyme;
        	private Date dateCreation;
        	private Date dateModification;
            /* fin Added fields */

        private TypeEntiteAdministrativeVo typeEntiteAdministrativeVo ;
        private EntiteAdministrativeVo entiteAdministrativeVo ;
        private PaysVo paysVo ;
        private VilleVo villeVo ;
        private DepartementScientifiqueVo departementScientifiqueVo ;
        private CommissionScientifiqueVo commissionScientifiqueVo ;
        private GradeVo gradeVo ;
        private CorpsVo corpsVo ;
        private SexeVo sexeVo ;

    private List<DomaineScientifiqueChercheurVo> domaineScientifiqueChercheursVo ;
    private List<ZoneActiviteInteractionRechercheVo> zoneActiviteInteractionRecherchesVo ;
    private List<CommunauteSavoirChercheurVo> communauteSavoirChercheursVo ;
    private List<InstrumentsEtDispositifsIrdChercheurVo> instrumentsEtDispositifsIrdChercheursVo ;
    private List<IdentifiantAuteurExpertVo> identifiantAuteurExpertsVo ;

    public ChercheurVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getNumeroMatricule(){
        return this.numeroMatricule;
        }

        public void setNumeroMatricule(String numeroMatricule){
        this.numeroMatricule = numeroMatricule;
        }
        public String getEmail(){
        return this.email;
        }

        public void setEmail(String email){
        this.email = email;
        }
        public String getNatureImplication(){
        return this.natureImplication;
        }

        public void setNatureImplication(String natureImplication){
        this.natureImplication = natureImplication;
        }
        public String getResume(){
        return this.resume;
        }

        public void setResume(String resume){
        this.resume = resume;
        }
        public String getFormationEnManagement(){
        return this.formationEnManagement;
        }

        public void setFormationEnManagement(String formationEnManagement){
        this.formationEnManagement = formationEnManagement;
        }
        public String getCredentialsNonExpired(){
        return this.credentialsNonExpired;
        }

        public void setCredentialsNonExpired(String credentialsNonExpired){
        this.credentialsNonExpired = credentialsNonExpired;
        }
        public String getEnabled(){
        return this.enabled;
        }

        public void setEnabled(String enabled){
        this.enabled = enabled;
        }
        public String getCreatedAt(){
        return this.createdAt;
        }

        public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
        }
        public String getUpdatedAt(){
        return this.updatedAt;
        }

        public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
        }
        public String getAccountNonExpired(){
        return this.accountNonExpired;
        }

        public void setAccountNonExpired(String accountNonExpired){
        this.accountNonExpired = accountNonExpired;
        }
        public String getAccountNonLocked(){
        return this.accountNonLocked;
        }

        public void setAccountNonLocked(String accountNonLocked){
        this.accountNonLocked = accountNonLocked;
        }
        public String getUsername(){
        return this.username;
        }

        public void setUsername(String username){
        this.username = username;
        }
        public String getPassword(){
        return this.password;
        }

        public void setPassword(String password){
        this.password = password;
        }
        public String getPrenom(){
        return this.prenom;
        }

        public void setPrenom(String prenom){
        this.prenom = prenom;
        }
        public String getNom(){
        return this.nom;
        }

        public void setNom(String nom){
        this.nom = nom;
        }
        public String getRole(){
        return this.role;
        }

        public void setRole(String role){
        this.role = role;
        }
        public String getPasswordChanged(){
        return this.passwordChanged;
        }

        public void setPasswordChanged(String passwordChanged){
        this.passwordChanged = passwordChanged;
        }


            public String getCreatedAtMax(){
            return this.createdAtMax;
            }

            public String getCreatedAtMin(){
            return this.createdAtMin;
            }

            public void setCreatedAtMax(String createdAtMax){
            this.createdAtMax = createdAtMax;
            }

            public void setCreatedAtMin(String createdAtMin){
            this.createdAtMin = createdAtMin;
            }

            public String getUpdatedAtMax(){
            return this.updatedAtMax;
            }

            public String getUpdatedAtMin(){
            return this.updatedAtMin;
            }

            public void setUpdatedAtMax(String updatedAtMax){
            this.updatedAtMax = updatedAtMax;
            }

            public void setUpdatedAtMin(String updatedAtMin){
            this.updatedAtMin = updatedAtMin;
            }


        public TypeEntiteAdministrativeVo getTypeEntiteAdministrativeVo(){
        return this.typeEntiteAdministrativeVo;
        }

        public void setTypeEntiteAdministrativeVo(TypeEntiteAdministrativeVo typeEntiteAdministrativeVo){
        this.typeEntiteAdministrativeVo = typeEntiteAdministrativeVo;
        }
        public EntiteAdministrativeVo getEntiteAdministrativeVo(){
        return this.entiteAdministrativeVo;
        }

        public void setEntiteAdministrativeVo(EntiteAdministrativeVo entiteAdministrativeVo){
        this.entiteAdministrativeVo = entiteAdministrativeVo;
        }
        public PaysVo getPaysVo(){
        return this.paysVo;
        }

        public void setPaysVo(PaysVo paysVo){
        this.paysVo = paysVo;
        }
        public VilleVo getVilleVo(){
        return this.villeVo;
        }

        public void setVilleVo(VilleVo villeVo){
        this.villeVo = villeVo;
        }
        public DepartementScientifiqueVo getDepartementScientifiqueVo(){
        return this.departementScientifiqueVo;
        }

        public void setDepartementScientifiqueVo(DepartementScientifiqueVo departementScientifiqueVo){
        this.departementScientifiqueVo = departementScientifiqueVo;
        }
        public CommissionScientifiqueVo getCommissionScientifiqueVo(){
        return this.commissionScientifiqueVo;
        }

        public void setCommissionScientifiqueVo(CommissionScientifiqueVo commissionScientifiqueVo){
        this.commissionScientifiqueVo = commissionScientifiqueVo;
        }
        public GradeVo getGradeVo(){
        return this.gradeVo;
        }

        public void setGradeVo(GradeVo gradeVo){
        this.gradeVo = gradeVo;
        }
        public CorpsVo getCorpsVo(){
        return this.corpsVo;
        }

        public void setCorpsVo(CorpsVo corpsVo){
        this.corpsVo = corpsVo;
        }
        public SexeVo getSexeVo(){
        return this.sexeVo;
        }

        public void setSexeVo(SexeVo sexeVo){
        this.sexeVo = sexeVo;
        }


        public List<DomaineScientifiqueChercheurVo> getDomaineScientifiqueChercheursVo(){
        return this.domaineScientifiqueChercheursVo;
        }

        public void setDomaineScientifiqueChercheursVo(List<DomaineScientifiqueChercheurVo> domaineScientifiqueChercheursVo){
            this.domaineScientifiqueChercheursVo = domaineScientifiqueChercheursVo;
            }

        public List<ZoneActiviteInteractionRechercheVo> getZoneActiviteInteractionRecherchesVo(){
        return this.zoneActiviteInteractionRecherchesVo;
        }

        public void setZoneActiviteInteractionRecherchesVo(List<ZoneActiviteInteractionRechercheVo> zoneActiviteInteractionRecherchesVo){
            this.zoneActiviteInteractionRecherchesVo = zoneActiviteInteractionRecherchesVo;
            }

        public List<CommunauteSavoirChercheurVo> getCommunauteSavoirChercheursVo(){
        return this.communauteSavoirChercheursVo;
        }

        public void setCommunauteSavoirChercheursVo(List<CommunauteSavoirChercheurVo> communauteSavoirChercheursVo){
            this.communauteSavoirChercheursVo = communauteSavoirChercheursVo;
            }

        public List<InstrumentsEtDispositifsIrdChercheurVo> getInstrumentsEtDispositifsIrdChercheursVo(){
        return this.instrumentsEtDispositifsIrdChercheursVo;
        }

        public void setInstrumentsEtDispositifsIrdChercheursVo(List<InstrumentsEtDispositifsIrdChercheurVo> instrumentsEtDispositifsIrdChercheursVo){
            this.instrumentsEtDispositifsIrdChercheursVo = instrumentsEtDispositifsIrdChercheursVo;
            }

        public List<IdentifiantAuteurExpertVo> getIdentifiantAuteurExpertsVo(){
        return this.identifiantAuteurExpertsVo;
        }

        public void setIdentifiantAuteurExpertsVo(List<IdentifiantAuteurExpertVo> identifiantAuteurExpertsVo){
            this.identifiantAuteurExpertsVo = identifiantAuteurExpertsVo;
            }

		public String getIdGraph() {
			return idGraph;
		}

		public void setIdGraph(String idGraph) {
			this.idGraph = idGraph;
		}

		public String getCivilite() {
			return civilite;
		}

		public void setCivilite(String civilite) {
			this.civilite = civilite;
		}

		public String getIntitulePoste() {
			return intitulePoste;
		}

		public void setIntitulePoste(String intitulePoste) {
			this.intitulePoste = intitulePoste;
		}

		public Boolean getSorgho() {
			return sorgho;
		}

		public void setSorgho(Boolean sorgho) {
			this.sorgho = sorgho;
		}

		public Boolean getValide() {
			return valide;
		}

		public void setValide(Boolean valide) {
			this.valide = valide;
		}

		public String getTypeEffectif() {
			return typeEffectif;
		}

		public void setTypeEffectif(String typeEffectif) {
			this.typeEffectif = typeEffectif;
		}

		public String getDomaineActivite() {
			return domaineActivite;
		}

		public void setDomaineActivite(String domaineActivite) {
			this.domaineActivite = domaineActivite;
		}

		public String getNomNaissance() {
			return nomNaissance;
		}

		public void setNomNaissance(String nomNaissance) {
			this.nomNaissance = nomNaissance;
		}

		public Date getDateDeNaissance() {
			return dateDeNaissance;
		}

		public void setDateDeNaissance(Date dateDeNaissance) {
			this.dateDeNaissance = dateDeNaissance;
		}

		public String getLieuDeNaissance() {
			return lieuDeNaissance;
		}

		public void setLieuDeNaissance(String lieuDeNaissance) {
			this.lieuDeNaissance = lieuDeNaissance;
		}

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		public String getIdentifiantCas() {
			return identifiantCas;
		}

		public void setIdentifiantCas(String identifiantCas) {
			this.identifiantCas = identifiantCas;
		}

		public String getCommentaireDesactivation() {
			return commentaireDesactivation;
		}

		public void setCommentaireDesactivation(String commentaireDesactivation) {
			this.commentaireDesactivation = commentaireDesactivation;
		}

		public Boolean getAnonyme() {
			return anonyme;
		}

		public void setAnonyme(Boolean anonyme) {
			this.anonyme = anonyme;
		}

		public Date getDateCreation() {
			return dateCreation;
		}

		public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
		}

		public Date getDateModification() {
			return dateModification;
		}

		public void setDateModification(Date dateModification) {
			this.dateModification = dateModification;
		}

            }
