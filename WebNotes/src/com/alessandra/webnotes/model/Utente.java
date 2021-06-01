package com.alessandra.webnotes.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({@NamedQuery(name = "Utente.login", query = "select u from Utente u where u.username=:user and u.password=:pwd")})
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "utente")
    private List<Note> note = new ArrayList<>();


    public Utente() {
    }

    public Utente(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public Utente(String username,String password,Note nota) {
        this.username = username;
        this.password = password;
        setNote(nota);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Note> getNote() {
        return note;
    }

    public void setNote(Note nota) {
        note.add(nota);
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
