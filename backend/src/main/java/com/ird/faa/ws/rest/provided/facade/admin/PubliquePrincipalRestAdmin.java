package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.PubliquePrincipalAdminService;

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
import com.ird.faa.bean.formulaire.PubliquePrincipal;
import com.ird.faa.ws.rest.provided.converter.PubliquePrincipalConverter;
import com.ird.faa.ws.rest.provided.vo.PubliquePrincipalVo;

@Api("Manages publiquePrincipal services")
@RestController
@RequestMapping("api/admin/publiquePrincipal")
public class PubliquePrincipalRestAdmin {

@Autowired
private PubliquePrincipalAdminService publiquePrincipalService;

@Autowired
private PubliquePrincipalConverter publiquePrincipalConverter;


            @ApiOperation("Updates the specified  publiquePrincipal")
            @PutMapping("/")
            public  PubliquePrincipalVo update(@RequestBody  PubliquePrincipalVo  publiquePrincipalVo){
            PubliquePrincipal publiquePrincipal = publiquePrincipalConverter.toItem(publiquePrincipalVo);
            publiquePrincipal = publiquePrincipalService.update(publiquePrincipal);
            return publiquePrincipalConverter.toVo(publiquePrincipal);
            }

    @ApiOperation("Finds a list of all publiquePrincipals")
    @GetMapping("/")
    public List<PubliquePrincipalVo> findAll(){
        return publiquePrincipalConverter.toVo(publiquePrincipalService.findAll());
    }

    @ApiOperation("Finds a publiquePrincipal with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PubliquePrincipalVo findByIdWithAssociatedList(@PathVariable Long id){
    return publiquePrincipalConverter.toVo(publiquePrincipalService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search publiquePrincipal by a specific criteria")
    @PostMapping("/search")
    public List<PubliquePrincipalVo> findByCriteria(@RequestBody PubliquePrincipalVo publiquePrincipalVo){
        return publiquePrincipalConverter.toVo(publiquePrincipalService.findByCriteria(publiquePrincipalVo));
        }

            @ApiOperation("Finds a publiquePrincipal by id")
            @GetMapping("/id/{id}")
            public PubliquePrincipalVo findById(@PathVariable Long id){
            return publiquePrincipalConverter.toVo(publiquePrincipalService.findById(id));
            }

            @ApiOperation("Saves the specified  publiquePrincipal")
            @PostMapping("/")
            public PubliquePrincipalVo save(@RequestBody PubliquePrincipalVo publiquePrincipalVo){
            PubliquePrincipal publiquePrincipal = publiquePrincipalConverter.toItem(publiquePrincipalVo);
            publiquePrincipal = publiquePrincipalService.save(publiquePrincipal);
            return publiquePrincipalConverter.toVo(publiquePrincipal);
            }

            @ApiOperation("Delete the specified publiquePrincipal")
            @DeleteMapping("/")
            public int delete(@RequestBody PubliquePrincipalVo publiquePrincipalVo){
            PubliquePrincipal publiquePrincipal = publiquePrincipalConverter.toItem(publiquePrincipalVo);
            return publiquePrincipalService.delete(publiquePrincipal);
            }

            @ApiOperation("Deletes a publiquePrincipal by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return publiquePrincipalService.deleteById(id);
            }


        }
