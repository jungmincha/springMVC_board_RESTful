package edu.bit.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.ex.mapper.LoginMapper;
import edu.bit.ex.page.Criteria;
import edu.bit.ex.page.PageVO;
import edu.bit.ex.service.BoardService;
import edu.bit.ex.service.LoginService;
import edu.bit.ex.vo.BoardVO;
import edu.bit.ex.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class LoginController {
	
	private LoginService loginService;

	   @GetMapping("/")
	   public String home() {
	      log.info("home...");
	      return "login";

	   }

	   @PostMapping("/login")
	   public String login(HttpServletRequest req, RedirectAttributes rttr) {

	      log.info("post login..");
	      String id = req.getParameter("id");
	      String pw = req.getParameter("pw");

	      // Session ó���� ���� Session ��ü HttpServletRequest �ȿ� ����
	      HttpSession session = req.getSession();

	      UserVO user = loginService.loginUser(id, pw);

	      if (user == null) {
	         session.setAttribute("user", null);
	         /*
	          * Spring3 ���� �����ϴ� RedirectAttributes�� ����ϸ� redirect post ������ �����մϴ�.
	          * 
	          * ������ ��ȸ���Դϴ�. ���ΰ�ħ�ϸ� ���󰡴� �������̹Ƿ� �������� ���� ���/�Ұ��� �Ǵ��� �� �ϼž� �Ұ� �����ϴ�.
	          */
	         rttr.addFlashAttribute("msg", false);
	      } else {
	         session.setAttribute("user", user);
	      }

	      return "redirect:/";

	   }

	   // �α׾ƿ�
	   @RequestMapping(value = "/logout")
	   public String logout(HttpSession session) throws Exception {
	      log.info("/member/logout");

	      session.invalidate();

	      return "redirect:/";
	   }
}