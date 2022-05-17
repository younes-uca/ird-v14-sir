package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.ModaliteFormationContinue;
import com.ird.faa.ws.rest.provided.vo.ModaliteFormationContinueVo;

@Component
public class ModaliteFormationContinueConverter extends AbstractConverter<ModaliteFormationContinue,ModaliteFormationContinueVo>{


public  ModaliteFormationContinueConverter(){
init(true);
}

@Override
public ModaliteFormationContinue toItem(ModaliteFormationContinueVo vo) {
if (vo == null) {
return null;
} else {
ModaliteFormationContinue item = new ModaliteFormationContinue();
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
public ModaliteFormationContinueVo toVo(ModaliteFormationContinue item) {
if (item == null) {
return null;
} else {
ModaliteFormationContinueVo vo = new ModaliteFormationContinueVo();
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
