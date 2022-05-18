package main.java.com.ird.faa.ws.rest.provided.converter.referentiel;

import com.ird.faa.bean.referentiel.TypeEnseignement;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.TypeEnseignementVo;
import org.springframework.stereotype.Component;

@Component
public class TypeEnseignementConverter extends AbstractConverter<TypeEnseignement,TypeEnseignementVo>{


public  TypeEnseignementConverter(){
init(true);
}

@Override
public TypeEnseignement toItem(TypeEnseignementVo vo) {
if (vo == null) {
return null;
} else {
TypeEnseignement item = new TypeEnseignement();
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
public TypeEnseignementVo toVo(TypeEnseignement item) {
if (item == null) {
return null;
} else {
TypeEnseignementVo vo = new TypeEnseignementVo();
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
