package com.example.antichidelitti.bozza;

import com.example.antichidelitti.articolo.Articolo;
import com.example.antichidelitti.exception.BadRequestException;
import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.payloads.entities.ArticoloDTO;
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
@RequestMapping("/bozza")
public class BozzaController {
    @Autowired
    BozzaService bozzaService;
    @GetMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Page<Bozza> finAll(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "id") String orderBy){
        return bozzaService.getAll(page, size, orderBy);
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void save(@RequestBody @Validated BozzaDTO body, BindingResult validation){
        if(validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        }else{bozzaService.save(body);}
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Bozza findByIdAndUpdate(@PathVariable int id, @RequestBody BozzaDTO body) throws NotFoundException {
        return bozzaService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id) throws NotFoundException {
        bozzaService.findByIdAndDelete(id);
    }
}
