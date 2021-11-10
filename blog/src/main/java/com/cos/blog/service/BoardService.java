package com.cos.blog.service;

import com.cos.blog.model.Board;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;


// 컴포넌트 스캔을 통해서 Bean에 등록하도록
@Service
public class BoardService {
    
    @Autowired
    private BoardRepository boardRepository;


    //아래 함수를 하나의 트랜젝션으로 묻어서, 성공하면 commit을 실패하면 rollback을 하도록
    @Transactional
    public void save(Board board, User user) {
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }


    @Transactional(readOnly = true) //select만 할때
    public Page<Board> boardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }


    @Transactional(readOnly = true) //select만 할때
    public Board showBoard(int id) {
        return boardRepository.findById(id).orElseThrow(()->{
           return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다.");
        });
    }

    @Transactional
    public void deleteById(int id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, Board requestBoard) {
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("글 찾기 실패: 아이디를 찾을 수 없습니다.");
        });//영속화 완료

        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        //해당 함수로 종료시(서비스가 종료될때) 트랜잭션이 종료됨. 이때 더티체킹(영속화되어있는 board의 데이트 값이 변경이 일어나서 -> 자동 업데이트)
    }
}
