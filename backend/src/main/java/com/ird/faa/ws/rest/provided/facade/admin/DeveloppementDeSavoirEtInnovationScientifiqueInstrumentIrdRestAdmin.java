package com.ird.faa.ws.rest.provided.facade.admin;

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

import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd;
import com.ird.faa.service.admin.facade.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdAdminService;
import com.ird.faa.ws.rest.provided.converter.DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdConverter;
import com.ird.faa.ws.rest.provided.vo.DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Manages developpementDeSavoirEtInnovationScientifiqueInstrumentIrd services")
@RestController
@RequestMapping("api/admin/developpementDeSavoirEtInnovationScientifiqueInstrumentIrd")
public class DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdRestAdmin {

	@Autowired
	private DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdAdminService developpementDeSavoirEtInnovationScientifiqueInstrumentIrdService;

	@Autowired
	private DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdConverter developpementDeSavoirEtInnovationScientifiqueInstrumentIrdConverter;

	@ApiOperation("Updates the specified  developpementDeSavoirEtInnovationScientifiqueInstrumentIrd")
	@PutMapping("/")
	public DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo update(
			@RequestBody DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo developpementDeSavoirEtInnovationScientifiqueInstrumentIrdVo) {
		DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd developpementDeSavoirEtInnovationScientifiqueInstrumentIrd = developpementDeSavoirEtInnovationScientifiqueInstrumentIrdConverter
				.toItem(developpementDeSavoirEtInnovationScientifiqueInstrumentIrdVo);
		developpementDeSavoirEtInnovationScientifiqueInstrumentIrd = developpementDeSavoirEtInnovationScientifiqueInstrumentIrdService
				.update(developpementDeSavoirEtInnovationScientifiqueInstrumentIrd);
		return developpementDeSavoirEtInnovationScientifiqueInstrumentIrdConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueInstrumentIrd);
	}

	@ApiOperation("Finds a list of all developpementDeSavoirEtInnovationScientifiqueInstrumentIrds")
	@GetMapping("/")
	public List<DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo> findAll() {
		return developpementDeSavoirEtInnovationScientifiqueInstrumentIrdConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueInstrumentIrdService.findAll());
	}

	@ApiOperation("Finds a developpementDeSavoirEtInnovationScientifiqueInstrumentIrd with associated lists by id")
	@GetMapping("/detail/id/{id}")
	public DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo findByIdWithAssociatedList(
			@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueInstrumentIrdConverter.toVo(
				developpementDeSavoirEtInnovationScientifiqueInstrumentIrdService.findByIdWithAssociatedList(id));
	}

	@ApiOperation("Search developpementDeSavoirEtInnovationScientifiqueInstrumentIrd by a specific criteria")
	@PostMapping("/search")
	public List<DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo> findByCriteria(
			@RequestBody DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo developpementDeSavoirEtInnovationScientifiqueInstrumentIrdVo) {
		return developpementDeSavoirEtInnovationScientifiqueInstrumentIrdConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueInstrumentIrdService
						.findByCriteria(developpementDeSavoirEtInnovationScientifiqueInstrumentIrdVo));
	}

	@ApiOperation("Finds a developpementDeSavoirEtInnovationScientifiqueInstrumentIrd by id")
	@GetMapping("/id/{id}")
	public DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo findById(@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueInstrumentIrdConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueInstrumentIrdService.findById(id));
	}

	@ApiOperation("Saves the specified  developpementDeSavoirEtInnovationScientifiqueInstrumentIrd")
	@PostMapping("/")
	public DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo save(
			@RequestBody DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo developpementDeSavoirEtInnovationScientifiqueInstrumentIrdVo) {
		DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd developpementDeSavoirEtInnovationScientifiqueInstrumentIrd = developpementDeSavoirEtInnovationScientifiqueInstrumentIrdConverter
				.toItem(developpementDeSavoirEtInnovationScientifiqueInstrumentIrdVo);
		developpementDeSavoirEtInnovationScientifiqueInstrumentIrd = developpementDeSavoirEtInnovationScientifiqueInstrumentIrdService
				.save(developpementDeSavoirEtInnovationScientifiqueInstrumentIrd);
		return developpementDeSavoirEtInnovationScientifiqueInstrumentIrdConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueInstrumentIrd);
	}

	@ApiOperation("Delete the specified developpementDeSavoirEtInnovationScientifiqueInstrumentIrd")
	@DeleteMapping("/")
	public int delete(
			@RequestBody DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo developpementDeSavoirEtInnovationScientifiqueInstrumentIrdVo) {
		DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd developpementDeSavoirEtInnovationScientifiqueInstrumentIrd = developpementDeSavoirEtInnovationScientifiqueInstrumentIrdConverter
				.toItem(developpementDeSavoirEtInnovationScientifiqueInstrumentIrdVo);
		return developpementDeSavoirEtInnovationScientifiqueInstrumentIrdService
				.delete(developpementDeSavoirEtInnovationScientifiqueInstrumentIrd);
	}

	@ApiOperation("Deletes a developpementDeSavoirEtInnovationScientifiqueInstrumentIrd by id")
	@DeleteMapping("/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueInstrumentIrdService.deleteById(id);
	}

	@ApiOperation("find by instrumentIrd code")
	@GetMapping("/instrumentIrd/code/{code}")
	public List<DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd> findByInstrumentIrdCode(
			@PathVariable String code) {
		return developpementDeSavoirEtInnovationScientifiqueInstrumentIrdService.findByInstrumentIrdCode(code);
	}

	@ApiOperation("delete by instrumentIrd code")
	@DeleteMapping("/instrumentIrd/code/{code}")
	public int deleteByInstrumentIrdCode(@PathVariable String code) {
		return developpementDeSavoirEtInnovationScientifiqueInstrumentIrdService.deleteByInstrumentIrdCode(code);
	}

	@ApiOperation("find by instrumentIrd id")
	@GetMapping("/instrumentIrd/id/{id}")
	public List<DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd> findByInstrumentIrdId(
			@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueInstrumentIrdService.findByInstrumentIrdId(id);
	}

	@ApiOperation("delete by instrumentIrd id")
	@DeleteMapping("/instrumentIrd/id/{id}")
	public int deleteByInstrumentIrdId(@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueInstrumentIrdService.deleteByInstrumentIrdId(id);
	}

	@ApiOperation("find by developpementDeSavoirEtInnovationScientifique id")
	@GetMapping("/developpementDeSavoirEtInnovationScientifique/id/{id}")
	public List<DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd> findByDeveloppementDeSavoirEtInnovationScientifiqueId(
			@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueInstrumentIrdService
				.findByDeveloppementDeSavoirEtInnovationScientifiqueId(id);
	}

	@ApiOperation("delete by developpementDeSavoirEtInnovationScientifique id")
	@DeleteMapping("/developpementDeSavoirEtInnovationScientifique/id/{id}")
	public int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueInstrumentIrdService
				.deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(id);
	}

}
