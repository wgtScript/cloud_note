package note.entity;

import java.io.Serializable;

public class JoinNote implements Serializable {
	private static final long serialVersionUID = 3701858708241851756L;
	private String id;
	private String activityId;
	private String noteId;
	private Integer up;
	private Integer down;
	private String title;
	private String body;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getNoteId() {
		return noteId;
	}

	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}

	public Integer getUp() {
		return up;
	}

	public void setUp(Integer up) {
		this.up = up;
	}

	public Integer getDown() {
		return down;
	}

	public void setDown(Integer down) {
		this.down = down;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public JoinNote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JoinNote(String id, String activityId, String noteId, Integer up, Integer down, String title, String body) {
		super();
		this.id = id;
		this.activityId = activityId;
		this.noteId = noteId;
		this.up = up;
		this.down = down;
		this.title = title;
		this.body = body;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JoinNote other = (JoinNote) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
