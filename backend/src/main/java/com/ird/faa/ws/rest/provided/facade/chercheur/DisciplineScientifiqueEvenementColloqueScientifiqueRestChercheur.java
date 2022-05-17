package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.formulaire.DisciplineScientifiqueEvenementColloqueScientifiqueChercheurService;

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
import com.ird.faa.bean.formulaire.DisciplineScientifiqueEvenementColloqueScientifique;
import com.ird.faa.ws.rest.provided.converter.DisciplineScientifiqueEvenementColloqueScientifiqueConverter;
import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueEvenementColloqueScientifiqueVo;

@Api("Manages disciplineScientifiqueEvenementColloqueScientifique services")
@RestController
@RequestMapping("api/chercheur/disciplineScientifiqueEvenementColloqueScientifique")
public class DisciplineScientifiqueEvenementColloqueScientifiqueRestChercheur {

@Autowired
private DisciplineScientifiqueEvenementColloqueScientifiqueChercheurService disciplineScientifiqueEvenementColloqueScientifiqueService;

@Autowired
private DisciplineScientifiqueEvenementColloqueScientifiqueConverter disciplineScientifiqueEvenementColloqueScientifiqueConverter;


            @ApiOperation("Updates the specified  disciplineScientifiqueEvenementColloqueScientifique")
            @PutMapping("/")
            public  DisciplineScientifiqueEvenementColloqueScientifiqueVo update(@RequestBody  DisciplineScientifiqueEvenementColloqueScientifiqueVo  disciplineScientifiqueEvenementColloqueScientifiqueVo){
            DisciplineScientifiqueEvenementColloqueScientifique disciplineScientifiqueEvenementColloqueScientifique = disciplineScientifiqueEvenementColloqueScientifiqueConverter.toItem(disciplineScientifiqueEvenementColloqueScientifiqueVo);
            disciplineScientifiqueEvenementColloqueScientifique = disciplineScientifiqueEvenementColloqueScientifiqueService.update(disciplineScientifiqueEvenementColloqueScientifique);
            return disciplineScientifiqueEvenementColloqueScientifiqueConverter.toVo(disciplineScientifiqueEvenementColloqueScientifique);
            }

    @ApiOperation("Finds a list of all disciplineScientifiqueEvenementColloqueScientifiques")
    @GetMapping("/")
    public List<DisciplineScientifiqueEvenementColloqueScientifiqueVo> findAll(){
        return disciplineScientifiqueEvenementColloqueScientifiqueConverter.toVo(disciplineScientifiqueEvenementColloqueScientifiqueService.findAll());
    }

    @ApiOperation("Finds a disciplineScientifiqueEvenementColloqueScientifique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DisciplineScientifiqueEvenementColloqueScientifiqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return disciplineScientifiqueEvenementColloqueScientifiqueConverter.toVo(disciplineScientifiqueEvenementColloqueScientifiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search disciplineScientifiqueEvenementColloqueScientifique by a specific criteria")
    @PostMapping("/search")
    public List<DisciplineScientifiqueEvenementColloqueScientifiqueVo> findByCriteria(@RequestBody DisciplineScientifiqueEvenementColloqueScientifiqueVo disciplineScientifiqueEvenementColloqueScientifiqueVo){
        return disciplineScientifiqueEvenementColloqueScientifiqueConverter.toVo(disciplineScientifiqueEvenementColloqueScientifiqueService.findByCriteria(disciplineScientifiqueEvenementColloqueScientifiqueVo));
        }

            @ApiOperation("Finds a disciplineScientifiqueEvenementColloqueScientifique by id")
            @GetMapping("/id/{id}")
            public DisciplineScientifiqueEvenementColloqueScientifiqueVo findById(@PathVariable Long id){
            return disciplineScientifiqueEvenementColloqueScientifiqueConverter.toVo(disciplineScientifiqueEvenementColloqueScientifiqueService.findById(id));
            }

            @ApiOperation("Saves the specified  disciplineScientifiqueEvenementColloqueScientifique")
            @PostMapping("/")
            public DisciplineScientifiqueEvenementColloqueScientifiqueVo save(@RequestBody DisciplineScientifiqueEvenementColloqueScientifiqueVo disciplineScientifiqueEvenementColloqueScientifiqueVo){
            DisciplineScientifiqueEvenementColloqueScientifique disciplineScientifiqueEvenementColloqueScientifique = disciplineScientifiqueEvenementColloqueScientifiqueConverter.toItem(disciplineScientifiqueEvenementColloqueScientifiqueVo);
            disciplineScientifiqueEvenementColloqueScientifique = disciplineScientifiqueEvenementColloqueScientifiqueService.save(disciplineScientifiqueEvenementColloqueScientifique);
            return disciplineScientifiqueEvenementColloqueScientifiqueConverter.toVo(disciplineScientifiqueEvenementColloqueScientifique);
            }

            @ApiOperation("Delete the specified disciplineScientifiqueEvenementColloqueScientifique")
            @DeleteMapping("/")
            public int delete(@RequestBody DisciplineScientifiqueEvenementColloqueScientifiqueVo disciplineScientifiqueEvenementColloqueScientifiqueVo){
            DisciplineScientifiqueEvenementColloqueScientifique disciplineScientifiqueEvenementColloqueScientifique = disciplineScientifiqueEvenementColloqueScientifiqueConverter.toItem(disciplineScientifiqueEvenementColloqueScientifiqueVo);
            return disciplineScientifiqueEvenementColloqueScientifiqueService.delete(disciplineScientifiqueEvenementColloqueScientifique);
            }

            @ApiOperation("Deletes a disciplineScientifiqueEvenementColloqueScientifique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return disciplineScientifiqueEvenementColloqueScientifiqueService.deleteById(id);
            }


        }
