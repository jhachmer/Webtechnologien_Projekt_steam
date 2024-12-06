package de.hsh.steam.control;

import de.hsh.steam.entities.Genre;
import de.hsh.steam.entities.Score;
import de.hsh.steam.services.SteamService;
import de.hsh.steam.entities.Streamingprovider;
import de.hsh.steam.data.LoginData;
import de.hsh.steam.data.ShowData;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author Jannes
 */
@RequestScoped
@Named(value = "addEvent")
public class AddEvent implements Serializable {
    @Inject LoginData loginData;
    public String handleEvent(ShowData showData){
        SteamService services = new SteamService();
        services.addOrModifySeries(showData.getShowname(),
                showData.getNumberOfSeasons(),
                Genre.valueOf(showData.getGenre()),
                Streamingprovider.valueOf(showData.getStreamprovider()),
                loginData.getUsername(),
                Score.valueOf(showData.getRating()),
                showData.getRemark());
        System.out.println(services.getAllSeriesOfUser(loginData.getUsername()));
        return "overview";

    }
}
