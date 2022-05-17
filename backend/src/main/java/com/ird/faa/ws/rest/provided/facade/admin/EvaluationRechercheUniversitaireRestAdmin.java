package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.EvaluationRechercheUniversitaireAdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.ird.faa.bean.formulaire.EvaluationRechercheUniversitaire;
import com.ird.faa.ws.rest.provided.converter.EvaluationRechercheUniversitaireConverter;
import com.ird.faa.ws.rest.provided.vo.EvaluationRechercheUniversitaireVo;

@Api("Manages evaluationRechercheUniversitaire services")
@RestController
@RequestMapping("api/admin/evaluationRechercheUniversitaire")
public class EvaluationRechercheUniversitaireRestAdmin {

@Autowired
private EvaluationRechercheUniversitaireAdminService evaluationRechercheUniversitaireService;

@Autowired
private EvaluationRechercheUniversitaireConverter evaluationRechercheUniversitaireConverter;


            @ApiOperation("Updates the specified  evaluationRechercheUniversitaire")
            @PutMapping("/")
            public  EvaluationRechercheUniversitaireVo update(@RequestBody  EvaluationRechercheUniversitaireVo  evaluationRechercheUniversitaireVo){
            EvaluationRechercheUniversitaire evaluationRechercheUniversitaire = evaluationRechercheUniversitaireConverter.toItem(evaluationRechercheUniversitaireVo);
            evaluationRechercheUniversitaire = evaluationRechercheUniversitaireService.update(evaluationRechercheUniversitaire);
            return evaluationRechercheUniversitaireConverter.toVo(evaluationRechercheUniversitaire);
            }

    @ApiOperation("Finds a list of all evaluationRechercheUniversitaires")
    @GetMapping("/")
    public List<EvaluationRechercheUniversitaireVo> findAll(){
        return evaluationRechercheUniversitaireConverter.toVo(evaluationRechercheUniversitaireService.findAll());
    }

    @ApiOperation("Finds a evaluationRechercheUniversitaire with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EvaluationRechercheUniversitaireVo findByIdWithAssociatedList(@PathVariable Long id){
    return evaluationRechercheUniversitaireConverter.toVo(evaluationRechercheUniversitaireService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search evaluationRechercheUniversitaire by a specific criteria")
    @PostMapping("/search")
    public List<EvaluationRechercheUniversitaireVo> findByCriteria(@RequestBody EvaluationRechercheUniversitaireVo evaluationRechercheUniversitaireVo){
        return evaluationRechercheUniversitaireConverter.toVo(evaluationRechercheUniversitaireService.findByCriteria(evaluationRechercheUniversitaireVo));
        }

            @ApiOperation("Finds a evaluationRechercheUniversitaire by id")
            @GetMapping("/id/{id}")
            public EvaluationRechercheUniversitaireVo findById(@PathVariable Long id){
            return evaluationRechercheUniversitaireConverter.toVo(evaluationRechercheUniversitaireService.findById(id));
            }

            @ApiOperation("Saves the specified  evaluationRechercheUniversitaire")
            @PostMapping("/")
            public EvaluationRechercheUniversitaireVo save(@RequestBody EvaluationRechercheUniversitaireVo evaluationRechercheUniversitaireVo){
            EvaluationRechercheUniversitaire evaluationRechercheUniversitaire = evaluationRechercheUniversitaireConverter.toItem(evaluationRechercheUniversitaireVo);
            evaluationRechercheUniversitaire = evaluationRechercheUniversitaireService.save(evaluationRechercheUniversitaire);
            return evaluationRechercheUniversitaireConverter.toVo(evaluationRechercheUniversitaire);
            }

            @ApiOperation("Delete the specified evaluationRechercheUniversitaire")
            @DeleteMapping("/")
            public int delete(@RequestBody EvaluationRechercheUniversitaireVo evaluationRechercheUniversitaireVo){
            EvaluationRechercheUniversitaire evaluationRechercheUniversitaire = evaluationRechercheUniversitaireConverter.toItem(evaluationRechercheUniversitaireVo);
            return evaluationRechercheUniversitaireService.delete(evaluationRechercheUniversitaire);
            }

            @ApiOperation("Deletes a evaluationRechercheUniversitaire by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return evaluationRechercheUniversitaireService.deleteById(id);
            }


        }
