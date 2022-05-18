package main.java.com.ird.faa.ws.rest.provided.converter.formulaire;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.StatusProjet;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.StatusProjetVo;

@Component
public class StatusProjetConverter extends AbstractConverter<StatusProjet,StatusProjetVo>{


public  StatusProjetConverter(){
init(true);
}

@Override
public StatusProjet toItem(StatusProjetVo vo) {
if (vo == null) {
return null;
} else {
StatusProjet item = new StatusProjet();
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
public StatusProjetVo toVo(StatusProjet item) {
if (item == null) {
return null;
} else {
StatusProjetVo vo = new StatusProjetVo();
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
