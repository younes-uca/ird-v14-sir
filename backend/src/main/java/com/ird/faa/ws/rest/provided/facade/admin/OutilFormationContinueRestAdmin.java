package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.OutilFormationContinueAdminService;

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
import com.ird.faa.bean.formulaire.OutilFormationContinue;
import com.ird.faa.ws.rest.provided.converter.OutilFormationContinueConverter;
import com.ird.faa.ws.rest.provided.vo.OutilFormationContinueVo;

@Api("Manages outilFormationContinue services")
@RestController
@RequestMapping("api/admin/outilFormationContinue")
public class OutilFormationContinueRestAdmin {

@Autowired
private OutilFormationContinueAdminService outilFormationContinueService;

@Autowired
private OutilFormationContinueConverter outilFormationContinueConverter;


            @ApiOperation("Updates the specified  outilFormationContinue")
            @PutMapping("/")
            public  OutilFormationContinueVo update(@RequestBody  OutilFormationContinueVo  outilFormationContinueVo){
            OutilFormationContinue outilFormationContinue = outilFormationContinueConverter.toItem(outilFormationContinueVo);
            outilFormationContinue = outilFormationContinueService.update(outilFormationContinue);
            return outilFormationContinueConverter.toVo(outilFormationContinue);
            }

    @ApiOperation("Finds a list of all outilFormationContinues")
    @GetMapping("/")
    public List<OutilFormationContinueVo> findAll(){
        return outilFormationContinueConverter.toVo(outilFormationContinueService.findAll());
    }

    @ApiOperation("Finds a outilFormationContinue with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public OutilFormationContinueVo findByIdWithAssociatedList(@PathVariable Long id){
    return outilFormationContinueConverter.toVo(outilFormationContinueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search outilFormationContinue by a specific criteria")
    @PostMapping("/search")
    public List<OutilFormationContinueVo> findByCriteria(@RequestBody OutilFormationContinueVo outilFormationContinueVo){
        return outilFormationContinueConverter.toVo(outilFormationContinueService.findByCriteria(outilFormationContinueVo));
        }

            @ApiOperation("Finds a outilFormationContinue by id")
            @GetMapping("/id/{id}")
            public OutilFormationContinueVo findById(@PathVariable Long id){
            return outilFormationContinueConverter.toVo(outilFormationContinueService.findById(id));
            }

            @ApiOperation("Saves the specified  outilFormationContinue")
            @PostMapping("/")
            public OutilFormationContinueVo save(@RequestBody OutilFormationContinueVo outilFormationContinueVo){
            OutilFormationContinue outilFormationContinue = outilFormationContinueConverter.toItem(outilFormationContinueVo);
            outilFormationContinue = outilFormationContinueService.save(outilFormationContinue);
            return outilFormationContinueConverter.toVo(outilFormationContinue);
            }

            @ApiOperation("Delete the specified outilFormationContinue")
            @DeleteMapping("/")
            public int delete(@RequestBody OutilFormationContinueVo outilFormationContinueVo){
            OutilFormationContinue outilFormationContinue = outilFormationContinueConverter.toItem(outilFormationContinueVo);
            return outilFormationContinueService.delete(outilFormationContinue);
            }

            @ApiOperation("Deletes a outilFormationContinue by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return outilFormationContinueService.deleteById(id);
            }


        }
