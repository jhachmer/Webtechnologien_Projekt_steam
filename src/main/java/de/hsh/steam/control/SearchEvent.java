package de.hsh.steam.control;

import de.hsh.steam.entities.Genre;
import de.hsh.steam.entities.Score;
import de.hsh.steam.services.SteamService;
import de.hsh.steam.entities.Streamingprovider;
import de.hsh.steam.data.LoginData;
import de.hsh.steam.data.SearchData;
import de.hsh.steam.entities.Rating;
import de.hsh.steam.entities.Series;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Jannes
 */
@Named(value = "searchEvent")
@RequestScoped
public class SearchEvent {

    @Inject
    LoginData loginData;

    SteamService services = new SteamService();
    private ArrayList<Series> seriesList = new ArrayList<Series>();
    private ArrayList<Rating> ratingList = new ArrayList<Rating>();

    public LoginData getLoginData() {
        return loginData;
    }

    /**
     * Creates a new instance of ShowEvent
     */
    public SearchEvent() {
    }

    public void handleEvent(SearchData data) {
        //data.setSerien(services.search(loginData.getUsername(), Genre.valueOf(data.getGenre()), Streamingprovider.valueOf(data.getProvider()), Score.valueOf(data.getRating())));
        seriesList = services.search(loginData.getUsername(), Genre.valueOf(data.getGenre()), Streamingprovider.valueOf(data.getProvider()), Score.valueOf(data.getRating()));
        for (Series s : seriesList) {
            ratingList.add(services.getRating(s.getTitle(), loginData.getUsername()));
        }
        data.setSerien(seriesList);
        data.setRatingList(ratingList);
    }

}
