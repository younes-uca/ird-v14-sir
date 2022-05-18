package main.java.com.ird.faa.ws.rest.provided.converter.formulaire;

import com.ird.faa.bean.formulaire.TypeExpertiseEvaluation;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.TypeExpertiseEvaluationVo;
import org.springframework.stereotype.Component;

@Component
public class TypeExpertiseEvaluationConverter extends AbstractConverter<TypeExpertiseEvaluation,TypeExpertiseEvaluationVo>{


public  TypeExpertiseEvaluationConverter(){
init(true);
}

@Override
public TypeExpertiseEvaluation toItem(TypeExpertiseEvaluationVo vo) {
if (vo == null) {
return null;
} else {
TypeExpertiseEvaluation item = new TypeExpertiseEvaluation();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
            if(vo.getArchive() != null)
            item.setArchive(vo.getArchive());
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
        if(StringUtil.isNotEmpty(vo.getDateCreation()))
        item.setDateCreation(DateUtil.parse(vo.getDateCreation()));


return item;
}
}

@Override
public TypeExpertiseEvaluationVo toVo(TypeExpertiseEvaluation item) {
if (item == null) {
return null;
} else {
TypeExpertiseEvaluationVo vo = new TypeExpertiseEvaluationVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(item.getArchive()!=null)
        vo.setArchive(item.getArchive());
        if(item.getDateArchivage()!=null)
        vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
        if(item.getDateCreation()!=null)
        vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));

return vo;
}
}

public void init(Boolean value) {
}















}
