package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.PublicCibleCultureScientifiqueOutilPedagogique;
import com.ird.faa.ws.rest.provided.vo.PublicCibleCultureScientifiqueOutilPedagogiqueVo;

@Component
public class PublicCibleCultureScientifiqueOutilPedagogiqueConverter extends AbstractConverter<PublicCibleCultureScientifiqueOutilPedagogique,PublicCibleCultureScientifiqueOutilPedagogiqueVo>{

        @Autowired
        private PublicCibleConverter publicCibleConverter ;
        @Autowired
        private CultureScientifiqueOutilPedagogiqueConverter cultureScientifiqueOutilPedagogiqueConverter ;
        @Autowired
        private PaysConverter paysConverter ;
    private Boolean publicCible;
    private Boolean cultureScientifiqueOutilPedagogique;
    private Boolean pays;

public  PublicCibleCultureScientifiqueOutilPedagogiqueConverter(){
init(true);
}

@Override
public PublicCibleCultureScientifiqueOutilPedagogique toItem(PublicCibleCultureScientifiqueOutilPedagogiqueVo vo) {
if (vo == null) {
return null;
} else {
PublicCibleCultureScientifiqueOutilPedagogique item = new PublicCibleCultureScientifiqueOutilPedagogique();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getPublicCibleVo()!=null && this.publicCible)
        item.setPublicCible(publicCibleConverter.toItem(vo.getPublicCibleVo())) ;
    if(vo.getCultureScientifiqueOutilPedagogiqueVo()!=null && this.cultureScientifiqueOutilPedagogique)
        item.setCultureScientifiqueOutilPedagogique(cultureScientifiqueOutilPedagogiqueConverter.toItem(vo.getCultureScientifiqueOutilPedagogiqueVo())) ;
    if(vo.getPaysVo()!=null && this.pays)
        item.setPays(paysConverter.toItem(vo.getPaysVo())) ;


return item;
}
}

@Override
public PublicCibleCultureScientifiqueOutilPedagogiqueVo toVo(PublicCibleCultureScientifiqueOutilPedagogique item) {
if (item == null) {
return null;
} else {
PublicCibleCultureScientifiqueOutilPedagogiqueVo vo = new PublicCibleCultureScientifiqueOutilPedagogiqueVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getPublicCible()!=null && this.publicCible) {
        vo.setPublicCibleVo(publicCibleConverter.toVo(item.getPublicCible())) ;
    }
    if(item.getCultureScientifiqueOutilPedagogique()!=null && this.cultureScientifiqueOutilPedagogique) {
        vo.setCultureScientifiqueOutilPedagogiqueVo(cultureScientifiqueOutilPedagogiqueConverter.toVo(item.getCultureScientifiqueOutilPedagogique())) ;
    }
    if(item.getPays()!=null && this.pays) {
        vo.setPaysVo(paysConverter.toVo(item.getPays())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    publicCible = value;
    cultureScientifiqueOutilPedagogique = value;
    pays = value;
}


        public PublicCibleConverter getPublicCibleConverter(){
        return this.publicCibleConverter;
        }
        public void setPublicCibleConverter(PublicCibleConverter publicCibleConverter ){
        this.publicCibleConverter = publicCibleConverter;
        }
        public CultureScientifiqueOutilPedagogiqueConverter getCultureScientifiqueOutilPedagogiqueConverter(){
        return this.cultureScientifiqueOutilPedagogiqueConverter;
        }
        public void setCultureScientifiqueOutilPedagogiqueConverter(CultureScientifiqueOutilPedagogiqueConverter cultureScientifiqueOutilPedagogiqueConverter ){
        this.cultureScientifiqueOutilPedagogiqueConverter = cultureScientifiqueOutilPedagogiqueConverter;
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
    public boolean  isCultureScientifiqueOutilPedagogique(){
    return this.cultureScientifiqueOutilPedagogique;
    }
    public void  setCultureScientifiqueOutilPedagogique(boolean cultureScientifiqueOutilPedagogique){
    this.cultureScientifiqueOutilPedagogique = cultureScientifiqueOutilPedagogique;
    }
    public boolean  isPays(){
    return this.pays;
    }
    public void  setPays(boolean pays){
    this.pays = pays;
    }








}
