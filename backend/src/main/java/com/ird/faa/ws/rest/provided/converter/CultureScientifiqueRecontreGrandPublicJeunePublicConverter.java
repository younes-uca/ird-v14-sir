package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.CultureScientifiqueRecontreGrandPublicJeunePublic;
import com.ird.faa.ws.rest.provided.vo.CultureScientifiqueRecontreGrandPublicJeunePublicVo;

@Component
public class CultureScientifiqueRecontreGrandPublicJeunePublicConverter extends AbstractConverter<CultureScientifiqueRecontreGrandPublicJeunePublic,CultureScientifiqueRecontreGrandPublicJeunePublicVo>{

        @Autowired
        private PaysCultureScientifiqueRecontreGrandPublicJeunePublicConverter paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter ;
        @Autowired
        private PublicCibleCultureScientifiqueRecontreGrandPublicConverter publicCibleCultureScientifiqueRecontreGrandPublicConverter ;
        @Autowired
        private EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter ;
        @Autowired
        private FormatRencontreConverter formatRencontreConverter ;
        @Autowired
        private ContexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter ;
        @Autowired
        private CampagneConverter campagneConverter ;
        @Autowired
        private ChercheurConverter chercheurConverter ;
    private Boolean formatRencontre;
    private Boolean campagne;
    private Boolean chercheur;
        private Boolean publicCibleCultureScientifiqueRecontresGrandPublicJeunePublics;
        private Boolean contexteCultureScientifiqueRecontreGrandPublicJeunePublics;
        private Boolean etablissementCultureScientifiqueRecontreGrandPublicJeunePublics;
        private Boolean paysCultureScientifiqueRecontreGrandPublicJeunePublics;

public  CultureScientifiqueRecontreGrandPublicJeunePublicConverter(){
init(true);
}

@Override
public CultureScientifiqueRecontreGrandPublicJeunePublic toItem(CultureScientifiqueRecontreGrandPublicJeunePublicVo vo) {
if (vo == null) {
return null;
} else {
CultureScientifiqueRecontreGrandPublicJeunePublic item = new CultureScientifiqueRecontreGrandPublicJeunePublic();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getTempsEstimePourCetteAnnne()))
        item.setTempsEstimePourCetteAnnne(NumberUtil.toBigDecimal(vo.getTempsEstimePourCetteAnnne()));
        if(StringUtil.isNotEmpty(vo.getIntituleSujet()))
        item.setIntituleSujet(vo.getIntituleSujet());
        if(StringUtil.isNotEmpty(vo.getPeriodeAnnee()))
        item.setPeriodeAnnee(NumberUtil.toInt(vo.getPeriodeAnnee()));
        if(StringUtil.isNotEmpty(vo.getPeriodeMois()))
        item.setPeriodeMois(NumberUtil.toInt(vo.getPeriodeMois()));
        if(StringUtil.isNotEmpty(vo.getEvenementGrandPublic()))
        item.setEvenementGrandPublic(NumberUtil.toBoolean(vo.getEvenementGrandPublic()));
        if(StringUtil.isNotEmpty(vo.getVolumePublic()))
        item.setVolumePublic(NumberUtil.toBigDecimal(vo.getVolumePublic()));
        if(StringUtil.isNotEmpty(vo.getLienWeb()))
        item.setLienWeb(vo.getLienWeb());
    if(vo.getFormatRencontreVo()!=null && this.formatRencontre)
        item.setFormatRencontre(formatRencontreConverter.toItem(vo.getFormatRencontreVo())) ;
    if(vo.getCampagneVo()!=null && this.campagne)
        item.setCampagne(campagneConverter.toItem(vo.getCampagneVo())) ;
    if(vo.getChercheurVo()!=null && this.chercheur)
        item.setChercheur(chercheurConverter.toItem(vo.getChercheurVo())) ;

    if(ListUtil.isNotEmpty(vo.getPublicCibleCultureScientifiqueRecontresGrandPublicJeunePublicsVo()) && this.publicCibleCultureScientifiqueRecontresGrandPublicJeunePublics)
        item.setPublicCibleCultureScientifiqueRecontresGrandPublicJeunePublics(publicCibleCultureScientifiqueRecontreGrandPublicConverter.toItem(vo.getPublicCibleCultureScientifiqueRecontresGrandPublicJeunePublicsVo()));
    if(ListUtil.isNotEmpty(vo.getContexteCultureScientifiqueRecontreGrandPublicJeunePublicsVo()) && this.contexteCultureScientifiqueRecontreGrandPublicJeunePublics)
        item.setContexteCultureScientifiqueRecontreGrandPublicJeunePublics(contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(vo.getContexteCultureScientifiqueRecontreGrandPublicJeunePublicsVo()));
    if(ListUtil.isNotEmpty(vo.getEtablissementCultureScientifiqueRecontreGrandPublicJeunePublicsVo()) && this.etablissementCultureScientifiqueRecontreGrandPublicJeunePublics)
        item.setEtablissementCultureScientifiqueRecontreGrandPublicJeunePublics(etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(vo.getEtablissementCultureScientifiqueRecontreGrandPublicJeunePublicsVo()));
    if(ListUtil.isNotEmpty(vo.getPaysCultureScientifiqueRecontreGrandPublicJeunePublicsVo()) && this.paysCultureScientifiqueRecontreGrandPublicJeunePublics)
        item.setPaysCultureScientifiqueRecontreGrandPublicJeunePublics(paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(vo.getPaysCultureScientifiqueRecontreGrandPublicJeunePublicsVo()));

return item;
}
}

