package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.CampagneChercheur;
import com.ird.faa.ws.rest.provided.vo.CampagneChercheurVo;

@Component
public class CampagneChercheurConverter extends AbstractConverter<CampagneChercheur,CampagneChercheurVo>{

        @Autowired
        private EtatCampagneChercheurConverter etatCampagneChercheurConverter ;
        @Autowired
        private CampagneConverter campagneConverter ;
        @Autowired
        private ChercheurConverter chercheurConverter ;
    private Boolean chercheur;
    private Boolean campagne;
    private Boolean etatCampagneChercheur;

public  CampagneChercheurConverter(){
init(true);
}

@Override
public CampagneChercheur toItem(CampagneChercheurVo vo) {
if (vo == null) {
return null;
} else {
CampagneChercheur item = new CampagneChercheur();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getAvancement()))
        item.setAvancement(NumberUtil.toBigDecimal(vo.getAvancement()));
    if(vo.getChercheurVo()!=null && this.chercheur)
        item.setChercheur(chercheurConverter.toItem(vo.getChercheurVo())) ;
    if(vo.getCampagneVo()!=null && this.campagne)
        item.setCampagne(campagneConverter.toItem(vo.getCampagneVo())) ;
    if(vo.getEtatCampagneChercheurVo()!=null && this.etatCampagneChercheur)
        item.setEtatCampagneChercheur(etatCampagneChercheurConverter.toItem(vo.getEtatCampagneChercheurVo())) ;


return item;
}
}

@Override
public CampagneChercheurVo toVo(CampagneChercheur item) {
if (item == null) {
return null;
} else {
CampagneChercheurVo vo = new CampagneChercheurVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(item.getAvancement()!=null)
        vo.setAvancement(NumberUtil.toString(item.getAvancement()));
    if(item.getChercheur()!=null && this.chercheur) {
        vo.setChercheurVo(chercheurConverter.toVo(item.getChercheur())) ;
    }
    if(item.getCampagne()!=null && this.campagne) {
        vo.setCampagneVo(campagneConverter.toVo(item.getCampagne())) ;
    }
    if(item.getEtatCampagneChercheur()!=null && this.etatCampagneChercheur) {
        vo.setEtatCampagneChercheurVo(etatCampagneChercheurConverter.toVo(item.getEtatCampagneChercheur())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    chercheur = value;
    campagne = value;
    etatCampagneChercheur = value;
}


        public EtatCampagneChercheurConverter getEtatCampagneChercheurConverter(){
        return this.etatCampagneChercheurConverter;
        }
        public void setEtatCampagneChercheurConverter(EtatCampagneChercheurConverter etatCampagneChercheurConverter ){
        this.etatCampagneChercheurConverter = etatCampagneChercheurConverter;
        }
        public CampagneConverter getCampagneConverter(){
        return this.campagneConverter;
        }
        public void setCampagneConverter(CampagneConverter campagneConverter ){
        this.campagneConverter = campagneConverter;
        }
        public ChercheurConverter getChercheurConverter(){
        return this.chercheurConverter;
        }
        public void setChercheurConverter(ChercheurConverter chercheurConverter ){
        this.chercheurConverter = chercheurConverter;
        }

    public boolean  isChercheur(){
    return this.chercheur;
    }
    public void  setChercheur(boolean chercheur){
    this.chercheur = chercheur;
    }
    public boolean  isCampagne(){
    return this.campagne;
    }
    public void  setCampagne(boolean campagne){
    this.campagne = campagne;
    }
    public boolean  isEtatCampagneChercheur(){
    return this.etatCampagneChercheur;
    }
    public void  setEtatCampagneChercheur(boolean etatCampagneChercheur){
    this.etatCampagneChercheur = etatCampagneChercheur;
    }










}
