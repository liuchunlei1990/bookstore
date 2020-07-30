package cn.jack.service;

import cn.jack.bean.User;

public interface UserService {
  
	/**
	 * 根据用户+密码登录
	 * @param user
	 * @return
	 */
	String loginByUsername(String username,String password);
	
	/**
	 * 根据电话号码+验证码登录
	 * @return
	 */
	String loginByPhone(String phone);
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	String register(User user);
	
	/**
	 * 根据uid修改密码
	 * @param uid
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	String updatePassword(String uid,String oldPassword,String newPassword);
	
	/**
	 * 根据电话号码查找此电话是否注册
	 * @param phone
	 * @return
	 */
	boolean getUserByphone(String phone);
	
	/**
	 * 根据用户名查看此用户名是否注册
	 * @param username
	 * @return
	 */
	boolean getUserByUsername(String username);
	
	/**
	 * @param username
	 * @return
	 * 根据用户名获取用户对象
	 */
	User getUser(String username);
	
	User getUserPhone(String phone);
}
