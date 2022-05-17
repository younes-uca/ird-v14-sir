package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.ContexteCultureScientifiqueRecontreGrandPublicJeunePublicAdminService;

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
import com.ird.faa.bean.formulaire.ContexteCultureScientifiqueRecontreGrandPublicJeunePublic;
import com.ird.faa.ws.rest.provided.converter.ContexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter;
import com.ird.faa.ws.rest.provided.vo.ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo;

@Api("Manages contexteCultureScientifiqueRecontreGrandPublicJeunePublic services")
@RestController
@RequestMapping("api/admin/contexteCultureScientifiqueRecontreGrandPublicJeunePublic")
public class ContexteCultureScientifiqueRecontreGrandPublicJeunePublicRestAdmin {

@Autowired
private ContexteCultureScientifiqueRecontreGrandPublicJeunePublicAdminService contexteCultureScientifiqueRecontreGrandPublicJeunePublicService;

@Autowired
private ContexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter;


            @ApiOperation("Updates the specified  contexteCultureScientifiqueRecontreGrandPublicJeunePublic")
            @PutMapping("/")
            public  ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo update(@RequestBody  ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo  contexteCultureScientifiqueRecontreGrandPublicJeunePublicVo){
            ContexteCultureScientifiqueRecontreGrandPublicJeunePublic contexteCultureScientifiqueRecontreGrandPublicJeunePublic = contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(contexteCultureScientifiqueRecontreGrandPublicJeunePublicVo);
            contexteCultureScientifiqueRecontreGrandPublicJeunePublic = contexteCultureScientifiqueRecontreGrandPublicJeunePublicService.update(contexteCultureScientifiqueRecontreGrandPublicJeunePublic);
            return contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(contexteCultureScientifiqueRecontreGrandPublicJeunePublic);
            }

    @ApiOperation("Finds a list of all contexteCultureScientifiqueRecontreGrandPublicJeunePublics")
    @GetMapping("/")
    public List<ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo> findAll(){
        return contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(contexteCultureScientifiqueRecontreGrandPublicJeunePublicService.findAll());
    }

    @ApiOperation("Finds a contexteCultureScientifiqueRecontreGrandPublicJeunePublic with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo findByIdWithAssociatedList(@PathVariable Long id){
    return contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(contexteCultureScientifiqueRecontreGrandPublicJeunePublicService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search contexteCultureScientifiqueRecontreGrandPublicJeunePublic by a specific criteria")
    @PostMapping("/search")
    public List<ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo> findByCriteria(@RequestBody ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo contexteCultureScientifiqueRecontreGrandPublicJeunePublicVo){
        return contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(contexteCultureScientifiqueRecontreGrandPublicJeunePublicService.findByCriteria(contexteCultureScientifiqueRecontreGrandPublicJeunePublicVo));
        }

            @ApiOperation("Finds a contexteCultureScientifiqueRecontreGrandPublicJeunePublic by id")
            @GetMapping("/id/{id}")
            public ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo findById(@PathVariable Long id){
            return contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(contexteCultureScientifiqueRecontreGrandPublicJeunePublicService.findById(id));
            }

            @ApiOperation("Saves the specified  contexteCultureScientifiqueRecontreGrandPublicJeunePublic")
            @PostMapping("/")
            public ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo save(@RequestBody ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo contexteCultureScientifiqueRecontreGrandPublicJeunePublicVo){
            ContexteCultureScientifiqueRecontreGrandPublicJeunePublic contexteCultureScientifiqueRecontreGrandPublicJeunePublic = contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(contexteCultureScientifiqueRecontreGrandPublicJeunePublicVo);
            contexteCultureScientifiqueRecontreGrandPublicJeunePublic = contexteCultureScientifiqueRecontreGrandPublicJeunePublicService.save(contexteCultureScientifiqueRecontreGrandPublicJeunePublic);
            return contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(contexteCultureScientifiqueRecontreGrandPublicJeunePublic);
            }

            @ApiOperation("Delete the specified contexteCultureScientifiqueRecontreGrandPublicJeunePublic")
            @DeleteMapping("/")
            public int delete(@RequestBody ContexteCultureScientifiqueRecontreGrandPublicJeunePublicVo contexteCultureScientifiqueRecontreGrandPublicJeunePublicVo){
            ContexteCultureScientifiqueRecontreGrandPublicJeunePublic contexteCultureScientifiqueRecontreGrandPublicJeunePublic = contexteCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(contexteCultureScientifiqueRecontreGrandPublicJeunePublicVo);
            return contexteCultureScientifiqueRecontreGrandPublicJeunePublicService.delete(contexteCultureScientifiqueRecontreGrandPublicJeunePublic);
            }

            @ApiOperation("Deletes a contexteCultureScientifiqueRecontreGrandPublicJeunePublic by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return contexteCultureScientifiqueRecontreGrandPublicJeunePublicService.deleteById(id);
            }


        }
