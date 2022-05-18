package main.java.com.ird.faa.ws.rest.provided.facade.admin.referentiel;

import com.ird.faa.bean.referentiel.AffectationStructurelle;
import com.ird.faa.service.admin.facade.formulaire.AffectationStructurelleAdminService;
import main.java.com.ird.faa.ws.rest.provided.converter.referentiel.AffectationStructurelleConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.AffectationStructurelleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages affectationStructurelle services")
@RestController
@RequestMapping("api/admin/affectationStructurelle")
public class AffectationStructurelleRestAdmin {

@Autowired
private AffectationStructurelleAdminService affectationStructurelleService;

@Autowired
private AffectationStructurelleConverter affectationStructurelleConverter;


            @ApiOperation("Updates the specified  affectationStructurelle")
            @PutMapping("/")
            public  AffectationStructurelleVo update(@RequestBody  AffectationStructurelleVo  affectationStructurelleVo){
            AffectationStructurelle affectationStructurelle = affectationStructurelleConverter.toItem(affectationStructurelleVo);
            affectationStructurelle = affectationStructurelleService.update(affectationStructurelle);
            return affectationStructurelleConverter.toVo(affectationStructurelle);
            }

    @ApiOperation("Finds a list of all affectationStructurelles")
    @GetMapping("/")
    public List<AffectationStructurelleVo> findAll(){
        return affectationStructurelleConverter.toVo(affectationStructurelleService.findAll());
    }

    @ApiOperation("Finds a affectationStructurelle with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public AffectationStructurelleVo findByIdWithAssociatedList(@PathVariable Long id){
    return affectationStructurelleConverter.toVo(affectationStructurelleService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search affectationStructurelle by a specific criteria")
    @PostMapping("/search")
    public List<AffectationStructurelleVo> findByCriteria(@RequestBody AffectationStructurelleVo affectationStructurelleVo){
        return affectationStructurelleConverter.toVo(affectationStructurelleService.findByCriteria(affectationStructurelleVo));
        }

            @ApiOperation("Finds a affectationStructurelle by id")
            @GetMapping("/id/{id}")
            public AffectationStructurelleVo findById(@PathVariable Long id){
            return affectationStructurelleConverter.toVo(affectationStructurelleService.findById(id));
            }

            @ApiOperation("Saves the specified  affectationStructurelle")
            @PostMapping("/")
            public AffectationStructurelleVo save(@RequestBody AffectationStructurelleVo affectationStructurelleVo){
            AffectationStructurelle affectationStructurelle = affectationStructurelleConverter.toItem(affectationStructurelleVo);
            affectationStructurelle = affectationStructurelleService.save(affectationStructurelle);
            return affectationStructurelleConverter.toVo(affectationStructurelle);
            }

            @ApiOperation("Delete the specified affectationStructurelle")
            @DeleteMapping("/")
            public int delete(@RequestBody AffectationStructurelleVo affectationStructurelleVo){
            AffectationStructurelle affectationStructurelle = affectationStructurelleConverter.toItem(affectationStructurelleVo);
            return affectationStructurelleService.delete(affectationStructurelle);
            }

            @ApiOperation("Deletes a affectationStructurelle by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return affectationStructurelleService.deleteById(id);
            }




            }
