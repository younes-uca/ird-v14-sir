package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.PaysEncadrementEtudiant;
import com.ird.faa.ws.rest.provided.vo.PaysEncadrementEtudiantVo;

@Component
public class PaysEncadrementEtudiantConverter extends AbstractConverter<PaysEncadrementEtudiant,PaysEncadrementEtudiantVo>{

        @Autowired
        private PaysConverter paysConverter ;
        @Autowired
        private EncadrementEtudiantConverter encadrementEtudiantConverter ;
    private Boolean pays;
    private Boolean encadrementEtudiant;

public  PaysEncadrementEtudiantConverter(){
init(true);
}

@Override
public PaysEncadrementEtudiant toItem(PaysEncadrementEtudiantVo vo) {
if (vo == null) {
return null;
} else {
PaysEncadrementEtudiant item = new PaysEncadrementEtudiant();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getPaysVo()!=null && this.pays)
        item.setPays(paysConverter.toItem(vo.getPaysVo())) ;
    if(vo.getEncadrementEtudiantVo()!=null && this.encadrementEtudiant)
        item.setEncadrementEtudiant(encadrementEtudiantConverter.toItem(vo.getEncadrementEtudiantVo())) ;


return item;
}
}

@Override
public PaysEncadrementEtudiantVo toVo(PaysEncadrementEtudiant item) {
if (item == null) {
return null;
} else {
PaysEncadrementEtudiantVo vo = new PaysEncadrementEtudiantVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

    if(item.getPays()!=null && this.pays) {
        vo.setPaysVo(paysConverter.toVo(item.getPays())) ;
    }
    if(item.getEncadrementEtudiant()!=null && this.encadrementEtudiant) {
        vo.setEncadrementEtudiantVo(encadrementEtudiantConverter.toVo(item.getEncadrementEtudiant())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    pays = value;
    encadrementEtudiant = value;
}


        public PaysConverter getPaysConverter(){
        return this.paysConverter;
        }
        public void setPaysConverter(PaysConverter paysConverter ){
        this.paysConverter = paysConverter;
        }
        public EncadrementEtudiantConverter getEncadrementEtudiantConverter(){
        return this.encadrementEtudiantConverter;
        }
        public void setEncadrementEtudiantConverter(EncadrementEtudiantConverter encadrementEtudiantConverter ){
        this.encadrementEtudiantConverter = encadrementEtudiantConverter;
        }

    public boolean  isPays(){
    return this.pays;
    }
    public void  setPays(boolean pays){
    this.pays = pays;
    }
    public boolean  isEncadrementEtudiant(){
    return this.encadrementEtudiant;
    }
    public void  setEncadrementEtudiant(boolean encadrementEtudiant){
    this.encadrementEtudiant = encadrementEtudiant;
    }






}
