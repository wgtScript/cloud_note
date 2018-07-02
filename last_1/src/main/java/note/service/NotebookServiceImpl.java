package note.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import note.dao.NotebookDao;
import note.exception.UserNotFoundException;

@Service("notebookService")
public class NotebookServiceImpl implements NotebookService {

	@Autowired
	private NotebookDao notebookDao;
	
	public List<Map<String, Object>> showNotebooks(String userId,Integer start,int rows) throws UserNotFoundException {
		if(userId==null||userId.trim().isEmpty()){
			throw new UserNotFoundException("用户id为空");
		}
		
		Map<String,Object> user =new HashMap<String,Object>();
		user.put("userId", userId);
		if(start!=null){
		
		user.put("start",start);
		user.put("rows", rows);
		}
	//	System.out.println(user);
		List<Map<String,Object>> notebooks=notebookDao.findNotebookByUserId(user);
	//	System.out.println(notebooks);
		if(notebooks==null){
			return null;
		}
		return notebooks;
	}

}
