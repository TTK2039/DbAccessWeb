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
import util.ParamUtil;

@WebServlet("/serch")
public class Serchservlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 文字化け対策
        request.setCharacterEncoding("UTF-8");

        // ログインID、パスワードを取得
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        // ログインチェック
        ProductService pdService = new ProductService();
        Product pd = null;
        List<Product> list = null;
        // 入力値のチェック
        if (ParamUtil.isNullOrEmpty(id) && ParamUtil.isNullOrEmpty(name)) {
            // メッセージ設定
            request.setAttribute("msg", "※product_id,product_nameのどちらかを入力しないと検索ができません！");

            // 次画面指定
            request.getRequestDispatcher("Serch.jsp").forward(request, response);
            return;
        }else if(ParamUtil.isNullOrEmpty(name)) {
        	pd = pdService.findProductId(id);
        }else if(ParamUtil.isNullOrEmpty(id)) {
        	list = pdService.findProductName(name);
        }else {
        	pd = pdService.findProductIDandName(id,name);
        }
        
        String msg ="";
        
        // 表示メッセージの受け渡し
        if(list != null) {
        	msg ="<table border = \"1\"><tr><th>product_id</th><th>product_name</th><th>price</th></tr>";
        	for(Product a :list) {
        		msg += ("<tr><th>" + a.getProductId() + "</th><th>" + a.getProductName() + "</th><th>" + a.getPrice() + "</th></tr><br>");
        	}
        	msg += "</table>";
        	
        	request.setAttribute("msg", msg);
        	
            request.getRequestDispatcher("Serch.jsp").forward(request, response);
        }
        
        if (pd != null) {
        // メッセージ設定
        
        msg ="<table border = \"1\"><tr><th>product_id</th><th>product_name</th><th>price</th></tr><tr><td>" + pd.getProductId()+ "</td><td>" + pd.getProductName()+ "</td><td>" + pd.getPrice() + "</td></tr></table>";
           
        request.setAttribute("msg", msg);
            
        // 次画面指定
        request.getRequestDispatcher("defaultResult.jsp").forward(request, response);
        	 
        	    
        }else {
    		// メッセージ設定
    		request.setAttribute("msg", "見つかりませんでした");
    		
    		// 次画面指定
    		request.getRequestDispatcher("Serch.jsp").forward(request, response);
        }
    }
}
    


