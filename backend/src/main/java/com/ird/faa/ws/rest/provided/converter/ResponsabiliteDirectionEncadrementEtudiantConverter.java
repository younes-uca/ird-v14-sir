package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.formulaire.ResponsabiliteDirectionEncadrementEtudiant;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.ResponsabiliteDirectionEncadrementEtudiantVo;
import org.springframework.stereotype.Component;

@Component
public class ResponsabiliteDirectionEncadrementEtudiantConverter extends AbstractConverter<ResponsabiliteDirectionEncadrementEtudiant,ResponsabiliteDirectionEncadrementEtudiantVo>{


public  ResponsabiliteDirectionEncadrementEtudiantConverter(){
init(true);
}

@Override
public ResponsabiliteDirectionEncadrementEtudiant toItem(ResponsabiliteDirectionEncadrementEtudiantVo vo) {
if (vo == null) {
return null;
} else {
ResponsabiliteDirectionEncadrementEtudiant item = new ResponsabiliteDirectionEncadrementEtudiant();
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
public ResponsabiliteDirectionEncadrementEtudiantVo toVo(ResponsabiliteDirectionEncadrementEtudiant item) {
if (item == null) {
return null;
} else {
ResponsabiliteDirectionEncadrementEtudiantVo vo = new ResponsabiliteDirectionEncadrementEtudiantVo();
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
