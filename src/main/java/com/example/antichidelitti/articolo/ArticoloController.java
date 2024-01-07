package com.example.antichidelitti.articolo;

import com.example.antichidelitti.bozza.Bozza;
import com.example.antichidelitti.bozza.BozzaService;
import com.example.antichidelitti.exception.BadRequestException;
import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.payloads.entities.ArticoloDTO;
import com.example.antichidelitti.payloads.entities.ArticoloFilterDTO;
import com.example.antichidelitti.payloads.entities.BozzaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articolo")
public class ArticoloController {
    @Autowired
    ArticoloService articoloService;
    @GetMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Page<Articolo> getArticles(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "id") String orderBy){
        return articoloService.getAll(page, size, orderBy);
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void save(@RequestBody @Validated ArticoloDTO body, BindingResult validation){
        if(validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        }else{
            System.out.println(body);
            articoloService.save(body);
        }
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Articolo findByIdAndUpdate(@PathVariable int id, @RequestBody ArticoloDTO body) throws NotFoundException {
        return articoloService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id) throws NotFoundException {
        articoloService.findByIdAndDelete(id);
    }
    @GetMapping("/filtered")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Articolo> getArticlesFiltered(@RequestBody ArticoloFilterDTO articoloFilterDTO){
        return articoloService.getAllFiltered(articoloFilterDTO);
    }
}
