package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.ProductService;

@WebServlet("/deleteFromID")
public class DeleteIDServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 文字化け対策
        request.setCharacterEncoding("UTF-8");
        
        String idStr = request.getParameter("id");
        
        String msg ="";
        
        //入力されているかどうか
        if(idStr == null || idStr.isEmpty()) {
        	msg = "product_idを入力しないと削除ができません！";     
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            int id = Integer.parseInt(idStr);
            Product pd = new Product(id, "", 0);
        	ProductService pdService = new ProductService();
        	int a = pdService.deleteFromID(pd);
        	if(a == 1) {
            	msg = "削除しました！";
                // 表示メッセージの受け渡し
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else if(a == 0) {
            	msg = "そのidは存在しません！";
            	request.setAttribute("msg", msg);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            }
        }
    }
}


