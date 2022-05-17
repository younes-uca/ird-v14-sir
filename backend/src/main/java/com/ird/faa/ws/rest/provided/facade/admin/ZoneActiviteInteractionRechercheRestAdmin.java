package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.ZoneActiviteInteractionRechercheAdminService;

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
import com.ird.faa.bean.formulaire.ZoneActiviteInteractionRecherche;
import com.ird.faa.ws.rest.provided.converter.ZoneActiviteInteractionRechercheConverter;
import com.ird.faa.ws.rest.provided.vo.ZoneActiviteInteractionRechercheVo;

@Api("Manages zoneActiviteInteractionRecherche services")
@RestController
@RequestMapping("api/admin/zoneActiviteInteractionRecherche")
public class ZoneActiviteInteractionRechercheRestAdmin {

@Autowired
private ZoneActiviteInteractionRechercheAdminService zoneActiviteInteractionRechercheService;

@Autowired
private ZoneActiviteInteractionRechercheConverter zoneActiviteInteractionRechercheConverter;


            @ApiOperation("Updates the specified  zoneActiviteInteractionRecherche")
            @PutMapping("/")
            public  ZoneActiviteInteractionRechercheVo update(@RequestBody  ZoneActiviteInteractionRechercheVo  zoneActiviteInteractionRechercheVo){
            ZoneActiviteInteractionRecherche zoneActiviteInteractionRecherche = zoneActiviteInteractionRechercheConverter.toItem(zoneActiviteInteractionRechercheVo);
            zoneActiviteInteractionRecherche = zoneActiviteInteractionRechercheService.update(zoneActiviteInteractionRecherche);
            return zoneActiviteInteractionRechercheConverter.toVo(zoneActiviteInteractionRecherche);
            }

    @ApiOperation("Finds a list of all zoneActiviteInteractionRecherches")
    @GetMapping("/")
    public List<ZoneActiviteInteractionRechercheVo> findAll(){
        return zoneActiviteInteractionRechercheConverter.toVo(zoneActiviteInteractionRechercheService.findAll());
    }

    @ApiOperation("Finds a zoneActiviteInteractionRecherche with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ZoneActiviteInteractionRechercheVo findByIdWithAssociatedList(@PathVariable Long id){
    return zoneActiviteInteractionRechercheConverter.toVo(zoneActiviteInteractionRechercheService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search zoneActiviteInteractionRecherche by a specific criteria")
    @PostMapping("/search")
    public List<ZoneActiviteInteractionRechercheVo> findByCriteria(@RequestBody ZoneActiviteInteractionRechercheVo zoneActiviteInteractionRechercheVo){
        return zoneActiviteInteractionRechercheConverter.toVo(zoneActiviteInteractionRechercheService.findByCriteria(zoneActiviteInteractionRechercheVo));
        }

            @ApiOperation("Finds a zoneActiviteInteractionRecherche by id")
            @GetMapping("/id/{id}")
            public ZoneActiviteInteractionRechercheVo findById(@PathVariable Long id){
            return zoneActiviteInteractionRechercheConverter.toVo(zoneActiviteInteractionRechercheService.findById(id));
            }

            @ApiOperation("Saves the specified  zoneActiviteInteractionRecherche")
            @PostMapping("/")
            public ZoneActiviteInteractionRechercheVo save(@RequestBody ZoneActiviteInteractionRechercheVo zoneActiviteInteractionRechercheVo){
            ZoneActiviteInteractionRecherche zoneActiviteInteractionRecherche = zoneActiviteInteractionRechercheConverter.toItem(zoneActiviteInteractionRechercheVo);
            zoneActiviteInteractionRecherche = zoneActiviteInteractionRechercheService.save(zoneActiviteInteractionRecherche);
            return zoneActiviteInteractionRechercheConverter.toVo(zoneActiviteInteractionRecherche);
            }

            @ApiOperation("Delete the specified zoneActiviteInteractionRecherche")
            @DeleteMapping("/")
            public int delete(@RequestBody ZoneActiviteInteractionRechercheVo zoneActiviteInteractionRechercheVo){
            ZoneActiviteInteractionRecherche zoneActiviteInteractionRecherche = zoneActiviteInteractionRechercheConverter.toItem(zoneActiviteInteractionRechercheVo);
            return zoneActiviteInteractionRechercheService.delete(zoneActiviteInteractionRecherche);
            }

            @ApiOperation("Deletes a zoneActiviteInteractionRecherche by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return zoneActiviteInteractionRechercheService.deleteById(id);
            }


        }
