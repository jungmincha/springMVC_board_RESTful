package edu.bit.ex.controller;

import java.util.List; 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//spring v4.0 ?��?�� �??�� @RestController?��?�� ?��?��?��?��?��?�� 추�??��?�� ?��?�� Controller?�� 모든 메서?��?�� 리턴???��?�� 기존�? ?��르게 처리?��?��?��것을 명시
@Log4j
@AllArgsConstructor
@RestController
@Controller
public class RestBoardSpring4AfterController {

	private BoardService boardService;

	@RequestMapping("/rest/after")
	public List<BoardVO> after() {

		log.info("/rest/after");
		List<BoardVO> list = boardService.getList();

		return list;
	}
	
   


}
