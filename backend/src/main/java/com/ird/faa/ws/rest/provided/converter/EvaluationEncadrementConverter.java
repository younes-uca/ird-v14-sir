package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.EvaluationEncadrement;
import com.ird.faa.ws.rest.provided.vo.EvaluationEncadrementVo;

@Component
public class EvaluationEncadrementConverter extends AbstractConverter<EvaluationEncadrement,EvaluationEncadrementVo>{


public  EvaluationEncadrementConverter(){
init(true);
}

@Override
public EvaluationEncadrement toItem(EvaluationEncadrementVo vo) {
if (vo == null) {
return null;
} else {
EvaluationEncadrement item = new EvaluationEncadrement();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());


return item;
}
}

@Override
public EvaluationEncadrementVo toVo(EvaluationEncadrement item) {
if (item == null) {
return null;
} else {
EvaluationEncadrementVo vo = new EvaluationEncadrementVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());


return vo;
}
}

public void init(Boolean value) {
}









}
