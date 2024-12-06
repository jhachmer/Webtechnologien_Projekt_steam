package de.hsh.steam.data;


import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author Jannes
 */
@Named(value = "showData")
@ViewScoped
public class ShowData implements Serializable {

    @NotNull(message="Enter Showname")
    @Size(min =1)
    String showname;
    @Min(value = 1L, message="Number of Seasons must be at least 1")
    int numberOfSeasons;
    //Selected by Radio Buttons  so no Validation  required
    String genre;
    //Selected by Radio Buttons  so no Validation  required
    String streamprovider;
    //Selected by Radio Buttons  so no Validation  required
    String rating;
    String remark;

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStreamprovider() {
        return streamprovider;
    }

    public void setStreamprovider(String streamprovider) {
        this.streamprovider = streamprovider;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }




}
