package readNote.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import readNote.mapper.ReadNoteMapper;
import readNote.vo.ReadNote;

@Service("readNoteService")
public class ReadNoteServiceImpl implements ReadNoteService{
	
	@Resource
	private ReadNoteMapper readNoteMapper;
	/**
	 * 获取笔记列表
	 * @return
	 */
	public List<ReadNote> getReadNoteList(Integer start,
			Integer rows,String chapterNo,String teacherName,
			String noteName,String noteSummary) {
		
		// 查询姓名为‘张三’的所有用户记录
/*		List<ReadNote> userList = readNoteMapper.selectList(new EntityWrapper<ReadNote>().eq("id_", "5"));
		
		return userList;*/
		Map<String, Object> pageInfo=new HashMap<String, Object>();
		pageInfo.put("teacherName", teacherName);
		pageInfo.put("noteName", noteName);
		pageInfo.put("noteSummary", noteSummary);
		pageInfo.put("chapterNo", chapterNo);
		pageInfo.put("start", start);
		pageInfo.put("rows", rows);
		return readNoteMapper.getReadNoteList(pageInfo);
		
	}
	@Transactional
	public int addReadNote(String chapterNo, String teacherName, String noteName, String noteSummary, String noteContent) {
		/*Map<String, Object> readNote=new HashMap<String, Object>();
		readNote.put("chapterNo", chapterNo);
		readNote.put("teacherName", teacherName);
		readNote.put("noteName", noteName);
		readNote.put("noteSummary", noteSummary);
		readNote.put("noteContent", noteContent);
		return readNoteMapper.addReadNote(readNote);*/
		int result=0;
		ReadNote readNote =new ReadNote();
		readNote.setChapterNo(chapterNo);
		readNote.setTeacherName(teacherName);
		readNote.setNoteName(noteName);
		readNote.setNoteSummary(noteSummary);
		readNote.setNoteContent(noteContent);
		try {
			result=readNoteMapper.insert(readNote);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public ReadNote getReadNote(Long id) {
		Map<String, Object> pageInfo=new HashMap<String, Object>();
		pageInfo.put("id", id);
		return readNoteMapper.getReadNoteList(pageInfo).get(0);
	}
}
