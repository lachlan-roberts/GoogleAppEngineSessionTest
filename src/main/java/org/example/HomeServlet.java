package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();


        writer.println("<h1>Home Page</h1>");
        writer.println("<a href=\"" + req.getContextPath() + "/login\">Create Session</a><br>");
        writer.println("<a href=\"" + req.getContextPath() + "/logout\">Invalidate Session</a><br>");
        writer.println("<br>");

        HttpSession session = req.getSession(false);
        if (session == null)
        {
            writer.println("Session has not been created.");
        }
        else
        {
            String attributeName = LoginServlet.LOGIN_ATTRIBUTE;
            String attributeValue = (String)session.getAttribute(attributeName);
            writer.println(String.format("SessionAttribute{name:%s, value:%s}", attributeName, attributeValue));
        }

        writer.println("<hr><h3><u>Session Listener Log</u></h3>");
        writer.println(SessionListener.HISTORY.toString());
    }
}
