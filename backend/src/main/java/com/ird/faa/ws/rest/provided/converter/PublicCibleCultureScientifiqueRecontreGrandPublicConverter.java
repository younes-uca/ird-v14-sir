package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.PublicCibleCultureScientifiqueRecontreGrandPublic;
import com.ird.faa.ws.rest.provided.vo.PublicCibleCultureScientifiqueRecontreGrandPublicVo;

@Component
public class PublicCibleCultureScientifiqueRecontreGrandPublicConverter extends AbstractConverter<PublicCibleCultureScientifiqueRecontreGrandPublic,PublicCibleCultureScientifiqueRecontreGrandPublicVo>{

        @Autowired
        private PublicCibleConverter publicCibleConverter ;
        @Autowired
        private CultureScientifiqueRecontreGrandPublicJeunePublicConverter cultureScientifiqueRecontreGrandPublicJeunePublicConverter ;
        @Autowired
        private PaysConverter paysConverter ;
    private Boolean publicCible;
    private Boolean pays;
    private Boolean cultureScientifiqueRecontreGrandPublicJeunePublic;

public  PublicCibleCultureScientifiqueRecontreGrandPublicConverter(){
init(true);
}

@Override
public PublicCibleCultureScientifiqueRecontreGrandPublic toItem(PublicCibleCultureScientifiqueRecontreGrandPublicVo vo) {
if (vo == null) {
return null;
} else {
PublicCibleCultureScientifiqueRecontreGrandPublic item = new PublicCibleCultureScientifiqueRecontreGrandPublic();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getPublicCibleVo()!=null && this.publicCible)
        item.setPublicCible(publicCibleConverter.toItem(vo.getPublicCibleVo())) ;
    if(vo.getPaysVo()!=null && this.pays)
        item.setPays(paysConverter.toItem(vo.getPaysVo())) ;
    if(vo.getCultureScientifiqueRecontreGrandPublicJeunePublicVo()!=null && this.cultureScientifiqueRecontreGrandPublicJeunePublic)
        item.setCultureScientifiqueRecontreGrandPublicJeunePublic(cultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(vo.getCultureScientifiqueRecontreGrandPublicJeunePublicVo())) ;


return item;
}
}

@Override
public PublicCibleCultureScientifiqueRecontreGrandPublicVo toVo(PublicCibleCultureScientifiqueRecontreGrandPublic item) {
if (item == null) {
return null;
} else {
PublicCibleCultureScientifiqueRecontreGrandPublicVo vo = new PublicCibleCultureScientifiqueRecontreGrandPublicVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getPublicCible()!=null && this.publicCible) {
        vo.setPublicCibleVo(publicCibleConverter.toVo(item.getPublicCible())) ;
    }
    if(item.getPays()!=null && this.pays) {
        vo.setPaysVo(paysConverter.toVo(item.getPays())) ;
    }
    if(item.getCultureScientifiqueRecontreGrandPublicJeunePublic()!=null && this.cultureScientifiqueRecontreGrandPublicJeunePublic) {
        vo.setCultureScientifiqueRecontreGrandPublicJeunePublicVo(cultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(item.getCultureScientifiqueRecontreGrandPublicJeunePublic())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    publicCible = value;
    pays = value;
    cultureScientifiqueRecontreGrandPublicJeunePublic = value;
}


        public PublicCibleConverter getPublicCibleConverter(){
        return this.publicCibleConverter;
        }
        public void setPublicCibleConverter(PublicCibleConverter publicCibleConverter ){
        this.publicCibleConverter = publicCibleConverter;
        }
        public CultureScientifiqueRecontreGrandPublicJeunePublicConverter getCultureScientifiqueRecontreGrandPublicJeunePublicConverter(){
        return this.cultureScientifiqueRecontreGrandPublicJeunePublicConverter;
        }
        public void setCultureScientifiqueRecontreGrandPublicJeunePublicConverter(CultureScientifiqueRecontreGrandPublicJeunePublicConverter cultureScientifiqueRecontreGrandPublicJeunePublicConverter ){
        this.cultureScientifiqueRecontreGrandPublicJeunePublicConverter = cultureScientifiqueRecontreGrandPublicJeunePublicConverter;
        }
        public PaysConverter getPaysConverter(){
        return this.paysConverter;
        }
        public void setPaysConverter(PaysConverter paysConverter ){
        this.paysConverter = paysConverter;
        }

    public boolean  isPublicCible(){
    return this.publicCible;
    }
    public void  setPublicCible(boolean publicCible){
    this.publicCible = publicCible;
    }
    public boolean  isPays(){
    return this.pays;
    }
    public void  setPays(boolean pays){
    this.pays = pays;
    }
    public boolean  isCultureScientifiqueRecontreGrandPublicJeunePublic(){
    return this.cultureScientifiqueRecontreGrandPublicJeunePublic;
    }
    public void  setCultureScientifiqueRecontreGrandPublicJeunePublic(boolean cultureScientifiqueRecontreGrandPublicJeunePublic){
    this.cultureScientifiqueRecontreGrandPublicJeunePublic = cultureScientifiqueRecontreGrandPublicJeunePublic;
    }








}
