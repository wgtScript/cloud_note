package readNote.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;


@TableName("read_note")
public class ReadNote implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2113509792155672086L;
	@TableId(value = "id_", type = IdType.AUTO)
	private long id;
	@TableField("charpter_no")
	private String chapterNo;//章节号
	@TableField("teacher_name")
	private String teacherName;//讲师名
	@TableField("note_summary")
	private String noteSummary;//笔记摘要（标题）
	@TableField("note_content")
	private String noteContent;//笔记内容
	@TableField("note_name")
	private String noteName;//书籍名
	
	
	@TableField("enable_")
	private Integer enable;
	@TableField("remark_")
	private String remark;
	@TableField("create_by")
	private Long createBy;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	@TableField("create_time")
	private Date createTime;
	@TableField("update_by")
	private Long updateBy;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	@TableField("update_time")
	private Date updateTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public ReadNote() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ReadNote [id=" + id + ", chapterNo=" + chapterNo + ", teacherName=" + teacherName + ", noteSummary="
				+ noteSummary + ", noteContent=" + noteContent + ", noteName=" + noteName + ", enable=" + enable
				+ ", remark=" + remark + ", createBy=" + createBy + ", createTime=" + createTime + ", updateBy="
				+ updateBy + ", updateTime=" + updateTime + "]";
	}
	
	
	
	
	
}
