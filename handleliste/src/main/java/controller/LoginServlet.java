package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    static String HANDLELISTE_PASSORD;

    @Override
    public void init() throws ServletException {
        HANDLELISTE_PASSORD = getServletContext().getInitParameter("passord");
        System.out.println("set password: " + HANDLELISTE_PASSORD);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        if (password.equals(HANDLELISTE_PASSORD)) {
            session.setAttribute("loginInfo", "asfd");
            response.sendRedirect("handleliste");
        } else {
            session.setAttribute("message", "Feil brukernavn og/eller passord.");
            response.sendRedirect("login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
        dispatcher.forward(request, response);
    }
}
