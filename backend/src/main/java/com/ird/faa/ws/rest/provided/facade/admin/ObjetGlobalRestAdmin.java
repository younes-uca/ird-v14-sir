package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.ObjetGlobalAdminService;

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
import com.ird.faa.bean.referentiel.ObjetGlobal;
import com.ird.faa.ws.rest.provided.converter.ObjetGlobalConverter;
import com.ird.faa.ws.rest.provided.vo.ObjetGlobalVo;

@Api("Manages objetGlobal services")
@RestController
@RequestMapping("api/admin/objetGlobal")
public class ObjetGlobalRestAdmin {

@Autowired
private ObjetGlobalAdminService objetGlobalService;

@Autowired
private ObjetGlobalConverter objetGlobalConverter;


            @ApiOperation("Updates the specified  objetGlobal")
            @PutMapping("/")
            public  ObjetGlobalVo update(@RequestBody  ObjetGlobalVo  objetGlobalVo){
            ObjetGlobal objetGlobal = objetGlobalConverter.toItem(objetGlobalVo);
            objetGlobal = objetGlobalService.update(objetGlobal);
            return objetGlobalConverter.toVo(objetGlobal);
            }

    @ApiOperation("Finds a list of all objetGlobals")
    @GetMapping("/")
    public List<ObjetGlobalVo> findAll(){
        return objetGlobalConverter.toVo(objetGlobalService.findAll());
    }

    @ApiOperation("Finds a objetGlobal with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ObjetGlobalVo findByIdWithAssociatedList(@PathVariable Long id){
    return objetGlobalConverter.toVo(objetGlobalService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search objetGlobal by a specific criteria")
    @PostMapping("/search")
    public List<ObjetGlobalVo> findByCriteria(@RequestBody ObjetGlobalVo objetGlobalVo){
        return objetGlobalConverter.toVo(objetGlobalService.findByCriteria(objetGlobalVo));
        }

            @ApiOperation("Finds a objetGlobal by id")
            @GetMapping("/id/{id}")
            public ObjetGlobalVo findById(@PathVariable Long id){
            return objetGlobalConverter.toVo(objetGlobalService.findById(id));
            }

            @ApiOperation("Saves the specified  objetGlobal")
            @PostMapping("/")
            public ObjetGlobalVo save(@RequestBody ObjetGlobalVo objetGlobalVo){
            ObjetGlobal objetGlobal = objetGlobalConverter.toItem(objetGlobalVo);
            objetGlobal = objetGlobalService.save(objetGlobal);
            return objetGlobalConverter.toVo(objetGlobal);
            }

            @ApiOperation("Delete the specified objetGlobal")
            @DeleteMapping("/")
            public int delete(@RequestBody ObjetGlobalVo objetGlobalVo){
            ObjetGlobal objetGlobal = objetGlobalConverter.toItem(objetGlobalVo);
            return objetGlobalService.delete(objetGlobal);
            }

            @ApiOperation("Deletes a objetGlobal by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return objetGlobalService.deleteById(id);
            }


        }
