package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.formulaire.TypePubliqueCultureScientifique;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.TypePubliqueCultureScientifiqueVo;
import org.springframework.stereotype.Component;

@Component
public class TypePubliqueCultureScientifiqueConverter extends AbstractConverter<TypePubliqueCultureScientifique,TypePubliqueCultureScientifiqueVo>{


public  TypePubliqueCultureScientifiqueConverter(){
init(true);
}

@Override
public TypePubliqueCultureScientifique toItem(TypePubliqueCultureScientifiqueVo vo) {
if (vo == null) {
return null;
} else {
TypePubliqueCultureScientifique item = new TypePubliqueCultureScientifique();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
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
public TypePubliqueCultureScientifiqueVo toVo(TypePubliqueCultureScientifique item) {
if (item == null) {
return null;
} else {
TypePubliqueCultureScientifiqueVo vo = new TypePubliqueCultureScientifiqueVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

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
