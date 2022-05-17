package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.DomaineScientifiqueChercheurAdminService;

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
import com.ird.faa.bean.formulaire.DomaineScientifiqueChercheur;
import com.ird.faa.ws.rest.provided.converter.DomaineScientifiqueChercheurConverter;
import com.ird.faa.ws.rest.provided.vo.DomaineScientifiqueChercheurVo;

@Api("Manages domaineScientifiqueChercheur services")
@RestController
@RequestMapping("api/admin/domaineScientifiqueChercheur")
public class DomaineScientifiqueChercheurRestAdmin {

@Autowired
private DomaineScientifiqueChercheurAdminService domaineScientifiqueChercheurService;

@Autowired
private DomaineScientifiqueChercheurConverter domaineScientifiqueChercheurConverter;


            @ApiOperation("Updates the specified  domaineScientifiqueChercheur")
            @PutMapping("/")
            public  DomaineScientifiqueChercheurVo update(@RequestBody  DomaineScientifiqueChercheurVo  domaineScientifiqueChercheurVo){
            DomaineScientifiqueChercheur domaineScientifiqueChercheur = domaineScientifiqueChercheurConverter.toItem(domaineScientifiqueChercheurVo);
            domaineScientifiqueChercheur = domaineScientifiqueChercheurService.update(domaineScientifiqueChercheur);
            return domaineScientifiqueChercheurConverter.toVo(domaineScientifiqueChercheur);
            }

    @ApiOperation("Finds a list of all domaineScientifiqueChercheurs")
    @GetMapping("/")
    public List<DomaineScientifiqueChercheurVo> findAll(){
        return domaineScientifiqueChercheurConverter.toVo(domaineScientifiqueChercheurService.findAll());
    }

    @ApiOperation("Finds a domaineScientifiqueChercheur with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DomaineScientifiqueChercheurVo findByIdWithAssociatedList(@PathVariable Long id){
    return domaineScientifiqueChercheurConverter.toVo(domaineScientifiqueChercheurService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search domaineScientifiqueChercheur by a specific criteria")
    @PostMapping("/search")
    public List<DomaineScientifiqueChercheurVo> findByCriteria(@RequestBody DomaineScientifiqueChercheurVo domaineScientifiqueChercheurVo){
        return domaineScientifiqueChercheurConverter.toVo(domaineScientifiqueChercheurService.findByCriteria(domaineScientifiqueChercheurVo));
        }

            @ApiOperation("Finds a domaineScientifiqueChercheur by id")
            @GetMapping("/id/{id}")
            public DomaineScientifiqueChercheurVo findById(@PathVariable Long id){
            return domaineScientifiqueChercheurConverter.toVo(domaineScientifiqueChercheurService.findById(id));
            }

            @ApiOperation("Saves the specified  domaineScientifiqueChercheur")
            @PostMapping("/")
            public DomaineScientifiqueChercheurVo save(@RequestBody DomaineScientifiqueChercheurVo domaineScientifiqueChercheurVo){
            DomaineScientifiqueChercheur domaineScientifiqueChercheur = domaineScientifiqueChercheurConverter.toItem(domaineScientifiqueChercheurVo);
            domaineScientifiqueChercheur = domaineScientifiqueChercheurService.save(domaineScientifiqueChercheur);
            return domaineScientifiqueChercheurConverter.toVo(domaineScientifiqueChercheur);
            }

            @ApiOperation("Delete the specified domaineScientifiqueChercheur")
            @DeleteMapping("/")
            public int delete(@RequestBody DomaineScientifiqueChercheurVo domaineScientifiqueChercheurVo){
            DomaineScientifiqueChercheur domaineScientifiqueChercheur = domaineScientifiqueChercheurConverter.toItem(domaineScientifiqueChercheurVo);
            return domaineScientifiqueChercheurService.delete(domaineScientifiqueChercheur);
            }

            @ApiOperation("Deletes a domaineScientifiqueChercheur by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return domaineScientifiqueChercheurService.deleteById(id);
            }


        }
