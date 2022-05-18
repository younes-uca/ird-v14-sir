package main.java.com.ird.faa.ws.rest.provided.facade.chercheur.formulaire;

import com.ird.faa.service.chercheur.facade.formulaire.ProjetActiviteRechercheChercheurService;

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
import com.ird.faa.bean.formulaire.ProjetActiviteRecherche;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.ProjetActiviteRechercheConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.ProjetActiviteRechercheVo;

@Api("Manages projetActiviteRecherche services")
@RestController
@RequestMapping("api/chercheur/projetActiviteRecherche")
public class ProjetActiviteRechercheRestChercheur {

@Autowired
private ProjetActiviteRechercheChercheurService projetActiviteRechercheService;

@Autowired
private ProjetActiviteRechercheConverter projetActiviteRechercheConverter;


            @ApiOperation("Updates the specified  projetActiviteRecherche")
            @PutMapping("/")
            public  ProjetActiviteRechercheVo update(@RequestBody  ProjetActiviteRechercheVo  projetActiviteRechercheVo){
            ProjetActiviteRecherche projetActiviteRecherche = projetActiviteRechercheConverter.toItem(projetActiviteRechercheVo);
            projetActiviteRecherche = projetActiviteRechercheService.update(projetActiviteRecherche);
            return projetActiviteRechercheConverter.toVo(projetActiviteRecherche);
            }

    @ApiOperation("Finds a list of all projetActiviteRecherches")
    @GetMapping("/")
    public List<ProjetActiviteRechercheVo> findAll(){
        return projetActiviteRechercheConverter.toVo(projetActiviteRechercheService.findAll());
    }

    @ApiOperation("Finds a projetActiviteRecherche with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ProjetActiviteRechercheVo findByIdWithAssociatedList(@PathVariable Long id){
    return projetActiviteRechercheConverter.toVo(projetActiviteRechercheService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search projetActiviteRecherche by a specific criteria")
    @PostMapping("/search")
    public List<ProjetActiviteRechercheVo> findByCriteria(@RequestBody ProjetActiviteRechercheVo projetActiviteRechercheVo){
        return projetActiviteRechercheConverter.toVo(projetActiviteRechercheService.findByCriteria(projetActiviteRechercheVo));
        }

            @ApiOperation("Finds a projetActiviteRecherche by id")
            @GetMapping("/id/{id}")
            public ProjetActiviteRechercheVo findById(@PathVariable Long id){
            return projetActiviteRechercheConverter.toVo(projetActiviteRechercheService.findById(id));
            }

            @ApiOperation("Saves the specified  projetActiviteRecherche")
            @PostMapping("/")
            public ProjetActiviteRechercheVo save(@RequestBody ProjetActiviteRechercheVo projetActiviteRechercheVo){
            ProjetActiviteRecherche projetActiviteRecherche = projetActiviteRechercheConverter.toItem(projetActiviteRechercheVo);
            projetActiviteRecherche = projetActiviteRechercheService.save(projetActiviteRecherche);
            return projetActiviteRechercheConverter.toVo(projetActiviteRecherche);
            }

            @ApiOperation("Delete the specified projetActiviteRecherche")
            @DeleteMapping("/")
            public int delete(@RequestBody ProjetActiviteRechercheVo projetActiviteRechercheVo){
            ProjetActiviteRecherche projetActiviteRecherche = projetActiviteRechercheConverter.toItem(projetActiviteRechercheVo);
            return projetActiviteRechercheService.delete(projetActiviteRecherche);
            }

            @ApiOperation("Deletes a projetActiviteRecherche by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return projetActiviteRechercheService.deleteById(id);
            }


            @GetMapping("/username/{username}/id/{compagneId}")
            public List<ProjetActiviteRechercheVo> findByChercheurUsernameAndCampagneId(@PathVariable String username,@PathVariable Long compagneId){
            return projetActiviteRechercheConverter.toVo(projetActiviteRechercheService.findByChercheurUsernameAndCampagneId(username,compagneId));
            }
        }
