package com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.bean.referentiel.RoleEvaluation;
import com.ird.faa.service.admin.facade.formulaire.RoleEvaluationAdminService;
import com.ird.faa.ws.rest.provided.converter.RoleEvaluationConverter;
import com.ird.faa.ws.rest.provided.vo.RoleEvaluationVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages roleEvaluation services")
@RestController
@RequestMapping("api/admin/roleEvaluation")
public class RoleEvaluationRestAdmin {

@Autowired
private RoleEvaluationAdminService roleEvaluationService;

@Autowired
private RoleEvaluationConverter roleEvaluationConverter;


            @ApiOperation("Updates the specified  roleEvaluation")
            @PutMapping("/")
            public  RoleEvaluationVo update(@RequestBody  RoleEvaluationVo  roleEvaluationVo){
            RoleEvaluation roleEvaluation = roleEvaluationConverter.toItem(roleEvaluationVo);
            roleEvaluation = roleEvaluationService.update(roleEvaluation);
            return roleEvaluationConverter.toVo(roleEvaluation);
            }

    @ApiOperation("Finds a list of all roleEvaluations")
    @GetMapping("/")
    public List<RoleEvaluationVo> findAll(){
        return roleEvaluationConverter.toVo(roleEvaluationService.findAll());
    }

    @ApiOperation("Finds a roleEvaluation with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public RoleEvaluationVo findByIdWithAssociatedList(@PathVariable Long id){
    return roleEvaluationConverter.toVo(roleEvaluationService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search roleEvaluation by a specific criteria")
    @PostMapping("/search")
    public List<RoleEvaluationVo> findByCriteria(@RequestBody RoleEvaluationVo roleEvaluationVo){
        return roleEvaluationConverter.toVo(roleEvaluationService.findByCriteria(roleEvaluationVo));
        }

            @ApiOperation("Finds a roleEvaluation by id")
            @GetMapping("/id/{id}")
            public RoleEvaluationVo findById(@PathVariable Long id){
            return roleEvaluationConverter.toVo(roleEvaluationService.findById(id));
            }

            @ApiOperation("Saves the specified  roleEvaluation")
            @PostMapping("/")
            public RoleEvaluationVo save(@RequestBody RoleEvaluationVo roleEvaluationVo){
            RoleEvaluation roleEvaluation = roleEvaluationConverter.toItem(roleEvaluationVo);
            roleEvaluation = roleEvaluationService.save(roleEvaluation);
            return roleEvaluationConverter.toVo(roleEvaluation);
            }

            @ApiOperation("Delete the specified roleEvaluation")
            @DeleteMapping("/")
            public int delete(@RequestBody RoleEvaluationVo roleEvaluationVo){
            RoleEvaluation roleEvaluation = roleEvaluationConverter.toItem(roleEvaluationVo);
            return roleEvaluationService.delete(roleEvaluation);
            }

            @ApiOperation("Deletes a roleEvaluation by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return roleEvaluationService.deleteById(id);
            }




            @PutMapping("/archiver/")
            public RoleEvaluationVo archiver(@RequestBody RoleEvaluationVo roleEvaluationVo){
                RoleEvaluation roleEvaluation = roleEvaluationService.archiver(roleEvaluationConverter.toItem(roleEvaluationVo));
                return roleEvaluationConverter.toVo(roleEvaluation);
                }

            @PutMapping("/desarchiver/")
            public RoleEvaluationVo desarchiver(@RequestBody RoleEvaluationVo roleEvaluationVo){
                RoleEvaluation roleEvaluation = roleEvaluationService.desarchiver(roleEvaluationConverter.toItem(roleEvaluationVo));
                return roleEvaluationConverter.toVo(roleEvaluation);}
            }
