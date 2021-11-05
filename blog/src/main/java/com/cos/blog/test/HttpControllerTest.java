package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

@RestController
public class HttpControllerTest {

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
