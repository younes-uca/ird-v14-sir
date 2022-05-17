package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ird.faa.bean.formulaire.GestionEquipeDetail;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.GestionEquipeDetailVo;

@Component
public class GestionEquipeDetailConverter extends AbstractConverter<GestionEquipeDetail, GestionEquipeDetailVo> {
	@Autowired
	private EtatEtapeCampagneConverter etatEtapeCampagneConverter;

	@Autowired
	private GestionEquipeConverter gestionEquipeConverter;
	private Boolean gestionEquipe;
	private Boolean etatEtapeCampagne;

	public GestionEquipeDetailConverter() {
		init(true);
	}

	@Override
	public GestionEquipeDetail toItem(GestionEquipeDetailVo vo) {
		if (vo == null) {
			return null;
		} else {
			GestionEquipeDetail item = new GestionEquipeDetail();
			if (StringUtil.isNotEmpty(vo.getId()))
				item.setId(NumberUtil.toLong(vo.getId()));
			if (StringUtil.isNotEmpty(vo.getNombrePersonneEncadre()))
				item.setNombrePersonneEncadre(NumberUtil.toInt(vo.getNombrePersonneEncadre()));
			if (StringUtil.isNotEmpty(vo.getNombrePersonneHorsIrd()))
				item.setNombrePersonneHorsIrd(NumberUtil.toInt(vo.getNombrePersonneHorsIrd()));
			if (StringUtil.isNotEmpty(vo.getNombrePersonneSousConventions()))
				item.setNombrePersonneSousConventions(NumberUtil.toInt(vo.getNombrePersonneSousConventions()));
			if (vo.getFormationManagement() != null)
				item.setFormationManagement(vo.getFormationManagement());
			if (vo.getGestionEquipeVo() != null && this.gestionEquipe)
				item.setGestionEquipe(gestionEquipeConverter.toItem(vo.getGestionEquipeVo()));

			if (vo.getEtatEtapeCampagneVo() != null && this.etatEtapeCampagne)
				item.setEtatEtapeCampagne(etatEtapeCampagneConverter.toItem(vo.getEtatEtapeCampagneVo()));
				
			return item;
		}
	}

	@Override
	public GestionEquipeDetailVo toVo(GestionEquipeDetail item) {
		if (item == null) {
			return null;
		} else {
			GestionEquipeDetailVo vo = new GestionEquipeDetailVo();
			if (item.getId() != null)
				vo.setId(NumberUtil.toString(item.getId()));

			if (item.getNombrePersonneEncadre() != null)
				vo.setNombrePersonneEncadre(NumberUtil.toString(item.getNombrePersonneEncadre()));

			if (item.getNombrePersonneHorsIrd() != null)
				vo.setNombrePersonneHorsIrd(NumberUtil.toString(item.getNombrePersonneHorsIrd()));

			if (item.getNombrePersonneSousConventions() != null)
				vo.setNombrePersonneSousConventions(NumberUtil.toString(item.getNombrePersonneSousConventions()));

			if (item.getFormationManagement() != null)
				vo.setFormationManagement(item.getFormationManagement());
			if (item.getGestionEquipe() != null && this.gestionEquipe) {
				vo.setGestionEquipeVo(gestionEquipeConverter.toVo(item.getGestionEquipe()));
			}

			if (item.getEtatEtapeCampagne() != null && this.etatEtapeCampagne) {
				vo.setEtatEtapeCampagneVo(etatEtapeCampagneConverter.toVo(item.getEtatEtapeCampagne()));
			}

			return vo;
		}
	}
	
	 public EtatEtapeCampagneConverter getEtatEtapeCampagneConverter(){
	        return this.etatEtapeCampagneConverter;
	        }
	        public void setEtatEtapeCampagneConverter(EtatEtapeCampagneConverter etatEtapeCampagneConverter ){
	        this.etatEtapeCampagneConverter = etatEtapeCampagneConverter;
	        }


	public void init(Boolean value) {

	    gestionEquipe = value;
	    etatEtapeCampagne = value;

	}

	public GestionEquipeConverter getGestionEquipeConverter() {
		return this.gestionEquipeConverter;
	}

	public void setGestionEquipeConverter(GestionEquipeConverter gestionEquipeConverter) {
		this.gestionEquipeConverter = gestionEquipeConverter;
	}

	public boolean isGestionEquipe() {
		return this.gestionEquipe;
	}

	public void setGestionEquipe(boolean gestionEquipe) {
		this.gestionEquipe = gestionEquipe;
	}

	 public boolean  isEtatEtapeCampagne(){
		    return this.etatEtapeCampagne;
		    }
		    public void  setEtatEtapeCampagne(boolean etatEtapeCampagne){
		    this.etatEtapeCampagne = etatEtapeCampagne;
		    }

}
