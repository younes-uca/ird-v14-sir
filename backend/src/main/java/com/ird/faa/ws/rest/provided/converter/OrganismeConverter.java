package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.Organisme;
import com.ird.faa.ws.rest.provided.vo.OrganismeVo;

@Component
public class OrganismeConverter extends AbstractConverter<Organisme,OrganismeVo>{

	@Autowired
    private PaysConverter paysConverter ;
    private Boolean pays;

public  OrganismeConverter(){
init(true);
}

@Override
public Organisme toItem(OrganismeVo vo) {
if (vo == null) {
return null;
} else {
Organisme item = new Organisme();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getIntitule()))
        item.setIntitule(vo.getIntitule());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
        if(vo.getPaysVo()!=null && this.pays)
         item.setPays(paysConverter.toItem(vo.getPaysVo())) ;

return item;
}
}

@Override
public OrganismeVo toVo(Organisme item) {
if (item == null) {
return null;
} else {
OrganismeVo vo = new OrganismeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getIntitule()))
        vo.setIntitule(item.getIntitule());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());
        
        if(item.getPays()!=null && this.pays) {
            vo.setPaysVo(paysConverter.toVo(item.getPays())) ;
        }


return vo;
}
}

public void init(Boolean value) {
	pays=value;
}











}
