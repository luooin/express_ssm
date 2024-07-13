package com.demo.utils;
import com.lifedian.common.filter.BaseFilter;
import com.lifedian.common.type.SessionType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
public class LoginFilter extends BaseFilter {
    public static final String unLoginReg = "(.*[/](?i)(static|login|adminLogin|reg)+.*?)";
    public LoginFilter() {
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest)request;
            String url = httpRequest.getRequestURI().toString();
            if(url.matches("(.*[/](?i)(static|login|adminLogin|reg)+.*?)")) {
                chain.doFilter(request, response);
                return;
            }
            HttpSession session = httpRequest.getSession();
            if(session.getAttribute(SessionType.USER_NAME.getName()) != null) {
                chain.doFilter(request, response);
                return;
            }
            response.setContentType("text/html;charset=UTF-8");
            String str = "<script language='javascript'>window.top.location.href='" + httpRequest.getContextPath() + this.LOGIN_INDEX + "';</script>";
            try {
                PrintWriter writer = response.getWriter();
                writer.write(str);
                writer.flush();
                writer.close();
            } catch (Exception var9) {
                var9.printStackTrace();
            }
        } catch (Exception var10) {
            ;
        }
    }
}
