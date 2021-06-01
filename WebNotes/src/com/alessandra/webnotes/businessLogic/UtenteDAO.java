package com.alessandra.webnotes.businessLogic;

import com.alessandra.webnotes.model.Utente;

import javax.persistence.EntityManager;
import java.util.List;

public class UtenteDAO {

    private EntityManager entityManager;

    public UtenteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void registrazioneUtente(Utente utente) {
        entityManager.getTransaction().begin();
        entityManager.persist(utente);
        entityManager.getTransaction().commit();
    }

    public Utente login(String username,String password){
        Utente utenteLoggato = null;
        List<Utente> list = entityManager.createNamedQuery("Utente.login", Utente.class).setParameter("user",username).setParameter("pwd",password).getResultList();
        if(list.size()>0){
            utenteLoggato = list.get(0);
        }
        return utenteLoggato;
    }
}
