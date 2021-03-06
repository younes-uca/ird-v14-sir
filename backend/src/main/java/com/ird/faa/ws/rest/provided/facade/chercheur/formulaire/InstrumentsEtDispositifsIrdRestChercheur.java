package main.java.com.ird.faa.ws.rest.provided.facade.chercheur.formulaire;

import com.ird.faa.service.chercheur.facade.formulaire.InstrumentsEtDispositifsIrdChercheurService;

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
import com.ird.faa.bean.formulaire.InstrumentsEtDispositifsIrd;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.InstrumentsEtDispositifsIrdConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.InstrumentsEtDispositifsIrdVo;

@Api("Manages instrumentsEtDispositifsIrd services")
@RestController
@RequestMapping("api/chercheur/instrumentsEtDispositifsIrd")
public class InstrumentsEtDispositifsIrdRestChercheur {

@Autowired
private InstrumentsEtDispositifsIrdChercheurService instrumentsEtDispositifsIrdService;

@Autowired
private InstrumentsEtDispositifsIrdConverter instrumentsEtDispositifsIrdConverter;


            @ApiOperation("Updates the specified  instrumentsEtDispositifsIrd")
            @PutMapping("/")
            public  InstrumentsEtDispositifsIrdVo update(@RequestBody  InstrumentsEtDispositifsIrdVo  instrumentsEtDispositifsIrdVo){
            InstrumentsEtDispositifsIrd instrumentsEtDispositifsIrd = instrumentsEtDispositifsIrdConverter.toItem(instrumentsEtDispositifsIrdVo);
            instrumentsEtDispositifsIrd = instrumentsEtDispositifsIrdService.update(instrumentsEtDispositifsIrd);
            return instrumentsEtDispositifsIrdConverter.toVo(instrumentsEtDispositifsIrd);
            }

    @ApiOperation("Finds a list of all instrumentsEtDispositifsIrds")
    @GetMapping("/")
    public List<InstrumentsEtDispositifsIrdVo> findAll(){
        return instrumentsEtDispositifsIrdConverter.toVo(instrumentsEtDispositifsIrdService.findAll());
    }

    @ApiOperation("Finds a instrumentsEtDispositifsIrd with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public InstrumentsEtDispositifsIrdVo findByIdWithAssociatedList(@PathVariable Long id){
    return instrumentsEtDispositifsIrdConverter.toVo(instrumentsEtDispositifsIrdService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search instrumentsEtDispositifsIrd by a specific criteria")
    @PostMapping("/search")
    public List<InstrumentsEtDispositifsIrdVo> findByCriteria(@RequestBody InstrumentsEtDispositifsIrdVo instrumentsEtDispositifsIrdVo){
        return instrumentsEtDispositifsIrdConverter.toVo(instrumentsEtDispositifsIrdService.findByCriteria(instrumentsEtDispositifsIrdVo));
        }

            @ApiOperation("Finds a instrumentsEtDispositifsIrd by id")
            @GetMapping("/id/{id}")
            public InstrumentsEtDispositifsIrdVo findById(@PathVariable Long id){
            return instrumentsEtDispositifsIrdConverter.toVo(instrumentsEtDispositifsIrdService.findById(id));
            }

            @ApiOperation("Saves the specified  instrumentsEtDispositifsIrd")
            @PostMapping("/")
            public InstrumentsEtDispositifsIrdVo save(@RequestBody InstrumentsEtDispositifsIrdVo instrumentsEtDispositifsIrdVo){
            InstrumentsEtDispositifsIrd instrumentsEtDispositifsIrd = instrumentsEtDispositifsIrdConverter.toItem(instrumentsEtDispositifsIrdVo);
            instrumentsEtDispositifsIrd = instrumentsEtDispositifsIrdService.save(instrumentsEtDispositifsIrd);
            return instrumentsEtDispositifsIrdConverter.toVo(instrumentsEtDispositifsIrd);
            }

            @ApiOperation("Delete the specified instrumentsEtDispositifsIrd")
            @DeleteMapping("/")
            public int delete(@RequestBody InstrumentsEtDispositifsIrdVo instrumentsEtDispositifsIrdVo){
            InstrumentsEtDispositifsIrd instrumentsEtDispositifsIrd = instrumentsEtDispositifsIrdConverter.toItem(instrumentsEtDispositifsIrdVo);
            return instrumentsEtDispositifsIrdService.delete(instrumentsEtDispositifsIrd);
            }

            @ApiOperation("Deletes a instrumentsEtDispositifsIrd by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return instrumentsEtDispositifsIrdService.deleteById(id);
            }


            @GetMapping("/username/{username}/id/{compagneId}")
            public List<InstrumentsEtDispositifsIrdVo> findByChercheurUsernameAndCampagneId(@PathVariable String username,@PathVariable Long compagneId){
            return instrumentsEtDispositifsIrdConverter.toVo(instrumentsEtDispositifsIrdService.findByChercheurUsernameAndCampagneId(username,compagneId));
            }
        }
