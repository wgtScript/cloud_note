package note.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import note.entity.Activity;
import note.service.ActivityService;

@Controller
public class ActivityController {
	@Resource
	private ActivityService activityService;
	
	@RequestMapping("activity.do")
	//@ResponseBody
	public String activity(HttpServletRequest req){
		
		List<Activity> activitys=activityService.findAllActivity();
		req.setAttribute("activitys", activitys);
		//System.out.println(activitys);
/*		String a=null;
		a.length();*/
		
		return "activity";
	}
	@RequestMapping("detail.do")
	public String detail(String id){
		//System.out.println("detail.do()");
		return "activity_detail";
	}
	
	
	
}
