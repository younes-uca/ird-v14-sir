package com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.bean.formulaire.CategorieFaq;
import com.ird.faa.service.admin.facade.formulaire.CategorieFaqAdminService;
import com.ird.faa.ws.rest.provided.converter.CategorieFaqConverter;
import com.ird.faa.ws.rest.provided.vo.CategorieFaqVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages categorieFaq services")
@RestController
@RequestMapping("api/admin/categorieFaq")
public class CategorieFaqRestAdmin {

    @Autowired
    private CategorieFaqAdminService categorieFaqService;

    @Autowired
    private CategorieFaqConverter categorieFaqConverter;

    @ApiOperation("Finds a list of all categorieFaqs order by ordre")
    @GetMapping("/all")
    public List<CategorieFaqVo> findAllOrderByOrdre() {
        return categorieFaqConverter.toVo(categorieFaqService.findAllWithFaq());
    }

    @ApiOperation("Updates the specified  categorieFaq")
    @PutMapping("/")
    public CategorieFaqVo update(@RequestBody CategorieFaqVo categorieFaqVo) {
        CategorieFaq categorieFaq = categorieFaqConverter.toItem(categorieFaqVo);
        categorieFaq = categorieFaqService.update(categorieFaq);
        return categorieFaqConverter.toVo(categorieFaq);
    }

    @ApiOperation("Finds a list of all categorieFaqs")
    @GetMapping("/")
    public List<CategorieFaqVo> findAll() {
        return categorieFaqConverter.toVo(categorieFaqService.findAll());
    }

    @ApiOperation("Finds a categorieFaq with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CategorieFaqVo findByIdWithAssociatedList(@PathVariable Long id) {
        return categorieFaqConverter.toVo(categorieFaqService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search categorieFaq by a specific criteria")
    @PostMapping("/search")
    public List<CategorieFaqVo> findByCriteria(@RequestBody CategorieFaqVo categorieFaqVo) {
        return categorieFaqConverter.toVo(categorieFaqService.findByCriteria(categorieFaqVo));
    }

    @ApiOperation("Finds a categorieFaq by id")
    @GetMapping("/id/{id}")
    public CategorieFaqVo findById(@PathVariable Long id) {
        return categorieFaqConverter.toVo(categorieFaqService.findById(id));
    }
    @ApiOperation("Finds a categorieFaq by ordre")
    @GetMapping("/ordre/{ordre}")
    public CategorieFaqVo findByOrdre(@PathVariable Integer ordre) {
        return categorieFaqConverter.toVo(categorieFaqService.findByOrdre(ordre));
    }

    @ApiOperation("Saves the specified  categorieFaq")
    @PostMapping("/")
    public CategorieFaqVo save(@RequestBody CategorieFaqVo categorieFaqVo) {
        CategorieFaq categorieFaq = categorieFaqConverter.toItem(categorieFaqVo);
        categorieFaq = categorieFaqService.save(categorieFaq);
        return categorieFaqConverter.toVo(categorieFaq);
    }

    @ApiOperation("Delete the specified categorieFaq")
    @DeleteMapping("/")
    public int delete(@RequestBody CategorieFaqVo categorieFaqVo) {
        CategorieFaq categorieFaq = categorieFaqConverter.toItem(categorieFaqVo);
        return categorieFaqService.delete(categorieFaq);
    }

    @ApiOperation("Deletes a categorieFaq by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return categorieFaqService.deleteById(id);
    }


}
