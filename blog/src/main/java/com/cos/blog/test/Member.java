package com.cos.blog.test;

import lombok.*;

@Data //@Getter + @Setter
//@RequiredArgsConstructor //final이 붙은 맴버변수를 매개변수로한 생성자 자동생성
//@AllArgsConstructor //모든 맴버변수를 생성자로
@NoArgsConstructor // 빈(매개변수가 없는) 생성자 생성
public class Member {

    private int id;
    private String name;
    private String password;
    private String email;

    //Builder를 이용하면, 생성자를 오버로딩한 효과를 볼 수 있다.
    @Builder
    public Member(int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
