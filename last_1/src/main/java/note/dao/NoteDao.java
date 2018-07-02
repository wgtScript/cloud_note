package note.dao;

import java.util.List;
import java.util.Map;

import note.entity.Note;

public interface NoteDao {
	
	List<Note> findNotesByBookId(Map<String, Object> book);
	
	void updateNote(Map<String,Object> note);
	
	int deleteNote(String noteId);
}
