package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.CaracterisationDeveloppementDeSavoirEtInnovationScientifiqueAdminService;

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
import com.ird.faa.bean.formulaire.CaracterisationDeveloppementDeSavoirEtInnovationScientifique;
import com.ird.faa.ws.rest.provided.converter.CaracterisationDeveloppementDeSavoirEtInnovationScientifiqueConverter;
import com.ird.faa.ws.rest.provided.vo.CaracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo;

@Api("Manages caracterisationDeveloppementDeSavoirEtInnovationScientifique services")
@RestController
@RequestMapping("api/admin/caracterisationDeveloppementDeSavoirEtInnovationScientifique")
public class CaracterisationDeveloppementDeSavoirEtInnovationScientifiqueRestAdmin {

@Autowired
private CaracterisationDeveloppementDeSavoirEtInnovationScientifiqueAdminService caracterisationDeveloppementDeSavoirEtInnovationScientifiqueService;

@Autowired
private CaracterisationDeveloppementDeSavoirEtInnovationScientifiqueConverter caracterisationDeveloppementDeSavoirEtInnovationScientifiqueConverter;


            @ApiOperation("Updates the specified  caracterisationDeveloppementDeSavoirEtInnovationScientifique")
            @PutMapping("/")
            public  CaracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo update(@RequestBody  CaracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo  caracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo){
            CaracterisationDeveloppementDeSavoirEtInnovationScientifique caracterisationDeveloppementDeSavoirEtInnovationScientifique = caracterisationDeveloppementDeSavoirEtInnovationScientifiqueConverter.toItem(caracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo);
            caracterisationDeveloppementDeSavoirEtInnovationScientifique = caracterisationDeveloppementDeSavoirEtInnovationScientifiqueService.update(caracterisationDeveloppementDeSavoirEtInnovationScientifique);
            return caracterisationDeveloppementDeSavoirEtInnovationScientifiqueConverter.toVo(caracterisationDeveloppementDeSavoirEtInnovationScientifique);
            }

    @ApiOperation("Finds a list of all caracterisationDeveloppementDeSavoirEtInnovationScientifiques")
    @GetMapping("/")
    public List<CaracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo> findAll(){
        return caracterisationDeveloppementDeSavoirEtInnovationScientifiqueConverter.toVo(caracterisationDeveloppementDeSavoirEtInnovationScientifiqueService.findAll());
    }

    @ApiOperation("Finds a caracterisationDeveloppementDeSavoirEtInnovationScientifique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CaracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return caracterisationDeveloppementDeSavoirEtInnovationScientifiqueConverter.toVo(caracterisationDeveloppementDeSavoirEtInnovationScientifiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search caracterisationDeveloppementDeSavoirEtInnovationScientifique by a specific criteria")
    @PostMapping("/search")
    public List<CaracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo> findByCriteria(@RequestBody CaracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo caracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo){
        return caracterisationDeveloppementDeSavoirEtInnovationScientifiqueConverter.toVo(caracterisationDeveloppementDeSavoirEtInnovationScientifiqueService.findByCriteria(caracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo));
        }

            @ApiOperation("Finds a caracterisationDeveloppementDeSavoirEtInnovationScientifique by id")
            @GetMapping("/id/{id}")
            public CaracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo findById(@PathVariable Long id){
            return caracterisationDeveloppementDeSavoirEtInnovationScientifiqueConverter.toVo(caracterisationDeveloppementDeSavoirEtInnovationScientifiqueService.findById(id));
            }

            @ApiOperation("Saves the specified  caracterisationDeveloppementDeSavoirEtInnovationScientifique")
            @PostMapping("/")
            public CaracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo save(@RequestBody CaracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo caracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo){
            CaracterisationDeveloppementDeSavoirEtInnovationScientifique caracterisationDeveloppementDeSavoirEtInnovationScientifique = caracterisationDeveloppementDeSavoirEtInnovationScientifiqueConverter.toItem(caracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo);
            caracterisationDeveloppementDeSavoirEtInnovationScientifique = caracterisationDeveloppementDeSavoirEtInnovationScientifiqueService.save(caracterisationDeveloppementDeSavoirEtInnovationScientifique);
            return caracterisationDeveloppementDeSavoirEtInnovationScientifiqueConverter.toVo(caracterisationDeveloppementDeSavoirEtInnovationScientifique);
            }

            @ApiOperation("Delete the specified caracterisationDeveloppementDeSavoirEtInnovationScientifique")
            @DeleteMapping("/")
            public int delete(@RequestBody CaracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo caracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo){
            CaracterisationDeveloppementDeSavoirEtInnovationScientifique caracterisationDeveloppementDeSavoirEtInnovationScientifique = caracterisationDeveloppementDeSavoirEtInnovationScientifiqueConverter.toItem(caracterisationDeveloppementDeSavoirEtInnovationScientifiqueVo);
            return caracterisationDeveloppementDeSavoirEtInnovationScientifiqueService.delete(caracterisationDeveloppementDeSavoirEtInnovationScientifique);
            }

            @ApiOperation("Deletes a caracterisationDeveloppementDeSavoirEtInnovationScientifique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return caracterisationDeveloppementDeSavoirEtInnovationScientifiqueService.deleteById(id);
            }


        }
