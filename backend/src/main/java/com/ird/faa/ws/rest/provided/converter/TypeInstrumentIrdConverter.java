package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.TypeInstrumentIrd;
import com.ird.faa.ws.rest.provided.vo.TypeInstrumentIrdVo;

@Component
public class TypeInstrumentIrdConverter extends AbstractConverter<TypeInstrumentIrd,TypeInstrumentIrdVo>{


public  TypeInstrumentIrdConverter(){
init(true);
}

@Override
public TypeInstrumentIrd toItem(TypeInstrumentIrdVo vo) {
if (vo == null) {
return null;
} else {
TypeInstrumentIrd item = new TypeInstrumentIrd();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
            if(StringUtil.isNotEmpty(vo.getArchive()))
            item.setArchive(NumberUtil.toBoolean(vo.getArchive()));
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));


return item;
}
}

@Override
public TypeInstrumentIrdVo toVo(TypeInstrumentIrd item) {
if (item == null) {
return null;
} else {
TypeInstrumentIrdVo vo = new TypeInstrumentIrdVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(item.getArchive()!=null)
        vo.setArchive(NumberUtil.toString(item.getArchive()));
        if(item.getDateArchivage()!=null)
        vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));

return vo;
}
}

public void init(Boolean value) {
}













}
