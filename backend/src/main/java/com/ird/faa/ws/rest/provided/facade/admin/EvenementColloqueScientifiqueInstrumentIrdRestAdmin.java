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

import com.ird.faa.bean.formulaire.EvenementColloqueScientifiqueInstrumentIrd;
import com.ird.faa.service.admin.facade.formulaire.EvenementColloqueScientifiqueInstrumentIrdAdminService;
import com.ird.faa.ws.rest.provided.converter.EvenementColloqueScientifiqueInstrumentIrdConverter;
import com.ird.faa.ws.rest.provided.vo.EvenementColloqueScientifiqueInstrumentIrdVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Manages instrumentIrdEvenementColloqueScientifique services")
@RestController
@RequestMapping("api/admin/instrumentIrdEvenementColloqueScientifique")
public class EvenementColloqueScientifiqueInstrumentIrdRestAdmin {

	@Autowired
	private EvenementColloqueScientifiqueInstrumentIrdAdminService instrumentIrdEvenementColloqueScientifiqueService;

	@Autowired
	private EvenementColloqueScientifiqueInstrumentIrdConverter instrumentIrdEvenementColloqueScientifiqueConverter;

	@ApiOperation("Updates the specified  instrumentIrdEvenementColloqueScientifique")
	@PutMapping("/")
	public EvenementColloqueScientifiqueInstrumentIrdVo update(
			@RequestBody EvenementColloqueScientifiqueInstrumentIrdVo instrumentIrdEvenementColloqueScientifiqueVo) {
		EvenementColloqueScientifiqueInstrumentIrd instrumentIrdEvenementColloqueScientifique = instrumentIrdEvenementColloqueScientifiqueConverter
				.toItem(instrumentIrdEvenementColloqueScientifiqueVo);
		instrumentIrdEvenementColloqueScientifique = instrumentIrdEvenementColloqueScientifiqueService
				.update(instrumentIrdEvenementColloqueScientifique);
		return instrumentIrdEvenementColloqueScientifiqueConverter
				.toVo(instrumentIrdEvenementColloqueScientifique);
	}

	@ApiOperation("Finds a list of all instrumentIrdEvenementColloqueScientifiques")
	@GetMapping("/")
	public List<EvenementColloqueScientifiqueInstrumentIrdVo> findAll() {
		return instrumentIrdEvenementColloqueScientifiqueConverter
				.toVo(instrumentIrdEvenementColloqueScientifiqueService.findAll());
	}

	@ApiOperation("Finds a instrumentIrdEvenementColloqueScientifique with associated lists by id")
	@GetMapping("/detail/id/{id}")
	public EvenementColloqueScientifiqueInstrumentIrdVo findByIdWithAssociatedList(@PathVariable Long id) {
		return instrumentIrdEvenementColloqueScientifiqueConverter
				.toVo(instrumentIrdEvenementColloqueScientifiqueService.findByIdWithAssociatedList(id));
	}

	@ApiOperation("Search instrumentIrdEvenementColloqueScientifique by a specific criteria")
	@PostMapping("/search")
	public List<EvenementColloqueScientifiqueInstrumentIrdVo> findByCriteria(
			@RequestBody EvenementColloqueScientifiqueInstrumentIrdVo instrumentIrdEvenementColloqueScientifiqueVo) {
		return instrumentIrdEvenementColloqueScientifiqueConverter
				.toVo(instrumentIrdEvenementColloqueScientifiqueService
						.findByCriteria(instrumentIrdEvenementColloqueScientifiqueVo));
	}

	@ApiOperation("Finds a instrumentIrdEvenementColloqueScientifique by id")
	@GetMapping("/id/{id}")
	public EvenementColloqueScientifiqueInstrumentIrdVo findById(@PathVariable Long id) {
		return instrumentIrdEvenementColloqueScientifiqueConverter
				.toVo(instrumentIrdEvenementColloqueScientifiqueService.findById(id));
	}

