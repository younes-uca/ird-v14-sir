package main.java.com.ird.faa.ws.rest.provided.facade.chercheur.formulaire;

import com.ird.faa.service.chercheur.facade.formulaire.DisciplineScientifiqueEvaluationRechercheUniversitaireChercheurService;

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
import com.ird.faa.bean.formulaire.DisciplineScientifiqueEvaluationRechercheUniversitaire;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.DisciplineScientifiqueEvaluationRechercheUniversitaireConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.DisciplineScientifiqueEvaluationRechercheUniversitaireVo;

@Api("Manages disciplineScientifiqueEvaluationRechercheUniversitaire services")
@RestController
@RequestMapping("api/chercheur/disciplineScientifiqueEvaluationRechercheUniversitaire")
public class DisciplineScientifiqueEvaluationRechercheUniversitaireRestChercheur {

@Autowired
private DisciplineScientifiqueEvaluationRechercheUniversitaireChercheurService disciplineScientifiqueEvaluationRechercheUniversitaireService;

@Autowired
private DisciplineScientifiqueEvaluationRechercheUniversitaireConverter disciplineScientifiqueEvaluationRechercheUniversitaireConverter;


            @ApiOperation("Updates the specified  disciplineScientifiqueEvaluationRechercheUniversitaire")
            @PutMapping("/")
            public  DisciplineScientifiqueEvaluationRechercheUniversitaireVo update(@RequestBody  DisciplineScientifiqueEvaluationRechercheUniversitaireVo  disciplineScientifiqueEvaluationRechercheUniversitaireVo){
            DisciplineScientifiqueEvaluationRechercheUniversitaire disciplineScientifiqueEvaluationRechercheUniversitaire = disciplineScientifiqueEvaluationRechercheUniversitaireConverter.toItem(disciplineScientifiqueEvaluationRechercheUniversitaireVo);
            disciplineScientifiqueEvaluationRechercheUniversitaire = disciplineScientifiqueEvaluationRechercheUniversitaireService.update(disciplineScientifiqueEvaluationRechercheUniversitaire);
            return disciplineScientifiqueEvaluationRechercheUniversitaireConverter.toVo(disciplineScientifiqueEvaluationRechercheUniversitaire);
            }

    @ApiOperation("Finds a list of all disciplineScientifiqueEvaluationRechercheUniversitaires")
    @GetMapping("/")
    public List<DisciplineScientifiqueEvaluationRechercheUniversitaireVo> findAll(){
        return disciplineScientifiqueEvaluationRechercheUniversitaireConverter.toVo(disciplineScientifiqueEvaluationRechercheUniversitaireService.findAll());
    }

    @ApiOperation("Finds a disciplineScientifiqueEvaluationRechercheUniversitaire with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DisciplineScientifiqueEvaluationRechercheUniversitaireVo findByIdWithAssociatedList(@PathVariable Long id){
    return disciplineScientifiqueEvaluationRechercheUniversitaireConverter.toVo(disciplineScientifiqueEvaluationRechercheUniversitaireService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search disciplineScientifiqueEvaluationRechercheUniversitaire by a specific criteria")
    @PostMapping("/search")
    public List<DisciplineScientifiqueEvaluationRechercheUniversitaireVo> findByCriteria(@RequestBody DisciplineScientifiqueEvaluationRechercheUniversitaireVo disciplineScientifiqueEvaluationRechercheUniversitaireVo){
        return disciplineScientifiqueEvaluationRechercheUniversitaireConverter.toVo(disciplineScientifiqueEvaluationRechercheUniversitaireService.findByCriteria(disciplineScientifiqueEvaluationRechercheUniversitaireVo));
        }

            @ApiOperation("Finds a disciplineScientifiqueEvaluationRechercheUniversitaire by id")
            @GetMapping("/id/{id}")
            public DisciplineScientifiqueEvaluationRechercheUniversitaireVo findById(@PathVariable Long id){
            return disciplineScientifiqueEvaluationRechercheUniversitaireConverter.toVo(disciplineScientifiqueEvaluationRechercheUniversitaireService.findById(id));
            }

            @ApiOperation("Saves the specified  disciplineScientifiqueEvaluationRechercheUniversitaire")
            @PostMapping("/")
            public DisciplineScientifiqueEvaluationRechercheUniversitaireVo save(@RequestBody DisciplineScientifiqueEvaluationRechercheUniversitaireVo disciplineScientifiqueEvaluationRechercheUniversitaireVo){
            DisciplineScientifiqueEvaluationRechercheUniversitaire disciplineScientifiqueEvaluationRechercheUniversitaire = disciplineScientifiqueEvaluationRechercheUniversitaireConverter.toItem(disciplineScientifiqueEvaluationRechercheUniversitaireVo);
            disciplineScientifiqueEvaluationRechercheUniversitaire = disciplineScientifiqueEvaluationRechercheUniversitaireService.save(disciplineScientifiqueEvaluationRechercheUniversitaire);
            return disciplineScientifiqueEvaluationRechercheUniversitaireConverter.toVo(disciplineScientifiqueEvaluationRechercheUniversitaire);
            }

            @ApiOperation("Delete the specified disciplineScientifiqueEvaluationRechercheUniversitaire")
            @DeleteMapping("/")
            public int delete(@RequestBody DisciplineScientifiqueEvaluationRechercheUniversitaireVo disciplineScientifiqueEvaluationRechercheUniversitaireVo){
            DisciplineScientifiqueEvaluationRechercheUniversitaire disciplineScientifiqueEvaluationRechercheUniversitaire = disciplineScientifiqueEvaluationRechercheUniversitaireConverter.toItem(disciplineScientifiqueEvaluationRechercheUniversitaireVo);
            return disciplineScientifiqueEvaluationRechercheUniversitaireService.delete(disciplineScientifiqueEvaluationRechercheUniversitaire);
            }

            @ApiOperation("Deletes a disciplineScientifiqueEvaluationRechercheUniversitaire by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return disciplineScientifiqueEvaluationRechercheUniversitaireService.deleteById(id);
            }


        }
