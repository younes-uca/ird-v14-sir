package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.ObjetFormationGenerique;
import com.ird.faa.ws.rest.provided.vo.ObjetFormationGeneriqueVo;

@Component
public class ObjetFormationGeneriqueConverter extends AbstractConverter<ObjetFormationGenerique,ObjetFormationGeneriqueVo>{


public  ObjetFormationGeneriqueConverter(){
init(true);
}

@Override
public ObjetFormationGenerique toItem(ObjetFormationGeneriqueVo vo) {
if (vo == null) {
return null;
} else {
ObjetFormationGenerique item = new ObjetFormationGenerique();
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
public ObjetFormationGeneriqueVo toVo(ObjetFormationGenerique item) {
if (item == null) {
return null;
} else {
ObjetFormationGeneriqueVo vo = new ObjetFormationGeneriqueVo();
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
