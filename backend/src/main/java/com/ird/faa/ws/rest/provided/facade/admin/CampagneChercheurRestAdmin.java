package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.CampagneChercheurAdminService;

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
import com.ird.faa.bean.formulaire.CampagneChercheur;
import com.ird.faa.ws.rest.provided.converter.CampagneChercheurConverter;
import com.ird.faa.ws.rest.provided.vo.CampagneChercheurVo;

@Api("Manages campagneChercheur services")
@RestController
@RequestMapping("api/admin/campagneChercheur")
public class CampagneChercheurRestAdmin {

@Autowired
private CampagneChercheurAdminService campagneChercheurService;

@Autowired
private CampagneChercheurConverter campagneChercheurConverter;


            @ApiOperation("Updates the specified  campagneChercheur")
            @PutMapping("/")
            public  CampagneChercheurVo update(@RequestBody  CampagneChercheurVo  campagneChercheurVo){
            CampagneChercheur campagneChercheur = campagneChercheurConverter.toItem(campagneChercheurVo);
            campagneChercheur = campagneChercheurService.update(campagneChercheur);
            return campagneChercheurConverter.toVo(campagneChercheur);
            }

    @ApiOperation("Finds a list of all campagneChercheurs")
    @GetMapping("/")
    public List<CampagneChercheurVo> findAll(){
        return campagneChercheurConverter.toVo(campagneChercheurService.findAll());
    }

    @ApiOperation("Finds a campagneChercheur with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CampagneChercheurVo findByIdWithAssociatedList(@PathVariable Long id){
    return campagneChercheurConverter.toVo(campagneChercheurService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search campagneChercheur by a specific criteria")
    @PostMapping("/search")
    public List<CampagneChercheurVo> findByCriteria(@RequestBody CampagneChercheurVo campagneChercheurVo){
        return campagneChercheurConverter.toVo(campagneChercheurService.findByCriteria(campagneChercheurVo));
        }

            @ApiOperation("Finds a campagneChercheur by id")
            @GetMapping("/id/{id}")
            public CampagneChercheurVo findById(@PathVariable Long id){
            return campagneChercheurConverter.toVo(campagneChercheurService.findById(id));
            }

            @ApiOperation("Saves the specified  campagneChercheur")
            @PostMapping("/")
            public CampagneChercheurVo save(@RequestBody CampagneChercheurVo campagneChercheurVo){
            CampagneChercheur campagneChercheur = campagneChercheurConverter.toItem(campagneChercheurVo);
            campagneChercheur = campagneChercheurService.save(campagneChercheur);
            return campagneChercheurConverter.toVo(campagneChercheur);
            }

            @ApiOperation("Delete the specified campagneChercheur")
            @DeleteMapping("/")
            public int delete(@RequestBody CampagneChercheurVo campagneChercheurVo){
            CampagneChercheur campagneChercheur = campagneChercheurConverter.toItem(campagneChercheurVo);
            return campagneChercheurService.delete(campagneChercheur);
            }

            @ApiOperation("Deletes a campagneChercheur by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return campagneChercheurService.deleteById(id);
            }


        }
