package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.ResponsabilitePedagogiqueMasterAdminService;

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
import com.ird.faa.bean.formulaire.ResponsabilitePedagogiqueMaster;
import com.ird.faa.ws.rest.provided.converter.ResponsabilitePedagogiqueMasterConverter;
import com.ird.faa.ws.rest.provided.vo.ResponsabilitePedagogiqueMasterVo;

@Api("Manages responsabilitePedagogiqueMaster services")
@RestController
@RequestMapping("api/admin/responsabilitePedagogiqueMaster")
public class ResponsabilitePedagogiqueMasterRestAdmin {

@Autowired
private ResponsabilitePedagogiqueMasterAdminService responsabilitePedagogiqueMasterService;

@Autowired
private ResponsabilitePedagogiqueMasterConverter responsabilitePedagogiqueMasterConverter;


            @ApiOperation("Updates the specified  responsabilitePedagogiqueMaster")
            @PutMapping("/")
            public  ResponsabilitePedagogiqueMasterVo update(@RequestBody  ResponsabilitePedagogiqueMasterVo  responsabilitePedagogiqueMasterVo){
            ResponsabilitePedagogiqueMaster responsabilitePedagogiqueMaster = responsabilitePedagogiqueMasterConverter.toItem(responsabilitePedagogiqueMasterVo);
            responsabilitePedagogiqueMaster = responsabilitePedagogiqueMasterService.update(responsabilitePedagogiqueMaster);
            return responsabilitePedagogiqueMasterConverter.toVo(responsabilitePedagogiqueMaster);
            }

    @ApiOperation("Finds a list of all responsabilitePedagogiqueMasters")
    @GetMapping("/")
    public List<ResponsabilitePedagogiqueMasterVo> findAll(){
        return responsabilitePedagogiqueMasterConverter.toVo(responsabilitePedagogiqueMasterService.findAll());
    }

    @ApiOperation("Finds a responsabilitePedagogiqueMaster with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ResponsabilitePedagogiqueMasterVo findByIdWithAssociatedList(@PathVariable Long id){
    return responsabilitePedagogiqueMasterConverter.toVo(responsabilitePedagogiqueMasterService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search responsabilitePedagogiqueMaster by a specific criteria")
    @PostMapping("/search")
    public List<ResponsabilitePedagogiqueMasterVo> findByCriteria(@RequestBody ResponsabilitePedagogiqueMasterVo responsabilitePedagogiqueMasterVo){
        return responsabilitePedagogiqueMasterConverter.toVo(responsabilitePedagogiqueMasterService.findByCriteria(responsabilitePedagogiqueMasterVo));
        }

            @ApiOperation("Finds a responsabilitePedagogiqueMaster by id")
            @GetMapping("/id/{id}")
            public ResponsabilitePedagogiqueMasterVo findById(@PathVariable Long id){
            return responsabilitePedagogiqueMasterConverter.toVo(responsabilitePedagogiqueMasterService.findById(id));
            }

            @ApiOperation("Saves the specified  responsabilitePedagogiqueMaster")
            @PostMapping("/")
            public ResponsabilitePedagogiqueMasterVo save(@RequestBody ResponsabilitePedagogiqueMasterVo responsabilitePedagogiqueMasterVo){
            ResponsabilitePedagogiqueMaster responsabilitePedagogiqueMaster = responsabilitePedagogiqueMasterConverter.toItem(responsabilitePedagogiqueMasterVo);
            responsabilitePedagogiqueMaster = responsabilitePedagogiqueMasterService.save(responsabilitePedagogiqueMaster);
            return responsabilitePedagogiqueMasterConverter.toVo(responsabilitePedagogiqueMaster);
            }

            @ApiOperation("Delete the specified responsabilitePedagogiqueMaster")
            @DeleteMapping("/")
            public int delete(@RequestBody ResponsabilitePedagogiqueMasterVo responsabilitePedagogiqueMasterVo){
            ResponsabilitePedagogiqueMaster responsabilitePedagogiqueMaster = responsabilitePedagogiqueMasterConverter.toItem(responsabilitePedagogiqueMasterVo);
            return responsabilitePedagogiqueMasterService.delete(responsabilitePedagogiqueMaster);
            }

            @ApiOperation("Deletes a responsabilitePedagogiqueMaster by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return responsabilitePedagogiqueMasterService.deleteById(id);
            }


        }
