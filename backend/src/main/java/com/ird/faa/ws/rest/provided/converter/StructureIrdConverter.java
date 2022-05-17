package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.StructureIrd;
import com.ird.faa.ws.rest.provided.vo.StructureIrdVo;

@Component
public class StructureIrdConverter extends AbstractConverter<StructureIrd,StructureIrdVo>{


public  StructureIrdConverter(){
init(true);
}

@Override
public StructureIrd toItem(StructureIrdVo vo) {
if (vo == null) {
return null;
} else {
StructureIrd item = new StructureIrd();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
            if(StringUtil.isNotEmpty(vo.getArchive()))
            item.setArchive(NumberUtil.toBoolean(vo.getArchive()));
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));


return item;
}
}

@Override
public StructureIrdVo toVo(StructureIrd item) {
if (item == null) {
return null;
} else {
StructureIrdVo vo = new StructureIrdVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

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
