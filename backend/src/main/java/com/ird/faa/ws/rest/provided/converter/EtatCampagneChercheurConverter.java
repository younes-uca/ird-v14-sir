package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.config.EtatCampagneChercheur;
import com.ird.faa.ws.rest.provided.vo.EtatCampagneChercheurVo;

@Component
public class EtatCampagneChercheurConverter extends AbstractConverter<EtatCampagneChercheur,EtatCampagneChercheurVo>{


public  EtatCampagneChercheurConverter(){
init(true);
}

@Override
public EtatCampagneChercheur toItem(EtatCampagneChercheurVo vo) {
if (vo == null) {
return null;
} else {
EtatCampagneChercheur item = new EtatCampagneChercheur();
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
public EtatCampagneChercheurVo toVo(EtatCampagneChercheur item) {
if (item == null) {
return null;
} else {
EtatCampagneChercheurVo vo = new EtatCampagneChercheurVo();
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
