package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.CultureScientifiqueOutilPedagogique;
import com.ird.faa.ws.rest.provided.vo.CultureScientifiqueOutilPedagogiqueVo;

@Component
public class CultureScientifiqueOutilPedagogiqueConverter extends AbstractConverter<CultureScientifiqueOutilPedagogique,CultureScientifiqueOutilPedagogiqueVo>{

        @Autowired
        private EtablissementCultureScientifiqueOutilPedagogiqueConverter etablissementCultureScientifiqueOutilPedagogiqueConverter ;
        @Autowired
        private EtatEtapeCampagneConverter etatEtapeCampagneConverter ;
        @Autowired
        private PaysTypeOutilCultureScientifiqueOutilPedagogiqueConverter paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter ;
        @Autowired
        private TypeOutilCultureScientifiqueOutilPedagogiqueConverter typeOutilCultureScientifiqueOutilPedagogiqueConverter ;
        @Autowired
        private CampagneConverter campagneConverter ;
        @Autowired
        private PublicCibleCultureScientifiqueOutilPedagogiqueConverter publicCibleCultureScientifiqueOutilPedagogiqueConverter ;
        @Autowired
        private ChercheurConverter chercheurConverter ;
    private Boolean campagne;
    private Boolean chercheur;
    private Boolean etatEtapeCampagne;
        private Boolean publicCibleCultureScientifiqueOutilPedagogiques;
        private Boolean typeOutilCultureScientifiqueOutilPedagogiques;
        private Boolean paysTypeOutilCultureScientifiqueOutilPedagogiques;
        private Boolean etablissementCultureScientifiqueOutilPedagogiques;

public  CultureScientifiqueOutilPedagogiqueConverter(){
init(true);
}

@Override
public CultureScientifiqueOutilPedagogique toItem(CultureScientifiqueOutilPedagogiqueVo vo) {
if (vo == null) {
return null;
} else {
CultureScientifiqueOutilPedagogique item = new CultureScientifiqueOutilPedagogique();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getRole()))
        item.setRole(vo.getRole());
        if(StringUtil.isNotEmpty(vo.getNomOutil()))
        item.setNomOutil(vo.getNomOutil());
        if(StringUtil.isNotEmpty(vo.getSortieAnnee()))
        item.setSortieAnnee(NumberUtil.toInt(vo.getSortieAnnee()));
        if(StringUtil.isNotEmpty(vo.getSortieMois()))
        item.setSortieMois(NumberUtil.toInt(vo.getSortieMois()));
        if(StringUtil.isNotEmpty(vo.getLienWeb()))
        item.setLienWeb(vo.getLienWeb());
    if(vo.getCampagneVo()!=null && this.campagne)
        item.setCampagne(campagneConverter.toItem(vo.getCampagneVo())) ;
    if(vo.getChercheurVo()!=null && this.chercheur)
        item.setChercheur(chercheurConverter.toItem(vo.getChercheurVo())) ;
    if(vo.getEtatEtapeCampagneVo()!=null && this.etatEtapeCampagne)
        item.setEtatEtapeCampagne(etatEtapeCampagneConverter.toItem(vo.getEtatEtapeCampagneVo())) ;

    if(ListUtil.isNotEmpty(vo.getPublicCibleCultureScientifiqueOutilPedagogiquesVo()) && this.publicCibleCultureScientifiqueOutilPedagogiques)
        item.setPublicCibleCultureScientifiqueOutilPedagogiques(publicCibleCultureScientifiqueOutilPedagogiqueConverter.toItem(vo.getPublicCibleCultureScientifiqueOutilPedagogiquesVo()));
    if(ListUtil.isNotEmpty(vo.getTypeOutilCultureScientifiqueOutilPedagogiquesVo()) && this.typeOutilCultureScientifiqueOutilPedagogiques)
        item.setTypeOutilCultureScientifiqueOutilPedagogiques(typeOutilCultureScientifiqueOutilPedagogiqueConverter.toItem(vo.getTypeOutilCultureScientifiqueOutilPedagogiquesVo()));
    if(ListUtil.isNotEmpty(vo.getPaysTypeOutilCultureScientifiqueOutilPedagogiquesVo()) && this.paysTypeOutilCultureScientifiqueOutilPedagogiques)
        item.setPaysTypeOutilCultureScientifiqueOutilPedagogiques(paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter.toItem(vo.getPaysTypeOutilCultureScientifiqueOutilPedagogiquesVo()));
    if(ListUtil.isNotEmpty(vo.getEtablissementCultureScientifiqueOutilPedagogiquesVo()) && this.etablissementCultureScientifiqueOutilPedagogiques)
        item.setEtablissementCultureScientifiqueOutilPedagogiques(etablissementCultureScientifiqueOutilPedagogiqueConverter.toItem(vo.getEtablissementCultureScientifiqueOutilPedagogiquesVo()));

return item;
}
}

