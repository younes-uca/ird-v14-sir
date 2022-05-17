package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.formulaire.DoctorantAdminService;

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
import com.ird.faa.bean.formulaire.Doctorant;
import com.ird.faa.ws.rest.provided.converter.DoctorantConverter;
import com.ird.faa.ws.rest.provided.vo.DoctorantVo;

@Api("Manages doctorant services")
@RestController
@RequestMapping("api/admin/doctorant")
public class DoctorantRestAdmin {

@Autowired
private DoctorantAdminService doctorantService;

@Autowired
private DoctorantConverter doctorantConverter;


            @ApiOperation("Updates the specified  doctorant")
            @PutMapping("/")
            public  DoctorantVo update(@RequestBody  DoctorantVo  doctorantVo){
            Doctorant doctorant = doctorantConverter.toItem(doctorantVo);
            doctorant = doctorantService.update(doctorant);
            return doctorantConverter.toVo(doctorant);
            }

    @ApiOperation("Finds a list of all doctorants")
    @GetMapping("/")
    public List<DoctorantVo> findAll(){
        return doctorantConverter.toVo(doctorantService.findAll());
    }

    @ApiOperation("Finds a doctorant with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DoctorantVo findByIdWithAssociatedList(@PathVariable Long id){
    return doctorantConverter.toVo(doctorantService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search doctorant by a specific criteria")
    @PostMapping("/search")
    public List<DoctorantVo> findByCriteria(@RequestBody DoctorantVo doctorantVo){
        return doctorantConverter.toVo(doctorantService.findByCriteria(doctorantVo));
        }

            @ApiOperation("Finds a doctorant by id")
            @GetMapping("/id/{id}")
            public DoctorantVo findById(@PathVariable Long id){
            return doctorantConverter.toVo(doctorantService.findById(id));
            }

            @ApiOperation("Saves the specified  doctorant")
            @PostMapping("/")
            public DoctorantVo save(@RequestBody DoctorantVo doctorantVo){
            Doctorant doctorant = doctorantConverter.toItem(doctorantVo);
            doctorant = doctorantService.save(doctorant);
            return doctorantConverter.toVo(doctorant);
            }

            @ApiOperation("Delete the specified doctorant")
            @DeleteMapping("/")
            public int delete(@RequestBody DoctorantVo doctorantVo){
            Doctorant doctorant = doctorantConverter.toItem(doctorantVo);
            return doctorantService.delete(doctorant);
            }

            @ApiOperation("Deletes a doctorant by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return doctorantService.deleteById(id);
            }


        }
