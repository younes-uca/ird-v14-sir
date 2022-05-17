package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.PaysCultureScientifiqueRecontreGrandPublicJeunePublic;
import com.ird.faa.ws.rest.provided.vo.PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo;

@Component
public class PaysCultureScientifiqueRecontreGrandPublicJeunePublicConverter extends AbstractConverter<PaysCultureScientifiqueRecontreGrandPublicJeunePublic,PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo>{

        @Autowired
        private CultureScientifiqueRecontreGrandPublicJeunePublicConverter cultureScientifiqueRecontreGrandPublicJeunePublicConverter ;
        @Autowired
        private PaysConverter paysConverter ;
    private Boolean pays;
    private Boolean cultureScientifiqueRecontreGrandPublicJeunePublic;

public  PaysCultureScientifiqueRecontreGrandPublicJeunePublicConverter(){
init(true);
}

@Override
public PaysCultureScientifiqueRecontreGrandPublicJeunePublic toItem(PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo vo) {
if (vo == null) {
return null;
} else {
PaysCultureScientifiqueRecontreGrandPublicJeunePublic item = new PaysCultureScientifiqueRecontreGrandPublicJeunePublic();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getPaysVo()!=null && this.pays)
        item.setPays(paysConverter.toItem(vo.getPaysVo())) ;
    if(vo.getCultureScientifiqueRecontreGrandPublicJeunePublicVo()!=null && this.cultureScientifiqueRecontreGrandPublicJeunePublic)
        item.setCultureScientifiqueRecontreGrandPublicJeunePublic(cultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(vo.getCultureScientifiqueRecontreGrandPublicJeunePublicVo())) ;


return item;
}
}

@Override
public PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo toVo(PaysCultureScientifiqueRecontreGrandPublicJeunePublic item) {
if (item == null) {
return null;
} else {
PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo vo = new PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
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
    pays = value;
    cultureScientifiqueRecontreGrandPublicJeunePublic = value;
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
