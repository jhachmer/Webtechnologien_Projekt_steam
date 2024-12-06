package de.hsh.steam.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 *
 * @author Jannes
 */
@XmlRootElement
@XmlType(propOrder={"username","password"})
@JsonPropertyOrder({"username","password"})
public class loginModel {
    private String username;
    private String password;

    public loginModel(){

    }
    public loginModel(String username,String password){
        this.password = password;
        this.username = username;
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
}
