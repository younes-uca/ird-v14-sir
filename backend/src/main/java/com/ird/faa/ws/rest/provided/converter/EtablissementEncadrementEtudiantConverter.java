package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.EtablissementEncadrementEtudiant;
import com.ird.faa.ws.rest.provided.vo.EtablissementEncadrementEtudiantVo;

@Component
public class EtablissementEncadrementEtudiantConverter extends AbstractConverter<EtablissementEncadrementEtudiant,EtablissementEncadrementEtudiantVo>{

        @Autowired
        private EtablissementConverter etablissementConverter ;
        @Autowired
        private EncadrementEtudiantConverter encadrementEtudiantConverter ;
    private Boolean etablissement;
    private Boolean encadrementEtudiant;

public  EtablissementEncadrementEtudiantConverter(){
init(true);
}

@Override
public EtablissementEncadrementEtudiant toItem(EtablissementEncadrementEtudiantVo vo) {
if (vo == null) {
return null;
} else {
EtablissementEncadrementEtudiant item = new EtablissementEncadrementEtudiant();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getEtablissementVo()!=null && this.etablissement)
        item.setEtablissement(etablissementConverter.toItem(vo.getEtablissementVo())) ;
    if(vo.getEncadrementEtudiantVo()!=null && this.encadrementEtudiant)
        item.setEncadrementEtudiant(encadrementEtudiantConverter.toItem(vo.getEncadrementEtudiantVo())) ;


return item;
}
}

@Override
public EtablissementEncadrementEtudiantVo toVo(EtablissementEncadrementEtudiant item) {
if (item == null) {
return null;
} else {
EtablissementEncadrementEtudiantVo vo = new EtablissementEncadrementEtudiantVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

    if(item.getEtablissement()!=null && this.etablissement) {
        vo.setEtablissementVo(etablissementConverter.toVo(item.getEtablissement())) ;
    }
    if(item.getEncadrementEtudiant()!=null && this.encadrementEtudiant) {
        vo.setEncadrementEtudiantVo(encadrementEtudiantConverter.toVo(item.getEncadrementEtudiant())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    etablissement = value;
    encadrementEtudiant = value;
}


        public EtablissementConverter getEtablissementConverter(){
        return this.etablissementConverter;
        }
        public void setEtablissementConverter(EtablissementConverter etablissementConverter ){
        this.etablissementConverter = etablissementConverter;
        }
        public EncadrementEtudiantConverter getEncadrementEtudiantConverter(){
        return this.encadrementEtudiantConverter;
        }
        public void setEncadrementEtudiantConverter(EncadrementEtudiantConverter encadrementEtudiantConverter ){
        this.encadrementEtudiantConverter = encadrementEtudiantConverter;
        }

    public boolean  isEtablissement(){
    return this.etablissement;
    }
    public void  setEtablissement(boolean etablissement){
    this.etablissement = etablissement;
    }
    public boolean  isEncadrementEtudiant(){
    return this.encadrementEtudiant;
    }
    public void  setEncadrementEtudiant(boolean encadrementEtudiant){
    this.encadrementEtudiant = encadrementEtudiant;
    }






}
