package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.formulaire.CampagneRappelChercheurService;

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
import com.ird.faa.bean.formulaire.CampagneRappel;
import com.ird.faa.ws.rest.provided.converter.CampagneRappelConverter;
import com.ird.faa.ws.rest.provided.vo.CampagneRappelVo;

@Api("Manages campagneRappel services")
@RestController
@RequestMapping("api/chercheur/campagneRappel")
public class CampagneRappelRestChercheur {

@Autowired
private CampagneRappelChercheurService campagneRappelService;

@Autowired
private CampagneRappelConverter campagneRappelConverter;


            @ApiOperation("Updates the specified  campagneRappel")
            @PutMapping("/")
            public  CampagneRappelVo update(@RequestBody  CampagneRappelVo  campagneRappelVo){
            CampagneRappel campagneRappel = campagneRappelConverter.toItem(campagneRappelVo);
            campagneRappel = campagneRappelService.update(campagneRappel);
            return campagneRappelConverter.toVo(campagneRappel);
            }

    @ApiOperation("Finds a list of all campagneRappels")
    @GetMapping("/")
    public List<CampagneRappelVo> findAll(){
        return campagneRappelConverter.toVo(campagneRappelService.findAll());
    }

    @ApiOperation("Finds a campagneRappel with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CampagneRappelVo findByIdWithAssociatedList(@PathVariable Long id){
    return campagneRappelConverter.toVo(campagneRappelService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search campagneRappel by a specific criteria")
    @PostMapping("/search")
    public List<CampagneRappelVo> findByCriteria(@RequestBody CampagneRappelVo campagneRappelVo){
        return campagneRappelConverter.toVo(campagneRappelService.findByCriteria(campagneRappelVo));
        }

            @ApiOperation("Finds a campagneRappel by id")
            @GetMapping("/id/{id}")
            public CampagneRappelVo findById(@PathVariable Long id){
            return campagneRappelConverter.toVo(campagneRappelService.findById(id));
            }

            @ApiOperation("Saves the specified  campagneRappel")
            @PostMapping("/")
            public CampagneRappelVo save(@RequestBody CampagneRappelVo campagneRappelVo){
            CampagneRappel campagneRappel = campagneRappelConverter.toItem(campagneRappelVo);
            campagneRappel = campagneRappelService.save(campagneRappel);
            return campagneRappelConverter.toVo(campagneRappel);
            }

            @ApiOperation("Delete the specified campagneRappel")
            @DeleteMapping("/")
            public int delete(@RequestBody CampagneRappelVo campagneRappelVo){
            CampagneRappel campagneRappel = campagneRappelConverter.toItem(campagneRappelVo);
            return campagneRappelService.delete(campagneRappel);
            }

            @ApiOperation("Deletes a campagneRappel by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return campagneRappelService.deleteById(id);
            }


        }
