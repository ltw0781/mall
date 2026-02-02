package com.firstshop.mall.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.firstshop.mall.board.domain.Board;

@Mapper
public interface BoardMapper {
    
    // 게시판 목록
    public List<Board> list() throws Exception;

    // 게시판 상세
    public Board read(int no) throws Exception;

    // 게시판 등록
    public int insert(Board board) throws Exception;

    // 게시판 수정
    public int update(Board board) throws Exception;

    // 게시판 삭제
    public int delete(int no) throws Exception;



}
