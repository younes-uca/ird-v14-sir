package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.CommunauteSavoirChercheurAdminService;

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
import com.ird.faa.bean.formulaire.CommunauteSavoirChercheur;
import com.ird.faa.ws.rest.provided.converter.CommunauteSavoirChercheurConverter;
import com.ird.faa.ws.rest.provided.vo.CommunauteSavoirChercheurVo;

@Api("Manages communauteSavoirChercheur services")
@RestController
@RequestMapping("api/admin/communauteSavoirChercheur")
public class CommunauteSavoirChercheurRestAdmin {

@Autowired
private CommunauteSavoirChercheurAdminService communauteSavoirChercheurService;

@Autowired
private CommunauteSavoirChercheurConverter communauteSavoirChercheurConverter;


            @ApiOperation("Updates the specified  communauteSavoirChercheur")
            @PutMapping("/")
            public  CommunauteSavoirChercheurVo update(@RequestBody  CommunauteSavoirChercheurVo  communauteSavoirChercheurVo){
            CommunauteSavoirChercheur communauteSavoirChercheur = communauteSavoirChercheurConverter.toItem(communauteSavoirChercheurVo);
            communauteSavoirChercheur = communauteSavoirChercheurService.update(communauteSavoirChercheur);
            return communauteSavoirChercheurConverter.toVo(communauteSavoirChercheur);
            }

    @ApiOperation("Finds a list of all communauteSavoirChercheurs")
    @GetMapping("/")
    public List<CommunauteSavoirChercheurVo> findAll(){
        return communauteSavoirChercheurConverter.toVo(communauteSavoirChercheurService.findAll());
    }

    @ApiOperation("Finds a communauteSavoirChercheur with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CommunauteSavoirChercheurVo findByIdWithAssociatedList(@PathVariable Long id){
    return communauteSavoirChercheurConverter.toVo(communauteSavoirChercheurService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search communauteSavoirChercheur by a specific criteria")
    @PostMapping("/search")
    public List<CommunauteSavoirChercheurVo> findByCriteria(@RequestBody CommunauteSavoirChercheurVo communauteSavoirChercheurVo){
        return communauteSavoirChercheurConverter.toVo(communauteSavoirChercheurService.findByCriteria(communauteSavoirChercheurVo));
        }

            @ApiOperation("Finds a communauteSavoirChercheur by id")
            @GetMapping("/id/{id}")
            public CommunauteSavoirChercheurVo findById(@PathVariable Long id){
            return communauteSavoirChercheurConverter.toVo(communauteSavoirChercheurService.findById(id));
            }

            @ApiOperation("Saves the specified  communauteSavoirChercheur")
            @PostMapping("/")
            public CommunauteSavoirChercheurVo save(@RequestBody CommunauteSavoirChercheurVo communauteSavoirChercheurVo){
            CommunauteSavoirChercheur communauteSavoirChercheur = communauteSavoirChercheurConverter.toItem(communauteSavoirChercheurVo);
            communauteSavoirChercheur = communauteSavoirChercheurService.save(communauteSavoirChercheur);
            return communauteSavoirChercheurConverter.toVo(communauteSavoirChercheur);
            }

            @ApiOperation("Delete the specified communauteSavoirChercheur")
            @DeleteMapping("/")
            public int delete(@RequestBody CommunauteSavoirChercheurVo communauteSavoirChercheurVo){
            CommunauteSavoirChercheur communauteSavoirChercheur = communauteSavoirChercheurConverter.toItem(communauteSavoirChercheurVo);
            return communauteSavoirChercheurService.delete(communauteSavoirChercheur);
            }

            @ApiOperation("Deletes a communauteSavoirChercheur by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return communauteSavoirChercheurService.deleteById(id);
            }


        }
