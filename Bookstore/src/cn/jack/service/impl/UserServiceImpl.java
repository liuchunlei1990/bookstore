package cn.jack.service.impl;

import java.sql.SQLException;

import cn.jack.bean.User;
import cn.jack.dao.UserDao;
import cn.jack.dao.impl.UserDaoImpl;
import cn.jack.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao dao = new UserDaoImpl();

	@Override
	public String loginByUsername(String username, String password) {
		User user = null;
		try {
			user = dao.getUserByUsername(username);
			if (user == null) {
				return "账号不存在";
			}
			if (!user.getPassword().equals(password)) {
				return "密码错误";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String loginByPhone(String phone) {
		User user = null;
		try {
			user = dao.getUserByPhone(phone);
			if (user == null) {
				return "手机未注册";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String register(User user) {
		// 1.验证账号是否存在
		User isExis = null;
		try {
			isExis = dao.getUserByUsername(user.getUsername());
			if (isExis != null) {
				return "账号已注册!";
			}
			isExis = dao.getUserByPhone(user.getPhone());
			if (isExis != null) {
				return "手机号已注册!";
			}
			dao.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updatePassword(String uid, String oldPassword, String newPassword) {
        User user = null;
		try {
			user = dao.getUserByUid(uid);
			if(!user.getPassword().equals(oldPassword)) {
				return "原密码错误！";
			}
			dao.updatePassword(uid, newPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean getUserByphone(String phone) {
		User user = null;
		try {
			user = dao.getUserByPhone(phone);
			if(user != null) {
			   return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return true;
	}

	@Override
	public boolean getUserByUsername(String username) {
		User user = null;
		try {
			user = dao.getUserByUsername(username);
			if(user !=null ) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		try {
			return dao.getUserByUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserPhone(String phone) {
		// TODO Auto-generated method stub
		try {
			return dao.getUserByPhone(phone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
