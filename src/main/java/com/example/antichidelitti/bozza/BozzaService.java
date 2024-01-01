package com.example.antichidelitti.bozza;

import com.example.antichidelitti.categoria.Categoria;
import com.example.antichidelitti.categoria.CategoriaRepository;
import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.luogo.LuogoRepository;
import com.example.antichidelitti.payloads.entities.BozzaDTO;
import com.example.antichidelitti.payloads.entities.TagDTO;
import com.example.antichidelitti.tag.Tag;
import com.example.antichidelitti.tag.TagRepository;
import com.example.antichidelitti.tema.Tema;
import com.example.antichidelitti.tema.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BozzaService {
    @Autowired
    BozzaRepository bozzaRepository;
    @Autowired
    TagRepository tagRepository;
    @Autowired
    TemaRepository temaRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    LuogoRepository luogoRepository;
    public void save(){
        Bozza bozza = new Bozza();
        bozzaRepository.save(bozza);
    }

    public Bozza findById(long id) throws NotFoundException {
        return bozzaRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public List<Bozza> getAll(){
        return bozzaRepository.findAll();
    }

    public Bozza findByIdAndUpdate(long id, BozzaDTO body) throws NotFoundException {
        Bozza found = bozzaRepository.findById(id).get();
        List<Tag> tagList = new ArrayList<>();
        List<Tema> temaList = new ArrayList<>();
        List<Categoria> categoriaList = new ArrayList<>();

        found.setLuogo(luogoRepository.findById(body.luogo_id()).get());
        for(Long t : body.tag_id()){
            tagList.add(tagRepository.findById(t).get());
        }
        found.setTagList(tagList);
        for(Long t : body.category_id()){
            categoriaList.add(categoriaRepository.findById(t).get());
        }
        found.setCategoriaList(categoriaList);
        for(Long t : body.theme_id()){
            temaList.add(temaRepository.findById(t).get());
        }
        found.setTemaList(temaList);

        return bozzaRepository.save(found);
    }

    public void findByIdAndDelete(long id) throws NotFoundException {
        Bozza found = this.findById(id);
        bozzaRepository.delete(found);
    }
}
