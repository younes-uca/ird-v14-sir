package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.ReclamationAdminService;

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
import com.ird.faa.bean.formulaire.Reclamation;
import com.ird.faa.ws.rest.provided.converter.ReclamationConverter;
import com.ird.faa.ws.rest.provided.vo.ReclamationVo;

@Api("Manages reclamation services")
@RestController
@RequestMapping("api/admin/reclamation")
public class ReclamationRestAdmin {

@Autowired
private ReclamationAdminService reclamationService;

@Autowired
private ReclamationConverter reclamationConverter;


            @ApiOperation("Updates the specified  reclamation")
            @PutMapping("/")
            public  ReclamationVo update(@RequestBody  ReclamationVo  reclamationVo){
            Reclamation reclamation = reclamationConverter.toItem(reclamationVo);
            reclamation = reclamationService.update(reclamation);
            return reclamationConverter.toVo(reclamation);
            }

    @ApiOperation("Finds a list of all reclamations")
    @GetMapping("/")
    public List<ReclamationVo> findAll(){
        return reclamationConverter.toVo(reclamationService.findAll());
    }

    @ApiOperation("Finds a reclamation with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ReclamationVo findByIdWithAssociatedList(@PathVariable Long id){
    return reclamationConverter.toVo(reclamationService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search reclamation by a specific criteria")
    @PostMapping("/search")
    public List<ReclamationVo> findByCriteria(@RequestBody ReclamationVo reclamationVo){
        return reclamationConverter.toVo(reclamationService.findByCriteria(reclamationVo));
        }

            @ApiOperation("Finds a reclamation by id")
            @GetMapping("/id/{id}")
            public ReclamationVo findById(@PathVariable Long id){
            return reclamationConverter.toVo(reclamationService.findById(id));
            }

            @ApiOperation("Saves the specified  reclamation")
            @PostMapping("/")
            public ReclamationVo save(@RequestBody ReclamationVo reclamationVo){
            Reclamation reclamation = reclamationConverter.toItem(reclamationVo);
            reclamation = reclamationService.save(reclamation);
            return reclamationConverter.toVo(reclamation);
            }

            @ApiOperation("Delete the specified reclamation")
            @DeleteMapping("/")
            public int delete(@RequestBody ReclamationVo reclamationVo){
            Reclamation reclamation = reclamationConverter.toItem(reclamationVo);
            return reclamationService.delete(reclamation);
            }

            @ApiOperation("Deletes a reclamation by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return reclamationService.deleteById(id);
            }


        }
