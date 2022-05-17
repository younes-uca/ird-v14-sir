package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.CampagneRelanceChercheurAdminService;

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
import com.ird.faa.bean.formulaire.CampagneRelanceChercheur;
import com.ird.faa.ws.rest.provided.converter.CampagneRelanceChercheurConverter;
import com.ird.faa.ws.rest.provided.vo.CampagneRelanceChercheurVo;

@Api("Manages campagneRelanceChercheur services")
@RestController
@RequestMapping("api/admin/campagneRelanceChercheur")
public class CampagneRelanceChercheurRestAdmin {

@Autowired
private CampagneRelanceChercheurAdminService campagneRelanceChercheurService;

@Autowired
private CampagneRelanceChercheurConverter campagneRelanceChercheurConverter;


            @ApiOperation("Updates the specified  campagneRelanceChercheur")
            @PutMapping("/")
            public  CampagneRelanceChercheurVo update(@RequestBody  CampagneRelanceChercheurVo  campagneRelanceChercheurVo){
            CampagneRelanceChercheur campagneRelanceChercheur = campagneRelanceChercheurConverter.toItem(campagneRelanceChercheurVo);
            campagneRelanceChercheur = campagneRelanceChercheurService.update(campagneRelanceChercheur);
            return campagneRelanceChercheurConverter.toVo(campagneRelanceChercheur);
            }

    @ApiOperation("Finds a list of all campagneRelanceChercheurs")
    @GetMapping("/")
    public List<CampagneRelanceChercheurVo> findAll(){
    	
    	List<CampagneRelanceChercheurVo> campagneRelanceChercheurs=campagneRelanceChercheurConverter.toVo(campagneRelanceChercheurService.findAll()); 
        return campagneRelanceChercheurConverter.toVo(campagneRelanceChercheurService.findAll());
    }

    @ApiOperation("Finds a campagneRelanceChercheur with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CampagneRelanceChercheurVo findByIdWithAssociatedList(@PathVariable Long id){
    return campagneRelanceChercheurConverter.toVo(campagneRelanceChercheurService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search campagneRelanceChercheur by a specific criteria")
    @PostMapping("/search")
    public List<CampagneRelanceChercheurVo> findByCriteria(@RequestBody CampagneRelanceChercheurVo campagneRelanceChercheurVo){
        return campagneRelanceChercheurConverter.toVo(campagneRelanceChercheurService.findByCriteria(campagneRelanceChercheurVo));
        }

            @ApiOperation("Finds a campagneRelanceChercheur by id")
            @GetMapping("/id/{id}")
            public CampagneRelanceChercheurVo findById(@PathVariable Long id){
            return campagneRelanceChercheurConverter.toVo(campagneRelanceChercheurService.findById(id));
            }

            @ApiOperation("Saves the specified  campagneRelanceChercheur")
            @PostMapping("/")
            public CampagneRelanceChercheurVo save(@RequestBody CampagneRelanceChercheurVo campagneRelanceChercheurVo){
            CampagneRelanceChercheur campagneRelanceChercheur = campagneRelanceChercheurConverter.toItem(campagneRelanceChercheurVo);
            campagneRelanceChercheur = campagneRelanceChercheurService.save(campagneRelanceChercheur);
            return campagneRelanceChercheurConverter.toVo(campagneRelanceChercheur);
            }

            @ApiOperation("Delete the specified campagneRelanceChercheur")
            @DeleteMapping("/")
            public int delete(@RequestBody CampagneRelanceChercheurVo campagneRelanceChercheurVo){
            CampagneRelanceChercheur campagneRelanceChercheur = campagneRelanceChercheurConverter.toItem(campagneRelanceChercheurVo);
            return campagneRelanceChercheurService.delete(campagneRelanceChercheur);
            }

            @ApiOperation("Deletes a campagneRelanceChercheur by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return campagneRelanceChercheurService.deleteById(id);
            }
         
          
            @ApiOperation("Finds a campagneRelanceChercheur with associated lists by id")
            @GetMapping("/findByCampagneRelanceId/id/{id}")
            public List<CampagneRelanceChercheurVo> findByCampagneRelanceId(@PathVariable Long id){
            return campagneRelanceChercheurConverter.toVo(campagneRelanceChercheurService.findByCampagneRelanceId(id));
            }
            


        }
