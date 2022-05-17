package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.Corps;
import com.ird.faa.ws.rest.provided.vo.CorpsVo;

@Component
public class CorpsConverter extends AbstractConverter<Corps,CorpsVo>{


public  CorpsConverter(){
init(true);
}

@Override
public Corps toItem(CorpsVo vo) {
if (vo == null) {
return null;
} else {
Corps item = new Corps();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
        /*TODO:added fields*/
        if(StringUtil.isNotEmpty(vo.getIdGraph()))
        item.setIdGraph(vo.getIdGraph());
        /*TODO: fin added fields*/


return item;
}
}

@Override
public CorpsVo toVo(Corps item) {
if (item == null) {
return null;
} else {
CorpsVo vo = new CorpsVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

        /*TODO:added fields*/
        if(StringUtil.isNotEmpty(item.getIdGraph()))
        vo.setIdGraph(item.getIdGraph());
        
        /*TODO:fin added fields*/


return vo;
}
}

public void init(Boolean value) {
}











}
