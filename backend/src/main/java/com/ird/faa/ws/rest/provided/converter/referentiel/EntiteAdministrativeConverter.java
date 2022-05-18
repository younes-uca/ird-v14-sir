package main.java.com.ird.faa.ws.rest.provided.converter.referentiel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.EntiteAdministrative;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.EntiteAdministrativeVo;

@Component
public class EntiteAdministrativeConverter extends AbstractConverter<EntiteAdministrative,EntiteAdministrativeVo>{

        @Autowired
        private TypeEntiteAdministrativeConverter typeEntiteAdministrativeConverter ;
    private Boolean typeEntiteAdministrative;

public  EntiteAdministrativeConverter(){
init(true);
}

@Override
public EntiteAdministrative toItem(EntiteAdministrativeVo vo) {
if (vo == null) {
return null;
} else {
EntiteAdministrative item = new EntiteAdministrative();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
    if(vo.getTypeEntiteAdministrativeVo()!=null && this.typeEntiteAdministrative)
        item.setTypeEntiteAdministrative(typeEntiteAdministrativeConverter.toItem(vo.getTypeEntiteAdministrativeVo())) ;


return item;
}
}

@Override
public EntiteAdministrativeVo toVo(EntiteAdministrative item) {
if (item == null) {
return null;
} else {
EntiteAdministrativeVo vo = new EntiteAdministrativeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

    if(item.getTypeEntiteAdministrative()!=null && this.typeEntiteAdministrative) {
        vo.setTypeEntiteAdministrativeVo(typeEntiteAdministrativeConverter.toVo(item.getTypeEntiteAdministrative())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    typeEntiteAdministrative = value;
}


        public TypeEntiteAdministrativeConverter getTypeEntiteAdministrativeConverter(){
        return this.typeEntiteAdministrativeConverter;
        }
        public void setTypeEntiteAdministrativeConverter(TypeEntiteAdministrativeConverter typeEntiteAdministrativeConverter ){
        this.typeEntiteAdministrativeConverter = typeEntiteAdministrativeConverter;
        }

    public boolean  isTypeEntiteAdministrative(){
    return this.typeEntiteAdministrative;
    }
    public void  setTypeEntiteAdministrative(boolean typeEntiteAdministrative){
    this.typeEntiteAdministrative = typeEntiteAdministrative;
    }










}
