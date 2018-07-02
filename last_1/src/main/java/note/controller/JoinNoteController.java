package note.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import note.entity.JoinNote;
import note.service.JoinNoteService;
import note.util.JsonResult;

@Controller
public class JoinNoteController extends BaseController {
	@Autowired
	private JoinNoteService joinNoteService;
	
	@RequestMapping("showJoinNote.do")
	@ResponseBody
	public JsonResult showJoinNote(String id){
		List<JoinNote> list=joinNoteService.findAllJoinNote(id);
		return new JsonResult(list);
	}
	@RequestMapping("addJoinNote.do")
	@ResponseBody
	public JsonResult addJoinNote(String activityId,String noteId,String title,String body){
		Map<String,Object> joinNote=joinNoteService.addJoinNote(activityId, noteId, title, body);
		//joinNote.remove("id");
		return new JsonResult (joinNote);
	}
	
	@RequestMapping("showUserJoinNotes.do")
	@ResponseBody
	public JsonResult showUserJoinNotes(String userId){
		
		
		List<Map<String,Object>> list=joinNoteService.findUserJoinNotes(userId);
		
		return new JsonResult(list);
	}
	
	
	
	
}
