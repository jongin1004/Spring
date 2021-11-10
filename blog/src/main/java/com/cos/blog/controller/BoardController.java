package com.cos.blog.controller;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    //WEB-INF/views/index.jsp
    @GetMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("boards", boardService.boardList());
        return "index"; //viewResolver가 작동하여, 해당 return값 index페이지로 model의 정보를 전달해줌
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
}
