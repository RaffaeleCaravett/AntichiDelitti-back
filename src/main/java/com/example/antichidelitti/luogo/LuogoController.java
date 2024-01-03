package com.example.antichidelitti.luogo;

import com.example.antichidelitti.exception.BadRequestException;
import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.payloads.entities.LuogoDTO;
import com.example.antichidelitti.payloads.entities.TagDTO;
import com.example.antichidelitti.payloads.entities.TemaDTO;
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
@RequestMapping("/luogo")
public class LuogoController {
    @Autowired
    LuogoService luogoService;
    @Autowired
    LuogoRepository luogoRepository;
    @GetMapping("")
    public List<Luogo> findAll(){
        return luogoService.getAll();
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void save(@RequestBody @Validated LuogoDTO body, BindingResult validation){
        if(validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        }else if(luogoRepository.findByLuogo(body.luogo())!=null){
            throw new BadRequestException("Luogo già presente");
        }else {
            luogoService.save(body);
        }
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
    @GetMapping("/luogo")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Luogo> findBLuogoContainsIgnoreCase(@PathVariable String luogo){
        return luogoService.findByLuogoContainsIgnoreCase(luogo);
    }
}
