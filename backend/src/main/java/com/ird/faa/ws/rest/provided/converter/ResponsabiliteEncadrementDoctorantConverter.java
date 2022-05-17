package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.ResponsabiliteEncadrementDoctorant;
import com.ird.faa.ws.rest.provided.vo.ResponsabiliteEncadrementDoctorantVo;

@Component
public class ResponsabiliteEncadrementDoctorantConverter extends AbstractConverter<ResponsabiliteEncadrementDoctorant,ResponsabiliteEncadrementDoctorantVo>{


public  ResponsabiliteEncadrementDoctorantConverter(){
init(true);
}

@Override
public ResponsabiliteEncadrementDoctorant toItem(ResponsabiliteEncadrementDoctorantVo vo) {
if (vo == null) {
return null;
} else {
ResponsabiliteEncadrementDoctorant item = new ResponsabiliteEncadrementDoctorant();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
            if(vo.getArchive() != null)
            item.setArchive(vo.getArchive());
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));


return item;
}
}

@Override
public ResponsabiliteEncadrementDoctorantVo toVo(ResponsabiliteEncadrementDoctorant item) {
if (item == null) {
return null;
} else {
ResponsabiliteEncadrementDoctorantVo vo = new ResponsabiliteEncadrementDoctorantVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(item.getArchive()!=null)
        vo.setArchive(item.getArchive());
        if(item.getDateArchivage()!=null)
        vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));

return vo;
}
}

public void init(Boolean value) {
}

}
