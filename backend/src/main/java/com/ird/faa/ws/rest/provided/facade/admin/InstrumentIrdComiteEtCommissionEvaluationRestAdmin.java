package com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.bean.formulaire.InstrumentIrdComiteEtCommissionEvaluation;
import com.ird.faa.service.admin.facade.formulaire.InstrumentIrdComiteEtCommissionEvaluationAdminService;
import com.ird.faa.ws.rest.provided.converter.InstrumentIrdComiteEtCommissionEvaluationConverter;
import com.ird.faa.ws.rest.provided.vo.InstrumentIrdComiteEtCommissionEvaluationVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages instrumentIrdComiteEtCommissionEvaluation services")
@RestController
@RequestMapping("api/admin/instrumentIrdComiteEtCommissionEvaluation")
public class InstrumentIrdComiteEtCommissionEvaluationRestAdmin {

@Autowired
private InstrumentIrdComiteEtCommissionEvaluationAdminService instrumentIrdComiteEtCommissionEvaluationService;

@Autowired
private InstrumentIrdComiteEtCommissionEvaluationConverter instrumentIrdComiteEtCommissionEvaluationConverter;


            @ApiOperation("Updates the specified  instrumentIrdComiteEtCommissionEvaluation")
            @PutMapping("/")
            public  InstrumentIrdComiteEtCommissionEvaluationVo update(@RequestBody  InstrumentIrdComiteEtCommissionEvaluationVo  instrumentIrdComiteEtCommissionEvaluationVo){
            InstrumentIrdComiteEtCommissionEvaluation instrumentIrdComiteEtCommissionEvaluation = instrumentIrdComiteEtCommissionEvaluationConverter.toItem(instrumentIrdComiteEtCommissionEvaluationVo);
            instrumentIrdComiteEtCommissionEvaluation = instrumentIrdComiteEtCommissionEvaluationService.update(instrumentIrdComiteEtCommissionEvaluation);
            return instrumentIrdComiteEtCommissionEvaluationConverter.toVo(instrumentIrdComiteEtCommissionEvaluation);
            }

    @ApiOperation("Finds a list of all instrumentIrdComiteEtCommissionEvaluations")
    @GetMapping("/")
    public List<InstrumentIrdComiteEtCommissionEvaluationVo> findAll(){
        return instrumentIrdComiteEtCommissionEvaluationConverter.toVo(instrumentIrdComiteEtCommissionEvaluationService.findAll());
    }

