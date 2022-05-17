package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.FinancementEncadrementDoctorant;
import com.ird.faa.ws.rest.provided.vo.FinancementEncadrementDoctorantVo;

@Component
public class FinancementEncadrementDoctorantConverter extends AbstractConverter<FinancementEncadrementDoctorant,FinancementEncadrementDoctorantVo>{

        @Autowired
        private FinancementDoctorantConverter enjeuxIrdConverter ;
        @Autowired
        private EncadrementDoctorantConverter encadrementDoctorantConverter ;
    private Boolean enjeuxIrd;
    private Boolean encadrementDoctorant;

public  FinancementEncadrementDoctorantConverter(){
init(true);
}

@Override
public FinancementEncadrementDoctorant toItem(FinancementEncadrementDoctorantVo vo) {
if (vo == null) {
return null;
} else {
FinancementEncadrementDoctorant item = new FinancementEncadrementDoctorant();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getFinancementDoctorantVo()!=null && this.enjeuxIrd)
        item.setFinancement(enjeuxIrdConverter.toItem(vo.getFinancementDoctorantVo())) ;
    if(vo.getEncadrementDoctorantVo()!=null && this.encadrementDoctorant)
        item.setEncadrementDoctorant(encadrementDoctorantConverter.toItem(vo.getEncadrementDoctorantVo())) ;


return item;
}
}

@Override
public FinancementEncadrementDoctorantVo toVo(FinancementEncadrementDoctorant item) {
if (item == null) {
return null;
} else {
FinancementEncadrementDoctorantVo vo = new FinancementEncadrementDoctorantVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

    if(item.getFinancement()!=null && this.enjeuxIrd) {
        vo.setFinancementDoctorantVo(enjeuxIrdConverter.toVo(item.getFinancement())) ;
    }
    if(item.getEncadrementDoctorant()!=null && this.encadrementDoctorant) {
        vo.setEncadrementDoctorantVo(encadrementDoctorantConverter.toVo(item.getEncadrementDoctorant())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    enjeuxIrd = value;
    encadrementDoctorant = value;
}


        public FinancementDoctorantConverter getFinancementDoctorantConverter(){
        return this.enjeuxIrdConverter;
        }
        public void setFinancementDoctorantConverter(FinancementDoctorantConverter enjeuxIrdConverter ){
        this.enjeuxIrdConverter = enjeuxIrdConverter;
        }
        public EncadrementDoctorantConverter getEncadrementDoctorantConverter(){
        return this.encadrementDoctorantConverter;
        }
        public void setEncadrementDoctorantConverter(EncadrementDoctorantConverter encadrementDoctorantConverter ){
        this.encadrementDoctorantConverter = encadrementDoctorantConverter;
        }

    public boolean  isFinancement(){
    return this.enjeuxIrd;
    }
    public void  setFinancement(boolean enjeuxIrd){
    this.enjeuxIrd = enjeuxIrd;
    }
    public boolean  isEncadrementDoctorant(){
    return this.encadrementDoctorant;
    }
    public void  setEncadrementDoctorant(boolean encadrementDoctorant){
    this.encadrementDoctorant = encadrementDoctorant;
    }






}
