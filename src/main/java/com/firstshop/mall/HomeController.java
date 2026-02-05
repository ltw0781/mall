package com.firstshop.mall;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.firstshop.mall.board.domain.Board;
import com.firstshop.mall.board.service.BoardService;

@Controller
public class HomeController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String home(Model model) throws Exception {
        List<Board> boardList = boardService.list();
        model.addAttribute("boardList", boardList);
        return "index";
    }
}
