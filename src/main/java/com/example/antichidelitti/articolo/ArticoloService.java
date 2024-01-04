package com.example.antichidelitti.articolo;

import com.example.antichidelitti.categoria.Categoria;
import com.example.antichidelitti.categoria.CategoriaRepository;
import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.luogo.LuogoRepository;
import com.example.antichidelitti.payloads.entities.ArticoloDTO;
import com.example.antichidelitti.payloads.entities.TagDTO;
import com.example.antichidelitti.personaggio.Personaggio;
import com.example.antichidelitti.personaggio.PersonaggioRepository;
import com.example.antichidelitti.tag.Tag;
import com.example.antichidelitti.tag.TagRepository;
import com.example.antichidelitti.tema.Tema;
import com.example.antichidelitti.tema.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticoloService {
    @Autowired
    ArticoloRepository articoloRepository;
    @Autowired
    TagRepository tagRepository;
    @Autowired
    TemaRepository temaRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    LuogoRepository luogoRepository;
    @Autowired
    PersonaggioRepository personaggioRepository;
    public void save(ArticoloDTO body){
        Articolo found = new Articolo();
        found.setTesto(body.testo());
        found.setTitolo(body.titolo());
        List<Tag> tagList = new ArrayList<>();
        List<Tema> temaList = new ArrayList<>();
        List<Categoria> categoriaList = new ArrayList<>();
        List<Personaggio> personaggioList = new ArrayList<>();

        if(body.luogo_id()!=0){
            found.setLuogo(luogoRepository.findById(body.luogo_id()).get());
        }

        if(!body.tag_id().isEmpty()){
            for(Long t : body.tag_id()){
                tagList.add(tagRepository.findById(t).get());
            }
        }
        found.setTagList(tagList);
        if(!body.category_id().isEmpty()){
            for(Long t : body.category_id()){
                categoriaList.add(categoriaRepository.findById(t).get());
            }
        }

        found.setCategoriaList(categoriaList);
        if(!body.theme_id().isEmpty()){
            for(Long t : body.theme_id()){
                temaList.add(temaRepository.findById(t).get());
            }
        }

        found.setTemaList(temaList);
        if(!body.personaggio_id().isEmpty()) {
            for (Long t : body.personaggio_id()) {
                personaggioList.add(personaggioRepository.findById(t).get());
            }
        }
        found.setPersonaggioList(personaggioList);
        List<String> imageList = new ArrayList<>(body.imageList());
        found.setTemaList(temaList);
        found.setImages(imageList);
        found.setCreated_at(LocalDate.now());
        articoloRepository.save(found);
    }

    public Articolo findById(long id) throws NotFoundException {
        return articoloRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public List<Articolo> getAll(){
        return articoloRepository.findAll();
    }

    public Articolo findByIdAndUpdate(long id, ArticoloDTO body) throws NotFoundException {
        Articolo found = articoloRepository.findById(id).get();
        found.setTesto(body.testo());
        found.setTitolo(body.titolo());
        List<Tag> tagList = new ArrayList<>();
        List<Tema> temaList = new ArrayList<>();
        List<Categoria> categoriaList = new ArrayList<>();
        List<Personaggio> personaggioList = new ArrayList<>();
if(body.luogo_id()!=0){
    found.setLuogo(luogoRepository.findById(body.luogo_id()).get());
}

if(!body.tag_id().isEmpty()){
    for(Long t : body.tag_id()){
        tagList.add(tagRepository.findById(t).get());
    }
}
            found.setTagList(tagList);
            if(!body.category_id().isEmpty()){
        for(Long t : body.category_id()){
            categoriaList.add(categoriaRepository.findById(t).get());
        }
    }

            found.setCategoriaList(categoriaList);
            if(!body.theme_id().isEmpty()){
        for(Long t : body.theme_id()){
            temaList.add(temaRepository.findById(t).get());
        }
    }

            found.setTemaList(temaList);
          if(!body.personaggio_id().isEmpty()) {
            for (Long t : body.personaggio_id()) {
                personaggioList.add(personaggioRepository.findById(t).get());
            }
        }
        found.setPersonaggioList(personaggioList);
        List<String> imageList = new ArrayList<>(body.imageList());
        found.setTemaList(temaList);
        found.setImages(imageList);
        return articoloRepository.save(found);
    }

    public void findByIdAndDelete(long id) throws NotFoundException {
        Articolo found = this.findById(id);
        articoloRepository.delete(found);
    }
}
