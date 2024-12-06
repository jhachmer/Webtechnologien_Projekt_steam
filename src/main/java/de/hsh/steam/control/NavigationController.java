package de.hsh.steam.control;


import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author Jannes
 */
@Named(value = "navigationController")
@SessionScoped
public class NavigationController implements Serializable {

    public String moveToSearch(){
        return "search";
    }

    public String moveToAdd(){
        return "addtvshow";
    }

    public String moveToOverview(){
        return "overview";
    }

}
