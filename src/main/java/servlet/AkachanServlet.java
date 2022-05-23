package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.UserService;

@WebServlet("/akachan")
public class AkachanServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 文字化け対策
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("userName");
        String passStr = request.getParameter("userPass");

        String msg ="";
        
        
        //入力されているかどうか
        if(name == null || name.isEmpty() || passStr == null || passStr.isEmpty()) {
        	msg = "名前とパスワード両方を入力しないと登録ができません！";   
        	request.setAttribute("msg", msg);
            request.getRequestDispatcher("insert.jsp").forward(request, response);
        } else {
        	User user = new User(0, name, passStr);
//        	request.setAttribute("user", user);
        	UserService userService = new UserService();
            int a = userService.regUser(user);
            if(a == 1) {
            	msg = "登録しました！";
            	request.setAttribute("user", userService.selectFromUser(name));
                // 表示メッセージの受け渡し
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("insert_result.jsp").forward(request, response);
            }else if(a == 0) {
            	msg = "同じ名前のユーザーがすでにいます！";
            	request.setAttribute("msg", msg);
                request.getRequestDispatcher("insert.jsp").forward(request, response);

            }
        }

    }

}


