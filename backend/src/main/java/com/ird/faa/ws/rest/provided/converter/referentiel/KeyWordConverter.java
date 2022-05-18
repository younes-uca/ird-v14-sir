package main.java.com.ird.faa.ws.rest.provided.converter.referentiel;

import com.ird.faa.bean.referentiel.KeyWord;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.KeyWordVo;
import org.springframework.stereotype.Component;

@Component
public class KeyWordConverter extends AbstractConverter<KeyWord,KeyWordVo>{


public  KeyWordConverter(){
init(true);
}

@Override
public KeyWord toItem(KeyWordVo vo) {
if (vo == null) {
return null;
} else {
KeyWord item = new KeyWord();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelleFr()))
        item.setLibelleFr(vo.getLibelleFr());
        if(StringUtil.isNotEmpty(vo.getLibelleEng()))
        item.setLibelleEng(vo.getLibelleEng());
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
public KeyWordVo toVo(KeyWord item) {
if (item == null) {
return null;
} else {
KeyWordVo vo = new KeyWordVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelleFr()))
        vo.setLibelleFr(item.getLibelleFr());

        if(StringUtil.isNotEmpty(item.getLibelleEng()))
        vo.setLibelleEng(item.getLibelleEng());

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
