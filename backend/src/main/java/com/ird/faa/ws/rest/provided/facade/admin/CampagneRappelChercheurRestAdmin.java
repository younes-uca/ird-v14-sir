package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.CampagneRappelChercheurAdminService;

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
import com.ird.faa.bean.formulaire.CampagneRappelChercheur;
import com.ird.faa.ws.rest.provided.converter.CampagneRappelChercheurConverter;
import com.ird.faa.ws.rest.provided.vo.CampagneRappelChercheurVo;

@Api("Manages campagneRappelChercheur services")
@RestController
@RequestMapping("api/admin/campagneRappelChercheur")
public class CampagneRappelChercheurRestAdmin {

@Autowired
private CampagneRappelChercheurAdminService campagneRappelChercheurService;

@Autowired
private CampagneRappelChercheurConverter campagneRappelChercheurConverter;


            @ApiOperation("Updates the specified  campagneRappelChercheur")
            @PutMapping("/")
            public  CampagneRappelChercheurVo update(@RequestBody  CampagneRappelChercheurVo  campagneRappelChercheurVo){
            CampagneRappelChercheur campagneRappelChercheur = campagneRappelChercheurConverter.toItem(campagneRappelChercheurVo);
            campagneRappelChercheur = campagneRappelChercheurService.update(campagneRappelChercheur);
            return campagneRappelChercheurConverter.toVo(campagneRappelChercheur);
            }

    @ApiOperation("Finds a list of all campagneRappelChercheurs")
    @GetMapping("/")
    public List<CampagneRappelChercheurVo> findAll(){
        return campagneRappelChercheurConverter.toVo(campagneRappelChercheurService.findAll());
    }

    @ApiOperation("Finds a campagneRappelChercheur with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CampagneRappelChercheurVo findByIdWithAssociatedList(@PathVariable Long id){
    return campagneRappelChercheurConverter.toVo(campagneRappelChercheurService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search campagneRappelChercheur by a specific criteria")
    @PostMapping("/search")
    public List<CampagneRappelChercheurVo> findByCriteria(@RequestBody CampagneRappelChercheurVo campagneRappelChercheurVo){
        return campagneRappelChercheurConverter.toVo(campagneRappelChercheurService.findByCriteria(campagneRappelChercheurVo));
        }

            @ApiOperation("Finds a campagneRappelChercheur by id")
            @GetMapping("/id/{id}")
            public CampagneRappelChercheurVo findById(@PathVariable Long id){
            return campagneRappelChercheurConverter.toVo(campagneRappelChercheurService.findById(id));
            }

            @ApiOperation("Saves the specified  campagneRappelChercheur")
            @PostMapping("/")
            public CampagneRappelChercheurVo save(@RequestBody CampagneRappelChercheurVo campagneRappelChercheurVo){
            CampagneRappelChercheur campagneRappelChercheur = campagneRappelChercheurConverter.toItem(campagneRappelChercheurVo);
            campagneRappelChercheur = campagneRappelChercheurService.save(campagneRappelChercheur);
            return campagneRappelChercheurConverter.toVo(campagneRappelChercheur);
            }

            @ApiOperation("Delete the specified campagneRappelChercheur")
            @DeleteMapping("/")
            public int delete(@RequestBody CampagneRappelChercheurVo campagneRappelChercheurVo){
            CampagneRappelChercheur campagneRappelChercheur = campagneRappelChercheurConverter.toItem(campagneRappelChercheurVo);
            return campagneRappelChercheurService.delete(campagneRappelChercheur);
            }

            @ApiOperation("Deletes a campagneRappelChercheur by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return campagneRappelChercheurService.deleteById(id);
            }
            
            @ApiOperation("Finds a campagneRelanceChercheur with associated lists by id")
            @GetMapping("/findByCampagneRappelId/id/{id}")
            public List<CampagneRappelChercheurVo> findByCampagneRappelId(@PathVariable Long id){
            return campagneRappelChercheurConverter.toVo(campagneRappelChercheurService.findByCampagneRappelId(id));
            }
          


        }
