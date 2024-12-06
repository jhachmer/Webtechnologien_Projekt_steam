package de.hsh.steam.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 *
 * @author Jannes
 */
@XmlRootElement
@XmlType(propOrder={"title","numberOfSeasons","genre","provider"})
@JsonPropertyOrder({"title","numberOfSeasons","genre","provider"})
public class seriesModel {
    private String title;
    private int numberOfSeasons;
    private String genre;
    private String provider;

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }


    public seriesModel(){

    }
    public seriesModel(String title,int numberOfSeasons,String genre,String provider){
        this.title = title;
        this.numberOfSeasons = numberOfSeasons;
        this.genre = genre;
        this.provider = provider;
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
