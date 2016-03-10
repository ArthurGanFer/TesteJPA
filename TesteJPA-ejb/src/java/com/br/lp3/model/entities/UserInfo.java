package com.br.lp3.model.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author cacique
 */
@Entity 
@Table(name = "userinfo")
public class UserInfo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_userinfo;
    @Size(max=100)
    private String fullname;
    @Size(max=100)
    private String email;

    @OneToOne
    @JoinColumn(name = "id_user")
    private UserLP3 userlp3;
    
    public UserInfo() {
    }

    public long getId_userinfo() {
        return id_userinfo;
    }

    public void setId_userinfo(long id_userinfo) {
        this.id_userinfo = id_userinfo;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "id_userinfo=" + id_userinfo + ", fullname=" + fullname + ", email=" + email + '}';
    }
    
}