@Override
public CultureScientifiqueOutilPedagogiqueVo toVo(CultureScientifiqueOutilPedagogique item) {
if (item == null) {
return null;
} else {
CultureScientifiqueOutilPedagogiqueVo vo = new CultureScientifiqueOutilPedagogiqueVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getRole()))
        vo.setRole(item.getRole());

        if(StringUtil.isNotEmpty(item.getNomOutil()))
        vo.setNomOutil(item.getNomOutil());

        if(item.getSortieAnnee()!=null)
        vo.setSortieAnnee(NumberUtil.toString(item.getSortieAnnee()));
        if(item.getSortieMois()!=null)
        vo.setSortieMois(NumberUtil.toString(item.getSortieMois()));
        if(StringUtil.isNotEmpty(item.getLienWeb()))
        vo.setLienWeb(item.getLienWeb());

    if(item.getCampagne()!=null && this.campagne) {
        vo.setCampagneVo(campagneConverter.toVo(item.getCampagne())) ;
    }
    if(item.getChercheur()!=null && this.chercheur) {
        vo.setChercheurVo(chercheurConverter.toVo(item.getChercheur())) ;
    }
    if(item.getEtatEtapeCampagne()!=null && this.etatEtapeCampagne) {
        vo.setEtatEtapeCampagneVo(etatEtapeCampagneConverter.toVo(item.getEtatEtapeCampagne())) ;
    }
        if(ListUtil.isNotEmpty(item.getPublicCibleCultureScientifiqueOutilPedagogiques()) && this.publicCibleCultureScientifiqueOutilPedagogiques){
        publicCibleCultureScientifiqueOutilPedagogiqueConverter.init(true);
        publicCibleCultureScientifiqueOutilPedagogiqueConverter.setCultureScientifiqueOutilPedagogique(false);
        vo.setPublicCibleCultureScientifiqueOutilPedagogiquesVo(publicCibleCultureScientifiqueOutilPedagogiqueConverter.toVo(item.getPublicCibleCultureScientifiqueOutilPedagogiques()));
        }
        if(ListUtil.isNotEmpty(item.getTypeOutilCultureScientifiqueOutilPedagogiques()) && this.typeOutilCultureScientifiqueOutilPedagogiques){
        typeOutilCultureScientifiqueOutilPedagogiqueConverter.init(true);
        typeOutilCultureScientifiqueOutilPedagogiqueConverter.setCultureScientifiqueOutilPedagogique(false);
        vo.setTypeOutilCultureScientifiqueOutilPedagogiquesVo(typeOutilCultureScientifiqueOutilPedagogiqueConverter.toVo(item.getTypeOutilCultureScientifiqueOutilPedagogiques()));
        }
        if(ListUtil.isNotEmpty(item.getPaysTypeOutilCultureScientifiqueOutilPedagogiques()) && this.paysTypeOutilCultureScientifiqueOutilPedagogiques){
        paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter.init(true);
        paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter.setCultureScientifiqueOutilPedagogique(false);
        vo.setPaysTypeOutilCultureScientifiqueOutilPedagogiquesVo(paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter.toVo(item.getPaysTypeOutilCultureScientifiqueOutilPedagogiques()));
        }
        if(ListUtil.isNotEmpty(item.getEtablissementCultureScientifiqueOutilPedagogiques()) && this.etablissementCultureScientifiqueOutilPedagogiques){
        etablissementCultureScientifiqueOutilPedagogiqueConverter.init(true);
        etablissementCultureScientifiqueOutilPedagogiqueConverter.setCultureScientifiqueOutilPedagogique(false);
        vo.setEtablissementCultureScientifiqueOutilPedagogiquesVo(etablissementCultureScientifiqueOutilPedagogiqueConverter.toVo(item.getEtablissementCultureScientifiqueOutilPedagogiques()));
        }

return vo;
}
}

