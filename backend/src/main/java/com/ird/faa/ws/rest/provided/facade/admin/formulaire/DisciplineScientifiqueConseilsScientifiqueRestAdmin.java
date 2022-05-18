package main.java.com.ird.faa.ws.rest.provided.facade.admin.formulaire;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueConseilsScientifique;
import com.ird.faa.service.admin.facade.formulaire.DisciplineScientifiqueConseilsScientifiqueAdminService;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.DisciplineScientifiqueConseilsScientifiqueConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.DisciplineScientifiqueConseilsScientifiqueVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages disciplineScientifiqueConseilsScientifique services")
@RestController
@RequestMapping("api/admin/disciplineScientifiqueConseilsScientifique")
public class DisciplineScientifiqueConseilsScientifiqueRestAdmin {

@Autowired
private DisciplineScientifiqueConseilsScientifiqueAdminService disciplineScientifiqueConseilsScientifiqueService;

@Autowired
private DisciplineScientifiqueConseilsScientifiqueConverter disciplineScientifiqueConseilsScientifiqueConverter;


            @ApiOperation("Updates the specified  disciplineScientifiqueConseilsScientifique")
            @PutMapping("/")
            public  DisciplineScientifiqueConseilsScientifiqueVo update(@RequestBody  DisciplineScientifiqueConseilsScientifiqueVo  disciplineScientifiqueConseilsScientifiqueVo){
            DisciplineScientifiqueConseilsScientifique disciplineScientifiqueConseilsScientifique = disciplineScientifiqueConseilsScientifiqueConverter.toItem(disciplineScientifiqueConseilsScientifiqueVo);
            disciplineScientifiqueConseilsScientifique = disciplineScientifiqueConseilsScientifiqueService.update(disciplineScientifiqueConseilsScientifique);
            return disciplineScientifiqueConseilsScientifiqueConverter.toVo(disciplineScientifiqueConseilsScientifique);
            }

    @ApiOperation("Finds a list of all disciplineScientifiqueConseilsScientifiques")
    @GetMapping("/")
    public List<DisciplineScientifiqueConseilsScientifiqueVo> findAll(){
        return disciplineScientifiqueConseilsScientifiqueConverter.toVo(disciplineScientifiqueConseilsScientifiqueService.findAll());
    }

    @ApiOperation("Finds a disciplineScientifiqueConseilsScientifique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DisciplineScientifiqueConseilsScientifiqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return disciplineScientifiqueConseilsScientifiqueConverter.toVo(disciplineScientifiqueConseilsScientifiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search disciplineScientifiqueConseilsScientifique by a specific criteria")
    @PostMapping("/search")
    public List<DisciplineScientifiqueConseilsScientifiqueVo> findByCriteria(@RequestBody DisciplineScientifiqueConseilsScientifiqueVo disciplineScientifiqueConseilsScientifiqueVo){
        return disciplineScientifiqueConseilsScientifiqueConverter.toVo(disciplineScientifiqueConseilsScientifiqueService.findByCriteria(disciplineScientifiqueConseilsScientifiqueVo));
        }

            @ApiOperation("Finds a disciplineScientifiqueConseilsScientifique by id")
            @GetMapping("/id/{id}")
            public DisciplineScientifiqueConseilsScientifiqueVo findById(@PathVariable Long id){
            return disciplineScientifiqueConseilsScientifiqueConverter.toVo(disciplineScientifiqueConseilsScientifiqueService.findById(id));
            }

            @ApiOperation("Saves the specified  disciplineScientifiqueConseilsScientifique")
            @PostMapping("/")
            public DisciplineScientifiqueConseilsScientifiqueVo save(@RequestBody DisciplineScientifiqueConseilsScientifiqueVo disciplineScientifiqueConseilsScientifiqueVo){
            DisciplineScientifiqueConseilsScientifique disciplineScientifiqueConseilsScientifique = disciplineScientifiqueConseilsScientifiqueConverter.toItem(disciplineScientifiqueConseilsScientifiqueVo);
            disciplineScientifiqueConseilsScientifique = disciplineScientifiqueConseilsScientifiqueService.save(disciplineScientifiqueConseilsScientifique);
            return disciplineScientifiqueConseilsScientifiqueConverter.toVo(disciplineScientifiqueConseilsScientifique);
            }

            @ApiOperation("Delete the specified disciplineScientifiqueConseilsScientifique")
            @DeleteMapping("/")
            public int delete(@RequestBody DisciplineScientifiqueConseilsScientifiqueVo disciplineScientifiqueConseilsScientifiqueVo){
            DisciplineScientifiqueConseilsScientifique disciplineScientifiqueConseilsScientifique = disciplineScientifiqueConseilsScientifiqueConverter.toItem(disciplineScientifiqueConseilsScientifiqueVo);
            return disciplineScientifiqueConseilsScientifiqueService.delete(disciplineScientifiqueConseilsScientifique);
            }

            @ApiOperation("Deletes a disciplineScientifiqueConseilsScientifique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return disciplineScientifiqueConseilsScientifiqueService.deleteById(id);
            }
        @ApiOperation("find by conseilsScientifique id")
        @GetMapping("/conseilsScientifique/id/{id}")
        public List<DisciplineScientifiqueConseilsScientifique> findByConseilsScientifiqueId(@PathVariable Long id){
        return disciplineScientifiqueConseilsScientifiqueService.findByConseilsScientifiqueId(id);
        }

        @ApiOperation("delete by conseilsScientifique id")
        @DeleteMapping("/conseilsScientifique/id/{id}")
        public int deleteByConseilsScientifiqueId(@PathVariable Long id){
        return disciplineScientifiqueConseilsScientifiqueService.deleteByConseilsScientifiqueId(id);
        }

        @ApiOperation("find by disciplineScientifique code")
        @GetMapping("/disciplineScientifique/code/{code}")
        public List<DisciplineScientifiqueConseilsScientifique> findByDisciplineScientifiqueCode(@PathVariable String code){
        return disciplineScientifiqueConseilsScientifiqueService.findByDisciplineScientifiqueCode(code);
        }

        @ApiOperation("delete by disciplineScientifique code")
        @DeleteMapping("/disciplineScientifique/code/{code}")
        public int deleteByDisciplineScientifiqueCode(@PathVariable String code){
        return disciplineScientifiqueConseilsScientifiqueService.deleteByDisciplineScientifiqueCode(code);
        }

        @ApiOperation("find by disciplineScientifique id")
        @GetMapping("/disciplineScientifique/id/{id}")
        public List<DisciplineScientifiqueConseilsScientifique> findByDisciplineScientifiqueId(@PathVariable Long id){
        return disciplineScientifiqueConseilsScientifiqueService.findByDisciplineScientifiqueId(id);
        }

        @ApiOperation("delete by disciplineScientifique id")
        @DeleteMapping("/disciplineScientifique/id/{id}")
        public int deleteByDisciplineScientifiqueId(@PathVariable Long id){
        return disciplineScientifiqueConseilsScientifiqueService.deleteByDisciplineScientifiqueId(id);
        }





            }
