//package  com.ird.faa.ws.rest.provided.facade.admin;
//
//import com.ird.faa.service.admin.facade.formulaire.InstitutionCoContractantProjetActiviteRechercheAdminService;
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
//import com.ird.faa.bean.formulaire.InstitutionCoContractantProjetActiviteRecherche;
//import com.ird.faa.ws.rest.provided.converter.InstitutionCoContractantProjetActiviteRechercheConverter;
//import com.ird.faa.ws.rest.provided.vo.InstitutionCoContractantProjetActiviteRechercheVo;
//
//@Api("Manages institutionCoContractantProjetActiviteRecherche services")
//@RestController
//@RequestMapping("api/admin/institutionCoContractantProjetActiviteRecherche")
//public class InstitutionCoContractantProjetActiviteRechercheRestAdmin {
//
//@Autowired
//private InstitutionCoContractantProjetActiviteRechercheAdminService institutionCoContractantProjetActiviteRechercheService;
//
//@Autowired
//private InstitutionCoContractantProjetActiviteRechercheConverter institutionCoContractantProjetActiviteRechercheConverter;
//
//
//            @ApiOperation("Updates the specified  institutionCoContractantProjetActiviteRecherche")
//            @PutMapping("/")
//            public  InstitutionCoContractantProjetActiviteRechercheVo update(@RequestBody  InstitutionCoContractantProjetActiviteRechercheVo  institutionCoContractantProjetActiviteRechercheVo){
//            InstitutionCoContractantProjetActiviteRecherche institutionCoContractantProjetActiviteRecherche = institutionCoContractantProjetActiviteRechercheConverter.toItem(institutionCoContractantProjetActiviteRechercheVo);
//            institutionCoContractantProjetActiviteRecherche = institutionCoContractantProjetActiviteRechercheService.update(institutionCoContractantProjetActiviteRecherche);
//            return institutionCoContractantProjetActiviteRechercheConverter.toVo(institutionCoContractantProjetActiviteRecherche);
//            }
//
//    @ApiOperation("Finds a list of all institutionCoContractantProjetActiviteRecherches")
//    @GetMapping("/")
//    public List<InstitutionCoContractantProjetActiviteRechercheVo> findAll(){
//        return institutionCoContractantProjetActiviteRechercheConverter.toVo(institutionCoContractantProjetActiviteRechercheService.findAll());
//    }
//
//    @ApiOperation("Finds a institutionCoContractantProjetActiviteRecherche with associated lists by id")
//    @GetMapping("/detail/id/{id}")
//    public InstitutionCoContractantProjetActiviteRechercheVo findByIdWithAssociatedList(@PathVariable Long id){
//    return institutionCoContractantProjetActiviteRechercheConverter.toVo(institutionCoContractantProjetActiviteRechercheService.findByIdWithAssociatedList(id));
//    }
//
//    @ApiOperation("Search institutionCoContractantProjetActiviteRecherche by a specific criteria")
//    @PostMapping("/search")
//    public List<InstitutionCoContractantProjetActiviteRechercheVo> findByCriteria(@RequestBody InstitutionCoContractantProjetActiviteRechercheVo institutionCoContractantProjetActiviteRechercheVo){
//        return institutionCoContractantProjetActiviteRechercheConverter.toVo(institutionCoContractantProjetActiviteRechercheService.findByCriteria(institutionCoContractantProjetActiviteRechercheVo));
//        }
//
//            @ApiOperation("Finds a institutionCoContractantProjetActiviteRecherche by id")
//            @GetMapping("/id/{id}")
//            public InstitutionCoContractantProjetActiviteRechercheVo findById(@PathVariable Long id){
//            return institutionCoContractantProjetActiviteRechercheConverter.toVo(institutionCoContractantProjetActiviteRechercheService.findById(id));
//            }
//
//            @ApiOperation("Saves the specified  institutionCoContractantProjetActiviteRecherche")
//            @PostMapping("/")
//            public InstitutionCoContractantProjetActiviteRechercheVo save(@RequestBody InstitutionCoContractantProjetActiviteRechercheVo institutionCoContractantProjetActiviteRechercheVo){
//            InstitutionCoContractantProjetActiviteRecherche institutionCoContractantProjetActiviteRecherche = institutionCoContractantProjetActiviteRechercheConverter.toItem(institutionCoContractantProjetActiviteRechercheVo);
//            institutionCoContractantProjetActiviteRecherche = institutionCoContractantProjetActiviteRechercheService.save(institutionCoContractantProjetActiviteRecherche);
//            return institutionCoContractantProjetActiviteRechercheConverter.toVo(institutionCoContractantProjetActiviteRecherche);
//            }
//
//            @ApiOperation("Delete the specified institutionCoContractantProjetActiviteRecherche")
//            @DeleteMapping("/")
//            public int delete(@RequestBody InstitutionCoContractantProjetActiviteRechercheVo institutionCoContractantProjetActiviteRechercheVo){
//            InstitutionCoContractantProjetActiviteRecherche institutionCoContractantProjetActiviteRecherche = institutionCoContractantProjetActiviteRechercheConverter.toItem(institutionCoContractantProjetActiviteRechercheVo);
//            return institutionCoContractantProjetActiviteRechercheService.delete(institutionCoContractantProjetActiviteRecherche);
//            }
//
//            @ApiOperation("Deletes a institutionCoContractantProjetActiviteRecherche by id")
//            @DeleteMapping("/id/{id}")
//            public int deleteById(@PathVariable Long id){
//            return institutionCoContractantProjetActiviteRechercheService.deleteById(id);
//            }
//
//
//        }
