package com.example.springbootdev.service;

import com.example.springbootdev.domain.Article;
import com.example.springbootdev.dto.AddArticleRequest;
import com.example.springbootdev.dto.UpdateArticleRequest;
import com.example.springbootdev.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;


    @Transactional
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: " + id)); //이건 자바옵셔널임
    }

    public void delete(long id){
        blogRepository.deleteById(id);
    }


    @Transactional
    public Article update(long id , UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found:" + id));

        article.update(request.getTitle(), request.getContent());

        return article;


    }



}
