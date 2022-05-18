package main.java.com.ird.faa.ws.rest.provided.converter.formulaire;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.EtablissementPartenaire;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.EtablissementPartenaireVo;

@Component
public class EtablissementPartenaireConverter extends AbstractConverter<EtablissementPartenaire,EtablissementPartenaireVo>{


public  EtablissementPartenaireConverter(){
init(true);
}

@Override
public EtablissementPartenaire toItem(EtablissementPartenaireVo vo) {
if (vo == null) {
return null;
} else {
EtablissementPartenaire item = new EtablissementPartenaire();
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
public EtablissementPartenaireVo toVo(EtablissementPartenaire item) {
if (item == null) {
return null;
} else {
EtablissementPartenaireVo vo = new EtablissementPartenaireVo();
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
