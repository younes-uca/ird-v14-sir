package main.java.com.ird.faa.ws.rest.provided.converter.referentiel;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.PubliqueProfessionel;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.PubliqueProfessionelVo;

@Component
public class PubliqueProfessionelConverter extends AbstractConverter<PubliqueProfessionel,PubliqueProfessionelVo>{


public  PubliqueProfessionelConverter(){
init(true);
}

@Override
public PubliqueProfessionel toItem(PubliqueProfessionelVo vo) {
if (vo == null) {
return null;
} else {
PubliqueProfessionel item = new PubliqueProfessionel();
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
        if(StringUtil.isNotEmpty(vo.getDateCreation()))
        item.setDateCreation(DateUtil.parse(vo.getDateCreation()));


return item;
}
}

@Override
public PubliqueProfessionelVo toVo(PubliqueProfessionel item) {
if (item == null) {
return null;
} else {
PubliqueProfessionelVo vo = new PubliqueProfessionelVo();
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
        if(item.getDateCreation()!=null)
        vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));

return vo;
}
}

public void init(Boolean value) {
}

}
