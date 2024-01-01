package com.example.antichidelitti.tema;

import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.payloads.entities.TemaDTO;
import com.example.antichidelitti.payloads.entities.UserRegistrationDTO;
import com.example.antichidelitti.user.User;
import com.example.antichidelitti.visita.Visita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaService {
    @Autowired
   TemaRepository temaRepository;
    public void save(){
        Tema tema = new Tema();
        temaRepository.save(tema);
    }

    public Tema findById(long id) throws NotFoundException {
        return temaRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public List<Tema> getAll(){
        return temaRepository.findAll();
    }

    public Tema findByIdAndUpdate(long id, TemaDTO body) throws NotFoundException {
        Tema found = temaRepository.findById(id).get();
        found.setThema(body.thema());
        //found.setPassword(bcrypt.encode(body.getPassword()));
        return temaRepository.save(found);
    }

    public void findByIdAndDelete(long id) throws NotFoundException {
        Tema found = this.findById(id);
        temaRepository.delete(found);
    }
}
