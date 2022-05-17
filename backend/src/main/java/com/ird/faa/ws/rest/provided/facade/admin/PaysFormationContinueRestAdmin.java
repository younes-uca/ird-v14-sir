package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.PaysFormationContinueAdminService;

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
import com.ird.faa.bean.formulaire.PaysFormationContinue;
import com.ird.faa.ws.rest.provided.converter.PaysFormationContinueConverter;
import com.ird.faa.ws.rest.provided.vo.PaysFormationContinueVo;

@Api("Manages paysFormationContinue services")
@RestController
@RequestMapping("api/admin/paysFormationContinue")
public class PaysFormationContinueRestAdmin {

@Autowired
private PaysFormationContinueAdminService paysFormationContinueService;

@Autowired
private PaysFormationContinueConverter paysFormationContinueConverter;


            @ApiOperation("Updates the specified  paysFormationContinue")
            @PutMapping("/")
            public  PaysFormationContinueVo update(@RequestBody  PaysFormationContinueVo  paysFormationContinueVo){
            PaysFormationContinue paysFormationContinue = paysFormationContinueConverter.toItem(paysFormationContinueVo);
            paysFormationContinue = paysFormationContinueService.update(paysFormationContinue);
            return paysFormationContinueConverter.toVo(paysFormationContinue);
            }

    @ApiOperation("Finds a list of all paysFormationContinues")
    @GetMapping("/")
    public List<PaysFormationContinueVo> findAll(){
        return paysFormationContinueConverter.toVo(paysFormationContinueService.findAll());
    }

    @ApiOperation("Finds a paysFormationContinue with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PaysFormationContinueVo findByIdWithAssociatedList(@PathVariable Long id){
    return paysFormationContinueConverter.toVo(paysFormationContinueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search paysFormationContinue by a specific criteria")
    @PostMapping("/search")
    public List<PaysFormationContinueVo> findByCriteria(@RequestBody PaysFormationContinueVo paysFormationContinueVo){
        return paysFormationContinueConverter.toVo(paysFormationContinueService.findByCriteria(paysFormationContinueVo));
        }

            @ApiOperation("Finds a paysFormationContinue by id")
            @GetMapping("/id/{id}")
            public PaysFormationContinueVo findById(@PathVariable Long id){
            return paysFormationContinueConverter.toVo(paysFormationContinueService.findById(id));
            }

            @ApiOperation("Saves the specified  paysFormationContinue")
            @PostMapping("/")
            public PaysFormationContinueVo save(@RequestBody PaysFormationContinueVo paysFormationContinueVo){
            PaysFormationContinue paysFormationContinue = paysFormationContinueConverter.toItem(paysFormationContinueVo);
            paysFormationContinue = paysFormationContinueService.save(paysFormationContinue);
            return paysFormationContinueConverter.toVo(paysFormationContinue);
            }

            @ApiOperation("Delete the specified paysFormationContinue")
            @DeleteMapping("/")
            public int delete(@RequestBody PaysFormationContinueVo paysFormationContinueVo){
            PaysFormationContinue paysFormationContinue = paysFormationContinueConverter.toItem(paysFormationContinueVo);
            return paysFormationContinueService.delete(paysFormationContinue);
            }

            @ApiOperation("Deletes a paysFormationContinue by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return paysFormationContinueService.deleteById(id);
            }


        }
