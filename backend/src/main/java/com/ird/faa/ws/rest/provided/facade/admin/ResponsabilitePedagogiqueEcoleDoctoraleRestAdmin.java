package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.ResponsabilitePedagogiqueEcoleDoctoraleAdminService;

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
import com.ird.faa.bean.formulaire.ResponsabilitePedagogiqueEcoleDoctorale;
import com.ird.faa.ws.rest.provided.converter.ResponsabilitePedagogiqueEcoleDoctoraleConverter;
import com.ird.faa.ws.rest.provided.vo.ResponsabilitePedagogiqueEcoleDoctoraleVo;

@Api("Manages responsabilitePedagogiqueEcoleDoctorale services")
@RestController
@RequestMapping("api/admin/responsabilitePedagogiqueEcoleDoctorale")
public class ResponsabilitePedagogiqueEcoleDoctoraleRestAdmin {

@Autowired
private ResponsabilitePedagogiqueEcoleDoctoraleAdminService responsabilitePedagogiqueEcoleDoctoraleService;

@Autowired
private ResponsabilitePedagogiqueEcoleDoctoraleConverter responsabilitePedagogiqueEcoleDoctoraleConverter;


            @ApiOperation("Updates the specified  responsabilitePedagogiqueEcoleDoctorale")
            @PutMapping("/")
            public  ResponsabilitePedagogiqueEcoleDoctoraleVo update(@RequestBody  ResponsabilitePedagogiqueEcoleDoctoraleVo  responsabilitePedagogiqueEcoleDoctoraleVo){
            ResponsabilitePedagogiqueEcoleDoctorale responsabilitePedagogiqueEcoleDoctorale = responsabilitePedagogiqueEcoleDoctoraleConverter.toItem(responsabilitePedagogiqueEcoleDoctoraleVo);
            responsabilitePedagogiqueEcoleDoctorale = responsabilitePedagogiqueEcoleDoctoraleService.update(responsabilitePedagogiqueEcoleDoctorale);
            return responsabilitePedagogiqueEcoleDoctoraleConverter.toVo(responsabilitePedagogiqueEcoleDoctorale);
            }

    @ApiOperation("Finds a list of all responsabilitePedagogiqueEcoleDoctorales")
    @GetMapping("/")
    public List<ResponsabilitePedagogiqueEcoleDoctoraleVo> findAll(){
        return responsabilitePedagogiqueEcoleDoctoraleConverter.toVo(responsabilitePedagogiqueEcoleDoctoraleService.findAll());
    }

    @ApiOperation("Finds a responsabilitePedagogiqueEcoleDoctorale with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ResponsabilitePedagogiqueEcoleDoctoraleVo findByIdWithAssociatedList(@PathVariable Long id){
    return responsabilitePedagogiqueEcoleDoctoraleConverter.toVo(responsabilitePedagogiqueEcoleDoctoraleService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search responsabilitePedagogiqueEcoleDoctorale by a specific criteria")
    @PostMapping("/search")
    public List<ResponsabilitePedagogiqueEcoleDoctoraleVo> findByCriteria(@RequestBody ResponsabilitePedagogiqueEcoleDoctoraleVo responsabilitePedagogiqueEcoleDoctoraleVo){
        return responsabilitePedagogiqueEcoleDoctoraleConverter.toVo(responsabilitePedagogiqueEcoleDoctoraleService.findByCriteria(responsabilitePedagogiqueEcoleDoctoraleVo));
        }

            @ApiOperation("Finds a responsabilitePedagogiqueEcoleDoctorale by id")
            @GetMapping("/id/{id}")
            public ResponsabilitePedagogiqueEcoleDoctoraleVo findById(@PathVariable Long id){
            return responsabilitePedagogiqueEcoleDoctoraleConverter.toVo(responsabilitePedagogiqueEcoleDoctoraleService.findById(id));
            }

            @ApiOperation("Saves the specified  responsabilitePedagogiqueEcoleDoctorale")
            @PostMapping("/")
            public ResponsabilitePedagogiqueEcoleDoctoraleVo save(@RequestBody ResponsabilitePedagogiqueEcoleDoctoraleVo responsabilitePedagogiqueEcoleDoctoraleVo){
            ResponsabilitePedagogiqueEcoleDoctorale responsabilitePedagogiqueEcoleDoctorale = responsabilitePedagogiqueEcoleDoctoraleConverter.toItem(responsabilitePedagogiqueEcoleDoctoraleVo);
            responsabilitePedagogiqueEcoleDoctorale = responsabilitePedagogiqueEcoleDoctoraleService.save(responsabilitePedagogiqueEcoleDoctorale);
            return responsabilitePedagogiqueEcoleDoctoraleConverter.toVo(responsabilitePedagogiqueEcoleDoctorale);
            }

            @ApiOperation("Delete the specified responsabilitePedagogiqueEcoleDoctorale")
            @DeleteMapping("/")
            public int delete(@RequestBody ResponsabilitePedagogiqueEcoleDoctoraleVo responsabilitePedagogiqueEcoleDoctoraleVo){
            ResponsabilitePedagogiqueEcoleDoctorale responsabilitePedagogiqueEcoleDoctorale = responsabilitePedagogiqueEcoleDoctoraleConverter.toItem(responsabilitePedagogiqueEcoleDoctoraleVo);
            return responsabilitePedagogiqueEcoleDoctoraleService.delete(responsabilitePedagogiqueEcoleDoctorale);
            }

            @ApiOperation("Deletes a responsabilitePedagogiqueEcoleDoctorale by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return responsabilitePedagogiqueEcoleDoctoraleService.deleteById(id);
            }


        }
