package main.java.com.ird.faa.ws.rest.provided.facade.admin.formulaire;

import com.ird.faa.bean.formulaire.ResponsabiliteDirectionEncadrementEtudiant;
import com.ird.faa.service.admin.facade.formulaire.ResponsabiliteDirectionEncadrementEtudiantAdminService;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.ResponsabiliteDirectionEncadrementEtudiantConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.ResponsabiliteDirectionEncadrementEtudiantVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages responsabiliteDirectionEncadrementEtudiant services")
@RestController
@RequestMapping("api/admin/responsabiliteDirectionEncadrementEtudiant")
public class ResponsabiliteDirectionEncadrementEtudiantRestAdmin {

@Autowired
private ResponsabiliteDirectionEncadrementEtudiantAdminService responsabiliteDirectionEncadrementEtudiantService;

@Autowired
private ResponsabiliteDirectionEncadrementEtudiantConverter responsabiliteDirectionEncadrementEtudiantConverter;


            @ApiOperation("Updates the specified  responsabiliteDirectionEncadrementEtudiant")
            @PutMapping("/")
            public  ResponsabiliteDirectionEncadrementEtudiantVo update(@RequestBody  ResponsabiliteDirectionEncadrementEtudiantVo  responsabiliteDirectionEncadrementEtudiantVo){
            ResponsabiliteDirectionEncadrementEtudiant responsabiliteDirectionEncadrementEtudiant = responsabiliteDirectionEncadrementEtudiantConverter.toItem(responsabiliteDirectionEncadrementEtudiantVo);
            responsabiliteDirectionEncadrementEtudiant = responsabiliteDirectionEncadrementEtudiantService.update(responsabiliteDirectionEncadrementEtudiant);
            return responsabiliteDirectionEncadrementEtudiantConverter.toVo(responsabiliteDirectionEncadrementEtudiant);
            }

    @ApiOperation("Finds a list of all responsabiliteDirectionEncadrementEtudiants")
    @GetMapping("/")
    public List<ResponsabiliteDirectionEncadrementEtudiantVo> findAll(){
        return responsabiliteDirectionEncadrementEtudiantConverter.toVo(responsabiliteDirectionEncadrementEtudiantService.findAll());
    }

    @ApiOperation("Finds a responsabiliteDirectionEncadrementEtudiant with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ResponsabiliteDirectionEncadrementEtudiantVo findByIdWithAssociatedList(@PathVariable Long id){
    return responsabiliteDirectionEncadrementEtudiantConverter.toVo(responsabiliteDirectionEncadrementEtudiantService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search responsabiliteDirectionEncadrementEtudiant by a specific criteria")
    @PostMapping("/search")
    public List<ResponsabiliteDirectionEncadrementEtudiantVo> findByCriteria(@RequestBody ResponsabiliteDirectionEncadrementEtudiantVo responsabiliteDirectionEncadrementEtudiantVo){
        return responsabiliteDirectionEncadrementEtudiantConverter.toVo(responsabiliteDirectionEncadrementEtudiantService.findByCriteria(responsabiliteDirectionEncadrementEtudiantVo));
        }

            @ApiOperation("Finds a responsabiliteDirectionEncadrementEtudiant by id")
            @GetMapping("/id/{id}")
            public ResponsabiliteDirectionEncadrementEtudiantVo findById(@PathVariable Long id){
            return responsabiliteDirectionEncadrementEtudiantConverter.toVo(responsabiliteDirectionEncadrementEtudiantService.findById(id));
            }

            @ApiOperation("Saves the specified  responsabiliteDirectionEncadrementEtudiant")
            @PostMapping("/")
            public ResponsabiliteDirectionEncadrementEtudiantVo save(@RequestBody ResponsabiliteDirectionEncadrementEtudiantVo responsabiliteDirectionEncadrementEtudiantVo){
            ResponsabiliteDirectionEncadrementEtudiant responsabiliteDirectionEncadrementEtudiant = responsabiliteDirectionEncadrementEtudiantConverter.toItem(responsabiliteDirectionEncadrementEtudiantVo);
            responsabiliteDirectionEncadrementEtudiant = responsabiliteDirectionEncadrementEtudiantService.save(responsabiliteDirectionEncadrementEtudiant);
            return responsabiliteDirectionEncadrementEtudiantConverter.toVo(responsabiliteDirectionEncadrementEtudiant);
            }

            @ApiOperation("Delete the specified responsabiliteDirectionEncadrementEtudiant")
            @DeleteMapping("/")
            public int delete(@RequestBody ResponsabiliteDirectionEncadrementEtudiantVo responsabiliteDirectionEncadrementEtudiantVo){
            ResponsabiliteDirectionEncadrementEtudiant responsabiliteDirectionEncadrementEtudiant = responsabiliteDirectionEncadrementEtudiantConverter.toItem(responsabiliteDirectionEncadrementEtudiantVo);
            return responsabiliteDirectionEncadrementEtudiantService.delete(responsabiliteDirectionEncadrementEtudiant);
            }

            @ApiOperation("Deletes a responsabiliteDirectionEncadrementEtudiant by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return responsabiliteDirectionEncadrementEtudiantService.deleteById(id);
            }




            @PutMapping("/archiver/")
            public ResponsabiliteDirectionEncadrementEtudiantVo archiver(@RequestBody ResponsabiliteDirectionEncadrementEtudiantVo responsabiliteDirectionEncadrementEtudiantVo){
                ResponsabiliteDirectionEncadrementEtudiant responsabiliteDirectionEncadrementEtudiant = responsabiliteDirectionEncadrementEtudiantService.archiver(responsabiliteDirectionEncadrementEtudiantConverter.toItem(responsabiliteDirectionEncadrementEtudiantVo));
                return responsabiliteDirectionEncadrementEtudiantConverter.toVo(responsabiliteDirectionEncadrementEtudiant);
                }

            @PutMapping("/desarchiver/")
            public ResponsabiliteDirectionEncadrementEtudiantVo desarchiver(@RequestBody ResponsabiliteDirectionEncadrementEtudiantVo responsabiliteDirectionEncadrementEtudiantVo){
                ResponsabiliteDirectionEncadrementEtudiant responsabiliteDirectionEncadrementEtudiant = responsabiliteDirectionEncadrementEtudiantService.desarchiver(responsabiliteDirectionEncadrementEtudiantConverter.toItem(responsabiliteDirectionEncadrementEtudiantVo));
                return responsabiliteDirectionEncadrementEtudiantConverter.toVo(responsabiliteDirectionEncadrementEtudiant);}
            }
