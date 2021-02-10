package edu.bit.ex.service;

import java.util.List;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;







public interface BoardService {

	public List<BoardVO> getList() ;

	public BoardVO getBoard(int getbId);

	public void writeBoard(BoardVO boardVO);

	public BoardVO getReply(int getbId);

	public void replyInsert(BoardVO boardVO);

	public void delete(int getbId);

	public int modify(BoardVO boardVO);

	public List<BoardVO>getList(Criteria criteria);

	public int getTotal(Criteria criteria);

	public void remove(int getbId);

	public void rest_modify(BoardVO boardVO);

	

}
