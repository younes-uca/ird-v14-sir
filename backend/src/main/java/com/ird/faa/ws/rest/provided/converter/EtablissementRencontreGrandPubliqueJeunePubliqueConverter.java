package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.EtablissementRencontreGrandPubliqueJeunePublique;
import com.ird.faa.ws.rest.provided.vo.EtablissementRencontreGrandPubliqueJeunePubliqueVo;

@Component
public class EtablissementRencontreGrandPubliqueJeunePubliqueConverter extends AbstractConverter<EtablissementRencontreGrandPubliqueJeunePublique,EtablissementRencontreGrandPubliqueJeunePubliqueVo>{

        @Autowired
        private RencontreGrandPubliqueJeunePubliqueConverter rencontreGrandPubliqueJeunePubliqueConverter ;
        @Autowired
        private EtablissementConverter etablissementConverter ;
    private Boolean rencontreGrandPubliqueJeunePublique;
    private Boolean etablissement;

public  EtablissementRencontreGrandPubliqueJeunePubliqueConverter(){
init(true);
}

@Override
public EtablissementRencontreGrandPubliqueJeunePublique toItem(EtablissementRencontreGrandPubliqueJeunePubliqueVo vo) {
if (vo == null) {
return null;
} else {
EtablissementRencontreGrandPubliqueJeunePublique item = new EtablissementRencontreGrandPubliqueJeunePublique();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getRencontreGrandPubliqueJeunePubliqueVo()!=null && this.rencontreGrandPubliqueJeunePublique)
        item.setRencontreGrandPubliqueJeunePublique(rencontreGrandPubliqueJeunePubliqueConverter.toItem(vo.getRencontreGrandPubliqueJeunePubliqueVo())) ;
    if(vo.getEtablissementVo()!=null && this.etablissement)
        item.setEtablissement(etablissementConverter.toItem(vo.getEtablissementVo())) ;


return item;
}
}

@Override
public EtablissementRencontreGrandPubliqueJeunePubliqueVo toVo(EtablissementRencontreGrandPubliqueJeunePublique item) {
if (item == null) {
return null;
} else {
EtablissementRencontreGrandPubliqueJeunePubliqueVo vo = new EtablissementRencontreGrandPubliqueJeunePubliqueVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getRencontreGrandPubliqueJeunePublique()!=null && this.rencontreGrandPubliqueJeunePublique) {
        vo.setRencontreGrandPubliqueJeunePubliqueVo(rencontreGrandPubliqueJeunePubliqueConverter.toVo(item.getRencontreGrandPubliqueJeunePublique())) ;
    }
    if(item.getEtablissement()!=null && this.etablissement) {
        vo.setEtablissementVo(etablissementConverter.toVo(item.getEtablissement())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    rencontreGrandPubliqueJeunePublique = value;
    etablissement = value;
}


        public RencontreGrandPubliqueJeunePubliqueConverter getRencontreGrandPubliqueJeunePubliqueConverter(){
        return this.rencontreGrandPubliqueJeunePubliqueConverter;
        }
        public void setRencontreGrandPubliqueJeunePubliqueConverter(RencontreGrandPubliqueJeunePubliqueConverter rencontreGrandPubliqueJeunePubliqueConverter ){
        this.rencontreGrandPubliqueJeunePubliqueConverter = rencontreGrandPubliqueJeunePubliqueConverter;
        }
        public EtablissementConverter getEtablissementConverter(){
        return this.etablissementConverter;
        }
        public void setEtablissementConverter(EtablissementConverter etablissementConverter ){
        this.etablissementConverter = etablissementConverter;
        }

    public boolean  isRencontreGrandPubliqueJeunePublique(){
    return this.rencontreGrandPubliqueJeunePublique;
    }
    public void  setRencontreGrandPubliqueJeunePublique(boolean rencontreGrandPubliqueJeunePublique){
    this.rencontreGrandPubliqueJeunePublique = rencontreGrandPubliqueJeunePublique;
    }
    public boolean  isEtablissement(){
    return this.etablissement;
    }
    public void  setEtablissement(boolean etablissement){
    this.etablissement = etablissement;
    }






}
