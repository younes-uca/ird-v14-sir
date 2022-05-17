package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.DisciplineScientifiqueAdminService;

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
import com.ird.faa.bean.formulaire.DisciplineScientifique;
import com.ird.faa.ws.rest.provided.converter.DisciplineScientifiqueConverter;
import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueVo;

@Api("Manages disciplineScientifique services")
@RestController
@RequestMapping("api/admin/disciplineScientifique")
public class DisciplineScientifiqueRestAdmin {

@Autowired
private DisciplineScientifiqueAdminService disciplineScientifiqueService;

@Autowired
private DisciplineScientifiqueConverter disciplineScientifiqueConverter;


            @ApiOperation("Updates the specified  disciplineScientifique")
            @PutMapping("/")
            public  DisciplineScientifiqueVo update(@RequestBody  DisciplineScientifiqueVo  disciplineScientifiqueVo){
            DisciplineScientifique disciplineScientifique = disciplineScientifiqueConverter.toItem(disciplineScientifiqueVo);
            disciplineScientifique = disciplineScientifiqueService.update(disciplineScientifique);
            return disciplineScientifiqueConverter.toVo(disciplineScientifique);
            }

    @ApiOperation("Finds a list of all disciplineScientifiques")
    @GetMapping("/")
    public List<DisciplineScientifiqueVo> findAll(){
        return disciplineScientifiqueConverter.toVo(disciplineScientifiqueService.findAll());
    }

    @ApiOperation("Finds a disciplineScientifique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DisciplineScientifiqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return disciplineScientifiqueConverter.toVo(disciplineScientifiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search disciplineScientifique by a specific criteria")
    @PostMapping("/search")
    public List<DisciplineScientifiqueVo> findByCriteria(@RequestBody DisciplineScientifiqueVo disciplineScientifiqueVo){
        return disciplineScientifiqueConverter.toVo(disciplineScientifiqueService.findByCriteria(disciplineScientifiqueVo));
        }

            @ApiOperation("Finds a disciplineScientifique by id")
            @GetMapping("/id/{id}")
            public DisciplineScientifiqueVo findById(@PathVariable Long id){
            return disciplineScientifiqueConverter.toVo(disciplineScientifiqueService.findById(id));
            }

            @ApiOperation("Saves the specified  disciplineScientifique")
            @PostMapping("/")
            public DisciplineScientifiqueVo save(@RequestBody DisciplineScientifiqueVo disciplineScientifiqueVo){
            DisciplineScientifique disciplineScientifique = disciplineScientifiqueConverter.toItem(disciplineScientifiqueVo);
            disciplineScientifique = disciplineScientifiqueService.save(disciplineScientifique);
            return disciplineScientifiqueConverter.toVo(disciplineScientifique);
            }

            @ApiOperation("Delete the specified disciplineScientifique")
            @DeleteMapping("/")
            public int delete(@RequestBody DisciplineScientifiqueVo disciplineScientifiqueVo){
            DisciplineScientifique disciplineScientifique = disciplineScientifiqueConverter.toItem(disciplineScientifiqueVo);
            return disciplineScientifiqueService.delete(disciplineScientifique);
            }

            @ApiOperation("Deletes a disciplineScientifique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return disciplineScientifiqueService.deleteById(id);
            }


        }
