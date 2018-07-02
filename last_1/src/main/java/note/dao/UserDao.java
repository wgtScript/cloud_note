package note.dao;

import note.entity.User;

public interface UserDao {
	User findUserByName(String name);
	
	User findUserById(String id);
}
