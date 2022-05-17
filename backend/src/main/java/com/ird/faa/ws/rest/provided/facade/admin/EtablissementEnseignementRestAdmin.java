package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.EtablissementEnseignementAdminService;

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
import com.ird.faa.bean.formulaire.EtablissementEnseignement;
import com.ird.faa.ws.rest.provided.converter.EtablissementEnseignementConverter;
import com.ird.faa.ws.rest.provided.vo.EtablissementEnseignementVo;

@Api("Manages etablissementEnseignement services")
@RestController
@RequestMapping("api/admin/etablissementEnseignement")
public class EtablissementEnseignementRestAdmin {

@Autowired
private EtablissementEnseignementAdminService etablissementEnseignementService;

@Autowired
private EtablissementEnseignementConverter etablissementEnseignementConverter;


            @ApiOperation("Updates the specified  etablissementEnseignement")
            @PutMapping("/")
            public  EtablissementEnseignementVo update(@RequestBody  EtablissementEnseignementVo  etablissementEnseignementVo){
            EtablissementEnseignement etablissementEnseignement = etablissementEnseignementConverter.toItem(etablissementEnseignementVo);
            etablissementEnseignement = etablissementEnseignementService.update(etablissementEnseignement);
            return etablissementEnseignementConverter.toVo(etablissementEnseignement);
            }

    @ApiOperation("Finds a list of all etablissementEnseignements")
    @GetMapping("/")
    public List<EtablissementEnseignementVo> findAll(){
        return etablissementEnseignementConverter.toVo(etablissementEnseignementService.findAll());
    }

    @ApiOperation("Finds a etablissementEnseignement with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtablissementEnseignementVo findByIdWithAssociatedList(@PathVariable Long id){
    return etablissementEnseignementConverter.toVo(etablissementEnseignementService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etablissementEnseignement by a specific criteria")
    @PostMapping("/search")
    public List<EtablissementEnseignementVo> findByCriteria(@RequestBody EtablissementEnseignementVo etablissementEnseignementVo){
        return etablissementEnseignementConverter.toVo(etablissementEnseignementService.findByCriteria(etablissementEnseignementVo));
        }

            @ApiOperation("Finds a etablissementEnseignement by id")
            @GetMapping("/id/{id}")
            public EtablissementEnseignementVo findById(@PathVariable Long id){
            return etablissementEnseignementConverter.toVo(etablissementEnseignementService.findById(id));
            }

            @ApiOperation("Saves the specified  etablissementEnseignement")
            @PostMapping("/")
            public EtablissementEnseignementVo save(@RequestBody EtablissementEnseignementVo etablissementEnseignementVo){
            EtablissementEnseignement etablissementEnseignement = etablissementEnseignementConverter.toItem(etablissementEnseignementVo);
            etablissementEnseignement = etablissementEnseignementService.save(etablissementEnseignement);
            return etablissementEnseignementConverter.toVo(etablissementEnseignement);
            }

            @ApiOperation("Delete the specified etablissementEnseignement")
            @DeleteMapping("/")
            public int delete(@RequestBody EtablissementEnseignementVo etablissementEnseignementVo){
            EtablissementEnseignement etablissementEnseignement = etablissementEnseignementConverter.toItem(etablissementEnseignementVo);
            return etablissementEnseignementService.delete(etablissementEnseignement);
            }

            @ApiOperation("Deletes a etablissementEnseignement by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etablissementEnseignementService.deleteById(id);
            }


        }
