package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.PublicCibleCultureScientifiqueOutilPedagogiqueAdminService;

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
import com.ird.faa.bean.formulaire.PublicCibleCultureScientifiqueOutilPedagogique;
import com.ird.faa.ws.rest.provided.converter.PublicCibleCultureScientifiqueOutilPedagogiqueConverter;
import com.ird.faa.ws.rest.provided.vo.PublicCibleCultureScientifiqueOutilPedagogiqueVo;

@Api("Manages publicCibleCultureScientifiqueOutilPedagogique services")
@RestController
@RequestMapping("api/admin/publicCibleCultureScientifiqueOutilPedagogique")
public class PublicCibleCultureScientifiqueOutilPedagogiqueRestAdmin {

@Autowired
private PublicCibleCultureScientifiqueOutilPedagogiqueAdminService publicCibleCultureScientifiqueOutilPedagogiqueService;

@Autowired
private PublicCibleCultureScientifiqueOutilPedagogiqueConverter publicCibleCultureScientifiqueOutilPedagogiqueConverter;


            @ApiOperation("Updates the specified  publicCibleCultureScientifiqueOutilPedagogique")
            @PutMapping("/")
            public  PublicCibleCultureScientifiqueOutilPedagogiqueVo update(@RequestBody  PublicCibleCultureScientifiqueOutilPedagogiqueVo  publicCibleCultureScientifiqueOutilPedagogiqueVo){
            PublicCibleCultureScientifiqueOutilPedagogique publicCibleCultureScientifiqueOutilPedagogique = publicCibleCultureScientifiqueOutilPedagogiqueConverter.toItem(publicCibleCultureScientifiqueOutilPedagogiqueVo);
            publicCibleCultureScientifiqueOutilPedagogique = publicCibleCultureScientifiqueOutilPedagogiqueService.update(publicCibleCultureScientifiqueOutilPedagogique);
            return publicCibleCultureScientifiqueOutilPedagogiqueConverter.toVo(publicCibleCultureScientifiqueOutilPedagogique);
            }

    @ApiOperation("Finds a list of all publicCibleCultureScientifiqueOutilPedagogiques")
    @GetMapping("/")
    public List<PublicCibleCultureScientifiqueOutilPedagogiqueVo> findAll(){
        return publicCibleCultureScientifiqueOutilPedagogiqueConverter.toVo(publicCibleCultureScientifiqueOutilPedagogiqueService.findAll());
    }

    @ApiOperation("Finds a publicCibleCultureScientifiqueOutilPedagogique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PublicCibleCultureScientifiqueOutilPedagogiqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return publicCibleCultureScientifiqueOutilPedagogiqueConverter.toVo(publicCibleCultureScientifiqueOutilPedagogiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search publicCibleCultureScientifiqueOutilPedagogique by a specific criteria")
    @PostMapping("/search")
    public List<PublicCibleCultureScientifiqueOutilPedagogiqueVo> findByCriteria(@RequestBody PublicCibleCultureScientifiqueOutilPedagogiqueVo publicCibleCultureScientifiqueOutilPedagogiqueVo){
        return publicCibleCultureScientifiqueOutilPedagogiqueConverter.toVo(publicCibleCultureScientifiqueOutilPedagogiqueService.findByCriteria(publicCibleCultureScientifiqueOutilPedagogiqueVo));
        }

            @ApiOperation("Finds a publicCibleCultureScientifiqueOutilPedagogique by id")
            @GetMapping("/id/{id}")
            public PublicCibleCultureScientifiqueOutilPedagogiqueVo findById(@PathVariable Long id){
            return publicCibleCultureScientifiqueOutilPedagogiqueConverter.toVo(publicCibleCultureScientifiqueOutilPedagogiqueService.findById(id));
            }

            @ApiOperation("Saves the specified  publicCibleCultureScientifiqueOutilPedagogique")
            @PostMapping("/")
            public PublicCibleCultureScientifiqueOutilPedagogiqueVo save(@RequestBody PublicCibleCultureScientifiqueOutilPedagogiqueVo publicCibleCultureScientifiqueOutilPedagogiqueVo){
            PublicCibleCultureScientifiqueOutilPedagogique publicCibleCultureScientifiqueOutilPedagogique = publicCibleCultureScientifiqueOutilPedagogiqueConverter.toItem(publicCibleCultureScientifiqueOutilPedagogiqueVo);
            publicCibleCultureScientifiqueOutilPedagogique = publicCibleCultureScientifiqueOutilPedagogiqueService.save(publicCibleCultureScientifiqueOutilPedagogique);
            return publicCibleCultureScientifiqueOutilPedagogiqueConverter.toVo(publicCibleCultureScientifiqueOutilPedagogique);
            }

            @ApiOperation("Delete the specified publicCibleCultureScientifiqueOutilPedagogique")
            @DeleteMapping("/")
            public int delete(@RequestBody PublicCibleCultureScientifiqueOutilPedagogiqueVo publicCibleCultureScientifiqueOutilPedagogiqueVo){
            PublicCibleCultureScientifiqueOutilPedagogique publicCibleCultureScientifiqueOutilPedagogique = publicCibleCultureScientifiqueOutilPedagogiqueConverter.toItem(publicCibleCultureScientifiqueOutilPedagogiqueVo);
            return publicCibleCultureScientifiqueOutilPedagogiqueService.delete(publicCibleCultureScientifiqueOutilPedagogique);
            }

            @ApiOperation("Deletes a publicCibleCultureScientifiqueOutilPedagogique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return publicCibleCultureScientifiqueOutilPedagogiqueService.deleteById(id);
            }


        }
