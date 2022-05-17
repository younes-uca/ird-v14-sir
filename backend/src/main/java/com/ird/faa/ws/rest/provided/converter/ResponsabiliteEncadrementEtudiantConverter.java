package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.ResponsabiliteEncadrementEtudiant;
import com.ird.faa.ws.rest.provided.vo.ResponsabiliteEncadrementEtudiantVo;

@Component
public class ResponsabiliteEncadrementEtudiantConverter extends AbstractConverter<ResponsabiliteEncadrementEtudiant,ResponsabiliteEncadrementEtudiantVo>{


public  ResponsabiliteEncadrementEtudiantConverter(){
init(true);
}

@Override
public ResponsabiliteEncadrementEtudiant toItem(ResponsabiliteEncadrementEtudiantVo vo) {
if (vo == null) {
return null;
} else {
ResponsabiliteEncadrementEtudiant item = new ResponsabiliteEncadrementEtudiant();
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
public ResponsabiliteEncadrementEtudiantVo toVo(ResponsabiliteEncadrementEtudiant item) {
if (item == null) {
return null;
} else {
ResponsabiliteEncadrementEtudiantVo vo = new ResponsabiliteEncadrementEtudiantVo();
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
