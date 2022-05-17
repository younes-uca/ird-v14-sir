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

import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique;
import com.ird.faa.service.admin.facade.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueAdminService;
import com.ird.faa.ws.rest.provided.converter.DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueConverter;
import com.ird.faa.ws.rest.provided.vo.DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Manages developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique services")
@RestController
@RequestMapping("api/admin/developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique")
public class DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueRestAdmin {

	@Autowired
	private DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueAdminService developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueService;

	@Autowired
	private DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueConverter developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueConverter;

	@ApiOperation("Updates the specified  developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique")
	@PutMapping("/")
	public DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo update(
			@RequestBody DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo) {
		DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique = developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueConverter
				.toItem(developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo);
		developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique = developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueService
				.update(developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique);
		return developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique);
	}

	@ApiOperation("Finds a list of all developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiques")
	@GetMapping("/")
	public List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo> findAll() {
		return developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueService.findAll());
	}

	@ApiOperation("Finds a developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique with associated lists by id")
	@GetMapping("/detail/id/{id}")
	public DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo findByIdWithAssociatedList(
			@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueService
						.findByIdWithAssociatedList(id));
	}

	@ApiOperation("Search developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique by a specific criteria")
	@PostMapping("/search")
	public List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo> findByCriteria(
			@RequestBody DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo) {
		return developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueService
						.findByCriteria(developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo));
	}

	@ApiOperation("Finds a developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique by id")
	@GetMapping("/id/{id}")
	public DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo findById(@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueService.findById(id));
	}

	@ApiOperation("Saves the specified  developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique")
	@PostMapping("/")
	public DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo save(
			@RequestBody DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo) {
		DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique = developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueConverter
				.toItem(developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo);
		developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique = developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueService
				.save(developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique);
		return developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueConverter
				.toVo(developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique);
	}

	@ApiOperation("Delete the specified developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique")
	@DeleteMapping("/")
	public int delete(
			@RequestBody DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo) {
		DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique = developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueConverter
				.toItem(developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo);
		return developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueService
				.delete(developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique);
	}

	@ApiOperation("Deletes a developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique by id")
	@DeleteMapping("/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueService.deleteById(id);
	}

	@ApiOperation("find by communauteSavoir code")
	@GetMapping("/communauteSavoir/code/{code}")
	public List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique> findByDisciplineScientifiqueCode(
			@PathVariable String code) {
		return developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueService
				.findByDisciplineScientifiqueCode(code);
	}

	@ApiOperation("delete by communauteSavoir code")
	@DeleteMapping("/communauteSavoir/code/{code}")
	public int deleteByDisciplineScientifiqueCode(@PathVariable String code) {
		return developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueService
				.deleteByDisciplineScientifiqueCode(code);
	}

	@ApiOperation("find by communauteSavoir id")
	@GetMapping("/communauteSavoir/id/{id}")
	public List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique> findByDisciplineScientifiqueId(
			@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueService.findByDisciplineScientifiqueId(id);
	}

	@ApiOperation("delete by communauteSavoir id")
	@DeleteMapping("/communauteSavoir/id/{id}")
	public int deleteByDisciplineScientifiqueId(@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueService
				.deleteByDisciplineScientifiqueId(id);
	}

	@ApiOperation("find by developpementDeSavoirEtInnovationScientifique id")
	@GetMapping("/developpementDeSavoirEtInnovationScientifique/id/{id}")
	public List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique> findByDeveloppementDeSavoirEtInnovationScientifiqueId(
			@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueService
				.findByDeveloppementDeSavoirEtInnovationScientifiqueId(id);
	}

	@ApiOperation("delete by developpementDeSavoirEtInnovationScientifique id")
	@DeleteMapping("/developpementDeSavoirEtInnovationScientifique/id/{id}")
	public int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(@PathVariable Long id) {
		return developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueService
				.deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(id);
	}

}
