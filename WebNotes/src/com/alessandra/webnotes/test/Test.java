package com.alessandra.webnotes.test;

import com.alessandra.webnotes.businessLogic.NoteDAO;
import com.alessandra.webnotes.businessLogic.UtenteDAO;
import com.alessandra.webnotes.model.Note;
import com.alessandra.webnotes.model.Utente;
import com.alessandra.webnotes.utility.DBManager;

import javax.persistence.EntityManager;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            EntityManager entityManager = DBManager.getEntityManager();
            UtenteDAO utenteDAO = new UtenteDAO(entityManager);
            Utente uLoggato = utenteDAO.login("Bhoken","1234");
            System.out.println(uLoggato.getUsername());
            //Note n1 = new Note();
            /*Note n2 = new Note();
            Utente u1 = new Utente();
            n2.setTitolo("Prova2");
            n2.setContenuto("Provaprova2");
            n2.setUtente(u1);
            u1.setNote(n2);
            u1.setUsername("Bhoken");
            u1.setPassword("1234");
            NoteDAO notaDao = new NoteDAO(entityManager);
            UtenteDAO utenteDAO = new UtenteDAO(entityManager);
            utenteDAO.registrazioneUtente(u1);
            notaDao.addNote(n2);*/
            //Note nota = notaDao.getById(1);
            //notaDao.removeNote(nota);
            //System.out.println(n2.getId());
            //notaDao.removeNoteById(2);
            /*List<Note> note = notaDao.findAll();
            for (Note nota: note
                 ) {
                System.out.println(nota.getTitolo());
                System.out.println(nota.getContenuto());
            }*/
            //System.out.println(note.get(0));
            //notaDao.updateNote(3,"Update1","Update1");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
