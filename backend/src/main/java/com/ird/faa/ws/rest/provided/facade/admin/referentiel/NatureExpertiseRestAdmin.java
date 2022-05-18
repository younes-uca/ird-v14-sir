package main.java.com.ird.faa.ws.rest.provided.facade.admin.referentiel;

import com.ird.faa.bean.referentiel.NatureExpertise;
import com.ird.faa.service.admin.facade.formulaire.NatureExpertiseAdminService;
import main.java.com.ird.faa.ws.rest.provided.converter.referentiel.NatureExpertiseConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.NatureExpertiseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages natureExpertise services")
@RestController
@RequestMapping("api/admin/natureExpertise")
public class NatureExpertiseRestAdmin {

@Autowired
private NatureExpertiseAdminService natureExpertiseService;

@Autowired
private NatureExpertiseConverter natureExpertiseConverter;


            @ApiOperation("Updates the specified  natureExpertise")
            @PutMapping("/")
            public  NatureExpertiseVo update(@RequestBody  NatureExpertiseVo  natureExpertiseVo){
            NatureExpertise natureExpertise = natureExpertiseConverter.toItem(natureExpertiseVo);
            natureExpertise = natureExpertiseService.update(natureExpertise);
            return natureExpertiseConverter.toVo(natureExpertise);
            }

    @ApiOperation("Finds a list of all natureExpertises")
    @GetMapping("/")
    public List<NatureExpertiseVo> findAll(){
        return natureExpertiseConverter.toVo(natureExpertiseService.findAll());
    }

    @ApiOperation("Finds a natureExpertise with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public NatureExpertiseVo findByIdWithAssociatedList(@PathVariable Long id){
    return natureExpertiseConverter.toVo(natureExpertiseService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search natureExpertise by a specific criteria")
    @PostMapping("/search")
    public List<NatureExpertiseVo> findByCriteria(@RequestBody NatureExpertiseVo natureExpertiseVo){
        return natureExpertiseConverter.toVo(natureExpertiseService.findByCriteria(natureExpertiseVo));
        }

            @ApiOperation("Finds a natureExpertise by id")
            @GetMapping("/id/{id}")
            public NatureExpertiseVo findById(@PathVariable Long id){
            return natureExpertiseConverter.toVo(natureExpertiseService.findById(id));
            }

            @ApiOperation("Saves the specified  natureExpertise")
            @PostMapping("/")
            public NatureExpertiseVo save(@RequestBody NatureExpertiseVo natureExpertiseVo){
            NatureExpertise natureExpertise = natureExpertiseConverter.toItem(natureExpertiseVo);
            natureExpertise = natureExpertiseService.save(natureExpertise);
            return natureExpertiseConverter.toVo(natureExpertise);
            }

            @ApiOperation("Delete the specified natureExpertise")
            @DeleteMapping("/")
            public int delete(@RequestBody NatureExpertiseVo natureExpertiseVo){
            NatureExpertise natureExpertise = natureExpertiseConverter.toItem(natureExpertiseVo);
            return natureExpertiseService.delete(natureExpertise);
            }

            @ApiOperation("Deletes a natureExpertise by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return natureExpertiseService.deleteById(id);
            }




            @PutMapping("/archiver/")
            public NatureExpertiseVo archiver(@RequestBody NatureExpertiseVo natureExpertiseVo){
                NatureExpertise natureExpertise = natureExpertiseService.archiver(natureExpertiseConverter.toItem(natureExpertiseVo));
                return natureExpertiseConverter.toVo(natureExpertise);
                }

            @PutMapping("/desarchiver/")
            public NatureExpertiseVo desarchiver(@RequestBody NatureExpertiseVo natureExpertiseVo){
                NatureExpertise natureExpertise = natureExpertiseService.desarchiver(natureExpertiseConverter.toItem(natureExpertiseVo));
                return natureExpertiseConverter.toVo(natureExpertise);}
            }
