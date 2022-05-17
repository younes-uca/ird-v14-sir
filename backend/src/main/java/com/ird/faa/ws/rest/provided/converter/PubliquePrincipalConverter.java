package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.PubliquePrincipal;
import com.ird.faa.ws.rest.provided.vo.PubliquePrincipalVo;

@Component
public class PubliquePrincipalConverter extends AbstractConverter<PubliquePrincipal,PubliquePrincipalVo>{


public  PubliquePrincipalConverter(){
init(true);
}

@Override
public PubliquePrincipal toItem(PubliquePrincipalVo vo) {
if (vo == null) {
return null;
} else {
PubliquePrincipal item = new PubliquePrincipal();
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
public PubliquePrincipalVo toVo(PubliquePrincipal item) {
if (item == null) {
return null;
} else {
PubliquePrincipalVo vo = new PubliquePrincipalVo();
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
