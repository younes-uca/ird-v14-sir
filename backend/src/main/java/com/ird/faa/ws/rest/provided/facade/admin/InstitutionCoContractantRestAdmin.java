package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.InstitutionCoContractantAdminService;

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
import com.ird.faa.bean.formulaire.InstitutionCoContractant;
import com.ird.faa.ws.rest.provided.converter.InstitutionCoContractantConverter;
import com.ird.faa.ws.rest.provided.vo.InstitutionCoContractantVo;

@Api("Manages institutionCoContractant services")
@RestController
@RequestMapping("api/admin/institutionCoContractant")
public class InstitutionCoContractantRestAdmin {

@Autowired
private InstitutionCoContractantAdminService institutionCoContractantService;

@Autowired
private InstitutionCoContractantConverter institutionCoContractantConverter;


            @ApiOperation("Updates the specified  institutionCoContractant")
            @PutMapping("/")
            public  InstitutionCoContractantVo update(@RequestBody  InstitutionCoContractantVo  institutionCoContractantVo){
            InstitutionCoContractant institutionCoContractant = institutionCoContractantConverter.toItem(institutionCoContractantVo);
            institutionCoContractant = institutionCoContractantService.update(institutionCoContractant);
            return institutionCoContractantConverter.toVo(institutionCoContractant);
            }

    @ApiOperation("Finds a list of all institutionCoContractants")
    @GetMapping("/")
    public List<InstitutionCoContractantVo> findAll(){
        return institutionCoContractantConverter.toVo(institutionCoContractantService.findAll());
    }

    @ApiOperation("Finds a institutionCoContractant with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public InstitutionCoContractantVo findByIdWithAssociatedList(@PathVariable Long id){
    return institutionCoContractantConverter.toVo(institutionCoContractantService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search institutionCoContractant by a specific criteria")
    @PostMapping("/search")
    public List<InstitutionCoContractantVo> findByCriteria(@RequestBody InstitutionCoContractantVo institutionCoContractantVo){
        return institutionCoContractantConverter.toVo(institutionCoContractantService.findByCriteria(institutionCoContractantVo));
        }

            @ApiOperation("Finds a institutionCoContractant by id")
            @GetMapping("/id/{id}")
            public InstitutionCoContractantVo findById(@PathVariable Long id){
            return institutionCoContractantConverter.toVo(institutionCoContractantService.findById(id));
            }

            @ApiOperation("Saves the specified  institutionCoContractant")
            @PostMapping("/")
            public InstitutionCoContractantVo save(@RequestBody InstitutionCoContractantVo institutionCoContractantVo){
            InstitutionCoContractant institutionCoContractant = institutionCoContractantConverter.toItem(institutionCoContractantVo);
            institutionCoContractant = institutionCoContractantService.save(institutionCoContractant);
            return institutionCoContractantConverter.toVo(institutionCoContractant);
            }

            @ApiOperation("Delete the specified institutionCoContractant")
            @DeleteMapping("/")
            public int delete(@RequestBody InstitutionCoContractantVo institutionCoContractantVo){
            InstitutionCoContractant institutionCoContractant = institutionCoContractantConverter.toItem(institutionCoContractantVo);
            return institutionCoContractantService.delete(institutionCoContractant);
            }

            @ApiOperation("Deletes a institutionCoContractant by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return institutionCoContractantService.deleteById(id);
            }


        }
