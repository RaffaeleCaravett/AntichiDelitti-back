package com.example.antichidelitti.visita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService {

    @Autowired
    VisitRepository visitRepository;

    public void save(){
        Visita visit = new Visita();
        visitRepository.save(visit);
    }

    public List<Visita> getAll(){
        return visitRepository.findAll();
    }
}
