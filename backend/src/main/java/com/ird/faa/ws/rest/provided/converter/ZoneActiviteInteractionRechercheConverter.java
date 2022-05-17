package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.ZoneActiviteInteractionRecherche;
import com.ird.faa.ws.rest.provided.vo.ZoneActiviteInteractionRechercheVo;

@Component
public class ZoneActiviteInteractionRechercheConverter extends AbstractConverter<ZoneActiviteInteractionRecherche,ZoneActiviteInteractionRechercheVo>{

        @Autowired
        private PaysConverter paysConverter ;
        @Autowired
        private ChercheurConverter chercheurConverter ;
    private Boolean pays;
    private Boolean chercheur;

public  ZoneActiviteInteractionRechercheConverter(){
init(true);
}

@Override
public ZoneActiviteInteractionRecherche toItem(ZoneActiviteInteractionRechercheVo vo) {
if (vo == null) {
return null;
} else {
ZoneActiviteInteractionRecherche item = new ZoneActiviteInteractionRecherche();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getPaysVo()!=null && this.pays)
        item.setPays(paysConverter.toItem(vo.getPaysVo())) ;
    if(vo.getChercheurVo()!=null && this.chercheur)
        item.setChercheur(chercheurConverter.toItem(vo.getChercheurVo())) ;


return item;
}
}

@Override
public ZoneActiviteInteractionRechercheVo toVo(ZoneActiviteInteractionRecherche item) {
if (item == null) {
return null;
} else {
ZoneActiviteInteractionRechercheVo vo = new ZoneActiviteInteractionRechercheVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getPays()!=null && this.pays) {
        vo.setPaysVo(paysConverter.toVo(item.getPays())) ;
    }
    if(item.getChercheur()!=null && this.chercheur) {
        vo.setChercheurVo(chercheurConverter.toVo(item.getChercheur())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    pays = value;
    chercheur = value;
}


        public PaysConverter getPaysConverter(){
        return this.paysConverter;
        }
        public void setPaysConverter(PaysConverter paysConverter ){
        this.paysConverter = paysConverter;
        }
        public ChercheurConverter getChercheurConverter(){
        return this.chercheurConverter;
        }
        public void setChercheurConverter(ChercheurConverter chercheurConverter ){
        this.chercheurConverter = chercheurConverter;
        }

    public boolean  isPays(){
    return this.pays;
    }
    public void  setPays(boolean pays){
    this.pays = pays;
    }
    public boolean  isChercheur(){
    return this.chercheur;
    }
    public void  setChercheur(boolean chercheur){
    this.chercheur = chercheur;
    }






}
