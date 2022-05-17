package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.Doctorant;
import com.ird.faa.ws.rest.provided.vo.DoctorantVo;

@Component
public class DoctorantConverter extends AbstractConverter<Doctorant,DoctorantVo>{

        @Autowired
        private SexeConverter sexeConverter ;
        @Autowired
        private PaysConverter paysConverter ;
    private Boolean sexe;
    private Boolean pays;

public  DoctorantConverter(){
init(true);
}

@Override
public Doctorant toItem(DoctorantVo vo) {
if (vo == null) {
return null;
} else {
Doctorant item = new Doctorant();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        
        if(StringUtil.isNotEmpty(vo.getNom()))
        item.setNom(vo.getNom());
        
        if(StringUtil.isNotEmpty(vo.getCivilite()))
            item.setCivilite(vo.getCivilite());
        
          
        if(StringUtil.isNotEmpty(vo.getPrenom()))
        item.setPrenom(vo.getPrenom());
        if(StringUtil.isNotEmpty(vo.getAnneeNaissance()))
        item.setAnneeNaissance(NumberUtil.toInt(vo.getAnneeNaissance()));
    if(vo.getSexeVo()!=null && this.sexe)
        item.setSexe(sexeConverter.toItem(vo.getSexeVo())) ;
    if(vo.getPaysVo()!=null && this.pays)
        item.setPays(paysConverter.toItem(vo.getPaysVo())) ;


return item;
}
}

@Override
public DoctorantVo toVo(Doctorant item) {
if (item == null) {
return null;
} else {
DoctorantVo vo = new DoctorantVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        
        if(StringUtil.isNotEmpty(item.getCivilite()))
            vo.setCivilite(item.getCivilite());

        
        
        if(StringUtil.isNotEmpty(item.getNom()))
        vo.setNom(item.getNom());

        if(StringUtil.isNotEmpty(item.getPrenom()))
        vo.setPrenom(item.getPrenom());

        if(item.getAnneeNaissance()!=null)
        vo.setAnneeNaissance(NumberUtil.toString(item.getAnneeNaissance()));
    if(item.getSexe()!=null && this.sexe) {
        vo.setSexeVo(sexeConverter.toVo(item.getSexe())) ;
    }
    if(item.getPays()!=null && this.pays) {
        vo.setPaysVo(paysConverter.toVo(item.getPays())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    sexe = value;
    pays = value;
}


        public SexeConverter getSexeConverter(){
        return this.sexeConverter;
        }
        public void setSexeConverter(SexeConverter sexeConverter ){
        this.sexeConverter = sexeConverter;
        }
        public PaysConverter getPaysConverter(){
        return this.paysConverter;
        }
        public void setPaysConverter(PaysConverter paysConverter ){
        this.paysConverter = paysConverter;
        }

    public boolean  isSexe(){
    return this.sexe;
    }
    public void  setSexe(boolean sexe){
    this.sexe = sexe;
    }
    public boolean  isPays(){
    return this.pays;
    }
    public void  setPays(boolean pays){
    this.pays = pays;
    }












}
