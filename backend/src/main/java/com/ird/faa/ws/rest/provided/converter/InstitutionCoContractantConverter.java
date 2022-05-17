package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.InstitutionCoContractant;
import com.ird.faa.ws.rest.provided.vo.InstitutionCoContractantVo;

@Component
public class InstitutionCoContractantConverter extends AbstractConverter<InstitutionCoContractant,InstitutionCoContractantVo>{

        @Autowired
        private InstitutionConverter institutionConverter ;
        @Autowired
        private ChercheurConverter chercheurConverter ;
    private Boolean chercheur;
    private Boolean institution;

public  InstitutionCoContractantConverter(){
init(true);
}

@Override
public InstitutionCoContractant toItem(InstitutionCoContractantVo vo) {
if (vo == null) {
return null;
} else {
InstitutionCoContractant item = new InstitutionCoContractant();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getChercheurVo()!=null && this.chercheur)
        item.setChercheur(chercheurConverter.toItem(vo.getChercheurVo())) ;
    if(vo.getInstitutionVo()!=null && this.institution)
        item.setInstitution(institutionConverter.toItem(vo.getInstitutionVo())) ;


return item;
}
}

@Override
public InstitutionCoContractantVo toVo(InstitutionCoContractant item) {
if (item == null) {
return null;
} else {
InstitutionCoContractantVo vo = new InstitutionCoContractantVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getChercheur()!=null && this.chercheur) {
        vo.setChercheurVo(chercheurConverter.toVo(item.getChercheur())) ;
    }
    if(item.getInstitution()!=null && this.institution) {
        vo.setInstitutionVo(institutionConverter.toVo(item.getInstitution())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    chercheur = value;
    institution = value;
}


        public InstitutionConverter getInstitutionConverter(){
        return this.institutionConverter;
        }
        public void setInstitutionConverter(InstitutionConverter institutionConverter ){
        this.institutionConverter = institutionConverter;
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
    public boolean  isInstitution(){
    return this.institution;
    }
    public void  setInstitution(boolean institution){
    this.institution = institution;
    }






}
