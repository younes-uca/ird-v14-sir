package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.EvaluationEncadrementAdminService;

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
import com.ird.faa.bean.formulaire.EvaluationEncadrement;
import com.ird.faa.ws.rest.provided.converter.EvaluationEncadrementConverter;
import com.ird.faa.ws.rest.provided.vo.EvaluationEncadrementVo;

@Api("Manages evaluationEncadrement services")
@RestController
@RequestMapping("api/admin/evaluationEncadrement")
public class EvaluationEncadrementRestAdmin {

@Autowired
private EvaluationEncadrementAdminService evaluationEncadrementService;

@Autowired
private EvaluationEncadrementConverter evaluationEncadrementConverter;


            @ApiOperation("Updates the specified  evaluationEncadrement")
            @PutMapping("/")
            public  EvaluationEncadrementVo update(@RequestBody  EvaluationEncadrementVo  evaluationEncadrementVo){
            EvaluationEncadrement evaluationEncadrement = evaluationEncadrementConverter.toItem(evaluationEncadrementVo);
            evaluationEncadrement = evaluationEncadrementService.update(evaluationEncadrement);
            return evaluationEncadrementConverter.toVo(evaluationEncadrement);
            }

    @ApiOperation("Finds a list of all evaluationEncadrements")
    @GetMapping("/")
    public List<EvaluationEncadrementVo> findAll(){
        return evaluationEncadrementConverter.toVo(evaluationEncadrementService.findAll());
    }

    @ApiOperation("Finds a evaluationEncadrement with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EvaluationEncadrementVo findByIdWithAssociatedList(@PathVariable Long id){
    return evaluationEncadrementConverter.toVo(evaluationEncadrementService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search evaluationEncadrement by a specific criteria")
    @PostMapping("/search")
    public List<EvaluationEncadrementVo> findByCriteria(@RequestBody EvaluationEncadrementVo evaluationEncadrementVo){
        return evaluationEncadrementConverter.toVo(evaluationEncadrementService.findByCriteria(evaluationEncadrementVo));
        }

            @ApiOperation("Finds a evaluationEncadrement by id")
            @GetMapping("/id/{id}")
            public EvaluationEncadrementVo findById(@PathVariable Long id){
            return evaluationEncadrementConverter.toVo(evaluationEncadrementService.findById(id));
            }

            @ApiOperation("Saves the specified  evaluationEncadrement")
            @PostMapping("/")
            public EvaluationEncadrementVo save(@RequestBody EvaluationEncadrementVo evaluationEncadrementVo){
            EvaluationEncadrement evaluationEncadrement = evaluationEncadrementConverter.toItem(evaluationEncadrementVo);
            evaluationEncadrement = evaluationEncadrementService.save(evaluationEncadrement);
            return evaluationEncadrementConverter.toVo(evaluationEncadrement);
            }

            @ApiOperation("Delete the specified evaluationEncadrement")
            @DeleteMapping("/")
            public int delete(@RequestBody EvaluationEncadrementVo evaluationEncadrementVo){
            EvaluationEncadrement evaluationEncadrement = evaluationEncadrementConverter.toItem(evaluationEncadrementVo);
            return evaluationEncadrementService.delete(evaluationEncadrement);
            }

            @ApiOperation("Deletes a evaluationEncadrement by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return evaluationEncadrementService.deleteById(id);
            }


        }
