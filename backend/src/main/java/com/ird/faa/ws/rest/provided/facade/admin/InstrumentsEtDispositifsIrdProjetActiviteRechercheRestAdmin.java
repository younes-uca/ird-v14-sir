//package  com.ird.faa.ws.rest.provided.facade.admin;
//
//import com.ird.faa.service.admin.facade.formulaire.InstrumentsEtDispositifsIrdProjetActiviteRechercheAdminService;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import com.ird.faa.bean.formulaire.InstrumentsEtDispositifsIrdProjetActiviteRecherche;
//import com.ird.faa.ws.rest.provided.converter.InstrumentsEtDispositifsIrdProjetActiviteRechercheConverter;
//import com.ird.faa.ws.rest.provided.vo.InstrumentsEtDispositifsIrdProjetActiviteRechercheVo;
//
//@Api("Manages instrumentsEtDispositifsIrdProjetActiviteRecherche services")
//@RestController
//@RequestMapping("api/admin/instrumentsEtDispositifsIrdProjetActiviteRecherche")
//public class InstrumentsEtDispositifsIrdProjetActiviteRechercheRestAdmin {
//
//@Autowired
//private InstrumentsEtDispositifsIrdProjetActiviteRechercheAdminService instrumentsEtDispositifsIrdProjetActiviteRechercheService;
//
//@Autowired
//private InstrumentsEtDispositifsIrdProjetActiviteRechercheConverter instrumentsEtDispositifsIrdProjetActiviteRechercheConverter;
//
//
//            @ApiOperation("Updates the specified  instrumentsEtDispositifsIrdProjetActiviteRecherche")
//            @PutMapping("/")
//            public  InstrumentsEtDispositifsIrdProjetActiviteRechercheVo update(@RequestBody  InstrumentsEtDispositifsIrdProjetActiviteRechercheVo  instrumentsEtDispositifsIrdProjetActiviteRechercheVo){
//            InstrumentsEtDispositifsIrdProjetActiviteRecherche instrumentsEtDispositifsIrdProjetActiviteRecherche = instrumentsEtDispositifsIrdProjetActiviteRechercheConverter.toItem(instrumentsEtDispositifsIrdProjetActiviteRechercheVo);
//            instrumentsEtDispositifsIrdProjetActiviteRecherche = instrumentsEtDispositifsIrdProjetActiviteRechercheService.update(instrumentsEtDispositifsIrdProjetActiviteRecherche);
//            return instrumentsEtDispositifsIrdProjetActiviteRechercheConverter.toVo(instrumentsEtDispositifsIrdProjetActiviteRecherche);
//            }
//
//    @ApiOperation("Finds a list of all instrumentsEtDispositifsIrdProjetActiviteRecherches")
//    @GetMapping("/")
//    public List<InstrumentsEtDispositifsIrdProjetActiviteRechercheVo> findAll(){
//        return instrumentsEtDispositifsIrdProjetActiviteRechercheConverter.toVo(instrumentsEtDispositifsIrdProjetActiviteRechercheService.findAll());
//    }
//
//    @ApiOperation("Finds a instrumentsEtDispositifsIrdProjetActiviteRecherche with associated lists by id")
//    @GetMapping("/detail/id/{id}")
//    public InstrumentsEtDispositifsIrdProjetActiviteRechercheVo findByIdWithAssociatedList(@PathVariable Long id){
//    return instrumentsEtDispositifsIrdProjetActiviteRechercheConverter.toVo(instrumentsEtDispositifsIrdProjetActiviteRechercheService.findByIdWithAssociatedList(id));
//    }
//
//    @ApiOperation("Search instrumentsEtDispositifsIrdProjetActiviteRecherche by a specific criteria")
//    @PostMapping("/search")
//    public List<InstrumentsEtDispositifsIrdProjetActiviteRechercheVo> findByCriteria(@RequestBody InstrumentsEtDispositifsIrdProjetActiviteRechercheVo instrumentsEtDispositifsIrdProjetActiviteRechercheVo){
//        return instrumentsEtDispositifsIrdProjetActiviteRechercheConverter.toVo(instrumentsEtDispositifsIrdProjetActiviteRechercheService.findByCriteria(instrumentsEtDispositifsIrdProjetActiviteRechercheVo));
//        }
//
//            @ApiOperation("Finds a instrumentsEtDispositifsIrdProjetActiviteRecherche by id")
//            @GetMapping("/id/{id}")
//            public InstrumentsEtDispositifsIrdProjetActiviteRechercheVo findById(@PathVariable Long id){
//            return instrumentsEtDispositifsIrdProjetActiviteRechercheConverter.toVo(instrumentsEtDispositifsIrdProjetActiviteRechercheService.findById(id));
//            }
//
//            @ApiOperation("Saves the specified  instrumentsEtDispositifsIrdProjetActiviteRecherche")
//            @PostMapping("/")
//            public InstrumentsEtDispositifsIrdProjetActiviteRechercheVo save(@RequestBody InstrumentsEtDispositifsIrdProjetActiviteRechercheVo instrumentsEtDispositifsIrdProjetActiviteRechercheVo){
//            InstrumentsEtDispositifsIrdProjetActiviteRecherche instrumentsEtDispositifsIrdProjetActiviteRecherche = instrumentsEtDispositifsIrdProjetActiviteRechercheConverter.toItem(instrumentsEtDispositifsIrdProjetActiviteRechercheVo);
//            instrumentsEtDispositifsIrdProjetActiviteRecherche = instrumentsEtDispositifsIrdProjetActiviteRechercheService.save(instrumentsEtDispositifsIrdProjetActiviteRecherche);
//            return instrumentsEtDispositifsIrdProjetActiviteRechercheConverter.toVo(instrumentsEtDispositifsIrdProjetActiviteRecherche);
//            }
//
//            @ApiOperation("Delete the specified instrumentsEtDispositifsIrdProjetActiviteRecherche")
//            @DeleteMapping("/")
//            public int delete(@RequestBody InstrumentsEtDispositifsIrdProjetActiviteRechercheVo instrumentsEtDispositifsIrdProjetActiviteRechercheVo){
//            InstrumentsEtDispositifsIrdProjetActiviteRecherche instrumentsEtDispositifsIrdProjetActiviteRecherche = instrumentsEtDispositifsIrdProjetActiviteRechercheConverter.toItem(instrumentsEtDispositifsIrdProjetActiviteRechercheVo);
//            return instrumentsEtDispositifsIrdProjetActiviteRechercheService.delete(instrumentsEtDispositifsIrdProjetActiviteRecherche);
//            }
//
//            @ApiOperation("Deletes a instrumentsEtDispositifsIrdProjetActiviteRecherche by id")
//            @DeleteMapping("/id/{id}")
//            public int deleteById(@PathVariable Long id){
//            return instrumentsEtDispositifsIrdProjetActiviteRechercheService.deleteById(id);
//            }
//
//
//        }
