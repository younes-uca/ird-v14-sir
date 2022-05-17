package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.CommissionScientifique;
import com.ird.faa.ws.rest.provided.vo.CommissionScientifiqueVo;

@Component
public class CommissionScientifiqueConverter extends AbstractConverter<CommissionScientifique,CommissionScientifiqueVo>{


public  CommissionScientifiqueConverter(){
init(true);
}

@Override
public CommissionScientifique toItem(CommissionScientifiqueVo vo) {
if (vo == null) {
return null;
} else {
CommissionScientifique item = new CommissionScientifique();
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
public CommissionScientifiqueVo toVo(CommissionScientifique item) {
if (item == null) {
return null;
} else {
CommissionScientifiqueVo vo = new CommissionScientifiqueVo();
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
