package de.hsh.steam.control;

import de.hsh.steam.services.SteamService;
import de.hsh.steam.data.LoginData;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author Jannes
 */
@Named(value = "loginEvent")
@RequestScoped
public class LoginEvent implements Serializable{

    boolean success;

    public void login(LoginData data){
            SteamService service = new SteamService();
            success = service.login(data.getUsername(),data.getPassword());
    }

    public String handleEvent(LoginData data){
        login(data);
        if(success){
            return("overview");
        }
        else{
            return("home");
        }
    }
}
