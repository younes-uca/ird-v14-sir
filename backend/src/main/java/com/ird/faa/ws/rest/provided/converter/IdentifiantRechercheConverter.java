package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.IdentifiantRecherche;
import com.ird.faa.ws.rest.provided.vo.IdentifiantRechercheVo;

@Component
public class IdentifiantRechercheConverter extends AbstractConverter<IdentifiantRecherche,IdentifiantRechercheVo>{


public  IdentifiantRechercheConverter(){
init(true);
}

@Override
public IdentifiantRecherche toItem(IdentifiantRechercheVo vo) {
if (vo == null) {
return null;
} else {
IdentifiantRecherche item = new IdentifiantRecherche();
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
public IdentifiantRechercheVo toVo(IdentifiantRecherche item) {
if (item == null) {
return null;
} else {
IdentifiantRechercheVo vo = new IdentifiantRechercheVo();
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
