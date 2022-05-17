package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.PaysCultureScientifiqueRecontreGrandPublicJeunePublicAdminService;

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
import com.ird.faa.bean.formulaire.PaysCultureScientifiqueRecontreGrandPublicJeunePublic;
import com.ird.faa.ws.rest.provided.converter.PaysCultureScientifiqueRecontreGrandPublicJeunePublicConverter;
import com.ird.faa.ws.rest.provided.vo.PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo;

@Api("Manages paysCultureScientifiqueRecontreGrandPublicJeunePublic services")
@RestController
@RequestMapping("api/admin/paysCultureScientifiqueRecontreGrandPublicJeunePublic")
public class PaysCultureScientifiqueRecontreGrandPublicJeunePublicRestAdmin {

@Autowired
private PaysCultureScientifiqueRecontreGrandPublicJeunePublicAdminService paysCultureScientifiqueRecontreGrandPublicJeunePublicService;

@Autowired
private PaysCultureScientifiqueRecontreGrandPublicJeunePublicConverter paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter;


            @ApiOperation("Updates the specified  paysCultureScientifiqueRecontreGrandPublicJeunePublic")
            @PutMapping("/")
            public  PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo update(@RequestBody  PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo  paysCultureScientifiqueRecontreGrandPublicJeunePublicVo){
            PaysCultureScientifiqueRecontreGrandPublicJeunePublic paysCultureScientifiqueRecontreGrandPublicJeunePublic = paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(paysCultureScientifiqueRecontreGrandPublicJeunePublicVo);
            paysCultureScientifiqueRecontreGrandPublicJeunePublic = paysCultureScientifiqueRecontreGrandPublicJeunePublicService.update(paysCultureScientifiqueRecontreGrandPublicJeunePublic);
            return paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(paysCultureScientifiqueRecontreGrandPublicJeunePublic);
            }

    @ApiOperation("Finds a list of all paysCultureScientifiqueRecontreGrandPublicJeunePublics")
    @GetMapping("/")
    public List<PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo> findAll(){
        return paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(paysCultureScientifiqueRecontreGrandPublicJeunePublicService.findAll());
    }

    @ApiOperation("Finds a paysCultureScientifiqueRecontreGrandPublicJeunePublic with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo findByIdWithAssociatedList(@PathVariable Long id){
    return paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(paysCultureScientifiqueRecontreGrandPublicJeunePublicService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search paysCultureScientifiqueRecontreGrandPublicJeunePublic by a specific criteria")
    @PostMapping("/search")
    public List<PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo> findByCriteria(@RequestBody PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo paysCultureScientifiqueRecontreGrandPublicJeunePublicVo){
        return paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(paysCultureScientifiqueRecontreGrandPublicJeunePublicService.findByCriteria(paysCultureScientifiqueRecontreGrandPublicJeunePublicVo));
        }

            @ApiOperation("Finds a paysCultureScientifiqueRecontreGrandPublicJeunePublic by id")
            @GetMapping("/id/{id}")
            public PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo findById(@PathVariable Long id){
            return paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(paysCultureScientifiqueRecontreGrandPublicJeunePublicService.findById(id));
            }

            @ApiOperation("Saves the specified  paysCultureScientifiqueRecontreGrandPublicJeunePublic")
            @PostMapping("/")
            public PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo save(@RequestBody PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo paysCultureScientifiqueRecontreGrandPublicJeunePublicVo){
            PaysCultureScientifiqueRecontreGrandPublicJeunePublic paysCultureScientifiqueRecontreGrandPublicJeunePublic = paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(paysCultureScientifiqueRecontreGrandPublicJeunePublicVo);
            paysCultureScientifiqueRecontreGrandPublicJeunePublic = paysCultureScientifiqueRecontreGrandPublicJeunePublicService.save(paysCultureScientifiqueRecontreGrandPublicJeunePublic);
            return paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toVo(paysCultureScientifiqueRecontreGrandPublicJeunePublic);
            }

            @ApiOperation("Delete the specified paysCultureScientifiqueRecontreGrandPublicJeunePublic")
            @DeleteMapping("/")
            public int delete(@RequestBody PaysCultureScientifiqueRecontreGrandPublicJeunePublicVo paysCultureScientifiqueRecontreGrandPublicJeunePublicVo){
            PaysCultureScientifiqueRecontreGrandPublicJeunePublic paysCultureScientifiqueRecontreGrandPublicJeunePublic = paysCultureScientifiqueRecontreGrandPublicJeunePublicConverter.toItem(paysCultureScientifiqueRecontreGrandPublicJeunePublicVo);
            return paysCultureScientifiqueRecontreGrandPublicJeunePublicService.delete(paysCultureScientifiqueRecontreGrandPublicJeunePublic);
            }

            @ApiOperation("Deletes a paysCultureScientifiqueRecontreGrandPublicJeunePublic by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return paysCultureScientifiqueRecontreGrandPublicJeunePublicService.deleteById(id);
            }


        }
