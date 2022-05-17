package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.FournisseurAppelProjetRecherche;
import com.ird.faa.ws.rest.provided.vo.FournisseurAppelProjetRechercheVo;

@Component
public class FournisseurAppelProjetRechercheConverter extends AbstractConverter<FournisseurAppelProjetRecherche,FournisseurAppelProjetRechercheVo>{

        @Autowired
        private PaysConverter paysConverter ;
    private Boolean pays;

public  FournisseurAppelProjetRechercheConverter(){
init(true);
}

@Override
public FournisseurAppelProjetRecherche toItem(FournisseurAppelProjetRechercheVo vo) {
if (vo == null) {
return null;
} else {
FournisseurAppelProjetRecherche item = new FournisseurAppelProjetRecherche();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
    if(vo.getPaysVo()!=null && this.pays)
        item.setPays(paysConverter.toItem(vo.getPaysVo())) ;


return item;
}
}

@Override
public FournisseurAppelProjetRechercheVo toVo(FournisseurAppelProjetRecherche item) {
if (item == null) {
return null;
} else {
FournisseurAppelProjetRechercheVo vo = new FournisseurAppelProjetRechercheVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

    if(item.getPays()!=null && this.pays) {
        vo.setPaysVo(paysConverter.toVo(item.getPays())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    pays = value;
}


        public PaysConverter getPaysConverter(){
        return this.paysConverter;
        }
        public void setPaysConverter(PaysConverter paysConverter ){
        this.paysConverter = paysConverter;
        }

    public boolean  isPays(){
    return this.pays;
    }
    public void  setPays(boolean pays){
    this.pays = pays;
    }










}
