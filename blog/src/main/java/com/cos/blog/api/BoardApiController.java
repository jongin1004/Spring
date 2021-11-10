package com.cos.blog.api;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApiController {

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody User user) {

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
