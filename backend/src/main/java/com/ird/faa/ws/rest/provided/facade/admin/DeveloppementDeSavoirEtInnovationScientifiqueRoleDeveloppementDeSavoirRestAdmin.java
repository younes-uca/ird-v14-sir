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

import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueRole;
import com.ird.faa.service.admin.facade.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueRoleAdminService;
import com.ird.faa.ws.rest.provided.converter.DeveloppementDeSavoirEtInnovationScientifiqueRoleConverter;
import com.ird.faa.ws.rest.provided.vo.DeveloppementDeSavoirEtInnovationScientifiqueRoleVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Manages developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir services")
@RestController
@RequestMapping("api/admin/developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir")
public class DeveloppementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirRestAdmin {

	@Autowired
	private DeveloppementDeSavoirEtInnovationScientifiqueRoleAdminService developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirService;

	@Autowired
	private DeveloppementDeSavoirEtInnovationScientifiqueRoleConverter developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirConverter;

	@ApiOperation("Updates the specified  developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir")
	@PutMapping("/")
	public DeveloppementDeSavoirEtInnovationScientifiqueRoleVo update(
			@RequestBody DeveloppementDeSavoirEtInnovationScientifiqueRoleVo developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirVo) {
		DeveloppementDeSavoirEtInnovationScientifiqueRole developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir = developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirConverter
				.toItem(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirVo);
		developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir = developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirService
				.update(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir);
		return developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir);
	}

	@ApiOperation("Finds a list of all developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirs")
	@GetMapping("/")
	public List<DeveloppementDeSavoirEtInnovationScientifiqueRoleVo> findAll() {
		return developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirService.findAll());
	}

	@ApiOperation("Finds a developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir with associated lists by id")
	@GetMapping("/detail/id/{id}")
	public DeveloppementDeSavoirEtInnovationScientifiqueRoleVo findByIdWithAssociatedList(
			@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirService.findByIdWithAssociatedList(id));
	}

	@ApiOperation("Search developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir by a specific criteria")
	@PostMapping("/search")
	public List<DeveloppementDeSavoirEtInnovationScientifiqueRoleVo> findByCriteria(
			@RequestBody DeveloppementDeSavoirEtInnovationScientifiqueRoleVo developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirVo) {
		return developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirService
						.findByCriteria(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirVo));
	}

	@ApiOperation("Finds a developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir by id")
	@GetMapping("/id/{id}")
	public DeveloppementDeSavoirEtInnovationScientifiqueRoleVo findById(@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirService.findById(id));
	}

	@ApiOperation("Saves the specified  developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir")
	@PostMapping("/")
	public DeveloppementDeSavoirEtInnovationScientifiqueRoleVo save(
			@RequestBody DeveloppementDeSavoirEtInnovationScientifiqueRoleVo developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirVo) {
		DeveloppementDeSavoirEtInnovationScientifiqueRole developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir = developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirConverter
				.toItem(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirVo);
		developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir = developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirService
				.save(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir);
		return developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir);
	}

	@ApiOperation("Delete the specified developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir")
	@DeleteMapping("/")
	public int delete(
			@RequestBody DeveloppementDeSavoirEtInnovationScientifiqueRoleVo developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirVo) {
		DeveloppementDeSavoirEtInnovationScientifiqueRole developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir = developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirConverter
				.toItem(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirVo);
		return developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirService
				.delete(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir);
	}

	@ApiOperation("Deletes a developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir by id")
	@DeleteMapping("/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirService.deleteById(id);
	}

	@ApiOperation("find by etablissement code")
	@GetMapping("/etablissement/code/{code}")
	public List<DeveloppementDeSavoirEtInnovationScientifiqueRole> findByRoleDeveloppementDeSavoirCode(
			@PathVariable String code) {
		return developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirService.findByRoleDeveloppementDeSavoirCode(code);
	}

	@ApiOperation("delete by etablissement code")
	@DeleteMapping("/etablissement/code/{code}")
	public int deleteByRoleDeveloppementDeSavoirCode(@PathVariable String code) {
		return developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirService.deleteByRoleDeveloppementDeSavoirCode(code);
	}

	@ApiOperation("find by etablissement id")
	@GetMapping("/etablissement/id/{id}")
	public List<DeveloppementDeSavoirEtInnovationScientifiqueRole> findByRoleDeveloppementDeSavoirId(
			@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirService.findByRoleDeveloppementDeSavoirId(id);
	}

	@ApiOperation("delete by etablissement id")
	@DeleteMapping("/etablissement/id/{id}")
	public int deleteByRoleDeveloppementDeSavoirId(@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirService.deleteByRoleDeveloppementDeSavoirId(id);
	}

	@ApiOperation("find by developpementDeSavoirEtInnovationScientifique id")
	@GetMapping("/developpementDeSavoirEtInnovationScientifique/id/{id}")
	public List<DeveloppementDeSavoirEtInnovationScientifiqueRole> findByDeveloppementDeSavoirEtInnovationScientifiqueId(
			@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirService
				.findByDeveloppementDeSavoirEtInnovationScientifiqueId(id);
	}

	@ApiOperation("delete by developpementDeSavoirEtInnovationScientifique id")
	@DeleteMapping("/developpementDeSavoirEtInnovationScientifique/id/{id}")
	public int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirService
				.deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(id);
	}

}
