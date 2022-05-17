package com.ird.faa.ws.rest.provided.facade.chercheur;

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
import com.ird.faa.bean.formulaire.ProjetActiviteRechercheDetailEtablissementFinanceur;
import com.ird.faa.service.chercheur.facade.formulaire.ProjetActiviteRechercheDetailEtablissementFinanceurChercheurService;
import com.ird.faa.ws.rest.provided.converter.ProjetActiviteRechercheDetailEtablissementFinanceurConverter;
import com.ird.faa.ws.rest.provided.vo.ProjetActiviteRechercheDetailEtablissementFinanceurVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Manages projetActiviteRechercheDetailEtablissementFinanceur services")
@RestController
@RequestMapping("api/chercheur/projetActiviteRechercheDetailEtablissementFinanceur")
public class ProjetActiviteRechercheDetailEtablissementFinanceurRestChercheur {

@Autowired
private ProjetActiviteRechercheDetailEtablissementFinanceurChercheurService projetActiviteRechercheDetailEtablissementFinanceurService;

@Autowired
private ProjetActiviteRechercheDetailEtablissementFinanceurConverter projetActiviteRechercheDetailEtablissementFinanceurConverter;


            @ApiOperation("Updates the specified  projetActiviteRechercheDetailEtablissementFinanceur")
            @PutMapping("/")
            public  ProjetActiviteRechercheDetailEtablissementFinanceurVo update(@RequestBody  ProjetActiviteRechercheDetailEtablissementFinanceurVo  projetActiviteRechercheDetailEtablissementFinanceurVo){
            ProjetActiviteRechercheDetailEtablissementFinanceur projetActiviteRechercheDetailEtablissementFinanceur = projetActiviteRechercheDetailEtablissementFinanceurConverter.toItem(projetActiviteRechercheDetailEtablissementFinanceurVo);
            projetActiviteRechercheDetailEtablissementFinanceur = projetActiviteRechercheDetailEtablissementFinanceurService.update(projetActiviteRechercheDetailEtablissementFinanceur);
            return projetActiviteRechercheDetailEtablissementFinanceurConverter.toVo(projetActiviteRechercheDetailEtablissementFinanceur);
            }

    @ApiOperation("Finds a list of all projetActiviteRechercheDetailEtablissementFinanceurs")
    @GetMapping("/")
    public List<ProjetActiviteRechercheDetailEtablissementFinanceurVo> findAll(){
        return projetActiviteRechercheDetailEtablissementFinanceurConverter.toVo(projetActiviteRechercheDetailEtablissementFinanceurService.findAll());
    }

    @ApiOperation("Finds a projetActiviteRechercheDetailEtablissementFinanceur with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ProjetActiviteRechercheDetailEtablissementFinanceurVo findByIdWithAssociatedList(@PathVariable Long id){
    return projetActiviteRechercheDetailEtablissementFinanceurConverter.toVo(projetActiviteRechercheDetailEtablissementFinanceurService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search projetActiviteRechercheDetailEtablissementFinanceur by a specific criteria")
    @PostMapping("/search")
    public List<ProjetActiviteRechercheDetailEtablissementFinanceurVo> findByCriteria(@RequestBody ProjetActiviteRechercheDetailEtablissementFinanceurVo projetActiviteRechercheDetailEtablissementFinanceurVo){
        return projetActiviteRechercheDetailEtablissementFinanceurConverter.toVo(projetActiviteRechercheDetailEtablissementFinanceurService.findByCriteria(projetActiviteRechercheDetailEtablissementFinanceurVo));
        }

            @ApiOperation("Finds a projetActiviteRechercheDetailEtablissementFinanceur by id")
            @GetMapping("/id/{id}")
            public ProjetActiviteRechercheDetailEtablissementFinanceurVo findById(@PathVariable Long id){
            return projetActiviteRechercheDetailEtablissementFinanceurConverter.toVo(projetActiviteRechercheDetailEtablissementFinanceurService.findById(id));
            }

            @ApiOperation("Saves the specified  projetActiviteRechercheDetailEtablissementFinanceur")
            @PostMapping("/")
            public ProjetActiviteRechercheDetailEtablissementFinanceurVo save(@RequestBody ProjetActiviteRechercheDetailEtablissementFinanceurVo projetActiviteRechercheDetailEtablissementFianceurVo){
            ProjetActiviteRechercheDetailEtablissementFinanceur projetActiviteRechercheDetailEtablissementFinanceur = projetActiviteRechercheDetailEtablissementFinanceurConverter.toItem(projetActiviteRechercheDetailEtablissementFianceurVo);
            projetActiviteRechercheDetailEtablissementFinanceur = projetActiviteRechercheDetailEtablissementFinanceurService.save(projetActiviteRechercheDetailEtablissementFinanceur);
            return projetActiviteRechercheDetailEtablissementFinanceurConverter.toVo(projetActiviteRechercheDetailEtablissementFinanceur);
            }

            @ApiOperation("Delete the specified projetActiviteRechercheDetailEtablissementFinanceur")
            @DeleteMapping("/")
            public int delete(@RequestBody ProjetActiviteRechercheDetailEtablissementFinanceurVo projetActiviteRechercheDetailEtablissementFinanceurVo){
            ProjetActiviteRechercheDetailEtablissementFinanceur projetActiviteRechercheDetailEtablissementFinanceur = projetActiviteRechercheDetailEtablissementFinanceurConverter.toItem(projetActiviteRechercheDetailEtablissementFinanceurVo);
            return projetActiviteRechercheDetailEtablissementFinanceurService.delete(projetActiviteRechercheDetailEtablissementFinanceur);
            }

            @ApiOperation("Deletes a projetActiviteRechercheDetailEtablissementFinanceur by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return projetActiviteRechercheDetailEtablissementFinanceurService.deleteById(id);
            }


        }
