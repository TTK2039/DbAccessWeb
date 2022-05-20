package service;

import java.sql.Connection;
import java.util.List;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;
public class ProductService {

    public Product findProductId(String id) {
        try (Connection conn = DbUtil.getConnection()) {
        	ProductDao pdDao = new ProductDao(conn);
        	Product pd = pdDao.findByProductId(id);

            return pd;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public List<Product> findAll() {
        try (Connection conn = DbUtil.getConnection()) {
        	ProductDao pdDao = new ProductDao(conn);
            List<Product> a = pdDao.findAll();

            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public int sumPrice() {
        try (Connection conn = DbUtil.getConnection()) {
        	ProductDao pdDao = new ProductDao(conn);
            int a = pdDao.sumPrice();

            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }   

    public int register(Product pd) {
        try (Connection conn = DbUtil.getConnection()) {
        	ProductDao pdDao = new ProductDao(conn);
            return pdDao.registerchan(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    
    public int deleteFromID(Product pd) {
        try (Connection conn = DbUtil.getConnection()) {
        	ProductDao pdDao = new ProductDao(conn);
            return pdDao.deleteFromID(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    
    public int deleteFromName(Product pd) {
        try (Connection conn = DbUtil.getConnection()) {
        	ProductDao pdDao = new ProductDao(conn);
            return pdDao.deleteFromName(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }


}
