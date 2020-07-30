package cn.jack.dao;

import java.sql.SQLException;

import cn.jack.bean.User;

public interface UserDao {
   
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username) throws SQLException;
	
	/**
	 * 根据电话号码查找用户
	 * @param phone
	 * @return
	 */
	User getUserByPhone(String phone) throws SQLException;
	
	/**
	 * 修改密码
	 * @param uid
	 * @param password
	 * @return
	 */
	void updatePassword(String uid,String password) throws SQLException;
	
	/**
	 * 根据uid查询用户
	 * @param uid
	 * @return
	 */
	User getUserByUid(String uid) throws SQLException;
	
	
	/**
	 * 添加一个用户
	 * @param user
	 * @return
	 */
	void addUser(User user) throws SQLException;
	
}
