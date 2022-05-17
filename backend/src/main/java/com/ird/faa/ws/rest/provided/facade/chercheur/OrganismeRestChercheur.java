package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.formulaire.OrganismeChercheurService;

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
import com.ird.faa.bean.referentiel.Organisme;
import com.ird.faa.ws.rest.provided.converter.OrganismeConverter;
import com.ird.faa.ws.rest.provided.vo.OrganismeVo;

@Api("Manages organisme services")
@RestController
@RequestMapping("api/chercheur/organisme")
public class OrganismeRestChercheur {

@Autowired
private OrganismeChercheurService organismeService;

@Autowired
private OrganismeConverter organismeConverter;


            @ApiOperation("Updates the specified  organisme")
            @PutMapping("/")
            public  OrganismeVo update(@RequestBody  OrganismeVo  organismeVo){
            Organisme organisme = organismeConverter.toItem(organismeVo);
            organisme = organismeService.update(organisme);
            return organismeConverter.toVo(organisme);
            }

    @ApiOperation("Finds a list of all organismes")
    @GetMapping("/")
    public List<OrganismeVo> findAll(){
        return organismeConverter.toVo(organismeService.findAll());
    }

    @ApiOperation("Finds a organisme with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public OrganismeVo findByIdWithAssociatedList(@PathVariable Long id){
    return organismeConverter.toVo(organismeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search organisme by a specific criteria")
    @PostMapping("/search")
    public List<OrganismeVo> findByCriteria(@RequestBody OrganismeVo organismeVo){
        return organismeConverter.toVo(organismeService.findByCriteria(organismeVo));
        }

            @ApiOperation("Finds a organisme by id")
            @GetMapping("/id/{id}")
            public OrganismeVo findById(@PathVariable Long id){
            return organismeConverter.toVo(organismeService.findById(id));
            }

            @ApiOperation("Saves the specified  organisme")
            @PostMapping("/")
            public OrganismeVo save(@RequestBody OrganismeVo organismeVo){
            Organisme organisme = organismeConverter.toItem(organismeVo);
            organisme = organismeService.save(organisme);
            return organismeConverter.toVo(organisme);
            }

            @ApiOperation("Delete the specified organisme")
            @DeleteMapping("/")
            public int delete(@RequestBody OrganismeVo organismeVo){
            Organisme organisme = organismeConverter.toItem(organismeVo);
            return organismeService.delete(organisme);
            }

            @ApiOperation("Deletes a organisme by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return organismeService.deleteById(id);
            }


        }
