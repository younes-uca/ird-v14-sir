package main.java.com.ird.faa.ws.rest.provided.facade.chercheur.formulaire;

import com.ird.faa.bean.formulaire.Expertise;
import com.ird.faa.service.chercheur.facade.formulaire.ExpertiseChercheurService;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.ExpertiseConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.ExpertiseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages expertise services")
@RestController
@RequestMapping("api/chercheur/expertise")
public class ExpertiseRestChercheur {

@Autowired
private ExpertiseChercheurService expertiseService;

@Autowired
private ExpertiseConverter expertiseConverter;


            @ApiOperation("Updates the specified  expertise")
            @PutMapping("/")
            public  ExpertiseVo update(@RequestBody  ExpertiseVo  expertiseVo){
            Expertise expertise = expertiseConverter.toItem(expertiseVo);
            expertise = expertiseService.update(expertise);
            return expertiseConverter.toVo(expertise);
            }

    @ApiOperation("Finds a list of all expertises")
    @GetMapping("/")
    public List<ExpertiseVo> findAll(){
        return expertiseConverter.toVo(expertiseService.findAll());
    }

    @ApiOperation("Finds a expertise with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ExpertiseVo findByIdWithAssociatedList(@PathVariable Long id){
    return expertiseConverter.toVo(expertiseService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search expertise by a specific criteria")
    @PostMapping("/search")
    public List<ExpertiseVo> findByCriteria(@RequestBody ExpertiseVo expertiseVo){
        return expertiseConverter.toVo(expertiseService.findByCriteria(expertiseVo));
        }

            @ApiOperation("Finds a expertise by id")
            @GetMapping("/id/{id}")
            public ExpertiseVo findById(@PathVariable Long id){
            return expertiseConverter.toVo(expertiseService.findById(id));
            }

            @ApiOperation("Saves the specified  expertise")
            @PostMapping("/")
            public ExpertiseVo save(@RequestBody ExpertiseVo expertiseVo){
            Expertise expertise = expertiseConverter.toItem(expertiseVo);
            expertise = expertiseService.save(expertise);
            return expertiseConverter.toVo(expertise);
            }

            @ApiOperation("Delete the specified expertise")
            @DeleteMapping("/")
            public int delete(@RequestBody ExpertiseVo expertiseVo){
            Expertise expertise = expertiseConverter.toItem(expertiseVo);
            return expertiseService.delete(expertise);
            }

            @ApiOperation("Deletes a expertise by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return expertiseService.deleteById(id);
            }
        @ApiOperation("find by etatEtapeCampagne code")
        @GetMapping("/etatEtapeCampagne/code/{code}")
        public List<Expertise> findByEtatEtapeCampagneCode(@PathVariable String code){
        return expertiseService.findByEtatEtapeCampagneCode(code);
        }

        @ApiOperation("delete by etatEtapeCampagne code")
        @DeleteMapping("/etatEtapeCampagne/code/{code}")
        public int deleteByEtatEtapeCampagneCode(@PathVariable String code){
        return expertiseService.deleteByEtatEtapeCampagneCode(code);
        }

        @ApiOperation("find by etatEtapeCampagne id")
        @GetMapping("/etatEtapeCampagne/id/{id}")
        public List<Expertise> findByEtatEtapeCampagneId(@PathVariable Long id){
        return expertiseService.findByEtatEtapeCampagneId(id);
        }

        @ApiOperation("delete by etatEtapeCampagne id")
        @DeleteMapping("/etatEtapeCampagne/id/{id}")
        public int deleteByEtatEtapeCampagneId(@PathVariable Long id){
        return expertiseService.deleteByEtatEtapeCampagneId(id);
        }

        @ApiOperation("find by chercheur numeroMatricule")
        @GetMapping("/chercheur/numeroMatricule/{numeroMatricule}")
        public List<Expertise> findByChercheurNumeroMatricule(@PathVariable String numeroMatricule){
        return expertiseService.findByChercheurNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("delete by chercheur numeroMatricule")
        @DeleteMapping("/chercheur/numeroMatricule/{numeroMatricule}")
        public int deleteByChercheurNumeroMatricule(@PathVariable String numeroMatricule){
        return expertiseService.deleteByChercheurNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("find by chercheur id")
        @GetMapping("/chercheur/id/{id}")
        public List<Expertise> findByChercheurId(@PathVariable Long id){
        return expertiseService.findByChercheurId(id);
        }

        @ApiOperation("delete by chercheur id")
        @DeleteMapping("/chercheur/id/{id}")
        public int deleteByChercheurId(@PathVariable Long id){
        return expertiseService.deleteByChercheurId(id);
        }

        @ApiOperation("find by campagne code")
        @GetMapping("/campagne/code/{code}")
        public List<Expertise> findByCampagneCode(@PathVariable String code){
        return expertiseService.findByCampagneCode(code);
        }

        @ApiOperation("delete by campagne code")
        @DeleteMapping("/campagne/code/{code}")
        public int deleteByCampagneCode(@PathVariable String code){
        return expertiseService.deleteByCampagneCode(code);
        }

        @ApiOperation("find by campagne id")
        @GetMapping("/campagne/id/{id}")
        public List<Expertise> findByCampagneId(@PathVariable Long id){
        return expertiseService.findByCampagneId(id);
        }

        @ApiOperation("delete by campagne id")
        @DeleteMapping("/campagne/id/{id}")
        public int deleteByCampagneId(@PathVariable Long id){
        return expertiseService.deleteByCampagneId(id);
        }




            @GetMapping("/username/{username}/id/{compagneId}")
            public List<ExpertiseVo> findByChercheurUsernameAndCampagneId(@PathVariable String username,@PathVariable Long compagneId){
            return expertiseConverter.toVo(expertiseService.findByChercheurUsernameAndCampagneId(username,compagneId));
            }

            }
