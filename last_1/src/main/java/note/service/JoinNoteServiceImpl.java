package note.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import note.dao.JoinNoteDao;
import note.dao.UserDao;
import note.entity.JoinNote;
import note.entity.User;
import note.exception.ActivityException;
import note.exception.ActivityNotFoundException;
import note.exception.NoteException;
import note.exception.UserNotFoundException;
@Service("joinNoteService")
public class JoinNoteServiceImpl implements JoinNoteService{
	@Autowired
	private JoinNoteDao joinNoteDao;
	@Resource
	private UserDao userDao;
	public List<JoinNote> findAllJoinNote(String activityId) throws ActivityNotFoundException {
		if(activityId==null||activityId.trim().isEmpty()){
			throw new ActivityNotFoundException("没有该活动");
		}
		int id=Integer.valueOf(activityId);
		List<JoinNote> list=joinNoteDao.findNoteByActivityId(id);
		if(list==null){
			throw new ActivityNotFoundException("没有笔记参加该活动");
		}
		return list;
	}

	public Map<String,Object> addJoinNote(String activityId, String noteId, String title, String body) throws ActivityException,NoteException{
		if(activityId==null||activityId.trim().isEmpty()){
			throw new ActivityException("活动id为空");
		}
		if(noteId==null||noteId.trim().isEmpty()){
			throw new NoteException("笔记id为空");
		}
		//findById!!!
		
		/*JoinNote joinNote =new JoinNote(UUID.randomUUID().toString(), activityId, noteId, 0, 0, title, body);	*/
		Map<String,Object> joinNote=new HashMap<String,Object>();
		joinNote.put("activityId", activityId);
		joinNote.put("noteId", noteId);
		joinNote.put("id", UUID.randomUUID().toString());
		System.out.println(joinNote.get("id"));
		joinNote.put("title", title);
		joinNote.put("body", body);
		joinNote.put("up", 0);
		joinNote.put("down", 0);
		
		int i=joinNoteDao.addJoinNote(joinNote);
		if(i!=1){
			return null;
		}
		return joinNote;
	}

	public List<Map<String, Object>> findUserJoinNotes(String userId) throws UserNotFoundException {
		if(userId==null||userId.trim().isEmpty()){
			throw new  UserNotFoundException("用户id 为空");
		}
		User user=userDao.findUserById(userId);
		if(user==null){
			throw new UserNotFoundException("没有该用户");
		}
		
		List<Map<String,Object>> list=joinNoteDao.findNotesByUserId(userId);
		
		
		return list;
	}
	
	
}
