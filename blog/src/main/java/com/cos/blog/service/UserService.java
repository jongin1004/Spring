package com.cos.blog.service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// 컴포넌트 스캔을 통해서 Bean에 등록하도록
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    //아래 함수를 하나의 트랜젝션으로 묻어서, 성공하면 commit을 실패하면 rollback을 하도록
    @Transactional
    public int join(User user) {
        userRepository.save(user);
        return 1;
    }

    //Select할 떄 트랙잭션 시작, 서비스 종료시에 트랜잭션 종료 (정합성 유지)
//    @org.springframework.transaction.annotation.Transactional(readOnly = true)
//    public User login(User user) {
//        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//    }
}
