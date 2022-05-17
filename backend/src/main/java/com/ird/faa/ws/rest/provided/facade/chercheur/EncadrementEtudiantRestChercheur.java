package  com.ird.faa.ws.rest.provided.facade.chercheur;

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

import com.ird.faa.bean.formulaire.EncadrementEtudiant;
import com.ird.faa.service.chercheur.facade.formulaire.EncadrementEtudiantChercheurService;
import com.ird.faa.ws.rest.provided.converter.EncadrementEtudiantConverter;
import com.ird.faa.ws.rest.provided.vo.EncadrementEtudiantVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Manages encadrementEtudiant services")
@RestController
@RequestMapping("api/chercheur/encadrementEtudiant")
public class EncadrementEtudiantRestChercheur {

@Autowired
private EncadrementEtudiantChercheurService encadrementEtudiantService;

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
        @ApiOperation("find by niveauFormationPostBac code")
        @GetMapping("/niveauFormationPostBac/code/{code}")
        public List<EncadrementEtudiant> findByNiveauFormationPostBacCode(@PathVariable String code){
        return encadrementEtudiantService.findByNiveauFormationPostBacCode(code);
        }

        @ApiOperation("delete by niveauFormationPostBac code")
        @DeleteMapping("/niveauFormationPostBac/code/{code}")
        public int deleteByNiveauFormationPostBacCode(@PathVariable String code){
        return encadrementEtudiantService.deleteByNiveauFormationPostBacCode(code);
        }

        @ApiOperation("find by niveauFormationPostBac id")
        @GetMapping("/niveauFormationPostBac/id/{id}")
        public List<EncadrementEtudiant> findByNiveauFormationPostBacId(@PathVariable Long id){
        return encadrementEtudiantService.findByNiveauFormationPostBacId(id);
        }

        @ApiOperation("delete by niveauFormationPostBac id")
        @DeleteMapping("/niveauFormationPostBac/id/{id}")
        public int deleteByNiveauFormationPostBacId(@PathVariable Long id){
        return encadrementEtudiantService.deleteByNiveauFormationPostBacId(id);
        }

        @ApiOperation("find by responsabiliteEncadrementEtudiant code")
        @GetMapping("/responsabiliteEncadrementEtudiant/code/{code}")
        public List<EncadrementEtudiant> findByResponsabiliteEncadrementEtudiantCode(@PathVariable String code){
        return encadrementEtudiantService.findByResponsabiliteEncadrementEtudiantCode(code);
        }

        @ApiOperation("delete by responsabiliteEncadrementEtudiant code")
        @DeleteMapping("/responsabiliteEncadrementEtudiant/code/{code}")
        public int deleteByResponsabiliteEncadrementEtudiantCode(@PathVariable String code){
        return encadrementEtudiantService.deleteByResponsabiliteEncadrementEtudiantCode(code);
        }

        @ApiOperation("find by responsabiliteEncadrementEtudiant id")
        @GetMapping("/responsabiliteEncadrementEtudiant/id/{id}")
        public List<EncadrementEtudiant> findByResponsabiliteEncadrementEtudiantId(@PathVariable Long id){
        return encadrementEtudiantService.findByResponsabiliteEncadrementEtudiantId(id);
        }

        @ApiOperation("delete by responsabiliteEncadrementEtudiant id")
        @DeleteMapping("/responsabiliteEncadrementEtudiant/id/{id}")
        public int deleteByResponsabiliteEncadrementEtudiantId(@PathVariable Long id){
        return encadrementEtudiantService.deleteByResponsabiliteEncadrementEtudiantId(id);
        }

        @ApiOperation("find by etablissement code")
        @GetMapping("/etablissement/code/{code}")
        public List<EncadrementEtudiant> findByEtablissementCode(@PathVariable String code){
        return encadrementEtudiantService.findByEtablissementCode(code);
        }

        @ApiOperation("delete by etablissement code")
        @DeleteMapping("/etablissement/code/{code}")
        public int deleteByEtablissementCode(@PathVariable String code){
        return encadrementEtudiantService.deleteByEtablissementCode(code);
        }

        @ApiOperation("find by etablissement id")
        @GetMapping("/etablissement/id/{id}")
        public List<EncadrementEtudiant> findByEtablissementId(@PathVariable Long id){
        return encadrementEtudiantService.findByEtablissementId(id);
        }

        @ApiOperation("delete by etablissement id")
        @DeleteMapping("/etablissement/id/{id}")
        public int deleteByEtablissementId(@PathVariable Long id){
        return encadrementEtudiantService.deleteByEtablissementId(id);
        }

        @ApiOperation("find by pays code")
        @GetMapping("/pays/code/{code}")
        public List<EncadrementEtudiant> findByPaysCode(@PathVariable String code){
        return encadrementEtudiantService.findByPaysCode(code);
        }

        @ApiOperation("delete by pays code")
        @DeleteMapping("/pays/code/{code}")
        public int deleteByPaysCode(@PathVariable String code){
        return encadrementEtudiantService.deleteByPaysCode(code);
        }

        @ApiOperation("find by pays id")
        @GetMapping("/pays/id/{id}")
        public List<EncadrementEtudiant> findByPaysId(@PathVariable Long id){
        return encadrementEtudiantService.findByPaysId(id);
        }

        @ApiOperation("delete by pays id")
        @DeleteMapping("/pays/id/{id}")
        public int deleteByPaysId(@PathVariable Long id){
        return encadrementEtudiantService.deleteByPaysId(id);
        }

        @ApiOperation("find by encadrement id")
        @GetMapping("/encadrement/id/{id}")
        public List<EncadrementEtudiant> findByEncadrementId(@PathVariable Long id){
        return encadrementEtudiantService.findByEncadrementId(id);
        }

        @ApiOperation("delete by encadrement id")
        @DeleteMapping("/encadrement/id/{id}")
        public int deleteByEncadrementId(@PathVariable Long id){
        return encadrementEtudiantService.deleteByEncadrementId(id);
        }

        @ApiOperation("find by etatEtapeCampagne code")
        @GetMapping("/etatEtapeCampagne/code/{code}")
        public List<EncadrementEtudiant> findByEtatEtapeCampagneCode(@PathVariable String code){
        return encadrementEtudiantService.findByEtatEtapeCampagneCode(code);
        }

        @ApiOperation("delete by etatEtapeCampagne code")
        @DeleteMapping("/etatEtapeCampagne/code/{code}")
        public int deleteByEtatEtapeCampagneCode(@PathVariable String code){
        return encadrementEtudiantService.deleteByEtatEtapeCampagneCode(code);
        }

        @ApiOperation("find by etatEtapeCampagne id")
        @GetMapping("/etatEtapeCampagne/id/{id}")
        public List<EncadrementEtudiant> findByEtatEtapeCampagneId(@PathVariable Long id){
        return encadrementEtudiantService.findByEtatEtapeCampagneId(id);
        }

        @ApiOperation("delete by etatEtapeCampagne id")
        @DeleteMapping("/etatEtapeCampagne/id/{id}")
        public int deleteByEtatEtapeCampagneId(@PathVariable Long id){
        return encadrementEtudiantService.deleteByEtatEtapeCampagneId(id);
        }

	@GetMapping("/username/{username}/id/{compagneId}")
	public List<EncadrementEtudiantVo> findByChercheurUsernameAndCampagneId(@PathVariable String username,
			@PathVariable Long compagneId) {
		return encadrementEtudiantConverter
				.toVo(encadrementEtudiantService.findByChercheurUsernameAndCampagneId(username, compagneId));
	}


            }
