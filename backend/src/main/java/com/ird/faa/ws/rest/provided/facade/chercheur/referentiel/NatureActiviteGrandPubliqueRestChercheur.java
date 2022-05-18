package main.java.com.ird.faa.ws.rest.provided.facade.chercheur.referentiel;

import com.ird.faa.service.chercheur.facade.formulaire.NatureActiviteGrandPubliqueChercheurService;

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
import com.ird.faa.bean.referentiel.NatureActiviteGrandPublique;
import main.java.com.ird.faa.ws.rest.provided.converter.referentiel.NatureActiviteGrandPubliqueConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.NatureActiviteGrandPubliqueVo;

@Api("Manages natureActiviteGrandPublique services")
@RestController
@RequestMapping("api/chercheur/natureActiviteGrandPublique")
public class NatureActiviteGrandPubliqueRestChercheur {

@Autowired
private NatureActiviteGrandPubliqueChercheurService natureActiviteGrandPubliqueService;

@Autowired
private NatureActiviteGrandPubliqueConverter natureActiviteGrandPubliqueConverter;


            @ApiOperation("Updates the specified  natureActiviteGrandPublique")
            @PutMapping("/")
            public  NatureActiviteGrandPubliqueVo update(@RequestBody  NatureActiviteGrandPubliqueVo  natureActiviteGrandPubliqueVo){
            NatureActiviteGrandPublique natureActiviteGrandPublique = natureActiviteGrandPubliqueConverter.toItem(natureActiviteGrandPubliqueVo);
            natureActiviteGrandPublique = natureActiviteGrandPubliqueService.update(natureActiviteGrandPublique);
            return natureActiviteGrandPubliqueConverter.toVo(natureActiviteGrandPublique);
            }

    @ApiOperation("Finds a list of all natureActiviteGrandPubliques")
    @GetMapping("/")
    public List<NatureActiviteGrandPubliqueVo> findAll(){
        return natureActiviteGrandPubliqueConverter.toVo(natureActiviteGrandPubliqueService.findAll());
    }

    @ApiOperation("Finds a natureActiviteGrandPublique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public NatureActiviteGrandPubliqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return natureActiviteGrandPubliqueConverter.toVo(natureActiviteGrandPubliqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search natureActiviteGrandPublique by a specific criteria")
    @PostMapping("/search")
    public List<NatureActiviteGrandPubliqueVo> findByCriteria(@RequestBody NatureActiviteGrandPubliqueVo natureActiviteGrandPubliqueVo){
        return natureActiviteGrandPubliqueConverter.toVo(natureActiviteGrandPubliqueService.findByCriteria(natureActiviteGrandPubliqueVo));
        }

            @ApiOperation("Finds a natureActiviteGrandPublique by id")
            @GetMapping("/id/{id}")
            public NatureActiviteGrandPubliqueVo findById(@PathVariable Long id){
            return natureActiviteGrandPubliqueConverter.toVo(natureActiviteGrandPubliqueService.findById(id));
            }

            @ApiOperation("Saves the specified  natureActiviteGrandPublique")
            @PostMapping("/")
            public NatureActiviteGrandPubliqueVo save(@RequestBody NatureActiviteGrandPubliqueVo natureActiviteGrandPubliqueVo){
            NatureActiviteGrandPublique natureActiviteGrandPublique = natureActiviteGrandPubliqueConverter.toItem(natureActiviteGrandPubliqueVo);
            natureActiviteGrandPublique = natureActiviteGrandPubliqueService.save(natureActiviteGrandPublique);
            return natureActiviteGrandPubliqueConverter.toVo(natureActiviteGrandPublique);
            }

            @ApiOperation("Delete the specified natureActiviteGrandPublique")
            @DeleteMapping("/")
            public int delete(@RequestBody NatureActiviteGrandPubliqueVo natureActiviteGrandPubliqueVo){
            NatureActiviteGrandPublique natureActiviteGrandPublique = natureActiviteGrandPubliqueConverter.toItem(natureActiviteGrandPubliqueVo);
            return natureActiviteGrandPubliqueService.delete(natureActiviteGrandPublique);
            }

            @ApiOperation("Deletes a natureActiviteGrandPublique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return natureActiviteGrandPubliqueService.deleteById(id);
            }


            }
