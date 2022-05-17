package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.formulaire.ProjetActiviteRechercheDetailEnjeuxIrdChercheurService;

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
import com.ird.faa.bean.formulaire.ProjetActiviteRechercheDetailEnjeuxIrd;
import com.ird.faa.ws.rest.provided.converter.ProjetActiviteRechercheDetailEnjeuxIrdConverter;
import com.ird.faa.ws.rest.provided.vo.ProjetActiviteRechercheDetailEnjeuxIrdVo;

@Api("Manages projetActiviteRechercheDetailEnjeuxIrd services")
@RestController
@RequestMapping("api/chercheur/projetActiviteRechercheDetailEnjeuxIrd")
public class ProjetActiviteRechercheDetailEnjeuxIrdRestChercheur {

@Autowired
private ProjetActiviteRechercheDetailEnjeuxIrdChercheurService projetActiviteRechercheDetailEnjeuxIrdService;

@Autowired
private ProjetActiviteRechercheDetailEnjeuxIrdConverter projetActiviteRechercheDetailEnjeuxIrdConverter;


            @ApiOperation("Updates the specified  projetActiviteRechercheDetailEnjeuxIrd")
            @PutMapping("/")
            public  ProjetActiviteRechercheDetailEnjeuxIrdVo update(@RequestBody  ProjetActiviteRechercheDetailEnjeuxIrdVo  projetActiviteRechercheDetailEnjeuxIrdVo){
            ProjetActiviteRechercheDetailEnjeuxIrd projetActiviteRechercheDetailEnjeuxIrd = projetActiviteRechercheDetailEnjeuxIrdConverter.toItem(projetActiviteRechercheDetailEnjeuxIrdVo);
            projetActiviteRechercheDetailEnjeuxIrd = projetActiviteRechercheDetailEnjeuxIrdService.update(projetActiviteRechercheDetailEnjeuxIrd);
            return projetActiviteRechercheDetailEnjeuxIrdConverter.toVo(projetActiviteRechercheDetailEnjeuxIrd);
            }

    @ApiOperation("Finds a list of all projetActiviteRechercheDetailEnjeuxIrds")
    @GetMapping("/")
    public List<ProjetActiviteRechercheDetailEnjeuxIrdVo> findAll(){
        return projetActiviteRechercheDetailEnjeuxIrdConverter.toVo(projetActiviteRechercheDetailEnjeuxIrdService.findAll());
    }

    @ApiOperation("Finds a projetActiviteRechercheDetailEnjeuxIrd with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ProjetActiviteRechercheDetailEnjeuxIrdVo findByIdWithAssociatedList(@PathVariable Long id){
    return projetActiviteRechercheDetailEnjeuxIrdConverter.toVo(projetActiviteRechercheDetailEnjeuxIrdService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search projetActiviteRechercheDetailEnjeuxIrd by a specific criteria")
    @PostMapping("/search")
    public List<ProjetActiviteRechercheDetailEnjeuxIrdVo> findByCriteria(@RequestBody ProjetActiviteRechercheDetailEnjeuxIrdVo projetActiviteRechercheDetailEnjeuxIrdVo){
        return projetActiviteRechercheDetailEnjeuxIrdConverter.toVo(projetActiviteRechercheDetailEnjeuxIrdService.findByCriteria(projetActiviteRechercheDetailEnjeuxIrdVo));
        }

            @ApiOperation("Finds a projetActiviteRechercheDetailEnjeuxIrd by id")
            @GetMapping("/id/{id}")
            public ProjetActiviteRechercheDetailEnjeuxIrdVo findById(@PathVariable Long id){
            return projetActiviteRechercheDetailEnjeuxIrdConverter.toVo(projetActiviteRechercheDetailEnjeuxIrdService.findById(id));
            }

            @ApiOperation("Saves the specified  projetActiviteRechercheDetailEnjeuxIrd")
            @PostMapping("/")
            public ProjetActiviteRechercheDetailEnjeuxIrdVo save(@RequestBody ProjetActiviteRechercheDetailEnjeuxIrdVo projetActiviteRechercheDetailEnjeuxIrdVo){
            ProjetActiviteRechercheDetailEnjeuxIrd projetActiviteRechercheDetailEnjeuxIrd = projetActiviteRechercheDetailEnjeuxIrdConverter.toItem(projetActiviteRechercheDetailEnjeuxIrdVo);
            projetActiviteRechercheDetailEnjeuxIrd = projetActiviteRechercheDetailEnjeuxIrdService.save(projetActiviteRechercheDetailEnjeuxIrd);
            return projetActiviteRechercheDetailEnjeuxIrdConverter.toVo(projetActiviteRechercheDetailEnjeuxIrd);
            }

            @ApiOperation("Delete the specified projetActiviteRechercheDetailEnjeuxIrd")
            @DeleteMapping("/")
            public int delete(@RequestBody ProjetActiviteRechercheDetailEnjeuxIrdVo projetActiviteRechercheDetailEnjeuxIrdVo){
            ProjetActiviteRechercheDetailEnjeuxIrd projetActiviteRechercheDetailEnjeuxIrd = projetActiviteRechercheDetailEnjeuxIrdConverter.toItem(projetActiviteRechercheDetailEnjeuxIrdVo);
            return projetActiviteRechercheDetailEnjeuxIrdService.delete(projetActiviteRechercheDetailEnjeuxIrd);
            }

            @ApiOperation("Deletes a projetActiviteRechercheDetailEnjeuxIrd by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return projetActiviteRechercheDetailEnjeuxIrdService.deleteById(id);
            }


        }
