package com.example.antichidelitti.categoria;

import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.payloads.entities.CategoryDTO;
import com.example.antichidelitti.payloads.entities.TagDTO;
import com.example.antichidelitti.tag.Tag;
import com.example.antichidelitti.tag.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository tagRepository;
    public void save(){
        Categoria categoria = new Categoria();
        tagRepository.save(categoria);
    }

    public Categoria findById(long id) throws NotFoundException {
        return tagRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public List<Categoria> getAll(){
        return tagRepository.findAll();
    }

    public Categoria findByIdAndUpdate(long id, CategoryDTO body) throws NotFoundException {
        Categoria found = tagRepository.findById(id).get();
        found.setCategory(body.category());
        //found.setPassword(bcrypt.encode(body.getPassword()));
        return tagRepository.save(found);
    }

    public void findByIdAndDelete(long id) throws NotFoundException {
        Categoria found = this.findById(id);
        tagRepository.delete(found);
    }
}