	@ApiOperation("Saves the specified  instrumentIrdEvenementColloqueScientifique")
	@PostMapping("/")
	public EvenementColloqueScientifiqueInstrumentIrdVo save(
			@RequestBody EvenementColloqueScientifiqueInstrumentIrdVo instrumentIrdEvenementColloqueScientifiqueVo) {
		EvenementColloqueScientifiqueInstrumentIrd instrumentIrdEvenementColloqueScientifique = instrumentIrdEvenementColloqueScientifiqueConverter
				.toItem(instrumentIrdEvenementColloqueScientifiqueVo);
		instrumentIrdEvenementColloqueScientifique = instrumentIrdEvenementColloqueScientifiqueService
				.save(instrumentIrdEvenementColloqueScientifique);
		return instrumentIrdEvenementColloqueScientifiqueConverter
				.toVo(instrumentIrdEvenementColloqueScientifique);
	}

	@ApiOperation("Delete the specified instrumentIrdEvenementColloqueScientifique")
	@DeleteMapping("/")
	public int delete(
			@RequestBody EvenementColloqueScientifiqueInstrumentIrdVo instrumentIrdEvenementColloqueScientifiqueVo) {
		EvenementColloqueScientifiqueInstrumentIrd instrumentIrdEvenementColloqueScientifique = instrumentIrdEvenementColloqueScientifiqueConverter
				.toItem(instrumentIrdEvenementColloqueScientifiqueVo);
		return instrumentIrdEvenementColloqueScientifiqueService
				.delete(instrumentIrdEvenementColloqueScientifique);
	}

	@ApiOperation("Deletes a instrumentIrdEvenementColloqueScientifique by id")
	@DeleteMapping("/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return instrumentIrdEvenementColloqueScientifiqueService.deleteById(id);
	}

	@ApiOperation("find by evenementColloqueScienntifique id")
	@GetMapping("/evenementColloqueScienntifique/id/{id}")
	public List<EvenementColloqueScientifiqueInstrumentIrd> findByEvenementColloqueScienntifiqueId(
			@PathVariable Long id) {
		return instrumentIrdEvenementColloqueScientifiqueService.findByEvenementColloqueScienntifiqueId(id);
	}

	@ApiOperation("delete by evenementColloqueScienntifique id")
	@DeleteMapping("/evenementColloqueScienntifique/id/{id}")
	public int deleteByEvenementColloqueScienntifiqueId(@PathVariable Long id) {
		return instrumentIrdEvenementColloqueScientifiqueService.deleteByEvenementColloqueScienntifiqueId(id);
	}

	@ApiOperation("find by instrumentIrd code")
	@GetMapping("/instrumentIrd/code/{code}")
	public List<EvenementColloqueScientifiqueInstrumentIrd> findByInstrumentIrdCode(@PathVariable String code) {
		return instrumentIrdEvenementColloqueScientifiqueService.findByInstrumentIrdCode(code);
	}

	@ApiOperation("delete by instrumentIrd code")
	@DeleteMapping("/instrumentIrd/code/{code}")
	public int deleteByInstrumentIrdCode(@PathVariable String code) {
		return instrumentIrdEvenementColloqueScientifiqueService.deleteByInstrumentIrdCode(code);
	}

	@ApiOperation("find by instrumentIrd id")
	@GetMapping("/instrumentIrd/id/{id}")
	public List<EvenementColloqueScientifiqueInstrumentIrd> findByInstrumentIrdId(@PathVariable Long id) {
		return instrumentIrdEvenementColloqueScientifiqueService.findByInstrumentIrdId(id);
	}

	@ApiOperation("delete by instrumentIrd id")
	@DeleteMapping("/instrumentIrd/id/{id}")
	public int deleteByInstrumentIrdId(@PathVariable Long id) {
		return instrumentIrdEvenementColloqueScientifiqueService.deleteByInstrumentIrdId(id);
	}

}
