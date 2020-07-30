package cn.jack.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.jack.bean.User;
import cn.jack.dao.UserDao;
import cn.jack.util.JdbcUtil;

public class UserDaoImpl implements UserDao {
	QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

	@Override
	public User getUserByUsername(String username) throws SQLException {
		String sql = "select * from t_user  where username = ?";
		return qr.query(sql, new BeanHandler<User>(User.class), username);
	}

	@Override
	public User getUserByPhone(String phone) throws SQLException {
		String sql = "select * from t_user  where phone = ?";
		// 2.执行查询操作
		return qr.query(sql, new BeanHandler<User>(User.class), phone);

	}

	@Override
	public void updatePassword(String uid, String password) throws SQLException {
		String sql = "update t_user set `password` = ? where uid = ?";
		int num = qr.update(sql, password, uid);
	}

	@Override
	public User getUserByUid(String uid) throws SQLException {
		String sql = "select * from t_user  where uid = ?";
		return qr.query(sql, new BeanHandler<User>(User.class), uid);

	}

	@Override
	public void addUser(User user) throws SQLException {
		String sql = "insert t_user(uid,username,`password`,phone) value (?,?,?,?)";
		qr.update(sql, user.getUid(), user.getUsername(), user.getPassword(), user.getPhone());
	}

}
