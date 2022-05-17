package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.PaysEncadrementDoctorant;
import com.ird.faa.ws.rest.provided.vo.PaysEncadrementDoctorantVo;

@Component
public class PaysEncadrementDoctorantConverter extends AbstractConverter<PaysEncadrementDoctorant,PaysEncadrementDoctorantVo>{

        @Autowired
        private PaysConverter paysConverter ;
        @Autowired
        private EncadrementDoctorantConverter encadrementDoctorantConverter ;
    private Boolean pays;
    private Boolean encadrementDoctorant;

public  PaysEncadrementDoctorantConverter(){
init(true);
}

@Override
public PaysEncadrementDoctorant toItem(PaysEncadrementDoctorantVo vo) {
if (vo == null) {
return null;
} else {
PaysEncadrementDoctorant item = new PaysEncadrementDoctorant();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getPaysVo()!=null && this.pays)
        item.setPays(paysConverter.toItem(vo.getPaysVo())) ;
    if(vo.getEncadrementDoctorantVo()!=null && this.encadrementDoctorant)
        item.setEncadrementDoctorant(encadrementDoctorantConverter.toItem(vo.getEncadrementDoctorantVo())) ;


return item;
}
}

@Override
public PaysEncadrementDoctorantVo toVo(PaysEncadrementDoctorant item) {
if (item == null) {
return null;
} else {
PaysEncadrementDoctorantVo vo = new PaysEncadrementDoctorantVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

    if(item.getPays()!=null && this.pays) {
        vo.setPaysVo(paysConverter.toVo(item.getPays())) ;
    }
    if(item.getEncadrementDoctorant()!=null && this.encadrementDoctorant) {
        vo.setEncadrementDoctorantVo(encadrementDoctorantConverter.toVo(item.getEncadrementDoctorant())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    pays = value;
    encadrementDoctorant = value;
}


        public PaysConverter getPaysConverter(){
        return this.paysConverter;
        }
        public void setPaysConverter(PaysConverter paysConverter ){
        this.paysConverter = paysConverter;
        }
        public EncadrementDoctorantConverter getEncadrementDoctorantConverter(){
        return this.encadrementDoctorantConverter;
        }
        public void setEncadrementDoctorantConverter(EncadrementDoctorantConverter encadrementDoctorantConverter ){
        this.encadrementDoctorantConverter = encadrementDoctorantConverter;
        }

    public boolean  isPays(){
    return this.pays;
    }
    public void  setPays(boolean pays){
    this.pays = pays;
    }
    public boolean  isEncadrementDoctorant(){
    return this.encadrementDoctorant;
    }
    public void  setEncadrementDoctorant(boolean encadrementDoctorant){
    this.encadrementDoctorant = encadrementDoctorant;
    }






}
