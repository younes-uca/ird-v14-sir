package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.EtablissementCultureScientifiqueOutilPedagogique;
import com.ird.faa.ws.rest.provided.vo.EtablissementCultureScientifiqueOutilPedagogiqueVo;

@Component
public class EtablissementCultureScientifiqueOutilPedagogiqueConverter extends AbstractConverter<EtablissementCultureScientifiqueOutilPedagogique,EtablissementCultureScientifiqueOutilPedagogiqueVo>{

        @Autowired
        private CultureScientifiqueOutilPedagogiqueConverter cultureScientifiqueOutilPedagogiqueConverter ;
        @Autowired
        private EtablissementConverter etablissementConverter ;
    private Boolean cultureScientifiqueOutilPedagogique;
    private Boolean etablissement;

public  EtablissementCultureScientifiqueOutilPedagogiqueConverter(){
init(true);
}

@Override
public EtablissementCultureScientifiqueOutilPedagogique toItem(EtablissementCultureScientifiqueOutilPedagogiqueVo vo) {
if (vo == null) {
return null;
} else {
EtablissementCultureScientifiqueOutilPedagogique item = new EtablissementCultureScientifiqueOutilPedagogique();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getCultureScientifiqueOutilPedagogiqueVo()!=null && this.cultureScientifiqueOutilPedagogique)
        item.setCultureScientifiqueOutilPedagogique(cultureScientifiqueOutilPedagogiqueConverter.toItem(vo.getCultureScientifiqueOutilPedagogiqueVo())) ;
    if(vo.getEtablissementVo()!=null && this.etablissement)
        item.setEtablissement(etablissementConverter.toItem(vo.getEtablissementVo())) ;


return item;
}
}

@Override
public EtablissementCultureScientifiqueOutilPedagogiqueVo toVo(EtablissementCultureScientifiqueOutilPedagogique item) {
if (item == null) {
return null;
} else {
EtablissementCultureScientifiqueOutilPedagogiqueVo vo = new EtablissementCultureScientifiqueOutilPedagogiqueVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getCultureScientifiqueOutilPedagogique()!=null && this.cultureScientifiqueOutilPedagogique) {
        vo.setCultureScientifiqueOutilPedagogiqueVo(cultureScientifiqueOutilPedagogiqueConverter.toVo(item.getCultureScientifiqueOutilPedagogique())) ;
    }
    if(item.getEtablissement()!=null && this.etablissement) {
        vo.setEtablissementVo(etablissementConverter.toVo(item.getEtablissement())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    cultureScientifiqueOutilPedagogique = value;
    etablissement = value;
}


        public CultureScientifiqueOutilPedagogiqueConverter getCultureScientifiqueOutilPedagogiqueConverter(){
        return this.cultureScientifiqueOutilPedagogiqueConverter;
        }
        public void setCultureScientifiqueOutilPedagogiqueConverter(CultureScientifiqueOutilPedagogiqueConverter cultureScientifiqueOutilPedagogiqueConverter ){
        this.cultureScientifiqueOutilPedagogiqueConverter = cultureScientifiqueOutilPedagogiqueConverter;
        }
        public EtablissementConverter getEtablissementConverter(){
        return this.etablissementConverter;
        }
        public void setEtablissementConverter(EtablissementConverter etablissementConverter ){
        this.etablissementConverter = etablissementConverter;
        }

    public boolean  isCultureScientifiqueOutilPedagogique(){
    return this.cultureScientifiqueOutilPedagogique;
    }
    public void  setCultureScientifiqueOutilPedagogique(boolean cultureScientifiqueOutilPedagogique){
    this.cultureScientifiqueOutilPedagogique = cultureScientifiqueOutilPedagogique;
    }
    public boolean  isEtablissement(){
    return this.etablissement;
    }
    public void  setEtablissement(boolean etablissement){
    this.etablissement = etablissement;
    }






}
