package org.maxvas.factorapp.repository;

import org.maxvas.batchnews.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
    List<Article> findAll();
}
