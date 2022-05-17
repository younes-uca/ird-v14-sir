package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.PaysTypeOutilCultureScientifiqueOutilPedagogique;
import com.ird.faa.ws.rest.provided.vo.PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo;

@Component
public class PaysTypeOutilCultureScientifiqueOutilPedagogiqueConverter extends AbstractConverter<PaysTypeOutilCultureScientifiqueOutilPedagogique,PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo>{

        @Autowired
        private CultureScientifiqueOutilPedagogiqueConverter cultureScientifiqueOutilPedagogiqueConverter ;
        @Autowired
        private PaysConverter paysConverter ;
    private Boolean cultureScientifiqueOutilPedagogique;
    private Boolean pays;

public  PaysTypeOutilCultureScientifiqueOutilPedagogiqueConverter(){
init(true);
}

@Override
public PaysTypeOutilCultureScientifiqueOutilPedagogique toItem(PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo vo) {
if (vo == null) {
return null;
} else {
PaysTypeOutilCultureScientifiqueOutilPedagogique item = new PaysTypeOutilCultureScientifiqueOutilPedagogique();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getCultureScientifiqueOutilPedagogiqueVo()!=null && this.cultureScientifiqueOutilPedagogique)
        item.setCultureScientifiqueOutilPedagogique(cultureScientifiqueOutilPedagogiqueConverter.toItem(vo.getCultureScientifiqueOutilPedagogiqueVo())) ;
    if(vo.getPaysVo()!=null && this.pays)
        item.setPays(paysConverter.toItem(vo.getPaysVo())) ;


return item;
}
}

@Override
public PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo toVo(PaysTypeOutilCultureScientifiqueOutilPedagogique item) {
if (item == null) {
return null;
} else {
PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo vo = new PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getCultureScientifiqueOutilPedagogique()!=null && this.cultureScientifiqueOutilPedagogique) {
        vo.setCultureScientifiqueOutilPedagogiqueVo(cultureScientifiqueOutilPedagogiqueConverter.toVo(item.getCultureScientifiqueOutilPedagogique())) ;
    }
    if(item.getPays()!=null && this.pays) {
        vo.setPaysVo(paysConverter.toVo(item.getPays())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    cultureScientifiqueOutilPedagogique = value;
    pays = value;
}


        public CultureScientifiqueOutilPedagogiqueConverter getCultureScientifiqueOutilPedagogiqueConverter(){
        return this.cultureScientifiqueOutilPedagogiqueConverter;
        }
        public void setCultureScientifiqueOutilPedagogiqueConverter(CultureScientifiqueOutilPedagogiqueConverter cultureScientifiqueOutilPedagogiqueConverter ){
        this.cultureScientifiqueOutilPedagogiqueConverter = cultureScientifiqueOutilPedagogiqueConverter;
        }
        public PaysConverter getPaysConverter(){
        return this.paysConverter;
        }
        public void setPaysConverter(PaysConverter paysConverter ){
        this.paysConverter = paysConverter;
        }

    public boolean  isCultureScientifiqueOutilPedagogique(){
    return this.cultureScientifiqueOutilPedagogique;
    }
    public void  setCultureScientifiqueOutilPedagogique(boolean cultureScientifiqueOutilPedagogique){
    this.cultureScientifiqueOutilPedagogique = cultureScientifiqueOutilPedagogique;
    }
    public boolean  isPays(){
    return this.pays;
    }
    public void  setPays(boolean pays){
    this.pays = pays;
    }






}
