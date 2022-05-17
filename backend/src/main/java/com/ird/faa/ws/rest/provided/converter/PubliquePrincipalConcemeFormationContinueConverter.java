package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.PubliquePrincipalConcemeFormationContinue;
import com.ird.faa.ws.rest.provided.vo.PubliquePrincipalConcemeFormationContinueVo;

@Component
public class PubliquePrincipalConcemeFormationContinueConverter extends AbstractConverter<PubliquePrincipalConcemeFormationContinue,PubliquePrincipalConcemeFormationContinueVo>{

        @Autowired
        private PubliquePrincipalConverter publiquePrincipalConverter ;
        @Autowired
        private FormationContinueConverter formationContinueConverter ;
    private Boolean publiquePrincipal;
    private Boolean formationContinue;

public  PubliquePrincipalConcemeFormationContinueConverter(){
init(true);
}

@Override
public PubliquePrincipalConcemeFormationContinue toItem(PubliquePrincipalConcemeFormationContinueVo vo) {
if (vo == null) {
return null;
} else {
PubliquePrincipalConcemeFormationContinue item = new PubliquePrincipalConcemeFormationContinue();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getPubliquePrincipalVo()!=null && this.publiquePrincipal)
        item.setPubliquePrincipal(publiquePrincipalConverter.toItem(vo.getPubliquePrincipalVo())) ;
    if(vo.getFormationContinueVo()!=null && this.formationContinue)
        item.setFormationContinue(formationContinueConverter.toItem(vo.getFormationContinueVo())) ;


return item;
}
}

@Override
public PubliquePrincipalConcemeFormationContinueVo toVo(PubliquePrincipalConcemeFormationContinue item) {
if (item == null) {
return null;
} else {
PubliquePrincipalConcemeFormationContinueVo vo = new PubliquePrincipalConcemeFormationContinueVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getPubliquePrincipal()!=null && this.publiquePrincipal) {
        vo.setPubliquePrincipalVo(publiquePrincipalConverter.toVo(item.getPubliquePrincipal())) ;
    }
    if(item.getFormationContinue()!=null && this.formationContinue) {
        vo.setFormationContinueVo(formationContinueConverter.toVo(item.getFormationContinue())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    publiquePrincipal = value;
    formationContinue = value;
}


        public PubliquePrincipalConverter getPubliquePrincipalConverter(){
        return this.publiquePrincipalConverter;
        }
        public void setPubliquePrincipalConverter(PubliquePrincipalConverter publiquePrincipalConverter ){
        this.publiquePrincipalConverter = publiquePrincipalConverter;
        }
        public FormationContinueConverter getFormationContinueConverter(){
        return this.formationContinueConverter;
        }
        public void setFormationContinueConverter(FormationContinueConverter formationContinueConverter ){
        this.formationContinueConverter = formationContinueConverter;
        }

    public boolean  isPubliquePrincipal(){
    return this.publiquePrincipal;
    }
    public void  setPubliquePrincipal(boolean publiquePrincipal){
    this.publiquePrincipal = publiquePrincipal;
    }
    public boolean  isFormationContinue(){
    return this.formationContinue;
    }
    public void  setFormationContinue(boolean formationContinue){
    this.formationContinue = formationContinue;
    }






}
