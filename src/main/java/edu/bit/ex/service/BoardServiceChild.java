package edu.bit.ex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.BoardMapper;
import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@Log4j
@Service
@AllArgsConstructor

public class BoardServiceChild implements BoardService {
	private BoardMapper mapper;
	@Override
	public List<BoardVO> getList() {
		
		return mapper.bringList();
	}
	@Override
	public BoardVO getBoard(int getbId) {
		
		log.info("getBoard........");
		mapper.upHit(getbId);
		return mapper.getBoard(getbId);
	}
	@Override
	public void writeBoard(BoardVO boardVO) {
		log.info("writeBoard........");
		mapper.writeBoard(boardVO);
		
	}
	@Override
	public BoardVO getReply(int bno) {
		log.info("getReply........");
		return mapper.getReply(bno);
	}
	@Override
	public void replyInsert(BoardVO boardVO) {
		log.info("replyreply........");
		mapper.replyInsert(boardVO);
		mapper.replyshape(boardVO);
		
	}
	@Override
	public void delete(int bId) {
		
		log.info("delete........");
		mapper.deleteInsert(bId);
	}
	@Override
	public int modify(BoardVO boardVO) {
		return mapper.modify(boardVO);
		
	}
	@Override
	public List<BoardVO> getList(Criteria criteria) {
		
		return mapper.getListWithPaging(criteria);
	}
	@Override
	public int getTotal(Criteria criteria) {
		
		return mapper.getTotalCount(criteria);
	}
	@Override
	public void remove(int bId) {
		log.info("remove..........");	
		mapper.remove(bId);
	}
	@Override
	public void rest_modify(BoardVO boardVO) {
		mapper.rest_modify(boardVO);
		
	}

}
