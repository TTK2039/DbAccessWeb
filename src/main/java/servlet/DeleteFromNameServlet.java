package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.ProductService;

@WebServlet("/deleteFromName")
public class DeleteFromNameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 文字化け対策
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("name");

        String msg ="";
        
        //入力されているかどうか
        if(name == null || name.isEmpty()) {
        	msg = "nameを入力しないと削除ができません！";  
            // 表示メッセージの受け渡し
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("deletePd.jsp").forward(request, response);
        } else {
            Product pd = new Product(0, name, 0);
        	ProductService pdService = new ProductService();
            int a = pdService.deleteFromName(pd);
            if(a == 1) {
            	msg = "削除しました！";
                // 表示メッセージの受け渡し
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("deletePd_result.jsp").forward(request, response);
            }else if(a == 0) {
            	msg = "そのnameが存在しません";
            	request.setAttribute("msg", msg);
                request.getRequestDispatcher("deletePd.jsp").forward(request, response);

            }
        }

    }

}


