package main.java.com.ird.faa.ws.rest.provided.facade.chercheur.formulaire;

import com.ird.faa.service.chercheur.facade.formulaire.NiveauEtudeEnseignementChercheurService;

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
import com.ird.faa.bean.formulaire.NiveauEtudeEnseignement;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.NiveauEtudeEnseignementConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.NiveauEtudeEnseignementVo;

@Api("Manages niveauEtudeEnseignement services")
@RestController
@RequestMapping("api/chercheur/niveauEtudeEnseignement")
public class NiveauEtudeEnseignementRestChercheur {

@Autowired
private NiveauEtudeEnseignementChercheurService niveauEtudeEnseignementService;

@Autowired
private NiveauEtudeEnseignementConverter niveauEtudeEnseignementConverter;


            @ApiOperation("Updates the specified  niveauEtudeEnseignement")
            @PutMapping("/")
            public  NiveauEtudeEnseignementVo update(@RequestBody  NiveauEtudeEnseignementVo  niveauEtudeEnseignementVo){
            NiveauEtudeEnseignement niveauEtudeEnseignement = niveauEtudeEnseignementConverter.toItem(niveauEtudeEnseignementVo);
            niveauEtudeEnseignement = niveauEtudeEnseignementService.update(niveauEtudeEnseignement);
            return niveauEtudeEnseignementConverter.toVo(niveauEtudeEnseignement);
            }

    @ApiOperation("Finds a list of all niveauEtudeEnseignements")
    @GetMapping("/")
    public List<NiveauEtudeEnseignementVo> findAll(){
        return niveauEtudeEnseignementConverter.toVo(niveauEtudeEnseignementService.findAll());
    }

    @ApiOperation("Finds a niveauEtudeEnseignement with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public NiveauEtudeEnseignementVo findByIdWithAssociatedList(@PathVariable Long id){
    return niveauEtudeEnseignementConverter.toVo(niveauEtudeEnseignementService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search niveauEtudeEnseignement by a specific criteria")
    @PostMapping("/search")
    public List<NiveauEtudeEnseignementVo> findByCriteria(@RequestBody NiveauEtudeEnseignementVo niveauEtudeEnseignementVo){
        return niveauEtudeEnseignementConverter.toVo(niveauEtudeEnseignementService.findByCriteria(niveauEtudeEnseignementVo));
        }

            @ApiOperation("Finds a niveauEtudeEnseignement by id")
            @GetMapping("/id/{id}")
            public NiveauEtudeEnseignementVo findById(@PathVariable Long id){
            return niveauEtudeEnseignementConverter.toVo(niveauEtudeEnseignementService.findById(id));
            }

            @ApiOperation("Saves the specified  niveauEtudeEnseignement")
            @PostMapping("/")
            public NiveauEtudeEnseignementVo save(@RequestBody NiveauEtudeEnseignementVo niveauEtudeEnseignementVo){
            NiveauEtudeEnseignement niveauEtudeEnseignement = niveauEtudeEnseignementConverter.toItem(niveauEtudeEnseignementVo);
            niveauEtudeEnseignement = niveauEtudeEnseignementService.save(niveauEtudeEnseignement);
            return niveauEtudeEnseignementConverter.toVo(niveauEtudeEnseignement);
            }

            @ApiOperation("Delete the specified niveauEtudeEnseignement")
            @DeleteMapping("/")
            public int delete(@RequestBody NiveauEtudeEnseignementVo niveauEtudeEnseignementVo){
            NiveauEtudeEnseignement niveauEtudeEnseignement = niveauEtudeEnseignementConverter.toItem(niveauEtudeEnseignementVo);
            return niveauEtudeEnseignementService.delete(niveauEtudeEnseignement);
            }

            @ApiOperation("Deletes a niveauEtudeEnseignement by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return niveauEtudeEnseignementService.deleteById(id);
            }


        }
