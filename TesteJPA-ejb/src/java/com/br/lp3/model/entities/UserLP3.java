package com.br.lp3.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author cacique
 */
@Entity
@Table(name="userlp3")
public class UserLP3 implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;
    @Size(max = 20)
    private String username;
    @Size(max = 32)
    private String password;
    
    @OneToOne(mappedBy = "userlp3", 
            cascade = CascadeType.ALL, orphanRemoval = true)
    private UserInfo userinfo;

    @OneToMany(cascade = CascadeType.ALL, 
        mappedBy = "userLP3", orphanRemoval = true)
    private List<Livro> livros = new ArrayList<>();
    
    public UserLP3() {
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
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

    public UserInfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfo userinfo) {
        this.userinfo = userinfo;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "UserLP3{" + "id_user=" + id_user + ", username=" + username + ", password=" + password + ", userinfo=" + userinfo + ", livros=" + livros + '}';
    }
    
}
