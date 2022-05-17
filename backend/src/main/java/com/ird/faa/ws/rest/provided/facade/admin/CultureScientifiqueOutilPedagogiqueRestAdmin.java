package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.CultureScientifiqueOutilPedagogiqueAdminService;

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
import com.ird.faa.bean.formulaire.CultureScientifiqueOutilPedagogique;
import com.ird.faa.ws.rest.provided.converter.CultureScientifiqueOutilPedagogiqueConverter;
import com.ird.faa.ws.rest.provided.vo.CultureScientifiqueOutilPedagogiqueVo;

@Api("Manages cultureScientifiqueOutilPedagogique services")
@RestController
@RequestMapping("api/admin/cultureScientifiqueOutilPedagogique")
public class CultureScientifiqueOutilPedagogiqueRestAdmin {

@Autowired
private CultureScientifiqueOutilPedagogiqueAdminService cultureScientifiqueOutilPedagogiqueService;

@Autowired
private CultureScientifiqueOutilPedagogiqueConverter cultureScientifiqueOutilPedagogiqueConverter;


            @ApiOperation("Updates the specified  cultureScientifiqueOutilPedagogique")
            @PutMapping("/")
            public  CultureScientifiqueOutilPedagogiqueVo update(@RequestBody  CultureScientifiqueOutilPedagogiqueVo  cultureScientifiqueOutilPedagogiqueVo){
            CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique = cultureScientifiqueOutilPedagogiqueConverter.toItem(cultureScientifiqueOutilPedagogiqueVo);
            cultureScientifiqueOutilPedagogique = cultureScientifiqueOutilPedagogiqueService.update(cultureScientifiqueOutilPedagogique);
            return cultureScientifiqueOutilPedagogiqueConverter.toVo(cultureScientifiqueOutilPedagogique);
            }

    @ApiOperation("Finds a list of all cultureScientifiqueOutilPedagogiques")
    @GetMapping("/")
    public List<CultureScientifiqueOutilPedagogiqueVo> findAll(){
        return cultureScientifiqueOutilPedagogiqueConverter.toVo(cultureScientifiqueOutilPedagogiqueService.findAll());
    }

    @ApiOperation("Finds a cultureScientifiqueOutilPedagogique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CultureScientifiqueOutilPedagogiqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return cultureScientifiqueOutilPedagogiqueConverter.toVo(cultureScientifiqueOutilPedagogiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search cultureScientifiqueOutilPedagogique by a specific criteria")
    @PostMapping("/search")
    public List<CultureScientifiqueOutilPedagogiqueVo> findByCriteria(@RequestBody CultureScientifiqueOutilPedagogiqueVo cultureScientifiqueOutilPedagogiqueVo){
        return cultureScientifiqueOutilPedagogiqueConverter.toVo(cultureScientifiqueOutilPedagogiqueService.findByCriteria(cultureScientifiqueOutilPedagogiqueVo));
        }

            @ApiOperation("Finds a cultureScientifiqueOutilPedagogique by id")
            @GetMapping("/id/{id}")
            public CultureScientifiqueOutilPedagogiqueVo findById(@PathVariable Long id){
            return cultureScientifiqueOutilPedagogiqueConverter.toVo(cultureScientifiqueOutilPedagogiqueService.findById(id));
            }

            @ApiOperation("Saves the specified  cultureScientifiqueOutilPedagogique")
            @PostMapping("/")
            public CultureScientifiqueOutilPedagogiqueVo save(@RequestBody CultureScientifiqueOutilPedagogiqueVo cultureScientifiqueOutilPedagogiqueVo){
            CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique = cultureScientifiqueOutilPedagogiqueConverter.toItem(cultureScientifiqueOutilPedagogiqueVo);
            cultureScientifiqueOutilPedagogique = cultureScientifiqueOutilPedagogiqueService.save(cultureScientifiqueOutilPedagogique);
            return cultureScientifiqueOutilPedagogiqueConverter.toVo(cultureScientifiqueOutilPedagogique);
            }

            @ApiOperation("Delete the specified cultureScientifiqueOutilPedagogique")
            @DeleteMapping("/")
            public int delete(@RequestBody CultureScientifiqueOutilPedagogiqueVo cultureScientifiqueOutilPedagogiqueVo){
            CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique = cultureScientifiqueOutilPedagogiqueConverter.toItem(cultureScientifiqueOutilPedagogiqueVo);
            return cultureScientifiqueOutilPedagogiqueService.delete(cultureScientifiqueOutilPedagogique);
            }

            @ApiOperation("Deletes a cultureScientifiqueOutilPedagogique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return cultureScientifiqueOutilPedagogiqueService.deleteById(id);
            }


        }
