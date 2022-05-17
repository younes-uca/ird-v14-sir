package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;

public class EncadrementEtudiantVo {

	private String id;
	private String sujetEtude;
	private boolean cursus;

	private NiveauFormationPostBacVo niveauFormationPostBacVo;
	private ResponsabiliteEncadrementEtudiantVo responsabiliteEncadrementEtudiantVo;
	private EtablissementVo etablissementVo;
	private PaysVo paysVo;
	private EtudiantVo etudiantVo;
	private EncadrementVo encadrementVo;
	private EtatEtapeCampagneVo etatEtapeCampagneVo;

	private List<EncadrementEtudiantEnjeuxIrdVo> encadrementEtudiantEnjeuxIrdsVo;
	private List<EncadrementEtudiantDisciplineScientifiqueVo> encadrementEtudiantDisciplineScientifiquesVo;
	
	  private List<PaysEncadrementEtudiantVo> paysEncadrementEtudiantsVo ;
	    private List<EtablissementEncadrementEtudiantVo> etablissementEncadrementEtudiantsVo ;

	public EncadrementEtudiantVo() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSujetEtude() {
		return this.sujetEtude;
	}

	public void setSujetEtude(String sujetEtude) {
		this.sujetEtude = sujetEtude;
	}

	public NiveauFormationPostBacVo getNiveauFormationPostBacVo() {
		return this.niveauFormationPostBacVo;
	}

	public void setNiveauFormationPostBacVo(NiveauFormationPostBacVo niveauFormationPostBacVo) {
		this.niveauFormationPostBacVo = niveauFormationPostBacVo;
	}

	public ResponsabiliteEncadrementEtudiantVo getResponsabiliteEncadrementEtudiantVo() {
		return this.responsabiliteEncadrementEtudiantVo;
	}

	public void setResponsabiliteEncadrementEtudiantVo(
			ResponsabiliteEncadrementEtudiantVo responsabiliteEncadrementEtudiantVo) {
		this.responsabiliteEncadrementEtudiantVo = responsabiliteEncadrementEtudiantVo;
	}

	public EtablissementVo getEtablissementVo() {
		return this.etablissementVo;
	}

	public void setEtablissementVo(EtablissementVo etablissementVo) {
		this.etablissementVo = etablissementVo;
	}

	public PaysVo getPaysVo() {
		return this.paysVo;
	}

	public void setPaysVo(PaysVo paysVo) {
		this.paysVo = paysVo;
	}

	public EtudiantVo getEtudiantVo() {
		return etudiantVo;
	}

	public void setEtudiantVo(EtudiantVo etudiantVo) {
		this.etudiantVo = etudiantVo;
	}

	public EncadrementVo getEncadrementVo() {
		return this.encadrementVo;
	}

	public void setEncadrementVo(EncadrementVo encadrementVo) {
		this.encadrementVo = encadrementVo;
	}

	public EtatEtapeCampagneVo getEtatEtapeCampagneVo() {
		return this.etatEtapeCampagneVo;
	}

	public void setEtatEtapeCampagneVo(EtatEtapeCampagneVo etatEtapeCampagneVo) {
		this.etatEtapeCampagneVo = etatEtapeCampagneVo;
	}

	public List<EncadrementEtudiantEnjeuxIrdVo> getEncadrementEtudiantEnjeuxIrdsVo() {
		return this.encadrementEtudiantEnjeuxIrdsVo;
	}

	public void setEncadrementEtudiantEnjeuxIrdsVo(
			List<EncadrementEtudiantEnjeuxIrdVo> encadrementEtudiantEnjeuxIrdsVo) {
		this.encadrementEtudiantEnjeuxIrdsVo = encadrementEtudiantEnjeuxIrdsVo;
	}

	public List<EncadrementEtudiantDisciplineScientifiqueVo> getEncadrementEtudiantDisciplineScientifiquesVo() {
		return this.encadrementEtudiantDisciplineScientifiquesVo;
	}

	public void setEncadrementEtudiantDisciplineScientifiquesVo(
			List<EncadrementEtudiantDisciplineScientifiqueVo> encadrementEtudiantDisciplineScientifiquesVo) {
		this.encadrementEtudiantDisciplineScientifiquesVo = encadrementEtudiantDisciplineScientifiquesVo;
	}

	public boolean isCursus() {
		return cursus;
	}

	public void setCursus(boolean cursus) {
		this.cursus = cursus;
	}

	public List<PaysEncadrementEtudiantVo> getPaysEncadrementEtudiantsVo() {
		return paysEncadrementEtudiantsVo;
	}

	public void setPaysEncadrementEtudiantsVo(List<PaysEncadrementEtudiantVo> paysEncadrementEtudiantsVo) {
		this.paysEncadrementEtudiantsVo = paysEncadrementEtudiantsVo;
	}

	public List<EtablissementEncadrementEtudiantVo> getEtablissementEncadrementEtudiantsVo() {
		return etablissementEncadrementEtudiantsVo;
	}

	public void setEtablissementEncadrementEtudiantsVo(
			List<EtablissementEncadrementEtudiantVo> etablissementEncadrementEtudiantsVo) {
		this.etablissementEncadrementEtudiantsVo = etablissementEncadrementEtudiantsVo;
	}

	

	
}
