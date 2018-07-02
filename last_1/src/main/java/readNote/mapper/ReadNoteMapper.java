package readNote.mapper;

import java.util.List;
import java.util.Map;

import readNote.vo.ReadNote;

public interface ReadNoteMapper {
	/**
	 * 获取笔记列表
	 */
	public List<ReadNote> getReadNoteList(Map<String,Object> pageInfo);
	
	/**
	 * 添加笔记
	 * @param readNote 笔记实体
	 */
	public int addReadNote(Map<String,Object> readNote);
	/**
	 * 删除笔记
	 * 2018年6月30日 author:wgt
	 * @param readNoteId 笔记id
	 * @return
	 */
	public int deleteReadNote(int readNoteId);
	
	/**
	 * 获取笔记详情
	 * 2018年6月30日 author:wgt
	 * @param readNoteId
	 * @return
	 */
	public ReadNote getReadNote(int readNoteId);

	/**
	 * 修改笔记
	 * 2018年6月30日 author:wgt
	 * @param newReadNote
	 * @return
	 */
	public int updateReadNote(Map<String,Object> newReadNote);
}
