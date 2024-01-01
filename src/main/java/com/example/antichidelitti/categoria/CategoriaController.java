package com.example.antichidelitti.categoria;

import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.payloads.entities.CategoryDTO;
import com.example.antichidelitti.payloads.entities.TagDTO;
import com.example.antichidelitti.tag.Tag;
import com.example.antichidelitti.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;
    @GetMapping("")
    public List<Categoria> findAll(){
        return categoriaService.getAll();
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void save(CategoryDTO body){
        categoriaService.save();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Categoria findByIdAndUpdate(@PathVariable int id, @RequestBody CategoryDTO body) throws NotFoundException {
        return categoriaService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id) throws NotFoundException {
        categoriaService.findByIdAndDelete(id);
    }
}