    @ApiOperation("Finds a instrumentIrdComiteEtCommissionEvaluation with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public InstrumentIrdComiteEtCommissionEvaluationVo findByIdWithAssociatedList(@PathVariable Long id){
    return instrumentIrdComiteEtCommissionEvaluationConverter.toVo(instrumentIrdComiteEtCommissionEvaluationService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search instrumentIrdComiteEtCommissionEvaluation by a specific criteria")
    @PostMapping("/search")
    public List<InstrumentIrdComiteEtCommissionEvaluationVo> findByCriteria(@RequestBody InstrumentIrdComiteEtCommissionEvaluationVo instrumentIrdComiteEtCommissionEvaluationVo){
        return instrumentIrdComiteEtCommissionEvaluationConverter.toVo(instrumentIrdComiteEtCommissionEvaluationService.findByCriteria(instrumentIrdComiteEtCommissionEvaluationVo));
        }

            @ApiOperation("Finds a instrumentIrdComiteEtCommissionEvaluation by id")
            @GetMapping("/id/{id}")
            public InstrumentIrdComiteEtCommissionEvaluationVo findById(@PathVariable Long id){
            return instrumentIrdComiteEtCommissionEvaluationConverter.toVo(instrumentIrdComiteEtCommissionEvaluationService.findById(id));
            }

            @ApiOperation("Saves the specified  instrumentIrdComiteEtCommissionEvaluation")
            @PostMapping("/")
            public InstrumentIrdComiteEtCommissionEvaluationVo save(@RequestBody InstrumentIrdComiteEtCommissionEvaluationVo instrumentIrdComiteEtCommissionEvaluationVo){
            InstrumentIrdComiteEtCommissionEvaluation instrumentIrdComiteEtCommissionEvaluation = instrumentIrdComiteEtCommissionEvaluationConverter.toItem(instrumentIrdComiteEtCommissionEvaluationVo);
            instrumentIrdComiteEtCommissionEvaluation = instrumentIrdComiteEtCommissionEvaluationService.save(instrumentIrdComiteEtCommissionEvaluation);
            return instrumentIrdComiteEtCommissionEvaluationConverter.toVo(instrumentIrdComiteEtCommissionEvaluation);
            }

            @ApiOperation("Delete the specified instrumentIrdComiteEtCommissionEvaluation")
            @DeleteMapping("/")
            public int delete(@RequestBody InstrumentIrdComiteEtCommissionEvaluationVo instrumentIrdComiteEtCommissionEvaluationVo){
            InstrumentIrdComiteEtCommissionEvaluation instrumentIrdComiteEtCommissionEvaluation = instrumentIrdComiteEtCommissionEvaluationConverter.toItem(instrumentIrdComiteEtCommissionEvaluationVo);
            return instrumentIrdComiteEtCommissionEvaluationService.delete(instrumentIrdComiteEtCommissionEvaluation);
            }

            @ApiOperation("Deletes a instrumentIrdComiteEtCommissionEvaluation by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return instrumentIrdComiteEtCommissionEvaluationService.deleteById(id);
            }
        @ApiOperation("find by instrumentIrd code")
        @GetMapping("/instrumentIrd/code/{code}")
        public List<InstrumentIrdComiteEtCommissionEvaluation> findByInstrumentIrdCode(@PathVariable String code){
        return instrumentIrdComiteEtCommissionEvaluationService.findByInstrumentIrdCode(code);
        }

        @ApiOperation("delete by instrumentIrd code")
        @DeleteMapping("/instrumentIrd/code/{code}")
        public int deleteByInstrumentIrdCode(@PathVariable String code){
        return instrumentIrdComiteEtCommissionEvaluationService.deleteByInstrumentIrdCode(code);
        }

        @ApiOperation("find by instrumentIrd id")
        @GetMapping("/instrumentIrd/id/{id}")
        public List<InstrumentIrdComiteEtCommissionEvaluation> findByInstrumentIrdId(@PathVariable Long id){
        return instrumentIrdComiteEtCommissionEvaluationService.findByInstrumentIrdId(id);
        }

        @ApiOperation("delete by instrumentIrd id")
        @DeleteMapping("/instrumentIrd/id/{id}")
        public int deleteByInstrumentIrdId(@PathVariable Long id){
        return instrumentIrdComiteEtCommissionEvaluationService.deleteByInstrumentIrdId(id);
        }

        @ApiOperation("find by typeInstrumentIrd code")
        @GetMapping("/typeInstrumentIrd/code/{code}")
        public List<InstrumentIrdComiteEtCommissionEvaluation> findByTypeInstrumentIrdCode(@PathVariable String code){
        return instrumentIrdComiteEtCommissionEvaluationService.findByTypeInstrumentIrdCode(code);
        }

        @ApiOperation("delete by typeInstrumentIrd code")
        @DeleteMapping("/typeInstrumentIrd/code/{code}")
        public int deleteByTypeInstrumentIrdCode(@PathVariable String code){
        return instrumentIrdComiteEtCommissionEvaluationService.deleteByTypeInstrumentIrdCode(code);
        }

        @ApiOperation("find by typeInstrumentIrd id")
        @GetMapping("/typeInstrumentIrd/id/{id}")
        public List<InstrumentIrdComiteEtCommissionEvaluation> findByTypeInstrumentIrdId(@PathVariable Long id){
        return instrumentIrdComiteEtCommissionEvaluationService.findByTypeInstrumentIrdId(id);
        }

        @ApiOperation("delete by typeInstrumentIrd id")
        @DeleteMapping("/typeInstrumentIrd/id/{id}")
        public int deleteByTypeInstrumentIrdId(@PathVariable Long id){
        return instrumentIrdComiteEtCommissionEvaluationService.deleteByTypeInstrumentIrdId(id);
        }

        @ApiOperation("find by comiteEtCommissionEvaluation id")
        @GetMapping("/comiteEtCommissionEvaluation/id/{id}")
        public List<InstrumentIrdComiteEtCommissionEvaluation> findByComiteEtCommissionEvaluationId(@PathVariable Long id){
        return instrumentIrdComiteEtCommissionEvaluationService.findByComiteEtCommissionEvaluationId(id);
        }

        @ApiOperation("delete by comiteEtCommissionEvaluation id")
        @DeleteMapping("/comiteEtCommissionEvaluation/id/{id}")
        public int deleteByComiteEtCommissionEvaluationId(@PathVariable Long id){
        return instrumentIrdComiteEtCommissionEvaluationService.deleteByComiteEtCommissionEvaluationId(id);
        }





            }
