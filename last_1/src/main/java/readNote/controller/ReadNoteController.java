package readNote.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import note.controller.BaseController;
import note.util.JsonResult;
import readNote.service.ReadNoteService;
import readNote.vo.ReadNote;

@Controller
public class ReadNoteController extends BaseController{
	@Resource
	private ReadNoteService readNoteService;
	
	//http://localhost:8080/last_1/getReadNoteList.do
	@RequestMapping("getReadNoteList.do")
	@ResponseBody
	public JsonResult getReadNoteList(Integer start,
			Integer rows,String chapterNo,String teacherName,
			String noteName,String noteSummary){
		List<ReadNote> list=readNoteService.getReadNoteList(start,rows,chapterNo,teacherName,noteName,noteSummary);
		
		//(T data,int totalPage,int currentPage,int numPerPage,int nextPage,int previousPage)
		return new JsonResult(list,1);
	}
	
	
	
	
	
	
	
	
}
