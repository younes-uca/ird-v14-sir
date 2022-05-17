package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.TypeInstrumentsEtDispositifsIrdAdminService;

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
import com.ird.faa.bean.referentiel.TypeInstrumentsEtDispositifsIrd;
import com.ird.faa.ws.rest.provided.converter.TypeInstrumentsEtDispositifsIrdConverter;
import com.ird.faa.ws.rest.provided.vo.TypeInstrumentsEtDispositifsIrdVo;

@Api("Manages typeInstrumentsEtDispositifsIrd services")
@RestController
@RequestMapping("api/admin/typeInstrumentsEtDispositifsIrd")
public class TypeInstrumentsEtDispositifsIrdRestAdmin {

@Autowired
private TypeInstrumentsEtDispositifsIrdAdminService typeInstrumentsEtDispositifsIrdService;

@Autowired
private TypeInstrumentsEtDispositifsIrdConverter typeInstrumentsEtDispositifsIrdConverter;


            @ApiOperation("Updates the specified  typeInstrumentsEtDispositifsIrd")
            @PutMapping("/")
            public  TypeInstrumentsEtDispositifsIrdVo update(@RequestBody  TypeInstrumentsEtDispositifsIrdVo  typeInstrumentsEtDispositifsIrdVo){
            TypeInstrumentsEtDispositifsIrd typeInstrumentsEtDispositifsIrd = typeInstrumentsEtDispositifsIrdConverter.toItem(typeInstrumentsEtDispositifsIrdVo);
            typeInstrumentsEtDispositifsIrd = typeInstrumentsEtDispositifsIrdService.update(typeInstrumentsEtDispositifsIrd);
            return typeInstrumentsEtDispositifsIrdConverter.toVo(typeInstrumentsEtDispositifsIrd);
            }

    @ApiOperation("Finds a list of all typeInstrumentsEtDispositifsIrds")
    @GetMapping("/")
    public List<TypeInstrumentsEtDispositifsIrdVo> findAll(){
        return typeInstrumentsEtDispositifsIrdConverter.toVo(typeInstrumentsEtDispositifsIrdService.findAll());
    }

    @ApiOperation("Finds a typeInstrumentsEtDispositifsIrd with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeInstrumentsEtDispositifsIrdVo findByIdWithAssociatedList(@PathVariable Long id){
    return typeInstrumentsEtDispositifsIrdConverter.toVo(typeInstrumentsEtDispositifsIrdService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeInstrumentsEtDispositifsIrd by a specific criteria")
    @PostMapping("/search")
    public List<TypeInstrumentsEtDispositifsIrdVo> findByCriteria(@RequestBody TypeInstrumentsEtDispositifsIrdVo typeInstrumentsEtDispositifsIrdVo){
        return typeInstrumentsEtDispositifsIrdConverter.toVo(typeInstrumentsEtDispositifsIrdService.findByCriteria(typeInstrumentsEtDispositifsIrdVo));
        }

            @ApiOperation("Finds a typeInstrumentsEtDispositifsIrd by id")
            @GetMapping("/id/{id}")
            public TypeInstrumentsEtDispositifsIrdVo findById(@PathVariable Long id){
            return typeInstrumentsEtDispositifsIrdConverter.toVo(typeInstrumentsEtDispositifsIrdService.findById(id));
            }

            @ApiOperation("Saves the specified  typeInstrumentsEtDispositifsIrd")
            @PostMapping("/")
            public TypeInstrumentsEtDispositifsIrdVo save(@RequestBody TypeInstrumentsEtDispositifsIrdVo typeInstrumentsEtDispositifsIrdVo){
            TypeInstrumentsEtDispositifsIrd typeInstrumentsEtDispositifsIrd = typeInstrumentsEtDispositifsIrdConverter.toItem(typeInstrumentsEtDispositifsIrdVo);
            typeInstrumentsEtDispositifsIrd = typeInstrumentsEtDispositifsIrdService.save(typeInstrumentsEtDispositifsIrd);
            return typeInstrumentsEtDispositifsIrdConverter.toVo(typeInstrumentsEtDispositifsIrd);
            }

            @ApiOperation("Delete the specified typeInstrumentsEtDispositifsIrd")
            @DeleteMapping("/")
            public int delete(@RequestBody TypeInstrumentsEtDispositifsIrdVo typeInstrumentsEtDispositifsIrdVo){
            TypeInstrumentsEtDispositifsIrd typeInstrumentsEtDispositifsIrd = typeInstrumentsEtDispositifsIrdConverter.toItem(typeInstrumentsEtDispositifsIrdVo);
            return typeInstrumentsEtDispositifsIrdService.delete(typeInstrumentsEtDispositifsIrd);
            }

            @ApiOperation("Deletes a typeInstrumentsEtDispositifsIrd by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typeInstrumentsEtDispositifsIrdService.deleteById(id);
            }


        }
