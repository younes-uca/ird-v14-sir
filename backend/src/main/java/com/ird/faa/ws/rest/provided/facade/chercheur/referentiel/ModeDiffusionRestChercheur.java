package main.java.com.ird.faa.ws.rest.provided.facade.chercheur.referentiel;

import com.ird.faa.service.chercheur.facade.formulaire.ModeDiffusionChercheurService;

import java.util.ArrayList;
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
import com.ird.faa.bean.referentiel.ModeDiffusion;
import com.ird.faa.bean.referentiel.TypeSavoir;
import main.java.com.ird.faa.ws.rest.provided.converter.referentiel.ModeDiffusionConverter;
import main.java.com.ird.faa.ws.rest.provided.converter.referentiel.TypeSavoirConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.ModeDiffusionVo;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.TypeSavoirVo;

@Api("Manages modeDiffusion services")
@RestController
@RequestMapping("api/chercheur/modeDiffusion")
public class ModeDiffusionRestChercheur {

@Autowired
private ModeDiffusionChercheurService modeDiffusionService;

@Autowired
private ModeDiffusionConverter modeDiffusionConverter;

@Autowired
private TypeSavoirConverter typeSavoirConverter;


            @ApiOperation("Updates the specified  modeDiffusion")
            @PutMapping("/")
            public  ModeDiffusionVo update(@RequestBody  ModeDiffusionVo  modeDiffusionVo){
            ModeDiffusion modeDiffusion = modeDiffusionConverter.toItem(modeDiffusionVo);
            modeDiffusion = modeDiffusionService.update(modeDiffusion);
            return modeDiffusionConverter.toVo(modeDiffusion);
            }

    @ApiOperation("Finds a list of all modeDiffusions")
    @GetMapping("/")
    public List<ModeDiffusionVo> findAll(){
        return modeDiffusionConverter.toVo(modeDiffusionService.findAll());
    }

    @ApiOperation("Finds a modeDiffusion with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ModeDiffusionVo findByIdWithAssociatedList(@PathVariable Long id){
    return modeDiffusionConverter.toVo(modeDiffusionService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search modeDiffusion by a specific criteria")
    @PostMapping("/search")
    public List<ModeDiffusionVo> findByCriteria(@RequestBody ModeDiffusionVo modeDiffusionVo){
        return modeDiffusionConverter.toVo(modeDiffusionService.findByCriteria(modeDiffusionVo));
        }

            @ApiOperation("Finds a modeDiffusion by id")
            @GetMapping("/id/{id}")
            public ModeDiffusionVo findById(@PathVariable Long id){
            return modeDiffusionConverter.toVo(modeDiffusionService.findById(id));
            }

            @ApiOperation("Saves the specified  modeDiffusion")
            @PostMapping("/")
            public ModeDiffusionVo save(@RequestBody ModeDiffusionVo modeDiffusionVo){
            ModeDiffusion modeDiffusion = modeDiffusionConverter.toItem(modeDiffusionVo);
            modeDiffusion = modeDiffusionService.save(modeDiffusion);
            return modeDiffusionConverter.toVo(modeDiffusion);
            }

            @ApiOperation("Delete the specified modeDiffusion")
            @DeleteMapping("/")
            public int delete(@RequestBody ModeDiffusionVo modeDiffusionVo){
            ModeDiffusion modeDiffusion = modeDiffusionConverter.toItem(modeDiffusionVo);
            return modeDiffusionService.delete(modeDiffusion);
            }

            @ApiOperation("Deletes a modeDiffusion by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return modeDiffusionService.deleteById(id);
            }
            
            @ApiOperation("Finds a modeDiffusion by list of TypeSavoirs")
            @PostMapping("/search/bytypesavoirs")
            public List<ModeDiffusionVo> findByTypeSavoirs(@RequestBody List<TypeSavoirVo> typeSavoirsVo){
            List<TypeSavoir> typeSavoirs=new ArrayList<TypeSavoir>();
            for (TypeSavoirVo typeSavoirVo:typeSavoirsVo) {
                TypeSavoir typeSavoir = typeSavoirConverter.toItem(typeSavoirVo);
                typeSavoirs.add(typeSavoir);
            }
            return modeDiffusionConverter.toVo(modeDiffusionService.findByTypeSavoirs(typeSavoirs));
            }
            
        }
