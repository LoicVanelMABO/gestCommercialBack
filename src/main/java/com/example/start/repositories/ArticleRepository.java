package com.example.start.repositories;

import com.example.start.entities.Article;
import com.example.start.entities.CatArticle;
import com.example.start.enums.Etat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    List<Article> findByEtatArticle(Etat etat);
    Optional<Article> findByIdAndEtatArticle(Long id, Etat etat);
}
