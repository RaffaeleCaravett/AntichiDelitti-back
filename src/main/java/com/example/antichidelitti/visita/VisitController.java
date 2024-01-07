package com.example.antichidelitti.visita;

import com.example.antichidelitti.articolo.Articolo;
import com.example.antichidelitti.articolo.ArticoloService;
import com.example.antichidelitti.categoria.Categoria;
import com.example.antichidelitti.categoria.CategoriaService;
import com.example.antichidelitti.luogo.Luogo;
import com.example.antichidelitti.luogo.LuogoService;
import com.example.antichidelitti.payloads.entities.ArticoloFilterDTO;
import com.example.antichidelitti.tema.Tema;
import com.example.antichidelitti.tema.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/visit")
public class VisitController {

    @Autowired
    VisitService visitService;
    @Autowired
    ArticoloService articoloService;
    @Autowired
    CategoriaService categoriaService;
    @Autowired
    TemaService temaService;
    @Autowired
    LuogoService luogoService;
    @GetMapping("")
    public List<Visita> findAll(){
        return visitService.getAll();
    }

    @PostMapping("")
    public void save(){
        visitService.save();
    }

    @GetMapping("/articles")
    public Page<Articolo> getArticles(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "id") String orderBy){
        return articoloService.getAll(page, size, orderBy);
    }
    @GetMapping("/categories")
    public List<Categoria> findAllCategories(){
        return categoriaService.getAll();
    }
    @GetMapping("/places")
    public List<Luogo> findAllPlaces(){
        return luogoService.getAll();
    }
    @GetMapping("/themas")
    public List<Tema> findAllThemas(){
        return temaService.getAll();
    }
    @PostMapping("/filtered")
    public List<Articolo> getArticlesFiltered(@RequestBody ArticoloFilterDTO articoloFilterDTO){
        return articoloService.getAllFiltered(articoloFilterDTO);
    }
}