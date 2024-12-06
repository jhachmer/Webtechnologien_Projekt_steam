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
public class newUserModel {
    private String password;
    private String username;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public newUserModel(String username,String password){
        this.username = username;
        this.password = password;

    }
    public newUserModel(){

    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }


}
