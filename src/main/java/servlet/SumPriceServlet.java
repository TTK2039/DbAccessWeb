package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductService;

@WebServlet("/sumPriceChan")
public class SumPriceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 文字化け対策
        request.setCharacterEncoding("UTF-8");

        // ログインチェック
        ProductService pdService = new ProductService();
        int a = pdService.sumPrice();

        // 表示メッセージの受け渡し
        if (a != 0) {
            // メッセージ設定
            
            request.setAttribute("msg", a);
            
            // 次画面指定
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            // メッセージ設定
            request.setAttribute("msg", "プライスレス！");

            // 次画面指定
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

}


