package com.alessandra.webnotes.web;

import com.alessandra.webnotes.model.Utente;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/jsp/*","/includes/*"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpSerReq = (HttpServletRequest) req;
        Utente utenteLoggato = (Utente) httpSerReq.getSession().getAttribute("userLogged");
        if(utenteLoggato!=null) {
            //req.getRequestDispatcher("/jsp/note.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("/public/login.jsp").forward(req, resp);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
