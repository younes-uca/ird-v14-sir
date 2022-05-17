package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.InstrumentsEtDispositifsIrdChercheur;
import com.ird.faa.ws.rest.provided.vo.InstrumentsEtDispositifsIrdChercheurVo;

@Component
public class InstrumentsEtDispositifsIrdChercheurConverter extends AbstractConverter<InstrumentsEtDispositifsIrdChercheur,InstrumentsEtDispositifsIrdChercheurVo>{

        @Autowired
        private TypeInstrumentsEtDispositifsIrdConverter typeInstrumentsEtDispositifsIrdConverter ;
        @Autowired
        private ChercheurConverter chercheurConverter ;
    private Boolean typeInstrumentsEtDispositifsIrd;
    private Boolean chercheur;

public  InstrumentsEtDispositifsIrdChercheurConverter(){
init(true);
}

@Override
public InstrumentsEtDispositifsIrdChercheur toItem(InstrumentsEtDispositifsIrdChercheurVo vo) {
if (vo == null) {
return null;
} else {
InstrumentsEtDispositifsIrdChercheur item = new InstrumentsEtDispositifsIrdChercheur();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getTypeInstrumentsEtDispositifsIrdVo()!=null && this.typeInstrumentsEtDispositifsIrd)
        item.setTypeInstrumentsEtDispositifsIrd(typeInstrumentsEtDispositifsIrdConverter.toItem(vo.getTypeInstrumentsEtDispositifsIrdVo())) ;
    if(vo.getChercheurVo()!=null && this.chercheur)
        item.setChercheur(chercheurConverter.toItem(vo.getChercheurVo())) ;


return item;
}
}

@Override
public InstrumentsEtDispositifsIrdChercheurVo toVo(InstrumentsEtDispositifsIrdChercheur item) {
if (item == null) {
return null;
} else {
InstrumentsEtDispositifsIrdChercheurVo vo = new InstrumentsEtDispositifsIrdChercheurVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getTypeInstrumentsEtDispositifsIrd()!=null && this.typeInstrumentsEtDispositifsIrd) {
        vo.setTypeInstrumentsEtDispositifsIrdVo(typeInstrumentsEtDispositifsIrdConverter.toVo(item.getTypeInstrumentsEtDispositifsIrd())) ;
    }
    if(item.getChercheur()!=null && this.chercheur) {
        vo.setChercheurVo(chercheurConverter.toVo(item.getChercheur())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    typeInstrumentsEtDispositifsIrd = value;
    chercheur = value;
}


        public TypeInstrumentsEtDispositifsIrdConverter getTypeInstrumentsEtDispositifsIrdConverter(){
        return this.typeInstrumentsEtDispositifsIrdConverter;
        }
        public void setTypeInstrumentsEtDispositifsIrdConverter(TypeInstrumentsEtDispositifsIrdConverter typeInstrumentsEtDispositifsIrdConverter ){
        this.typeInstrumentsEtDispositifsIrdConverter = typeInstrumentsEtDispositifsIrdConverter;
        }
        public ChercheurConverter getChercheurConverter(){
        return this.chercheurConverter;
        }
        public void setChercheurConverter(ChercheurConverter chercheurConverter ){
        this.chercheurConverter = chercheurConverter;
        }

    public boolean  isTypeInstrumentsEtDispositifsIrd(){
    return this.typeInstrumentsEtDispositifsIrd;
    }
    public void  setTypeInstrumentsEtDispositifsIrd(boolean typeInstrumentsEtDispositifsIrd){
    this.typeInstrumentsEtDispositifsIrd = typeInstrumentsEtDispositifsIrd;
    }
    public boolean  isChercheur(){
    return this.chercheur;
    }
    public void  setChercheur(boolean chercheur){
    this.chercheur = chercheur;
    }






}
