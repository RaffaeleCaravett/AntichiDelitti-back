package com.example.antichidelitti.luogo;

import com.example.antichidelitti.categoria.Categoria;
import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.payloads.entities.LuogoDTO;
import com.example.antichidelitti.payloads.entities.TagDTO;
import com.example.antichidelitti.tag.Tag;
import com.example.antichidelitti.tag.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LuogoService {
    @Autowired
    LuogoRepository luogoRepository;
    public void save(LuogoDTO body){
        Luogo luogo = new Luogo();
        luogo.setLuogo(body.luogo());
        luogoRepository.save(luogo);
    }

    public Luogo findById(long id) throws NotFoundException {
        return luogoRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public List<Luogo> getAll(){
        return luogoRepository.findAll();
    }

    public Luogo findByIdAndUpdate(long id, LuogoDTO body) throws NotFoundException {
        Luogo found = luogoRepository.findById(id).get();
        found.setLuogo(body.luogo());
        return luogoRepository.save(found);
    }

    public void findByIdAndDelete(long id) throws NotFoundException {
        Luogo found = this.findById(id);
        luogoRepository.delete(found);
    }
    public List<Luogo> findByLuogoContainsIgnoreCase(String luogo) throws NotFoundException {
        return luogoRepository.findByLuogoContainsIgnoreCase(luogo);
    }
}
