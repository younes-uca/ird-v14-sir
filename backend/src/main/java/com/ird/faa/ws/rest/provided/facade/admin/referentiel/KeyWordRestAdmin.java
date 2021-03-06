package main.java.com.ird.faa.ws.rest.provided.facade.admin.referentiel;

import com.ird.faa.bean.referentiel.KeyWord;
import com.ird.faa.service.admin.facade.formulaire.KeyWordAdminService;
import main.java.com.ird.faa.ws.rest.provided.converter.referentiel.KeyWordConverter;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.KeyWordVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages keyWord services")
@RestController
@RequestMapping("api/admin/keyWord")
public class KeyWordRestAdmin {

@Autowired
private KeyWordAdminService keyWordService;

@Autowired
private KeyWordConverter keyWordConverter;


            @ApiOperation("Updates the specified  keyWord")
            @PutMapping("/")
            public  KeyWordVo update(@RequestBody  KeyWordVo  keyWordVo){
            KeyWord keyWord = keyWordConverter.toItem(keyWordVo);
            keyWord = keyWordService.update(keyWord);
            return keyWordConverter.toVo(keyWord);
            }

    @ApiOperation("Finds a list of all keyWords")
    @GetMapping("/")
    public List<KeyWordVo> findAll(){
        return keyWordConverter.toVo(keyWordService.findAll());
    }

    @ApiOperation("Finds a keyWord with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public KeyWordVo findByIdWithAssociatedList(@PathVariable Long id){
    return keyWordConverter.toVo(keyWordService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search keyWord by a specific criteria")
    @PostMapping("/search")
    public List<KeyWordVo> findByCriteria(@RequestBody KeyWordVo keyWordVo){
        return keyWordConverter.toVo(keyWordService.findByCriteria(keyWordVo));
        }

            @ApiOperation("Finds a keyWord by id")
            @GetMapping("/id/{id}")
            public KeyWordVo findById(@PathVariable Long id){
            return keyWordConverter.toVo(keyWordService.findById(id));
            }

            @ApiOperation("Saves the specified  keyWord")
            @PostMapping("/")
            public KeyWordVo save(@RequestBody KeyWordVo keyWordVo){
            KeyWord keyWord = keyWordConverter.toItem(keyWordVo);
            keyWord = keyWordService.save(keyWord);
            return keyWordConverter.toVo(keyWord);
            }

            @ApiOperation("Delete the specified keyWord")
            @DeleteMapping("/")
            public int delete(@RequestBody KeyWordVo keyWordVo){
            KeyWord keyWord = keyWordConverter.toItem(keyWordVo);
            return keyWordService.delete(keyWord);
            }

            @ApiOperation("Deletes a keyWord by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return keyWordService.deleteById(id);
            }




            @PutMapping("/archiver/")
            public KeyWordVo archiver(@RequestBody KeyWordVo keyWordVo){
                KeyWord keyWord = keyWordService.archiver(keyWordConverter.toItem(keyWordVo));
                return keyWordConverter.toVo(keyWord);
                }

            @PutMapping("/desarchiver/")
            public KeyWordVo desarchiver(@RequestBody KeyWordVo keyWordVo){
                KeyWord keyWord = keyWordService.desarchiver(keyWordConverter.toItem(keyWordVo));
                return keyWordConverter.toVo(keyWord);}
            }
