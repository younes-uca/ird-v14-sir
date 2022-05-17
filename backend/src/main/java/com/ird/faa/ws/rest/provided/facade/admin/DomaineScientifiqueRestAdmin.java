package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.DomaineScientifiqueAdminService;

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
import com.ird.faa.bean.formulaire.DomaineScientifique;
import com.ird.faa.ws.rest.provided.converter.DomaineScientifiqueConverter;
import com.ird.faa.ws.rest.provided.vo.DomaineScientifiqueVo;

@Api("Manages domaineScientifique services")
@RestController
@RequestMapping("api/admin/domaineScientifique")
public class DomaineScientifiqueRestAdmin {

@Autowired
private DomaineScientifiqueAdminService domaineScientifiqueService;

@Autowired
private DomaineScientifiqueConverter domaineScientifiqueConverter;


            @ApiOperation("Updates the specified  domaineScientifique")
            @PutMapping("/")
            public  DomaineScientifiqueVo update(@RequestBody  DomaineScientifiqueVo  domaineScientifiqueVo){
            DomaineScientifique domaineScientifique = domaineScientifiqueConverter.toItem(domaineScientifiqueVo);
            domaineScientifique = domaineScientifiqueService.update(domaineScientifique);
            return domaineScientifiqueConverter.toVo(domaineScientifique);
            }

    @ApiOperation("Finds a list of all domaineScientifiques")
    @GetMapping("/")
    public List<DomaineScientifiqueVo> findAll(){
        return domaineScientifiqueConverter.toVo(domaineScientifiqueService.findAll());
    }

    @ApiOperation("Finds a domaineScientifique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DomaineScientifiqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return domaineScientifiqueConverter.toVo(domaineScientifiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search domaineScientifique by a specific criteria")
    @PostMapping("/search")
    public List<DomaineScientifiqueVo> findByCriteria(@RequestBody DomaineScientifiqueVo domaineScientifiqueVo){
        return domaineScientifiqueConverter.toVo(domaineScientifiqueService.findByCriteria(domaineScientifiqueVo));
        }

            @ApiOperation("Finds a domaineScientifique by id")
            @GetMapping("/id/{id}")
            public DomaineScientifiqueVo findById(@PathVariable Long id){
            return domaineScientifiqueConverter.toVo(domaineScientifiqueService.findById(id));
            }

            @ApiOperation("Saves the specified  domaineScientifique")
            @PostMapping("/")
            public DomaineScientifiqueVo save(@RequestBody DomaineScientifiqueVo domaineScientifiqueVo){
            DomaineScientifique domaineScientifique = domaineScientifiqueConverter.toItem(domaineScientifiqueVo);
            domaineScientifique = domaineScientifiqueService.save(domaineScientifique);
            return domaineScientifiqueConverter.toVo(domaineScientifique);
            }

            @ApiOperation("Delete the specified domaineScientifique")
            @DeleteMapping("/")
            public int delete(@RequestBody DomaineScientifiqueVo domaineScientifiqueVo){
            DomaineScientifique domaineScientifique = domaineScientifiqueConverter.toItem(domaineScientifiqueVo);
            return domaineScientifiqueService.delete(domaineScientifique);
            }

            @ApiOperation("Deletes a domaineScientifique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return domaineScientifiqueService.deleteById(id);
            }


        }
