package com.cos.blog.api;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @PostMapping("/api/user")
    public ResponseDto<Integer> userSaveApi(@RequestBody User user) {
        return new ResponseDto<Integer>(200, 1);
    }
}
