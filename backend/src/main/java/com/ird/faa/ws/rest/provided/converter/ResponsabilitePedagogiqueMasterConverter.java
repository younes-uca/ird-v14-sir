package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.ResponsabilitePedagogiqueMaster;
import com.ird.faa.ws.rest.provided.vo.ResponsabilitePedagogiqueMasterVo;

@Component
public class ResponsabilitePedagogiqueMasterConverter extends AbstractConverter<ResponsabilitePedagogiqueMaster,ResponsabilitePedagogiqueMasterVo>{

        @Autowired
        private EtatEtapeCampagneConverter etatEtapeCampagneConverter ;
        @Autowired
        private MasterConverter masterConverter ;
        @Autowired
        private StatutMasterConverter statutMasterConverter ;
        @Autowired
        private EtablissementConverter etablissementConverter ;
        @Autowired
        private CampagneConverter campagneConverter ;
        @Autowired
        private ChercheurConverter chercheurConverter ;
    private Boolean statutMaster;
    private Boolean master;
    private Boolean etablissement;
    private Boolean etatEtapeCampagne;
    private Boolean chercheur;
    private Boolean campagne;

public  ResponsabilitePedagogiqueMasterConverter(){
init(true);
}

@Override
public ResponsabilitePedagogiqueMaster toItem(ResponsabilitePedagogiqueMasterVo vo) {
if (vo == null) {
return null;
} else {
ResponsabilitePedagogiqueMaster item = new ResponsabilitePedagogiqueMaster();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getAnnee()))
        item.setAnnee(NumberUtil.toInt(vo.getAnnee()));
        if(StringUtil.isNotEmpty(vo.getTempsEstimePourCetteAnnne()))
        item.setTempsEstimePourCetteAnnne(NumberUtil.toBigDecimal(vo.getTempsEstimePourCetteAnnne()));
        if(StringUtil.isNotEmpty(vo.getAppelServiceRenforcementCapaciteSud()))
        item.setAppelServiceRenforcementCapaciteSud(NumberUtil.toBoolean(vo.getAppelServiceRenforcementCapaciteSud()));
        if(StringUtil.isNotEmpty(vo.getMasterInternational()))
        item.setMasterInternational(NumberUtil.toBoolean(vo.getMasterInternational()));
    if(vo.getStatutMasterVo()!=null && this.statutMaster)
        item.setStatutMaster(statutMasterConverter.toItem(vo.getStatutMasterVo())) ;
    if(vo.getMasterVo()!=null && this.master)
        item.setMaster(masterConverter.toItem(vo.getMasterVo())) ;
    if(vo.getEtablissementVo()!=null && this.etablissement)
        item.setEtablissement(etablissementConverter.toItem(vo.getEtablissementVo())) ;
    if(vo.getEtatEtapeCampagneVo()!=null && this.etatEtapeCampagne)
        item.setEtatEtapeCampagne(etatEtapeCampagneConverter.toItem(vo.getEtatEtapeCampagneVo())) ;
    if(vo.getChercheurVo()!=null && this.chercheur)
        item.setChercheur(chercheurConverter.toItem(vo.getChercheurVo())) ;
    if(vo.getCampagneVo()!=null && this.campagne)
        item.setCampagne(campagneConverter.toItem(vo.getCampagneVo())) ;


return item;
}
}

@Override
public ResponsabilitePedagogiqueMasterVo toVo(ResponsabilitePedagogiqueMaster item) {
if (item == null) {
return null;
} else {
ResponsabilitePedagogiqueMasterVo vo = new ResponsabilitePedagogiqueMasterVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(item.getAnnee()!=null)
        vo.setAnnee(NumberUtil.toString(item.getAnnee()));
        if(item.getTempsEstimePourCetteAnnne()!=null)
        vo.setTempsEstimePourCetteAnnne(NumberUtil.toString(item.getTempsEstimePourCetteAnnne()));
        if(item.getAppelServiceRenforcementCapaciteSud()!=null)
        vo.setAppelServiceRenforcementCapaciteSud(NumberUtil.toString(item.getAppelServiceRenforcementCapaciteSud()));
        if(item.getMasterInternational()!=null)
        vo.setMasterInternational(NumberUtil.toString(item.getMasterInternational()));
    if(item.getStatutMaster()!=null && this.statutMaster) {
        vo.setStatutMasterVo(statutMasterConverter.toVo(item.getStatutMaster())) ;
    }
    if(item.getMaster()!=null && this.master) {
        vo.setMasterVo(masterConverter.toVo(item.getMaster())) ;
    }
    if(item.getEtablissement()!=null && this.etablissement) {
        vo.setEtablissementVo(etablissementConverter.toVo(item.getEtablissement())) ;
    }
    if(item.getEtatEtapeCampagne()!=null && this.etatEtapeCampagne) {
        vo.setEtatEtapeCampagneVo(etatEtapeCampagneConverter.toVo(item.getEtatEtapeCampagne())) ;
    }
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
    statutMaster = value;
    master = value;
    etablissement = value;
    etatEtapeCampagne = value;
    chercheur = value;
    campagne = value;
}


        public EtatEtapeCampagneConverter getEtatEtapeCampagneConverter(){
        return this.etatEtapeCampagneConverter;
        }
        public void setEtatEtapeCampagneConverter(EtatEtapeCampagneConverter etatEtapeCampagneConverter ){
        this.etatEtapeCampagneConverter = etatEtapeCampagneConverter;
        }
        public MasterConverter getMasterConverter(){
        return this.masterConverter;
        }
        public void setMasterConverter(MasterConverter masterConverter ){
        this.masterConverter = masterConverter;
        }
        public StatutMasterConverter getStatutMasterConverter(){
        return this.statutMasterConverter;
        }
        public void setStatutMasterConverter(StatutMasterConverter statutMasterConverter ){
        this.statutMasterConverter = statutMasterConverter;
        }
        public EtablissementConverter getEtablissementConverter(){
        return this.etablissementConverter;
        }
        public void setEtablissementConverter(EtablissementConverter etablissementConverter ){
        this.etablissementConverter = etablissementConverter;
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

    public boolean  isStatutMaster(){
    return this.statutMaster;
    }
    public void  setStatutMaster(boolean statutMaster){
    this.statutMaster = statutMaster;
    }
    public boolean  isMaster(){
    return this.master;
    }
    public void  setMaster(boolean master){
    this.master = master;
    }
    public boolean  isEtablissement(){
    return this.etablissement;
    }
    public void  setEtablissement(boolean etablissement){
    this.etablissement = etablissement;
    }
    public boolean  isEtatEtapeCampagne(){
    return this.etatEtapeCampagne;
    }
    public void  setEtatEtapeCampagne(boolean etatEtapeCampagne){
    this.etatEtapeCampagne = etatEtapeCampagne;
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
