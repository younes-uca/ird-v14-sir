package com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueErcParent;
import com.ird.faa.service.chercheur.facade.formulaire.DisciplineScientifiqueErcParentChercheurService;
import com.ird.faa.ws.rest.provided.converter.DisciplineScientifiqueErcParentConverter;
import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueErcParentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages disciplineScientifiqueErcParent services")
@RestController
@RequestMapping("api/chercheur/disciplineScientifiqueErcParent")
public class DisciplineScientifiqueErcParentRestChercheur {

@Autowired
private DisciplineScientifiqueErcParentChercheurService disciplineScientifiqueErcParentService;

@Autowired
private DisciplineScientifiqueErcParentConverter disciplineScientifiqueErcParentConverter;


            @ApiOperation("Updates the specified  disciplineScientifiqueErcParent")
            @PutMapping("/")
            public  DisciplineScientifiqueErcParentVo update(@RequestBody  DisciplineScientifiqueErcParentVo  disciplineScientifiqueErcParentVo){
            DisciplineScientifiqueErcParent disciplineScientifiqueErcParent = disciplineScientifiqueErcParentConverter.toItem(disciplineScientifiqueErcParentVo);
            disciplineScientifiqueErcParent = disciplineScientifiqueErcParentService.update(disciplineScientifiqueErcParent);
            return disciplineScientifiqueErcParentConverter.toVo(disciplineScientifiqueErcParent);
            }

    @ApiOperation("Finds a list of all disciplineScientifiqueErcParents")
    @GetMapping("/")
    public List<DisciplineScientifiqueErcParentVo> findAll(){
        return disciplineScientifiqueErcParentConverter.toVo(disciplineScientifiqueErcParentService.findAll());
    }

    @ApiOperation("Finds a disciplineScientifiqueErcParent with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DisciplineScientifiqueErcParentVo findByIdWithAssociatedList(@PathVariable Long id){
    return disciplineScientifiqueErcParentConverter.toVo(disciplineScientifiqueErcParentService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search disciplineScientifiqueErcParent by a specific criteria")
    @PostMapping("/search")
    public List<DisciplineScientifiqueErcParentVo> findByCriteria(@RequestBody DisciplineScientifiqueErcParentVo disciplineScientifiqueErcParentVo){
        return disciplineScientifiqueErcParentConverter.toVo(disciplineScientifiqueErcParentService.findByCriteria(disciplineScientifiqueErcParentVo));
        }

            @ApiOperation("Finds a disciplineScientifiqueErcParent by id")
            @GetMapping("/id/{id}")
            public DisciplineScientifiqueErcParentVo findById(@PathVariable Long id){
            return disciplineScientifiqueErcParentConverter.toVo(disciplineScientifiqueErcParentService.findById(id));
            }

            @ApiOperation("Saves the specified  disciplineScientifiqueErcParent")
            @PostMapping("/")
            public DisciplineScientifiqueErcParentVo save(@RequestBody DisciplineScientifiqueErcParentVo disciplineScientifiqueErcParentVo){
            DisciplineScientifiqueErcParent disciplineScientifiqueErcParent = disciplineScientifiqueErcParentConverter.toItem(disciplineScientifiqueErcParentVo);
            disciplineScientifiqueErcParent = disciplineScientifiqueErcParentService.save(disciplineScientifiqueErcParent);
            return disciplineScientifiqueErcParentConverter.toVo(disciplineScientifiqueErcParent);
            }

            @ApiOperation("Delete the specified disciplineScientifiqueErcParent")
            @DeleteMapping("/")
            public int delete(@RequestBody DisciplineScientifiqueErcParentVo disciplineScientifiqueErcParentVo){
            DisciplineScientifiqueErcParent disciplineScientifiqueErcParent = disciplineScientifiqueErcParentConverter.toItem(disciplineScientifiqueErcParentVo);
            return disciplineScientifiqueErcParentService.delete(disciplineScientifiqueErcParent);
            }

            @ApiOperation("Deletes a disciplineScientifiqueErcParent by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return disciplineScientifiqueErcParentService.deleteById(id);
            }




            }
