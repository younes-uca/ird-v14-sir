package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.VieInstitutionnelleDetailEtablissementAdminService;

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
import com.ird.faa.bean.formulaire.VieInstitutionnelleDetailEtablissement;
import com.ird.faa.ws.rest.provided.converter.VieInstitutionnelleDetailEtablissementConverter;
import com.ird.faa.ws.rest.provided.vo.VieInstitutionnelleDetailEtablissementVo;

@Api("Manages vieInstitutionnelleDetailEtablissement services")
@RestController
@RequestMapping("api/admin/vieInstitutionnelleDetailEtablissement")
public class VieInstitutionnelleDetailEtablissementRestAdmin {

@Autowired
private VieInstitutionnelleDetailEtablissementAdminService vieInstitutionnelleDetailEtablissementService;

@Autowired
private VieInstitutionnelleDetailEtablissementConverter vieInstitutionnelleDetailEtablissementConverter;


            @ApiOperation("Updates the specified  vieInstitutionnelleDetailEtablissement")
            @PutMapping("/")
            public  VieInstitutionnelleDetailEtablissementVo update(@RequestBody  VieInstitutionnelleDetailEtablissementVo  vieInstitutionnelleDetailEtablissementVo){
            VieInstitutionnelleDetailEtablissement vieInstitutionnelleDetailEtablissement = vieInstitutionnelleDetailEtablissementConverter.toItem(vieInstitutionnelleDetailEtablissementVo);
            vieInstitutionnelleDetailEtablissement = vieInstitutionnelleDetailEtablissementService.update(vieInstitutionnelleDetailEtablissement);
            return vieInstitutionnelleDetailEtablissementConverter.toVo(vieInstitutionnelleDetailEtablissement);
            }

    @ApiOperation("Finds a list of all vieInstitutionnelleDetailEtablissements")
    @GetMapping("/")
    public List<VieInstitutionnelleDetailEtablissementVo> findAll(){
        return vieInstitutionnelleDetailEtablissementConverter.toVo(vieInstitutionnelleDetailEtablissementService.findAll());
    }

    @ApiOperation("Finds a vieInstitutionnelleDetailEtablissement with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public VieInstitutionnelleDetailEtablissementVo findByIdWithAssociatedList(@PathVariable Long id){
    return vieInstitutionnelleDetailEtablissementConverter.toVo(vieInstitutionnelleDetailEtablissementService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search vieInstitutionnelleDetailEtablissement by a specific criteria")
    @PostMapping("/search")
    public List<VieInstitutionnelleDetailEtablissementVo> findByCriteria(@RequestBody VieInstitutionnelleDetailEtablissementVo vieInstitutionnelleDetailEtablissementVo){
        return vieInstitutionnelleDetailEtablissementConverter.toVo(vieInstitutionnelleDetailEtablissementService.findByCriteria(vieInstitutionnelleDetailEtablissementVo));
        }

            @ApiOperation("Finds a vieInstitutionnelleDetailEtablissement by id")
            @GetMapping("/id/{id}")
            public VieInstitutionnelleDetailEtablissementVo findById(@PathVariable Long id){
            return vieInstitutionnelleDetailEtablissementConverter.toVo(vieInstitutionnelleDetailEtablissementService.findById(id));
            }

            @ApiOperation("Saves the specified  vieInstitutionnelleDetailEtablissement")
            @PostMapping("/")
            public VieInstitutionnelleDetailEtablissementVo save(@RequestBody VieInstitutionnelleDetailEtablissementVo vieInstitutionnelleDetailEtablissementVo){
            VieInstitutionnelleDetailEtablissement vieInstitutionnelleDetailEtablissement = vieInstitutionnelleDetailEtablissementConverter.toItem(vieInstitutionnelleDetailEtablissementVo);
            vieInstitutionnelleDetailEtablissement = vieInstitutionnelleDetailEtablissementService.save(vieInstitutionnelleDetailEtablissement);
            return vieInstitutionnelleDetailEtablissementConverter.toVo(vieInstitutionnelleDetailEtablissement);
            }

            @ApiOperation("Delete the specified vieInstitutionnelleDetailEtablissement")
            @DeleteMapping("/")
            public int delete(@RequestBody VieInstitutionnelleDetailEtablissementVo vieInstitutionnelleDetailEtablissementVo){
            VieInstitutionnelleDetailEtablissement vieInstitutionnelleDetailEtablissement = vieInstitutionnelleDetailEtablissementConverter.toItem(vieInstitutionnelleDetailEtablissementVo);
            return vieInstitutionnelleDetailEtablissementService.delete(vieInstitutionnelleDetailEtablissement);
            }

            @ApiOperation("Deletes a vieInstitutionnelleDetailEtablissement by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return vieInstitutionnelleDetailEtablissementService.deleteById(id);
            }


        }
