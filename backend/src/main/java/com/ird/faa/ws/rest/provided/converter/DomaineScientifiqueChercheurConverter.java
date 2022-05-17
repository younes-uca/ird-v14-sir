package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.DomaineScientifiqueChercheur;
import com.ird.faa.ws.rest.provided.vo.DomaineScientifiqueChercheurVo;

@Component
public class DomaineScientifiqueChercheurConverter extends AbstractConverter<DomaineScientifiqueChercheur,DomaineScientifiqueChercheurVo>{

        @Autowired
        private DomaineScientifiqueConverter domaineScientifiqueConverter ;
        @Autowired
        private ChercheurConverter chercheurConverter ;
    private Boolean domaineScientifique;
    private Boolean chercheur;

public  DomaineScientifiqueChercheurConverter(){
init(true);
}

@Override
public DomaineScientifiqueChercheur toItem(DomaineScientifiqueChercheurVo vo) {
if (vo == null) {
return null;
} else {
DomaineScientifiqueChercheur item = new DomaineScientifiqueChercheur();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getDomaineScientifiqueVo()!=null && this.domaineScientifique)
        item.setDomaineScientifique(domaineScientifiqueConverter.toItem(vo.getDomaineScientifiqueVo())) ;
    if(vo.getChercheurVo()!=null && this.chercheur)
        item.setChercheur(chercheurConverter.toItem(vo.getChercheurVo())) ;


return item;
}
}

@Override
public DomaineScientifiqueChercheurVo toVo(DomaineScientifiqueChercheur item) {
if (item == null) {
return null;
} else {
DomaineScientifiqueChercheurVo vo = new DomaineScientifiqueChercheurVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getDomaineScientifique()!=null && this.domaineScientifique) {
        vo.setDomaineScientifiqueVo(domaineScientifiqueConverter.toVo(item.getDomaineScientifique())) ;
    }
    if(item.getChercheur()!=null && this.chercheur) {
        vo.setChercheurVo(chercheurConverter.toVo(item.getChercheur())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    domaineScientifique = value;
    chercheur = value;
}


        public DomaineScientifiqueConverter getDomaineScientifiqueConverter(){
        return this.domaineScientifiqueConverter;
        }
        public void setDomaineScientifiqueConverter(DomaineScientifiqueConverter domaineScientifiqueConverter ){
        this.domaineScientifiqueConverter = domaineScientifiqueConverter;
        }
        public ChercheurConverter getChercheurConverter(){
        return this.chercheurConverter;
        }
        public void setChercheurConverter(ChercheurConverter chercheurConverter ){
        this.chercheurConverter = chercheurConverter;
        }

    public boolean  isDomaineScientifique(){
    return this.domaineScientifique;
    }
    public void  setDomaineScientifique(boolean domaineScientifique){
    this.domaineScientifique = domaineScientifique;
    }
    public boolean  isChercheur(){
    return this.chercheur;
    }
    public void  setChercheur(boolean chercheur){
    this.chercheur = chercheur;
    }






}
