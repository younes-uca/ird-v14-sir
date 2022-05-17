package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.ContexteCultureScientifiqueRecontreGrandPublicJeunePublic;
import com.ird.faa.ws.rest.provided.vo.ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo;

@Component
public class ContexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter extends AbstractConverter<ContexteCultureScientifiqueRecontreGrandPublicJeunePublic,ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo>{

        @Autowired
        private ContexteConverter contexteConverter ;
        @Autowired
        private CultureScientifiqueRecontreGrandPublicJeunePublicConverter cultureScientifiqueRecontreGrandPublicJeunePublicConverter ;
    private Boolean cultureScientifiqueRecontreGrandPublicJeunePublic;
    private Boolean contexte;

public  ContexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter(){
init(true);
}

@Override
public ContexteCultureScientifiqueRecontreGrandPublicJeunePublic toItem(ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo vo) {
if (vo == null) {
return null;
} else {
ContexteCultureScientifiqueRecontreGrandPublicJeunePublic item = new ContexteCultureScientifiqueRecontreGrandPublicJeunePublic();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getCultureScientifiqueRecontreGrandPublicJeunePublicVo()!=null && this.cultureScientifiqueRecontreGrandPublicJeunePublic)
        item.setCultureScientifiqueRecontreGrandPublicJeunePublic(cultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(vo.getCultureScientifiqueRecontreGrandPublicJeunePublicVo())) ;
    if(vo.getContexteVo()!=null && this.contexte)
        item.setContexte(contexteConverter.toItem(vo.getContexteVo())) ;


return item;
}
}

@Override
public ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo toVo(ContexteCultureScientifiqueRecontreGrandPublicJeunePublic item) {
if (item == null) {
return null;
} else {
ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo vo = new ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getCultureScientifiqueRecontreGrandPublicJeunePublic()!=null && this.cultureScientifiqueRecontreGrandPublicJeunePublic) {
        vo.setCultureScientifiqueRecontreGrandPublicJeunePublicVo(cultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(item.getCultureScientifiqueRecontreGrandPublicJeunePublic())) ;
    }
    if(item.getContexte()!=null && this.contexte) {
        vo.setContexteVo(contexteConverter.toVo(item.getContexte())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    cultureScientifiqueRecontreGrandPublicJeunePublic = value;
    contexte = value;
}


        public ContexteConverter getContexteConverter(){
        return this.contexteConverter;
        }
        public void setContexteConverter(ContexteConverter contexteConverter ){
        this.contexteConverter = contexteConverter;
        }
        public CultureScientifiqueRecontreGrandPublicJeunePublicConverter getCultureScientifiqueRecontreGrandPublicJeunePublicConverter(){
        return this.cultureScientifiqueRecontreGrandPublicJeunePublicConverter;
        }
        public void setCultureScientifiqueRecontreGrandPublicJeunePublicConverter(CultureScientifiqueRecontreGrandPublicJeunePublicConverter cultureScientifiqueRecontreGrandPublicJeunePublicConverter ){
        this.cultureScientifiqueRecontreGrandPublicJeunePublicConverter = cultureScientifiqueRecontreGrandPublicJeunePublicConverter;
        }

    public boolean  isCultureScientifiqueRecontreGrandPublicJeunePublic(){
    return this.cultureScientifiqueRecontreGrandPublicJeunePublic;
    }
    public void  setCultureScientifiqueRecontreGrandPublicJeunePublic(boolean cultureScientifiqueRecontreGrandPublicJeunePublic){
    this.cultureScientifiqueRecontreGrandPublicJeunePublic = cultureScientifiqueRecontreGrandPublicJeunePublic;
    }
    public boolean  isContexte(){
    return this.contexte;
    }
    public void  setContexte(boolean contexte){
    this.contexte = contexte;
    }






}
