package com.example.antichidelitti.tag;


import com.example.antichidelitti.categoria.Categoria;
import com.example.antichidelitti.exception.BadRequestException;
import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.payloads.entities.TagDTO;
import com.example.antichidelitti.payloads.entities.TemaDTO;
import com.example.antichidelitti.tema.Tema;
import com.example.antichidelitti.tema.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    TagService tagService;
    @Autowired
    TagRepository tagRepository;
    @GetMapping("")
    public List<Tag> findAll(){
        return tagService.getAll();
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void save(@RequestBody @Validated TagDTO body, BindingResult validation){
        if(validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        }else if(tagRepository.findByTag(body.tag())!=null){
            throw new BadRequestException("Tag già presente");
        }else {
            tagService.save(body);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Tag findByIdAndUpdate(@PathVariable int id, @RequestBody TagDTO body) throws NotFoundException {
        return tagService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id) throws NotFoundException {
        tagService.findByIdAndDelete(id);
    }
    @GetMapping("/{tag}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Tag> findBTagContainsIgnoreCase(@PathVariable String tag){
        return tagService.findByTagContainsIgnoreCase(tag);
    }
}
