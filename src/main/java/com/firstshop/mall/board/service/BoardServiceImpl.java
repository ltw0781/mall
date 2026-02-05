package com.firstshop.mall.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstshop.mall.board.domain.Board;
import com.firstshop.mall.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    // 게시판 목록
    @Override
    public List<Board> list() throws Exception {
        return boardMapper.list();
    }

    // 게시판 상세
    @Override
    public Board read(int no) throws Exception {
        return boardMapper.read(no);
    }

    // 게시판 등록
    @Override
    public int insert(Board board) throws Exception {
        return boardMapper.insert(board);
    }

    // 게시판 수정
    @Override
    public int update(Board board) throws Exception {
        return boardMapper.update(board);
    }

    // 게시판 삭제
    @Override
    public int delete(int no) throws Exception {
        return boardMapper.delete(no);
    }
}
