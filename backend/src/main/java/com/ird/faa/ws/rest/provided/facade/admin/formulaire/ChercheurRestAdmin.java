package main.java.com.ird.faa.ws.rest.provided.facade.admin.formulaire;

import com.ird.faa.service.admin.facade.formulaire.ChercheurAdminService;
import com.ird.faa.service.admin.facade.formulaire.ChercheursImportService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.ird.faa.bean.formulaire.Chercheur;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.CampagneConverter;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.ChercheurConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.ChercheurVo;

@Api("Manages chercheur services")
@RestController
@RequestMapping("api/admin/chercheur")
public class ChercheurRestAdmin {

	@Autowired
	private ChercheurAdminService chercheurService;

	@Autowired
	private ChercheurConverter chercheurConverter;
	
	@Autowired
    private CampagneConverter campagneConverter;
	@Autowired
	private ChercheursImportService chercheursImportService;

	private boolean isContains;


	@ApiOperation("Updates the specified  chercheur")
	@PutMapping("/")
	public ChercheurVo update(@RequestBody ChercheurVo chercheurVo) {
		Chercheur chercheur = chercheurConverter.toItem(chercheurVo);
		chercheur = chercheurService.update(chercheur);
		return chercheurConverter.toVo(chercheur);
	}

	@ApiOperation("Finds a list of all chercheurs")
	@GetMapping("/")
	public List<ChercheurVo> findAll() {
		return chercheurConverter.toVo(chercheurService.findAll());
	}

	@ApiOperation("Finds a chercheur with associated lists by id")
	@GetMapping("/detail/id/{id}")
	public ChercheurVo findByIdWithAssociatedList(@PathVariable Long id) {
		return chercheurConverter.toVo(chercheurService.findByIdWithAssociatedList(id));
	}

	@ApiOperation("Search chercheur by a specific criteria")
	@PostMapping("/search")
	public List<ChercheurVo> findByCriteria(@RequestBody ChercheurVo chercheurVo) {
		return chercheurConverter.toVo(chercheurService.findByCriteria(chercheurVo));
	}

	@ApiOperation("Finds a chercheur by id")
	@GetMapping("/id/{id}")
	public ChercheurVo findById(@PathVariable Long id) {
		return chercheurConverter.toVo(chercheurService.findById(id));
	}

	@ApiOperation("Saves the specified  chercheur")
	@PostMapping("/")
	public ChercheurVo save(@RequestBody ChercheurVo chercheurVo) {
		Chercheur chercheur = chercheurConverter.toItem(chercheurVo);
		chercheur = chercheurService.save(chercheur);
		return chercheurConverter.toVo(chercheur);
	}

	@ApiOperation("Delete the specified chercheur")
	@DeleteMapping("/")
	public int delete(@RequestBody ChercheurVo chercheurVo) {
		Chercheur chercheur = chercheurConverter.toItem(chercheurVo);
		return chercheurService.delete(chercheur);
	}

	@ApiOperation("Deletes a chercheur by id")
	@DeleteMapping("/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return chercheurService.deleteById(id);
	}

	@ApiOperation("Search chercheur by a specific campagne")
	@GetMapping("/findByCampagne/id/{id}")
	public List<ChercheurVo> findByCampagneId(@PathVariable Long id) {
		return chercheurConverter.toVo(chercheurService.findByCampagneId(id));
	}
	
	
	
	

	@ApiOperation("Search chercheur by a specific campagne")
	@GetMapping("/findAvailableChercheurs/id/{id}")
	public List<ChercheurVo> findByCampagne(@PathVariable Long id) {
		List<ChercheurVo> chercheursVo = findAll();
		List<ChercheurVo> selectedChercheursVo = findByCampagneId(id);
		List<ChercheurVo> availableChercheursVo = new ArrayList<>();
		if(chercheursVo!=null) {
			if(selectedChercheursVo!=null) {
				if(chercheursVo!=null) {
					chercheursVo.forEach(chercheur -> {
						if(!checkContains(chercheur,selectedChercheursVo)) {
							availableChercheursVo.add(chercheur);
						}
					});
					
				}
				
			}
			else {
				availableChercheursVo.addAll(chercheursVo);
			}
			
		}
		
		return availableChercheursVo;
	}
	
	private boolean checkContains( ChercheurVo  chercheur, List<ChercheurVo> selectedChercheursVo) {
		this.isContains=false;
		selectedChercheursVo.forEach(selectChercheur -> {
			if(chercheur.getId().equals(selectChercheur.getId())) {
				this.isContains=true;
			}
			
		});
		return this.isContains;
	}
            
    @GetMapping("/chercheurs-import")
    public Map<String,Object> getChercheurs() {
        return chercheursImportService.updateOrAddChercheur(); 
    }

}
