package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.CommunauteSavoirProjetActiviteRechercheAdminService;

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
import com.ird.faa.bean.formulaire.CommunauteSavoirProjetActiviteRecherche;
import com.ird.faa.ws.rest.provided.converter.CommunauteSavoirProjetActiviteRechercheConverter;
import com.ird.faa.ws.rest.provided.vo.CommunauteSavoirProjetActiviteRechercheVo;

@Api("Manages communauteSavoirProjetActiviteRecherche services")
@RestController
@RequestMapping("api/admin/communauteSavoirProjetActiviteRecherche")
public class CommunauteSavoirProjetActiviteRechercheRestAdmin {

@Autowired
private CommunauteSavoirProjetActiviteRechercheAdminService communauteSavoirProjetActiviteRechercheService;

@Autowired
private CommunauteSavoirProjetActiviteRechercheConverter communauteSavoirProjetActiviteRechercheConverter;


            @ApiOperation("Updates the specified  communauteSavoirProjetActiviteRecherche")
            @PutMapping("/")
            public  CommunauteSavoirProjetActiviteRechercheVo update(@RequestBody  CommunauteSavoirProjetActiviteRechercheVo  communauteSavoirProjetActiviteRechercheVo){
            CommunauteSavoirProjetActiviteRecherche communauteSavoirProjetActiviteRecherche = communauteSavoirProjetActiviteRechercheConverter.toItem(communauteSavoirProjetActiviteRechercheVo);
            communauteSavoirProjetActiviteRecherche = communauteSavoirProjetActiviteRechercheService.update(communauteSavoirProjetActiviteRecherche);
            return communauteSavoirProjetActiviteRechercheConverter.toVo(communauteSavoirProjetActiviteRecherche);
            }

    @ApiOperation("Finds a list of all communauteSavoirProjetActiviteRecherches")
    @GetMapping("/")
    public List<CommunauteSavoirProjetActiviteRechercheVo> findAll(){
        return communauteSavoirProjetActiviteRechercheConverter.toVo(communauteSavoirProjetActiviteRechercheService.findAll());
    }

    @ApiOperation("Finds a communauteSavoirProjetActiviteRecherche with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CommunauteSavoirProjetActiviteRechercheVo findByIdWithAssociatedList(@PathVariable Long id){
    return communauteSavoirProjetActiviteRechercheConverter.toVo(communauteSavoirProjetActiviteRechercheService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search communauteSavoirProjetActiviteRecherche by a specific criteria")
    @PostMapping("/search")
    public List<CommunauteSavoirProjetActiviteRechercheVo> findByCriteria(@RequestBody CommunauteSavoirProjetActiviteRechercheVo communauteSavoirProjetActiviteRechercheVo){
        return communauteSavoirProjetActiviteRechercheConverter.toVo(communauteSavoirProjetActiviteRechercheService.findByCriteria(communauteSavoirProjetActiviteRechercheVo));
        }

            @ApiOperation("Finds a communauteSavoirProjetActiviteRecherche by id")
            @GetMapping("/id/{id}")
            public CommunauteSavoirProjetActiviteRechercheVo findById(@PathVariable Long id){
            return communauteSavoirProjetActiviteRechercheConverter.toVo(communauteSavoirProjetActiviteRechercheService.findById(id));
            }

            @ApiOperation("Saves the specified  communauteSavoirProjetActiviteRecherche")
            @PostMapping("/")
            public CommunauteSavoirProjetActiviteRechercheVo save(@RequestBody CommunauteSavoirProjetActiviteRechercheVo communauteSavoirProjetActiviteRechercheVo){
            CommunauteSavoirProjetActiviteRecherche communauteSavoirProjetActiviteRecherche = communauteSavoirProjetActiviteRechercheConverter.toItem(communauteSavoirProjetActiviteRechercheVo);
            communauteSavoirProjetActiviteRecherche = communauteSavoirProjetActiviteRechercheService.save(communauteSavoirProjetActiviteRecherche);
            return communauteSavoirProjetActiviteRechercheConverter.toVo(communauteSavoirProjetActiviteRecherche);
            }

            @ApiOperation("Delete the specified communauteSavoirProjetActiviteRecherche")
            @DeleteMapping("/")
            public int delete(@RequestBody CommunauteSavoirProjetActiviteRechercheVo communauteSavoirProjetActiviteRechercheVo){
            CommunauteSavoirProjetActiviteRecherche communauteSavoirProjetActiviteRecherche = communauteSavoirProjetActiviteRechercheConverter.toItem(communauteSavoirProjetActiviteRechercheVo);
            return communauteSavoirProjetActiviteRechercheService.delete(communauteSavoirProjetActiviteRecherche);
            }

            @ApiOperation("Deletes a communauteSavoirProjetActiviteRecherche by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return communauteSavoirProjetActiviteRechercheService.deleteById(id);
            }


        }
