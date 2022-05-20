package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.ProductService;

@WebServlet("/registerchan")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 文字化け対策
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("registerName");
        String priceStr = request.getParameter("registerprice");

        String msg ="";
        
        //入力されているかどうか
        if(name == null || name.isEmpty() || priceStr == null || priceStr.isEmpty()) {
        	msg = "nameとprice両方を入力しないと登録ができません！";  
            // 表示メッセージの受け渡し
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("insertPd.jsp").forward(request, response);
        } else {
            int price = Integer.parseInt(priceStr);
            Product pd = new Product(0, name, price);
        	ProductService pdService = new ProductService();
            pdService.register(pd);
            msg = "登録しました";
            // 表示メッセージの受け渡し
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("insertPd_result.jsp").forward(request, response);
        }

    }

}


