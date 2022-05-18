package main.java.com.ird.faa.ws.rest.provided.facade.chercheur.referentiel;

import com.ird.faa.service.chercheur.facade.formulaire.NiveauEtudeChercheurService;

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
import com.ird.faa.bean.referentiel.NiveauEtude;
import main.java.com.ird.faa.ws.rest.provided.converter.referentiel.NiveauEtudeConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.NiveauEtudeVo;

@Api("Manages niveauEtude services")
@RestController
@RequestMapping("api/chercheur/niveauEtude")
public class NiveauEtudeRestChercheur {

@Autowired
private NiveauEtudeChercheurService niveauEtudeService;

@Autowired
private NiveauEtudeConverter niveauEtudeConverter;


            @ApiOperation("Updates the specified  niveauEtude")
            @PutMapping("/")
            public  NiveauEtudeVo update(@RequestBody  NiveauEtudeVo  niveauEtudeVo){
            NiveauEtude niveauEtude = niveauEtudeConverter.toItem(niveauEtudeVo);
            niveauEtude = niveauEtudeService.update(niveauEtude);
            return niveauEtudeConverter.toVo(niveauEtude);
            }

    @ApiOperation("Finds a list of all niveauEtudes")
    @GetMapping("/")
    public List<NiveauEtudeVo> findAll(){
        return niveauEtudeConverter.toVo(niveauEtudeService.findAll());
    }

    @ApiOperation("Finds a niveauEtude with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public NiveauEtudeVo findByIdWithAssociatedList(@PathVariable Long id){
    return niveauEtudeConverter.toVo(niveauEtudeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search niveauEtude by a specific criteria")
    @PostMapping("/search")
    public List<NiveauEtudeVo> findByCriteria(@RequestBody NiveauEtudeVo niveauEtudeVo){
        return niveauEtudeConverter.toVo(niveauEtudeService.findByCriteria(niveauEtudeVo));
        }

            @ApiOperation("Finds a niveauEtude by id")
            @GetMapping("/id/{id}")
            public NiveauEtudeVo findById(@PathVariable Long id){
            return niveauEtudeConverter.toVo(niveauEtudeService.findById(id));
            }

            @ApiOperation("Saves the specified  niveauEtude")
            @PostMapping("/")
            public NiveauEtudeVo save(@RequestBody NiveauEtudeVo niveauEtudeVo){
            NiveauEtude niveauEtude = niveauEtudeConverter.toItem(niveauEtudeVo);
            niveauEtude = niveauEtudeService.save(niveauEtude);
            return niveauEtudeConverter.toVo(niveauEtude);
            }

            @ApiOperation("Delete the specified niveauEtude")
            @DeleteMapping("/")
            public int delete(@RequestBody NiveauEtudeVo niveauEtudeVo){
            NiveauEtude niveauEtude = niveauEtudeConverter.toItem(niveauEtudeVo);
            return niveauEtudeService.delete(niveauEtude);
            }

            @ApiOperation("Deletes a niveauEtude by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return niveauEtudeService.deleteById(id);
            }


        }
