package de.hsh.steam.data;

import de.hsh.steam.entities.Rating;
import de.hsh.steam.entities.Series;
import de.hsh.steam.services.SteamService;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Named;

/**
 *
 * @author Jannes
 */
@Named(value = "searchData")
@RequestScoped
public class SearchData {

    @ManagedProperty(value = "#{LoginData}")
    private LoginData loginData;

    public LoginData getLoginData() {
        return loginData;
    }

    public void setLoginData(LoginData loginData) {
        this.loginData = loginData;
    }
    private String genre;
    private String provider;
    private String rating;

    private SteamService services = new SteamService();
    private ArrayList<Series> seriesList = new ArrayList<Series>();
    private ArrayList<Rating> ratingList = new ArrayList<Rating>();

    /**
     * Creates a new instance of SearchData
     */
    public SearchData() {
    }


    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public String getProvider() {
        return provider;
    }

    public String getRating() {
        return rating;
    }

    public ArrayList<Series> getSerien() {
        return seriesList;
    }

    public void setSerien(ArrayList<Series> seriesList) {
        this.seriesList = seriesList;
    }

    public ArrayList<Rating> getRatingList(){
        return ratingList;
    }
    public void setRatingList(ArrayList<Rating> ratingList){
        this.ratingList = ratingList;
    }
}
