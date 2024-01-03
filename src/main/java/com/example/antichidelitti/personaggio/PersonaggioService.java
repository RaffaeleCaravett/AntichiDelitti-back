package com.example.antichidelitti.personaggio;

import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.luogo.Luogo;
import com.example.antichidelitti.payloads.entities.TagDTO;
import com.example.antichidelitti.tag.Tag;
import com.example.antichidelitti.tag.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaggioService {
    @Autowired
    PersonaggioRepository personaggioRepository;
    public void save(Personaggio body){
        Personaggio personaggio = new Personaggio();
        personaggio.setName(body.getName());
        personaggio.setSurname(body.getSurname());
        personaggio.setAlias(body.getAlias());
        personaggioRepository.save(personaggio);
    }

    public Personaggio findById(long id) throws NotFoundException {
        return personaggioRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public List<Personaggio> getAll(){
        return personaggioRepository.findAll();
    }

    public Personaggio findByIdAndUpdate(long id, Personaggio body) throws NotFoundException {
        Personaggio found = personaggioRepository.findById(id).get();
        found.setName(body.getName());
        found.setSurname(body.getSurname());
        found.setAlias(body.getAlias());
        //found.setPassword(bcrypt.encode(body.getPassword()));
        return personaggioRepository.save(found);
    }

    public void findByIdAndDelete(long id) throws NotFoundException {
        Personaggio found = this.findById(id);
        personaggioRepository.delete(found);
    }
    public List<Personaggio> findByAliasContainsIgnoreCase(String alias) throws NotFoundException {
        return personaggioRepository.findByAliasContainsIgnoreCase(alias);
    }
}
