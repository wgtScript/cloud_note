package readNote.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import readNote.vo.ReadNote;

public interface ReadNoteMapper extends BaseMapper<ReadNote>{
	/**
	 * 获取笔记列表
	 */
	public List<ReadNote> getReadNoteList(Map<String,Object> pageInfo);
	
	public List<ReadNote> getReadNoteList(RowBounds rows, Map<String,Object> pageInfo);
	
	/**获取笔记书名*/
	public List<Map<String,Object>> getNoteName( @Param("col")String col);
}
