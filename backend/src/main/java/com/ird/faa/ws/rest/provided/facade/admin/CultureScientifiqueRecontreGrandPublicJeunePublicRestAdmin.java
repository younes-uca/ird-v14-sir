package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.CultureScientifiqueRecontreGrandPublicJeunePublicAdminService;

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
import com.ird.faa.bean.formulaire.CultureScientifiqueRecontreGrandPublicJeunePublic;
import com.ird.faa.ws.rest.provided.converter.CultureScientifiqueRecontreGrandPublicJeunePublicConverter;
import com.ird.faa.ws.rest.provided.vo.CultureScientifiqueRecontreGrandPublicJeunePublicVo;

@Api("Manages cultureScientifiqueRecontreGrandPublicJeunePublic services")
@RestController
@RequestMapping("api/admin/cultureScientifiqueRecontreGrandPublicJeunePublic")
public class CultureScientifiqueRecontreGrandPublicJeunePublicRestAdmin {

@Autowired
private CultureScientifiqueRecontreGrandPublicJeunePublicAdminService cultureScientifiqueRecontreGrandPublicJeunePublicService;

@Autowired
private CultureScientifiqueRecontreGrandPublicJeunePublicConverter cultureScientifiqueRecontreGrandPublicJeunePublicConverter;


            @ApiOperation("Updates the specified  cultureScientifiqueRecontreGrandPublicJeunePublic")
            @PutMapping("/")
            public  CultureScientifiqueRecontreGrandPublicJeunePublicVo update(@RequestBody  CultureScientifiqueRecontreGrandPublicJeunePublicVo  cultureScientifiqueRecontreGrandPublicJeunePublicVo){
            CultureScientifiqueRecontreGrandPublicJeunePublic cultureScientifiqueRecontreGrandPublicJeunePublic = cultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(cultureScientifiqueRecontreGrandPublicJeunePublicVo);
            cultureScientifiqueRecontreGrandPublicJeunePublic = cultureScientifiqueRecontreGrandPublicJeunePublicService.update(cultureScientifiqueRecontreGrandPublicJeunePublic);
            return cultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(cultureScientifiqueRecontreGrandPublicJeunePublic);
            }

    @ApiOperation("Finds a list of all cultureScientifiqueRecontreGrandPublicJeunePublics")
    @GetMapping("/")
    public List<CultureScientifiqueRecontreGrandPublicJeunePublicVo> findAll(){
        return cultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(cultureScientifiqueRecontreGrandPublicJeunePublicService.findAll());
    }

    @ApiOperation("Finds a cultureScientifiqueRecontreGrandPublicJeunePublic with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CultureScientifiqueRecontreGrandPublicJeunePublicVo findByIdWithAssociatedList(@PathVariable Long id){
    return cultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(cultureScientifiqueRecontreGrandPublicJeunePublicService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search cultureScientifiqueRecontreGrandPublicJeunePublic by a specific criteria")
    @PostMapping("/search")
    public List<CultureScientifiqueRecontreGrandPublicJeunePublicVo> findByCriteria(@RequestBody CultureScientifiqueRecontreGrandPublicJeunePublicVo cultureScientifiqueRecontreGrandPublicJeunePublicVo){
        return cultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(cultureScientifiqueRecontreGrandPublicJeunePublicService.findByCriteria(cultureScientifiqueRecontreGrandPublicJeunePublicVo));
        }

            @ApiOperation("Finds a cultureScientifiqueRecontreGrandPublicJeunePublic by id")
            @GetMapping("/id/{id}")
            public CultureScientifiqueRecontreGrandPublicJeunePublicVo findById(@PathVariable Long id){
            return cultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(cultureScientifiqueRecontreGrandPublicJeunePublicService.findById(id));
            }

            @ApiOperation("Saves the specified  cultureScientifiqueRecontreGrandPublicJeunePublic")
            @PostMapping("/")
            public CultureScientifiqueRecontreGrandPublicJeunePublicVo save(@RequestBody CultureScientifiqueRecontreGrandPublicJeunePublicVo cultureScientifiqueRecontreGrandPublicJeunePublicVo){
            CultureScientifiqueRecontreGrandPublicJeunePublic cultureScientifiqueRecontreGrandPublicJeunePublic = cultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(cultureScientifiqueRecontreGrandPublicJeunePublicVo);
            cultureScientifiqueRecontreGrandPublicJeunePublic = cultureScientifiqueRecontreGrandPublicJeunePublicService.save(cultureScientifiqueRecontreGrandPublicJeunePublic);
            return cultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(cultureScientifiqueRecontreGrandPublicJeunePublic);
            }

            @ApiOperation("Delete the specified cultureScientifiqueRecontreGrandPublicJeunePublic")
            @DeleteMapping("/")
            public int delete(@RequestBody CultureScientifiqueRecontreGrandPublicJeunePublicVo cultureScientifiqueRecontreGrandPublicJeunePublicVo){
            CultureScientifiqueRecontreGrandPublicJeunePublic cultureScientifiqueRecontreGrandPublicJeunePublic = cultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(cultureScientifiqueRecontreGrandPublicJeunePublicVo);
            return cultureScientifiqueRecontreGrandPublicJeunePublicService.delete(cultureScientifiqueRecontreGrandPublicJeunePublic);
            }

            @ApiOperation("Deletes a cultureScientifiqueRecontreGrandPublicJeunePublic by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return cultureScientifiqueRecontreGrandPublicJeunePublicService.deleteById(id);
            }


        }
