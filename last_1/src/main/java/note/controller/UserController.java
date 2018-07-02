package note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import note.entity.User;
import note.exception.PasswordException;
import note.exception.UsernameException;
import note.service.UserService;
import note.util.JsonResult;

@Controller
public class UserController {
@Autowired
private UserService userService;
	@RequestMapping("login.do")
	@ResponseBody
	public JsonResult login(String username,String password){
		
		User user=userService.login(username, password);
		user.setPassword("");
		return new JsonResult(user);
	}
	@ExceptionHandler
	@ResponseBody
	public JsonResult exp(Exception e){
		e.printStackTrace();
		if(e instanceof UsernameException){
			
			return new JsonResult(2,e);
		}
		if(e instanceof PasswordException){
			return new JsonResult(3,e);
		}
		
		return new JsonResult(e);
	}

}
