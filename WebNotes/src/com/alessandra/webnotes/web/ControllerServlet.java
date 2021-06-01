package com.alessandra.webnotes.web;

import com.alessandra.webnotes.businessLogic.NoteDAO;
import com.alessandra.webnotes.model.Note;
import com.alessandra.webnotes.model.Utente;
import com.alessandra.webnotes.utility.DBManager;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/note")
public class ControllerServlet extends HttpServlet {

    private NoteDAO noteDAO;

    @Override
    public void init() {
        EntityManager entityManager = DBManager.getEntityManager();
        noteDAO = new NoteDAO(entityManager);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Si prende il path della servlet e esegue metodo corrispondente
        String path = request.getServletPath();

        switch (path) {
            case "/new":
                addNote(request,response);
                break;
            case "/edit":
                editNote(request,response);
                break;
            case "/delete":
                deleteNote(request,response);
                break;
            case "/update":
                updateNota(request,response);
                break;
            default:
                listaNote(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private void listaNote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utente user = (Utente) request.getSession().getAttribute("userLogged");
        if(user!=null){
            //List<Note> notes = noteDAO.findAll();
            List<Note> notes = noteDAO.findAllByUser(user);
            request.getSession().setAttribute("notes", notes);
            request.getRequestDispatcher("/jsp/note.jsp").forward(request, response);
        }else{
            System.out.println("Utente nullo");
        }

    }

    private void editNote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String noteId = request.getParameter("notaIdEdit");
        if(noteId!=null && !noteId.isEmpty()) {
            int id = Integer.parseInt(noteId);
            Note notaById = noteDAO.findById(id);
            request.getSession().setAttribute("notaById",notaById);
            request.getRequestDispatcher("/jsp/editForm.jsp").forward(request,response);
        }
    }

    private void updateNota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String updateTitolo = request.getParameter("titoloEdit");
        String updateContenuto = request.getParameter("contenutoEdit");
        String notaId = request.getParameter("notaId");
        if(updateContenuto!=null && !updateContenuto.isEmpty() && updateTitolo!=null && !updateContenuto.isEmpty()) {
            int id = Integer.parseInt(notaId);
            noteDAO.updateNote(id,updateTitolo,updateContenuto);
            request.getRequestDispatcher("/note").forward(request,response);
        }else{
            request.getRequestDispatcher("/jsp/editForm.jsp").forward(request,response);
        }
    }

    private void deleteNote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String noteId = request.getParameter("notaIdDelete");
        if(noteId!=null && !noteId.isEmpty()) {
            int id = Integer.parseInt(noteId);
            try {
                noteDAO.removeNoteById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("/note").forward(request,response);
        }else{
            request.getRequestDispatcher(request.getContextPath()+"/jsp/delete.jsp").forward(request,response);
        }
    }

    private void addNote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newTitle = request.getParameter("newTitle");
        String newContenuto = request.getParameter("newContenuto");
        Utente user = (Utente) request.getSession().getAttribute("userLogged");
        if(newTitle!=null && !newTitle.isEmpty() && user!=null){
            Note newNote = new Note(newTitle,newContenuto,user);
            noteDAO.addNote(newNote);
            request.getRequestDispatcher("/note").forward(request,response);
        } else {
            request.getRequestDispatcher("/jsp/new.jsp").forward(request,response);
        }
    }




}
