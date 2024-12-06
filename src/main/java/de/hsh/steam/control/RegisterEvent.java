package de.hsh.steam.control;

import de.hsh.steam.services.SteamService;
import de.hsh.steam.data.LoginData;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author Jannes
 */
@Named(value = "registerEvent")
@RequestScoped
public class RegisterEvent {

    public void register(LoginData data){
        SteamService services = new SteamService();
        services.newUser(data.getUsername(), data.getPassword());
    }

    public String handleEvent(LoginData data){
        register(data);
    return("home");

    }

}
