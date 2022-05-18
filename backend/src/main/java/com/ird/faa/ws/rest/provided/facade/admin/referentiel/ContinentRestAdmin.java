package main.java.com.ird.faa.ws.rest.provided.facade.admin.referentiel;

import com.ird.faa.service.admin.facade.formulaire.ContinentAdminService;

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
import com.ird.faa.bean.referentiel.Continent;
import main.java.com.ird.faa.ws.rest.provided.converter.referentiel.ContinentConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.ContinentVo;

@Api("Manages continent services")
@RestController
@RequestMapping("api/admin/continent")
public class ContinentRestAdmin {

@Autowired
private ContinentAdminService continentService;

@Autowired
private ContinentConverter continentConverter;


            @ApiOperation("Updates the specified  continent")
            @PutMapping("/")
            public  ContinentVo update(@RequestBody  ContinentVo  continentVo){
            Continent continent = continentConverter.toItem(continentVo);
            continent = continentService.update(continent);
            return continentConverter.toVo(continent);
            }

    @ApiOperation("Finds a list of all continents")
    @GetMapping("/")
    public List<ContinentVo> findAll(){
        return continentConverter.toVo(continentService.findAll());
    }

    @ApiOperation("Finds a continent with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ContinentVo findByIdWithAssociatedList(@PathVariable Long id){
    return continentConverter.toVo(continentService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search continent by a specific criteria")
    @PostMapping("/search")
    public List<ContinentVo> findByCriteria(@RequestBody ContinentVo continentVo){
        return continentConverter.toVo(continentService.findByCriteria(continentVo));
        }

            @ApiOperation("Finds a continent by id")
            @GetMapping("/id/{id}")
            public ContinentVo findById(@PathVariable Long id){
            return continentConverter.toVo(continentService.findById(id));
            }

            @ApiOperation("Saves the specified  continent")
            @PostMapping("/")
            public ContinentVo save(@RequestBody ContinentVo continentVo){
            Continent continent = continentConverter.toItem(continentVo);
            continent = continentService.save(continent);
            return continentConverter.toVo(continent);
            }

            @ApiOperation("Delete the specified continent")
            @DeleteMapping("/")
            public int delete(@RequestBody ContinentVo continentVo){
            Continent continent = continentConverter.toItem(continentVo);
            return continentService.delete(continent);
            }

            @ApiOperation("Deletes a continent by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return continentService.deleteById(id);
            }


        }
