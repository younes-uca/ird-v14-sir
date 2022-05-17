package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.EvaluationRechercheUniversitaire;
import com.ird.faa.ws.rest.provided.vo.EvaluationRechercheUniversitaireVo;

@Component
public class EvaluationRechercheUniversitaireConverter extends AbstractConverter<EvaluationRechercheUniversitaire,EvaluationRechercheUniversitaireVo>{

        @Autowired
        private RoleEvaluationRechercheUniversitaireConverter roleEvaluationRechercheUniversitaireConverter ;
        @Autowired
        private EtatEtapeCampagneConverter etatEtapeCampagneConverter ;
        @Autowired
        private CommunauteSavoirEvaluationRechercheUniversitaireConverter communauteSavoirEvaluationRechercheUniversitaireConverter ;
        @Autowired
        private DisciplineScientifiqueEvaluationRechercheUniversitaireConverter disciplineScientifiqueEvaluationRechercheUniversitaireConverter ;
        @Autowired
        private TypeExpertConverter typeExpertConverter ;
        @Autowired
        private EtablissementConverter etablissementConverter ;
        @Autowired
        private CampagneConverter campagneConverter ;
        @Autowired
        private PaysConverter paysConverter ;
        @Autowired
        private ChercheurConverter chercheurConverter ;
    private Boolean typeExpert;
    private Boolean roleEvaluationRechercheUniversitaire;
    private Boolean pays;
    private Boolean etablissement;
    private Boolean chercheur;
    private Boolean campagne;
    private Boolean etatEtapeCampagne;
        private Boolean communauteSavoirEvaluationRechercheUniversitaires;
        private Boolean disciplineScientifiqueEvaluationRechercheUniversitaires;

public  EvaluationRechercheUniversitaireConverter(){
init(true);
}

@Override
public EvaluationRechercheUniversitaire toItem(EvaluationRechercheUniversitaireVo vo) {
if (vo == null) {
return null;
} else {
EvaluationRechercheUniversitaire item = new EvaluationRechercheUniversitaire();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getAnnee()))
        item.setAnnee(NumberUtil.toInt(vo.getAnnee()));
        if(StringUtil.isNotEmpty(vo.getNombreJourConsacrePourCetteAnnee()))
        item.setNombreJourConsacrePourCetteAnnee(NumberUtil.toBigDecimal(vo.getNombreJourConsacrePourCetteAnnee()));
        if(StringUtil.isNotEmpty(vo.getCommentaire()))
        item.setCommentaire(vo.getCommentaire());
    if(vo.getTypeExpertVo()!=null && this.typeExpert)
        item.setTypeExpert(typeExpertConverter.toItem(vo.getTypeExpertVo())) ;
    if(vo.getRoleEvaluationRechercheUniversitaireVo()!=null && this.roleEvaluationRechercheUniversitaire)
        item.setRoleEvaluationRechercheUniversitaire(roleEvaluationRechercheUniversitaireConverter.toItem(vo.getRoleEvaluationRechercheUniversitaireVo())) ;
    if(vo.getPaysVo()!=null && this.pays)
        item.setPays(paysConverter.toItem(vo.getPaysVo())) ;
    if(vo.getEtablissementVo()!=null && this.etablissement)
        item.setEtablissement(etablissementConverter.toItem(vo.getEtablissementVo())) ;
    if(vo.getChercheurVo()!=null && this.chercheur)
        item.setChercheur(chercheurConverter.toItem(vo.getChercheurVo())) ;
    if(vo.getCampagneVo()!=null && this.campagne)
        item.setCampagne(campagneConverter.toItem(vo.getCampagneVo())) ;
    if(vo.getEtatEtapeCampagneVo()!=null && this.etatEtapeCampagne)
        item.setEtatEtapeCampagne(etatEtapeCampagneConverter.toItem(vo.getEtatEtapeCampagneVo())) ;

    if(ListUtil.isNotEmpty(vo.getCommunauteSavoirEvaluationRechercheUniversitairesVo()) && this.communauteSavoirEvaluationRechercheUniversitaires)
        item.setCommunauteSavoirEvaluationRechercheUniversitaires(communauteSavoirEvaluationRechercheUniversitaireConverter.toItem(vo.getCommunauteSavoirEvaluationRechercheUniversitairesVo()));
    if(ListUtil.isNotEmpty(vo.getDisciplineScientifiqueEvaluationRechercheUniversitairesVo()) && this.disciplineScientifiqueEvaluationRechercheUniversitaires)
        item.setDisciplineScientifiqueEvaluationRechercheUniversitaires(disciplineScientifiqueEvaluationRechercheUniversitaireConverter.toItem(vo.getDisciplineScientifiqueEvaluationRechercheUniversitairesVo()));

return item;
}
}

