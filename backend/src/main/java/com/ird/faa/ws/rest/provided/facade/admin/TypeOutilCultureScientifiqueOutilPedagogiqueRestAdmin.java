package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.TypeOutilCultureScientifiqueOutilPedagogiqueAdminService;

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
import com.ird.faa.bean.formulaire.TypeOutilCultureScientifiqueOutilPedagogique;
import com.ird.faa.ws.rest.provided.converter.TypeOutilCultureScientifiqueOutilPedagogiqueConverter;
import com.ird.faa.ws.rest.provided.vo.TypeOutilCultureScientifiqueOutilPedagogiqueVo;

@Api("Manages typeOutilCultureScientifiqueOutilPedagogique services")
@RestController
@RequestMapping("api/admin/typeOutilCultureScientifiqueOutilPedagogique")
public class TypeOutilCultureScientifiqueOutilPedagogiqueRestAdmin {

@Autowired
private TypeOutilCultureScientifiqueOutilPedagogiqueAdminService typeOutilCultureScientifiqueOutilPedagogiqueService;

@Autowired
private TypeOutilCultureScientifiqueOutilPedagogiqueConverter typeOutilCultureScientifiqueOutilPedagogiqueConverter;


            @ApiOperation("Updates the specified  typeOutilCultureScientifiqueOutilPedagogique")
            @PutMapping("/")
            public  TypeOutilCultureScientifiqueOutilPedagogiqueVo update(@RequestBody  TypeOutilCultureScientifiqueOutilPedagogiqueVo  typeOutilCultureScientifiqueOutilPedagogiqueVo){
            TypeOutilCultureScientifiqueOutilPedagogique typeOutilCultureScientifiqueOutilPedagogique = typeOutilCultureScientifiqueOutilPedagogiqueConverter.toItem(typeOutilCultureScientifiqueOutilPedagogiqueVo);
            typeOutilCultureScientifiqueOutilPedagogique = typeOutilCultureScientifiqueOutilPedagogiqueService.update(typeOutilCultureScientifiqueOutilPedagogique);
            return typeOutilCultureScientifiqueOutilPedagogiqueConverter.toVo(typeOutilCultureScientifiqueOutilPedagogique);
            }

    @ApiOperation("Finds a list of all typeOutilCultureScientifiqueOutilPedagogiques")
    @GetMapping("/")
    public List<TypeOutilCultureScientifiqueOutilPedagogiqueVo> findAll(){
        return typeOutilCultureScientifiqueOutilPedagogiqueConverter.toVo(typeOutilCultureScientifiqueOutilPedagogiqueService.findAll());
    }

    @ApiOperation("Finds a typeOutilCultureScientifiqueOutilPedagogique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeOutilCultureScientifiqueOutilPedagogiqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return typeOutilCultureScientifiqueOutilPedagogiqueConverter.toVo(typeOutilCultureScientifiqueOutilPedagogiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeOutilCultureScientifiqueOutilPedagogique by a specific criteria")
    @PostMapping("/search")
    public List<TypeOutilCultureScientifiqueOutilPedagogiqueVo> findByCriteria(@RequestBody TypeOutilCultureScientifiqueOutilPedagogiqueVo typeOutilCultureScientifiqueOutilPedagogiqueVo){
        return typeOutilCultureScientifiqueOutilPedagogiqueConverter.toVo(typeOutilCultureScientifiqueOutilPedagogiqueService.findByCriteria(typeOutilCultureScientifiqueOutilPedagogiqueVo));
        }

            @ApiOperation("Finds a typeOutilCultureScientifiqueOutilPedagogique by id")
            @GetMapping("/id/{id}")
            public TypeOutilCultureScientifiqueOutilPedagogiqueVo findById(@PathVariable Long id){
            return typeOutilCultureScientifiqueOutilPedagogiqueConverter.toVo(typeOutilCultureScientifiqueOutilPedagogiqueService.findById(id));
            }

            @ApiOperation("Saves the specified  typeOutilCultureScientifiqueOutilPedagogique")
            @PostMapping("/")
            public TypeOutilCultureScientifiqueOutilPedagogiqueVo save(@RequestBody TypeOutilCultureScientifiqueOutilPedagogiqueVo typeOutilCultureScientifiqueOutilPedagogiqueVo){
            TypeOutilCultureScientifiqueOutilPedagogique typeOutilCultureScientifiqueOutilPedagogique = typeOutilCultureScientifiqueOutilPedagogiqueConverter.toItem(typeOutilCultureScientifiqueOutilPedagogiqueVo);
            typeOutilCultureScientifiqueOutilPedagogique = typeOutilCultureScientifiqueOutilPedagogiqueService.save(typeOutilCultureScientifiqueOutilPedagogique);
            return typeOutilCultureScientifiqueOutilPedagogiqueConverter.toVo(typeOutilCultureScientifiqueOutilPedagogique);
            }

            @ApiOperation("Delete the specified typeOutilCultureScientifiqueOutilPedagogique")
            @DeleteMapping("/")
            public int delete(@RequestBody TypeOutilCultureScientifiqueOutilPedagogiqueVo typeOutilCultureScientifiqueOutilPedagogiqueVo){
            TypeOutilCultureScientifiqueOutilPedagogique typeOutilCultureScientifiqueOutilPedagogique = typeOutilCultureScientifiqueOutilPedagogiqueConverter.toItem(typeOutilCultureScientifiqueOutilPedagogiqueVo);
            return typeOutilCultureScientifiqueOutilPedagogiqueService.delete(typeOutilCultureScientifiqueOutilPedagogique);
            }

            @ApiOperation("Deletes a typeOutilCultureScientifiqueOutilPedagogique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typeOutilCultureScientifiqueOutilPedagogiqueService.deleteById(id);
            }


        }
