package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
public class DumyControllerTest {

    @Autowired //의존성 주입
    private UserRepository userRepository;

    //람다식을 이용
//    @GetMapping("/dummy/user/{id}")
//    public User detail(@PathVariable int id) {
//        User user = userRepository.findById(id).orElseThrow(() -> {
//           return new IllegalArgumentException("해당 유저는 존재하지 안습니다 ID : " + id);
//        });
//        return user;
//    }

    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 존재하지 안습니다 ID : " + id);
            }
        });
        //요청 : 웹브라우저
        //@RestController : html이 아닌 data를 리턴
        //user 객체 = 자바 오브젝트
        // -> 웹 브라우저에서는 user객체를 이해하지 못함  -> 변환이 필요함 (JSON)
        //스프링부트는 MessageConvert가 자동으로 Jackson을 이용해서 JSON으로 변환해줌
        return user;
    }

    @GetMapping("/dummy/users")
    public List<User> list() {
        return userRepository.findAll();
    }

    //한 페이지당 2건의 데이터를 리턴 받음
    @GetMapping("/dummy/user/page")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> pagingUser = userRepository.findAll(pageable);
        List<User> users = pagingUser.getContent();

        return users;
    }

    //@RequestBody = JSON데이터를 받을 경우에 필요함 (MasseageConvert의 Jackson라이브러리가 JSON을 객체로 만들어줌)
    @Transactional
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
        System.out.println("id = " + id + ", requestUser.password = " + requestUser.getPassword());
        System.out.println("id = " + id + ", requestUser.email = " + requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("유저 없음");
        });
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());
//        userRepository.save(user);

        return null;
    }

    // http://localhost:8000/blog/dummy/join
    @PostMapping("/dummy/join")
    public String join(User user) {
        System.out.println("username = " + user.getUsername());
        System.out.println("password = " + user.getPassword());
        System.out.println("email = " + user.getEmail());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
