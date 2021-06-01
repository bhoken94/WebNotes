package com.alessandra.webnotes.web;

import com.alessandra.webnotes.businessLogic.NoteDAO;
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

@WebServlet("/newUser")
public class NewUtenteServlet extends HttpServlet {

    private UtenteDAO utenteDAO;

    @Override
    public void init() {
        EntityManager entityManager = DBManager.getEntityManager();
        utenteDAO = new UtenteDAO(entityManager);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(!username.isEmpty() && !password.isEmpty() && username!=null && password!=null){
            Utente newUser = new Utente(username,password);
            utenteDAO.registrazioneUtente(newUser);
            request.getSession().setAttribute("userLogged",newUser);
            request.getRequestDispatcher("/jsp/note.jsp").forward(request,response);
        }else{
            System.out.println("Campi nulli");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
