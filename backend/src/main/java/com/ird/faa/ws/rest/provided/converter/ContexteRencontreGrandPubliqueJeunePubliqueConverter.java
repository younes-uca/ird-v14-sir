package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.ContexteRencontreGrandPubliqueJeunePublique;
import com.ird.faa.ws.rest.provided.vo.ContexteRencontreGrandPubliqueJeunePubliqueVo;

@Component
public class ContexteRencontreGrandPubliqueJeunePubliqueConverter extends AbstractConverter<ContexteRencontreGrandPubliqueJeunePublique,ContexteRencontreGrandPubliqueJeunePubliqueVo>{

        @Autowired
        private RencontreGrandPubliqueJeunePubliqueConverter rencontreGrandPubliqueJeunePubliqueConverter ;
        @Autowired
        private ContexteConverter contexteConverter ;
    private Boolean rencontreGrandPubliqueJeunePublique;
    private Boolean contexte;

public  ContexteRencontreGrandPubliqueJeunePubliqueConverter(){
init(true);
}

@Override
public ContexteRencontreGrandPubliqueJeunePublique toItem(ContexteRencontreGrandPubliqueJeunePubliqueVo vo) {
if (vo == null) {
return null;
} else {
ContexteRencontreGrandPubliqueJeunePublique item = new ContexteRencontreGrandPubliqueJeunePublique();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getRencontreGrandPubliqueJeunePubliqueVo()!=null && this.rencontreGrandPubliqueJeunePublique)
        item.setRencontreGrandPubliqueJeunePublique(rencontreGrandPubliqueJeunePubliqueConverter.toItem(vo.getRencontreGrandPubliqueJeunePubliqueVo())) ;
    if(vo.getContexteVo()!=null && this.contexte)
        item.setContexte(contexteConverter.toItem(vo.getContexteVo())) ;


return item;
}
}

@Override
public ContexteRencontreGrandPubliqueJeunePubliqueVo toVo(ContexteRencontreGrandPubliqueJeunePublique item) {
if (item == null) {
return null;
} else {
ContexteRencontreGrandPubliqueJeunePubliqueVo vo = new ContexteRencontreGrandPubliqueJeunePubliqueVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getRencontreGrandPubliqueJeunePublique()!=null && this.rencontreGrandPubliqueJeunePublique) {
        vo.setRencontreGrandPubliqueJeunePubliqueVo(rencontreGrandPubliqueJeunePubliqueConverter.toVo(item.getRencontreGrandPubliqueJeunePublique())) ;
    }
    if(item.getContexte()!=null && this.contexte) {
        vo.setContexteVo(contexteConverter.toVo(item.getContexte())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    rencontreGrandPubliqueJeunePublique = value;
    contexte = value;
}


        public RencontreGrandPubliqueJeunePubliqueConverter getRencontreGrandPubliqueJeunePubliqueConverter(){
        return this.rencontreGrandPubliqueJeunePubliqueConverter;
        }
        public void setRencontreGrandPubliqueJeunePubliqueConverter(RencontreGrandPubliqueJeunePubliqueConverter rencontreGrandPubliqueJeunePubliqueConverter ){
        this.rencontreGrandPubliqueJeunePubliqueConverter = rencontreGrandPubliqueJeunePubliqueConverter;
        }
        public ContexteConverter getContexteConverter(){
        return this.contexteConverter;
        }
        public void setContexteConverter(ContexteConverter contexteConverter ){
        this.contexteConverter = contexteConverter;
        }

    public boolean  isRencontreGrandPubliqueJeunePublique(){
    return this.rencontreGrandPubliqueJeunePublique;
    }
    public void  setRencontreGrandPubliqueJeunePublique(boolean rencontreGrandPubliqueJeunePublique){
    this.rencontreGrandPubliqueJeunePublique = rencontreGrandPubliqueJeunePublique;
    }
    public boolean  isContexte(){
    return this.contexte;
    }
    public void  setContexte(boolean contexte){
    this.contexte = contexte;
    }






}
