package edu.bit.ex.service;

import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.LoginMapper;
import edu.bit.ex.vo.UserVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginService {   

   LoginMapper loginMapper;
   
   public UserVO loginUser(String id,String pw)  {
      return loginMapper.logInUser(id,pw) ;
   }

}
