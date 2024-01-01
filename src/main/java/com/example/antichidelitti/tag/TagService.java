package com.example.antichidelitti.tag;

import com.example.antichidelitti.exception.NotFoundException;
import com.example.antichidelitti.payloads.entities.TagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;
    public void save(){
        Tag tag = new Tag();
        tagRepository.save(tag);
    }

    public Tag findById(long id) throws NotFoundException {
        return tagRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public List<Tag> getAll(){
        return tagRepository.findAll();
    }

    public Tag findByIdAndUpdate(long id, TagDTO body) throws NotFoundException {
        Tag found = tagRepository.findById(id).get();
        found.setTag(body.tag());
        //found.setPassword(bcrypt.encode(body.getPassword()));
        return tagRepository.save(found);
    }

    public void findByIdAndDelete(long id) throws NotFoundException {
        Tag found = this.findById(id);
        tagRepository.delete(found);
    }
}
