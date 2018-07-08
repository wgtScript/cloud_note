package readNote.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;

import readNote.vo.ReadNote;

public interface ReadNoteService {
	/**
	 * 获取笔记列表
	 * @return
	 */
	public List<ReadNote> getReadNoteList(Integer start,
			Integer rows,String chapterNo,String teacherName,
			String noteName,String noteSummary);
	
	
	public Page<ReadNote> getNotePage(Map<String,Object> params);
	/**
	 * 添加笔记
	 * @param chapterNo
	 * @param teacherName
	 * @param noteName
	 * @param noteSummary
	 * @param content
	 * @return
	 */
	public int addReadNote(String id,String chapterNo,String teacherName,
			String noteName,String noteSummary,String content);
	
	/**
	 * 获取笔记
	 * @param id
	 * @return
	 */
	public ReadNote getReadNote(Long id);
	
	public int deleteReadNote(Long id);
	
	
}
