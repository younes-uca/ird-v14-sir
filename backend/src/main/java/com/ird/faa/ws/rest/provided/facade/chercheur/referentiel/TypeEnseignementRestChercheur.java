package main.java.com.ird.faa.ws.rest.provided.facade.chercheur.referentiel;

import com.ird.faa.bean.referentiel.TypeEnseignement;
import com.ird.faa.service.chercheur.facade.formulaire.TypeEnseignementChercheurService;
import main.java.com.ird.faa.ws.rest.provided.converter.referentiel.TypeEnseignementConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.TypeEnseignementVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages typeEnseignement services")
@RestController
@RequestMapping("api/chercheur/typeEnseignement")
public class TypeEnseignementRestChercheur {

@Autowired
private TypeEnseignementChercheurService typeEnseignementService;

@Autowired
private TypeEnseignementConverter typeEnseignementConverter;


            @ApiOperation("Updates the specified  typeEnseignement")
            @PutMapping("/")
            public  TypeEnseignementVo update(@RequestBody  TypeEnseignementVo  typeEnseignementVo){
            TypeEnseignement typeEnseignement = typeEnseignementConverter.toItem(typeEnseignementVo);
            typeEnseignement = typeEnseignementService.update(typeEnseignement);
            return typeEnseignementConverter.toVo(typeEnseignement);
            }

    @ApiOperation("Finds a list of all typeEnseignements")
    @GetMapping("/")
    public List<TypeEnseignementVo> findAll(){
        return typeEnseignementConverter.toVo(typeEnseignementService.findAll());
    }

    @ApiOperation("Finds a typeEnseignement with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeEnseignementVo findByIdWithAssociatedList(@PathVariable Long id){
    return typeEnseignementConverter.toVo(typeEnseignementService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeEnseignement by a specific criteria")
    @PostMapping("/search")
    public List<TypeEnseignementVo> findByCriteria(@RequestBody TypeEnseignementVo typeEnseignementVo){
        return typeEnseignementConverter.toVo(typeEnseignementService.findByCriteria(typeEnseignementVo));
        }

            @ApiOperation("Finds a typeEnseignement by id")
            @GetMapping("/id/{id}")
            public TypeEnseignementVo findById(@PathVariable Long id){
            return typeEnseignementConverter.toVo(typeEnseignementService.findById(id));
            }

            @ApiOperation("Saves the specified  typeEnseignement")
            @PostMapping("/")
            public TypeEnseignementVo save(@RequestBody TypeEnseignementVo typeEnseignementVo){
            TypeEnseignement typeEnseignement = typeEnseignementConverter.toItem(typeEnseignementVo);
            typeEnseignement = typeEnseignementService.save(typeEnseignement);
            return typeEnseignementConverter.toVo(typeEnseignement);
            }

            @ApiOperation("Delete the specified typeEnseignement")
            @DeleteMapping("/")
            public int delete(@RequestBody TypeEnseignementVo typeEnseignementVo){
            TypeEnseignement typeEnseignement = typeEnseignementConverter.toItem(typeEnseignementVo);
            return typeEnseignementService.delete(typeEnseignement);
            }

            @ApiOperation("Deletes a typeEnseignement by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typeEnseignementService.deleteById(id);
            }




            }
