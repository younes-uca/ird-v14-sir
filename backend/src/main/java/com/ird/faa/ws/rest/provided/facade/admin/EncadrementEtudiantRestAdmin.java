package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.EncadrementEtudiantAdminService;

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
import com.ird.faa.bean.formulaire.EncadrementEtudiant;
import com.ird.faa.ws.rest.provided.converter.EncadrementEtudiantConverter;
import com.ird.faa.ws.rest.provided.vo.EncadrementEtudiantVo;

@Api("Manages encadrementEtudiant services")
@RestController
@RequestMapping("api/admin/encadrementEtudiant")
public class EncadrementEtudiantRestAdmin {

@Autowired
private EncadrementEtudiantAdminService encadrementEtudiantService;

@Autowired
private EncadrementEtudiantConverter encadrementEtudiantConverter;


            @ApiOperation("Updates the specified  encadrementEtudiant")
            @PutMapping("/")
            public  EncadrementEtudiantVo update(@RequestBody  EncadrementEtudiantVo  encadrementEtudiantVo){
            EncadrementEtudiant encadrementEtudiant = encadrementEtudiantConverter.toItem(encadrementEtudiantVo);
            encadrementEtudiant = encadrementEtudiantService.update(encadrementEtudiant);
            return encadrementEtudiantConverter.toVo(encadrementEtudiant);
            }

    @ApiOperation("Finds a list of all encadrementEtudiants")
    @GetMapping("/")
    public List<EncadrementEtudiantVo> findAll(){
        return encadrementEtudiantConverter.toVo(encadrementEtudiantService.findAll());
    }

    @ApiOperation("Finds a encadrementEtudiant with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EncadrementEtudiantVo findByIdWithAssociatedList(@PathVariable Long id){
    return encadrementEtudiantConverter.toVo(encadrementEtudiantService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search encadrementEtudiant by a specific criteria")
    @PostMapping("/search")
    public List<EncadrementEtudiantVo> findByCriteria(@RequestBody EncadrementEtudiantVo encadrementEtudiantVo){
        return encadrementEtudiantConverter.toVo(encadrementEtudiantService.findByCriteria(encadrementEtudiantVo));
        }

            @ApiOperation("Finds a encadrementEtudiant by id")
            @GetMapping("/id/{id}")
            public EncadrementEtudiantVo findById(@PathVariable Long id){
            return encadrementEtudiantConverter.toVo(encadrementEtudiantService.findById(id));
            }

            @ApiOperation("Saves the specified  encadrementEtudiant")
            @PostMapping("/")
            public EncadrementEtudiantVo save(@RequestBody EncadrementEtudiantVo encadrementEtudiantVo){
            EncadrementEtudiant encadrementEtudiant = encadrementEtudiantConverter.toItem(encadrementEtudiantVo);
            encadrementEtudiant = encadrementEtudiantService.save(encadrementEtudiant);
            return encadrementEtudiantConverter.toVo(encadrementEtudiant);
            }

            @ApiOperation("Delete the specified encadrementEtudiant")
            @DeleteMapping("/")
            public int delete(@RequestBody EncadrementEtudiantVo encadrementEtudiantVo){
            EncadrementEtudiant encadrementEtudiant = encadrementEtudiantConverter.toItem(encadrementEtudiantVo);
            return encadrementEtudiantService.delete(encadrementEtudiant);
            }

            @ApiOperation("Deletes a encadrementEtudiant by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return encadrementEtudiantService.deleteById(id);
            }


        }
