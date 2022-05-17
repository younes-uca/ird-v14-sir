package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.formulaire.StatutEcoleDoctoraleChercheurService;

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
import com.ird.faa.bean.referentiel.StatutEcoleDoctorale;
import com.ird.faa.ws.rest.provided.converter.StatutEcoleDoctoraleConverter;
import com.ird.faa.ws.rest.provided.vo.StatutEcoleDoctoraleVo;

@Api("Manages statutEcoleDoctorale services")
@RestController
@RequestMapping("api/chercheur/statutEcoleDoctorale")
public class StatutEcoleDoctoraleRestChercheur {

@Autowired
private StatutEcoleDoctoraleChercheurService statutEcoleDoctoraleService;

@Autowired
private StatutEcoleDoctoraleConverter statutEcoleDoctoraleConverter;


            @ApiOperation("Updates the specified  statutEcoleDoctorale")
            @PutMapping("/")
            public  StatutEcoleDoctoraleVo update(@RequestBody  StatutEcoleDoctoraleVo  statutEcoleDoctoraleVo){
            StatutEcoleDoctorale statutEcoleDoctorale = statutEcoleDoctoraleConverter.toItem(statutEcoleDoctoraleVo);
            statutEcoleDoctorale = statutEcoleDoctoraleService.update(statutEcoleDoctorale);
            return statutEcoleDoctoraleConverter.toVo(statutEcoleDoctorale);
            }

    @ApiOperation("Finds a list of all statutEcoleDoctorales")
    @GetMapping("/")
    public List<StatutEcoleDoctoraleVo> findAll(){
        return statutEcoleDoctoraleConverter.toVo(statutEcoleDoctoraleService.findAll());
    }

    @ApiOperation("Finds a statutEcoleDoctorale with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public StatutEcoleDoctoraleVo findByIdWithAssociatedList(@PathVariable Long id){
    return statutEcoleDoctoraleConverter.toVo(statutEcoleDoctoraleService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search statutEcoleDoctorale by a specific criteria")
    @PostMapping("/search")
    public List<StatutEcoleDoctoraleVo> findByCriteria(@RequestBody StatutEcoleDoctoraleVo statutEcoleDoctoraleVo){
        return statutEcoleDoctoraleConverter.toVo(statutEcoleDoctoraleService.findByCriteria(statutEcoleDoctoraleVo));
        }

            @ApiOperation("Finds a statutEcoleDoctorale by id")
            @GetMapping("/id/{id}")
            public StatutEcoleDoctoraleVo findById(@PathVariable Long id){
            return statutEcoleDoctoraleConverter.toVo(statutEcoleDoctoraleService.findById(id));
            }

            @ApiOperation("Saves the specified  statutEcoleDoctorale")
            @PostMapping("/")
            public StatutEcoleDoctoraleVo save(@RequestBody StatutEcoleDoctoraleVo statutEcoleDoctoraleVo){
            StatutEcoleDoctorale statutEcoleDoctorale = statutEcoleDoctoraleConverter.toItem(statutEcoleDoctoraleVo);
            statutEcoleDoctorale = statutEcoleDoctoraleService.save(statutEcoleDoctorale);
            return statutEcoleDoctoraleConverter.toVo(statutEcoleDoctorale);
            }

            @ApiOperation("Delete the specified statutEcoleDoctorale")
            @DeleteMapping("/")
            public int delete(@RequestBody StatutEcoleDoctoraleVo statutEcoleDoctoraleVo){
            StatutEcoleDoctorale statutEcoleDoctorale = statutEcoleDoctoraleConverter.toItem(statutEcoleDoctoraleVo);
            return statutEcoleDoctoraleService.delete(statutEcoleDoctorale);
            }

            @ApiOperation("Deletes a statutEcoleDoctorale by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return statutEcoleDoctoraleService.deleteById(id);
            }


        }
