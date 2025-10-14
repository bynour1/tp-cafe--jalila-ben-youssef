package repositories;

import com.example.tp_cafe_jalila_ben_youssef.Entite.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Long> {
}
