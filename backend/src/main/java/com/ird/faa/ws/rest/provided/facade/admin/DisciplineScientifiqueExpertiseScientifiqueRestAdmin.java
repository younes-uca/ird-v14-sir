package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.DisciplineScientifiqueExpertiseScientifiqueAdminService;

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
import com.ird.faa.bean.formulaire.DisciplineScientifiqueExpertiseScientifique;
import com.ird.faa.ws.rest.provided.converter.DisciplineScientifiqueExpertiseScientifiqueConverter;
import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueExpertiseScientifiqueVo;

@Api("Manages disciplineScientifiqueExpertiseScientifique services")
@RestController
@RequestMapping("api/admin/disciplineScientifiqueExpertiseScientifique")
public class DisciplineScientifiqueExpertiseScientifiqueRestAdmin {

@Autowired
private DisciplineScientifiqueExpertiseScientifiqueAdminService disciplineScientifiqueExpertiseScientifiqueService;

@Autowired
private DisciplineScientifiqueExpertiseScientifiqueConverter disciplineScientifiqueExpertiseScientifiqueConverter;


            @ApiOperation("Updates the specified  disciplineScientifiqueExpertiseScientifique")
            @PutMapping("/")
            public  DisciplineScientifiqueExpertiseScientifiqueVo update(@RequestBody  DisciplineScientifiqueExpertiseScientifiqueVo  disciplineScientifiqueExpertiseScientifiqueVo){
            DisciplineScientifiqueExpertiseScientifique disciplineScientifiqueExpertiseScientifique = disciplineScientifiqueExpertiseScientifiqueConverter.toItem(disciplineScientifiqueExpertiseScientifiqueVo);
            disciplineScientifiqueExpertiseScientifique = disciplineScientifiqueExpertiseScientifiqueService.update(disciplineScientifiqueExpertiseScientifique);
            return disciplineScientifiqueExpertiseScientifiqueConverter.toVo(disciplineScientifiqueExpertiseScientifique);
            }

    @ApiOperation("Finds a list of all disciplineScientifiqueExpertiseScientifiques")
    @GetMapping("/")
    public List<DisciplineScientifiqueExpertiseScientifiqueVo> findAll(){
        return disciplineScientifiqueExpertiseScientifiqueConverter.toVo(disciplineScientifiqueExpertiseScientifiqueService.findAll());
    }

    @ApiOperation("Finds a disciplineScientifiqueExpertiseScientifique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DisciplineScientifiqueExpertiseScientifiqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return disciplineScientifiqueExpertiseScientifiqueConverter.toVo(disciplineScientifiqueExpertiseScientifiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search disciplineScientifiqueExpertiseScientifique by a specific criteria")
    @PostMapping("/search")
    public List<DisciplineScientifiqueExpertiseScientifiqueVo> findByCriteria(@RequestBody DisciplineScientifiqueExpertiseScientifiqueVo disciplineScientifiqueExpertiseScientifiqueVo){
        return disciplineScientifiqueExpertiseScientifiqueConverter.toVo(disciplineScientifiqueExpertiseScientifiqueService.findByCriteria(disciplineScientifiqueExpertiseScientifiqueVo));
        }

            @ApiOperation("Finds a disciplineScientifiqueExpertiseScientifique by id")
            @GetMapping("/id/{id}")
            public DisciplineScientifiqueExpertiseScientifiqueVo findById(@PathVariable Long id){
            return disciplineScientifiqueExpertiseScientifiqueConverter.toVo(disciplineScientifiqueExpertiseScientifiqueService.findById(id));
            }

            @ApiOperation("Saves the specified  disciplineScientifiqueExpertiseScientifique")
            @PostMapping("/")
            public DisciplineScientifiqueExpertiseScientifiqueVo save(@RequestBody DisciplineScientifiqueExpertiseScientifiqueVo disciplineScientifiqueExpertiseScientifiqueVo){
            DisciplineScientifiqueExpertiseScientifique disciplineScientifiqueExpertiseScientifique = disciplineScientifiqueExpertiseScientifiqueConverter.toItem(disciplineScientifiqueExpertiseScientifiqueVo);
            disciplineScientifiqueExpertiseScientifique = disciplineScientifiqueExpertiseScientifiqueService.save(disciplineScientifiqueExpertiseScientifique);
            return disciplineScientifiqueExpertiseScientifiqueConverter.toVo(disciplineScientifiqueExpertiseScientifique);
            }

            @ApiOperation("Delete the specified disciplineScientifiqueExpertiseScientifique")
            @DeleteMapping("/")
            public int delete(@RequestBody DisciplineScientifiqueExpertiseScientifiqueVo disciplineScientifiqueExpertiseScientifiqueVo){
            DisciplineScientifiqueExpertiseScientifique disciplineScientifiqueExpertiseScientifique = disciplineScientifiqueExpertiseScientifiqueConverter.toItem(disciplineScientifiqueExpertiseScientifiqueVo);
            return disciplineScientifiqueExpertiseScientifiqueService.delete(disciplineScientifiqueExpertiseScientifique);
            }

            @ApiOperation("Deletes a disciplineScientifiqueExpertiseScientifique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return disciplineScientifiqueExpertiseScientifiqueService.deleteById(id);
            }


        }
