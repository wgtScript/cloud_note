package note.service;

import java.util.List;
import java.util.Map;

import note.entity.JoinNote;
import note.exception.ActivityException;
import note.exception.ActivityNotFoundException;
import note.exception.NoteException;
import note.exception.UserNotFoundException;

public interface JoinNoteService {
	List<JoinNote> findAllJoinNote(String activityId) throws ActivityNotFoundException;
	
	Map<String,Object> addJoinNote(String activityId,String noteId,String title,String body) throws ActivityException,NoteException;
	
	List<Map<String,Object>> findUserJoinNotes(String userId) throws UserNotFoundException;
	
	
}
