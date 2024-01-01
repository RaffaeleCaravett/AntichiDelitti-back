package com.example.antichidelitti.luogo;

import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.payloads.entities.LuogoDTO;
import com.example.antichidelitti.payloads.entities.TagDTO;
import com.example.antichidelitti.tag.Tag;
import com.example.antichidelitti.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/luogo")
public class LuogoController {
    @Autowired
    LuogoService luogoService;
    @GetMapping("")
    public List<Luogo> findAll(){
        return luogoService.getAll();
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void save(LuogoDTO body){
        luogoService.save(body);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Luogo findByIdAndUpdate(@PathVariable int id, @RequestBody LuogoDTO body) throws NotFoundException {
        return luogoService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id) throws NotFoundException {
        luogoService.findByIdAndDelete(id);
    }
}
