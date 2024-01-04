package com.example.antichidelitti.articolo;

import com.example.antichidelitti.bozza.Bozza;
import com.example.antichidelitti.bozza.BozzaService;
import com.example.antichidelitti.exception.BadRequestException;
import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.payloads.entities.ArticoloDTO;
import com.example.antichidelitti.payloads.entities.BozzaDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Articolo> findAll(){
        return articoloService.getAll();
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
}
