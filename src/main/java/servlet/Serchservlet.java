package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.ProductService;
import util.ParamUtil;

@WebServlet("/serch")
public class Serchservlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 文字化け対策
        request.setCharacterEncoding("UTF-8");

        // ログインID、パスワードを取得
        String id = request.getParameter("id");

        // 入力値のチェック
        if (ParamUtil.isNullOrEmpty(id)) {
            // メッセージ設定
            request.setAttribute("msg", "product_idを入力しないと検索ができません！");

            // 次画面指定
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        // ログインチェック
        ProductService pdService = new ProductService();
        Product pd = pdService.findProductId(id);

        // 表示メッセージの受け渡し
        if (pd != null) {
            // メッセージ設定

            String msg ="product_id :" + pd.getProductId()+ " product_name :" + pd.getProductName()+ " price :" + pd.getPrice();
            
            request.setAttribute("msg", msg);
            
            // 次画面指定
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            // メッセージ設定
            request.setAttribute("msg", "見つかりませんでした");

            // 次画面指定
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

}


