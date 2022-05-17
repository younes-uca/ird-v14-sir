package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.EcoleDoctorale;
import com.ird.faa.ws.rest.provided.vo.EcoleDoctoraleVo;

@Component
public class EcoleDoctoraleConverter extends AbstractConverter<EcoleDoctorale,EcoleDoctoraleVo>{

        @Autowired
        private PaysConverter paysConverter ;
    private Boolean pays;

public  EcoleDoctoraleConverter(){
init(true);
}

@Override
public EcoleDoctorale toItem(EcoleDoctoraleVo vo) {
if (vo == null) {
return null;
} else {
EcoleDoctorale item = new EcoleDoctorale();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getIntitule()))
        item.setIntitule(vo.getIntitule());
        if(StringUtil.isNotEmpty(vo.getInternational()))
        item.setInternational(NumberUtil.toBoolean(vo.getInternational()));
    if(vo.getPaysVo()!=null && this.pays)
        item.setPays(paysConverter.toItem(vo.getPaysVo())) ;


return item;
}
}

@Override
public EcoleDoctoraleVo toVo(EcoleDoctorale item) {
if (item == null) {
return null;
} else {
EcoleDoctoraleVo vo = new EcoleDoctoraleVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getIntitule()))
        vo.setIntitule(item.getIntitule());

        if(item.getInternational()!=null)
        vo.setInternational(NumberUtil.toString(item.getInternational()));
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