@Override
public CultureScientifiqueRecontreGrandPublicJeunePublicVo toVo(CultureScientifiqueRecontreGrandPublicJeunePublic item) {
if (item == null) {
return null;
} else {
CultureScientifiqueRecontreGrandPublicJeunePublicVo vo = new CultureScientifiqueRecontreGrandPublicJeunePublicVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(item.getTempsEstimePourCetteAnnne()!=null)
        vo.setTempsEstimePourCetteAnnne(NumberUtil.toString(item.getTempsEstimePourCetteAnnne()));
        if(StringUtil.isNotEmpty(item.getIntituleSujet()))
        vo.setIntituleSujet(item.getIntituleSujet());

        if(item.getPeriodeAnnee()!=null)
        vo.setPeriodeAnnee(NumberUtil.toString(item.getPeriodeAnnee()));
        if(item.getPeriodeMois()!=null)
        vo.setPeriodeMois(NumberUtil.toString(item.getPeriodeMois()));
        if(item.getEvenementGrandPublic()!=null)
        vo.setEvenementGrandPublic(NumberUtil.toString(item.getEvenementGrandPublic()));
        if(item.getVolumePublic()!=null)
        vo.setVolumePublic(NumberUtil.toString(item.getVolumePublic()));
        if(StringUtil.isNotEmpty(item.getLienWeb()))
        vo.setLienWeb(item.getLienWeb());

    if(item.getFormatRencontre()!=null && this.formatRencontre) {
        vo.setFormatRencontreVo(formatRencontreConverter.toVo(item.getFormatRencontre())) ;
    }
    if(item.getCampagne()!=null && this.campagne) {
        vo.setCampagneVo(campagneConverter.toVo(item.getCampagne())) ;
    }
    if(item.getChercheur()!=null && this.chercheur) {
        vo.setChercheurVo(chercheurConverter.toVo(item.getChercheur())) ;
    }
        if(ListUtil.isNotEmpty(item.getPublicCibleCultureScientifiqueRecontresGrandPublicJeunePublics()) && this.publicCibleCultureScientifiqueRecontresGrandPublicJeunePublics){
        publicCibleCultureScientifiqueRecontreGrandPublicConverter.init(true);
        publicCibleCultureScientifiqueRecontreGrandPublicConverter.setCultureScientifiqueRecontreGrandPublicJeunePublic(false);
        vo.setPublicCibleCultureScientifiqueRecontresGrandPublicJeunePublicsVo(publicCibleCultureScientifiqueRecontreGrandPublicConverter.toVo(item.getPublicCibleCultureScientifiqueRecontresGrandPublicJeunePublics()));
        }
        if(ListUtil.isNotEmpty(item.getContexteCultureScientifiqueRecontreGrandPublicJeunePublics()) && this.contexteCultureScientifiqueRecontreGrandPublicJeunePublics){
        contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter.init(true);
        contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter.setCultureScientifiqueRecontreGrandPublicJeunePublic(false);
        vo.setContexteCultureScientifiqueRecontreGrandPublicJeunePublicsVo(contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(item.getContexteCultureScientifiqueRecontreGrandPublicJeunePublics()));
        }
        if(ListUtil.isNotEmpty(item.getEtablissementCultureScientifiqueRecontreGrandPublicJeunePublics()) && this.etablissementCultureScientifiqueRecontreGrandPublicJeunePublics){
        etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter.init(true);
        etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter.setCultureScientifiqueRecontreGrandPublicJeunePublic(false);
        vo.setEtablissementCultureScientifiqueRecontreGrandPublicJeunePublicsVo(etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(item.getEtablissementCultureScientifiqueRecontreGrandPublicJeunePublics()));
        }
        if(ListUtil.isNotEmpty(item.getPaysCultureScientifiqueRecontreGrandPublicJeunePublics()) && this.paysCultureScientifiqueRecontreGrandPublicJeunePublics){
        paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter.init(true);
        paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter.setCultureScientifiqueRecontreGrandPublicJeunePublic(false);
        vo.setPaysCultureScientifiqueRecontreGrandPublicJeunePublicsVo(paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(item.getPaysCultureScientifiqueRecontreGrandPublicJeunePublics()));
        }

return vo;
}
}

