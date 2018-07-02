package readNote.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class ReadNote implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2113509792155672086L;
	private int id;
	private String chapterNo;//章节号
	private String teacherName;//讲师名
	private String noteSummary;//笔记摘要（标题）
	private String noteContent;//笔记内容
	private String noteName;//书籍名
	private String remark;//备注
	private String enable;//是否可用
	private String createBy;
	private String updateBy;
	private Timestamp createTime;
	private Timestamp updateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChapterNo() {
		return chapterNo;
	}
	public void setChapterNo(String chapterNo) {
		this.chapterNo = chapterNo;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getNoteSummary() {
		return noteSummary;
	}
	public void setNoteSummary(String noteSummary) {
		this.noteSummary = noteSummary;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	public ReadNote() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ReadNote [id=" + id + ", chapterNo=" + chapterNo + ", teacherName=" + teacherName + ", noteSummary="
				+ noteSummary + ", noteContent=" + noteContent + ", noteName=" + noteName + ", remark=" + remark
				+ ", enable=" + enable + ", createBy=" + createBy + ", updateBy=" + updateBy + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}
	
	
	
	
}
