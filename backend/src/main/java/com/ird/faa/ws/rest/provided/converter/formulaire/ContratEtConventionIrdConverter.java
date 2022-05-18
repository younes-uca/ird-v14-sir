package main.java.com.ird.faa.ws.rest.provided.converter.formulaire;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.bean.formulaire.ContratEtConventionIrd;
import com.ird.faa.bean.formulaire.ContratEtConventionIrdPartenaire;
import com.ird.faa.bean.formulaire.Partenaire;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.ContratEtConventionIrdVo;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.PartenaireVo;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.PaysVo;

@Component
public class ContratEtConventionIrdConverter
		extends AbstractConverter<ContratEtConventionIrd, ContratEtConventionIrdVo> {

	@Autowired
	private SavoirEtInnovationConverter savoirEtInnovationConverter;
	@Autowired
	private EtatEtapeCampagneConverter etatEtapeCampagneConverter;
	@Autowired
	private PaysConverter paysConverter;
	@Autowired
	private StatusContratEtConventionConverter statusContratEtConventionConverter;
	private Boolean statusContratEtConvention;
	private Boolean savoirEtInnovation;
	private Boolean etatEtapeCampagne;

	public ContratEtConventionIrdConverter() {
		init(true);
	}

	@Override
	public ContratEtConventionIrd toItem(ContratEtConventionIrdVo vo) {
		if (vo == null) {
			return null;
		} else {
			ContratEtConventionIrd item = new ContratEtConventionIrd();
			if (StringUtil.isNotEmpty(vo.getId()))
				item.setId(NumberUtil.toLong(vo.getId()));
			if (StringUtil.isNotEmpty(vo.getNumero()))
				item.setNumero(vo.getNumero());
			if (StringUtil.isNotEmpty(vo.getDateCreationContrat()))
				item.setDateCreationContrat(vo.getDateCreationContrat());
			if (StringUtil.isNotEmpty(vo.getPartenairesVo())) {
				List<ContratEtConventionIrdPartenaire> contratEtConventionIrdPartenaires = new ArrayList<ContratEtConventionIrdPartenaire>();
				vo.getPartenairesVo().forEach(partenaireVo -> {
						Partenaire partenaire = new Partenaire();
						partenaire.setIdGraphQl(partenaireVo.getIdGraphQl());
						partenaire.setNomOfficel(partenaireVo.getNomOfficiel());
						partenaire.setSigleOfficel(partenaireVo.getSigleOfficiel());
						partenaire.setAdresse(partenaireVo.getAdresse());
						partenaire
								.setPaysPartenaire(paysConverter.toItem(partenaireVo.getPays()));
						ContratEtConventionIrdPartenaire contratEtConventionIrdPartenaire = new ContratEtConventionIrdPartenaire();
						contratEtConventionIrdPartenaire.setPartenaire(partenaire);
						contratEtConventionIrdPartenaires.add(contratEtConventionIrdPartenaire);
				});
			    item.setContratEtConventionIrdPartenaires(contratEtConventionIrdPartenaires);
			}
			if (StringUtil.isNotEmpty(vo.getDateEntreeEnVigueurContrat()))
				item.setDateEntreeEnVigueur(vo.getDateEntreeEnVigueurContrat());
			if (StringUtil.isNotEmpty(vo.getDateFinContrat()))
				item.setDateFin(vo.getDateFinContrat());
			if (StringUtil.isNotEmpty(vo.getDureeEnMois()))
				item.setDureeEnMois(vo.getDureeEnMois());
			if (StringUtil.isNotEmpty(vo.getDateCreationContrat()))
				item.setDateCreationContrat(vo.getDateCreationContrat());
			if (StringUtil.isNotEmpty(vo.getIntitule()))
				item.setIntitule(vo.getIntitule());
			if (StringUtil.isNotEmpty(vo.getDescription()))
				item.setDescription(vo.getDescription());
			if (StringUtil.isNotEmpty(vo.getProgrammeFinancement()))
				item.setProgrammeFinancement(vo.getProgrammeFinancement());
			if (StringUtil.isNotEmpty(vo.getNumMatriculePorteur()))
				item.setNumMatriculePorteur(vo.getNumMatriculePorteur());
			if (vo.getStatusContratEtConventionVo() != null && this.statusContratEtConvention)
				item.setStatusContratEtConvention(
						statusContratEtConventionConverter.toItem(vo.getStatusContratEtConventionVo()));
			if (vo.getSavoirEtInnovationVo() != null && this.savoirEtInnovation)
				item.setSavoirEtInnovation(savoirEtInnovationConverter.toItem(vo.getSavoirEtInnovationVo()));
			if (vo.getEtatEtapeCampagneVo() != null && this.etatEtapeCampagne)
				item.setEtatEtapeCampagne(etatEtapeCampagneConverter.toItem(vo.getEtatEtapeCampagneVo()));

			return item;
		}
	}

	@Override
	public ContratEtConventionIrdVo toVo(ContratEtConventionIrd item) {
		if (item == null) {
			return null;
		} else {
			ContratEtConventionIrdVo vo = new ContratEtConventionIrdVo();
			if (item.getId() != null)
				vo.setId(NumberUtil.toString(item.getId()));

			if (StringUtil.isNotEmpty(item.getNumero()))
				vo.setNumero(item.getNumero());

			if (item.getDateCreationContrat() != null)
				vo.setDateCreationContrat(item.getDateCreationContrat());
			if (item.getDateEntreeEnVigueur() != null)
				vo.setDateEntreeEnVigueurContrat(item.getDateEntreeEnVigueur());
			if (item.getDateFin() != null)
				vo.setDateFinContrat(item.getDateFin());
			vo.setDureeEnMois(item.getDureeEnMois());
			if (StringUtil.isNotEmpty(item.getIntitule()))
				vo.setIntitule(item.getIntitule());
			if (StringUtil.isNotEmpty(item.getContratEtConventionIrdPartenaires())) {
				List<PartenaireVo> partenairesVo =new ArrayList<>();
				if (item.getContratEtConventionIrdPartenaires() != null) {
					item.getContratEtConventionIrdPartenaires().forEach(contratPartenaire->{
						PartenaireVo partenaireVo= new PartenaireVo();
						if (contratPartenaire.getPartenaire()!=null) {
							partenaireVo.setNomOfficiel(contratPartenaire.getPartenaire().getNomOfficel());
							partenaireVo.setSigleOfficiel(contratPartenaire.getPartenaire().getSigleOfficel());
						}
						if (contratPartenaire.getPartenaire().getPaysPartenaire()!=null) {
							PaysVo paysVo=new PaysVo();
							paysVo.setCode(contratPartenaire.getPartenaire().getPaysPartenaire().getCode());
							paysVo.setLibelle(contratPartenaire.getPartenaire().getPaysPartenaire().getLibelle());
							partenaireVo.setPays(paysVo);
						}
						partenairesVo.add(partenaireVo);
					});
				}
				vo.setPartenairesVo(partenairesVo);		
			}
			if (StringUtil.isNotEmpty(item.getDescription()))
				vo.setDescription(item.getDescription());
			if (StringUtil.isNotEmpty(item.getNumMatriculePorteur()))
				vo.setNumMatriculePorteur(item.getNumMatriculePorteur());
			if (StringUtil.isNotEmpty(item.getProgrammeFinancement()))
				vo.setProgrammeFinancement(item.getProgrammeFinancement());
			if (item.getStatusContratEtConvention() != null && this.statusContratEtConvention) {
				vo.setStatusContratEtConventionVo(
						statusContratEtConventionConverter.toVo(item.getStatusContratEtConvention()));
			}
		

			return vo;
		}
	}

	public void init(Boolean value) {
		statusContratEtConvention = value;
		savoirEtInnovation = value;
		etatEtapeCampagne = value;
	}

	public SavoirEtInnovationConverter getSavoirEtInnovationConverter() {
		return this.savoirEtInnovationConverter;
	}

	public void setSavoirEtInnovationConverter(SavoirEtInnovationConverter savoirEtInnovationConverter) {
		this.savoirEtInnovationConverter = savoirEtInnovationConverter;
	}

	public EtatEtapeCampagneConverter getEtatEtapeCampagneConverter() {
		return this.etatEtapeCampagneConverter;
	}

	public void setEtatEtapeCampagneConverter(EtatEtapeCampagneConverter etatEtapeCampagneConverter) {
		this.etatEtapeCampagneConverter = etatEtapeCampagneConverter;
	}

	public StatusContratEtConventionConverter getStatusContratEtConventionConverter() {
		return this.statusContratEtConventionConverter;
	}

	public void setStatusContratEtConventionConverter(
			StatusContratEtConventionConverter statusContratEtConventionConverter) {
		this.statusContratEtConventionConverter = statusContratEtConventionConverter;
	}

	public boolean isStatusContratEtConvention() {
		return this.statusContratEtConvention;
	}

	public void setStatusContratEtConvention(boolean statusContratEtConvention) {
		this.statusContratEtConvention = statusContratEtConvention;
	}

	public boolean isSavoirEtInnovation() {
		return this.savoirEtInnovation;
	}

	public void setSavoirEtInnovation(boolean savoirEtInnovation) {
		this.savoirEtInnovation = savoirEtInnovation;
	}

	public boolean isEtatEtapeCampagne() {
		return this.etatEtapeCampagne;
	}

	public void setEtatEtapeCampagne(boolean etatEtapeCampagne) {
		this.etatEtapeCampagne = etatEtapeCampagne;
	}

}
