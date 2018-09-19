package service;

import java.util.List;

import dao.UserDAO;
import vo.UserInfo;

public class UserService {

/*	UserDAO udao = new UserDAO();
	
	public List<UserInfo> getUserInfoList(){
		
		return udao.selectUserInfiList();
	}
}
*/

	UserDAO udao = new UserDAO();
	
	public List<UserInfo> getUserInfoList(){
		return udao.selectUserInfiList();
	}
}
