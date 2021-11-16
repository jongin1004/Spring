package com.cos.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //대용량 데이터
    private String content; //섬모노트 라이브러리 사용 <html>태그가 섞임

    //@ColumnDefault("0")
    private int count;

    // Many = board, one = user -> 한 명의 유저는 여러개의 게시글을 가질 수 있다.
    //ManyToOne일 경우에는 FetchType의 기본값이 EAGER이기 때문에, 생략가능
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId") // 실제 테이블에는 userId라는 속성이름으로 저장됨
    private User user; //DB는 오브젝트를 저장할 수 없기 때문에 id(FK)를 사용

    //mappedBy 연관관계의 주인이 아닌다. (FK가 아닙니다.) DB에 칼럼을 만들지 마세요
    //fetch = FetchType.EAGER -> 무조건 다 땡겨와라! / EAGER이 아닌, LAZY는 필요할 때만 가져와라 라는 의미
    //OneToMany일 경우에는 FetchType의 기본 값이 LAZY이기 때문에, 설정해줘야함
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"board"}) // 무한참조되는 것을 막기 위함
    @OrderBy("id desc")
    private List<Reply> replys;


    @CreationTimestamp
    private Timestamp createDate;
}
