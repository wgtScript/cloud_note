package note.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import note.dao.UserDao;
import note.entity.User;
import note.exception.PasswordException;
import note.exception.UserNotFoundException;
import note.exception.UsernameException;
import note.util.CodeMd5;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserDao userDao;
	
	public User login(String username, String password) throws UsernameException,PasswordException,UserNotFoundException {
		if(username==null||username.trim().isEmpty()){
			throw new UsernameException("用户id为空");
		}
		//正则表达式
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("密码不能为空");
		}
		
		User user=userDao.findUserByName(username);
		if(user==null){
			throw new UserNotFoundException("查无此人");
		}
		if(!user.getPassword().equals(CodeMd5.crypt(password))){
			throw new PasswordException("用户名或者密码错误");
		}
		
		return user;
	}

}
