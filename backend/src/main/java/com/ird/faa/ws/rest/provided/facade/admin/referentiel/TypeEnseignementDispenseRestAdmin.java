package main.java.com.ird.faa.ws.rest.provided.facade.admin.referentiel;

import com.ird.faa.service.admin.facade.formulaire.TypeEnseignementDispenseAdminService;

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
import com.ird.faa.bean.referentiel.TypeEnseignementDispense;
import main.java.com.ird.faa.ws.rest.provided.converter.referentiel.TypeEnseignementDispenseConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.TypeEnseignementDispenseVo;

@Api("Manages typeEnseignementDispense services")
@RestController
@RequestMapping("api/admin/typeEnseignementDispense")
public class TypeEnseignementDispenseRestAdmin {

@Autowired
private TypeEnseignementDispenseAdminService typeEnseignementDispenseService;

@Autowired
private TypeEnseignementDispenseConverter typeEnseignementDispenseConverter;


            @ApiOperation("Updates the specified  typeEnseignementDispense")
            @PutMapping("/")
            public  TypeEnseignementDispenseVo update(@RequestBody  TypeEnseignementDispenseVo  typeEnseignementDispenseVo){
            TypeEnseignementDispense typeEnseignementDispense = typeEnseignementDispenseConverter.toItem(typeEnseignementDispenseVo);
            typeEnseignementDispense = typeEnseignementDispenseService.update(typeEnseignementDispense);
            return typeEnseignementDispenseConverter.toVo(typeEnseignementDispense);
            }

    @ApiOperation("Finds a list of all typeEnseignementDispenses")
    @GetMapping("/")
    public List<TypeEnseignementDispenseVo> findAll(){
        return typeEnseignementDispenseConverter.toVo(typeEnseignementDispenseService.findAll());
    }

    @ApiOperation("Finds a typeEnseignementDispense with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeEnseignementDispenseVo findByIdWithAssociatedList(@PathVariable Long id){
    return typeEnseignementDispenseConverter.toVo(typeEnseignementDispenseService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeEnseignementDispense by a specific criteria")
    @PostMapping("/search")
    public List<TypeEnseignementDispenseVo> findByCriteria(@RequestBody TypeEnseignementDispenseVo typeEnseignementDispenseVo){
        return typeEnseignementDispenseConverter.toVo(typeEnseignementDispenseService.findByCriteria(typeEnseignementDispenseVo));
        }

            @ApiOperation("Finds a typeEnseignementDispense by id")
            @GetMapping("/id/{id}")
            public TypeEnseignementDispenseVo findById(@PathVariable Long id){
            return typeEnseignementDispenseConverter.toVo(typeEnseignementDispenseService.findById(id));
            }

            @ApiOperation("Saves the specified  typeEnseignementDispense")
            @PostMapping("/")
            public TypeEnseignementDispenseVo save(@RequestBody TypeEnseignementDispenseVo typeEnseignementDispenseVo){
            TypeEnseignementDispense typeEnseignementDispense = typeEnseignementDispenseConverter.toItem(typeEnseignementDispenseVo);
            typeEnseignementDispense = typeEnseignementDispenseService.save(typeEnseignementDispense);
            return typeEnseignementDispenseConverter.toVo(typeEnseignementDispense);
            }

            @ApiOperation("Delete the specified typeEnseignementDispense")
            @DeleteMapping("/")
            public int delete(@RequestBody TypeEnseignementDispenseVo typeEnseignementDispenseVo){
            TypeEnseignementDispense typeEnseignementDispense = typeEnseignementDispenseConverter.toItem(typeEnseignementDispenseVo);
            return typeEnseignementDispenseService.delete(typeEnseignementDispense);
            }

            @ApiOperation("Deletes a typeEnseignementDispense by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typeEnseignementDispenseService.deleteById(id);
            }


        }
