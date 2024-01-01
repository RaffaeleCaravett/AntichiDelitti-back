package com.example.antichidelitti.bozza;

import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.payloads.entities.BozzaDTO;
import com.example.antichidelitti.payloads.entities.TagDTO;
import com.example.antichidelitti.tag.Tag;
import com.example.antichidelitti.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bozza")
public class BozzaController {
    @Autowired
    BozzaService bozzaService;
    @GetMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Bozza> findAll(){
        return bozzaService.getAll();
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void save(BozzaDTO body){
        bozzaService.save();
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
