package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.InstitutionCoContractantProjetActiviteRecherche;
import com.ird.faa.ws.rest.provided.vo.InstitutionCoContractantProjetActiviteRechercheVo;

@Component
public class InstitutionCoContractantProjetActiviteRechercheConverter extends AbstractConverter<InstitutionCoContractantProjetActiviteRecherche,InstitutionCoContractantProjetActiviteRechercheVo>{

        @Autowired
        private ProjetActiviteRechercheConverter projetActiviteRechercheConverter ;
        @Autowired
        private InstitutionCoContractantConverter institutionCoContractantConverter ;
    private Boolean institutionCoContractant;
    private Boolean projetActiviteRecherche;

public  InstitutionCoContractantProjetActiviteRechercheConverter(){
init(true);
}

@Override
public InstitutionCoContractantProjetActiviteRecherche toItem(InstitutionCoContractantProjetActiviteRechercheVo vo) {
if (vo == null) {
return null;
} else {
InstitutionCoContractantProjetActiviteRecherche item = new InstitutionCoContractantProjetActiviteRecherche();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getInstitutionCoContractantVo()!=null && this.institutionCoContractant)
        item.setInstitutionCoContractant(institutionCoContractantConverter.toItem(vo.getInstitutionCoContractantVo())) ;
    if(vo.getProjetActiviteRechercheVo()!=null && this.projetActiviteRecherche)
        item.setProjetActiviteRecherche(projetActiviteRechercheConverter.toItem(vo.getProjetActiviteRechercheVo())) ;


return item;
}
}

@Override
public InstitutionCoContractantProjetActiviteRechercheVo toVo(InstitutionCoContractantProjetActiviteRecherche item) {
if (item == null) {
return null;
} else {
InstitutionCoContractantProjetActiviteRechercheVo vo = new InstitutionCoContractantProjetActiviteRechercheVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getInstitutionCoContractant()!=null && this.institutionCoContractant) {
        vo.setInstitutionCoContractantVo(institutionCoContractantConverter.toVo(item.getInstitutionCoContractant())) ;
    }
    if(item.getProjetActiviteRecherche()!=null && this.projetActiviteRecherche) {
        vo.setProjetActiviteRechercheVo(projetActiviteRechercheConverter.toVo(item.getProjetActiviteRecherche())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    institutionCoContractant = value;
    projetActiviteRecherche = value;
}


        public ProjetActiviteRechercheConverter getProjetActiviteRechercheConverter(){
        return this.projetActiviteRechercheConverter;
        }
        public void setProjetActiviteRechercheConverter(ProjetActiviteRechercheConverter projetActiviteRechercheConverter ){
        this.projetActiviteRechercheConverter = projetActiviteRechercheConverter;
        }
        public InstitutionCoContractantConverter getInstitutionCoContractantConverter(){
        return this.institutionCoContractantConverter;
        }
        public void setInstitutionCoContractantConverter(InstitutionCoContractantConverter institutionCoContractantConverter ){
        this.institutionCoContractantConverter = institutionCoContractantConverter;
        }

    public boolean  isInstitutionCoContractant(){
    return this.institutionCoContractant;
    }
    public void  setInstitutionCoContractant(boolean institutionCoContractant){
    this.institutionCoContractant = institutionCoContractant;
    }
    public boolean  isProjetActiviteRecherche(){
    return this.projetActiviteRecherche;
    }
    public void  setProjetActiviteRecherche(boolean projetActiviteRecherche){
    this.projetActiviteRecherche = projetActiviteRecherche;
    }






}
