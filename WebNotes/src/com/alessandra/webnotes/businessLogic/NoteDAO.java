package com.alessandra.webnotes.businessLogic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.alessandra.webnotes.model.Note;
import com.alessandra.webnotes.model.Utente;

public class NoteDAO {

    private EntityManager entityManager;

    public NoteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Note findById(int id) {
        return entityManager.find(Note.class, id);
    }

    public List<Note> findAll() {
        return entityManager.createQuery("select n from Note n").getResultList();
    }

    public List<Note> findAllByUser(Utente idUtente){
        return entityManager.createQuery("select n from Note n where n.utente=:utenteId").setParameter("utenteId",idUtente).getResultList();
    }

    public void addNote(Note nota) {
        entityManager.getTransaction().begin();
        entityManager.persist(nota);
        entityManager.getTransaction().commit();
    }

    public void removeNoteById(int id) {
        entityManager.getTransaction().begin();
        List<Note> notaTrovata = new ArrayList<>();
        notaTrovata = entityManager.createQuery("select n from Note n where id=:id").setParameter("id",id).getResultList();
        entityManager.remove(notaTrovata.get(0));
        entityManager.getTransaction().commit();
    }

    public void updateNote(int id,String titolo,String contenuto) {
        entityManager.getTransaction().begin();
        Note notaTrovata = entityManager.find(Note.class,id);
        notaTrovata.setTitolo(titolo);
        notaTrovata.setContenuto(contenuto);
        entityManager.getTransaction().commit();
    }
}
