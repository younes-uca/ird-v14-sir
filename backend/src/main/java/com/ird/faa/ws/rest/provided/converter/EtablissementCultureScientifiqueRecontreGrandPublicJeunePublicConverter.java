package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic;
import com.ird.faa.ws.rest.provided.vo.EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo;

@Component
public class EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter extends AbstractConverter<EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic,EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo>{

        @Autowired
        private CultureScientifiqueRecontreGrandPublicJeunePublicConverter cultureScientifiqueRecontreGrandPublicJeunePublicConverter ;
        @Autowired
        private EtablissementConverter etablissementConverter ;
    private Boolean cultureScientifiqueRecontreGrandPublicJeunePublic;
    private Boolean etablissement;

public  EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter(){
init(true);
}

@Override
public EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic toItem(EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo vo) {
if (vo == null) {
return null;
} else {
EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic item = new EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getCultureScientifiqueRecontreGrandPublicJeunePublicVo()!=null && this.cultureScientifiqueRecontreGrandPublicJeunePublic)
        item.setCultureScientifiqueRecontreGrandPublicJeunePublic(cultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(vo.getCultureScientifiqueRecontreGrandPublicJeunePublicVo())) ;
    if(vo.getEtablissementVo()!=null && this.etablissement)
        item.setEtablissement(etablissementConverter.toItem(vo.getEtablissementVo())) ;


return item;
}
}

@Override
public EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo toVo(EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic item) {
if (item == null) {
return null;
} else {
EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo vo = new EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getCultureScientifiqueRecontreGrandPublicJeunePublic()!=null && this.cultureScientifiqueRecontreGrandPublicJeunePublic) {
        vo.setCultureScientifiqueRecontreGrandPublicJeunePublicVo(cultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(item.getCultureScientifiqueRecontreGrandPublicJeunePublic())) ;
    }
    if(item.getEtablissement()!=null && this.etablissement) {
        vo.setEtablissementVo(etablissementConverter.toVo(item.getEtablissement())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    cultureScientifiqueRecontreGrandPublicJeunePublic = value;
    etablissement = value;
}


        public CultureScientifiqueRecontreGrandPublicJeunePublicConverter getCultureScientifiqueRecontreGrandPublicJeunePublicConverter(){
        return this.cultureScientifiqueRecontreGrandPublicJeunePublicConverter;
        }
        public void setCultureScientifiqueRecontreGrandPublicJeunePublicConverter(CultureScientifiqueRecontreGrandPublicJeunePublicConverter cultureScientifiqueRecontreGrandPublicJeunePublicConverter ){
        this.cultureScientifiqueRecontreGrandPublicJeunePublicConverter = cultureScientifiqueRecontreGrandPublicJeunePublicConverter;
        }
        public EtablissementConverter getEtablissementConverter(){
        return this.etablissementConverter;
        }
        public void setEtablissementConverter(EtablissementConverter etablissementConverter ){
        this.etablissementConverter = etablissementConverter;
        }

    public boolean  isCultureScientifiqueRecontreGrandPublicJeunePublic(){
    return this.cultureScientifiqueRecontreGrandPublicJeunePublic;
    }
    public void  setCultureScientifiqueRecontreGrandPublicJeunePublic(boolean cultureScientifiqueRecontreGrandPublicJeunePublic){
    this.cultureScientifiqueRecontreGrandPublicJeunePublic = cultureScientifiqueRecontreGrandPublicJeunePublic;
    }
    public boolean  isEtablissement(){
    return this.etablissement;
    }
    public void  setEtablissement(boolean etablissement){
    this.etablissement = etablissement;
    }






}
