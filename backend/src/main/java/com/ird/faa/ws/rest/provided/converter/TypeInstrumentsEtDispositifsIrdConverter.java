package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.TypeInstrumentsEtDispositifsIrd;
import com.ird.faa.ws.rest.provided.vo.TypeInstrumentsEtDispositifsIrdVo;

@Component
public class TypeInstrumentsEtDispositifsIrdConverter extends AbstractConverter<TypeInstrumentsEtDispositifsIrd,TypeInstrumentsEtDispositifsIrdVo>{


public  TypeInstrumentsEtDispositifsIrdConverter(){
init(true);
}

@Override
public TypeInstrumentsEtDispositifsIrd toItem(TypeInstrumentsEtDispositifsIrdVo vo) {
if (vo == null) {
return null;
} else {
TypeInstrumentsEtDispositifsIrd item = new TypeInstrumentsEtDispositifsIrd();
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
public TypeInstrumentsEtDispositifsIrdVo toVo(TypeInstrumentsEtDispositifsIrd item) {
if (item == null) {
return null;
} else {
TypeInstrumentsEtDispositifsIrdVo vo = new TypeInstrumentsEtDispositifsIrdVo();
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
