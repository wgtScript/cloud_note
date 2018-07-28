package readNote.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;

import note.controller.BaseController;
import note.util.JsonResult;
import readNote.service.ReadNoteService;
import readNote.vo.ReadNote;

@Controller
@ResponseBody
public class ReadNoteController extends BaseController{
	@Resource
	private ReadNoteService readNoteService;
	//http://localhost:8080/last_1/getReadNoteList.do
	//@ApiOperation(value = "获取笔记列表")
	@RequestMapping("getReadNoteList.do")
	public Map<String,Object> getReadNoteList(Integer page,
			Integer rows,String chapterNo,String teacherName,
			String noteName,String noteSummary,String sort,String order){
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("page", page);
		params.put("rows", rows);
		params.put("sort", sort);
		params.put("order",order);
		params.put("chapterNo",chapterNo);
		params.put("noteName",noteName);
		params.put("teacherName", teacherName);
		params.put("noteSummary", noteSummary);
		
		Page<ReadNote> pa = readNoteService.getNotePage(params);
		Map<String,Object> dataMap=new HashMap<String,Object>();
		dataMap.put("rows", pa.getRecords());
		dataMap.put("total", pa.getTotal());
		return dataMap;
	}

	//http://localhost:8080/last_1/addReadNote.do
	//@ApiOperation(value = "添加笔记")
	@RequestMapping("addReadNote.do")
	public JsonResult addReadNote(String id,String chapterNo,String teacherName,
			String noteName,String noteSummary,String noteContent){
		//List<ReadNote> list=readNoteService.getReadNoteList(start,rows,chapterNo,teacherName,noteName,noteSummary);

		//(T data,int totalPage,int currentPage,int numPerPage,int nextPage,int previousPage)
		System.out.println("noteContent:"+noteContent);
		int statuCode;
		String message,title;
		if(StringUtils.isBlank(noteName)) {
			statuCode=300;
			message="操作失败,书名不能为空！";
			title="操作提示";
		}else {
			int i=readNoteService.addReadNote(id,chapterNo, teacherName, noteName, noteSummary, noteContent);
			if(i>0) {
				statuCode=200;
				message="恭喜你，操作成功！当statusCode为200时，返回成功提示信息。";
				title="操作提示";
			}else {
				statuCode=300;
				message="恭喜你，操作失败！当statusCode为300时，返回失败提示信息。";
				title="操作提示";
			}
		}
		return new JsonResult(statuCode,title,message);
	}
	
	//http://localhost:8080/last_1/getReadNote.do
	//@ApiOperation(value = "获取笔记")
	@RequestMapping("getReadNote2.do")
	public ReadNote getReadNote2(Long id) {
		ReadNote readNote=readNoteService.getReadNote(id);
		return readNote;
	}
	
	//http://localhost:8080/last_1/deleteReadNote.do
	//@ApiOperation(value = "删除笔记")
	@RequestMapping("deleteReadNote.do")
	public Map<String,Object> deleteReadNote(Long id){
		int statuCode;
		String message,title;
		int i=readNoteService.deleteReadNote(id);
		if(i>0) {
			statuCode=200;
			message="恭喜你，删除成功";
			title="操作提示";
		}else {
			statuCode=300;
			message="恭喜你，删除失败";
			title="操作提示";
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("statuCode", statuCode);
		map.put("message", message);
		map.put("title", "操作提示");
		return map;
	}
	@RequestMapping("getNoteName.do")
	public List<Map<String,Object>> getNoteName(String col){
		if(StringUtils.isNotBlank(col))	{
			return readNoteService.getNoteName(col);
		}
		return null;
	}
	
	
}
