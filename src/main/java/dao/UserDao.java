package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class UserDao {

    private static final String SQL_INSERT= "INSERT INTO users (user_name, password) VALUES (?,?)";
    private static final String SQL_SELECT_FROM_NAME= "SELECT * FROM users where user_name = ?";
//    private static final String SQL_SERCH = "select count(*) count from users where user_name = ?";
    
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public int regUser(User user) {
//    	try (PreparedStatement stmt1 = connection.prepareStatement(SQL_SERCH)) {
//        	stmt1.setString(1, user.getuserName());
//            ResultSet rs = stmt1.executeQuery();
//            rs.next();
//        	int p = rs.getInt("count");
//        	if (p == 0) {
	        	try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
		        	//int idInt = Integer.parseInt(pass);
		        	stmt.setString(1, user.getUserName());
		            stmt.setString(2, user.getPassword());
		            return stmt.executeUpdate();
	        	} catch (SQLException e) {
	            throw new RuntimeException(e);
	        	}
//	        	 ResultSet rs = stmt.executeQuery();
//		            User index =  new User(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
//        	}else {return 0;}
//    	}catch (SQLException e) {
//            throw new RuntimeException(e);
//    	}	
    }
    
    public User selectFromName(String name) {
    	try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_FROM_NAME)) {
        	//int idInt = Integer.parseInt(pass);
        	stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            User a = null;
            while (rs.next()) {
            	a =  new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("password"));
            	
            }
        	return a;
    	} catch (SQLException e) {
        throw new RuntimeException(e);
    	}
    }
    
}