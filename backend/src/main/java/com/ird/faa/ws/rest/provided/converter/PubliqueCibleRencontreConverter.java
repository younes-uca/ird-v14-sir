package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.PubliqueCibleRencontre;
import com.ird.faa.ws.rest.provided.vo.PubliqueCibleRencontreVo;

@Component
public class PubliqueCibleRencontreConverter extends AbstractConverter<PubliqueCibleRencontre,PubliqueCibleRencontreVo>{


public  PubliqueCibleRencontreConverter(){
init(true);
}

@Override
public PubliqueCibleRencontre toItem(PubliqueCibleRencontreVo vo) {
if (vo == null) {
return null;
} else {
PubliqueCibleRencontre item = new PubliqueCibleRencontre();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
            if(StringUtil.isNotEmpty(vo.getArchive()))
            item.setArchive(NumberUtil.toBoolean(vo.getArchive()));
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));


return item;
}
}

@Override
public PubliqueCibleRencontreVo toVo(PubliqueCibleRencontre item) {
if (item == null) {
return null;
} else {
PubliqueCibleRencontreVo vo = new PubliqueCibleRencontreVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

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
