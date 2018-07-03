package readNote.controller;

import java.util.ArrayList;
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
	//@ApiOperation(value = "获取笔记列表")
	@RequestMapping("getReadNoteList.do")
	@ResponseBody
	public JsonResult getReadNoteList(Integer start,
			Integer rows,String chapterNo,String teacherName,
			String noteName,String noteSummary){
		List<ReadNote> list=readNoteService.getReadNoteList(start,rows,chapterNo,teacherName,noteName,noteSummary);
		
		//(T data,int totalPage,int currentPage,int numPerPage,int nextPage,int previousPage)
		return new JsonResult(list,1);
	}
	
	//http://localhost:8080/last_1/addReadNote.do
	//@ApiOperation(value = "添加笔记")
	@RequestMapping("addReadNote.do")
	@ResponseBody
	public JsonResult addReadNote(String chapterNo,String teacherName,
			String noteName,String noteSummary,String content){
		//List<ReadNote> list=readNoteService.getReadNoteList(start,rows,chapterNo,teacherName,noteName,noteSummary);
		
		//(T data,int totalPage,int currentPage,int numPerPage,int nextPage,int previousPage)
		System.out.println("content:"+content);
		
		int i=readNoteService.addReadNote(chapterNo, teacherName, noteName, noteSummary, content);
		int statuCode;
		String message,title;
		if(i>0) {
			 statuCode=200;
			 message="恭喜你，操作成功！当statusCode为200时，返回成功提示信息。";
			 title="操作提示";
		}else {
			statuCode=300;
			 message="恭喜你，操作失败！当statusCode为300时，返回失败提示信息。";
			 title="操作提示";
		}
		return new JsonResult(statuCode,title,message);
	}
	
	
	
	
	
	
}
