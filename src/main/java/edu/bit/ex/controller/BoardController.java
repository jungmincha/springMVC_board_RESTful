package edu.bit.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.page.PageVO;
import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class BoardController {
	
	private BoardService boardService;

	@GetMapping("/board/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list",boardService.getList());
		
	}
	
	@GetMapping("/board/list2")
	public void list(Criteria cri , Model model) {
		log.info("list2() ȣ��");
		log.info("cri");
		
		model.addAttribute("list",boardService.getList(cri));
		
		int total = boardService.getTotal(cri);
		log.info("total" + total);
		model.addAttribute("pageMaker", new PageVO(cri, total));
		
	}
	
	

/*	
	@GetMapping("/board/content_view")
	public String content_view(Model model , BoardVO boardVO)throws Exception {
		log.info("content_view");

		model.addAttribute("content_view", boardService.getBoard(boardVO.getbId()));

		return "board/content_view";
		
		
	}
*/
	
	@GetMapping("/board/write_view")
	public String write_view() {
		log.info("write_view");


		return "board/write_view";
		
		
	}
	@PostMapping("/board/write") //���⼭ 1�ð� �ɷȴ�. /board �ȿ� ���������� ������ board�� ����� �Ѵ�.
	public String write(BoardVO boardVO)throws Exception {
		log.info("write");
		boardService.writeBoard(boardVO);
		
		return "redirect:list";//�����̷�Ʈ list�� ���� 
		
	}
	
	
	@PostMapping("/board/modify") //���⼭ 1�ð� �ɷȴ�. /board �ȿ� ���������� ������ board�� ����� �Ѵ�.
	public String modify(BoardVO boardVO)throws Exception {
		log.info("modify");
		boardService.modify(boardVO);
		
		return "redirect:list";//�����̷�Ʈ list�� ���� 
		
	}
	
	
	
	
	
	
	
	@GetMapping("/board/reply_view")
	public String reply_view(Model model , BoardVO boardVO)throws Exception {
		log.info("reply_view");

		model.addAttribute("reply_view", boardService.getReply(boardVO.getbId()));

		return "board/reply_view";
		
		
	}
	
	@PostMapping("/board/reply") //���⼭ 1�ð� �ɷȴ�. /board �ȿ� ���������� ������ board�� ����� �Ѵ�.
	public String reply(BoardVO boardVO)throws Exception {
		log.info("reply");
		boardService.replyInsert(boardVO);
		
		return "redirect:list"; //�����̷�Ʈ list�� ���� 
		
	}

	@GetMapping("/board/delete")
	public String delete(BoardVO boardVO)throws Exception {
		log.info("delete");
		
		
	boardService.delete(boardVO.getbId());
	
	return "redirect:list"; 
	
	}

	
		
		@GetMapping("/board/listUpgrade")
		public String listUpgrade() {
			log.info("/board/listUpgrade");

			return "board/listUpgrade";
		
		}
		
		
		
		
	
		
}