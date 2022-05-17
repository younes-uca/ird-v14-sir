package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.ConseilEtComiteScientifiqueAdminService;

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
import com.ird.faa.bean.formulaire.ConseilEtComiteScientifique;
import com.ird.faa.ws.rest.provided.converter.ConseilEtComiteScientifiqueConverter;
import com.ird.faa.ws.rest.provided.vo.ConseilEtComiteScientifiqueVo;

@Api("Manages conseilEtComiteScientifique services")
@RestController
@RequestMapping("api/admin/conseilEtComiteScientifique")
public class ConseilEtComiteScientifiqueRestAdmin {

@Autowired
private ConseilEtComiteScientifiqueAdminService conseilEtComiteScientifiqueService;

@Autowired
private ConseilEtComiteScientifiqueConverter conseilEtComiteScientifiqueConverter;


            @ApiOperation("Updates the specified  conseilEtComiteScientifique")
            @PutMapping("/")
            public  ConseilEtComiteScientifiqueVo update(@RequestBody  ConseilEtComiteScientifiqueVo  conseilEtComiteScientifiqueVo){
            ConseilEtComiteScientifique conseilEtComiteScientifique = conseilEtComiteScientifiqueConverter.toItem(conseilEtComiteScientifiqueVo);
            conseilEtComiteScientifique = conseilEtComiteScientifiqueService.update(conseilEtComiteScientifique);
            return conseilEtComiteScientifiqueConverter.toVo(conseilEtComiteScientifique);
            }

    @ApiOperation("Finds a list of all conseilEtComiteScientifiques")
    @GetMapping("/")
    public List<ConseilEtComiteScientifiqueVo> findAll(){
        return conseilEtComiteScientifiqueConverter.toVo(conseilEtComiteScientifiqueService.findAll());
    }

    @ApiOperation("Finds a conseilEtComiteScientifique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ConseilEtComiteScientifiqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return conseilEtComiteScientifiqueConverter.toVo(conseilEtComiteScientifiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search conseilEtComiteScientifique by a specific criteria")
    @PostMapping("/search")
    public List<ConseilEtComiteScientifiqueVo> findByCriteria(@RequestBody ConseilEtComiteScientifiqueVo conseilEtComiteScientifiqueVo){
        return conseilEtComiteScientifiqueConverter.toVo(conseilEtComiteScientifiqueService.findByCriteria(conseilEtComiteScientifiqueVo));
        }

            @ApiOperation("Finds a conseilEtComiteScientifique by id")
            @GetMapping("/id/{id}")
            public ConseilEtComiteScientifiqueVo findById(@PathVariable Long id){
            return conseilEtComiteScientifiqueConverter.toVo(conseilEtComiteScientifiqueService.findById(id));
            }

            @ApiOperation("Saves the specified  conseilEtComiteScientifique")
            @PostMapping("/")
            public ConseilEtComiteScientifiqueVo save(@RequestBody ConseilEtComiteScientifiqueVo conseilEtComiteScientifiqueVo){
            ConseilEtComiteScientifique conseilEtComiteScientifique = conseilEtComiteScientifiqueConverter.toItem(conseilEtComiteScientifiqueVo);
            conseilEtComiteScientifique = conseilEtComiteScientifiqueService.save(conseilEtComiteScientifique);
            return conseilEtComiteScientifiqueConverter.toVo(conseilEtComiteScientifique);
            }

            @ApiOperation("Delete the specified conseilEtComiteScientifique")
            @DeleteMapping("/")
            public int delete(@RequestBody ConseilEtComiteScientifiqueVo conseilEtComiteScientifiqueVo){
            ConseilEtComiteScientifique conseilEtComiteScientifique = conseilEtComiteScientifiqueConverter.toItem(conseilEtComiteScientifiqueVo);
            return conseilEtComiteScientifiqueService.delete(conseilEtComiteScientifique);
            }

            @ApiOperation("Deletes a conseilEtComiteScientifique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return conseilEtComiteScientifiqueService.deleteById(id);
            }


        }
