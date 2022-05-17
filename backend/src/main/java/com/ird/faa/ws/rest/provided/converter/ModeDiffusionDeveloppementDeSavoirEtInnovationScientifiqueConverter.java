package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique;
import com.ird.faa.ws.rest.provided.vo.ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo;

@Component
public class ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueConverter extends AbstractConverter<ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique,ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo>{

        @Autowired
        private ModeDiffusionConverter modeDiffusionConverter ;
        @Autowired
        private DeveloppementDeSavoirEtInnovationScientifiqueConverter developpementDeSavoirEtInnovationScientifiqueConverter ;
    private Boolean modeDiffusion;
    private Boolean developpementDeSavoirEtInnovationScientifique;

public  ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueConverter(){
init(true);
}

@Override
public ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique toItem(ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo vo) {
if (vo == null) {
return null;
} else {
ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique item = new ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getModeDiffusionVo()!=null && this.modeDiffusion)
        item.setModeDiffusion(modeDiffusionConverter.toItem(vo.getModeDiffusionVo())) ;
    if(vo.getDeveloppementDeSavoirEtInnovationScientifiqueVo()!=null && this.developpementDeSavoirEtInnovationScientifique)
        item.setDeveloppementDeSavoirEtInnovationScientifique(developpementDeSavoirEtInnovationScientifiqueConverter.toItem(vo.getDeveloppementDeSavoirEtInnovationScientifiqueVo())) ;


return item;
}
}

@Override
public ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo toVo(ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique item) {
if (item == null) {
return null;
} else {
ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo vo = new ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
    if(item.getModeDiffusion()!=null && this.modeDiffusion) {
        vo.setModeDiffusionVo(modeDiffusionConverter.toVo(item.getModeDiffusion())) ;
    }
    if(item.getDeveloppementDeSavoirEtInnovationScientifique()!=null && this.developpementDeSavoirEtInnovationScientifique) {
        vo.setDeveloppementDeSavoirEtInnovationScientifiqueVo(developpementDeSavoirEtInnovationScientifiqueConverter.toVo(item.getDeveloppementDeSavoirEtInnovationScientifique())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    modeDiffusion = value;
    developpementDeSavoirEtInnovationScientifique = value;
}


        public ModeDiffusionConverter getModeDiffusionConverter(){
        return this.modeDiffusionConverter;
        }
        public void setModeDiffusionConverter(ModeDiffusionConverter modeDiffusionConverter ){
        this.modeDiffusionConverter = modeDiffusionConverter;
        }
        public DeveloppementDeSavoirEtInnovationScientifiqueConverter getDeveloppementDeSavoirEtInnovationScientifiqueConverter(){
        return this.developpementDeSavoirEtInnovationScientifiqueConverter;
        }
        public void setDeveloppementDeSavoirEtInnovationScientifiqueConverter(DeveloppementDeSavoirEtInnovationScientifiqueConverter developpementDeSavoirEtInnovationScientifiqueConverter ){
        this.developpementDeSavoirEtInnovationScientifiqueConverter = developpementDeSavoirEtInnovationScientifiqueConverter;
        }

    public boolean  isModeDiffusion(){
    return this.modeDiffusion;
    }
    public void  setModeDiffusion(boolean modeDiffusion){
    this.modeDiffusion = modeDiffusion;
    }
    public boolean  isDeveloppementDeSavoirEtInnovationScientifique(){
    return this.developpementDeSavoirEtInnovationScientifique;
    }
    public void  setDeveloppementDeSavoirEtInnovationScientifique(boolean developpementDeSavoirEtInnovationScientifique){
    this.developpementDeSavoirEtInnovationScientifique = developpementDeSavoirEtInnovationScientifique;
    }






}
