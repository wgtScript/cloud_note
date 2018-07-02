package readNote.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
		Map<String, Object> pageInfo=new HashMap<String, Object>();
		pageInfo.put("teacherName", teacherName);
		pageInfo.put("noteName", noteName);
		pageInfo.put("noteSummary", noteSummary);
		pageInfo.put("chapterNo", chapterNo);
		pageInfo.put("start", start);
		pageInfo.put("rows", rows);
		return readNoteMapper.getReadNoteList(pageInfo);
		
	}
}
