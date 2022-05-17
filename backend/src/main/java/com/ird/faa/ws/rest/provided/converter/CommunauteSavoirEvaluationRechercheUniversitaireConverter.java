package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.CommunauteSavoirEvaluationRechercheUniversitaire;
import com.ird.faa.ws.rest.provided.vo.CommunauteSavoirEvaluationRechercheUniversitaireVo;

@Component
public class CommunauteSavoirEvaluationRechercheUniversitaireConverter extends AbstractConverter<CommunauteSavoirEvaluationRechercheUniversitaire,CommunauteSavoirEvaluationRechercheUniversitaireVo>{

        @Autowired
        private EvaluationRechercheUniversitaireConverter evaluationRechercheUniversitaireConverter ;
        @Autowired
        private CommunauteSavoirConverter communauteSavoirConverter ;
    private Boolean evaluationRechercheUniversitaire;
    private Boolean communauteSavoir;

public  CommunauteSavoirEvaluationRechercheUniversitaireConverter(){
init(true);
}

@Override
public CommunauteSavoirEvaluationRechercheUniversitaire toItem(CommunauteSavoirEvaluationRechercheUniversitaireVo vo) {
if (vo == null) {
return null;
} else {
CommunauteSavoirEvaluationRechercheUniversitaire item = new CommunauteSavoirEvaluationRechercheUniversitaire();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getEvaluationRechercheUniversitaireVo()!=null && this.evaluationRechercheUniversitaire)
        item.setEvaluationRechercheUniversitaire(evaluationRechercheUniversitaireConverter.toItem(vo.getEvaluationRechercheUniversitaireVo())) ;
    if(vo.getCommunauteSavoirVo()!=null && this.communauteSavoir)
        item.setCommunauteSavoir(communauteSavoirConverter.toItem(vo.getCommunauteSavoirVo())) ;


return item;
}
}

@Override
public CommunauteSavoirEvaluationRechercheUniversitaireVo toVo(CommunauteSavoirEvaluationRechercheUniversitaire item) {
if (item == null) {
return null;
} else {
CommunauteSavoirEvaluationRechercheUniversitaireVo vo = new CommunauteSavoirEvaluationRechercheUniversitaireVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getEvaluationRechercheUniversitaire()!=null && this.evaluationRechercheUniversitaire) {
        vo.setEvaluationRechercheUniversitaireVo(evaluationRechercheUniversitaireConverter.toVo(item.getEvaluationRechercheUniversitaire())) ;
    }
    if(item.getCommunauteSavoir()!=null && this.communauteSavoir) {
        vo.setCommunauteSavoirVo(communauteSavoirConverter.toVo(item.getCommunauteSavoir())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    evaluationRechercheUniversitaire = value;
    communauteSavoir = value;
}


        public EvaluationRechercheUniversitaireConverter getEvaluationRechercheUniversitaireConverter(){
        return this.evaluationRechercheUniversitaireConverter;
        }
        public void setEvaluationRechercheUniversitaireConverter(EvaluationRechercheUniversitaireConverter evaluationRechercheUniversitaireConverter ){
        this.evaluationRechercheUniversitaireConverter = evaluationRechercheUniversitaireConverter;
        }
        public CommunauteSavoirConverter getCommunauteSavoirConverter(){
        return this.communauteSavoirConverter;
        }
        public void setCommunauteSavoirConverter(CommunauteSavoirConverter communauteSavoirConverter ){
        this.communauteSavoirConverter = communauteSavoirConverter;
        }

    public boolean  isEvaluationRechercheUniversitaire(){
    return this.evaluationRechercheUniversitaire;
    }
    public void  setEvaluationRechercheUniversitaire(boolean evaluationRechercheUniversitaire){
    this.evaluationRechercheUniversitaire = evaluationRechercheUniversitaire;
    }
    public boolean  isCommunauteSavoir(){
    return this.communauteSavoir;
    }
    public void  setCommunauteSavoir(boolean communauteSavoir){
    this.communauteSavoir = communauteSavoir;
    }






}
