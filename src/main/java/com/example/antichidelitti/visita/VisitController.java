package com.example.antichidelitti.visita;

import com.example.antichidelitti.articolo.Articolo;
import com.example.antichidelitti.articolo.ArticoloService;
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

    @GetMapping("")
    public List<Visita> findAll(){
        return visitService.getAll();
    }

    @PostMapping("")
    public void save(){
        visitService.save();
    }

    @GetMapping("/articoles")
    public Page<Articolo> getArticles(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "id") String orderBy){
        return articoloService.getAll(page, size, orderBy);
    }
}