package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.ws.rest.provided.vo.PaysVo;

@Component
public class PaysConverter extends AbstractConverter<Pays,PaysVo>{

        @Autowired
        private ContinentConverter continentConverter ;
    private Boolean continent;

public  PaysConverter(){
init(true);
}

@Override
public Pays toItem(PaysVo vo) {
if (vo == null) {
return null;
} else {
Pays item = new Pays();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
    if(vo.getContinentVo()!=null && this.continent)
        item.setContinent(continentConverter.toItem(vo.getContinentVo())) ;
    	/*TODO: added fields */
    	if(StringUtil.isNotEmpty(vo.getIdGraph()))
    	item.setIdGraph(vo.getIdGraph());
    	/*TODO:fin added fields */

return item;
}
}

@Override
public PaysVo toVo(Pays item) {
if (item == null) {
return null;
} else {
PaysVo vo = new PaysVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

    if(item.getContinent()!=null && this.continent) {
        vo.setContinentVo(continentConverter.toVo(item.getContinent())) ;
    }
    	/*TODO: added fields */
    	if(StringUtil.isNotEmpty(item.getIdGraph()))
        vo.setIdGraph(item.getIdGraph());
    	/*TODO: fin added fields */
return vo;
}
}

public void init(Boolean value) {
    continent = value;
}


        public ContinentConverter getContinentConverter(){
        return this.continentConverter;
        }
        public void setContinentConverter(ContinentConverter continentConverter ){
        this.continentConverter = continentConverter;
        }

    public boolean  isContinent(){
    return this.continent;
    }
    public void  setContinent(boolean continent){
    this.continent = continent;
    }








}
