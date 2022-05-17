package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.formulaire.Bourse;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.BourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BourseConverter extends AbstractConverter<Bourse, BourseVo> {

    @Autowired
    private ProjetActiviteRechercheConverter projetActiviteRechercheConverter;
    @Autowired
    private CampagneConverter campagneConverter;
    @Autowired
    private ChercheurConverter chercheurConverter;
    private Boolean projetActiviteRecherche;
    private Boolean campagne;
    private Boolean chercheur;

    public BourseConverter() {
        init(true);
    }

    @Override
    public Bourse toItem(BourseVo vo) {
        if (vo == null) {
            return null;
        } else {
            Bourse item = new Bourse();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getDateObtention()))
                item.setDateObtention(DateUtil.parse(vo.getDateObtention()));
            if (StringUtil.isNotEmpty(vo.getIntitule()))
                item.setIntitule(vo.getIntitule());
            if (StringUtil.isNotEmpty(vo.getParticipationIndividuelle()))
                item.setParticipationIndividuelle(NumberUtil.toBoolean(vo.getParticipationIndividuelle()));
            if (StringUtil.isNotEmpty(vo.getMontant()))
                item.setMontant(NumberUtil.toBigDecimal(vo.getMontant()));
            if (StringUtil.isNotEmpty(vo.getDureeEnMois()))
                item.setDureeEnMois(NumberUtil.toInt(vo.getDureeEnMois()));
            if (vo.getProjetActiviteRechercheVo() != null && this.projetActiviteRecherche)
                item.setProjetActiviteRecherche(projetActiviteRechercheConverter.toItem(vo.getProjetActiviteRechercheVo()));
            if (vo.getCampagneVo() != null && this.campagne)
                item.setCampagne(campagneConverter.toItem(vo.getCampagneVo()));
            if (vo.getChercheurVo() != null && this.chercheur)
                item.setChercheur(chercheurConverter.toItem(vo.getChercheurVo()));


            return item;
        }
    }

    @Override
    public BourseVo toVo(Bourse item) {
        if (item == null) {
            return null;
        } else {
            BourseVo vo = new BourseVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));
            if (item.getDateObtention() != null)
                vo.setDateObtention(DateUtil.formateDate(item.getDateObtention()));
            if (StringUtil.isNotEmpty(item.getIntitule()))
                vo.setIntitule(item.getIntitule());

            if (item.getParticipationIndividuelle() != null)
                vo.setParticipationIndividuelle(NumberUtil.toString(item.getParticipationIndividuelle()));
            if (item.getMontant() != null)
                vo.setMontant(NumberUtil.toString(item.getMontant()));
            if (item.getDureeEnMois() != null)
                vo.setDureeEnMois(NumberUtil.toString(item.getDureeEnMois()));
            if (item.getProjetActiviteRecherche() != null && this.projetActiviteRecherche) {
                vo.setProjetActiviteRechercheVo(projetActiviteRechercheConverter.toVo(item.getProjetActiviteRecherche()));
            }
            if (item.getCampagne() != null && this.campagne) {
                vo.setCampagneVo(campagneConverter.toVo(item.getCampagne()));
            }
            if (item.getChercheur() != null && this.chercheur) {
                vo.setChercheurVo(chercheurConverter.toVo(item.getChercheur()));
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        projetActiviteRecherche = value;
        campagne = value;
        chercheur = value;
    }


    public ProjetActiviteRechercheConverter getProjetActiviteRechercheConverter() {
        return this.projetActiviteRechercheConverter;
    }

    public void setProjetActiviteRechercheConverter(ProjetActiviteRechercheConverter projetActiviteRechercheConverter) {
        this.projetActiviteRechercheConverter = projetActiviteRechercheConverter;
    }

    public CampagneConverter getCampagneConverter() {
        return this.campagneConverter;
    }

    public void setCampagneConverter(CampagneConverter campagneConverter) {
        this.campagneConverter = campagneConverter;
    }

    public ChercheurConverter getChercheurConverter() {
        return this.chercheurConverter;
    }

    public void setChercheurConverter(ChercheurConverter chercheurConverter) {
        this.chercheurConverter = chercheurConverter;
    }

    public boolean isProjetActiviteRecherche() {
        return this.projetActiviteRecherche;
    }

    public void setProjetActiviteRecherche(boolean projetActiviteRecherche) {
        this.projetActiviteRecherche = projetActiviteRecherche;
    }

    public boolean isCampagne() {
        return this.campagne;
    }

    public void setCampagne(boolean campagne) {
        this.campagne = campagne;
    }

    public boolean isChercheur() {
        return this.chercheur;
    }

    public void setChercheur(boolean chercheur) {
        this.chercheur = chercheur;
    }


}
