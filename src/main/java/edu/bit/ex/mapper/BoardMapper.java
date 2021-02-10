package edu.bit.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;
@Mapper
public interface BoardMapper {




	public List<BoardVO> bringList();

	public BoardVO getBoard(int getbId);

	public void upHit(int getbId);

	public void writeBoard(BoardVO boardVO);

	public BoardVO getReply(int bno);

	public void replyInsert(BoardVO boardVO);

	//public BoardVO deleteInsert(int bId);

	public void replyshape(BoardVO boardVO);

	public int modify(BoardVO boardVO);

	public List<BoardVO> getListWithPaging(Criteria criteria);

	public int getTotalCount(Criteria criteria);

	

	public BoardVO  deleteInsert(int bId);

	

	public BoardVO remove(int bId);

	public void rest_modify(BoardVO boardVO);

	

}
