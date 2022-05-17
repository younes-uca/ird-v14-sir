package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.FormatRencontre;
import com.ird.faa.ws.rest.provided.vo.FormatRencontreVo;

@Component
public class FormatRencontreConverter extends AbstractConverter<FormatRencontre,FormatRencontreVo>{


public  FormatRencontreConverter(){
init(true);
}

@Override
public FormatRencontre toItem(FormatRencontreVo vo) {
if (vo == null) {
return null;
} else {
FormatRencontre item = new FormatRencontre();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());


return item;
}
}

@Override
public FormatRencontreVo toVo(FormatRencontre item) {
if (item == null) {
return null;
} else {
FormatRencontreVo vo = new FormatRencontreVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());


return vo;
}
}

public void init(Boolean value) {
}









}
