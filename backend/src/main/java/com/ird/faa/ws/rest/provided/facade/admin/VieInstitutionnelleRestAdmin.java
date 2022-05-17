package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.VieInstitutionnelleAdminService;

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
import com.ird.faa.bean.referentiel.VieInstitutionnelle;
import com.ird.faa.ws.rest.provided.converter.VieInstitutionnelleConverter;
import com.ird.faa.ws.rest.provided.vo.VieInstitutionnelleVo;

@Api("Manages vieInstitutionnelle services")
@RestController
@RequestMapping("api/admin/vieInstitutionnelle")
public class VieInstitutionnelleRestAdmin {

@Autowired
private VieInstitutionnelleAdminService vieInstitutionnelleService;

@Autowired
private VieInstitutionnelleConverter vieInstitutionnelleConverter;


            @ApiOperation("Updates the specified  vieInstitutionnelle")
            @PutMapping("/")
            public  VieInstitutionnelleVo update(@RequestBody  VieInstitutionnelleVo  vieInstitutionnelleVo){
            VieInstitutionnelle vieInstitutionnelle = vieInstitutionnelleConverter.toItem(vieInstitutionnelleVo);
            vieInstitutionnelle = vieInstitutionnelleService.update(vieInstitutionnelle);
            return vieInstitutionnelleConverter.toVo(vieInstitutionnelle);
            }

    @ApiOperation("Finds a list of all vieInstitutionnelles")
    @GetMapping("/")
    public List<VieInstitutionnelleVo> findAll(){
        return vieInstitutionnelleConverter.toVo(vieInstitutionnelleService.findAll());
    }

    @ApiOperation("Finds a vieInstitutionnelle with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public VieInstitutionnelleVo findByIdWithAssociatedList(@PathVariable Long id){
    return vieInstitutionnelleConverter.toVo(vieInstitutionnelleService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search vieInstitutionnelle by a specific criteria")
    @PostMapping("/search")
    public List<VieInstitutionnelleVo> findByCriteria(@RequestBody VieInstitutionnelleVo vieInstitutionnelleVo){
        return vieInstitutionnelleConverter.toVo(vieInstitutionnelleService.findByCriteria(vieInstitutionnelleVo));
        }

            @ApiOperation("Finds a vieInstitutionnelle by id")
            @GetMapping("/id/{id}")
            public VieInstitutionnelleVo findById(@PathVariable Long id){
            return vieInstitutionnelleConverter.toVo(vieInstitutionnelleService.findById(id));
            }

            @ApiOperation("Saves the specified  vieInstitutionnelle")
            @PostMapping("/")
            public VieInstitutionnelleVo save(@RequestBody VieInstitutionnelleVo vieInstitutionnelleVo){
            VieInstitutionnelle vieInstitutionnelle = vieInstitutionnelleConverter.toItem(vieInstitutionnelleVo);
            vieInstitutionnelle = vieInstitutionnelleService.save(vieInstitutionnelle);
            return vieInstitutionnelleConverter.toVo(vieInstitutionnelle);
            }

            @ApiOperation("Delete the specified vieInstitutionnelle")
            @DeleteMapping("/")
            public int delete(@RequestBody VieInstitutionnelleVo vieInstitutionnelleVo){
            VieInstitutionnelle vieInstitutionnelle = vieInstitutionnelleConverter.toItem(vieInstitutionnelleVo);
            return vieInstitutionnelleService.delete(vieInstitutionnelle);
            }

            @ApiOperation("Deletes a vieInstitutionnelle by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return vieInstitutionnelleService.deleteById(id);
            }


        }
