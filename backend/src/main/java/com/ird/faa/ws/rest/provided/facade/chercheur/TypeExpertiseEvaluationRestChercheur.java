package com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.bean.formulaire.TypeExpertiseEvaluation;
import com.ird.faa.service.chercheur.facade.formulaire.TypeExpertiseEvaluationChercheurService;
import com.ird.faa.ws.rest.provided.converter.TypeExpertiseEvaluationConverter;
import com.ird.faa.ws.rest.provided.vo.TypeExpertiseEvaluationVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages typeExpertiseEvaluation services")
@RestController
@RequestMapping("api/chercheur/typeExpertiseEvaluation")
public class TypeExpertiseEvaluationRestChercheur {

@Autowired
private TypeExpertiseEvaluationChercheurService typeExpertiseEvaluationService;

@Autowired
private TypeExpertiseEvaluationConverter typeExpertiseEvaluationConverter;


            @ApiOperation("Updates the specified  typeExpertiseEvaluation")
            @PutMapping("/")
            public  TypeExpertiseEvaluationVo update(@RequestBody  TypeExpertiseEvaluationVo  typeExpertiseEvaluationVo){
            TypeExpertiseEvaluation typeExpertiseEvaluation = typeExpertiseEvaluationConverter.toItem(typeExpertiseEvaluationVo);
            typeExpertiseEvaluation = typeExpertiseEvaluationService.update(typeExpertiseEvaluation);
            return typeExpertiseEvaluationConverter.toVo(typeExpertiseEvaluation);
            }

    @ApiOperation("Finds a list of all typeExpertiseEvaluations")
    @GetMapping("/")
    public List<TypeExpertiseEvaluationVo> findAll(){
        return typeExpertiseEvaluationConverter.toVo(typeExpertiseEvaluationService.findAll());
    }

    @ApiOperation("Finds a typeExpertiseEvaluation with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeExpertiseEvaluationVo findByIdWithAssociatedList(@PathVariable Long id){
    return typeExpertiseEvaluationConverter.toVo(typeExpertiseEvaluationService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeExpertiseEvaluation by a specific criteria")
    @PostMapping("/search")
    public List<TypeExpertiseEvaluationVo> findByCriteria(@RequestBody TypeExpertiseEvaluationVo typeExpertiseEvaluationVo){
        return typeExpertiseEvaluationConverter.toVo(typeExpertiseEvaluationService.findByCriteria(typeExpertiseEvaluationVo));
        }

            @ApiOperation("Finds a typeExpertiseEvaluation by id")
            @GetMapping("/id/{id}")
            public TypeExpertiseEvaluationVo findById(@PathVariable Long id){
            return typeExpertiseEvaluationConverter.toVo(typeExpertiseEvaluationService.findById(id));
            }

            @ApiOperation("Saves the specified  typeExpertiseEvaluation")
            @PostMapping("/")
            public TypeExpertiseEvaluationVo save(@RequestBody TypeExpertiseEvaluationVo typeExpertiseEvaluationVo){
            TypeExpertiseEvaluation typeExpertiseEvaluation = typeExpertiseEvaluationConverter.toItem(typeExpertiseEvaluationVo);
            typeExpertiseEvaluation = typeExpertiseEvaluationService.save(typeExpertiseEvaluation);
            return typeExpertiseEvaluationConverter.toVo(typeExpertiseEvaluation);
            }

            @ApiOperation("Delete the specified typeExpertiseEvaluation")
            @DeleteMapping("/")
            public int delete(@RequestBody TypeExpertiseEvaluationVo typeExpertiseEvaluationVo){
            TypeExpertiseEvaluation typeExpertiseEvaluation = typeExpertiseEvaluationConverter.toItem(typeExpertiseEvaluationVo);
            return typeExpertiseEvaluationService.delete(typeExpertiseEvaluation);
            }

            @ApiOperation("Deletes a typeExpertiseEvaluation by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typeExpertiseEvaluationService.deleteById(id);
            }




            }
