package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.ExpertiseScientifiqueAdminService;

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
import com.ird.faa.bean.formulaire.ExpertiseScientifique;
import com.ird.faa.ws.rest.provided.converter.ExpertiseScientifiqueConverter;
import com.ird.faa.ws.rest.provided.vo.ExpertiseScientifiqueVo;

@Api("Manages expertiseScientifique services")
@RestController
@RequestMapping("api/admin/expertiseScientifique")
public class ExpertiseScientifiqueRestAdmin {

@Autowired
private ExpertiseScientifiqueAdminService expertiseScientifiqueService;

@Autowired
private ExpertiseScientifiqueConverter expertiseScientifiqueConverter;


            @ApiOperation("Updates the specified  expertiseScientifique")
            @PutMapping("/")
            public  ExpertiseScientifiqueVo update(@RequestBody  ExpertiseScientifiqueVo  expertiseScientifiqueVo){
            ExpertiseScientifique expertiseScientifique = expertiseScientifiqueConverter.toItem(expertiseScientifiqueVo);
            expertiseScientifique = expertiseScientifiqueService.update(expertiseScientifique);
            return expertiseScientifiqueConverter.toVo(expertiseScientifique);
            }

    @ApiOperation("Finds a list of all expertiseScientifiques")
    @GetMapping("/")
    public List<ExpertiseScientifiqueVo> findAll(){
        return expertiseScientifiqueConverter.toVo(expertiseScientifiqueService.findAll());
    }

    @ApiOperation("Finds a expertiseScientifique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ExpertiseScientifiqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return expertiseScientifiqueConverter.toVo(expertiseScientifiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search expertiseScientifique by a specific criteria")
    @PostMapping("/search")
    public List<ExpertiseScientifiqueVo> findByCriteria(@RequestBody ExpertiseScientifiqueVo expertiseScientifiqueVo){
        return expertiseScientifiqueConverter.toVo(expertiseScientifiqueService.findByCriteria(expertiseScientifiqueVo));
        }

            @ApiOperation("Finds a expertiseScientifique by id")
            @GetMapping("/id/{id}")
            public ExpertiseScientifiqueVo findById(@PathVariable Long id){
            return expertiseScientifiqueConverter.toVo(expertiseScientifiqueService.findById(id));
            }

            @ApiOperation("Saves the specified  expertiseScientifique")
            @PostMapping("/")
            public ExpertiseScientifiqueVo save(@RequestBody ExpertiseScientifiqueVo expertiseScientifiqueVo){
            ExpertiseScientifique expertiseScientifique = expertiseScientifiqueConverter.toItem(expertiseScientifiqueVo);
            expertiseScientifique = expertiseScientifiqueService.save(expertiseScientifique);
            return expertiseScientifiqueConverter.toVo(expertiseScientifique);
            }

            @ApiOperation("Delete the specified expertiseScientifique")
            @DeleteMapping("/")
            public int delete(@RequestBody ExpertiseScientifiqueVo expertiseScientifiqueVo){
            ExpertiseScientifique expertiseScientifique = expertiseScientifiqueConverter.toItem(expertiseScientifiqueVo);
            return expertiseScientifiqueService.delete(expertiseScientifique);
            }

            @ApiOperation("Deletes a expertiseScientifique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return expertiseScientifiqueService.deleteById(id);
            }


        }
