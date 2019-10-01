package org.yoganala.lunch.repository;

import org.springframework.data.repository.CrudRepository;
import org.yoganala.lunch.entity.Article;

public interface ArticleRepo extends CrudRepository<Article,Integer> {
}