public void init(Boolean value) {
    campagne = value;
    chercheur = value;
    etatEtapeCampagne = value;
        publicCibleCultureScientifiqueOutilPedagogiques = value;
        typeOutilCultureScientifiqueOutilPedagogiques = value;
        paysTypeOutilCultureScientifiqueOutilPedagogiques = value;
        etablissementCultureScientifiqueOutilPedagogiques = value;
}


        public EtablissementCultureScientifiqueOutilPedagogiqueConverter getEtablissementCultureScientifiqueOutilPedagogiqueConverter(){
        return this.etablissementCultureScientifiqueOutilPedagogiqueConverter;
        }
        public void setEtablissementCultureScientifiqueOutilPedagogiqueConverter(EtablissementCultureScientifiqueOutilPedagogiqueConverter etablissementCultureScientifiqueOutilPedagogiqueConverter ){
        this.etablissementCultureScientifiqueOutilPedagogiqueConverter = etablissementCultureScientifiqueOutilPedagogiqueConverter;
        }
        public EtatEtapeCampagneConverter getEtatEtapeCampagneConverter(){
        return this.etatEtapeCampagneConverter;
        }
        public void setEtatEtapeCampagneConverter(EtatEtapeCampagneConverter etatEtapeCampagneConverter ){
        this.etatEtapeCampagneConverter = etatEtapeCampagneConverter;
        }
        public PaysTypeOutilCultureScientifiqueOutilPedagogiqueConverter getPaysTypeOutilCultureScientifiqueOutilPedagogiqueConverter(){
        return this.paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter;
        }
        public void setPaysTypeOutilCultureScientifiqueOutilPedagogiqueConverter(PaysTypeOutilCultureScientifiqueOutilPedagogiqueConverter paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter ){
        this.paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter = paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter;
        }
        public TypeOutilCultureScientifiqueOutilPedagogiqueConverter getTypeOutilCultureScientifiqueOutilPedagogiqueConverter(){
        return this.typeOutilCultureScientifiqueOutilPedagogiqueConverter;
        }
        public void setTypeOutilCultureScientifiqueOutilPedagogiqueConverter(TypeOutilCultureScientifiqueOutilPedagogiqueConverter typeOutilCultureScientifiqueOutilPedagogiqueConverter ){
        this.typeOutilCultureScientifiqueOutilPedagogiqueConverter = typeOutilCultureScientifiqueOutilPedagogiqueConverter;
        }
        public CampagneConverter getCampagneConverter(){
        return this.campagneConverter;
        }
        public void setCampagneConverter(CampagneConverter campagneConverter ){
        this.campagneConverter = campagneConverter;
        }
        public PublicCibleCultureScientifiqueOutilPedagogiqueConverter getPublicCibleCultureScientifiqueOutilPedagogiqueConverter(){
        return this.publicCibleCultureScientifiqueOutilPedagogiqueConverter;
        }
        public void setPublicCibleCultureScientifiqueOutilPedagogiqueConverter(PublicCibleCultureScientifiqueOutilPedagogiqueConverter publicCibleCultureScientifiqueOutilPedagogiqueConverter ){
        this.publicCibleCultureScientifiqueOutilPedagogiqueConverter = publicCibleCultureScientifiqueOutilPedagogiqueConverter;
        }
        public ChercheurConverter getChercheurConverter(){
        return this.chercheurConverter;
        }
        public void setChercheurConverter(ChercheurConverter chercheurConverter ){
        this.chercheurConverter = chercheurConverter;
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
    public boolean  isEtatEtapeCampagne(){
    return this.etatEtapeCampagne;
    }
    public void  setEtatEtapeCampagne(boolean etatEtapeCampagne){
    this.etatEtapeCampagne = etatEtapeCampagne;
    }



        public Boolean  isPublicCibleCultureScientifiqueOutilPedagogiques(){
        return this.publicCibleCultureScientifiqueOutilPedagogiques ;
        }
        public void  setPublicCibleCultureScientifiqueOutilPedagogiques(Boolean publicCibleCultureScientifiqueOutilPedagogiques ){
        this.publicCibleCultureScientifiqueOutilPedagogiques  = publicCibleCultureScientifiqueOutilPedagogiques ;
        }





        public Boolean  isTypeOutilCultureScientifiqueOutilPedagogiques(){
        return this.typeOutilCultureScientifiqueOutilPedagogiques ;
        }
        public void  setTypeOutilCultureScientifiqueOutilPedagogiques(Boolean typeOutilCultureScientifiqueOutilPedagogiques ){
        this.typeOutilCultureScientifiqueOutilPedagogiques  = typeOutilCultureScientifiqueOutilPedagogiques ;
        }









        public Boolean  isPaysTypeOutilCultureScientifiqueOutilPedagogiques(){
        return this.paysTypeOutilCultureScientifiqueOutilPedagogiques ;
        }
        public void  setPaysTypeOutilCultureScientifiqueOutilPedagogiques(Boolean paysTypeOutilCultureScientifiqueOutilPedagogiques ){
        this.paysTypeOutilCultureScientifiqueOutilPedagogiques  = paysTypeOutilCultureScientifiqueOutilPedagogiques ;
        }



        public Boolean  isEtablissementCultureScientifiqueOutilPedagogiques(){
        return this.etablissementCultureScientifiqueOutilPedagogiques ;
        }
        public void  setEtablissementCultureScientifiqueOutilPedagogiques(Boolean etablissementCultureScientifiqueOutilPedagogiques ){
        this.etablissementCultureScientifiqueOutilPedagogiques  = etablissementCultureScientifiqueOutilPedagogiques ;
        }










}
