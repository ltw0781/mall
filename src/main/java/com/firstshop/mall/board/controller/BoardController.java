package com.firstshop.mall.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    // 게시판 상세
    @GetMapping("/read")
    public void read(@RequestParam("no") int no, Model model) throws Exception {
        Board board = boardService.read(no);
        model.addAttribute("board", board);
    }

    // 게시판 등록 화면
    @GetMapping("/insert")
    public void insertForm() {
    }

    // 게시판 등록 처리
    @PostMapping("/insert")
    public String insert(Board board, RedirectAttributes redirectAttributes) throws Exception {
        int result = boardService.insert(board);
        redirectAttributes.addFlashAttribute("message", result > 0 ? "등록되었습니다." : "등록에 실패했습니다.");
        return "redirect:/board/list";
    }

    // 게시판 수정 화면
    @GetMapping("/update")
    public void updateForm(@RequestParam("no") int no, Model model) throws Exception {
        Board board = boardService.read(no);
        model.addAttribute("board", board);
    }

    // 게시판 수정 처리
    @PostMapping("/update")
    public String update(Board board, RedirectAttributes redirectAttributes) throws Exception {
        int result = boardService.update(board);
        redirectAttributes.addFlashAttribute("message", result > 0 ? "수정되었습니다." : "수정에 실패했습니다.");
        return "redirect:/board/read?no=" + board.getNo();
    }

    // 게시판 삭제 처리
    @PostMapping("/delete")
    public String delete(@RequestParam("no") int no, RedirectAttributes redirectAttributes) throws Exception {
        int result = boardService.delete(no);
        redirectAttributes.addFlashAttribute("message", result > 0 ? "삭제되었습니다." : "삭제에 실패했습니다.");
        return "redirect:/board/list";
    }
}
