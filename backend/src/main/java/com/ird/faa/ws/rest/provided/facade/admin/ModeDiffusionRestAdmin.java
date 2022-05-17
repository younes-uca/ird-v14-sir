package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.ModeDiffusionAdminService;

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
import com.ird.faa.ws.rest.provided.converter.ModeDiffusionConverter;
import com.ird.faa.ws.rest.provided.vo.ModeDiffusionVo;

@Api("Manages modeDiffusion services")
@RestController
@RequestMapping("api/admin/modeDiffusion")
public class ModeDiffusionRestAdmin {

@Autowired
private ModeDiffusionAdminService modeDiffusionService;

@Autowired
private ModeDiffusionConverter modeDiffusionConverter;


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


        }
