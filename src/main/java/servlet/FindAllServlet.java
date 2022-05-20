package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.ProductService;

@WebServlet("/findAll")
public class FindAllServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 文字化け対策
        request.setCharacterEncoding("UTF-8");

        
        ProductService pdService = new ProductService();
        List<Product> list = pdService.findAll();

        // 表示メッセージの受け渡し
        if (list != null) {
            // メッセージ設定
            String msg ="<table border = \"1\"><tr><th>product_id</th><th>product_name</th><th>price</th></tr>";
            for(Product pd : list) {
    			msg += ("<tr><th>" + pd.getProductId() + "</th><th>" + pd.getProductName() + "</th><th>" + pd.getPrice() + "</th></tr><br>");
            }
        	
            msg += "</table>";
            
            request.setAttribute("msg", msg);
            
            // 次画面指定
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            // メッセージ設定
            request.setAttribute("msg", "productsテーブルがありません");

            // 次画面指定
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

}


