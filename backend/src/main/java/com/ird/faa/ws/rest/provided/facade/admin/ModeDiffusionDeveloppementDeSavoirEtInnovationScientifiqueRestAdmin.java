package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueAdminService;

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
import com.ird.faa.bean.formulaire.ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique;
import com.ird.faa.ws.rest.provided.converter.ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueConverter;
import com.ird.faa.ws.rest.provided.vo.ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo;

@Api("Manages modeDiffusionDeveloppementDeSavoirEtInnovationScientifique services")
@RestController
@RequestMapping("api/admin/modeDiffusionDeveloppementDeSavoirEtInnovationScientifique")
public class ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueRestAdmin {

@Autowired
private ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueAdminService modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueService;

@Autowired
private ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueConverter modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueConverter;


            @ApiOperation("Updates the specified  modeDiffusionDeveloppementDeSavoirEtInnovationScientifique")
            @PutMapping("/")
            public  ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo update(@RequestBody  ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo  modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo){
            ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique modeDiffusionDeveloppementDeSavoirEtInnovationScientifique = modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueConverter.toItem(modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo);
            modeDiffusionDeveloppementDeSavoirEtInnovationScientifique = modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueService.update(modeDiffusionDeveloppementDeSavoirEtInnovationScientifique);
            return modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueConverter.toVo(modeDiffusionDeveloppementDeSavoirEtInnovationScientifique);
            }

    @ApiOperation("Finds a list of all modeDiffusionDeveloppementDeSavoirEtInnovationScientifiques")
    @GetMapping("/")
    public List<ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo> findAll(){
        return modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueConverter.toVo(modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueService.findAll());
    }

    @ApiOperation("Finds a modeDiffusionDeveloppementDeSavoirEtInnovationScientifique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueConverter.toVo(modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search modeDiffusionDeveloppementDeSavoirEtInnovationScientifique by a specific criteria")
    @PostMapping("/search")
    public List<ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo> findByCriteria(@RequestBody ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo){
        return modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueConverter.toVo(modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueService.findByCriteria(modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo));
        }

            @ApiOperation("Finds a modeDiffusionDeveloppementDeSavoirEtInnovationScientifique by id")
            @GetMapping("/id/{id}")
            public ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo findById(@PathVariable Long id){
            return modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueConverter.toVo(modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueService.findById(id));
            }

            @ApiOperation("Saves the specified  modeDiffusionDeveloppementDeSavoirEtInnovationScientifique")
            @PostMapping("/")
            public ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo save(@RequestBody ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo){
            ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique modeDiffusionDeveloppementDeSavoirEtInnovationScientifique = modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueConverter.toItem(modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo);
            modeDiffusionDeveloppementDeSavoirEtInnovationScientifique = modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueService.save(modeDiffusionDeveloppementDeSavoirEtInnovationScientifique);
            return modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueConverter.toVo(modeDiffusionDeveloppementDeSavoirEtInnovationScientifique);
            }

            @ApiOperation("Delete the specified modeDiffusionDeveloppementDeSavoirEtInnovationScientifique")
            @DeleteMapping("/")
            public int delete(@RequestBody ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo){
            ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique modeDiffusionDeveloppementDeSavoirEtInnovationScientifique = modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueConverter.toItem(modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueVo);
            return modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueService.delete(modeDiffusionDeveloppementDeSavoirEtInnovationScientifique);
            }

            @ApiOperation("Deletes a modeDiffusionDeveloppementDeSavoirEtInnovationScientifique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return modeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueService.deleteById(id);
            }


        }
