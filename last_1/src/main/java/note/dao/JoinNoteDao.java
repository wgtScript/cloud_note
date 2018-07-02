package note.dao;

import java.util.List;
import java.util.Map;

import note.entity.JoinNote;

public interface JoinNoteDao {
	List<JoinNote> findNoteByActivityId(int activityId);
	
	int addJoinNote(Map<String,Object> joinNote);
	
	List<Map<String,Object>> findNotesByUserId(String userId);
}
