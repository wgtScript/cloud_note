package readNote.service;

import java.util.List;

import readNote.vo.ReadNote;

public interface ReadNoteService {
	/**
	 * 获取笔记列表
	 * @return
	 */
	public List<ReadNote> getReadNoteList(Integer start,
			Integer rows,String chapterNo,String teacherName,
			String noteName,String noteSummary);
	/**
	 * 添加笔记
	 * @param chapterNo
	 * @param teacherName
	 * @param noteName
	 * @param noteSummary
	 * @param content
	 * @return
	 */
	public int addReadNote(String chapterNo,String teacherName,
			String noteName,String noteSummary,String content);
}
