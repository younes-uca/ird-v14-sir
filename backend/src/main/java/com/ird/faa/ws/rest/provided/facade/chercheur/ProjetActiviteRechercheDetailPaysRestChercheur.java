package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.formulaire.ProjetActiviteRechercheDetailPaysChercheurService;

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
import com.ird.faa.bean.formulaire.ProjetActiviteRechercheDetailPays;
import com.ird.faa.ws.rest.provided.converter.ProjetActiviteRechercheDetailPaysConverter;
import com.ird.faa.ws.rest.provided.vo.ProjetActiviteRechercheDetailPaysVo;

@Api("Manages projetActiviteRechercheDetailPays services")
@RestController
@RequestMapping("api/chercheur/projetActiviteRechercheDetailPays")
public class ProjetActiviteRechercheDetailPaysRestChercheur {

@Autowired
private ProjetActiviteRechercheDetailPaysChercheurService projetActiviteRechercheDetailPaysService;

@Autowired
private ProjetActiviteRechercheDetailPaysConverter projetActiviteRechercheDetailPaysConverter;


            @ApiOperation("Updates the specified  projetActiviteRechercheDetailPays")
            @PutMapping("/")
            public  ProjetActiviteRechercheDetailPaysVo update(@RequestBody  ProjetActiviteRechercheDetailPaysVo  projetActiviteRechercheDetailPaysVo){
            ProjetActiviteRechercheDetailPays projetActiviteRechercheDetailPays = projetActiviteRechercheDetailPaysConverter.toItem(projetActiviteRechercheDetailPaysVo);
            projetActiviteRechercheDetailPays = projetActiviteRechercheDetailPaysService.update(projetActiviteRechercheDetailPays);
            return projetActiviteRechercheDetailPaysConverter.toVo(projetActiviteRechercheDetailPays);
            }

    @ApiOperation("Finds a list of all projetActiviteRechercheDetailPayss")
    @GetMapping("/")
    public List<ProjetActiviteRechercheDetailPaysVo> findAll(){
        return projetActiviteRechercheDetailPaysConverter.toVo(projetActiviteRechercheDetailPaysService.findAll());
    }

    @ApiOperation("Finds a projetActiviteRechercheDetailPays with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ProjetActiviteRechercheDetailPaysVo findByIdWithAssociatedList(@PathVariable Long id){
    return projetActiviteRechercheDetailPaysConverter.toVo(projetActiviteRechercheDetailPaysService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search projetActiviteRechercheDetailPays by a specific criteria")
    @PostMapping("/search")
    public List<ProjetActiviteRechercheDetailPaysVo> findByCriteria(@RequestBody ProjetActiviteRechercheDetailPaysVo projetActiviteRechercheDetailPaysVo){
        return projetActiviteRechercheDetailPaysConverter.toVo(projetActiviteRechercheDetailPaysService.findByCriteria(projetActiviteRechercheDetailPaysVo));
        }

            @ApiOperation("Finds a projetActiviteRechercheDetailPays by id")
            @GetMapping("/id/{id}")
            public ProjetActiviteRechercheDetailPaysVo findById(@PathVariable Long id){
            return projetActiviteRechercheDetailPaysConverter.toVo(projetActiviteRechercheDetailPaysService.findById(id));
            }

            @ApiOperation("Saves the specified  projetActiviteRechercheDetailPays")
            @PostMapping("/")
            public ProjetActiviteRechercheDetailPaysVo save(@RequestBody ProjetActiviteRechercheDetailPaysVo projetActiviteRechercheDetailPaysVo){
            ProjetActiviteRechercheDetailPays projetActiviteRechercheDetailPays = projetActiviteRechercheDetailPaysConverter.toItem(projetActiviteRechercheDetailPaysVo);
            projetActiviteRechercheDetailPays = projetActiviteRechercheDetailPaysService.save(projetActiviteRechercheDetailPays);
            return projetActiviteRechercheDetailPaysConverter.toVo(projetActiviteRechercheDetailPays);
            }

            @ApiOperation("Delete the specified projetActiviteRechercheDetailPays")
            @DeleteMapping("/")
            public int delete(@RequestBody ProjetActiviteRechercheDetailPaysVo projetActiviteRechercheDetailPaysVo){
            ProjetActiviteRechercheDetailPays projetActiviteRechercheDetailPays = projetActiviteRechercheDetailPaysConverter.toItem(projetActiviteRechercheDetailPaysVo);
            return projetActiviteRechercheDetailPaysService.delete(projetActiviteRechercheDetailPays);
            }

            @ApiOperation("Deletes a projetActiviteRechercheDetailPays by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return projetActiviteRechercheDetailPaysService.deleteById(id);
            }


        }
