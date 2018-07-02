package note.service;

import note.entity.User;
import note.exception.PasswordException;
import note.exception.UserNotFoundException;
import note.exception.UsernameException;

public interface UserService {
	User login(String username,String password)throws UsernameException,PasswordException,UserNotFoundException;

}
