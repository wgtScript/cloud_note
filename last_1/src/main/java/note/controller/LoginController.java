package note.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import note.util.JsonResult;

@Controller
public class LoginController {

	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("hello()");
		return "ok";
	}

	@RequestMapping("/hi.do")
	@ResponseBody
	public Object hi() {
		return new String[] { "haha", "hji" };
	}
	@RequestMapping("wgt.do")
	@ResponseBody
	public JsonResult wgt(){
		return new JsonResult();
	}
	
	
	
	
	
	
	
	
	
	
	
}
