package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.CommunauteSavoirEncadrementEtudiantAdminService;

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
import com.ird.faa.bean.formulaire.CommunauteSavoirEncadrementEtudiant;
import com.ird.faa.ws.rest.provided.converter.CommunauteSavoirEncadrementEtudiantConverter;
import com.ird.faa.ws.rest.provided.vo.CommunauteSavoirEncadrementEtudiantVo;

@Api("Manages communauteSavoirEncadrementEtudiant services")
@RestController
@RequestMapping("api/admin/communauteSavoirEncadrementEtudiant")
public class CommunauteSavoirEncadrementEtudiantRestAdmin {

@Autowired
private CommunauteSavoirEncadrementEtudiantAdminService communauteSavoirEncadrementEtudiantService;

@Autowired
private CommunauteSavoirEncadrementEtudiantConverter communauteSavoirEncadrementEtudiantConverter;


            @ApiOperation("Updates the specified  communauteSavoirEncadrementEtudiant")
            @PutMapping("/")
            public  CommunauteSavoirEncadrementEtudiantVo update(@RequestBody  CommunauteSavoirEncadrementEtudiantVo  communauteSavoirEncadrementEtudiantVo){
            CommunauteSavoirEncadrementEtudiant communauteSavoirEncadrementEtudiant = communauteSavoirEncadrementEtudiantConverter.toItem(communauteSavoirEncadrementEtudiantVo);
            communauteSavoirEncadrementEtudiant = communauteSavoirEncadrementEtudiantService.update(communauteSavoirEncadrementEtudiant);
            return communauteSavoirEncadrementEtudiantConverter.toVo(communauteSavoirEncadrementEtudiant);
            }

    @ApiOperation("Finds a list of all communauteSavoirEncadrementEtudiants")
    @GetMapping("/")
    public List<CommunauteSavoirEncadrementEtudiantVo> findAll(){
        return communauteSavoirEncadrementEtudiantConverter.toVo(communauteSavoirEncadrementEtudiantService.findAll());
    }

    @ApiOperation("Finds a communauteSavoirEncadrementEtudiant with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CommunauteSavoirEncadrementEtudiantVo findByIdWithAssociatedList(@PathVariable Long id){
    return communauteSavoirEncadrementEtudiantConverter.toVo(communauteSavoirEncadrementEtudiantService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search communauteSavoirEncadrementEtudiant by a specific criteria")
    @PostMapping("/search")
    public List<CommunauteSavoirEncadrementEtudiantVo> findByCriteria(@RequestBody CommunauteSavoirEncadrementEtudiantVo communauteSavoirEncadrementEtudiantVo){
        return communauteSavoirEncadrementEtudiantConverter.toVo(communauteSavoirEncadrementEtudiantService.findByCriteria(communauteSavoirEncadrementEtudiantVo));
        }

            @ApiOperation("Finds a communauteSavoirEncadrementEtudiant by id")
            @GetMapping("/id/{id}")
            public CommunauteSavoirEncadrementEtudiantVo findById(@PathVariable Long id){
            return communauteSavoirEncadrementEtudiantConverter.toVo(communauteSavoirEncadrementEtudiantService.findById(id));
            }

            @ApiOperation("Saves the specified  communauteSavoirEncadrementEtudiant")
            @PostMapping("/")
            public CommunauteSavoirEncadrementEtudiantVo save(@RequestBody CommunauteSavoirEncadrementEtudiantVo communauteSavoirEncadrementEtudiantVo){
            CommunauteSavoirEncadrementEtudiant communauteSavoirEncadrementEtudiant = communauteSavoirEncadrementEtudiantConverter.toItem(communauteSavoirEncadrementEtudiantVo);
            communauteSavoirEncadrementEtudiant = communauteSavoirEncadrementEtudiantService.save(communauteSavoirEncadrementEtudiant);
            return communauteSavoirEncadrementEtudiantConverter.toVo(communauteSavoirEncadrementEtudiant);
            }

            @ApiOperation("Delete the specified communauteSavoirEncadrementEtudiant")
            @DeleteMapping("/")
            public int delete(@RequestBody CommunauteSavoirEncadrementEtudiantVo communauteSavoirEncadrementEtudiantVo){
            CommunauteSavoirEncadrementEtudiant communauteSavoirEncadrementEtudiant = communauteSavoirEncadrementEtudiantConverter.toItem(communauteSavoirEncadrementEtudiantVo);
            return communauteSavoirEncadrementEtudiantService.delete(communauteSavoirEncadrementEtudiant);
            }

            @ApiOperation("Deletes a communauteSavoirEncadrementEtudiant by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return communauteSavoirEncadrementEtudiantService.deleteById(id);
            }


        }
