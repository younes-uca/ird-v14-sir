package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.CampagneChercheurOuverture;
import com.ird.faa.ws.rest.provided.vo.CampagneChercheurOuvertureVo;

@Component
public class CampagneChercheurOuvertureConverter extends AbstractConverter<CampagneChercheurOuverture,CampagneChercheurOuvertureVo>{

        @Autowired
        private CampagneConverter campagneConverter ;
        @Autowired
        private ChercheurConverter chercheurConverter ;
    private Boolean chercheur;
    private Boolean campagne;

public  CampagneChercheurOuvertureConverter(){
init(true);
}

@Override
public CampagneChercheurOuverture toItem(CampagneChercheurOuvertureVo vo) {
if (vo == null) {
return null;
} else {
CampagneChercheurOuverture item = new CampagneChercheurOuverture();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getObjet()))
        item.setObjet(vo.getObjet());
        if(StringUtil.isNotEmpty(vo.getMessage()))
        item.setMessage(vo.getMessage());
        if(StringUtil.isNotEmpty(vo.getEnvoye()))
        item.setEnvoye(NumberUtil.toBoolean(vo.getEnvoye()));
        if(StringUtil.isNotEmpty(vo.getDateEnvoi()))
        item.setDateEnvoi(DateUtil.parseDateCampagne(vo.getDateEnvoi()));
    if(vo.getChercheurVo()!=null && this.chercheur)
        item.setChercheur(chercheurConverter.toItem(vo.getChercheurVo())) ;
    if(vo.getCampagneVo()!=null && this.campagne)
        item.setCampagne(campagneConverter.toItem(vo.getCampagneVo())) ;


return item;
}
}

@Override
public CampagneChercheurOuvertureVo toVo(CampagneChercheurOuverture item) {
if (item == null) {
return null;
} else {
CampagneChercheurOuvertureVo vo = new CampagneChercheurOuvertureVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getObjet()))
        vo.setObjet(item.getObjet());

        if(StringUtil.isNotEmpty(item.getMessage()))
        vo.setMessage(item.getMessage());

        if(item.getEnvoye()!=null)
        vo.setEnvoye(NumberUtil.toString(item.getEnvoye()));
        if(item.getDateEnvoi()!=null)
        vo.setDateEnvoi(DateUtil.formateDate(item.getDateEnvoi()));
    if(item.getChercheur()!=null && this.chercheur) {
        vo.setChercheurVo(chercheurConverter.toVo(item.getChercheur())) ;
    }
    if(item.getCampagne()!=null && this.campagne) {
        vo.setCampagneVo(campagneConverter.toVo(item.getCampagne())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    chercheur = value;
    campagne = value;
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














}
