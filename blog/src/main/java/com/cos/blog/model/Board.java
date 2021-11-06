package com.cos.blog.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //대용량 데이터
    private String content; //섬모노트 라이브러리 사용 <html>태그가 섞임

    @ColumnDefault("0")
    private int count;

    @ManyToOne // Many = board, one = user -> 한 명의 유저는 여러개의 게시글을 가질 수 있다.
    @JoinColumn(name="userId") // 실제 테이블에는 userId라는 속성이름으로 저장됨
    private User user; //DB는 오브젝트를 저장할 수 없기 때문에 id(FK)를 사용

    @CreationTimestamp
    private Timestamp createDate;
}
