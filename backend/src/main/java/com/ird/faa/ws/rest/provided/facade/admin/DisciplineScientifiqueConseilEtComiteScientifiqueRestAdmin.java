package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.DisciplineScientifiqueConseilEtComiteScientifiqueAdminService;

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
import com.ird.faa.bean.formulaire.DisciplineScientifiqueConseilEtComiteScientifique;
import com.ird.faa.ws.rest.provided.converter.DisciplineScientifiqueConseilEtComiteScientifiqueConverter;
import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueConseilEtComiteScientifiqueVo;

@Api("Manages disciplineScientifiqueConseilEtComiteScientifique services")
@RestController
@RequestMapping("api/admin/disciplineScientifiqueConseilEtComiteScientifique")
public class DisciplineScientifiqueConseilEtComiteScientifiqueRestAdmin {

@Autowired
private DisciplineScientifiqueConseilEtComiteScientifiqueAdminService disciplineScientifiqueConseilEtComiteScientifiqueService;

@Autowired
private DisciplineScientifiqueConseilEtComiteScientifiqueConverter disciplineScientifiqueConseilEtComiteScientifiqueConverter;


            @ApiOperation("Updates the specified  disciplineScientifiqueConseilEtComiteScientifique")
            @PutMapping("/")
            public  DisciplineScientifiqueConseilEtComiteScientifiqueVo update(@RequestBody  DisciplineScientifiqueConseilEtComiteScientifiqueVo  disciplineScientifiqueConseilEtComiteScientifiqueVo){
            DisciplineScientifiqueConseilEtComiteScientifique disciplineScientifiqueConseilEtComiteScientifique = disciplineScientifiqueConseilEtComiteScientifiqueConverter.toItem(disciplineScientifiqueConseilEtComiteScientifiqueVo);
            disciplineScientifiqueConseilEtComiteScientifique = disciplineScientifiqueConseilEtComiteScientifiqueService.update(disciplineScientifiqueConseilEtComiteScientifique);
            return disciplineScientifiqueConseilEtComiteScientifiqueConverter.toVo(disciplineScientifiqueConseilEtComiteScientifique);
            }

    @ApiOperation("Finds a list of all disciplineScientifiqueConseilEtComiteScientifiques")
    @GetMapping("/")
    public List<DisciplineScientifiqueConseilEtComiteScientifiqueVo> findAll(){
        return disciplineScientifiqueConseilEtComiteScientifiqueConverter.toVo(disciplineScientifiqueConseilEtComiteScientifiqueService.findAll());
    }

    @ApiOperation("Finds a disciplineScientifiqueConseilEtComiteScientifique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DisciplineScientifiqueConseilEtComiteScientifiqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return disciplineScientifiqueConseilEtComiteScientifiqueConverter.toVo(disciplineScientifiqueConseilEtComiteScientifiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search disciplineScientifiqueConseilEtComiteScientifique by a specific criteria")
    @PostMapping("/search")
    public List<DisciplineScientifiqueConseilEtComiteScientifiqueVo> findByCriteria(@RequestBody DisciplineScientifiqueConseilEtComiteScientifiqueVo disciplineScientifiqueConseilEtComiteScientifiqueVo){
        return disciplineScientifiqueConseilEtComiteScientifiqueConverter.toVo(disciplineScientifiqueConseilEtComiteScientifiqueService.findByCriteria(disciplineScientifiqueConseilEtComiteScientifiqueVo));
        }

            @ApiOperation("Finds a disciplineScientifiqueConseilEtComiteScientifique by id")
            @GetMapping("/id/{id}")
            public DisciplineScientifiqueConseilEtComiteScientifiqueVo findById(@PathVariable Long id){
            return disciplineScientifiqueConseilEtComiteScientifiqueConverter.toVo(disciplineScientifiqueConseilEtComiteScientifiqueService.findById(id));
            }

            @ApiOperation("Saves the specified  disciplineScientifiqueConseilEtComiteScientifique")
            @PostMapping("/")
            public DisciplineScientifiqueConseilEtComiteScientifiqueVo save(@RequestBody DisciplineScientifiqueConseilEtComiteScientifiqueVo disciplineScientifiqueConseilEtComiteScientifiqueVo){
            DisciplineScientifiqueConseilEtComiteScientifique disciplineScientifiqueConseilEtComiteScientifique = disciplineScientifiqueConseilEtComiteScientifiqueConverter.toItem(disciplineScientifiqueConseilEtComiteScientifiqueVo);
            disciplineScientifiqueConseilEtComiteScientifique = disciplineScientifiqueConseilEtComiteScientifiqueService.save(disciplineScientifiqueConseilEtComiteScientifique);
            return disciplineScientifiqueConseilEtComiteScientifiqueConverter.toVo(disciplineScientifiqueConseilEtComiteScientifique);
            }

            @ApiOperation("Delete the specified disciplineScientifiqueConseilEtComiteScientifique")
            @DeleteMapping("/")
            public int delete(@RequestBody DisciplineScientifiqueConseilEtComiteScientifiqueVo disciplineScientifiqueConseilEtComiteScientifiqueVo){
            DisciplineScientifiqueConseilEtComiteScientifique disciplineScientifiqueConseilEtComiteScientifique = disciplineScientifiqueConseilEtComiteScientifiqueConverter.toItem(disciplineScientifiqueConseilEtComiteScientifiqueVo);
            return disciplineScientifiqueConseilEtComiteScientifiqueService.delete(disciplineScientifiqueConseilEtComiteScientifique);
            }

            @ApiOperation("Deletes a disciplineScientifiqueConseilEtComiteScientifique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return disciplineScientifiqueConseilEtComiteScientifiqueService.deleteById(id);
            }


        }
