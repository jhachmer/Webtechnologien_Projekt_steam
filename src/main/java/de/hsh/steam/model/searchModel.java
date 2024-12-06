package de.hsh.steam.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 *
 * @author Jannes
 */
@XmlRootElement
@XmlType(propOrder={"genre","provider","score"})
@JsonPropertyOrder({"genre","provider","score"})
public class searchModel {
    private String genre;
    private String provider;
    private String score;

    public searchModel(){

    }
    public searchModel(String genre, String provider, String score){
        this.genre = genre;
        this.provider = provider;
        this.score = score;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
