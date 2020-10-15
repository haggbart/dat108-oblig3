package no.hvl.dat108.handleliste.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Sessions {

    public static boolean sessionExpired(HttpServletRequest request) {
        return request.getRequestedSessionId() != null && !request.isRequestedSessionIdValid();
    }

    public static boolean isLoggedIn(HttpSession session) {
        return (session != null && session.getAttribute("user") != null);
    }
}
