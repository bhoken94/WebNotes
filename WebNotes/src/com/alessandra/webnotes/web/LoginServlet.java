package com.alessandra.webnotes.web;

import com.alessandra.webnotes.businessLogic.UtenteDAO;
import com.alessandra.webnotes.model.Utente;
import com.alessandra.webnotes.utility.DBManager;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UtenteDAO utenteDAO;

    @Override
    public void init() {
        EntityManager entityManager = DBManager.getEntityManager();
        utenteDAO = new UtenteDAO(entityManager);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pwd = request.getParameter("pass");
        if(!user.isEmpty() && !pwd.isEmpty() && user!=null && pwd!=null){
            Utente userLogged = utenteDAO.login(user,pwd);
            if(userLogged!=null){
                request.getSession().setAttribute("userLogged",userLogged);
                System.out.println("Login effettuata");
                request.getRequestDispatcher("/note").forward(request,response);
            }else{
                request.getRequestDispatcher("/public/login.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
