package com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.CampagneRelanceAdminService;

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

import com.ird.faa.bean.formulaire.CampagneRelance;
import com.ird.faa.dao.formulaire.CampagneRelanceDao;
import com.ird.faa.ws.rest.provided.converter.CampagneRelanceConverter;
import com.ird.faa.ws.rest.provided.vo.CampagneRelanceVo;

@Api("Manages campagneRelance services")
@RestController
@RequestMapping("api/admin/campagneRelance")
public class CampagneRelanceRestAdmin {

	@Autowired
	private CampagneRelanceAdminService campagneRelanceService;

	@Autowired
	private CampagneRelanceConverter campagneRelanceConverter;

	@Autowired
	private CampagneRelanceDao campagneRelanceDao;

	@ApiOperation("Updates the specified  campagneRelance")
	@PutMapping("/")
	public CampagneRelanceVo update(@RequestBody CampagneRelanceVo campagneRelanceVo) {
		CampagneRelance campagneRelance = campagneRelanceConverter.toItem(campagneRelanceVo);
		campagneRelance = campagneRelanceService.update(campagneRelance);
		return campagneRelanceConverter.toVo(campagneRelance);
	}

	@ApiOperation("Finds a list of all campagneRelances")
	@GetMapping("/")
	public List<CampagneRelanceVo> findAll() {
		List<CampagneRelanceVo> campagneRelances = campagneRelanceConverter.toVo(campagneRelanceService.findAll());
		return campagneRelanceConverter.toVo(campagneRelanceService.findAll());
	}

	@ApiOperation("Finds a campagneRelance with associated lists by id")
	@GetMapping("/detail/id/{id}")
	public CampagneRelanceVo findByIdWithAssociatedList(@PathVariable Long id) {
		return campagneRelanceConverter.toVo(campagneRelanceService.findByIdWithAssociatedList(id));
	}

	@ApiOperation("Search campagneRelance by a specific criteria")
	@PostMapping("/search")
	public List<CampagneRelanceVo> findByCriteria(@RequestBody CampagneRelanceVo campagneRelanceVo) {
		return campagneRelanceConverter.toVo(campagneRelanceService.findByCriteria(campagneRelanceVo));
	}

	@ApiOperation("Finds a campagneRelance by id")
	@GetMapping("/id/{id}")
	public CampagneRelanceVo findById(@PathVariable Long id) {
		return campagneRelanceConverter.toVo(campagneRelanceService.findById(id));
	}

	@ApiOperation("Saves the specified  campagneRelance")
	@PostMapping("/")
	public CampagneRelanceVo save(@RequestBody CampagneRelanceVo campagneRelanceVo) {
		CampagneRelance campagneRelance = campagneRelanceConverter.toItem(campagneRelanceVo);
		campagneRelance = campagneRelanceService.save(campagneRelance);
		return campagneRelanceConverter.toVo(campagneRelance);
	}

	@ApiOperation("Delete the specified campagneRelance")
	@DeleteMapping("/")
	public int delete(@RequestBody CampagneRelanceVo campagneRelanceVo) {
		System.out.println("delete campagneRelance");
		CampagneRelance campagneRelance = campagneRelanceConverter.toItem(campagneRelanceVo);
		return campagneRelanceService.delete(campagneRelance);
	}

	@ApiOperation("Deletes a campagneRelance by id")
	@DeleteMapping("/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return campagneRelanceService.deleteById(id);
	}

	@ApiOperation("Finds a campagneRelance with associated lists by id")
	@GetMapping("/findByCampagneId/id/{id}")
	public List<CampagneRelanceVo> findByCampagneId(@PathVariable Long id) {
		return campagneRelanceConverter.toVo(campagneRelanceDao.findByCampagneId(id));
	}
	
    @ApiOperation("Saves the specified  campagne and send email to chercheurs")
    @PostMapping("/sendEmailRelance")
    public void sendEmailRelance(@RequestBody CampagneRelanceVo campagneRelanceVo){
    	campagneRelanceConverter.setCampagne(true);
     CampagneRelance campagneRelance = campagneRelanceConverter.toItem(campagneRelanceVo);
     campagneRelanceConverter.setCampagne(false);
     campagneRelanceService.sendEmailRelance(campagneRelance);
 
    }
    

}
