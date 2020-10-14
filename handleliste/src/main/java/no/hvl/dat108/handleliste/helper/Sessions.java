package no.hvl.dat108.handleliste.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Sessions {

    public static boolean initialized;
    public static int TIMEOUT_SECONDS;

    public static boolean isLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("loginInfo") != null;
    }

    public static HttpSession getNewSession(HttpServletRequest request) {
        System.out.println("Timeout: " + TIMEOUT_SECONDS);
        HttpSession session = request.getSession(false);
        if (session != null)
            session.invalidate();
        session = request.getSession(true);
        session.setMaxInactiveInterval(TIMEOUT_SECONDS);
        return session;
    }
}
