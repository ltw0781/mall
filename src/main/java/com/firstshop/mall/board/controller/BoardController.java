package com.firstshop.mall.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firstshop.mall.board.domain.Board;
import com.firstshop.mall.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시판 목록
    @GetMapping("/list")
    public void list(Model model) throws Exception {

        List<Board> boardList = boardService.list();
        model.addAttribute("boardList", boardList);

    }

    
}
