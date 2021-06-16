package org.example;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet
{
    public static final String LOGIN_ATTRIBUTE = "loginAttribute";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        HttpSession session = req.getSession(false);
        if (session == null)
        {
            session = req.getSession(true);
            session.setAttribute(LOGIN_ATTRIBUTE, UUID.randomUUID().toString());
        }
        resp.sendRedirect(req.getContextPath());
    }
}
