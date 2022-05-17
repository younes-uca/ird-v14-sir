package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.EcoleDoctoraleAdminService;

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
import com.ird.faa.bean.formulaire.EcoleDoctorale;
import com.ird.faa.ws.rest.provided.converter.EcoleDoctoraleConverter;
import com.ird.faa.ws.rest.provided.vo.EcoleDoctoraleVo;

@Api("Manages ecoleDoctorale services")
@RestController
@RequestMapping("api/admin/ecoleDoctorale")
public class EcoleDoctoraleRestAdmin {

@Autowired
private EcoleDoctoraleAdminService ecoleDoctoraleService;

@Autowired
private EcoleDoctoraleConverter ecoleDoctoraleConverter;


            @ApiOperation("Updates the specified  ecoleDoctorale")
            @PutMapping("/")
            public  EcoleDoctoraleVo update(@RequestBody  EcoleDoctoraleVo  ecoleDoctoraleVo){
            EcoleDoctorale ecoleDoctorale = ecoleDoctoraleConverter.toItem(ecoleDoctoraleVo);
            ecoleDoctorale = ecoleDoctoraleService.update(ecoleDoctorale);
            return ecoleDoctoraleConverter.toVo(ecoleDoctorale);
            }

    @ApiOperation("Finds a list of all ecoleDoctorales")
    @GetMapping("/")
    public List<EcoleDoctoraleVo> findAll(){
        return ecoleDoctoraleConverter.toVo(ecoleDoctoraleService.findAll());
    }

    @ApiOperation("Finds a ecoleDoctorale with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EcoleDoctoraleVo findByIdWithAssociatedList(@PathVariable Long id){
    return ecoleDoctoraleConverter.toVo(ecoleDoctoraleService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search ecoleDoctorale by a specific criteria")
    @PostMapping("/search")
    public List<EcoleDoctoraleVo> findByCriteria(@RequestBody EcoleDoctoraleVo ecoleDoctoraleVo){
        return ecoleDoctoraleConverter.toVo(ecoleDoctoraleService.findByCriteria(ecoleDoctoraleVo));
        }

            @ApiOperation("Finds a ecoleDoctorale by id")
            @GetMapping("/id/{id}")
            public EcoleDoctoraleVo findById(@PathVariable Long id){
            return ecoleDoctoraleConverter.toVo(ecoleDoctoraleService.findById(id));
            }

            @ApiOperation("Saves the specified  ecoleDoctorale")
            @PostMapping("/")
            public EcoleDoctoraleVo save(@RequestBody EcoleDoctoraleVo ecoleDoctoraleVo){
            EcoleDoctorale ecoleDoctorale = ecoleDoctoraleConverter.toItem(ecoleDoctoraleVo);
            ecoleDoctorale = ecoleDoctoraleService.save(ecoleDoctorale);
            return ecoleDoctoraleConverter.toVo(ecoleDoctorale);
            }

            @ApiOperation("Delete the specified ecoleDoctorale")
            @DeleteMapping("/")
            public int delete(@RequestBody EcoleDoctoraleVo ecoleDoctoraleVo){
            EcoleDoctorale ecoleDoctorale = ecoleDoctoraleConverter.toItem(ecoleDoctoraleVo);
            return ecoleDoctoraleService.delete(ecoleDoctorale);
            }

            @ApiOperation("Deletes a ecoleDoctorale by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return ecoleDoctoraleService.deleteById(id);
            }


        }
