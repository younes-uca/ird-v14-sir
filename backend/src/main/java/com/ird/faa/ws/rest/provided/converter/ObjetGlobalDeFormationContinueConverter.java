package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.ObjetGlobalDeFormationContinue;
import com.ird.faa.ws.rest.provided.vo.ObjetGlobalDeFormationContinueVo;

@Component
public class ObjetGlobalDeFormationContinueConverter extends AbstractConverter<ObjetGlobalDeFormationContinue,ObjetGlobalDeFormationContinueVo>{

        @Autowired
        private FormationContinueConverter formationContinueConverter ;
        @Autowired
        private ObjetGlobalConverter objetGlobalConverter ;
    private Boolean objetGlobal;
    private Boolean formationContinue;

public  ObjetGlobalDeFormationContinueConverter(){
init(true);
}

@Override
public ObjetGlobalDeFormationContinue toItem(ObjetGlobalDeFormationContinueVo vo) {
if (vo == null) {
return null;
} else {
ObjetGlobalDeFormationContinue item = new ObjetGlobalDeFormationContinue();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getObjetGlobalVo()!=null && this.objetGlobal)
        item.setObjetGlobal(objetGlobalConverter.toItem(vo.getObjetGlobalVo())) ;
    if(vo.getFormationContinueVo()!=null && this.formationContinue)
        item.setFormationContinue(formationContinueConverter.toItem(vo.getFormationContinueVo())) ;


return item;
}
}

@Override
public ObjetGlobalDeFormationContinueVo toVo(ObjetGlobalDeFormationContinue item) {
if (item == null) {
return null;
} else {
ObjetGlobalDeFormationContinueVo vo = new ObjetGlobalDeFormationContinueVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getObjetGlobal()!=null && this.objetGlobal) {
        vo.setObjetGlobalVo(objetGlobalConverter.toVo(item.getObjetGlobal())) ;
    }
    if(item.getFormationContinue()!=null && this.formationContinue) {
        vo.setFormationContinueVo(formationContinueConverter.toVo(item.getFormationContinue())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    objetGlobal = value;
    formationContinue = value;
}


        public FormationContinueConverter getFormationContinueConverter(){
        return this.formationContinueConverter;
        }
        public void setFormationContinueConverter(FormationContinueConverter formationContinueConverter ){
        this.formationContinueConverter = formationContinueConverter;
        }
        public ObjetGlobalConverter getObjetGlobalConverter(){
        return this.objetGlobalConverter;
        }
        public void setObjetGlobalConverter(ObjetGlobalConverter objetGlobalConverter ){
        this.objetGlobalConverter = objetGlobalConverter;
        }

    public boolean  isObjetGlobal(){
    return this.objetGlobal;
    }
    public void  setObjetGlobal(boolean objetGlobal){
    this.objetGlobal = objetGlobal;
    }
    public boolean  isFormationContinue(){
    return this.formationContinue;
    }
    public void  setFormationContinue(boolean formationContinue){
    this.formationContinue = formationContinue;
    }






}
