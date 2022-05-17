package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.VieInstitutionnelleDetailAdminService;

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
import com.ird.faa.bean.formulaire.VieInstitutionnelleDetail;
import com.ird.faa.ws.rest.provided.converter.VieInstitutionnelleDetailConverter;
import com.ird.faa.ws.rest.provided.vo.VieInstitutionnelleDetailVo;

@Api("Manages vieInstitutionnelleDetail services")
@RestController
@RequestMapping("api/admin/vieInstitutionnelleDetail")
public class VieInstitutionnelleDetailRestAdmin {

@Autowired
private VieInstitutionnelleDetailAdminService vieInstitutionnelleDetailService;

@Autowired
private VieInstitutionnelleDetailConverter vieInstitutionnelleDetailConverter;


            @ApiOperation("Updates the specified  vieInstitutionnelleDetail")
            @PutMapping("/")
            public  VieInstitutionnelleDetailVo update(@RequestBody  VieInstitutionnelleDetailVo  vieInstitutionnelleDetailVo){
            VieInstitutionnelleDetail vieInstitutionnelleDetail = vieInstitutionnelleDetailConverter.toItem(vieInstitutionnelleDetailVo);
            vieInstitutionnelleDetail = vieInstitutionnelleDetailService.update(vieInstitutionnelleDetail);
            return vieInstitutionnelleDetailConverter.toVo(vieInstitutionnelleDetail);
            }

    @ApiOperation("Finds a list of all vieInstitutionnelleDetails")
    @GetMapping("/")
    public List<VieInstitutionnelleDetailVo> findAll(){
        return vieInstitutionnelleDetailConverter.toVo(vieInstitutionnelleDetailService.findAll());
    }

    @ApiOperation("Finds a vieInstitutionnelleDetail with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public VieInstitutionnelleDetailVo findByIdWithAssociatedList(@PathVariable Long id){
    return vieInstitutionnelleDetailConverter.toVo(vieInstitutionnelleDetailService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search vieInstitutionnelleDetail by a specific criteria")
    @PostMapping("/search")
    public List<VieInstitutionnelleDetailVo> findByCriteria(@RequestBody VieInstitutionnelleDetailVo vieInstitutionnelleDetailVo){
        return vieInstitutionnelleDetailConverter.toVo(vieInstitutionnelleDetailService.findByCriteria(vieInstitutionnelleDetailVo));
        }

            @ApiOperation("Finds a vieInstitutionnelleDetail by id")
            @GetMapping("/id/{id}")
            public VieInstitutionnelleDetailVo findById(@PathVariable Long id){
            return vieInstitutionnelleDetailConverter.toVo(vieInstitutionnelleDetailService.findById(id));
            }

            @ApiOperation("Saves the specified  vieInstitutionnelleDetail")
            @PostMapping("/")
            public VieInstitutionnelleDetailVo save(@RequestBody VieInstitutionnelleDetailVo vieInstitutionnelleDetailVo){
            VieInstitutionnelleDetail vieInstitutionnelleDetail = vieInstitutionnelleDetailConverter.toItem(vieInstitutionnelleDetailVo);
            vieInstitutionnelleDetail = vieInstitutionnelleDetailService.save(vieInstitutionnelleDetail);
            return vieInstitutionnelleDetailConverter.toVo(vieInstitutionnelleDetail);
            }

            @ApiOperation("Delete the specified vieInstitutionnelleDetail")
            @DeleteMapping("/")
            public int delete(@RequestBody VieInstitutionnelleDetailVo vieInstitutionnelleDetailVo){
            VieInstitutionnelleDetail vieInstitutionnelleDetail = vieInstitutionnelleDetailConverter.toItem(vieInstitutionnelleDetailVo);
            return vieInstitutionnelleDetailService.delete(vieInstitutionnelleDetail);
            }

            @ApiOperation("Deletes a vieInstitutionnelleDetail by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return vieInstitutionnelleDetailService.deleteById(id);
            }


        }