@Override
public EvaluationRechercheUniversitaireVo toVo(EvaluationRechercheUniversitaire item) {
if (item == null) {
return null;
} else {
EvaluationRechercheUniversitaireVo vo = new EvaluationRechercheUniversitaireVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(item.getAnnee()!=null)
        vo.setAnnee(NumberUtil.toString(item.getAnnee()));
        if(item.getNombreJourConsacrePourCetteAnnee()!=null)
        vo.setNombreJourConsacrePourCetteAnnee(NumberUtil.toString(item.getNombreJourConsacrePourCetteAnnee()));
        if(StringUtil.isNotEmpty(item.getCommentaire()))
        vo.setCommentaire(item.getCommentaire());

    if(item.getTypeExpert()!=null && this.typeExpert) {
        vo.setTypeExpertVo(typeExpertConverter.toVo(item.getTypeExpert())) ;
    }
    if(item.getRoleEvaluationRechercheUniversitaire()!=null && this.roleEvaluationRechercheUniversitaire) {
        vo.setRoleEvaluationRechercheUniversitaireVo(roleEvaluationRechercheUniversitaireConverter.toVo(item.getRoleEvaluationRechercheUniversitaire())) ;
    }
    if(item.getPays()!=null && this.pays) {
        vo.setPaysVo(paysConverter.toVo(item.getPays())) ;
    }
    if(item.getEtablissement()!=null && this.etablissement) {
        vo.setEtablissementVo(etablissementConverter.toVo(item.getEtablissement())) ;
    }
    if(item.getChercheur()!=null && this.chercheur) {
        vo.setChercheurVo(chercheurConverter.toVo(item.getChercheur())) ;
    }
    if(item.getCampagne()!=null && this.campagne) {
        vo.setCampagneVo(campagneConverter.toVo(item.getCampagne())) ;
    }
    if(item.getEtatEtapeCampagne()!=null && this.etatEtapeCampagne) {
        vo.setEtatEtapeCampagneVo(etatEtapeCampagneConverter.toVo(item.getEtatEtapeCampagne())) ;
    }
        if(ListUtil.isNotEmpty(item.getCommunauteSavoirEvaluationRechercheUniversitaires()) && this.communauteSavoirEvaluationRechercheUniversitaires){
        communauteSavoirEvaluationRechercheUniversitaireConverter.init(true);
        communauteSavoirEvaluationRechercheUniversitaireConverter.setEvaluationRechercheUniversitaire(false);
        vo.setCommunauteSavoirEvaluationRechercheUniversitairesVo(communauteSavoirEvaluationRechercheUniversitaireConverter.toVo(item.getCommunauteSavoirEvaluationRechercheUniversitaires()));
        }
        if(ListUtil.isNotEmpty(item.getDisciplineScientifiqueEvaluationRechercheUniversitaires()) && this.disciplineScientifiqueEvaluationRechercheUniversitaires){
        disciplineScientifiqueEvaluationRechercheUniversitaireConverter.init(true);
        disciplineScientifiqueEvaluationRechercheUniversitaireConverter.setEvaluationRechercheUniversitaire(false);
        vo.setDisciplineScientifiqueEvaluationRechercheUniversitairesVo(disciplineScientifiqueEvaluationRechercheUniversitaireConverter.toVo(item.getDisciplineScientifiqueEvaluationRechercheUniversitaires()));
        }

return vo;
}
}

