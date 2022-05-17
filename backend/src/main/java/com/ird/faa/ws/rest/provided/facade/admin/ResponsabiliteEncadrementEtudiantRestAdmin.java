package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.ResponsabiliteEncadrementEtudiantAdminService;

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
import com.ird.faa.bean.formulaire.ResponsabiliteEncadrementEtudiant;
import com.ird.faa.ws.rest.provided.converter.ResponsabiliteEncadrementEtudiantConverter;
import com.ird.faa.ws.rest.provided.vo.ResponsabiliteEncadrementEtudiantVo;

@Api("Manages responsabiliteEncadrementEtudiant services")
@RestController
@RequestMapping("api/admin/responsabiliteEncadrementEtudiant")
public class ResponsabiliteEncadrementEtudiantRestAdmin {

@Autowired
private ResponsabiliteEncadrementEtudiantAdminService responsabiliteEncadrementEtudiantService;

@Autowired
private ResponsabiliteEncadrementEtudiantConverter responsabiliteEncadrementEtudiantConverter;


            @ApiOperation("Updates the specified  responsabiliteEncadrementEtudiant")
            @PutMapping("/")
            public  ResponsabiliteEncadrementEtudiantVo update(@RequestBody  ResponsabiliteEncadrementEtudiantVo  responsabiliteEncadrementEtudiantVo){
            ResponsabiliteEncadrementEtudiant responsabiliteEncadrementEtudiant = responsabiliteEncadrementEtudiantConverter.toItem(responsabiliteEncadrementEtudiantVo);
            responsabiliteEncadrementEtudiant = responsabiliteEncadrementEtudiantService.update(responsabiliteEncadrementEtudiant);
            return responsabiliteEncadrementEtudiantConverter.toVo(responsabiliteEncadrementEtudiant);
            }

    @ApiOperation("Finds a list of all responsabiliteEncadrementEtudiants")
    @GetMapping("/")
    public List<ResponsabiliteEncadrementEtudiantVo> findAll(){
        return responsabiliteEncadrementEtudiantConverter.toVo(responsabiliteEncadrementEtudiantService.findAll());
    }

    @ApiOperation("Finds a responsabiliteEncadrementEtudiant with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ResponsabiliteEncadrementEtudiantVo findByIdWithAssociatedList(@PathVariable Long id){
    return responsabiliteEncadrementEtudiantConverter.toVo(responsabiliteEncadrementEtudiantService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search responsabiliteEncadrementEtudiant by a specific criteria")
    @PostMapping("/search")
    public List<ResponsabiliteEncadrementEtudiantVo> findByCriteria(@RequestBody ResponsabiliteEncadrementEtudiantVo responsabiliteEncadrementEtudiantVo){
        return responsabiliteEncadrementEtudiantConverter.toVo(responsabiliteEncadrementEtudiantService.findByCriteria(responsabiliteEncadrementEtudiantVo));
        }

            @ApiOperation("Finds a responsabiliteEncadrementEtudiant by id")
            @GetMapping("/id/{id}")
            public ResponsabiliteEncadrementEtudiantVo findById(@PathVariable Long id){
            return responsabiliteEncadrementEtudiantConverter.toVo(responsabiliteEncadrementEtudiantService.findById(id));
            }

            @ApiOperation("Saves the specified  responsabiliteEncadrementEtudiant")
            @PostMapping("/")
            public ResponsabiliteEncadrementEtudiantVo save(@RequestBody ResponsabiliteEncadrementEtudiantVo responsabiliteEncadrementEtudiantVo){
            ResponsabiliteEncadrementEtudiant responsabiliteEncadrementEtudiant = responsabiliteEncadrementEtudiantConverter.toItem(responsabiliteEncadrementEtudiantVo);
            responsabiliteEncadrementEtudiant = responsabiliteEncadrementEtudiantService.save(responsabiliteEncadrementEtudiant);
            return responsabiliteEncadrementEtudiantConverter.toVo(responsabiliteEncadrementEtudiant);
            }

            @ApiOperation("Delete the specified responsabiliteEncadrementEtudiant")
            @DeleteMapping("/")
            public int delete(@RequestBody ResponsabiliteEncadrementEtudiantVo responsabiliteEncadrementEtudiantVo){
            ResponsabiliteEncadrementEtudiant responsabiliteEncadrementEtudiant = responsabiliteEncadrementEtudiantConverter.toItem(responsabiliteEncadrementEtudiantVo);
            return responsabiliteEncadrementEtudiantService.delete(responsabiliteEncadrementEtudiant);
            }

            @ApiOperation("Deletes a responsabiliteEncadrementEtudiant by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return responsabiliteEncadrementEtudiantService.deleteById(id);
            }


        }
