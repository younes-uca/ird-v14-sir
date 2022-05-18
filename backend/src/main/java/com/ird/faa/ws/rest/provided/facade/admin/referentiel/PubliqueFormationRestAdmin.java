package main.java.com.ird.faa.ws.rest.provided.facade.admin.referentiel;

import com.ird.faa.bean.referentiel.PubliqueFormation;
import com.ird.faa.service.admin.facade.formulaire.PubliqueFormationAdminService;
import main.java.com.ird.faa.ws.rest.provided.converter.referentiel.PubliqueFormationConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.PubliqueFormationVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages publiqueFormation services")
@RestController
@RequestMapping("api/admin/publiqueFormation")
public class PubliqueFormationRestAdmin {

@Autowired
private PubliqueFormationAdminService publiqueFormationService;

@Autowired
private PubliqueFormationConverter publiqueFormationConverter;


            @ApiOperation("Updates the specified  publiqueFormation")
            @PutMapping("/")
            public  PubliqueFormationVo update(@RequestBody  PubliqueFormationVo  publiqueFormationVo){
            PubliqueFormation publiqueFormation = publiqueFormationConverter.toItem(publiqueFormationVo);
            publiqueFormation = publiqueFormationService.update(publiqueFormation);
            return publiqueFormationConverter.toVo(publiqueFormation);
            }

    @ApiOperation("Finds a list of all publiqueFormations")
    @GetMapping("/")
    public List<PubliqueFormationVo> findAll(){
        return publiqueFormationConverter.toVo(publiqueFormationService.findAll());
    }

    @ApiOperation("Finds a publiqueFormation with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PubliqueFormationVo findByIdWithAssociatedList(@PathVariable Long id){
    return publiqueFormationConverter.toVo(publiqueFormationService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search publiqueFormation by a specific criteria")
    @PostMapping("/search")
    public List<PubliqueFormationVo> findByCriteria(@RequestBody PubliqueFormationVo publiqueFormationVo){
        return publiqueFormationConverter.toVo(publiqueFormationService.findByCriteria(publiqueFormationVo));
        }

            @ApiOperation("Finds a publiqueFormation by id")
            @GetMapping("/id/{id}")
            public PubliqueFormationVo findById(@PathVariable Long id){
            return publiqueFormationConverter.toVo(publiqueFormationService.findById(id));
            }

            @ApiOperation("Saves the specified  publiqueFormation")
            @PostMapping("/")
            public PubliqueFormationVo save(@RequestBody PubliqueFormationVo publiqueFormationVo){
            PubliqueFormation publiqueFormation = publiqueFormationConverter.toItem(publiqueFormationVo);
            publiqueFormation = publiqueFormationService.save(publiqueFormation);
            return publiqueFormationConverter.toVo(publiqueFormation);
            }

            @ApiOperation("Delete the specified publiqueFormation")
            @DeleteMapping("/")
            public int delete(@RequestBody PubliqueFormationVo publiqueFormationVo){
            PubliqueFormation publiqueFormation = publiqueFormationConverter.toItem(publiqueFormationVo);
            return publiqueFormationService.delete(publiqueFormation);
            }

            @ApiOperation("Deletes a publiqueFormation by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return publiqueFormationService.deleteById(id);
            }




            @PutMapping("/archiver/")
            public PubliqueFormationVo archiver(@RequestBody PubliqueFormationVo publiqueFormationVo){
                PubliqueFormation publiqueFormation = publiqueFormationService.archiver(publiqueFormationConverter.toItem(publiqueFormationVo));
                return publiqueFormationConverter.toVo(publiqueFormation);
                }

            @PutMapping("/desarchiver/")
            public PubliqueFormationVo desarchiver(@RequestBody PubliqueFormationVo publiqueFormationVo){
                PubliqueFormation publiqueFormation = publiqueFormationService.desarchiver(publiqueFormationConverter.toItem(publiqueFormationVo));
                return publiqueFormationConverter.toVo(publiqueFormation);}
            }
