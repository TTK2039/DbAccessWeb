//package servlet;
//
//
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import entity.User;
//import service.UserService;
//
//@WebServlet("/insert")
//public class InsertServlet extends HttpServlet {
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 文字化け対策
//        request.setCharacterEncoding("UTF-8");
//
//        // 入力情報を取得
//        User user = new User(request.getParameter("id"), request.getParameter("name"), request.getParameter("pass"));
//
//        // ユーザーを登録
//        UserService userService = new UserService();
//        userService.register(user);
//
//        // userを設定
//        request.setAttribute("user", user);
//
//        // 次画面指定
//        request.getRequestDispatcher("insert_result.jsp").forward(request, response);
//    }
//
//}
