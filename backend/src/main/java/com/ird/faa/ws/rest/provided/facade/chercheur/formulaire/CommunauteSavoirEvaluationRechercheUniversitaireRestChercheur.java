package main.java.com.ird.faa.ws.rest.provided.facade.chercheur.formulaire;

import com.ird.faa.service.chercheur.facade.formulaire.CommunauteSavoirEvaluationRechercheUniversitaireChercheurService;

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
import com.ird.faa.bean.formulaire.CommunauteSavoirEvaluationRechercheUniversitaire;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.CommunauteSavoirEvaluationRechercheUniversitaireConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.CommunauteSavoirEvaluationRechercheUniversitaireVo;

@Api("Manages communauteSavoirEvaluationRechercheUniversitaire services")
@RestController
@RequestMapping("api/chercheur/communauteSavoirEvaluationRechercheUniversitaire")
public class CommunauteSavoirEvaluationRechercheUniversitaireRestChercheur {

@Autowired
private CommunauteSavoirEvaluationRechercheUniversitaireChercheurService communauteSavoirEvaluationRechercheUniversitaireService;

@Autowired
private CommunauteSavoirEvaluationRechercheUniversitaireConverter communauteSavoirEvaluationRechercheUniversitaireConverter;


            @ApiOperation("Updates the specified  communauteSavoirEvaluationRechercheUniversitaire")
            @PutMapping("/")
            public  CommunauteSavoirEvaluationRechercheUniversitaireVo update(@RequestBody  CommunauteSavoirEvaluationRechercheUniversitaireVo  communauteSavoirEvaluationRechercheUniversitaireVo){
            CommunauteSavoirEvaluationRechercheUniversitaire communauteSavoirEvaluationRechercheUniversitaire = communauteSavoirEvaluationRechercheUniversitaireConverter.toItem(communauteSavoirEvaluationRechercheUniversitaireVo);
            communauteSavoirEvaluationRechercheUniversitaire = communauteSavoirEvaluationRechercheUniversitaireService.update(communauteSavoirEvaluationRechercheUniversitaire);
            return communauteSavoirEvaluationRechercheUniversitaireConverter.toVo(communauteSavoirEvaluationRechercheUniversitaire);
            }

    @ApiOperation("Finds a list of all communauteSavoirEvaluationRechercheUniversitaires")
    @GetMapping("/")
    public List<CommunauteSavoirEvaluationRechercheUniversitaireVo> findAll(){
        return communauteSavoirEvaluationRechercheUniversitaireConverter.toVo(communauteSavoirEvaluationRechercheUniversitaireService.findAll());
    }

    @ApiOperation("Finds a communauteSavoirEvaluationRechercheUniversitaire with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CommunauteSavoirEvaluationRechercheUniversitaireVo findByIdWithAssociatedList(@PathVariable Long id){
    return communauteSavoirEvaluationRechercheUniversitaireConverter.toVo(communauteSavoirEvaluationRechercheUniversitaireService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search communauteSavoirEvaluationRechercheUniversitaire by a specific criteria")
    @PostMapping("/search")
    public List<CommunauteSavoirEvaluationRechercheUniversitaireVo> findByCriteria(@RequestBody CommunauteSavoirEvaluationRechercheUniversitaireVo communauteSavoirEvaluationRechercheUniversitaireVo){
        return communauteSavoirEvaluationRechercheUniversitaireConverter.toVo(communauteSavoirEvaluationRechercheUniversitaireService.findByCriteria(communauteSavoirEvaluationRechercheUniversitaireVo));
        }

            @ApiOperation("Finds a communauteSavoirEvaluationRechercheUniversitaire by id")
            @GetMapping("/id/{id}")
            public CommunauteSavoirEvaluationRechercheUniversitaireVo findById(@PathVariable Long id){
            return communauteSavoirEvaluationRechercheUniversitaireConverter.toVo(communauteSavoirEvaluationRechercheUniversitaireService.findById(id));
            }

            @ApiOperation("Saves the specified  communauteSavoirEvaluationRechercheUniversitaire")
            @PostMapping("/")
            public CommunauteSavoirEvaluationRechercheUniversitaireVo save(@RequestBody CommunauteSavoirEvaluationRechercheUniversitaireVo communauteSavoirEvaluationRechercheUniversitaireVo){
            CommunauteSavoirEvaluationRechercheUniversitaire communauteSavoirEvaluationRechercheUniversitaire = communauteSavoirEvaluationRechercheUniversitaireConverter.toItem(communauteSavoirEvaluationRechercheUniversitaireVo);
            communauteSavoirEvaluationRechercheUniversitaire = communauteSavoirEvaluationRechercheUniversitaireService.save(communauteSavoirEvaluationRechercheUniversitaire);
            return communauteSavoirEvaluationRechercheUniversitaireConverter.toVo(communauteSavoirEvaluationRechercheUniversitaire);
            }

            @ApiOperation("Delete the specified communauteSavoirEvaluationRechercheUniversitaire")
            @DeleteMapping("/")
            public int delete(@RequestBody CommunauteSavoirEvaluationRechercheUniversitaireVo communauteSavoirEvaluationRechercheUniversitaireVo){
            CommunauteSavoirEvaluationRechercheUniversitaire communauteSavoirEvaluationRechercheUniversitaire = communauteSavoirEvaluationRechercheUniversitaireConverter.toItem(communauteSavoirEvaluationRechercheUniversitaireVo);
            return communauteSavoirEvaluationRechercheUniversitaireService.delete(communauteSavoirEvaluationRechercheUniversitaire);
            }

            @ApiOperation("Deletes a communauteSavoirEvaluationRechercheUniversitaire by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return communauteSavoirEvaluationRechercheUniversitaireService.deleteById(id);
            }


        }
