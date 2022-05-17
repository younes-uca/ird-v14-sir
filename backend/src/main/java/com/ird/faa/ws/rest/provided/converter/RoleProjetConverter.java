package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.RoleProjet;
import com.ird.faa.ws.rest.provided.vo.RoleProjetVo;

@Component
public class RoleProjetConverter extends AbstractConverter<RoleProjet,RoleProjetVo>{


public  RoleProjetConverter(){
init(true);
}

@Override
public RoleProjet toItem(RoleProjetVo vo) {
if (vo == null) {
return null;
} else {
RoleProjet item = new RoleProjet();
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
public RoleProjetVo toVo(RoleProjet item) {
if (item == null) {
return null;
} else {
RoleProjetVo vo = new RoleProjetVo();
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
