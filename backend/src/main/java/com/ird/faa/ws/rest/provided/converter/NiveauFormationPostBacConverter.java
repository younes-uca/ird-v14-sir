package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.NiveauFormationPostBac;
import com.ird.faa.ws.rest.provided.vo.NiveauFormationPostBacVo;

@Component
public class NiveauFormationPostBacConverter extends AbstractConverter<NiveauFormationPostBac,NiveauFormationPostBacVo>{


public  NiveauFormationPostBacConverter(){
init(true);
}

@Override
public NiveauFormationPostBac toItem(NiveauFormationPostBacVo vo) {
if (vo == null) {
return null;
} else {
NiveauFormationPostBac item = new NiveauFormationPostBac();
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


return item;
}
}

@Override
public NiveauFormationPostBacVo toVo(NiveauFormationPostBac item) {
if (item == null) {
return null;
} else {
NiveauFormationPostBacVo vo = new NiveauFormationPostBacVo();
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

return vo;
}
}

public void init(Boolean value) {
}













}
