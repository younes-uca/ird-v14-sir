package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.EtablissementCultureScientifiqueOutilPedagogiqueAdminService;

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
import com.ird.faa.bean.formulaire.EtablissementCultureScientifiqueOutilPedagogique;
import com.ird.faa.ws.rest.provided.converter.EtablissementCultureScientifiqueOutilPedagogiqueConverter;
import com.ird.faa.ws.rest.provided.vo.EtablissementCultureScientifiqueOutilPedagogiqueVo;

@Api("Manages etablissementCultureScientifiqueOutilPedagogique services")
@RestController
@RequestMapping("api/admin/etablissementCultureScientifiqueOutilPedagogique")
public class EtablissementCultureScientifiqueOutilPedagogiqueRestAdmin {

@Autowired
private EtablissementCultureScientifiqueOutilPedagogiqueAdminService etablissementCultureScientifiqueOutilPedagogiqueService;

@Autowired
private EtablissementCultureScientifiqueOutilPedagogiqueConverter etablissementCultureScientifiqueOutilPedagogiqueConverter;


            @ApiOperation("Updates the specified  etablissementCultureScientifiqueOutilPedagogique")
            @PutMapping("/")
            public  EtablissementCultureScientifiqueOutilPedagogiqueVo update(@RequestBody  EtablissementCultureScientifiqueOutilPedagogiqueVo  etablissementCultureScientifiqueOutilPedagogiqueVo){
            EtablissementCultureScientifiqueOutilPedagogique etablissementCultureScientifiqueOutilPedagogique = etablissementCultureScientifiqueOutilPedagogiqueConverter.toItem(etablissementCultureScientifiqueOutilPedagogiqueVo);
            etablissementCultureScientifiqueOutilPedagogique = etablissementCultureScientifiqueOutilPedagogiqueService.update(etablissementCultureScientifiqueOutilPedagogique);
            return etablissementCultureScientifiqueOutilPedagogiqueConverter.toVo(etablissementCultureScientifiqueOutilPedagogique);
            }

    @ApiOperation("Finds a list of all etablissementCultureScientifiqueOutilPedagogiques")
    @GetMapping("/")
    public List<EtablissementCultureScientifiqueOutilPedagogiqueVo> findAll(){
        return etablissementCultureScientifiqueOutilPedagogiqueConverter.toVo(etablissementCultureScientifiqueOutilPedagogiqueService.findAll());
    }

    @ApiOperation("Finds a etablissementCultureScientifiqueOutilPedagogique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtablissementCultureScientifiqueOutilPedagogiqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return etablissementCultureScientifiqueOutilPedagogiqueConverter.toVo(etablissementCultureScientifiqueOutilPedagogiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etablissementCultureScientifiqueOutilPedagogique by a specific criteria")
    @PostMapping("/search")
    public List<EtablissementCultureScientifiqueOutilPedagogiqueVo> findByCriteria(@RequestBody EtablissementCultureScientifiqueOutilPedagogiqueVo etablissementCultureScientifiqueOutilPedagogiqueVo){
        return etablissementCultureScientifiqueOutilPedagogiqueConverter.toVo(etablissementCultureScientifiqueOutilPedagogiqueService.findByCriteria(etablissementCultureScientifiqueOutilPedagogiqueVo));
        }

            @ApiOperation("Finds a etablissementCultureScientifiqueOutilPedagogique by id")
            @GetMapping("/id/{id}")
            public EtablissementCultureScientifiqueOutilPedagogiqueVo findById(@PathVariable Long id){
            return etablissementCultureScientifiqueOutilPedagogiqueConverter.toVo(etablissementCultureScientifiqueOutilPedagogiqueService.findById(id));
            }

            @ApiOperation("Saves the specified  etablissementCultureScientifiqueOutilPedagogique")
            @PostMapping("/")
            public EtablissementCultureScientifiqueOutilPedagogiqueVo save(@RequestBody EtablissementCultureScientifiqueOutilPedagogiqueVo etablissementCultureScientifiqueOutilPedagogiqueVo){
            EtablissementCultureScientifiqueOutilPedagogique etablissementCultureScientifiqueOutilPedagogique = etablissementCultureScientifiqueOutilPedagogiqueConverter.toItem(etablissementCultureScientifiqueOutilPedagogiqueVo);
            etablissementCultureScientifiqueOutilPedagogique = etablissementCultureScientifiqueOutilPedagogiqueService.save(etablissementCultureScientifiqueOutilPedagogique);
            return etablissementCultureScientifiqueOutilPedagogiqueConverter.toVo(etablissementCultureScientifiqueOutilPedagogique);
            }

            @ApiOperation("Delete the specified etablissementCultureScientifiqueOutilPedagogique")
            @DeleteMapping("/")
            public int delete(@RequestBody EtablissementCultureScientifiqueOutilPedagogiqueVo etablissementCultureScientifiqueOutilPedagogiqueVo){
            EtablissementCultureScientifiqueOutilPedagogique etablissementCultureScientifiqueOutilPedagogique = etablissementCultureScientifiqueOutilPedagogiqueConverter.toItem(etablissementCultureScientifiqueOutilPedagogiqueVo);
            return etablissementCultureScientifiqueOutilPedagogiqueService.delete(etablissementCultureScientifiqueOutilPedagogique);
            }

            @ApiOperation("Deletes a etablissementCultureScientifiqueOutilPedagogique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etablissementCultureScientifiqueOutilPedagogiqueService.deleteById(id);
            }


        }
