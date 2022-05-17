package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.InstrumentsEtDispositifsIrdChercheurAdminService;

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
import com.ird.faa.bean.formulaire.InstrumentsEtDispositifsIrdChercheur;
import com.ird.faa.ws.rest.provided.converter.InstrumentsEtDispositifsIrdChercheurConverter;
import com.ird.faa.ws.rest.provided.vo.InstrumentsEtDispositifsIrdChercheurVo;

@Api("Manages instrumentsEtDispositifsIrdChercheur services")
@RestController
@RequestMapping("api/admin/instrumentsEtDispositifsIrdChercheur")
public class InstrumentsEtDispositifsIrdChercheurRestAdmin {

@Autowired
private InstrumentsEtDispositifsIrdChercheurAdminService instrumentsEtDispositifsIrdChercheurService;

@Autowired
private InstrumentsEtDispositifsIrdChercheurConverter instrumentsEtDispositifsIrdChercheurConverter;


            @ApiOperation("Updates the specified  instrumentsEtDispositifsIrdChercheur")
            @PutMapping("/")
            public  InstrumentsEtDispositifsIrdChercheurVo update(@RequestBody  InstrumentsEtDispositifsIrdChercheurVo  instrumentsEtDispositifsIrdChercheurVo){
            InstrumentsEtDispositifsIrdChercheur instrumentsEtDispositifsIrdChercheur = instrumentsEtDispositifsIrdChercheurConverter.toItem(instrumentsEtDispositifsIrdChercheurVo);
            instrumentsEtDispositifsIrdChercheur = instrumentsEtDispositifsIrdChercheurService.update(instrumentsEtDispositifsIrdChercheur);
            return instrumentsEtDispositifsIrdChercheurConverter.toVo(instrumentsEtDispositifsIrdChercheur);
            }

    @ApiOperation("Finds a list of all instrumentsEtDispositifsIrdChercheurs")
    @GetMapping("/")
    public List<InstrumentsEtDispositifsIrdChercheurVo> findAll(){
        return instrumentsEtDispositifsIrdChercheurConverter.toVo(instrumentsEtDispositifsIrdChercheurService.findAll());
    }

    @ApiOperation("Finds a instrumentsEtDispositifsIrdChercheur with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public InstrumentsEtDispositifsIrdChercheurVo findByIdWithAssociatedList(@PathVariable Long id){
    return instrumentsEtDispositifsIrdChercheurConverter.toVo(instrumentsEtDispositifsIrdChercheurService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search instrumentsEtDispositifsIrdChercheur by a specific criteria")
    @PostMapping("/search")
    public List<InstrumentsEtDispositifsIrdChercheurVo> findByCriteria(@RequestBody InstrumentsEtDispositifsIrdChercheurVo instrumentsEtDispositifsIrdChercheurVo){
        return instrumentsEtDispositifsIrdChercheurConverter.toVo(instrumentsEtDispositifsIrdChercheurService.findByCriteria(instrumentsEtDispositifsIrdChercheurVo));
        }

            @ApiOperation("Finds a instrumentsEtDispositifsIrdChercheur by id")
            @GetMapping("/id/{id}")
            public InstrumentsEtDispositifsIrdChercheurVo findById(@PathVariable Long id){
            return instrumentsEtDispositifsIrdChercheurConverter.toVo(instrumentsEtDispositifsIrdChercheurService.findById(id));
            }

            @ApiOperation("Saves the specified  instrumentsEtDispositifsIrdChercheur")
            @PostMapping("/")
            public InstrumentsEtDispositifsIrdChercheurVo save(@RequestBody InstrumentsEtDispositifsIrdChercheurVo instrumentsEtDispositifsIrdChercheurVo){
            InstrumentsEtDispositifsIrdChercheur instrumentsEtDispositifsIrdChercheur = instrumentsEtDispositifsIrdChercheurConverter.toItem(instrumentsEtDispositifsIrdChercheurVo);
            instrumentsEtDispositifsIrdChercheur = instrumentsEtDispositifsIrdChercheurService.save(instrumentsEtDispositifsIrdChercheur);
            return instrumentsEtDispositifsIrdChercheurConverter.toVo(instrumentsEtDispositifsIrdChercheur);
            }

            @ApiOperation("Delete the specified instrumentsEtDispositifsIrdChercheur")
            @DeleteMapping("/")
            public int delete(@RequestBody InstrumentsEtDispositifsIrdChercheurVo instrumentsEtDispositifsIrdChercheurVo){
            InstrumentsEtDispositifsIrdChercheur instrumentsEtDispositifsIrdChercheur = instrumentsEtDispositifsIrdChercheurConverter.toItem(instrumentsEtDispositifsIrdChercheurVo);
            return instrumentsEtDispositifsIrdChercheurService.delete(instrumentsEtDispositifsIrdChercheur);
            }

            @ApiOperation("Deletes a instrumentsEtDispositifsIrdChercheur by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return instrumentsEtDispositifsIrdChercheurService.deleteById(id);
            }


        }
