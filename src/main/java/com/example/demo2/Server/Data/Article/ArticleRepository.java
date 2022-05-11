package com.example.demo2.Server.Data.Article;

import com.example.demo2.Server.Data.User.DalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<DalArticle, String> {
}
