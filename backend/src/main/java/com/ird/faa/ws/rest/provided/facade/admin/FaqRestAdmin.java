package com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.bean.formulaire.CategorieFaq;
import com.ird.faa.bean.formulaire.Faq;
import com.ird.faa.service.admin.facade.formulaire.FaqAdminService;
import com.ird.faa.ws.rest.provided.converter.CategorieFaqConverter;
import com.ird.faa.ws.rest.provided.converter.FaqConverter;
import com.ird.faa.ws.rest.provided.vo.FaqVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api("Manages faq services")
@RestController
@RequestMapping("api/admin/faq")
public class FaqRestAdmin {

    @Autowired
    private FaqAdminService faqService;

    @Autowired
    private FaqConverter faqConverter;

    @Autowired
    private CategorieFaqConverter categorieFaqConverter;

    @ApiOperation("Find faqs by categorie order by ordre")
    @PostMapping("/category")
    public List<FaqVo> findByCategorieOrderByOrdre(@RequestBody FaqVo faqVo) {
        CategorieFaq categorieFaq = categorieFaqConverter.toItem(faqVo.getCategorieFaqVo());
        return faqConverter.toVo(faqService.findByCategorieOrderByOrdre(categorieFaq));
    }
    
    @ApiOperation("Finds by ordre and categorie")
    @GetMapping("/category-and-ordre/{ordre}/{catId}")
    FaqVo findByOrdreAndCategorieFaqId(@PathVariable Integer ordre,@PathVariable Long catId) {
    	return faqConverter.toVo(faqService.findByOrdreAndCategorieFaqId(ordre,catId));
    }

    @ApiOperation("Updates list Of Faqs")
    @PutMapping("/update/list")
    public List<FaqVo> update(@RequestBody List<FaqVo> faqsVo) {
        List<Faq> listFaqs = new ArrayList<>();
        faqsVo.forEach(faqVo -> {
            Faq faq = faqConverter.toItem(faqVo);
            listFaqs.add(faq);
        });
        faqService.update(listFaqs);
        return faqsVo;
    }

    @ApiOperation("Updates the specified  faq")
    @PutMapping("/")
    public FaqVo update(@RequestBody FaqVo faqVo) {
        Faq faq = faqConverter.toItem(faqVo);
        faq = faqService.update(faq);
        return faqConverter.toVo(faq);
    }

    @ApiOperation("Finds a list of all faqs")
    @GetMapping("/")
    public List<FaqVo> findAll() {
        return faqConverter.toVo(faqService.findAll());
    }

    @ApiOperation("Finds a faq with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public FaqVo findByIdWithAssociatedList(@PathVariable Long id) {
        return faqConverter.toVo(faqService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search faq by a specific criteria")
    @PostMapping("/search")
    public List<FaqVo> findByCriteria(@RequestBody FaqVo faqVo) {
        return faqConverter.toVo(faqService.findByCriteria(faqVo));
    }

    @ApiOperation("Finds a faq by id")
    @GetMapping("/id/{id}")
    public FaqVo findById(@PathVariable Long id) {
        return faqConverter.toVo(faqService.findById(id));
    }

    @ApiOperation("Saves the specified  faq")
    @PostMapping("/")
    public FaqVo save(@RequestBody FaqVo faqVo) {
        Faq faq = faqConverter.toItem(faqVo);
        faq = faqService.save(faq);
        return faqConverter.toVo(faq);
    }

    @ApiOperation("Delete the specified faq")
    @DeleteMapping("/")
    public int delete(@RequestBody FaqVo faqVo) {
        Faq faq = faqConverter.toItem(faqVo);
        return faqService.delete(faq);
    }

    @ApiOperation("Deletes a faq by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return faqService.deleteById(id);
    }


}
