package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicAdminService;

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
import com.ird.faa.bean.formulaire.EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic;
import com.ird.faa.ws.rest.provided.converter.EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter;
import com.ird.faa.ws.rest.provided.vo.EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo;

@Api("Manages etablissementCultureScientifiqueRecontreGrandPublicJeunePublic services")
@RestController
@RequestMapping("api/admin/etablissementCultureScientifiqueRecontreGrandPublicJeunePublic")
public class EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicRestAdmin {

@Autowired
private EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicAdminService etablissementCultureScientifiqueRecontreGrandPublicJeunePublicService;

@Autowired
private EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter;


            @ApiOperation("Updates the specified  etablissementCultureScientifiqueRecontreGrandPublicJeunePublic")
            @PutMapping("/")
            public  EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo update(@RequestBody  EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo  etablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo){
            EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic etablissementCultureScientifiqueRecontreGrandPublicJeunePublic = etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(etablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo);
            etablissementCultureScientifiqueRecontreGrandPublicJeunePublic = etablissementCultureScientifiqueRecontreGrandPublicJeunePublicService.update(etablissementCultureScientifiqueRecontreGrandPublicJeunePublic);
            return etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(etablissementCultureScientifiqueRecontreGrandPublicJeunePublic);
            }

    @ApiOperation("Finds a list of all etablissementCultureScientifiqueRecontreGrandPublicJeunePublics")
    @GetMapping("/")
    public List<EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo> findAll(){
        return etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(etablissementCultureScientifiqueRecontreGrandPublicJeunePublicService.findAll());
    }

    @ApiOperation("Finds a etablissementCultureScientifiqueRecontreGrandPublicJeunePublic with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo findByIdWithAssociatedList(@PathVariable Long id){
    return etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(etablissementCultureScientifiqueRecontreGrandPublicJeunePublicService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etablissementCultureScientifiqueRecontreGrandPublicJeunePublic by a specific criteria")
    @PostMapping("/search")
    public List<EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo> findByCriteria(@RequestBody EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo etablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo){
        return etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(etablissementCultureScientifiqueRecontreGrandPublicJeunePublicService.findByCriteria(etablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo));
        }

            @ApiOperation("Finds a etablissementCultureScientifiqueRecontreGrandPublicJeunePublic by id")
            @GetMapping("/id/{id}")
            public EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo findById(@PathVariable Long id){
            return etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(etablissementCultureScientifiqueRecontreGrandPublicJeunePublicService.findById(id));
            }

            @ApiOperation("Saves the specified  etablissementCultureScientifiqueRecontreGrandPublicJeunePublic")
            @PostMapping("/")
            public EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo save(@RequestBody EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo etablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo){
            EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic etablissementCultureScientifiqueRecontreGrandPublicJeunePublic = etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(etablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo);
            etablissementCultureScientifiqueRecontreGrandPublicJeunePublic = etablissementCultureScientifiqueRecontreGrandPublicJeunePublicService.save(etablissementCultureScientifiqueRecontreGrandPublicJeunePublic);
            return etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(etablissementCultureScientifiqueRecontreGrandPublicJeunePublic);
            }

            @ApiOperation("Delete the specified etablissementCultureScientifiqueRecontreGrandPublicJeunePublic")
            @DeleteMapping("/")
            public int delete(@RequestBody EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo etablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo){
            EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic etablissementCultureScientifiqueRecontreGrandPublicJeunePublic = etablissementCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(etablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo);
            return etablissementCultureScientifiqueRecontreGrandPublicJeunePublicService.delete(etablissementCultureScientifiqueRecontreGrandPublicJeunePublic);
            }

            @ApiOperation("Deletes a etablissementCultureScientifiqueRecontreGrandPublicJeunePublic by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etablissementCultureScientifiqueRecontreGrandPublicJeunePublicService.deleteById(id);
            }


        }
