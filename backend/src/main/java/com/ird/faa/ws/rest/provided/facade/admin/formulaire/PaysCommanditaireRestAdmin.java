package main.java.com.ird.faa.ws.rest.provided.facade.admin.formulaire;

import com.ird.faa.bean.formulaire.PaysCommanditaire;
import com.ird.faa.service.admin.facade.formulaire.PaysCommanditaireAdminService;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.PaysCommanditaireConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.PaysCommanditaireVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages paysCommanditaire services")
@RestController
@RequestMapping("api/admin/paysCommanditaire")
public class PaysCommanditaireRestAdmin {

@Autowired
private PaysCommanditaireAdminService paysCommanditaireService;

@Autowired
private PaysCommanditaireConverter paysCommanditaireConverter;


            @ApiOperation("Updates the specified  paysCommanditaire")
            @PutMapping("/")
            public  PaysCommanditaireVo update(@RequestBody  PaysCommanditaireVo  paysCommanditaireVo){
            PaysCommanditaire paysCommanditaire = paysCommanditaireConverter.toItem(paysCommanditaireVo);
            paysCommanditaire = paysCommanditaireService.update(paysCommanditaire);
            return paysCommanditaireConverter.toVo(paysCommanditaire);
            }

    @ApiOperation("Finds a list of all paysCommanditaires")
    @GetMapping("/")
    public List<PaysCommanditaireVo> findAll(){
        return paysCommanditaireConverter.toVo(paysCommanditaireService.findAll());
    }

    @ApiOperation("Finds a paysCommanditaire with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PaysCommanditaireVo findByIdWithAssociatedList(@PathVariable Long id){
    return paysCommanditaireConverter.toVo(paysCommanditaireService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search paysCommanditaire by a specific criteria")
    @PostMapping("/search")
    public List<PaysCommanditaireVo> findByCriteria(@RequestBody PaysCommanditaireVo paysCommanditaireVo){
        return paysCommanditaireConverter.toVo(paysCommanditaireService.findByCriteria(paysCommanditaireVo));
        }

            @ApiOperation("Finds a paysCommanditaire by id")
            @GetMapping("/id/{id}")
            public PaysCommanditaireVo findById(@PathVariable Long id){
            return paysCommanditaireConverter.toVo(paysCommanditaireService.findById(id));
            }

            @ApiOperation("Saves the specified  paysCommanditaire")
            @PostMapping("/")
            public PaysCommanditaireVo save(@RequestBody PaysCommanditaireVo paysCommanditaireVo){
            PaysCommanditaire paysCommanditaire = paysCommanditaireConverter.toItem(paysCommanditaireVo);
            paysCommanditaire = paysCommanditaireService.save(paysCommanditaire);
            return paysCommanditaireConverter.toVo(paysCommanditaire);
            }

            @ApiOperation("Delete the specified paysCommanditaire")
            @DeleteMapping("/")
            public int delete(@RequestBody PaysCommanditaireVo paysCommanditaireVo){
            PaysCommanditaire paysCommanditaire = paysCommanditaireConverter.toItem(paysCommanditaireVo);
            return paysCommanditaireService.delete(paysCommanditaire);
            }

            @ApiOperation("Deletes a paysCommanditaire by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return paysCommanditaireService.deleteById(id);
            }
        @ApiOperation("find by consultanceScientifiquePonctuelle id")
        @GetMapping("/consultanceScientifiquePonctuelle/id/{id}")
        public List<PaysCommanditaire> findByConsultanceScientifiquePonctuelleId(@PathVariable Long id){
        return paysCommanditaireService.findByConsultanceScientifiquePonctuelleId(id);
        }

        @ApiOperation("delete by consultanceScientifiquePonctuelle id")
        @DeleteMapping("/consultanceScientifiquePonctuelle/id/{id}")
        public int deleteByConsultanceScientifiquePonctuelleId(@PathVariable Long id){
        return paysCommanditaireService.deleteByConsultanceScientifiquePonctuelleId(id);
        }

        @ApiOperation("find by pays code")
        @GetMapping("/pays/code/{code}")
        public List<PaysCommanditaire> findByPaysCode(@PathVariable String code){
        return paysCommanditaireService.findByPaysCode(code);
        }

        @ApiOperation("delete by pays code")
        @DeleteMapping("/pays/code/{code}")
        public int deleteByPaysCode(@PathVariable String code){
        return paysCommanditaireService.deleteByPaysCode(code);
        }

        @ApiOperation("find by pays id")
        @GetMapping("/pays/id/{id}")
        public List<PaysCommanditaire> findByPaysId(@PathVariable Long id){
        return paysCommanditaireService.findByPaysId(id);
        }

        @ApiOperation("delete by pays id")
        @DeleteMapping("/pays/id/{id}")
        public int deleteByPaysId(@PathVariable Long id){
        return paysCommanditaireService.deleteByPaysId(id);
        }





            }
