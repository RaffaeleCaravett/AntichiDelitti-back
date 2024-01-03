package com.example.antichidelitti.tag;

import com.example.antichidelitti.tema.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {
    List<Tag> findByTagContainsIgnoreCase(String tag);
    Tag findByTag(String tag);
}
