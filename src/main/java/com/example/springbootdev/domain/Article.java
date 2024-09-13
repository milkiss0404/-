package com.example.springbootdev.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//기본키를 자동으로 1씩증가
    @Column(name = "id" , updatable = false)
    private Long id ;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "content",nullable = false)
    private String content;

    @CreatedDate // 엔티티가 생성될떄 생성시간 저장
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate //엔티티가 수정될때 수정시간 저장
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }


//    protected Article() {
//
//    }
}

