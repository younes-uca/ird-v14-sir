//package  com.ird.faa.ws.rest.provided.facade.chercheur;
//
//import com.ird.faa.service.chercheur.facade.formulaire.PaysProjetRechercheChercheurService;
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
//import com.ird.faa.bean.formulaire.PaysProjetRecherche;
//import com.ird.faa.ws.rest.provided.converter.PaysProjetRechercheConverter;
//import com.ird.faa.ws.rest.provided.vo.PaysProjetRechercheVo;
//
//@Api("Manages paysProjetRecherche services")
//@RestController
//@RequestMapping("api/chercheur/paysProjetRecherche")
//public class PaysProjetRechercheRestChercheur {
//
//@Autowired
//private PaysProjetRechercheChercheurService paysProjetRechercheService;
//
//@Autowired
//private PaysProjetRechercheConverter paysProjetRechercheConverter;
//
//
//            @ApiOperation("Updates the specified  paysProjetRecherche")
//            @PutMapping("/")
//            public  PaysProjetRechercheVo update(@RequestBody  PaysProjetRechercheVo  paysProjetRechercheVo){
//            PaysProjetRecherche paysProjetRecherche = paysProjetRechercheConverter.toItem(paysProjetRechercheVo);
//            paysProjetRecherche = paysProjetRechercheService.update(paysProjetRecherche);
//            return paysProjetRechercheConverter.toVo(paysProjetRecherche);
//            }
//
//    @ApiOperation("Finds a list of all paysProjetRecherches")
//    @GetMapping("/")
//    public List<PaysProjetRechercheVo> findAll(){
//        return paysProjetRechercheConverter.toVo(paysProjetRechercheService.findAll());
//    }
//
//    @ApiOperation("Finds a paysProjetRecherche with associated lists by id")
//    @GetMapping("/detail/id/{id}")
//    public PaysProjetRechercheVo findByIdWithAssociatedList(@PathVariable Long id){
//    return paysProjetRechercheConverter.toVo(paysProjetRechercheService.findByIdWithAssociatedList(id));
//    }
//
//    @ApiOperation("Search paysProjetRecherche by a specific criteria")
//    @PostMapping("/search")
//    public List<PaysProjetRechercheVo> findByCriteria(@RequestBody PaysProjetRechercheVo paysProjetRechercheVo){
//        return paysProjetRechercheConverter.toVo(paysProjetRechercheService.findByCriteria(paysProjetRechercheVo));
//        }
//
//            @ApiOperation("Finds a paysProjetRecherche by id")
//            @GetMapping("/id/{id}")
//            public PaysProjetRechercheVo findById(@PathVariable Long id){
//            return paysProjetRechercheConverter.toVo(paysProjetRechercheService.findById(id));
//            }
//
//            @ApiOperation("Saves the specified  paysProjetRecherche")
//            @PostMapping("/")
//            public PaysProjetRechercheVo save(@RequestBody PaysProjetRechercheVo paysProjetRechercheVo){
//            PaysProjetRecherche paysProjetRecherche = paysProjetRechercheConverter.toItem(paysProjetRechercheVo);
//            paysProjetRecherche = paysProjetRechercheService.save(paysProjetRecherche);
//            return paysProjetRechercheConverter.toVo(paysProjetRecherche);
//            }
//
//            @ApiOperation("Delete the specified paysProjetRecherche")
//            @DeleteMapping("/")
//            public int delete(@RequestBody PaysProjetRechercheVo paysProjetRechercheVo){
//            PaysProjetRecherche paysProjetRecherche = paysProjetRechercheConverter.toItem(paysProjetRechercheVo);
//            return paysProjetRechercheService.delete(paysProjetRecherche);
//            }
//
//            @ApiOperation("Deletes a paysProjetRecherche by id")
//            @DeleteMapping("/id/{id}")
//            public int deleteById(@PathVariable Long id){
//            return paysProjetRechercheService.deleteById(id);
//            }
//
//
//        }
