package note.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import note.service.NotebookService;
import note.util.JsonResult;

@Controller
public class NotebookController extends BaseController{
@Autowired
private NotebookService notebookService;
@RequestMapping("showNoteBooks.do")
@ResponseBody
public JsonResult<List<Map<String, Object>>> showBooks(String userId,Integer start){
	
	int rows=5;
	/*if(start==null){
		rows=20;
		start=0;
	}*/

	
	List<Map<String,Object>> books=notebookService.showNotebooks(userId,start,rows);
	return new JsonResult<List<Map<String, Object>>>(books);
}
}
