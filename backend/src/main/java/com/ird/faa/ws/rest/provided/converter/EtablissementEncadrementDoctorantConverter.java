package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.EtablissementEncadrementDoctorant;
import com.ird.faa.ws.rest.provided.vo.EtablissementEncadrementDoctorantVo;

@Component
public class EtablissementEncadrementDoctorantConverter extends AbstractConverter<EtablissementEncadrementDoctorant,EtablissementEncadrementDoctorantVo>{

        @Autowired
        private EtablissementConverter etablissementConverter ;
        @Autowired
        private EncadrementDoctorantConverter encadrementDoctorantConverter ;
    private Boolean etablissement;
    private Boolean encadrementDoctorant;

public  EtablissementEncadrementDoctorantConverter(){
init(true);
}

@Override
public EtablissementEncadrementDoctorant toItem(EtablissementEncadrementDoctorantVo vo) {
if (vo == null) {
return null;
} else {
EtablissementEncadrementDoctorant item = new EtablissementEncadrementDoctorant();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getEtablissementVo()!=null && this.etablissement)
        item.setEtablissement(etablissementConverter.toItem(vo.getEtablissementVo())) ;
    if(vo.getEncadrementDoctorantVo()!=null && this.encadrementDoctorant)
        item.setEncadrementDoctorant(encadrementDoctorantConverter.toItem(vo.getEncadrementDoctorantVo())) ;


return item;
}
}

@Override
public EtablissementEncadrementDoctorantVo toVo(EtablissementEncadrementDoctorant item) {
if (item == null) {
return null;
} else {
EtablissementEncadrementDoctorantVo vo = new EtablissementEncadrementDoctorantVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

    if(item.getEtablissement()!=null && this.etablissement) {
        vo.setEtablissementVo(etablissementConverter.toVo(item.getEtablissement())) ;
    }
    if(item.getEncadrementDoctorant()!=null && this.encadrementDoctorant) {
        vo.setEncadrementDoctorantVo(encadrementDoctorantConverter.toVo(item.getEncadrementDoctorant())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    etablissement = value;
    encadrementDoctorant = value;
}


        public EtablissementConverter getEtablissementConverter(){
        return this.etablissementConverter;
        }
        public void setEtablissementConverter(EtablissementConverter etablissementConverter ){
        this.etablissementConverter = etablissementConverter;
        }
        public EncadrementDoctorantConverter getEncadrementDoctorantConverter(){
        return this.encadrementDoctorantConverter;
        }
        public void setEncadrementDoctorantConverter(EncadrementDoctorantConverter encadrementDoctorantConverter ){
        this.encadrementDoctorantConverter = encadrementDoctorantConverter;
        }

    public boolean  isEtablissement(){
    return this.etablissement;
    }
    public void  setEtablissement(boolean etablissement){
    this.etablissement = etablissement;
    }
    public boolean  isEncadrementDoctorant(){
    return this.encadrementDoctorant;
    }
    public void  setEncadrementDoctorant(boolean encadrementDoctorant){
    this.encadrementDoctorant = encadrementDoctorant;
    }






}
