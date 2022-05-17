package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.StatutMasterAdminService;

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
import com.ird.faa.bean.referentiel.StatutMaster;
import com.ird.faa.ws.rest.provided.converter.StatutMasterConverter;
import com.ird.faa.ws.rest.provided.vo.StatutMasterVo;

@Api("Manages statutMaster services")
@RestController
@RequestMapping("api/admin/statutMaster")
public class StatutMasterRestAdmin {

@Autowired
private StatutMasterAdminService statutMasterService;

@Autowired
private StatutMasterConverter statutMasterConverter;


            @ApiOperation("Updates the specified  statutMaster")
            @PutMapping("/")
            public  StatutMasterVo update(@RequestBody  StatutMasterVo  statutMasterVo){
            StatutMaster statutMaster = statutMasterConverter.toItem(statutMasterVo);
            statutMaster = statutMasterService.update(statutMaster);
            return statutMasterConverter.toVo(statutMaster);
            }

    @ApiOperation("Finds a list of all statutMasters")
    @GetMapping("/")
    public List<StatutMasterVo> findAll(){
        return statutMasterConverter.toVo(statutMasterService.findAll());
    }

    @ApiOperation("Finds a statutMaster with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public StatutMasterVo findByIdWithAssociatedList(@PathVariable Long id){
    return statutMasterConverter.toVo(statutMasterService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search statutMaster by a specific criteria")
    @PostMapping("/search")
    public List<StatutMasterVo> findByCriteria(@RequestBody StatutMasterVo statutMasterVo){
        return statutMasterConverter.toVo(statutMasterService.findByCriteria(statutMasterVo));
        }

            @ApiOperation("Finds a statutMaster by id")
            @GetMapping("/id/{id}")
            public StatutMasterVo findById(@PathVariable Long id){
            return statutMasterConverter.toVo(statutMasterService.findById(id));
            }

            @ApiOperation("Saves the specified  statutMaster")
            @PostMapping("/")
            public StatutMasterVo save(@RequestBody StatutMasterVo statutMasterVo){
            StatutMaster statutMaster = statutMasterConverter.toItem(statutMasterVo);
            statutMaster = statutMasterService.save(statutMaster);
            return statutMasterConverter.toVo(statutMaster);
            }

            @ApiOperation("Delete the specified statutMaster")
            @DeleteMapping("/")
            public int delete(@RequestBody StatutMasterVo statutMasterVo){
            StatutMaster statutMaster = statutMasterConverter.toItem(statutMasterVo);
            return statutMasterService.delete(statutMaster);
            }

            @ApiOperation("Deletes a statutMaster by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return statutMasterService.deleteById(id);
            }


        }
