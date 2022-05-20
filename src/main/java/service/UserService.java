package service;

import java.sql.Connection;

import dao.UserDao;
import entity.User;
import util.DbUtil;
public class UserService {
    
    public int regUser(User user) {
        try (Connection conn = DbUtil.getConnection()) {
        	UserDao userDao = new UserDao(conn);
            return userDao.regUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }
    
    public User selectFromUser(String name) {
        try (Connection conn = DbUtil.getConnection()) {
        	UserDao userDao = new UserDao(conn);
        	return userDao.selectFromName(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
