package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.ResponsabilitePedagogiqueEcoleDoctorale;
import com.ird.faa.ws.rest.provided.vo.ResponsabilitePedagogiqueEcoleDoctoraleVo;

@Component
public class ResponsabilitePedagogiqueEcoleDoctoraleConverter extends AbstractConverter<ResponsabilitePedagogiqueEcoleDoctorale,ResponsabilitePedagogiqueEcoleDoctoraleVo>{

        @Autowired
        private EtatEtapeCampagneConverter etatEtapeCampagneConverter ;
        @Autowired
        private EcoleDoctoraleConverter ecoleDoctoraleConverter ;
        @Autowired
        private StatutEcoleDoctoraleConverter statutEcoleDoctoraleConverter ;
        @Autowired
        private EtablissementConverter etablissementConverter ;
        @Autowired
        private CampagneConverter campagneConverter ;
        @Autowired
        private ChercheurConverter chercheurConverter ;
    private Boolean statutEcoleDoctorale;
    private Boolean ecoleDoctorale;
    private Boolean etablissement;
    private Boolean etatEtapeCampagne;
    private Boolean chercheur;
    private Boolean campagne;

public  ResponsabilitePedagogiqueEcoleDoctoraleConverter(){
init(true);
}

@Override
public ResponsabilitePedagogiqueEcoleDoctorale toItem(ResponsabilitePedagogiqueEcoleDoctoraleVo vo) {
if (vo == null) {
return null;
} else {
ResponsabilitePedagogiqueEcoleDoctorale item = new ResponsabilitePedagogiqueEcoleDoctorale();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getAnnee()))
        item.setAnnee(NumberUtil.toInt(vo.getAnnee()));
        if(StringUtil.isNotEmpty(vo.getTempsEstimePourCetteAnnne()))
        item.setTempsEstimePourCetteAnnne(NumberUtil.toBigDecimal(vo.getTempsEstimePourCetteAnnne()));
        if(StringUtil.isNotEmpty(vo.getAppelServiceRenforcementCapaciteSud()))
        item.setAppelServiceRenforcementCapaciteSud(NumberUtil.toBoolean(vo.getAppelServiceRenforcementCapaciteSud()));
        if(StringUtil.isNotEmpty(vo.getEcoleDoctoraleInternational()))
        item.setEcoleDoctoraleInternational(NumberUtil.toBoolean(vo.getEcoleDoctoraleInternational()));
    if(vo.getStatutEcoleDoctoraleVo()!=null && this.statutEcoleDoctorale)
        item.setStatutEcoleDoctorale(statutEcoleDoctoraleConverter.toItem(vo.getStatutEcoleDoctoraleVo())) ;
    if(vo.getEcoleDoctoraleVo()!=null && this.ecoleDoctorale)
        item.setEcoleDoctorale(ecoleDoctoraleConverter.toItem(vo.getEcoleDoctoraleVo())) ;
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
public ResponsabilitePedagogiqueEcoleDoctoraleVo toVo(ResponsabilitePedagogiqueEcoleDoctorale item) {
if (item == null) {
return null;
} else {
ResponsabilitePedagogiqueEcoleDoctoraleVo vo = new ResponsabilitePedagogiqueEcoleDoctoraleVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(item.getAnnee()!=null)
        vo.setAnnee(NumberUtil.toString(item.getAnnee()));
        if(item.getTempsEstimePourCetteAnnne()!=null)
        vo.setTempsEstimePourCetteAnnne(NumberUtil.toString(item.getTempsEstimePourCetteAnnne()));
        if(item.getAppelServiceRenforcementCapaciteSud()!=null)
        vo.setAppelServiceRenforcementCapaciteSud(NumberUtil.toString(item.getAppelServiceRenforcementCapaciteSud()));
        if(item.getEcoleDoctoraleInternational()!=null)
        vo.setEcoleDoctoraleInternational(NumberUtil.toString(item.getEcoleDoctoraleInternational()));
    if(item.getStatutEcoleDoctorale()!=null && this.statutEcoleDoctorale) {
        vo.setStatutEcoleDoctoraleVo(statutEcoleDoctoraleConverter.toVo(item.getStatutEcoleDoctorale())) ;
    }
    if(item.getEcoleDoctorale()!=null && this.ecoleDoctorale) {
        vo.setEcoleDoctoraleVo(ecoleDoctoraleConverter.toVo(item.getEcoleDoctorale())) ;
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
    statutEcoleDoctorale = value;
    ecoleDoctorale = value;
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
        public EcoleDoctoraleConverter getEcoleDoctoraleConverter(){
        return this.ecoleDoctoraleConverter;
        }
        public void setEcoleDoctoraleConverter(EcoleDoctoraleConverter ecoleDoctoraleConverter ){
        this.ecoleDoctoraleConverter = ecoleDoctoraleConverter;
        }
        public StatutEcoleDoctoraleConverter getStatutEcoleDoctoraleConverter(){
        return this.statutEcoleDoctoraleConverter;
        }
        public void setStatutEcoleDoctoraleConverter(StatutEcoleDoctoraleConverter statutEcoleDoctoraleConverter ){
        this.statutEcoleDoctoraleConverter = statutEcoleDoctoraleConverter;
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

    public boolean  isStatutEcoleDoctorale(){
    return this.statutEcoleDoctorale;
    }
    public void  setStatutEcoleDoctorale(boolean statutEcoleDoctorale){
    this.statutEcoleDoctorale = statutEcoleDoctorale;
    }
    public boolean  isEcoleDoctorale(){
    return this.ecoleDoctorale;
    }
    public void  setEcoleDoctorale(boolean ecoleDoctorale){
    this.ecoleDoctorale = ecoleDoctorale;
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
