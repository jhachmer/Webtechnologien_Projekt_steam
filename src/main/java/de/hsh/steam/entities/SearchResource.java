package de.hsh.steam.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.hsh.steam.model.searchModel;
import de.hsh.steam.model.seriesModel;
import de.hsh.steam.repositories.SerializedSeriesRepository;
import de.hsh.steam.services.SteamService;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * REST Web Service
 *
 * @author Jannes
 */
@Path("/User/{username}/Search")
@RequestScoped
public class SearchResource {

    SteamService ss = SteamService.getInstance();
    SerializedSeriesRepository ssr = SerializedSeriesRepository.getInstance();
    ObjectMapper om = new ObjectMapper();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SearchResource
     */
    public SearchResource() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<seriesModel> search(@PathParam("username") String username, searchModel sm) throws JsonProcessingException {
        List<seriesModel> tempList = new ArrayList<>();
        ArrayList<Series> serien = ss.search(username, Genre.valueOf(sm.getGenre()), Streamingprovider.valueOf(sm.getProvider()), Score.valueOf(sm.getScore()));
        for (Series s : serien) {
            seriesModel item = new seriesModel(s.getTitle(), s.getNumberOfSeasons(), s.getGenre().name(), s.getStreamedBy().name());
            tempList.add(item);
        }
        return tempList;

    }

}
