package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

@RestController
public class HttpControllerTest {

    @GetMapping("/http/lombock")
    public String lombockTest() {
        Member member = new Member().builder().name("jongin").password("chl123").email("jongin@naver.com").build();
        System.out.println("member.name = " + member.getName());
        member.setName("chlwhddls");
        System.out.println("member.name = " + member.getName());
        return "lombockTest";
    }
    @GetMapping("/http/get")
    public String getTest(Member m) {
        return "getTest" + m.getId() +","+ m.getName();
    }

    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m) {
        return "postTest, " + m.getId() + m.getName() + m.getPassword() + m.getEmail();
    }

    @PutMapping("/http/put")
    public String putTest() {
        return "putTest";
    }

    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "deleteTest";
    }
}
