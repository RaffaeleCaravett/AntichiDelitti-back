package com.example.antichidelitti.visita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/visit")
public class VisitController {

    @Autowired
    VisitService visitService;

    @GetMapping("")
    public List<Visita> findAll(){
        return visitService.getAll();
    }

    @PostMapping("")
    public void save(){
        visitService.save();
    }
}