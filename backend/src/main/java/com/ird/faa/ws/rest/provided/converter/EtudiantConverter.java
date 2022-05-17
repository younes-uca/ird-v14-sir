package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ird.faa.bean.formulaire.Etudiant;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.EtudiantVo;

@Component
public class EtudiantConverter extends AbstractConverter<Etudiant,EtudiantVo>{

        @Autowired
        private SexeConverter sexeConverter ;
        @Autowired
        private PaysConverter paysConverter ;
    private Boolean sexe;
    private Boolean pays;

public  EtudiantConverter(){
init(true);
}

@Override
public Etudiant toItem(EtudiantVo vo) {
if (vo == null) {
return null;
} else {
Etudiant item = new Etudiant();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getNom()))
        item.setNom(vo.getNom());
        if(StringUtil.isNotEmpty(vo.getPrenom()))
        item.setPrenom(vo.getPrenom());
			if (vo.getArchive() != null)
				item.setArchive(vo.getArchive());
			if (StringUtil.isNotEmpty(vo.getDateArchivage()))
				item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
    if(vo.getSexeVo()!=null && this.sexe)
        item.setSexe(sexeConverter.toItem(vo.getSexeVo())) ;
    if(vo.getPaysVo()!=null && this.pays)
        item.setPays(paysConverter.toItem(vo.getPaysVo())) ;


return item;
}
}

@Override
public EtudiantVo toVo(Etudiant item) {
if (item == null) {
return null;
} else {
EtudiantVo vo = new EtudiantVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getNom()))
        vo.setNom(item.getNom());

        if(StringUtil.isNotEmpty(item.getPrenom()))
        vo.setPrenom(item.getPrenom());

			if (item.getArchive() != null)
				vo.setArchive(item.getArchive());
			if (item.getDateArchivage() != null)
				vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
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
