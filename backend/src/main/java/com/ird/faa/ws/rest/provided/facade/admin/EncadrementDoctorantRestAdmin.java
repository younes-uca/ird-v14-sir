package  com.ird.faa.ws.rest.provided.facade.admin;

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

import com.ird.faa.bean.formulaire.EncadrementDoctorant;
import com.ird.faa.service.admin.facade.formulaire.EncadrementDoctorantAdminService;
import com.ird.faa.ws.rest.provided.converter.EncadrementDoctorantConverter;
import com.ird.faa.ws.rest.provided.vo.EncadrementDoctorantVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Manages encadrementDoctorant services")
@RestController
@RequestMapping("api/admin/encadrementDoctorant")
public class EncadrementDoctorantRestAdmin {

@Autowired
private EncadrementDoctorantAdminService encadrementDoctorantService;

@Autowired
private EncadrementDoctorantConverter encadrementDoctorantConverter;


            @ApiOperation("Updates the specified  encadrementDoctorant")
            @PutMapping("/")
            public  EncadrementDoctorantVo update(@RequestBody  EncadrementDoctorantVo  encadrementDoctorantVo){
            EncadrementDoctorant encadrementDoctorant = encadrementDoctorantConverter.toItem(encadrementDoctorantVo);
            encadrementDoctorant = encadrementDoctorantService.update(encadrementDoctorant);
            return encadrementDoctorantConverter.toVo(encadrementDoctorant);
            }

    @ApiOperation("Finds a list of all encadrementDoctorants")
    @GetMapping("/")
    public List<EncadrementDoctorantVo> findAll(){
        return encadrementDoctorantConverter.toVo(encadrementDoctorantService.findAll());
    }

    @ApiOperation("Finds a encadrementDoctorant with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EncadrementDoctorantVo findByIdWithAssociatedList(@PathVariable Long id){
    return encadrementDoctorantConverter.toVo(encadrementDoctorantService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search encadrementDoctorant by a specific criteria")
    @PostMapping("/search")
    public List<EncadrementDoctorantVo> findByCriteria(@RequestBody EncadrementDoctorantVo encadrementDoctorantVo){
        return encadrementDoctorantConverter.toVo(encadrementDoctorantService.findByCriteria(encadrementDoctorantVo));
        }

            @ApiOperation("Finds a encadrementDoctorant by id")
            @GetMapping("/id/{id}")
            public EncadrementDoctorantVo findById(@PathVariable Long id){
            return encadrementDoctorantConverter.toVo(encadrementDoctorantService.findById(id));
            }

            @ApiOperation("Saves the specified  encadrementDoctorant")
            @PostMapping("/")
            public EncadrementDoctorantVo save(@RequestBody EncadrementDoctorantVo encadrementDoctorantVo){
            EncadrementDoctorant encadrementDoctorant = encadrementDoctorantConverter.toItem(encadrementDoctorantVo);
            encadrementDoctorant = encadrementDoctorantService.save(encadrementDoctorant);
            return encadrementDoctorantConverter.toVo(encadrementDoctorant);
            }

            @ApiOperation("Delete the specified encadrementDoctorant")
            @DeleteMapping("/")
            public int delete(@RequestBody EncadrementDoctorantVo encadrementDoctorantVo){
            EncadrementDoctorant encadrementDoctorant = encadrementDoctorantConverter.toItem(encadrementDoctorantVo);
            return encadrementDoctorantService.delete(encadrementDoctorant);
            }

            @ApiOperation("Deletes a encadrementDoctorant by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return encadrementDoctorantService.deleteById(id);
            }


        }
