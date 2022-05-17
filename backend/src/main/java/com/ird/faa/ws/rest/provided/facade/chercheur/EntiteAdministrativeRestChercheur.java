package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.formulaire.EntiteAdministrativeChercheurService;

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
import com.ird.faa.bean.referentiel.EntiteAdministrative;
import com.ird.faa.ws.rest.provided.converter.EntiteAdministrativeConverter;
import com.ird.faa.ws.rest.provided.vo.EntiteAdministrativeVo;

@Api("Manages entiteAdministrative services")
@RestController
@RequestMapping("api/chercheur/entiteAdministrative")
public class EntiteAdministrativeRestChercheur {

@Autowired
private EntiteAdministrativeChercheurService entiteAdministrativeService;

@Autowired
private EntiteAdministrativeConverter entiteAdministrativeConverter;


            @ApiOperation("Updates the specified  entiteAdministrative")
            @PutMapping("/")
            public  EntiteAdministrativeVo update(@RequestBody  EntiteAdministrativeVo  entiteAdministrativeVo){
            EntiteAdministrative entiteAdministrative = entiteAdministrativeConverter.toItem(entiteAdministrativeVo);
            entiteAdministrative = entiteAdministrativeService.update(entiteAdministrative);
            return entiteAdministrativeConverter.toVo(entiteAdministrative);
            }

    @ApiOperation("Finds a list of all entiteAdministratives")
    @GetMapping("/")
    public List<EntiteAdministrativeVo> findAll(){
        return entiteAdministrativeConverter.toVo(entiteAdministrativeService.findAll());
    }

    @ApiOperation("Finds a entiteAdministrative with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EntiteAdministrativeVo findByIdWithAssociatedList(@PathVariable Long id){
    return entiteAdministrativeConverter.toVo(entiteAdministrativeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search entiteAdministrative by a specific criteria")
    @PostMapping("/search")
    public List<EntiteAdministrativeVo> findByCriteria(@RequestBody EntiteAdministrativeVo entiteAdministrativeVo){
        return entiteAdministrativeConverter.toVo(entiteAdministrativeService.findByCriteria(entiteAdministrativeVo));
        }

            @ApiOperation("Finds a entiteAdministrative by id")
            @GetMapping("/id/{id}")
            public EntiteAdministrativeVo findById(@PathVariable Long id){
            return entiteAdministrativeConverter.toVo(entiteAdministrativeService.findById(id));
            }

            @ApiOperation("Saves the specified  entiteAdministrative")
            @PostMapping("/")
            public EntiteAdministrativeVo save(@RequestBody EntiteAdministrativeVo entiteAdministrativeVo){
            EntiteAdministrative entiteAdministrative = entiteAdministrativeConverter.toItem(entiteAdministrativeVo);
            entiteAdministrative = entiteAdministrativeService.save(entiteAdministrative);
            return entiteAdministrativeConverter.toVo(entiteAdministrative);
            }

            @ApiOperation("Delete the specified entiteAdministrative")
            @DeleteMapping("/")
            public int delete(@RequestBody EntiteAdministrativeVo entiteAdministrativeVo){
            EntiteAdministrative entiteAdministrative = entiteAdministrativeConverter.toItem(entiteAdministrativeVo);
            return entiteAdministrativeService.delete(entiteAdministrative);
            }

            @ApiOperation("Deletes a entiteAdministrative by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return entiteAdministrativeService.deleteById(id);
            }


        }
