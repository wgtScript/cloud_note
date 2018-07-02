package note.dao;

import java.util.List;
import java.util.Map;

public interface NotebookDao {
	List<Map<String,Object>> findNotebookByUserId(Map<String,Object> user);

}
