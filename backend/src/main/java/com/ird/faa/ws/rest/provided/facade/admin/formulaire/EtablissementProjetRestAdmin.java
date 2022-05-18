package main.java.com.ird.faa.ws.rest.provided.facade.admin.formulaire;

import com.ird.faa.service.admin.facade.formulaire.EtablissementProjetAdminService;

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
import com.ird.faa.bean.referentiel.EtablissementProjet;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.EtablissementProjetConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.EtablissementProjetVo;

@Api("Manages etablissementProjet services")
@RestController
@RequestMapping("api/admin/etablissementProjet")
public class EtablissementProjetRestAdmin {

@Autowired
private EtablissementProjetAdminService etablissementProjetService;

@Autowired
private EtablissementProjetConverter etablissementProjetConverter;


            @ApiOperation("Updates the specified  etablissementProjet")
            @PutMapping("/")
            public  EtablissementProjetVo update(@RequestBody  EtablissementProjetVo  etablissementProjetVo){
            EtablissementProjet etablissementProjet = etablissementProjetConverter.toItem(etablissementProjetVo);
            etablissementProjet = etablissementProjetService.update(etablissementProjet);
            return etablissementProjetConverter.toVo(etablissementProjet);
            }

    @ApiOperation("Finds a list of all etablissementProjets")
    @GetMapping("/")
    public List<EtablissementProjetVo> findAll(){
        return etablissementProjetConverter.toVo(etablissementProjetService.findAll());
    }

    @ApiOperation("Finds a etablissementProjet with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtablissementProjetVo findByIdWithAssociatedList(@PathVariable Long id){
    return etablissementProjetConverter.toVo(etablissementProjetService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etablissementProjet by a specific criteria")
    @PostMapping("/search")
    public List<EtablissementProjetVo> findByCriteria(@RequestBody EtablissementProjetVo etablissementProjetVo){
        return etablissementProjetConverter.toVo(etablissementProjetService.findByCriteria(etablissementProjetVo));
        }

            @ApiOperation("Finds a etablissementProjet by id")
            @GetMapping("/id/{id}")
            public EtablissementProjetVo findById(@PathVariable Long id){
            return etablissementProjetConverter.toVo(etablissementProjetService.findById(id));
            }

            @ApiOperation("Saves the specified  etablissementProjet")
            @PostMapping("/")
            public EtablissementProjetVo save(@RequestBody EtablissementProjetVo etablissementProjetVo){
            EtablissementProjet etablissementProjet = etablissementProjetConverter.toItem(etablissementProjetVo);
            etablissementProjet = etablissementProjetService.save(etablissementProjet);
            return etablissementProjetConverter.toVo(etablissementProjet);
            }

            @ApiOperation("Delete the specified etablissementProjet")
            @DeleteMapping("/")
            public int delete(@RequestBody EtablissementProjetVo etablissementProjetVo){
            EtablissementProjet etablissementProjet = etablissementProjetConverter.toItem(etablissementProjetVo);
            return etablissementProjetService.delete(etablissementProjet);
            }

            @ApiOperation("Deletes a etablissementProjet by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etablissementProjetService.deleteById(id);
            }


        }
