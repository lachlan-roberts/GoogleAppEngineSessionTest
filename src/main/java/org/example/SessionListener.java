package org.example;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener
{
    public static StringBuffer HISTORY = new StringBuffer();

    @Override
    public void sessionCreated(HttpSessionEvent se)
    {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se)
    {
        HttpSession session = se.getSession();
        String attributeName = LoginServlet.LOGIN_ATTRIBUTE;
        String attributeValue = (String)session.getAttribute(attributeName);
        HISTORY.append(String.format("SessionAttribute{name:%s, value:%s}<br>", attributeName, attributeValue));
    }
}
