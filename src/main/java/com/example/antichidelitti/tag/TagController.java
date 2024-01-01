package com.example.antichidelitti.tag;


import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.payloads.entities.TagDTO;
import com.example.antichidelitti.payloads.entities.TemaDTO;
import com.example.antichidelitti.tema.Tema;
import com.example.antichidelitti.tema.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    TagService tagService;
    @GetMapping("")
    public List<Tag> findAll(){
        return tagService.getAll();
    }

    @PostMapping("")
    public void save(TagDTO body){
        tagService.save();
    }

    @PutMapping("/{id}")
    public Tag findByIdAndUpdate(@PathVariable int id, @RequestBody TagDTO body) throws NotFoundException {
        return tagService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id) throws NotFoundException {
        tagService.findByIdAndDelete(id);
    }
}
