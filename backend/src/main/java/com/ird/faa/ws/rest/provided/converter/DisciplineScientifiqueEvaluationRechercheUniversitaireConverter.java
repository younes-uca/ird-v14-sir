package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.DisciplineScientifiqueEvaluationRechercheUniversitaire;
import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueEvaluationRechercheUniversitaireVo;

@Component
public class DisciplineScientifiqueEvaluationRechercheUniversitaireConverter extends AbstractConverter<DisciplineScientifiqueEvaluationRechercheUniversitaire,DisciplineScientifiqueEvaluationRechercheUniversitaireVo>{

        @Autowired
        private DisciplineScientifiqueConverter disciplineScientifiqueConverter ;
        @Autowired
        private EvaluationRechercheUniversitaireConverter evaluationRechercheUniversitaireConverter ;
    private Boolean disciplineScientifique;
    private Boolean evaluationRechercheUniversitaire;

public  DisciplineScientifiqueEvaluationRechercheUniversitaireConverter(){
init(true);
}

@Override
public DisciplineScientifiqueEvaluationRechercheUniversitaire toItem(DisciplineScientifiqueEvaluationRechercheUniversitaireVo vo) {
if (vo == null) {
return null;
} else {
DisciplineScientifiqueEvaluationRechercheUniversitaire item = new DisciplineScientifiqueEvaluationRechercheUniversitaire();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getDisciplineScientifiqueVo()!=null && this.disciplineScientifique)
        item.setDisciplineScientifique(disciplineScientifiqueConverter.toItem(vo.getDisciplineScientifiqueVo())) ;
    if(vo.getEvaluationRechercheUniversitaireVo()!=null && this.evaluationRechercheUniversitaire)
        item.setEvaluationRechercheUniversitaire(evaluationRechercheUniversitaireConverter.toItem(vo.getEvaluationRechercheUniversitaireVo())) ;


return item;
}
}

@Override
public DisciplineScientifiqueEvaluationRechercheUniversitaireVo toVo(DisciplineScientifiqueEvaluationRechercheUniversitaire item) {
if (item == null) {
return null;
} else {
DisciplineScientifiqueEvaluationRechercheUniversitaireVo vo = new DisciplineScientifiqueEvaluationRechercheUniversitaireVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getDisciplineScientifique()!=null && this.disciplineScientifique) {
        vo.setDisciplineScientifiqueVo(disciplineScientifiqueConverter.toVo(item.getDisciplineScientifique())) ;
    }
    if(item.getEvaluationRechercheUniversitaire()!=null && this.evaluationRechercheUniversitaire) {
        vo.setEvaluationRechercheUniversitaireVo(evaluationRechercheUniversitaireConverter.toVo(item.getEvaluationRechercheUniversitaire())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    disciplineScientifique = value;
    evaluationRechercheUniversitaire = value;
}


        public DisciplineScientifiqueConverter getDisciplineScientifiqueConverter(){
        return this.disciplineScientifiqueConverter;
        }
        public void setDisciplineScientifiqueConverter(DisciplineScientifiqueConverter disciplineScientifiqueConverter ){
        this.disciplineScientifiqueConverter = disciplineScientifiqueConverter;
        }
        public EvaluationRechercheUniversitaireConverter getEvaluationRechercheUniversitaireConverter(){
        return this.evaluationRechercheUniversitaireConverter;
        }
        public void setEvaluationRechercheUniversitaireConverter(EvaluationRechercheUniversitaireConverter evaluationRechercheUniversitaireConverter ){
        this.evaluationRechercheUniversitaireConverter = evaluationRechercheUniversitaireConverter;
        }

    public boolean  isDisciplineScientifique(){
    return this.disciplineScientifique;
    }
    public void  setDisciplineScientifique(boolean disciplineScientifique){
    this.disciplineScientifique = disciplineScientifique;
    }
    public boolean  isEvaluationRechercheUniversitaire(){
    return this.evaluationRechercheUniversitaire;
    }
    public void  setEvaluationRechercheUniversitaire(boolean evaluationRechercheUniversitaire){
    this.evaluationRechercheUniversitaire = evaluationRechercheUniversitaire;
    }






}
