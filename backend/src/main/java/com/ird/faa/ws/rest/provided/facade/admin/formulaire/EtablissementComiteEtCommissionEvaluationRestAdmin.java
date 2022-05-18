package main.java.com.ird.faa.ws.rest.provided.facade.admin.formulaire;

import com.ird.faa.bean.formulaire.EtablissementComiteEtCommissionEvaluation;
import com.ird.faa.service.admin.facade.formulaire.EtablissementComiteEtCommissionEvaluationAdminService;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.EtablissementComiteEtCommissionEvaluationConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.EtablissementComiteEtCommissionEvaluationVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages etablissementComiteEtCommissionEvaluation services")
@RestController
@RequestMapping("api/admin/etablissementComiteEtCommissionEvaluation")
public class EtablissementComiteEtCommissionEvaluationRestAdmin {

@Autowired
private EtablissementComiteEtCommissionEvaluationAdminService etablissementComiteEtCommissionEvaluationService;

@Autowired
private EtablissementComiteEtCommissionEvaluationConverter etablissementComiteEtCommissionEvaluationConverter;


            @ApiOperation("Updates the specified  etablissementComiteEtCommissionEvaluation")
            @PutMapping("/")
            public  EtablissementComiteEtCommissionEvaluationVo update(@RequestBody  EtablissementComiteEtCommissionEvaluationVo  etablissementComiteEtCommissionEvaluationVo){
            EtablissementComiteEtCommissionEvaluation etablissementComiteEtCommissionEvaluation = etablissementComiteEtCommissionEvaluationConverter.toItem(etablissementComiteEtCommissionEvaluationVo);
            etablissementComiteEtCommissionEvaluation = etablissementComiteEtCommissionEvaluationService.update(etablissementComiteEtCommissionEvaluation);
            return etablissementComiteEtCommissionEvaluationConverter.toVo(etablissementComiteEtCommissionEvaluation);
            }

    @ApiOperation("Finds a list of all etablissementComiteEtCommissionEvaluations")
    @GetMapping("/")
    public List<EtablissementComiteEtCommissionEvaluationVo> findAll(){
        return etablissementComiteEtCommissionEvaluationConverter.toVo(etablissementComiteEtCommissionEvaluationService.findAll());
    }

    @ApiOperation("Finds a etablissementComiteEtCommissionEvaluation with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtablissementComiteEtCommissionEvaluationVo findByIdWithAssociatedList(@PathVariable Long id){
    return etablissementComiteEtCommissionEvaluationConverter.toVo(etablissementComiteEtCommissionEvaluationService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etablissementComiteEtCommissionEvaluation by a specific criteria")
    @PostMapping("/search")
    public List<EtablissementComiteEtCommissionEvaluationVo> findByCriteria(@RequestBody EtablissementComiteEtCommissionEvaluationVo etablissementComiteEtCommissionEvaluationVo){
        return etablissementComiteEtCommissionEvaluationConverter.toVo(etablissementComiteEtCommissionEvaluationService.findByCriteria(etablissementComiteEtCommissionEvaluationVo));
        }

            @ApiOperation("Finds a etablissementComiteEtCommissionEvaluation by id")
            @GetMapping("/id/{id}")
            public EtablissementComiteEtCommissionEvaluationVo findById(@PathVariable Long id){
            return etablissementComiteEtCommissionEvaluationConverter.toVo(etablissementComiteEtCommissionEvaluationService.findById(id));
            }

            @ApiOperation("Saves the specified  etablissementComiteEtCommissionEvaluation")
            @PostMapping("/")
            public EtablissementComiteEtCommissionEvaluationVo save(@RequestBody EtablissementComiteEtCommissionEvaluationVo etablissementComiteEtCommissionEvaluationVo){
            EtablissementComiteEtCommissionEvaluation etablissementComiteEtCommissionEvaluation = etablissementComiteEtCommissionEvaluationConverter.toItem(etablissementComiteEtCommissionEvaluationVo);
            etablissementComiteEtCommissionEvaluation = etablissementComiteEtCommissionEvaluationService.save(etablissementComiteEtCommissionEvaluation);
            return etablissementComiteEtCommissionEvaluationConverter.toVo(etablissementComiteEtCommissionEvaluation);
            }

            @ApiOperation("Delete the specified etablissementComiteEtCommissionEvaluation")
            @DeleteMapping("/")
            public int delete(@RequestBody EtablissementComiteEtCommissionEvaluationVo etablissementComiteEtCommissionEvaluationVo){
            EtablissementComiteEtCommissionEvaluation etablissementComiteEtCommissionEvaluation = etablissementComiteEtCommissionEvaluationConverter.toItem(etablissementComiteEtCommissionEvaluationVo);
            return etablissementComiteEtCommissionEvaluationService.delete(etablissementComiteEtCommissionEvaluation);
            }

            @ApiOperation("Deletes a etablissementComiteEtCommissionEvaluation by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etablissementComiteEtCommissionEvaluationService.deleteById(id);
            }
        @ApiOperation("find by etablissement code")
        @GetMapping("/etablissement/code/{code}")
        public List<EtablissementComiteEtCommissionEvaluation> findByEtablissementCode(@PathVariable String code){
        return etablissementComiteEtCommissionEvaluationService.findByEtablissementCode(code);
        }

        @ApiOperation("delete by etablissement code")
        @DeleteMapping("/etablissement/code/{code}")
        public int deleteByEtablissementCode(@PathVariable String code){
        return etablissementComiteEtCommissionEvaluationService.deleteByEtablissementCode(code);
        }

        @ApiOperation("find by etablissement id")
        @GetMapping("/etablissement/id/{id}")
        public List<EtablissementComiteEtCommissionEvaluation> findByEtablissementId(@PathVariable Long id){
        return etablissementComiteEtCommissionEvaluationService.findByEtablissementId(id);
        }

        @ApiOperation("delete by etablissement id")
        @DeleteMapping("/etablissement/id/{id}")
        public int deleteByEtablissementId(@PathVariable Long id){
        return etablissementComiteEtCommissionEvaluationService.deleteByEtablissementId(id);
        }

        @ApiOperation("find by comiteEtCommissionEvaluation id")
        @GetMapping("/comiteEtCommissionEvaluation/id/{id}")
        public List<EtablissementComiteEtCommissionEvaluation> findByComiteEtCommissionEvaluationId(@PathVariable Long id){
        return etablissementComiteEtCommissionEvaluationService.findByComiteEtCommissionEvaluationId(id);
        }

        @ApiOperation("delete by comiteEtCommissionEvaluation id")
        @DeleteMapping("/comiteEtCommissionEvaluation/id/{id}")
        public int deleteByComiteEtCommissionEvaluationId(@PathVariable Long id){
        return etablissementComiteEtCommissionEvaluationService.deleteByComiteEtCommissionEvaluationId(id);
        }





            }
