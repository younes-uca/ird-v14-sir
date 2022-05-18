package main.java.com.ird.faa.ws.rest.provided.facade.chercheur.config;

import com.ird.faa.service.chercheur.facade.config.EtatCampagneChercheurService;

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
import com.ird.faa.bean.config.EtatCampagne;
import main.java.com.ird.faa.ws.rest.provided.converter.config.EtatCampagneConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.config.EtatCampagneVo;

@Api("Manages etatCampagne services")
@RestController
@RequestMapping("api/chercheur/etatCampagne")
public class EtatCampagneRestChercheur {

@Autowired
private EtatCampagneChercheurService etatCampagneService;

@Autowired
private EtatCampagneConverter etatCampagneConverter;


            @ApiOperation("Updates the specified  etatCampagne")
            @PutMapping("/")
            public  EtatCampagneVo update(@RequestBody  EtatCampagneVo  etatCampagneVo){
            EtatCampagne etatCampagne = etatCampagneConverter.toItem(etatCampagneVo);
            etatCampagne = etatCampagneService.update(etatCampagne);
            return etatCampagneConverter.toVo(etatCampagne);
            }

    @ApiOperation("Finds a list of all etatCampagnes")
    @GetMapping("/")
    public List<EtatCampagneVo> findAll(){
        return etatCampagneConverter.toVo(etatCampagneService.findAll());
    }

    @ApiOperation("Finds a etatCampagne with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatCampagneVo findByIdWithAssociatedList(@PathVariable Long id){
    return etatCampagneConverter.toVo(etatCampagneService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatCampagne by a specific criteria")
    @PostMapping("/search")
    public List<EtatCampagneVo> findByCriteria(@RequestBody EtatCampagneVo etatCampagneVo){
        return etatCampagneConverter.toVo(etatCampagneService.findByCriteria(etatCampagneVo));
        }

            @ApiOperation("Finds a etatCampagne by id")
            @GetMapping("/id/{id}")
            public EtatCampagneVo findById(@PathVariable Long id){
            return etatCampagneConverter.toVo(etatCampagneService.findById(id));
            }

            @ApiOperation("Saves the specified  etatCampagne")
            @PostMapping("/")
            public EtatCampagneVo save(@RequestBody EtatCampagneVo etatCampagneVo){
            EtatCampagne etatCampagne = etatCampagneConverter.toItem(etatCampagneVo);
            etatCampagne = etatCampagneService.save(etatCampagne);
            return etatCampagneConverter.toVo(etatCampagne);
            }

            @ApiOperation("Delete the specified etatCampagne")
            @DeleteMapping("/")
            public int delete(@RequestBody EtatCampagneVo etatCampagneVo){
            EtatCampagne etatCampagne = etatCampagneConverter.toItem(etatCampagneVo);
            return etatCampagneService.delete(etatCampagne);
            }

            @ApiOperation("Deletes a etatCampagne by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etatCampagneService.deleteById(id);
            }


        }
