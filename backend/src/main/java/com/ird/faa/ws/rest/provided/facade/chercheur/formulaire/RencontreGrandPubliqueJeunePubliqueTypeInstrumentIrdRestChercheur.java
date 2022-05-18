package main.java.com.ird.faa.ws.rest.provided.facade.chercheur.formulaire;

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

import com.ird.faa.bean.formulaire.RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd;
import com.ird.faa.service.chercheur.facade.formulaire.RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdChercheurService;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Manages rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd services")
@RestController
@RequestMapping("api/chercheur/rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd")
public class RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdRestChercheur {

@Autowired
private RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdChercheurService rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdService;

@Autowired
private RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdConverter rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdConverter;


@ApiOperation("Updates the specified  rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd")
            @PutMapping("/")
public RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo update(
		@RequestBody RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo) {
	RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd = rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdConverter
			.toItem(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo);
	rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd = rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdService
			.update(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd);
	return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdConverter
			.toVo(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd);
            }

@ApiOperation("Finds a list of all rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrds")
    @GetMapping("/")
public List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo> findAll() {
	return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdConverter
			.toVo(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdService.findAll());
    }

@ApiOperation("Finds a rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd with associated lists by id")
    @GetMapping("/detail/id/{id}")
public RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo findByIdWithAssociatedList(@PathVariable Long id) {
	return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdConverter
			.toVo(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdService.findByIdWithAssociatedList(id));
    }

@ApiOperation("Search rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd by a specific criteria")
    @PostMapping("/search")
public List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo> findByCriteria(
		@RequestBody RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo) {
	return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdConverter
			.toVo(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdService
					.findByCriteria(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo));
        }

@ApiOperation("Finds a rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd by id")
            @GetMapping("/id/{id}")
public RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo findById(@PathVariable Long id) {
	return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdConverter
			.toVo(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdService.findById(id));
            }

@ApiOperation("Saves the specified  rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd")
            @PostMapping("/")
public RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo save(
		@RequestBody RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo) {
	RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd = rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdConverter
			.toItem(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo);
	rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd = rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdService
			.save(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd);
	return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdConverter
			.toVo(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd);
            }

@ApiOperation("Delete the specified rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd")
            @DeleteMapping("/")
public int delete(
		@RequestBody RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo) {
	RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd = rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdConverter
			.toItem(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo);
	return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdService
			.delete(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd);
            }

@ApiOperation("Deletes a rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
				return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdService.deleteById(id);
            }

			@ApiOperation("find by TypeInstrumentIrd code")
			@GetMapping("/TypeInstrumentIrd/code/{code}")
			public List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> findByTypeInstrumentIrdCode(
					@PathVariable String code) {
				return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdService.findByTypeInstrumentIrdCode(code);
        }

			@ApiOperation("delete by TypeInstrumentIrd code")
			@DeleteMapping("/TypeInstrumentIrd/code/{code}")
			public int deleteByTypeInstrumentIrdCode(@PathVariable String code) {
				return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdService.deleteByTypeInstrumentIrdCode(code);
        }

			@ApiOperation("find by TypeInstrumentIrd id")
			@GetMapping("/TypeInstrumentIrd/id/{id}")
			public List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> findByTypeInstrumentIrdId(
					@PathVariable Long id) {
				return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdService.findByTypeInstrumentIrdId(id);
        }

			@ApiOperation("delete by TypeInstrumentIrd id")
			@DeleteMapping("/TypeInstrumentIrd/id/{id}")
			public int deleteByTypeInstrumentIrdId(@PathVariable Long id) {
				return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdService.deleteByTypeInstrumentIrdId(id);
        }

        @ApiOperation("find by rencontreGrandPubliqueJeunePublique id")
        @GetMapping("/rencontreGrandPubliqueJeunePublique/id/{id}")
		public List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> findByRencontreGrandPubliqueJeunePubliqueId(
				@PathVariable Long id) {
			return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdService
					.findByRencontreGrandPubliqueJeunePubliqueId(id);
        }

        @ApiOperation("delete by rencontreGrandPubliqueJeunePublique id")
        @DeleteMapping("/rencontreGrandPubliqueJeunePublique/id/{id}")
        public int deleteByRencontreGrandPubliqueJeunePubliqueId(@PathVariable Long id){
			return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdService
					.deleteByRencontreGrandPubliqueJeunePubliqueId(id);
        }



            }
