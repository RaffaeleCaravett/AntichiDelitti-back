package com.example.antichidelitti.tema;

import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.payloads.entities.TemaDTO;
import com.example.antichidelitti.payloads.entities.UserRegistrationDTO;
import com.example.antichidelitti.user.User;
import com.example.antichidelitti.visita.Visita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tema")
public class TemaController {

    @Autowired
    TemaService temaService;
    @GetMapping("")
    public List<Tema> findAll(){
        return temaService.getAll();
    }

    @PostMapping("")
    public void save(Object body){
        temaService.save();
    }

    @PutMapping("/{id}")
    public Tema findByIdAndUpdate(@PathVariable int id, @RequestBody TemaDTO body) throws NotFoundException {
        return temaService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id) throws NotFoundException {
        temaService.findByIdAndDelete(id);
    }
}