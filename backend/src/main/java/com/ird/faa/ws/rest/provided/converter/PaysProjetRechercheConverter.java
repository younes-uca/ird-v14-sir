package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.PaysProjetRecherche;
import com.ird.faa.ws.rest.provided.vo.PaysProjetRechercheVo;

@Component
public class PaysProjetRechercheConverter extends AbstractConverter<PaysProjetRecherche,PaysProjetRechercheVo>{

        @Autowired
        private ProjetActiviteRechercheConverter projetActiviteRechercheConverter ;
        @Autowired
        private PaysConverter paysConverter ;
    private Boolean pays;
    private Boolean projetActiviteRecherche;

public  PaysProjetRechercheConverter(){
init(true);
}

@Override
public PaysProjetRecherche toItem(PaysProjetRechercheVo vo) {
if (vo == null) {
return null;
} else {
PaysProjetRecherche item = new PaysProjetRecherche();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getPaysVo()!=null && this.pays)
        item.setPays(paysConverter.toItem(vo.getPaysVo())) ;
    if(vo.getProjetActiviteRechercheVo()!=null && this.projetActiviteRecherche)
        item.setProjetActiviteRecherche(projetActiviteRechercheConverter.toItem(vo.getProjetActiviteRechercheVo())) ;


return item;
}
}

@Override
public PaysProjetRechercheVo toVo(PaysProjetRecherche item) {
if (item == null) {
return null;
} else {
PaysProjetRechercheVo vo = new PaysProjetRechercheVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getPays()!=null && this.pays) {
        vo.setPaysVo(paysConverter.toVo(item.getPays())) ;
    }
    if(item.getProjetActiviteRecherche()!=null && this.projetActiviteRecherche) {
        vo.setProjetActiviteRechercheVo(projetActiviteRechercheConverter.toVo(item.getProjetActiviteRecherche())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    pays = value;
    projetActiviteRecherche = value;
}


        public ProjetActiviteRechercheConverter getProjetActiviteRechercheConverter(){
        return this.projetActiviteRechercheConverter;
        }
        public void setProjetActiviteRechercheConverter(ProjetActiviteRechercheConverter projetActiviteRechercheConverter ){
        this.projetActiviteRechercheConverter = projetActiviteRechercheConverter;
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
    public boolean  isProjetActiviteRecherche(){
    return this.projetActiviteRecherche;
    }
    public void  setProjetActiviteRecherche(boolean projetActiviteRecherche){
    this.projetActiviteRecherche = projetActiviteRecherche;
    }






}
