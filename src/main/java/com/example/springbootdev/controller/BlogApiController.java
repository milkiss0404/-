package com.example.springbootdev.controller;

import com.example.springbootdev.domain.Article;
import com.example.springbootdev.dto.AddArticleRequest;
import com.example.springbootdev.dto.ArticleResponse;
import com.example.springbootdev.dto.UpdateArticleRequest;
import com.example.springbootdev.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest addArticleRequest){
        Article saveArticle = blogService.save(addArticleRequest);


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saveArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();
        return ResponseEntity.ok() //ok() 메서드는 HTTP 200 Status Code와 함께 Response를 생성한다. 이는 가장 일반적으로 사용되는 메서드 중 하나이다.
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id){
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id){
        blogService.delete(id);
        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id , @RequestBody UpdateArticleRequest request){
        Article updateArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updateArticle);
    }


}
