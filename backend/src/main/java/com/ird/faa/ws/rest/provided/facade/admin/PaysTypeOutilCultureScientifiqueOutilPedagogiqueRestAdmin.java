package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.PaysTypeOutilCultureScientifiqueOutilPedagogiqueAdminService;

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
import com.ird.faa.bean.formulaire.PaysTypeOutilCultureScientifiqueOutilPedagogique;
import com.ird.faa.ws.rest.provided.converter.PaysTypeOutilCultureScientifiqueOutilPedagogiqueConverter;
import com.ird.faa.ws.rest.provided.vo.PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo;

@Api("Manages paysTypeOutilCultureScientifiqueOutilPedagogique services")
@RestController
@RequestMapping("api/admin/paysTypeOutilCultureScientifiqueOutilPedagogique")
public class PaysTypeOutilCultureScientifiqueOutilPedagogiqueRestAdmin {

@Autowired
private PaysTypeOutilCultureScientifiqueOutilPedagogiqueAdminService paysTypeOutilCultureScientifiqueOutilPedagogiqueService;

@Autowired
private PaysTypeOutilCultureScientifiqueOutilPedagogiqueConverter paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter;


            @ApiOperation("Updates the specified  paysTypeOutilCultureScientifiqueOutilPedagogique")
            @PutMapping("/")
            public  PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo update(@RequestBody  PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo  paysTypeOutilCultureScientifiqueOutilPedagogiqueVo){
            PaysTypeOutilCultureScientifiqueOutilPedagogique paysTypeOutilCultureScientifiqueOutilPedagogique = paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter.toItem(paysTypeOutilCultureScientifiqueOutilPedagogiqueVo);
            paysTypeOutilCultureScientifiqueOutilPedagogique = paysTypeOutilCultureScientifiqueOutilPedagogiqueService.update(paysTypeOutilCultureScientifiqueOutilPedagogique);
            return paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter.toVo(paysTypeOutilCultureScientifiqueOutilPedagogique);
            }

    @ApiOperation("Finds a list of all paysTypeOutilCultureScientifiqueOutilPedagogiques")
    @GetMapping("/")
    public List<PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo> findAll(){
        return paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter.toVo(paysTypeOutilCultureScientifiqueOutilPedagogiqueService.findAll());
    }

    @ApiOperation("Finds a paysTypeOutilCultureScientifiqueOutilPedagogique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter.toVo(paysTypeOutilCultureScientifiqueOutilPedagogiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search paysTypeOutilCultureScientifiqueOutilPedagogique by a specific criteria")
    @PostMapping("/search")
    public List<PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo> findByCriteria(@RequestBody PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo paysTypeOutilCultureScientifiqueOutilPedagogiqueVo){
        return paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter.toVo(paysTypeOutilCultureScientifiqueOutilPedagogiqueService.findByCriteria(paysTypeOutilCultureScientifiqueOutilPedagogiqueVo));
        }

            @ApiOperation("Finds a paysTypeOutilCultureScientifiqueOutilPedagogique by id")
            @GetMapping("/id/{id}")
            public PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo findById(@PathVariable Long id){
            return paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter.toVo(paysTypeOutilCultureScientifiqueOutilPedagogiqueService.findById(id));
            }

            @ApiOperation("Saves the specified  paysTypeOutilCultureScientifiqueOutilPedagogique")
            @PostMapping("/")
            public PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo save(@RequestBody PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo paysTypeOutilCultureScientifiqueOutilPedagogiqueVo){
            PaysTypeOutilCultureScientifiqueOutilPedagogique paysTypeOutilCultureScientifiqueOutilPedagogique = paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter.toItem(paysTypeOutilCultureScientifiqueOutilPedagogiqueVo);
            paysTypeOutilCultureScientifiqueOutilPedagogique = paysTypeOutilCultureScientifiqueOutilPedagogiqueService.save(paysTypeOutilCultureScientifiqueOutilPedagogique);
            return paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter.toVo(paysTypeOutilCultureScientifiqueOutilPedagogique);
            }

            @ApiOperation("Delete the specified paysTypeOutilCultureScientifiqueOutilPedagogique")
            @DeleteMapping("/")
            public int delete(@RequestBody PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo paysTypeOutilCultureScientifiqueOutilPedagogiqueVo){
            PaysTypeOutilCultureScientifiqueOutilPedagogique paysTypeOutilCultureScientifiqueOutilPedagogique = paysTypeOutilCultureScientifiqueOutilPedagogiqueConverter.toItem(paysTypeOutilCultureScientifiqueOutilPedagogiqueVo);
            return paysTypeOutilCultureScientifiqueOutilPedagogiqueService.delete(paysTypeOutilCultureScientifiqueOutilPedagogique);
            }

            @ApiOperation("Deletes a paysTypeOutilCultureScientifiqueOutilPedagogique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return paysTypeOutilCultureScientifiqueOutilPedagogiqueService.deleteById(id);
            }


        }
