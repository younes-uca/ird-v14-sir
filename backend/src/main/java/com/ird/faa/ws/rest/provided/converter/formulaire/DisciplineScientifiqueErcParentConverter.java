package main.java.com.ird.faa.ws.rest.provided.converter.formulaire;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueErcParent;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.DisciplineScientifiqueErcParentVo;
import org.springframework.stereotype.Component;

@Component
public class DisciplineScientifiqueErcParentConverter extends AbstractConverter<DisciplineScientifiqueErcParent,DisciplineScientifiqueErcParentVo>{


public  DisciplineScientifiqueErcParentConverter(){
init(true);
}

@Override
public DisciplineScientifiqueErcParent toItem(DisciplineScientifiqueErcParentVo vo) {
if (vo == null) {
return null;
} else {
DisciplineScientifiqueErcParent item = new DisciplineScientifiqueErcParent();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelleFr()))
        item.setLibelleFr(vo.getLibelleFr());
        if(StringUtil.isNotEmpty(vo.getLibelleEng()))
        item.setLibelleEng(vo.getLibelleEng());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getNiveau()))
        item.setNiveau(NumberUtil.toLong(vo.getNiveau()));
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
public DisciplineScientifiqueErcParentVo toVo(DisciplineScientifiqueErcParent item) {
if (item == null) {
return null;
} else {
DisciplineScientifiqueErcParentVo vo = new DisciplineScientifiqueErcParentVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelleFr()))
        vo.setLibelleFr(item.getLibelleFr());

        if(StringUtil.isNotEmpty(item.getLibelleEng()))
        vo.setLibelleEng(item.getLibelleEng());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(item.getNiveau()!=null)
        vo.setNiveau(NumberUtil.toString(item.getNiveau()));

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
