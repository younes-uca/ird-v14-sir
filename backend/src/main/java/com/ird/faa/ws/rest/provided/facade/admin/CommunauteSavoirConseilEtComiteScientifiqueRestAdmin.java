package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.CommunauteSavoirConseilEtComiteScientifiqueAdminService;

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
import com.ird.faa.bean.formulaire.CommunauteSavoirConseilEtComiteScientifique;
import com.ird.faa.ws.rest.provided.converter.CommunauteSavoirConseilEtComiteScientifiqueConverter;
import com.ird.faa.ws.rest.provided.vo.CommunauteSavoirConseilEtComiteScientifiqueVo;

@Api("Manages communauteSavoirConseilEtComiteScientifique services")
@RestController
@RequestMapping("api/admin/communauteSavoirConseilEtComiteScientifique")
public class CommunauteSavoirConseilEtComiteScientifiqueRestAdmin {

@Autowired
private CommunauteSavoirConseilEtComiteScientifiqueAdminService communauteSavoirConseilEtComiteScientifiqueService;

@Autowired
private CommunauteSavoirConseilEtComiteScientifiqueConverter communauteSavoirConseilEtComiteScientifiqueConverter;


            @ApiOperation("Updates the specified  communauteSavoirConseilEtComiteScientifique")
            @PutMapping("/")
            public  CommunauteSavoirConseilEtComiteScientifiqueVo update(@RequestBody  CommunauteSavoirConseilEtComiteScientifiqueVo  communauteSavoirConseilEtComiteScientifiqueVo){
            CommunauteSavoirConseilEtComiteScientifique communauteSavoirConseilEtComiteScientifique = communauteSavoirConseilEtComiteScientifiqueConverter.toItem(communauteSavoirConseilEtComiteScientifiqueVo);
            communauteSavoirConseilEtComiteScientifique = communauteSavoirConseilEtComiteScientifiqueService.update(communauteSavoirConseilEtComiteScientifique);
            return communauteSavoirConseilEtComiteScientifiqueConverter.toVo(communauteSavoirConseilEtComiteScientifique);
            }

    @ApiOperation("Finds a list of all communauteSavoirConseilEtComiteScientifiques")
    @GetMapping("/")
    public List<CommunauteSavoirConseilEtComiteScientifiqueVo> findAll(){
        return communauteSavoirConseilEtComiteScientifiqueConverter.toVo(communauteSavoirConseilEtComiteScientifiqueService.findAll());
    }

    @ApiOperation("Finds a communauteSavoirConseilEtComiteScientifique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CommunauteSavoirConseilEtComiteScientifiqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return communauteSavoirConseilEtComiteScientifiqueConverter.toVo(communauteSavoirConseilEtComiteScientifiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search communauteSavoirConseilEtComiteScientifique by a specific criteria")
    @PostMapping("/search")
    public List<CommunauteSavoirConseilEtComiteScientifiqueVo> findByCriteria(@RequestBody CommunauteSavoirConseilEtComiteScientifiqueVo communauteSavoirConseilEtComiteScientifiqueVo){
        return communauteSavoirConseilEtComiteScientifiqueConverter.toVo(communauteSavoirConseilEtComiteScientifiqueService.findByCriteria(communauteSavoirConseilEtComiteScientifiqueVo));
        }

            @ApiOperation("Finds a communauteSavoirConseilEtComiteScientifique by id")
            @GetMapping("/id/{id}")
            public CommunauteSavoirConseilEtComiteScientifiqueVo findById(@PathVariable Long id){
            return communauteSavoirConseilEtComiteScientifiqueConverter.toVo(communauteSavoirConseilEtComiteScientifiqueService.findById(id));
            }

            @ApiOperation("Saves the specified  communauteSavoirConseilEtComiteScientifique")
            @PostMapping("/")
            public CommunauteSavoirConseilEtComiteScientifiqueVo save(@RequestBody CommunauteSavoirConseilEtComiteScientifiqueVo communauteSavoirConseilEtComiteScientifiqueVo){
            CommunauteSavoirConseilEtComiteScientifique communauteSavoirConseilEtComiteScientifique = communauteSavoirConseilEtComiteScientifiqueConverter.toItem(communauteSavoirConseilEtComiteScientifiqueVo);
            communauteSavoirConseilEtComiteScientifique = communauteSavoirConseilEtComiteScientifiqueService.save(communauteSavoirConseilEtComiteScientifique);
            return communauteSavoirConseilEtComiteScientifiqueConverter.toVo(communauteSavoirConseilEtComiteScientifique);
            }

            @ApiOperation("Delete the specified communauteSavoirConseilEtComiteScientifique")
            @DeleteMapping("/")
            public int delete(@RequestBody CommunauteSavoirConseilEtComiteScientifiqueVo communauteSavoirConseilEtComiteScientifiqueVo){
            CommunauteSavoirConseilEtComiteScientifique communauteSavoirConseilEtComiteScientifique = communauteSavoirConseilEtComiteScientifiqueConverter.toItem(communauteSavoirConseilEtComiteScientifiqueVo);
            return communauteSavoirConseilEtComiteScientifiqueService.delete(communauteSavoirConseilEtComiteScientifique);
            }

            @ApiOperation("Deletes a communauteSavoirConseilEtComiteScientifique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return communauteSavoirConseilEtComiteScientifiqueService.deleteById(id);
            }


        }
