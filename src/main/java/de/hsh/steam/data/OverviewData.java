package de.hsh.steam.data;

import de.hsh.steam.entities.Series;
import de.hsh.steam.entities.Rating;
import de.hsh.steam.services.SteamService;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Jannes
 */
@ManagedBean
@Named(value = "overviewData")
@ViewScoped
public class OverviewData implements Serializable {


    public OverviewData() {

    }

    @PostConstruct
    public final void init() {
        getAllSeriesOfUser();
        getRatingForSeriesOfUser();
    }

    ArrayList<Series> seriesList;
    ArrayList<Rating> ratingList = new ArrayList<Rating>();

    SteamService services = new SteamService();

    @Inject
    LoginData loginData;

    public LoginData getLoginData() {
        return this.loginData;
    }

    public ArrayList<Series> getSeriesList() {
        return seriesList;
    }

    public void setSeriesList(ArrayList<Series> seriesList) {
        this.seriesList = seriesList;
    }

    public ArrayList<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(ArrayList<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public void getAllSeriesOfUser() {
        seriesList = services.getAllSeriesOfUser(loginData.getUsername());
    }

    public void getRatingForSeriesOfUser() {
        for (Series s : seriesList) {
            ratingList.add(services.getRating(s.getTitle(), loginData.getUsername()));
        }
    }

}
