package note.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import note.entity.Note;
import note.exception.BookNotFoundException;
import note.service.NoteService;
import note.util.JsonResult;

@Controller
public class NoteController extends BaseController{
@Resource
private NoteService noteService;
@RequestMapping("loadNotes.do")
@ResponseBody
public JsonResult loadNotes(String bookId,int start) throws BookNotFoundException {
	//1表示  正常的，0 表示回收站的。
	String statusId="1";
	List<Note> notes=noteService.showNotes(bookId,start,statusId,null);
	
	return new JsonResult(notes);
}
@RequestMapping("deleteNote.do")
@ResponseBody
public JsonResult deleteNote(String noteId){
	Map<String,Object> note=new HashMap<String,Object>();
	note.put("noteId", noteId);
	//0表示  删除的，  1表示显示。
	note.put("statusId", "0");
	note.put("lastModifyTime", System.currentTimeMillis());
	boolean pass=noteService.updateNote(note);
	if(pass==false){
		return new JsonResult("删除失败");
	}
	return new JsonResult("删除成功");
}
@RequestMapping("loadDeleteNote.do")
@ResponseBody
public JsonResult loadDeleteNotes(int start,String userId) throws BookNotFoundException {
	//1表示  正常的，0 表示回收站的。
	String statusId="0";
	List<Note> notes=noteService.showNotes(null,start,statusId,userId);
	
	return new JsonResult(notes);
}
@RequestMapping("sureDeleteNote.do")
@ResponseBody
public JsonResult sureDeleteNote(String noteId){
	boolean b=noteService.deleteNote(noteId);
	if(b==false){
		return new JsonResult("删除失败");
	}
	return new JsonResult("删除成功");
}

@RequestMapping("toReplay.do")
@ResponseBody
public JsonResult toReplay(String noteId){
	boolean b=noteService.toReplay(noteId);
	if(b==false){
		return new JsonResult("没有成功还原");
	}
	return new JsonResult("成功恢复");
}
@RequestMapping("toRollback.do")
@ResponseBody
public JsonResult toRollback(String noteId){
	boolean b=noteService.toRollback(noteId);
	if(b==false){
		return new JsonResult("没有移到回收站");
	}
	return new JsonResult("成功移到回收站");
}
















}
