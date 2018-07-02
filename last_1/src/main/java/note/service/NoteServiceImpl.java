package note.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import note.dao.NoteDao;
import note.entity.Note;
import note.exception.BookNotFoundException;
import note.exception.NoteNotFoundException;
@Service("noteService")
public class NoteServiceImpl implements NoteService{
	@Autowired
	private NoteDao noteDao;
	
	public List<Note> showNotes(String bookId,int start,String statusId,String userId) throws BookNotFoundException {
		Map<String,Object> book=new HashMap<String,Object>();
		//1表示  正常的，0 表示回收站的。
		if(statusId!="0"){
		book.put("bookId", bookId);
		if(bookId==null||bookId.trim().isEmpty()){
			throw new BookNotFoundException("笔记本id为空");
		}}
		book.put("start", start);
		book.put("rows", 20);
		book.put("statusId", statusId);
		book.put("userId",userId);
		
		List<Note> list=noteDao.findNotesByBookId(book);
		//System.out.println(list);
		if(list==null){
			throw new BookNotFoundException("没有该笔记本");
		}
		return list;
	}

	public boolean updateNote(Map<String, Object> note) throws NoteNotFoundException {
	//	System.out.println(note);
		Object noteId=note.get("noteId");
	//	System.out.println(noteId);
		if(noteId==null){
			return false;
		}
		noteDao.updateNote(note);
		
		return true;
	}

	public boolean deleteNote(String noteId) throws NoteNotFoundException {
		if(noteId==null){
			throw new NoteNotFoundException("笔记id为空，找不到笔记");
		}
		int i=noteDao.deleteNote(noteId);
		if(i==1){
			return true;
		}
		return false;
	}

	public boolean toReplay(String noteId) {
		if(noteId==null){
			return false;
		}
		Map<String,Object> note=new HashMap<String,Object>();
		note.put("noteId",noteId);
		//1表示  正常的，0 表示回收站的。
		note.put("statusId","1");
		
		noteDao.updateNote(note);
		
		return true;
	}

	public boolean toRollback(String noteId) {
		if(noteId==null){
			return false;
		}
		Map<String,Object> note=new HashMap<String,Object>();
		note.put("noteId",noteId);
		//1表示  正常的，0 表示回收站的。
		note.put("statusId","0");
		noteDao.updateNote(note);
		return true;
	}

}