public void init(Boolean value) {
    formatRencontre = value;
    campagne = value;
    chercheur = value;
        publicCibleCultureScientifiqueRecontresGrandPublicJeunePublics = value;
        contexteCultureScientifiqueRecontreGrandPublicJeunePublics = value;
        etablissementCultureScientifiqueRecontreGrandPublicJeunePublics = value;
        paysCultureScientifiqueRecontreGrandPublicJeunePublics = value;
}


        public PaysCultureScientifiqueRecontreGrandPublicJeunePublicConverter getPaysCultureScientifiqueRecontreGrandPublicJeunePublicConverter(){
        return this.paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter;
        }
        public void setPaysCultureScientifiqueRecontreGrandPublicJeunePublicConverter(PaysCultureScientifiqueRecontreGrandPublicJeunePublicConverter paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter ){
        this.paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter = paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter;
        }
        public PublicCibleCultureScientifiqueRecontreGrandPublicConverter getPublicCibleCultureScientifiqueRecontreGrandPublicConverter(){
        return this.publicCibleCultureScientifiqueRecontreGrandPublicConverter;
        }
        public void setPublicCibleCultureScientifiqueRecontreGrandPublicConverter(PublicCibleCultureScientifiqueRecontreGrandPublicConverter publicCibleCultureScientifiqueRecontreGrandPublicConverter ){
        this.publicCibleCultureScientifiqueRecontreGrandPublicConverter = publicCibleCultureScientifiqueRecontreGrandPublicConverter;
        }
        public EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter getEtablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter(){
        return this.etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter;
        }
        public void setEtablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter(EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter ){
        this.etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter = etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter;
        }
        public FormatRencontreConverter getFormatRencontreConverter(){
        return this.formatRencontreConverter;
        }
        public void setFormatRencontreConverter(FormatRencontreConverter formatRencontreConverter ){
        this.formatRencontreConverter = formatRencontreConverter;
        }
        public ContexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter getContexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter(){
        return this.contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter;
        }
        public void setContexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter(ContexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter ){
        this.contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter = contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter;
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

    public boolean  isFormatRencontre(){
    return this.formatRencontre;
    }
    public void  setFormatRencontre(boolean formatRencontre){
    this.formatRencontre = formatRencontre;
    }
    public boolean  isCampagne(){
    return this.campagne;
    }
    public void  setCampagne(boolean campagne){
    this.campagne = campagne;
    }
    public boolean  isChercheur(){
    return this.chercheur;
    }
    public void  setChercheur(boolean chercheur){
    this.chercheur = chercheur;
    }





        public Boolean  isPublicCibleCultureScientifiqueRecontresGrandPublicJeunePublics(){
        return this.publicCibleCultureScientifiqueRecontresGrandPublicJeunePublics ;
        }
        public void  setPublicCibleCultureScientifiqueRecontresGrandPublicJeunePublics(Boolean publicCibleCultureScientifiqueRecontresGrandPublicJeunePublics ){
        this.publicCibleCultureScientifiqueRecontresGrandPublicJeunePublics  = publicCibleCultureScientifiqueRecontresGrandPublicJeunePublics ;
        }





        public Boolean  isContexteCultureScientifiqueRecontreGrandPublicJeunePublics(){
        return this.contexteCultureScientifiqueRecontreGrandPublicJeunePublics ;
        }
        public void  setContexteCultureScientifiqueRecontreGrandPublicJeunePublics(Boolean contexteCultureScientifiqueRecontreGrandPublicJeunePublics ){
        this.contexteCultureScientifiqueRecontreGrandPublicJeunePublics  = contexteCultureScientifiqueRecontreGrandPublicJeunePublics ;
        }









        public Boolean  isEtablissementCultureScientifiqueRecontreGrandPublicJeunePublics(){
        return this.etablissementCultureScientifiqueRecontreGrandPublicJeunePublics ;
        }
        public void  setEtablissementCultureScientifiqueRecontreGrandPublicJeunePublics(Boolean etablissementCultureScientifiqueRecontreGrandPublicJeunePublics ){
        this.etablissementCultureScientifiqueRecontreGrandPublicJeunePublics  = etablissementCultureScientifiqueRecontreGrandPublicJeunePublics ;
        }







        public Boolean  isPaysCultureScientifiqueRecontreGrandPublicJeunePublics(){
        return this.paysCultureScientifiqueRecontreGrandPublicJeunePublics ;
        }
        public void  setPaysCultureScientifiqueRecontreGrandPublicJeunePublics(Boolean paysCultureScientifiqueRecontreGrandPublicJeunePublics ){
        this.paysCultureScientifiqueRecontreGrandPublicJeunePublics  = paysCultureScientifiqueRecontreGrandPublicJeunePublics ;
        }








}
