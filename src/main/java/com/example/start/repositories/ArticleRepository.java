package com.example.start.repositories;

import com.example.start.entities.Article;
import com.example.start.entities.CatArticle;
import com.example.start.enums.Etat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    //Etat etatArt = Etat.VALIDE;
    // https://docs.oracle.com/html/E13946_04/ejb3_langref.html#ejb3_langref_select
    List<Article> findByEtatArticle(Etat etat);
    Optional<Article> findByIdAndEtatArticle(Long id, Etat etat);

    @Query("SELECT a FROM Article a JOIN FETCH a.catArticle WHERE a.etatArticle = :etatArticle")
    List<Article> findAllArticlesWithCategories(@Param("etatArticle") Etat etatArt);
}
