package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ProductDao {

    private static final String SQL_SELECT_PRODUCTID = "SELECT product_id, product_name, price FROM products WHERE product_id = ?";
    private static final String SQL_FIND_ALL = "SELECT * FROM products ORDER BY product_id";
    private static final String SQL_SUM_PRICE = "SELECT sum(price)  FROM products";
    private static final String SQL_INSERT = "INSERT INTO products (product_name, price) VALUES(?, ?)";
    private static final String SQL_DELETE_FROM_ID = "DELETE FROM products WHERE product_id = ?";
    private static final String SQL_DELETE_FROM_NAME = "DELETE FROM products WHERE product_name=?";
    
    private Connection connection;

    public ProductDao(Connection connection) {
        this.connection = connection;
    }

    public Product findByProductId(String id) {
        try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_PRODUCTID)) {
        	
        	int idInt = Integer.parseInt(id);
        	
            stmt.setInt(1, idInt);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Product> findAll () {
        List<Product> list = new ArrayList<>();
    	
    	try (PreparedStatement stmt = connection.prepareStatement(SQL_FIND_ALL)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	Product  a =  new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
                list.add(a);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int sumPrice () {
    	try (PreparedStatement stmt = connection.prepareStatement(SQL_SUM_PRICE)) {

            ResultSet rs = stmt.executeQuery();
            int sum = 0;
            while (rs.next()) {
                sum = rs.getInt("sum");
            }
            return sum;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int registerchan (Product pd) {
    	try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
    		
    		stmt.setString(1, pd.getProductName());
    		stmt.setInt(2, pd.getPrice());
    		
            return  stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int deleteFromID (Product pd) {
    	try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE_FROM_ID)) {
    		
    		stmt.setInt(1, pd.getProductId());
    		
            return  stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int deleteFromName (Product pd) {
    	try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE_FROM_NAME)) {
    		
    		stmt.setString(1, pd.getProductName());
    		
            return  stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

