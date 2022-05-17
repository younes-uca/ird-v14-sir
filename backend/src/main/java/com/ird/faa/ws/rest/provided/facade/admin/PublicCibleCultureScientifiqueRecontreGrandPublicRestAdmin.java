package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.PublicCibleCultureScientifiqueRecontreGrandPublicAdminService;

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
import com.ird.faa.bean.formulaire.PublicCibleCultureScientifiqueRecontreGrandPublic;
import com.ird.faa.ws.rest.provided.converter.PublicCibleCultureScientifiqueRecontreGrandPublicConverter;
import com.ird.faa.ws.rest.provided.vo.PublicCibleCultureScientifiqueRecontreGrandPublicVo;

@Api("Manages publicCibleCultureScientifiqueRecontreGrandPublic services")
@RestController
@RequestMapping("api/admin/publicCibleCultureScientifiqueRecontreGrandPublic")
public class PublicCibleCultureScientifiqueRecontreGrandPublicRestAdmin {

@Autowired
private PublicCibleCultureScientifiqueRecontreGrandPublicAdminService publicCibleCultureScientifiqueRecontreGrandPublicService;

@Autowired
private PublicCibleCultureScientifiqueRecontreGrandPublicConverter publicCibleCultureScientifiqueRecontreGrandPublicConverter;


            @ApiOperation("Updates the specified  publicCibleCultureScientifiqueRecontreGrandPublic")
            @PutMapping("/")
            public  PublicCibleCultureScientifiqueRecontreGrandPublicVo update(@RequestBody  PublicCibleCultureScientifiqueRecontreGrandPublicVo  publicCibleCultureScientifiqueRecontreGrandPublicVo){
            PublicCibleCultureScientifiqueRecontreGrandPublic publicCibleCultureScientifiqueRecontreGrandPublic = publicCibleCultureScientifiqueRecontreGrandPublicConverter.toItem(publicCibleCultureScientifiqueRecontreGrandPublicVo);
            publicCibleCultureScientifiqueRecontreGrandPublic = publicCibleCultureScientifiqueRecontreGrandPublicService.update(publicCibleCultureScientifiqueRecontreGrandPublic);
            return publicCibleCultureScientifiqueRecontreGrandPublicConverter.toVo(publicCibleCultureScientifiqueRecontreGrandPublic);
            }

    @ApiOperation("Finds a list of all publicCibleCultureScientifiqueRecontreGrandPublics")
    @GetMapping("/")
    public List<PublicCibleCultureScientifiqueRecontreGrandPublicVo> findAll(){
        return publicCibleCultureScientifiqueRecontreGrandPublicConverter.toVo(publicCibleCultureScientifiqueRecontreGrandPublicService.findAll());
    }

    @ApiOperation("Finds a publicCibleCultureScientifiqueRecontreGrandPublic with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PublicCibleCultureScientifiqueRecontreGrandPublicVo findByIdWithAssociatedList(@PathVariable Long id){
    return publicCibleCultureScientifiqueRecontreGrandPublicConverter.toVo(publicCibleCultureScientifiqueRecontreGrandPublicService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search publicCibleCultureScientifiqueRecontreGrandPublic by a specific criteria")
    @PostMapping("/search")
    public List<PublicCibleCultureScientifiqueRecontreGrandPublicVo> findByCriteria(@RequestBody PublicCibleCultureScientifiqueRecontreGrandPublicVo publicCibleCultureScientifiqueRecontreGrandPublicVo){
        return publicCibleCultureScientifiqueRecontreGrandPublicConverter.toVo(publicCibleCultureScientifiqueRecontreGrandPublicService.findByCriteria(publicCibleCultureScientifiqueRecontreGrandPublicVo));
        }

            @ApiOperation("Finds a publicCibleCultureScientifiqueRecontreGrandPublic by id")
            @GetMapping("/id/{id}")
            public PublicCibleCultureScientifiqueRecontreGrandPublicVo findById(@PathVariable Long id){
            return publicCibleCultureScientifiqueRecontreGrandPublicConverter.toVo(publicCibleCultureScientifiqueRecontreGrandPublicService.findById(id));
            }

            @ApiOperation("Saves the specified  publicCibleCultureScientifiqueRecontreGrandPublic")
            @PostMapping("/")
            public PublicCibleCultureScientifiqueRecontreGrandPublicVo save(@RequestBody PublicCibleCultureScientifiqueRecontreGrandPublicVo publicCibleCultureScientifiqueRecontreGrandPublicVo){
            PublicCibleCultureScientifiqueRecontreGrandPublic publicCibleCultureScientifiqueRecontreGrandPublic = publicCibleCultureScientifiqueRecontreGrandPublicConverter.toItem(publicCibleCultureScientifiqueRecontreGrandPublicVo);
            publicCibleCultureScientifiqueRecontreGrandPublic = publicCibleCultureScientifiqueRecontreGrandPublicService.save(publicCibleCultureScientifiqueRecontreGrandPublic);
            return publicCibleCultureScientifiqueRecontreGrandPublicConverter.toVo(publicCibleCultureScientifiqueRecontreGrandPublic);
            }

            @ApiOperation("Delete the specified publicCibleCultureScientifiqueRecontreGrandPublic")
            @DeleteMapping("/")
            public int delete(@RequestBody PublicCibleCultureScientifiqueRecontreGrandPublicVo publicCibleCultureScientifiqueRecontreGrandPublicVo){
            PublicCibleCultureScientifiqueRecontreGrandPublic publicCibleCultureScientifiqueRecontreGrandPublic = publicCibleCultureScientifiqueRecontreGrandPublicConverter.toItem(publicCibleCultureScientifiqueRecontreGrandPublicVo);
            return publicCibleCultureScientifiqueRecontreGrandPublicService.delete(publicCibleCultureScientifiqueRecontreGrandPublic);
            }

            @ApiOperation("Deletes a publicCibleCultureScientifiqueRecontreGrandPublic by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return publicCibleCultureScientifiqueRecontreGrandPublicService.deleteById(id);
            }


        }
