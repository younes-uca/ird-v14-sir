package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.IdentifiantAuteurExpertAdminService;

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
import com.ird.faa.bean.formulaire.IdentifiantAuteurExpert;
import com.ird.faa.ws.rest.provided.converter.IdentifiantAuteurExpertConverter;
import com.ird.faa.ws.rest.provided.vo.IdentifiantAuteurExpertVo;

@Api("Manages identifiantAuteurExpert services")
@RestController
@RequestMapping("api/admin/identifiantAuteurExpert")
public class IdentifiantAuteurExpertRestAdmin {

@Autowired
private IdentifiantAuteurExpertAdminService identifiantAuteurExpertService;

@Autowired
private IdentifiantAuteurExpertConverter identifiantAuteurExpertConverter;


            @ApiOperation("Updates the specified  identifiantAuteurExpert")
            @PutMapping("/")
            public  IdentifiantAuteurExpertVo update(@RequestBody  IdentifiantAuteurExpertVo  identifiantAuteurExpertVo){
            IdentifiantAuteurExpert identifiantAuteurExpert = identifiantAuteurExpertConverter.toItem(identifiantAuteurExpertVo);
            identifiantAuteurExpert = identifiantAuteurExpertService.update(identifiantAuteurExpert);
            return identifiantAuteurExpertConverter.toVo(identifiantAuteurExpert);
            }

    @ApiOperation("Finds a list of all identifiantAuteurExperts")
    @GetMapping("/")
    public List<IdentifiantAuteurExpertVo> findAll(){
        return identifiantAuteurExpertConverter.toVo(identifiantAuteurExpertService.findAll());
    }

    @ApiOperation("Finds a identifiantAuteurExpert with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public IdentifiantAuteurExpertVo findByIdWithAssociatedList(@PathVariable Long id){
    return identifiantAuteurExpertConverter.toVo(identifiantAuteurExpertService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search identifiantAuteurExpert by a specific criteria")
    @PostMapping("/search")
    public List<IdentifiantAuteurExpertVo> findByCriteria(@RequestBody IdentifiantAuteurExpertVo identifiantAuteurExpertVo){
        return identifiantAuteurExpertConverter.toVo(identifiantAuteurExpertService.findByCriteria(identifiantAuteurExpertVo));
        }

            @ApiOperation("Finds a identifiantAuteurExpert by id")
            @GetMapping("/id/{id}")
            public IdentifiantAuteurExpertVo findById(@PathVariable Long id){
            return identifiantAuteurExpertConverter.toVo(identifiantAuteurExpertService.findById(id));
            }

            @ApiOperation("Saves the specified  identifiantAuteurExpert")
            @PostMapping("/")
            public IdentifiantAuteurExpertVo save(@RequestBody IdentifiantAuteurExpertVo identifiantAuteurExpertVo){
            IdentifiantAuteurExpert identifiantAuteurExpert = identifiantAuteurExpertConverter.toItem(identifiantAuteurExpertVo);
            identifiantAuteurExpert = identifiantAuteurExpertService.save(identifiantAuteurExpert);
            return identifiantAuteurExpertConverter.toVo(identifiantAuteurExpert);
            }

            @ApiOperation("Delete the specified identifiantAuteurExpert")
            @DeleteMapping("/")
            public int delete(@RequestBody IdentifiantAuteurExpertVo identifiantAuteurExpertVo){
            IdentifiantAuteurExpert identifiantAuteurExpert = identifiantAuteurExpertConverter.toItem(identifiantAuteurExpertVo);
            return identifiantAuteurExpertService.delete(identifiantAuteurExpert);
            }

            @ApiOperation("Deletes a identifiantAuteurExpert by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return identifiantAuteurExpertService.deleteById(id);
            }


        }
