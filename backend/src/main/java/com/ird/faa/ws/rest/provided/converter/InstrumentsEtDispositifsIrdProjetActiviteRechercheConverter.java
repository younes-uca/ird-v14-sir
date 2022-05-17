package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.InstrumentsEtDispositifsIrdProjetActiviteRecherche;
import com.ird.faa.ws.rest.provided.vo.InstrumentsEtDispositifsIrdProjetActiviteRechercheVo;

@Component
public class InstrumentsEtDispositifsIrdProjetActiviteRechercheConverter extends AbstractConverter<InstrumentsEtDispositifsIrdProjetActiviteRecherche,InstrumentsEtDispositifsIrdProjetActiviteRechercheVo>{

        @Autowired
        private ProjetActiviteRechercheConverter projetActiviteRechercheConverter ;
        @Autowired
        private InstrumentsEtDispositifsIrdConverter instrumentsEtDispositifsIrdConverter ;
    private Boolean projetActiviteRecherche;
    private Boolean instrumentsEtDispositifsIrd;

public  InstrumentsEtDispositifsIrdProjetActiviteRechercheConverter(){
init(true);
}

@Override
public InstrumentsEtDispositifsIrdProjetActiviteRecherche toItem(InstrumentsEtDispositifsIrdProjetActiviteRechercheVo vo) {
if (vo == null) {
return null;
} else {
InstrumentsEtDispositifsIrdProjetActiviteRecherche item = new InstrumentsEtDispositifsIrdProjetActiviteRecherche();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getProjetActiviteRechercheVo()!=null && this.projetActiviteRecherche)
        item.setProjetActiviteRecherche(projetActiviteRechercheConverter.toItem(vo.getProjetActiviteRechercheVo())) ;
    if(vo.getInstrumentsEtDispositifsIrdVo()!=null && this.instrumentsEtDispositifsIrd)
        item.setInstrumentsEtDispositifsIrd(instrumentsEtDispositifsIrdConverter.toItem(vo.getInstrumentsEtDispositifsIrdVo())) ;


return item;
}
}

@Override
public InstrumentsEtDispositifsIrdProjetActiviteRechercheVo toVo(InstrumentsEtDispositifsIrdProjetActiviteRecherche item) {
if (item == null) {
return null;
} else {
InstrumentsEtDispositifsIrdProjetActiviteRechercheVo vo = new InstrumentsEtDispositifsIrdProjetActiviteRechercheVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getProjetActiviteRecherche()!=null && this.projetActiviteRecherche) {
        vo.setProjetActiviteRechercheVo(projetActiviteRechercheConverter.toVo(item.getProjetActiviteRecherche())) ;
    }
    if(item.getInstrumentsEtDispositifsIrd()!=null && this.instrumentsEtDispositifsIrd) {
        vo.setInstrumentsEtDispositifsIrdVo(instrumentsEtDispositifsIrdConverter.toVo(item.getInstrumentsEtDispositifsIrd())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    projetActiviteRecherche = value;
    instrumentsEtDispositifsIrd = value;
}


        public ProjetActiviteRechercheConverter getProjetActiviteRechercheConverter(){
        return this.projetActiviteRechercheConverter;
        }
        public void setProjetActiviteRechercheConverter(ProjetActiviteRechercheConverter projetActiviteRechercheConverter ){
        this.projetActiviteRechercheConverter = projetActiviteRechercheConverter;
        }
        public InstrumentsEtDispositifsIrdConverter getInstrumentsEtDispositifsIrdConverter(){
        return this.instrumentsEtDispositifsIrdConverter;
        }
        public void setInstrumentsEtDispositifsIrdConverter(InstrumentsEtDispositifsIrdConverter instrumentsEtDispositifsIrdConverter ){
        this.instrumentsEtDispositifsIrdConverter = instrumentsEtDispositifsIrdConverter;
        }

    public boolean  isProjetActiviteRecherche(){
    return this.projetActiviteRecherche;
    }
    public void  setProjetActiviteRecherche(boolean projetActiviteRecherche){
    this.projetActiviteRecherche = projetActiviteRecherche;
    }
    public boolean  isInstrumentsEtDispositifsIrd(){
    return this.instrumentsEtDispositifsIrd;
    }
    public void  setInstrumentsEtDispositifsIrd(boolean instrumentsEtDispositifsIrd){
    this.instrumentsEtDispositifsIrd = instrumentsEtDispositifsIrd;
    }






}
