package com.example.antichidelitti.visita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VisitService {

    @Autowired
    VisitRepository visitRepository;

    public void save(){
        Visita visit = new Visita();
        visit.setCreated_at(LocalDate.now());
        visitRepository.save(visit);
    }

    public List<Visita> getAll(){
        return visitRepository.findAll();
    }
}
