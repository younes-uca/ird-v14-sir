package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.formulaire.ProjetActiviteRechercheDetailChercheurService;

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
import com.ird.faa.bean.formulaire.ProjetActiviteRechercheDetail;
import com.ird.faa.ws.rest.provided.converter.ProjetActiviteRechercheDetailConverter;
import com.ird.faa.ws.rest.provided.vo.ProjetActiviteRechercheDetailVo;

@Api("Manages projetActiviteRechercheDetail services")
@RestController
@RequestMapping("api/chercheur/projetActiviteRechercheDetail")
public class ProjetActiviteRechercheDetailRestChercheur {

@Autowired
private ProjetActiviteRechercheDetailChercheurService projetActiviteRechercheDetailService;

@Autowired
private ProjetActiviteRechercheDetailConverter projetActiviteRechercheDetailConverter;


            @ApiOperation("Updates the specified  projetActiviteRechercheDetail")
            @PutMapping("/")
            public  ProjetActiviteRechercheDetailVo update(@RequestBody  ProjetActiviteRechercheDetailVo  projetActiviteRechercheDetailVo){
            ProjetActiviteRechercheDetail projetActiviteRechercheDetail = projetActiviteRechercheDetailConverter.toItem(projetActiviteRechercheDetailVo);
            projetActiviteRechercheDetail = projetActiviteRechercheDetailService.update(projetActiviteRechercheDetail);
            return projetActiviteRechercheDetailConverter.toVo(projetActiviteRechercheDetail);
            }

    @ApiOperation("Finds a list of all projetActiviteRechercheDetails")
    @GetMapping("/")
    public List<ProjetActiviteRechercheDetailVo> findAll(){
        return projetActiviteRechercheDetailConverter.toVo(projetActiviteRechercheDetailService.findAll());
    }

    @ApiOperation("Finds a projetActiviteRechercheDetail with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ProjetActiviteRechercheDetailVo findByIdWithAssociatedList(@PathVariable Long id){
    return projetActiviteRechercheDetailConverter.toVo(projetActiviteRechercheDetailService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search projetActiviteRechercheDetail by a specific criteria")
    @PostMapping("/search")
    public List<ProjetActiviteRechercheDetailVo> findByCriteria(@RequestBody ProjetActiviteRechercheDetailVo projetActiviteRechercheDetailVo){
        return projetActiviteRechercheDetailConverter.toVo(projetActiviteRechercheDetailService.findByCriteria(projetActiviteRechercheDetailVo));
        }

            @ApiOperation("Finds a projetActiviteRechercheDetail by id")
            @GetMapping("/id/{id}")
            public ProjetActiviteRechercheDetailVo findById(@PathVariable Long id){
            return projetActiviteRechercheDetailConverter.toVo(projetActiviteRechercheDetailService.findById(id));
            }

            @ApiOperation("Saves the specified  projetActiviteRechercheDetail")
            @PostMapping("/")
            public ProjetActiviteRechercheDetailVo save(@RequestBody ProjetActiviteRechercheDetailVo projetActiviteRechercheDetailVo){
            ProjetActiviteRechercheDetail projetActiviteRechercheDetail = projetActiviteRechercheDetailConverter.toItem(projetActiviteRechercheDetailVo);
            projetActiviteRechercheDetail = projetActiviteRechercheDetailService.save(projetActiviteRechercheDetail);
            return projetActiviteRechercheDetailConverter.toVo(projetActiviteRechercheDetail);
            }

            @ApiOperation("Delete the specified projetActiviteRechercheDetail")
            @DeleteMapping("/")
            public int delete(@RequestBody ProjetActiviteRechercheDetailVo projetActiviteRechercheDetailVo){
            ProjetActiviteRechercheDetail projetActiviteRechercheDetail = projetActiviteRechercheDetailConverter.toItem(projetActiviteRechercheDetailVo);
            return projetActiviteRechercheDetailService.delete(projetActiviteRechercheDetail);
            }

            @ApiOperation("Deletes a projetActiviteRechercheDetail by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return projetActiviteRechercheDetailService.deleteById(id);
            }


        }
