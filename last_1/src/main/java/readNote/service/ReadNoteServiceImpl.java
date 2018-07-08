package readNote.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import readNote.mapper.ReadNoteMapper;
import readNote.vo.ReadNote;

@Service("readNoteService")
public class ReadNoteServiceImpl extends BaseService implements ReadNoteService {

	@Resource
	private ReadNoteMapper readNoteMapper;

	/**
	 * 获取笔记列表
	 * 
	 * @return
	 */
	public List<ReadNote> getReadNoteList(Integer start, Integer rows, String chapterNo, String teacherName,
			String noteName, String noteSummary) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		pageInfo.put("teacherName", teacherName);
		pageInfo.put("noteName", noteName);
		pageInfo.put("noteSummary", noteSummary);
		pageInfo.put("chapterNo", chapterNo);
		pageInfo.put("start", start);
		pageInfo.put("rows", rows);
		return readNoteMapper.getReadNoteList(pageInfo);

	}

	@Transactional
	public int addReadNote(String id, String chapterNo, String teacherName, String noteName, String noteSummary,
			String noteContent) {

		int result = 0;
		ReadNote readNote = new ReadNote();
		readNote.setChapterNo(chapterNo);
		readNote.setTeacherName(teacherName);
		readNote.setNoteName(noteName);
		readNote.setNoteSummary(noteSummary);
		readNote.setNoteContent(noteContent);

		readNote.setEnable(1);
		Long createMan = Long.valueOf(1);
		Date now = new Date();

		readNote.setUpdateBy(createMan);
		readNote.setUpdateTime(now);
		if (StringUtils.isNotBlank(id)) {
			readNote.setId(Long.valueOf(id));
			result = readNoteMapper.updateById(readNote);
		} else {
			readNote.setCreateBy(createMan);
			readNote.setCreateTime(now);
			result = readNoteMapper.insert(readNote);
		}
		return result;
	}

	public ReadNote getReadNote(Long id) {
		//Map<String, Object> pageInfo = new HashMap<String, Object>();
		//pageInfo.put("id", id);
		//return readNoteMapper.getReadNoteList(pageInfo).get(0);
		//readNoteMapper.selectById(id);
		return readNoteMapper.selectById(id);
	}

	/**
	 * 获取分页list
	 */
	public Page<ReadNote> getNotePage(Map<String, Object> params) {
		Page<ReadNote> page = getPageHelper(params);
		page.setAsc(false);  //默认是true
		List<ReadNote> list = readNoteMapper.getReadNoteList(page, params);
		page.setRecords(list);
		return page;
	}
	
	
	public int deleteReadNote(Long id) {
		return readNoteMapper.deleteById(id);
	}
}