public void init(Boolean value) {
    typeExpert = value;
    roleEvaluationRechercheUniversitaire = value;
    pays = value;
    etablissement = value;
    chercheur = value;
    campagne = value;
    etatEtapeCampagne = value;
        communauteSavoirEvaluationRechercheUniversitaires = value;
        disciplineScientifiqueEvaluationRechercheUniversitaires = value;
}


        public RoleEvaluationRechercheUniversitaireConverter getRoleEvaluationRechercheUniversitaireConverter(){
        return this.roleEvaluationRechercheUniversitaireConverter;
        }
        public void setRoleEvaluationRechercheUniversitaireConverter(RoleEvaluationRechercheUniversitaireConverter roleEvaluationRechercheUniversitaireConverter ){
        this.roleEvaluationRechercheUniversitaireConverter = roleEvaluationRechercheUniversitaireConverter;
        }
        public EtatEtapeCampagneConverter getEtatEtapeCampagneConverter(){
        return this.etatEtapeCampagneConverter;
        }
        public void setEtatEtapeCampagneConverter(EtatEtapeCampagneConverter etatEtapeCampagneConverter ){
        this.etatEtapeCampagneConverter = etatEtapeCampagneConverter;
        }
        public CommunauteSavoirEvaluationRechercheUniversitaireConverter getCommunauteSavoirEvaluationRechercheUniversitaireConverter(){
        return this.communauteSavoirEvaluationRechercheUniversitaireConverter;
        }
        public void setCommunauteSavoirEvaluationRechercheUniversitaireConverter(CommunauteSavoirEvaluationRechercheUniversitaireConverter communauteSavoirEvaluationRechercheUniversitaireConverter ){
        this.communauteSavoirEvaluationRechercheUniversitaireConverter = communauteSavoirEvaluationRechercheUniversitaireConverter;
        }
        public DisciplineScientifiqueEvaluationRechercheUniversitaireConverter getDisciplineScientifiqueEvaluationRechercheUniversitaireConverter(){
        return this.disciplineScientifiqueEvaluationRechercheUniversitaireConverter;
        }
        public void setDisciplineScientifiqueEvaluationRechercheUniversitaireConverter(DisciplineScientifiqueEvaluationRechercheUniversitaireConverter disciplineScientifiqueEvaluationRechercheUniversitaireConverter ){
        this.disciplineScientifiqueEvaluationRechercheUniversitaireConverter = disciplineScientifiqueEvaluationRechercheUniversitaireConverter;
        }
        public TypeExpertConverter getTypeExpertConverter(){
        return this.typeExpertConverter;
        }
        public void setTypeExpertConverter(TypeExpertConverter typeExpertConverter ){
        this.typeExpertConverter = typeExpertConverter;
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
        public PaysConverter getPaysConverter(){
        return this.paysConverter;
        }
        public void setPaysConverter(PaysConverter paysConverter ){
        this.paysConverter = paysConverter;
        }
        public ChercheurConverter getChercheurConverter(){
        return this.chercheurConverter;
        }
        public void setChercheurConverter(ChercheurConverter chercheurConverter ){
        this.chercheurConverter = chercheurConverter;
        }

    public boolean  isTypeExpert(){
    return this.typeExpert;
    }
    public void  setTypeExpert(boolean typeExpert){
    this.typeExpert = typeExpert;
    }
    public boolean  isRoleEvaluationRechercheUniversitaire(){
    return this.roleEvaluationRechercheUniversitaire;
    }
    public void  setRoleEvaluationRechercheUniversitaire(boolean roleEvaluationRechercheUniversitaire){
    this.roleEvaluationRechercheUniversitaire = roleEvaluationRechercheUniversitaire;
    }
    public boolean  isPays(){
    return this.pays;
    }
    public void  setPays(boolean pays){
    this.pays = pays;
    }
    public boolean  isEtablissement(){
    return this.etablissement;
    }
    public void  setEtablissement(boolean etablissement){
    this.etablissement = etablissement;
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
    public boolean  isEtatEtapeCampagne(){
    return this.etatEtapeCampagne;
    }
    public void  setEtatEtapeCampagne(boolean etatEtapeCampagne){
    this.etatEtapeCampagne = etatEtapeCampagne;
    }















        public Boolean  isCommunauteSavoirEvaluationRechercheUniversitaires(){
        return this.communauteSavoirEvaluationRechercheUniversitaires ;
        }
        public void  setCommunauteSavoirEvaluationRechercheUniversitaires(Boolean communauteSavoirEvaluationRechercheUniversitaires ){
        this.communauteSavoirEvaluationRechercheUniversitaires  = communauteSavoirEvaluationRechercheUniversitaires ;
        }



        public Boolean  isDisciplineScientifiqueEvaluationRechercheUniversitaires(){
        return this.disciplineScientifiqueEvaluationRechercheUniversitaires ;
        }
        public void  setDisciplineScientifiqueEvaluationRechercheUniversitaires(Boolean disciplineScientifiqueEvaluationRechercheUniversitaires ){
        this.disciplineScientifiqueEvaluationRechercheUniversitaires  = disciplineScientifiqueEvaluationRechercheUniversitaires ;
        }










}
