package de.hsh.steam.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Jannes
 */
@XmlRootElement
@XmlType(propOrder = {"title", "numberOfSeasons", "genre", "provider", "score", "remark"})
@JsonPropertyOrder({"title", "numberOfSeasons", "genre", "provider", "score", "remark"})
public class addEditSeriesModel {

    private String title;
    private int numberOfSeasons;
    private String genre;
    private String provider;
    private String score;
    private String remark;

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public addEditSeriesModel() {

    }

    public addEditSeriesModel(String title, int numberOfSeasons, String genre, String provider, String score, String remark) {
        this.title = title;
        this.numberOfSeasons = numberOfSeasons;
        this.genre = genre;
        this.provider = provider;
        this.score = score;
        this.remark = remark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

}
