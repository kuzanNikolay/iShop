package edu.java.ishop.model;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by Nikolay on 14.07.14.
 */
public class User extends Model {
    private String username;
    private String password;
    private Set<UserRole> userRoles;
    private Calendar dateOfBirth;

    public User(long id) {
        super(id);
    }

    public User (String username, String password){
        super();
        this.username = username;
        this.password = password;
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

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
