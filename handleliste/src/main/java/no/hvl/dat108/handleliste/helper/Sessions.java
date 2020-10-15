package no.hvl.dat108.handleliste.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Sessions {

    public static boolean initialized;

    public static boolean isLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("user") != null;
    }

//    public static HttpSession getNewSession(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        if (session != null)
//            session.invalidate();
//        session = request.getSession(true);
//        return session;
//    }
}
