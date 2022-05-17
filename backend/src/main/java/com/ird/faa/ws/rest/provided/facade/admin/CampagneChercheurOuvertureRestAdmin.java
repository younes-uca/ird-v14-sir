package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.CampagneChercheurOuvertureAdminService;

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
import com.ird.faa.bean.formulaire.CampagneChercheurOuverture;
import com.ird.faa.dao.formulaire.CampagneChercheurOuvertureDao;
import com.ird.faa.ws.rest.provided.converter.CampagneChercheurOuvertureConverter;
import com.ird.faa.ws.rest.provided.vo.CampagneChercheurOuvertureVo;
import com.ird.faa.ws.rest.provided.vo.ChercheurVo;

@Api("Manages campagneChercheurOuverture services")
@RestController
@RequestMapping("api/admin/campagneChercheurOuverture")
public class CampagneChercheurOuvertureRestAdmin {

@Autowired
private CampagneChercheurOuvertureAdminService campagneChercheurOuvertureService;

@Autowired
private CampagneChercheurOuvertureConverter campagneChercheurOuvertureConverter;

@Autowired
private CampagneChercheurOuvertureDao campagneChercheurOuvertureDao;


            @ApiOperation("Updates the specified  campagneChercheurOuverture")
            @PutMapping("/")
            public  CampagneChercheurOuvertureVo update(@RequestBody  CampagneChercheurOuvertureVo  campagneChercheurOuvertureVo){
            CampagneChercheurOuverture campagneChercheurOuverture = campagneChercheurOuvertureConverter.toItem(campagneChercheurOuvertureVo);
            campagneChercheurOuverture = campagneChercheurOuvertureService.update(campagneChercheurOuverture);
            return campagneChercheurOuvertureConverter.toVo(campagneChercheurOuverture);
            }

	@ApiOperation("Finds a list of all campagneChercheurOuvertures")
	@GetMapping("/")
	public List<CampagneChercheurOuvertureVo> findAll() {
		List<CampagneChercheurOuvertureVo> campagneChercheurOuvertures = campagneChercheurOuvertureConverter
				.toVo(campagneChercheurOuvertureService.findAll());
		return campagneChercheurOuvertureConverter.toVo(campagneChercheurOuvertureService.findAll());
	}

    @ApiOperation("Finds a campagneChercheurOuverture with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CampagneChercheurOuvertureVo findByIdWithAssociatedList(@PathVariable Long id){
    return campagneChercheurOuvertureConverter.toVo(campagneChercheurOuvertureService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search campagneChercheurOuverture by a specific criteria")
    @PostMapping("/search")
    public List<CampagneChercheurOuvertureVo> findByCriteria(@RequestBody CampagneChercheurOuvertureVo campagneChercheurOuvertureVo){
        return campagneChercheurOuvertureConverter.toVo(campagneChercheurOuvertureService.findByCriteria(campagneChercheurOuvertureVo));
        }

            @ApiOperation("Finds a campagneChercheurOuverture by id")
            @GetMapping("/id/{id}")
            public CampagneChercheurOuvertureVo findById(@PathVariable Long id){
            return campagneChercheurOuvertureConverter.toVo(campagneChercheurOuvertureService.findById(id));
            }

            @ApiOperation("Saves the specified  campagneChercheurOuverture")
            @PostMapping("/")
            public CampagneChercheurOuvertureVo save(@RequestBody CampagneChercheurOuvertureVo campagneChercheurOuvertureVo){
            CampagneChercheurOuverture campagneChercheurOuverture = campagneChercheurOuvertureConverter.toItem(campagneChercheurOuvertureVo);
            campagneChercheurOuverture = campagneChercheurOuvertureService.save(campagneChercheurOuverture);
            return campagneChercheurOuvertureConverter.toVo(campagneChercheurOuverture);
            }

            @ApiOperation("Delete the specified campagneChercheurOuverture")
            @DeleteMapping("/")
            public int delete(@RequestBody CampagneChercheurOuvertureVo campagneChercheurOuvertureVo){
            CampagneChercheurOuverture campagneChercheurOuverture = campagneChercheurOuvertureConverter.toItem(campagneChercheurOuvertureVo);
            return campagneChercheurOuvertureService.delete(campagneChercheurOuverture);
            }

            @ApiOperation("Deletes a campagneChercheurOuverture by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return campagneChercheurOuvertureService.deleteById(id);
            }
            
            @ApiOperation("Finds a campagneRelance with associated lists by id")
        	@GetMapping("/findByCampagneId/id/{id}")
        	public List<CampagneChercheurOuvertureVo> findByCampagneId(@PathVariable Long id) {
            	List<CampagneChercheurOuvertureVo> campagneChercheurOuvertureVo =campagneChercheurOuvertureConverter.toVo(campagneChercheurOuvertureDao.findByCampagneId(id));
        		return campagneChercheurOuvertureConverter.toVo(campagneChercheurOuvertureDao.findByCampagneId(id));
        	}
            @ApiOperation("Finds chercheurs by campagne id")
        	@GetMapping("/findChercheursByCampagneId/id/{id}")
        	public List<ChercheurVo> findChercheursByCampagneId(@PathVariable Long id) {
            	List<ChercheurVo> campagneChercheurOuvertureChercheursVo = campagneChercheurOuvertureService.findListChercheursByCampagneId(id);
        		return campagneChercheurOuvertureChercheursVo;
        	}
            

        }
