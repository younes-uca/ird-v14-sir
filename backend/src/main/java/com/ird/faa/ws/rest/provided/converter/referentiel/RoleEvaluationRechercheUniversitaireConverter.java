package main.java.com.ird.faa.ws.rest.provided.converter.referentiel;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.RoleEvaluationRechercheUniversitaire;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.RoleEvaluationRechercheUniversitaireVo;

@Component
public class RoleEvaluationRechercheUniversitaireConverter extends AbstractConverter<RoleEvaluationRechercheUniversitaire,RoleEvaluationRechercheUniversitaireVo>{


public  RoleEvaluationRechercheUniversitaireConverter(){
init(true);
}

@Override
public RoleEvaluationRechercheUniversitaire toItem(RoleEvaluationRechercheUniversitaireVo vo) {
if (vo == null) {
return null;
} else {
RoleEvaluationRechercheUniversitaire item = new RoleEvaluationRechercheUniversitaire();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());


return item;
}
}

@Override
public RoleEvaluationRechercheUniversitaireVo toVo(RoleEvaluationRechercheUniversitaire item) {
if (item == null) {
return null;
} else {
RoleEvaluationRechercheUniversitaireVo vo = new RoleEvaluationRechercheUniversitaireVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());


return vo;
}
}

public void init(Boolean value) {
}











}
