package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.PublicCibleAdminService;

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
import com.ird.faa.bean.formulaire.PublicCible;
import com.ird.faa.ws.rest.provided.converter.PublicCibleConverter;
import com.ird.faa.ws.rest.provided.vo.PublicCibleVo;

@Api("Manages publicCible services")
@RestController
@RequestMapping("api/admin/publicCible")
public class PublicCibleRestAdmin {

@Autowired
private PublicCibleAdminService publicCibleService;

@Autowired
private PublicCibleConverter publicCibleConverter;


            @ApiOperation("Updates the specified  publicCible")
            @PutMapping("/")
            public  PublicCibleVo update(@RequestBody  PublicCibleVo  publicCibleVo){
            PublicCible publicCible = publicCibleConverter.toItem(publicCibleVo);
            publicCible = publicCibleService.update(publicCible);
            return publicCibleConverter.toVo(publicCible);
            }

    @ApiOperation("Finds a list of all publicCibles")
    @GetMapping("/")
    public List<PublicCibleVo> findAll(){
        return publicCibleConverter.toVo(publicCibleService.findAll());
    }

    @ApiOperation("Finds a publicCible with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PublicCibleVo findByIdWithAssociatedList(@PathVariable Long id){
    return publicCibleConverter.toVo(publicCibleService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search publicCible by a specific criteria")
    @PostMapping("/search")
    public List<PublicCibleVo> findByCriteria(@RequestBody PublicCibleVo publicCibleVo){
        return publicCibleConverter.toVo(publicCibleService.findByCriteria(publicCibleVo));
        }

            @ApiOperation("Finds a publicCible by id")
            @GetMapping("/id/{id}")
            public PublicCibleVo findById(@PathVariable Long id){
            return publicCibleConverter.toVo(publicCibleService.findById(id));
            }

            @ApiOperation("Saves the specified  publicCible")
            @PostMapping("/")
            public PublicCibleVo save(@RequestBody PublicCibleVo publicCibleVo){
            PublicCible publicCible = publicCibleConverter.toItem(publicCibleVo);
            publicCible = publicCibleService.save(publicCible);
            return publicCibleConverter.toVo(publicCible);
            }

            @ApiOperation("Delete the specified publicCible")
            @DeleteMapping("/")
            public int delete(@RequestBody PublicCibleVo publicCibleVo){
            PublicCible publicCible = publicCibleConverter.toItem(publicCibleVo);
            return publicCibleService.delete(publicCible);
            }

            @ApiOperation("Deletes a publicCible by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return publicCibleService.deleteById(id);
            }


        }
