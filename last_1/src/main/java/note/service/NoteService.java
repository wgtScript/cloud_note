package note.service;

import java.util.List;
import java.util.Map;

import note.entity.Note;
import note.exception.BookNotFoundException;
import note.exception.NoteNotFoundException;

public interface NoteService {

	List<Note> showNotes(String bookId,int start,String statusId,String userId) throws BookNotFoundException;
	
	boolean updateNote(Map<String,Object> note)throws NoteNotFoundException;
	
	boolean deleteNote(String noteId) throws NoteNotFoundException;
	
	boolean toReplay(String noteId);
	
	boolean toRollback(String noteId);
}
