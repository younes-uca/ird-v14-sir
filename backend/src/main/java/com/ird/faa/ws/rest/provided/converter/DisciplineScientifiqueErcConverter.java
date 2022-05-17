package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueErc;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueErcVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DisciplineScientifiqueErcConverter extends AbstractConverter<DisciplineScientifiqueErc,DisciplineScientifiqueErcVo>{

        @Autowired
        private KeyWordDisciplineScientifiqueErcConverter keyWordDisciplineScientifiqueErcConverter ;
        @Autowired
        private DisciplineScientifiqueErcParentConverter disciplineScientifiqueErcParentConverter ;
    private Boolean disciplineScientifiqueErcParent;
        private Boolean keyWordDisciplineScientifiqueErcs;

public  DisciplineScientifiqueErcConverter(){
init(true);
}

@Override
public DisciplineScientifiqueErc toItem(DisciplineScientifiqueErcVo vo) {
if (vo == null) {
return null;
} else {
DisciplineScientifiqueErc item = new DisciplineScientifiqueErc();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelleFr()))
        item.setLibelleFr(vo.getLibelleFr());
        if(StringUtil.isNotEmpty(vo.getLibelleEng()))
        item.setLibelleEng(vo.getLibelleEng());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getNiveau()))
        item.setNiveau(NumberUtil.toLong(vo.getNiveau()));
            if(vo.getArchive() != null)
            item.setArchive(vo.getArchive());
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
        if(StringUtil.isNotEmpty(vo.getDateCreation()))
        item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
    if(vo.getDisciplineScientifiqueErcParentVo()!=null && this.disciplineScientifiqueErcParent)
        item.setDisciplineScientifiqueErcParent(disciplineScientifiqueErcParentConverter.toItem(vo.getDisciplineScientifiqueErcParentVo())) ;

    if(ListUtil.isNotEmpty(vo.getKeyWordDisciplineScientifiqueErcsVo()) && this.keyWordDisciplineScientifiqueErcs)
        item.setKeyWordDisciplineScientifiqueErcs(keyWordDisciplineScientifiqueErcConverter.toItem(vo.getKeyWordDisciplineScientifiqueErcsVo()));

return item;
}
}

@Override
public DisciplineScientifiqueErcVo toVo(DisciplineScientifiqueErc item) {
if (item == null) {
return null;
} else {
DisciplineScientifiqueErcVo vo = new DisciplineScientifiqueErcVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelleFr()))
        vo.setLibelleFr(item.getLibelleFr());

        if(StringUtil.isNotEmpty(item.getLibelleEng()))
        vo.setLibelleEng(item.getLibelleEng());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(item.getNiveau()!=null)
        vo.setNiveau(NumberUtil.toString(item.getNiveau()));

        if(item.getArchive()!=null)
        vo.setArchive(item.getArchive());
        if(item.getDateArchivage()!=null)
        vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
        if(item.getDateCreation()!=null)
        vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
    if(item.getDisciplineScientifiqueErcParent()!=null && this.disciplineScientifiqueErcParent) {
        vo.setDisciplineScientifiqueErcParentVo(disciplineScientifiqueErcParentConverter.toVo(item.getDisciplineScientifiqueErcParent())) ;
    }
        if(ListUtil.isNotEmpty(item.getKeyWordDisciplineScientifiqueErcs()) && this.keyWordDisciplineScientifiqueErcs){
        keyWordDisciplineScientifiqueErcConverter.init(true);
        keyWordDisciplineScientifiqueErcConverter.setDisciplineScientifiqueErc(false);
        vo.setKeyWordDisciplineScientifiqueErcsVo(keyWordDisciplineScientifiqueErcConverter.toVo(item.getKeyWordDisciplineScientifiqueErcs()));
        keyWordDisciplineScientifiqueErcConverter.setDisciplineScientifiqueErc(true);
        }

return vo;
}
}

public void init(Boolean value) {
    disciplineScientifiqueErcParent = value;
        keyWordDisciplineScientifiqueErcs = value;
}


        public KeyWordDisciplineScientifiqueErcConverter getKeyWordDisciplineScientifiqueErcConverter(){
        return this.keyWordDisciplineScientifiqueErcConverter;
        }
        public void setKeyWordDisciplineScientifiqueErcConverter(KeyWordDisciplineScientifiqueErcConverter keyWordDisciplineScientifiqueErcConverter ){
        this.keyWordDisciplineScientifiqueErcConverter = keyWordDisciplineScientifiqueErcConverter;
        }
        public DisciplineScientifiqueErcParentConverter getDisciplineScientifiqueErcParentConverter(){
        return this.disciplineScientifiqueErcParentConverter;
        }
        public void setDisciplineScientifiqueErcParentConverter(DisciplineScientifiqueErcParentConverter disciplineScientifiqueErcParentConverter ){
        this.disciplineScientifiqueErcParentConverter = disciplineScientifiqueErcParentConverter;
        }

    public boolean  isDisciplineScientifiqueErcParent(){
    return this.disciplineScientifiqueErcParent;
    }
    public void  setDisciplineScientifiqueErcParent(boolean disciplineScientifiqueErcParent){
    this.disciplineScientifiqueErcParent = disciplineScientifiqueErcParent;
    }













        public Boolean  isKeyWordDisciplineScientifiqueErcs(){
        return this.keyWordDisciplineScientifiqueErcs ;
        }
        public void  setKeyWordDisciplineScientifiqueErcs(Boolean keyWordDisciplineScientifiqueErcs ){
        this.keyWordDisciplineScientifiqueErcs  = keyWordDisciplineScientifiqueErcs ;
        }








}
