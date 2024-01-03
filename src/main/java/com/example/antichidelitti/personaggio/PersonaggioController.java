package com.example.antichidelitti.personaggio;

import com.example.antichidelitti.exception.BadRequestException;
import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.payloads.entities.TagDTO;
import com.example.antichidelitti.tag.Tag;
import com.example.antichidelitti.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personaggio")
public class PersonaggioController {
    @Autowired
    PersonaggioService personaggioService;
    @Autowired
    PersonaggioRepository personaggioRepository;
    @GetMapping("")
    public List<Personaggio> findAll(){
        return personaggioService.getAll();
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void save(@RequestBody @Validated Personaggio body, BindingResult validation){
        if(validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        }else if(personaggioRepository.findByAlias(body.getAlias())!=null){
            throw new BadRequestException("Personaggio già presente");
        }else {
            personaggioService.save(body);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Personaggio findByIdAndUpdate(@PathVariable int id, @RequestBody Personaggio body) throws NotFoundException {
        return personaggioService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id) throws NotFoundException {
        personaggioService.findByIdAndDelete(id);
    }
    @GetMapping("/{alias}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Personaggio> findByAliasContainsIgnoreCase(@PathVariable String alias){
        return personaggioService.findByAliasContainsIgnoreCase(alias);
    }
}
