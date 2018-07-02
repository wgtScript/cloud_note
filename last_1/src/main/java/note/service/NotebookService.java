package note.service;

import java.util.List;
import java.util.Map;

import note.exception.UserNotFoundException;

public interface NotebookService {
	List<Map<String,Object>> showNotebooks(String userId,Integer start,int rows) throws UserNotFoundException;
}
