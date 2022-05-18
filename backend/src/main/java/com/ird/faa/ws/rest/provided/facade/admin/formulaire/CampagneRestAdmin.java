package main.java.com.ird.faa.ws.rest.provided.facade.admin.formulaire;

import com.ird.faa.service.admin.facade.formulaire.CampagneAdminService;
import com.ird.faa.service.admin.facade.formulaire.CampagneChercheurAdminService;
import com.ird.faa.service.util.DateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import com.ird.faa.bean.formulaire.Campagne;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.CampagneConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.CampagneVo;

@Api("Manages campagne services")
@RestController
@RequestMapping("api/admin/campagne")
public class CampagneRestAdmin {

	@Autowired
	private CampagneAdminService campagneService;

	@Autowired
	private CampagneChercheurAdminService campagneChercheurService;

	@Autowired
	private CampagneConverter campagneConverter;

	@ApiOperation("Updates the specified  campagne")
	@PutMapping("/")
	public CampagneVo update(@RequestBody CampagneVo campagneVo) {
		Date anneeDate = DateUtil.parseDateCampagne(campagneVo.getAnnee());
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(anneeDate);
		int year = calendar.get(Calendar.YEAR);
		campagneVo.setAnnee(Integer.toString(year));
		Campagne campagne = campagneConverter.toItem(campagneVo);
		campagne = campagneService.update(campagne);
		return campagneConverter.toVo(campagne);
	}

	@ApiOperation("Finds a list of all campagnes")
	@GetMapping("/")
	public List<CampagneVo> findAll() {
		return campagneConverter.toVo(campagneService.findAll());
	}

	@ApiOperation("Finds a campagne with associated lists by id")
	@GetMapping("/detail/id/{id}")
	public CampagneVo findByIdWithAssociatedList(@PathVariable Long id) {
		Campagne campagne = campagneService.findByIdWithAssociatedList(id);
		return campagneConverter.toVo(campagne);
	}

	@ApiOperation("Search campagne by a specific criteria")
	@PostMapping("/search")
	public List<CampagneVo> findByCriteria(@RequestBody CampagneVo campagneVo) {
		return campagneConverter.toVo(campagneService.findByCriteria(campagneVo));
	}

	@ApiOperation("Finds a campagne by id")
	@GetMapping("/id/{id}")
	public CampagneVo findById(@PathVariable Long id) {
		return campagneConverter.toVo(campagneService.findById(id));
	}

	@ApiOperation("Saves the specified  campagne")
	@PostMapping("/")
	public CampagneVo save(@RequestBody CampagneVo campagneVo) {
		Date anneeDate = DateUtil.parseDateCampagne(campagneVo.getAnnee());
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(anneeDate);
		int year = calendar.get(Calendar.YEAR);
		campagneVo.setAnnee(Integer.toString(year));
		Campagne campagne = campagneConverter.toItem(campagneVo);
		campagne = campagneService.save(campagne);
		return campagneConverter.toVo(campagne);
	}

	@ApiOperation("Saves the specified  campagne and send email to chercheurs")
	@PostMapping("/sendEmailOuverture")
	public void sendEmailOuverture(@RequestBody CampagneVo campagneVo) {
		Campagne campagne = campagneConverter.toItem(campagneVo);
		campagneService.sendEmailOuverture(campagne);

	}

	@ApiOperation("Saves the specified  campagne and send email to chercheurs")
	@PostMapping("/sendEmailFermeture")
	public void sendEmailFermeture(@RequestBody CampagneVo campagneVo) {
		Campagne campagne = campagneConverter.toItem(campagneVo);
		campagneService.sendEmailFermeture(campagne);

	}

	@ApiOperation("Delete the specified campagne")
	@DeleteMapping("/")
	public int delete(@RequestBody CampagneVo campagneVo) {
		Campagne campagne = campagneConverter.toItem(campagneVo);
		return campagneService.delete(campagne);
	}

	@ApiOperation("Deletes a campagne by id")
	@DeleteMapping("/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return campagneService.deleteById(id);
	}

	@ApiOperation("Check overlapping depart date")
	@PostMapping("/checkOverlappingDepartDate")
	public boolean checkOverlappingDepartDate(@RequestBody CampagneVo campagneVo) {
		Campagne campagne = campagneConverter.toItem(campagneVo);
		return campagneService.checkOverlappingDepartDate(campagne);
	}

	@ApiOperation("Check overlapping fin date")
	@PostMapping("/checkOverlappingFinDate")
	public boolean checkOverlappingFinDate(@RequestBody CampagneVo campagneVo) {
		Campagne campagne = campagneConverter.toItem(campagneVo);
		return campagneService.checkOverlappingFinDate(campagne);
	}

	@ApiOperation("Check overlapping edited fin date")
	@PostMapping("/checkOverlappingEditFinDate")
	public boolean checkOverlappingEditFinDate(@RequestBody CampagneVo campagneVo) {
		System.out.println("checkOverlappingEditFinDate");
		Campagne campagne = campagneConverter.toItem(campagneVo);
		return campagneService.checkOverlappingEditFinDate(campagne);
	}

	@ApiOperation("Search campagneChercheur by a specific chercheur and code ")
	@GetMapping("/searchByChercheurUsername/{username}")
	public CampagneVo findProgressCampagneByChercheurUsername(@PathVariable String username) {
		return campagneConverter.toVo(campagneService.findProgressCampagneByChercheurUsername(username));
	}

	@ApiOperation("Check overlapping edit depart date")
	@PostMapping("/checkOverlappingEditDepartDate")
	public boolean checkOverlappingEditDepartDate(@RequestBody CampagneVo campagneVo) {
		Campagne campagne = campagneConverter.toItem(campagneVo);
		return campagneService.checkOverlappingEditDepartDate(campagne);
	}

}
