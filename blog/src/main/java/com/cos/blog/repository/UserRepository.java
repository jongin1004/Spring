package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

//JpaRepository<User, Integer> => User를 관리하는 Repository이고 PK는 Integer이다.
//자동으로 bean으로 등록된다 = @Repository 어노테이션을 생략할 수 있다.
public interface UserRepository extends JpaRepository<User, Integer> {

    //SELECT * FROM user WHERE username = ?;
    Optional<User> findByUsername(String username);
}

//jpa 네이밍전략
//SELECT * FROM user WHERE username = ? AND password = ?;
//User findByUsernameAndPassword(String username, String password);

//@Query(value="SELECT * FROM user WHERE username = ? AND password = ?", nativeQuery = true)
//User login(String username, String password);
