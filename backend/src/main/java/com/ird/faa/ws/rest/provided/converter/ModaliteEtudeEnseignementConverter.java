package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.ModaliteEtudeEnseignement;
import com.ird.faa.ws.rest.provided.vo.ModaliteEtudeEnseignementVo;

@Component
public class ModaliteEtudeEnseignementConverter extends AbstractConverter<ModaliteEtudeEnseignement,ModaliteEtudeEnseignementVo>{

        @Autowired
        private EnseignementConverter enseignementConverter ;
        @Autowired
        private ModaliteEtudeConverter modaliteEtudeConverter ;
    private Boolean modaliteEtude;
    private Boolean enseignement;

public  ModaliteEtudeEnseignementConverter(){
init(true);
}

@Override
public ModaliteEtudeEnseignement toItem(ModaliteEtudeEnseignementVo vo) {
if (vo == null) {
return null;
} else {
ModaliteEtudeEnseignement item = new ModaliteEtudeEnseignement();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getModaliteEtudeVo()!=null && this.modaliteEtude)
        item.setModaliteEtude(modaliteEtudeConverter.toItem(vo.getModaliteEtudeVo())) ;
    if(vo.getEnseignementVo()!=null && this.enseignement)
        item.setEnseignement(enseignementConverter.toItem(vo.getEnseignementVo())) ;


return item;
}
}

@Override
public ModaliteEtudeEnseignementVo toVo(ModaliteEtudeEnseignement item) {
if (item == null) {
return null;
} else {
ModaliteEtudeEnseignementVo vo = new ModaliteEtudeEnseignementVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getModaliteEtude()!=null && this.modaliteEtude) {
        vo.setModaliteEtudeVo(modaliteEtudeConverter.toVo(item.getModaliteEtude())) ;
    }
    if(item.getEnseignement()!=null && this.enseignement) {
        vo.setEnseignementVo(enseignementConverter.toVo(item.getEnseignement())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    modaliteEtude = value;
    enseignement = value;
}


        public EnseignementConverter getEnseignementConverter(){
        return this.enseignementConverter;
        }
        public void setEnseignementConverter(EnseignementConverter enseignementConverter ){
        this.enseignementConverter = enseignementConverter;
        }
        public ModaliteEtudeConverter getModaliteEtudeConverter(){
        return this.modaliteEtudeConverter;
        }
        public void setModaliteEtudeConverter(ModaliteEtudeConverter modaliteEtudeConverter ){
        this.modaliteEtudeConverter = modaliteEtudeConverter;
        }

    public boolean  isModaliteEtude(){
    return this.modaliteEtude;
    }
    public void  setModaliteEtude(boolean modaliteEtude){
    this.modaliteEtude = modaliteEtude;
    }
    public boolean  isEnseignement(){
    return this.enseignement;
    }
    public void  setEnseignement(boolean enseignement){
    this.enseignement = enseignement;
    }






}
