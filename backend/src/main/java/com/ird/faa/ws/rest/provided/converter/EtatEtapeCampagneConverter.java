package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.config.EtatEtapeCampagne;
import com.ird.faa.ws.rest.provided.vo.EtatEtapeCampagneVo;

@Component
public class EtatEtapeCampagneConverter extends AbstractConverter<EtatEtapeCampagne,EtatEtapeCampagneVo>{


public  EtatEtapeCampagneConverter(){
init(true);
}

@Override
public EtatEtapeCampagne toItem(EtatEtapeCampagneVo vo) {
if (vo == null) {
return null;
} else {
EtatEtapeCampagne item = new EtatEtapeCampagne();
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
public EtatEtapeCampagneVo toVo(EtatEtapeCampagne item) {
if (item == null) {
return null;
} else {
EtatEtapeCampagneVo vo = new EtatEtapeCampagneVo();
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
