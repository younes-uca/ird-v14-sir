//package  com.ird.faa.ws.rest.provided.facade.chercheur;
//
//import com.ird.faa.service.chercheur.facade.formulaire.BourseChercheurService;
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
//import com.ird.faa.bean.formulaire.Bourse;
//import com.ird.faa.ws.rest.provided.converter.BourseConverter;
//import com.ird.faa.ws.rest.provided.vo.BourseVo;
//
//@Api("Manages bourse services")
//@RestController
//@RequestMapping("api/chercheur/bourse")
//public class BourseRestChercheur {
//
//@Autowired
//private BourseChercheurService bourseService;
//
//@Autowired
//private BourseConverter bourseConverter;
//
//
//            @ApiOperation("Updates the specified  bourse")
//            @PutMapping("/")
//            public  BourseVo update(@RequestBody  BourseVo  bourseVo){
//            Bourse bourse = bourseConverter.toItem(bourseVo);
//            bourse = bourseService.update(bourse);
//            return bourseConverter.toVo(bourse);
//            }
//
//    @ApiOperation("Finds a list of all bourses")
//    @GetMapping("/")
//    public List<BourseVo> findAll(){
//        return bourseConverter.toVo(bourseService.findAll());
//    }
//
//    @ApiOperation("Finds a bourse with associated lists by id")
//    @GetMapping("/detail/id/{id}")
//    public BourseVo findByIdWithAssociatedList(@PathVariable Long id){
//    return bourseConverter.toVo(bourseService.findByIdWithAssociatedList(id));
//    }
//
//    @ApiOperation("Search bourse by a specific criteria")
//    @PostMapping("/search")
//    public List<BourseVo> findByCriteria(@RequestBody BourseVo bourseVo){
//        return bourseConverter.toVo(bourseService.findByCriteria(bourseVo));
//        }
//
//            @ApiOperation("Finds a bourse by id")
//            @GetMapping("/id/{id}")
//            public BourseVo findById(@PathVariable Long id){
//            return bourseConverter.toVo(bourseService.findById(id));
//            }
//
//            @ApiOperation("Saves the specified  bourse")
//            @PostMapping("/")
//            public BourseVo save(@RequestBody BourseVo bourseVo){
//            Bourse bourse = bourseConverter.toItem(bourseVo);
//            bourse = bourseService.save(bourse);
//            return bourseConverter.toVo(bourse);
//            }
//
//            @ApiOperation("Delete the specified bourse")
//            @DeleteMapping("/")
//            public int delete(@RequestBody BourseVo bourseVo){
//            Bourse bourse = bourseConverter.toItem(bourseVo);
//            return bourseService.delete(bourse);
//            }
//
//            @ApiOperation("Deletes a bourse by id")
//            @DeleteMapping("/id/{id}")
//            public int deleteById(@PathVariable Long id){
//            return bourseService.deleteById(id);
//            }
//
//
//            @GetMapping("/username/{username}/id/{compagneId}")
//            public List<BourseVo> findByChercheurUsernameAndCampagneId(@PathVariable String username,@PathVariable Long compagneId){
//            return bourseConverter.toVo(bourseService.findByChercheurUsernameAndCampagneId(username,compagneId));
//            }
//        }
