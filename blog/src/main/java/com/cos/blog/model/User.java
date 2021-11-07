package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@DynamicInsert //insert시에 null인 필드는 제외
@Entity //이 User클래스를 테이블화 하기 위해서, 맴버변수를 MySQL 테이블의 속성값으로 매핑
public class User {

    @Id //Primary key
    //GenerationType.IDENTITY 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    //MySQL인 경우에는 auto_increment를 따라가겠다.
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id; //auto_)increment

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    //@ColumnDefault("'user'")
    //@Enumerated(EnumType.STRING) -> DB는 RoleType이 없기 때문에, 알려줘야함
    @Enumerated(EnumType.STRING)
    private RoleType role; //Enum을 사용하는게 좋음

    @CreationTimestamp //시간이 자동으로 입력됨
    private Timestamp createDate;

}
