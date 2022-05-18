package main.java.com.ird.faa.ws.rest.provided.converter.referentiel;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.StatutEcoleDoctorale;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.StatutEcoleDoctoraleVo;

@Component
public class StatutEcoleDoctoraleConverter extends AbstractConverter<StatutEcoleDoctorale,StatutEcoleDoctoraleVo>{


public  StatutEcoleDoctoraleConverter(){
init(true);
}

@Override
public StatutEcoleDoctorale toItem(StatutEcoleDoctoraleVo vo) {
if (vo == null) {
return null;
} else {
StatutEcoleDoctorale item = new StatutEcoleDoctorale();
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
public StatutEcoleDoctoraleVo toVo(StatutEcoleDoctorale item) {
if (item == null) {
return null;
} else {
StatutEcoleDoctoraleVo vo = new StatutEcoleDoctoraleVo();
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
