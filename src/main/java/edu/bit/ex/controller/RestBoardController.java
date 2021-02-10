package edu.bit.ex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//REST : Representational State Transfer
//�ϳ��� URI�� �ϳ��� ������ ���ҽ��� ��ǥ�ϵ��� ����� ����

//http://localhost/spring02/list?bno=1 ==> url+�Ķ����
//http://localhost/spring02/list/1 ==> url
//RestController�� ������ 4.0���� ����
//@Controller, @RestController �������� �޼��尡 ����Ǹ� ȭ����ȯ�� ����

@Log4j
@AllArgsConstructor
@RestController
@RequestMapping("/restful/*")
public class RestBoardController {

   private BoardService boardService;

    // 1. list(ó�� ���� ȭ���̹Ƿ� ȭ���� ���ڿ��� ��������Ƿ� @Controller������� ���� - veiw(ȭ��)�� ����
   @GetMapping("/board")
   public ModelAndView list(ModelAndView mav) {
      mav.setViewName("rest_list");
      mav.addObject("list", boardService.getList());

      return mav;
   }

   @GetMapping("/board/{bId}")
   public ModelAndView rest_content_view(BoardVO boardVO, ModelAndView mav ) {
	   
	   log.info("rest_content_view");
      mav.setViewName("rest_content_view");
      mav.addObject("content_view", boardService.getBoard(boardVO.getbId()));
      return mav;
   }
   
   @DeleteMapping("/board/{bId}")
   public ResponseEntity<String> rest_delete(BoardVO boardVO,Model model) {
      ResponseEntity<String> entity = null;
      log.info("rest_delete..");
      try {
         boardService.remove(boardVO.getbId());
            // ������ �����ϸ� ���� ���¸޽��� ����
            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // ��� ������ �����ϸ� ���� ���¸޽��� ����
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        // ���� ó�� HTTP ���� �޽��� ����
        return entity;

   }  
   
   //put ����
   @PutMapping("/board/{bId}")
   public ResponseEntity<String> rest_update(@RequestBody BoardVO boardVO, ModelAndView modelAndView) {

      ResponseEntity<String> entity = null;

      log.info("rest_update..");
      try {
         
         int rn = boardService.modify(boardVO);
         log.info("update �Ѿ�� ����:::::" + rn);
         entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
         
      } catch (Exception e) {
         e.printStackTrace();
         entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
      }
      
      return entity;
   
   }  

   
 
   

   
   
   
   
   /*
   @GetMapping("/board/{bId}")
   public ModelAndView rest_content_view(BoardVO boardVO, ModelAndView mav) {

      log.info("rest_content_view");
      mav.setViewName("rest/rest_content_view");
      mav.addObject("content_view", boardService.getBoard(boardVO.getbId()));
      return mav;
   }
   */
}
