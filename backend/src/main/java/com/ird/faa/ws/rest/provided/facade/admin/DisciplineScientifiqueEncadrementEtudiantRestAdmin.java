package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.DisciplineScientifiqueEncadrementEtudiantAdminService;

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
import com.ird.faa.bean.formulaire.DisciplineScientifiqueEncadrementEtudiant;
import com.ird.faa.ws.rest.provided.converter.DisciplineScientifiqueEncadrementEtudiantConverter;
import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueEncadrementEtudiantVo;

@Api("Manages disciplineScientifiqueEncadrementEtudiant services")
@RestController
@RequestMapping("api/admin/disciplineScientifiqueEncadrementEtudiant")
public class DisciplineScientifiqueEncadrementEtudiantRestAdmin {

@Autowired
private DisciplineScientifiqueEncadrementEtudiantAdminService disciplineScientifiqueEncadrementEtudiantService;

@Autowired
private DisciplineScientifiqueEncadrementEtudiantConverter disciplineScientifiqueEncadrementEtudiantConverter;


            @ApiOperation("Updates the specified  disciplineScientifiqueEncadrementEtudiant")
            @PutMapping("/")
            public  DisciplineScientifiqueEncadrementEtudiantVo update(@RequestBody  DisciplineScientifiqueEncadrementEtudiantVo  disciplineScientifiqueEncadrementEtudiantVo){
            DisciplineScientifiqueEncadrementEtudiant disciplineScientifiqueEncadrementEtudiant = disciplineScientifiqueEncadrementEtudiantConverter.toItem(disciplineScientifiqueEncadrementEtudiantVo);
            disciplineScientifiqueEncadrementEtudiant = disciplineScientifiqueEncadrementEtudiantService.update(disciplineScientifiqueEncadrementEtudiant);
            return disciplineScientifiqueEncadrementEtudiantConverter.toVo(disciplineScientifiqueEncadrementEtudiant);
            }

    @ApiOperation("Finds a list of all disciplineScientifiqueEncadrementEtudiants")
    @GetMapping("/")
    public List<DisciplineScientifiqueEncadrementEtudiantVo> findAll(){
        return disciplineScientifiqueEncadrementEtudiantConverter.toVo(disciplineScientifiqueEncadrementEtudiantService.findAll());
    }

    @ApiOperation("Finds a disciplineScientifiqueEncadrementEtudiant with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DisciplineScientifiqueEncadrementEtudiantVo findByIdWithAssociatedList(@PathVariable Long id){
    return disciplineScientifiqueEncadrementEtudiantConverter.toVo(disciplineScientifiqueEncadrementEtudiantService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search disciplineScientifiqueEncadrementEtudiant by a specific criteria")
    @PostMapping("/search")
    public List<DisciplineScientifiqueEncadrementEtudiantVo> findByCriteria(@RequestBody DisciplineScientifiqueEncadrementEtudiantVo disciplineScientifiqueEncadrementEtudiantVo){
        return disciplineScientifiqueEncadrementEtudiantConverter.toVo(disciplineScientifiqueEncadrementEtudiantService.findByCriteria(disciplineScientifiqueEncadrementEtudiantVo));
        }

            @ApiOperation("Finds a disciplineScientifiqueEncadrementEtudiant by id")
            @GetMapping("/id/{id}")
            public DisciplineScientifiqueEncadrementEtudiantVo findById(@PathVariable Long id){
            return disciplineScientifiqueEncadrementEtudiantConverter.toVo(disciplineScientifiqueEncadrementEtudiantService.findById(id));
            }

            @ApiOperation("Saves the specified  disciplineScientifiqueEncadrementEtudiant")
            @PostMapping("/")
            public DisciplineScientifiqueEncadrementEtudiantVo save(@RequestBody DisciplineScientifiqueEncadrementEtudiantVo disciplineScientifiqueEncadrementEtudiantVo){
            DisciplineScientifiqueEncadrementEtudiant disciplineScientifiqueEncadrementEtudiant = disciplineScientifiqueEncadrementEtudiantConverter.toItem(disciplineScientifiqueEncadrementEtudiantVo);
            disciplineScientifiqueEncadrementEtudiant = disciplineScientifiqueEncadrementEtudiantService.save(disciplineScientifiqueEncadrementEtudiant);
            return disciplineScientifiqueEncadrementEtudiantConverter.toVo(disciplineScientifiqueEncadrementEtudiant);
            }

            @ApiOperation("Delete the specified disciplineScientifiqueEncadrementEtudiant")
            @DeleteMapping("/")
            public int delete(@RequestBody DisciplineScientifiqueEncadrementEtudiantVo disciplineScientifiqueEncadrementEtudiantVo){
            DisciplineScientifiqueEncadrementEtudiant disciplineScientifiqueEncadrementEtudiant = disciplineScientifiqueEncadrementEtudiantConverter.toItem(disciplineScientifiqueEncadrementEtudiantVo);
            return disciplineScientifiqueEncadrementEtudiantService.delete(disciplineScientifiqueEncadrementEtudiant);
            }

            @ApiOperation("Deletes a disciplineScientifiqueEncadrementEtudiant by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return disciplineScientifiqueEncadrementEtudiantService.deleteById(id);
            }


        }
