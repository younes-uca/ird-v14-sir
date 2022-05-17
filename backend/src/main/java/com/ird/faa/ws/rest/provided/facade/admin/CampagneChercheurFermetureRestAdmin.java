package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.CampagneChercheurFermetureAdminService;

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
import com.ird.faa.bean.formulaire.CampagneChercheurFermeture;
import com.ird.faa.dao.formulaire.CampagneChercheurFermetureDao;
import com.ird.faa.ws.rest.provided.converter.CampagneChercheurFermetureConverter;
import com.ird.faa.ws.rest.provided.vo.CampagneChercheurFermetureVo;

@Api("Manages campagneChercheurFermeture services")
@RestController
@RequestMapping("api/admin/campagneChercheurFermeture")
public class CampagneChercheurFermetureRestAdmin {

@Autowired
private CampagneChercheurFermetureAdminService campagneChercheurFermetureService;

@Autowired
private CampagneChercheurFermetureConverter campagneChercheurFermetureConverter;


@Autowired
private CampagneChercheurFermetureDao campagneChercheurFermetureDao;


            @ApiOperation("Updates the specified  campagneChercheurFermeture")
            @PutMapping("/")
            public  CampagneChercheurFermetureVo update(@RequestBody  CampagneChercheurFermetureVo  campagneChercheurFermetureVo){
            CampagneChercheurFermeture campagneChercheurFermeture = campagneChercheurFermetureConverter.toItem(campagneChercheurFermetureVo);
            campagneChercheurFermeture = campagneChercheurFermetureService.update(campagneChercheurFermeture);
            return campagneChercheurFermetureConverter.toVo(campagneChercheurFermeture);
            }

    @ApiOperation("Finds a list of all campagneChercheurFermetures")
    @GetMapping("/")
    public List<CampagneChercheurFermetureVo> findAll(){
        return campagneChercheurFermetureConverter.toVo(campagneChercheurFermetureService.findAll());
    }

    @ApiOperation("Finds a campagneChercheurFermeture with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CampagneChercheurFermetureVo findByIdWithAssociatedList(@PathVariable Long id){
    return campagneChercheurFermetureConverter.toVo(campagneChercheurFermetureService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search campagneChercheurFermeture by a specific criteria")
    @PostMapping("/search")
    public List<CampagneChercheurFermetureVo> findByCriteria(@RequestBody CampagneChercheurFermetureVo campagneChercheurFermetureVo){
        return campagneChercheurFermetureConverter.toVo(campagneChercheurFermetureService.findByCriteria(campagneChercheurFermetureVo));
        }

            @ApiOperation("Finds a campagneChercheurFermeture by id")
            @GetMapping("/id/{id}")
            public CampagneChercheurFermetureVo findById(@PathVariable Long id){
            return campagneChercheurFermetureConverter.toVo(campagneChercheurFermetureService.findById(id));
            }

            @ApiOperation("Saves the specified  campagneChercheurFermeture")
            @PostMapping("/")
            public CampagneChercheurFermetureVo save(@RequestBody CampagneChercheurFermetureVo campagneChercheurFermetureVo){
            CampagneChercheurFermeture campagneChercheurFermeture = campagneChercheurFermetureConverter.toItem(campagneChercheurFermetureVo);
            campagneChercheurFermeture = campagneChercheurFermetureService.save(campagneChercheurFermeture);
            return campagneChercheurFermetureConverter.toVo(campagneChercheurFermeture);
            }

            @ApiOperation("Delete the specified campagneChercheurFermeture")
            @DeleteMapping("/")
            public int delete(@RequestBody CampagneChercheurFermetureVo campagneChercheurFermetureVo){
            CampagneChercheurFermeture campagneChercheurFermeture = campagneChercheurFermetureConverter.toItem(campagneChercheurFermetureVo);
            return campagneChercheurFermetureService.delete(campagneChercheurFermeture);
            }

            @ApiOperation("Deletes a campagneChercheurFermeture by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return campagneChercheurFermetureService.deleteById(id);
            }
            
            @ApiOperation("Finds a campagneRelance with associated lists by id")
        	@GetMapping("/findByCampagneId/id/{id}")
        	public List<CampagneChercheurFermetureVo> findByCampagneId(@PathVariable Long id) {
            	List<CampagneChercheurFermetureVo> campagneChercheurOuvertureVo =campagneChercheurFermetureConverter.toVo(campagneChercheurFermetureDao.findByCampagneId(id));
        		return campagneChercheurFermetureConverter.toVo(campagneChercheurFermetureDao.findByCampagneId(id));
        	}



        }
