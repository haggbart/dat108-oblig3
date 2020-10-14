package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static helper.Sessions.getNewSession;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    static String HANDLELISTE_PASSORD;

    @Override
    public void init() throws ServletException {
        HANDLELISTE_PASSORD = getServletContext().getInitParameter("passord");
        System.out.println("set password: " + HANDLELISTE_PASSORD);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String password = request.getParameter("password");
        HttpSession session = getNewSession(request);

        if (!password.equals(HANDLELISTE_PASSORD)) {
            session.setAttribute("message", "Feil passord");
            response.sendRedirect("login");
            return;
        }

        session.setAttribute("loginInfo", "asfd");
        response.sendRedirect("handleliste");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
        dispatcher.forward(request, response);
    }
}
