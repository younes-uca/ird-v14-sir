package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.RoleEvaluationRechercheUniversitaireAdminService;

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
import com.ird.faa.bean.referentiel.RoleEvaluationRechercheUniversitaire;
import com.ird.faa.ws.rest.provided.converter.RoleEvaluationRechercheUniversitaireConverter;
import com.ird.faa.ws.rest.provided.vo.RoleEvaluationRechercheUniversitaireVo;

@Api("Manages roleEvaluationRechercheUniversitaire services")
@RestController
@RequestMapping("api/admin/roleEvaluationRechercheUniversitaire")
public class RoleEvaluationRechercheUniversitaireRestAdmin {

@Autowired
private RoleEvaluationRechercheUniversitaireAdminService roleEvaluationRechercheUniversitaireService;

@Autowired
private RoleEvaluationRechercheUniversitaireConverter roleEvaluationRechercheUniversitaireConverter;


            @ApiOperation("Updates the specified  roleEvaluationRechercheUniversitaire")
            @PutMapping("/")
            public  RoleEvaluationRechercheUniversitaireVo update(@RequestBody  RoleEvaluationRechercheUniversitaireVo  roleEvaluationRechercheUniversitaireVo){
            RoleEvaluationRechercheUniversitaire roleEvaluationRechercheUniversitaire = roleEvaluationRechercheUniversitaireConverter.toItem(roleEvaluationRechercheUniversitaireVo);
            roleEvaluationRechercheUniversitaire = roleEvaluationRechercheUniversitaireService.update(roleEvaluationRechercheUniversitaire);
            return roleEvaluationRechercheUniversitaireConverter.toVo(roleEvaluationRechercheUniversitaire);
            }

    @ApiOperation("Finds a list of all roleEvaluationRechercheUniversitaires")
    @GetMapping("/")
    public List<RoleEvaluationRechercheUniversitaireVo> findAll(){
        return roleEvaluationRechercheUniversitaireConverter.toVo(roleEvaluationRechercheUniversitaireService.findAll());
    }

    @ApiOperation("Finds a roleEvaluationRechercheUniversitaire with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public RoleEvaluationRechercheUniversitaireVo findByIdWithAssociatedList(@PathVariable Long id){
    return roleEvaluationRechercheUniversitaireConverter.toVo(roleEvaluationRechercheUniversitaireService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search roleEvaluationRechercheUniversitaire by a specific criteria")
    @PostMapping("/search")
    public List<RoleEvaluationRechercheUniversitaireVo> findByCriteria(@RequestBody RoleEvaluationRechercheUniversitaireVo roleEvaluationRechercheUniversitaireVo){
        return roleEvaluationRechercheUniversitaireConverter.toVo(roleEvaluationRechercheUniversitaireService.findByCriteria(roleEvaluationRechercheUniversitaireVo));
        }

            @ApiOperation("Finds a roleEvaluationRechercheUniversitaire by id")
            @GetMapping("/id/{id}")
            public RoleEvaluationRechercheUniversitaireVo findById(@PathVariable Long id){
            return roleEvaluationRechercheUniversitaireConverter.toVo(roleEvaluationRechercheUniversitaireService.findById(id));
            }

            @ApiOperation("Saves the specified  roleEvaluationRechercheUniversitaire")
            @PostMapping("/")
            public RoleEvaluationRechercheUniversitaireVo save(@RequestBody RoleEvaluationRechercheUniversitaireVo roleEvaluationRechercheUniversitaireVo){
            RoleEvaluationRechercheUniversitaire roleEvaluationRechercheUniversitaire = roleEvaluationRechercheUniversitaireConverter.toItem(roleEvaluationRechercheUniversitaireVo);
            roleEvaluationRechercheUniversitaire = roleEvaluationRechercheUniversitaireService.save(roleEvaluationRechercheUniversitaire);
            return roleEvaluationRechercheUniversitaireConverter.toVo(roleEvaluationRechercheUniversitaire);
            }

            @ApiOperation("Delete the specified roleEvaluationRechercheUniversitaire")
            @DeleteMapping("/")
            public int delete(@RequestBody RoleEvaluationRechercheUniversitaireVo roleEvaluationRechercheUniversitaireVo){
            RoleEvaluationRechercheUniversitaire roleEvaluationRechercheUniversitaire = roleEvaluationRechercheUniversitaireConverter.toItem(roleEvaluationRechercheUniversitaireVo);
            return roleEvaluationRechercheUniversitaireService.delete(roleEvaluationRechercheUniversitaire);
            }

            @ApiOperation("Deletes a roleEvaluationRechercheUniversitaire by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return roleEvaluationRechercheUniversitaireService.deleteById(id);
            }


        }
