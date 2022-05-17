package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.TypeOutilCultureScientifiqueOutilPedagogique;
import com.ird.faa.ws.rest.provided.vo.TypeOutilCultureScientifiqueOutilPedagogiqueVo;

@Component
public class TypeOutilCultureScientifiqueOutilPedagogiqueConverter extends AbstractConverter<TypeOutilCultureScientifiqueOutilPedagogique,TypeOutilCultureScientifiqueOutilPedagogiqueVo>{

        @Autowired
        private TypeOutilConverter typeOutilConverter ;
        @Autowired
        private CultureScientifiqueOutilPedagogiqueConverter cultureScientifiqueOutilPedagogiqueConverter ;
    private Boolean cultureScientifiqueOutilPedagogique;
    private Boolean typeOutil;

public  TypeOutilCultureScientifiqueOutilPedagogiqueConverter(){
init(true);
}

@Override
public TypeOutilCultureScientifiqueOutilPedagogique toItem(TypeOutilCultureScientifiqueOutilPedagogiqueVo vo) {
if (vo == null) {
return null;
} else {
TypeOutilCultureScientifiqueOutilPedagogique item = new TypeOutilCultureScientifiqueOutilPedagogique();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getCultureScientifiqueOutilPedagogiqueVo()!=null && this.cultureScientifiqueOutilPedagogique)
        item.setCultureScientifiqueOutilPedagogique(cultureScientifiqueOutilPedagogiqueConverter.toItem(vo.getCultureScientifiqueOutilPedagogiqueVo())) ;
    if(vo.getTypeOutilVo()!=null && this.typeOutil)
        item.setTypeOutil(typeOutilConverter.toItem(vo.getTypeOutilVo())) ;


return item;
}
}

@Override
public TypeOutilCultureScientifiqueOutilPedagogiqueVo toVo(TypeOutilCultureScientifiqueOutilPedagogique item) {
if (item == null) {
return null;
} else {
TypeOutilCultureScientifiqueOutilPedagogiqueVo vo = new TypeOutilCultureScientifiqueOutilPedagogiqueVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getCultureScientifiqueOutilPedagogique()!=null && this.cultureScientifiqueOutilPedagogique) {
        vo.setCultureScientifiqueOutilPedagogiqueVo(cultureScientifiqueOutilPedagogiqueConverter.toVo(item.getCultureScientifiqueOutilPedagogique())) ;
    }
    if(item.getTypeOutil()!=null && this.typeOutil) {
        vo.setTypeOutilVo(typeOutilConverter.toVo(item.getTypeOutil())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    cultureScientifiqueOutilPedagogique = value;
    typeOutil = value;
}


        public TypeOutilConverter getTypeOutilConverter(){
        return this.typeOutilConverter;
        }
        public void setTypeOutilConverter(TypeOutilConverter typeOutilConverter ){
        this.typeOutilConverter = typeOutilConverter;
        }
        public CultureScientifiqueOutilPedagogiqueConverter getCultureScientifiqueOutilPedagogiqueConverter(){
        return this.cultureScientifiqueOutilPedagogiqueConverter;
        }
        public void setCultureScientifiqueOutilPedagogiqueConverter(CultureScientifiqueOutilPedagogiqueConverter cultureScientifiqueOutilPedagogiqueConverter ){
        this.cultureScientifiqueOutilPedagogiqueConverter = cultureScientifiqueOutilPedagogiqueConverter;
        }

    public boolean  isCultureScientifiqueOutilPedagogique(){
    return this.cultureScientifiqueOutilPedagogique;
    }
    public void  setCultureScientifiqueOutilPedagogique(boolean cultureScientifiqueOutilPedagogique){
    this.cultureScientifiqueOutilPedagogique = cultureScientifiqueOutilPedagogique;
    }
    public boolean  isTypeOutil(){
    return this.typeOutil;
    }
    public void  setTypeOutil(boolean typeOutil){
    this.typeOutil = typeOutil;
    }






}
