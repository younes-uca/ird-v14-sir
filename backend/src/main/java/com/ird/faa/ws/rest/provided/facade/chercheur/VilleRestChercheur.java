package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.formulaire.VilleChercheurService;

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
import com.ird.faa.bean.referentiel.Ville;
import com.ird.faa.ws.rest.provided.converter.VilleConverter;
import com.ird.faa.ws.rest.provided.vo.VilleVo;

@Api("Manages ville services")
@RestController
@RequestMapping("api/chercheur/ville")
public class VilleRestChercheur {

@Autowired
private VilleChercheurService villeService;

@Autowired
private VilleConverter villeConverter;


            @ApiOperation("Updates the specified  ville")
            @PutMapping("/")
            public  VilleVo update(@RequestBody  VilleVo  villeVo){
            Ville ville = villeConverter.toItem(villeVo);
            ville = villeService.update(ville);
            return villeConverter.toVo(ville);
            }

    @ApiOperation("Finds a list of all villes")
    @GetMapping("/")
    public List<VilleVo> findAll(){
        return villeConverter.toVo(villeService.findAll());
    }

    @ApiOperation("Finds a ville with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public VilleVo findByIdWithAssociatedList(@PathVariable Long id){
    return villeConverter.toVo(villeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search ville by a specific criteria")
    @PostMapping("/search")
    public List<VilleVo> findByCriteria(@RequestBody VilleVo villeVo){
        return villeConverter.toVo(villeService.findByCriteria(villeVo));
        }

            @ApiOperation("Finds a ville by id")
            @GetMapping("/id/{id}")
            public VilleVo findById(@PathVariable Long id){
            return villeConverter.toVo(villeService.findById(id));
            }

            @ApiOperation("Saves the specified  ville")
            @PostMapping("/")
            public VilleVo save(@RequestBody VilleVo villeVo){
            Ville ville = villeConverter.toItem(villeVo);
            ville = villeService.save(ville);
            return villeConverter.toVo(ville);
            }

            @ApiOperation("Delete the specified ville")
            @DeleteMapping("/")
            public int delete(@RequestBody VilleVo villeVo){
            Ville ville = villeConverter.toItem(villeVo);
            return villeService.delete(ville);
            }

            @ApiOperation("Deletes a ville by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return villeService.deleteById(id);
            }


        }
