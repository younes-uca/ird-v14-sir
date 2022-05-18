package main.java.com.ird.faa.ws.rest.provided.converter.formulaire;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.Caracterisation;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.CaracterisationVo;

@Component
public class CaracterisationConverter extends AbstractConverter<Caracterisation,CaracterisationVo>{


public  CaracterisationConverter(){
init(true);
}

@Override
public Caracterisation toItem(CaracterisationVo vo) {
if (vo == null) {
return null;
} else {
Caracterisation item = new Caracterisation();
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
public CaracterisationVo toVo(Caracterisation item) {
if (item == null) {
return null;
} else {
CaracterisationVo vo = new CaracterisationVo();
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
