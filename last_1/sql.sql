show tables
 +----------------------+
| Tables_in_cloud_note |
+----------------------+
| cn_activity          |
| cn_activity_status   |
| cn_note              |
| cn_note_activity     |
| cn_note_status       |
| cn_note_type         |
| cn_notebook          |
| cn_notebook_type     |
| cn_share             |
| cn_user              |

desc cn_activity;
+----------------------+--------------+------+-----+---------+-------+
| Field                | Type         | Null | Key | Default | Extra |
+----------------------+--------------+------+-----+---------+-------+
| cn_activity_id       | varchar(100) | NO   | PRI | NULL    |       |
| cn_activity_title    | varchar(500) | YES  |     | NULL    |       |
| cn_activity_body     | text         | YES  |     | NULL    |       |
| cn_activity_end_time | bigint(20)   | YES  |     | NULL    |       |
+----------------------+--------------+------+-----+---------+-------+
desc cn_note_activity;-----------------------------------》》》》关联表。
+------------------------+--------------+------+-----+---------+-------+
| Field                  | Type         | Null | Key | Default | Extra |
+------------------------+--------------+------+-----+---------+-------+
| cn_note_activity_id    | varchar(100) | NO   | PRI | NULL    |       |
| cn_activity_id         | varchar(100) | YES  | MUL | NULL    |       |
| cn_note_id             | varchar(100) | YES  | MUL | NULL    |       |
| cn_note_activity_up    | int(11)      | YES  |     | NULL    |       |
| cn_note_activity_down  | int(11)      | YES  |     | NULL    |       |
| cn_note_activity_title | varchar(500) | YES  |     | NULL    |       |
| cn_note_activity_body  | text         | YES  |     | NULL    |       |

desc cn_activity_status;
+-------------------------+--------------+------+-----+---------+-------+
| Field                   | Type         | Null | Key | Default | Extra |
+-------------------------+--------------+------+-----+---------+-------+
| cn_activity_status_id   | varchar(100) | NO   | PRI | NULL    |       |
| cn_activity_id          | varchar(100) | YES  | MUL | NULL    |       |
| cn_activity_status_code | varchar(500) | YES  |     | NULL    |       |
| cn_activity_status_name | varchar(500) | YES  |     | NULL    |       |

desc cn_note;
+--------------------------+--------------+------+-----+---------+-------+
| Field                    | Type         | Null | Key | Default | Extra |
+--------------------------+--------------+------+-----+---------+-------+
| cn_note_id               | varchar(100) | NO   | PRI | NULL    |       |
| cn_notebook_id           | varchar(100) | YES  | MUL | NULL    |       |
| cn_user_id               | varchar(100) | YES  | MUL | NULL    |       |
| cn_note_status_id        | varchar(100) | YES  | MUL | NULL    |       |
| cn_note_type_id          | varchar(100) | YES  | MUL | NULL    |       |
| cn_note_title            | varchar(500) | YES  |     | NULL    |       |
| cn_note_body             | text         | YES  |     | NULL    |       |
| cn_note_create_time      | bigint(20)   | YES  |     | NULL    |       |
| cn_note_last_modify_time | bigint(20)   | YES  |     | NULL    |       |
+--------------------------+--------------+------+-----+---------+-------+

desc cn_note_status;
+---------------------+--------------+------+-----+---------+-------+
| Field               | Type         | Null | Key | Default | Extra |
+---------------------+--------------+------+-----+---------+-------+
| cn_note_status_id   | varchar(100) | NO   | PRI | NULL    |       |
| cn_note_status_code | varchar(100) | YES  |     | NULL    |       |
| cn_note_status_name | varchar(500) | YES  |     | NULL    |       |
+---------------------+--------------+------+-----+---------+-------+

select 
		n.cn_note_title title,
		n.cn_note_body body,
		n.cn_note_id noteId,
		n.cn_user_id userId
	from 
		cn_note n,cn_note_activity a
	where n.cn_note_id=a.cn_note_id
		and n.cn_user_id='39295a3d-cc9b-42b4-b206-a2e7fab7e77c'








































