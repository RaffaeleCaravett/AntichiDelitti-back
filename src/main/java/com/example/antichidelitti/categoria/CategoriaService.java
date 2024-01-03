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
    CategoriaRepository categoriaRepository;
    public void save(CategoryDTO categoryDTO){
        Categoria categoria = new Categoria();
        categoria.setCategory(categoryDTO.category());
        categoriaRepository.save(categoria);
    }

    public Categoria findById(long id) throws NotFoundException {
        return categoriaRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public List<Categoria> getAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findByIdAndUpdate(long id, CategoryDTO body) throws NotFoundException {
        Categoria found = categoriaRepository.findById(id).get();
        found.setCategory(body.category());
        //found.setPassword(bcrypt.encode(body.getPassword()));
        return categoriaRepository.save(found);
    }

    public void findByIdAndDelete(long id) throws NotFoundException {
        Categoria found = this.findById(id);
        categoriaRepository.delete(found);
    }

    public List<Categoria> findByCategoryContainsIgnoreCase(String category) throws NotFoundException {
        return categoriaRepository.findByCategoryContainsIgnoreCase(category);
    }
}
