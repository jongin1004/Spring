package com.cos.blog.service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 컴포넌트 스캔을 통해서 Bean에 등록하도록
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public int join(User user) {
        try {
            userRepository.save(user);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        
        return -1;
    }
}
