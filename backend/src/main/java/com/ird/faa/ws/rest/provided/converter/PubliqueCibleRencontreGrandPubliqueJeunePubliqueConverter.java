package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.PubliqueCibleRencontreGrandPubliqueJeunePublique;
import com.ird.faa.ws.rest.provided.vo.PubliqueCibleRencontreGrandPubliqueJeunePubliqueVo;

@Component
public class PubliqueCibleRencontreGrandPubliqueJeunePubliqueConverter extends AbstractConverter<PubliqueCibleRencontreGrandPubliqueJeunePublique,PubliqueCibleRencontreGrandPubliqueJeunePubliqueVo>{

        @Autowired
        private PubliqueCibleRencontreConverter publiqueCibleRencontreConverter ;
        @Autowired
        private RencontreGrandPubliqueJeunePubliqueConverter rencontreGrandPubliqueJeunePubliqueConverter ;
    private Boolean publiqueCibleRencontre;
    private Boolean rencontreGrandPubliqueJeunePublique;

public  PubliqueCibleRencontreGrandPubliqueJeunePubliqueConverter(){
init(true);
}

@Override
public PubliqueCibleRencontreGrandPubliqueJeunePublique toItem(PubliqueCibleRencontreGrandPubliqueJeunePubliqueVo vo) {
if (vo == null) {
return null;
} else {
PubliqueCibleRencontreGrandPubliqueJeunePublique item = new PubliqueCibleRencontreGrandPubliqueJeunePublique();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getPubliqueCibleRencontreVo()!=null && this.publiqueCibleRencontre)
        item.setPubliqueCibleRencontre(publiqueCibleRencontreConverter.toItem(vo.getPubliqueCibleRencontreVo())) ;
    if(vo.getRencontreGrandPubliqueJeunePubliqueVo()!=null && this.rencontreGrandPubliqueJeunePublique)
        item.setRencontreGrandPubliqueJeunePublique(rencontreGrandPubliqueJeunePubliqueConverter.toItem(vo.getRencontreGrandPubliqueJeunePubliqueVo())) ;


return item;
}
}

@Override
public PubliqueCibleRencontreGrandPubliqueJeunePubliqueVo toVo(PubliqueCibleRencontreGrandPubliqueJeunePublique item) {
if (item == null) {
return null;
} else {
PubliqueCibleRencontreGrandPubliqueJeunePubliqueVo vo = new PubliqueCibleRencontreGrandPubliqueJeunePubliqueVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getPubliqueCibleRencontre()!=null && this.publiqueCibleRencontre) {
        vo.setPubliqueCibleRencontreVo(publiqueCibleRencontreConverter.toVo(item.getPubliqueCibleRencontre())) ;
    }
    if(item.getRencontreGrandPubliqueJeunePublique()!=null && this.rencontreGrandPubliqueJeunePublique) {
        vo.setRencontreGrandPubliqueJeunePubliqueVo(rencontreGrandPubliqueJeunePubliqueConverter.toVo(item.getRencontreGrandPubliqueJeunePublique())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    publiqueCibleRencontre = value;
    rencontreGrandPubliqueJeunePublique = value;
}


        public PubliqueCibleRencontreConverter getPubliqueCibleRencontreConverter(){
        return this.publiqueCibleRencontreConverter;
        }
        public void setPubliqueCibleRencontreConverter(PubliqueCibleRencontreConverter publiqueCibleRencontreConverter ){
        this.publiqueCibleRencontreConverter = publiqueCibleRencontreConverter;
        }
        public RencontreGrandPubliqueJeunePubliqueConverter getRencontreGrandPubliqueJeunePubliqueConverter(){
        return this.rencontreGrandPubliqueJeunePubliqueConverter;
        }
        public void setRencontreGrandPubliqueJeunePubliqueConverter(RencontreGrandPubliqueJeunePubliqueConverter rencontreGrandPubliqueJeunePubliqueConverter ){
        this.rencontreGrandPubliqueJeunePubliqueConverter = rencontreGrandPubliqueJeunePubliqueConverter;
        }

    public boolean  isPubliqueCibleRencontre(){
    return this.publiqueCibleRencontre;
    }
    public void  setPubliqueCibleRencontre(boolean publiqueCibleRencontre){
    this.publiqueCibleRencontre = publiqueCibleRencontre;
    }
    public boolean  isRencontreGrandPubliqueJeunePublique(){
    return this.rencontreGrandPubliqueJeunePublique;
    }
    public void  setRencontreGrandPubliqueJeunePublique(boolean rencontreGrandPubliqueJeunePublique){
    this.rencontreGrandPubliqueJeunePublique = rencontreGrandPubliqueJeunePublique;
    }






}
