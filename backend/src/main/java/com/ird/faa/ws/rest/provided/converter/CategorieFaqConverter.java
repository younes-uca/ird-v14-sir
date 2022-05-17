package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.formulaire.CategorieFaq;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.CategorieFaqVo;
import org.springframework.stereotype.Component;

@Component
public class CategorieFaqConverter extends AbstractConverter<CategorieFaq, CategorieFaqVo> {


    public CategorieFaqConverter() {
        init(true);
    }

    @Override
    public CategorieFaq toItem(CategorieFaqVo vo) {
        if (vo == null) {
            return null;
        } else {
            CategorieFaq item = new CategorieFaq();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getLibelle()))
                item.setLibelle(vo.getLibelle());
            if (StringUtil.isNotEmpty(vo.getOrdre()))
                item.setOrdre(NumberUtil.toInt(vo.getOrdre()));
            if (vo.getArchive()!=null)
                item.setArchive(vo.getArchive());


            return item;
        }
    }

    @Override
    public CategorieFaqVo toVo(CategorieFaq item) {
        if (item == null) {
            return null;
        } else {
            CategorieFaqVo vo = new CategorieFaqVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));
            if (StringUtil.isNotEmpty(item.getLibelle()))
                vo.setLibelle(item.getLibelle());

            if (item.getOrdre() != null)
                vo.setOrdre(NumberUtil.toString(item.getOrdre()));
            if (item.getArchive() != null)
                vo.setArchive(item.getArchive());

            if (ListUtil.isNotEmpty(item.getFaqs())) {
                vo.setFaqs(item.getFaqs());
            }


            return vo;
        }
    }

    public void init(Boolean value) {
    }


}
