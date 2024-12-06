package de.hsh.steam.data;


import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author Jannes
 */
@ManagedBean
@SessionScoped
@Named(value = "loginData")
public class LoginData implements Serializable{

    @NotNull(message="Enter Username")
    @Size(min=3, max=12, message="Username must be between 3 and 12 characters")
    String username;

    @NotNull(message="Enter Password")
    @Size(min=3, max=12, message="Password must be between 3 and 12 characters")
    String password;

    public String getUsername() {
        return this.username;
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



}
