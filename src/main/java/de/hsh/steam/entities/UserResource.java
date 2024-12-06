package de.hsh.steam.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.hsh.steam.model.addEditSeriesModel;
import de.hsh.steam.model.newUserModel;
import de.hsh.steam.model.seriesModel;
import de.hsh.steam.repositories.SerializedSeriesRepository;
import de.hsh.steam.services.SteamService;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * REST Web Service
 *
 * @author Jannes
 */
@Path("/User")
@RequestScoped
public class UserResource {

    SteamService ss = SteamService.getInstance();
    ObjectMapper om = new ObjectMapper();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsersResource
     */
    public UserResource() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createUser(newUserModel nUM) {
        String username = nUM.getUsername();
        String password = nUM.getPassword();

        if (ss.newUser(username, password)) {
            return Response.status(Status.CREATED).entity("USER CREATED").build();
        } else {
            return Response.status(Status.FORBIDDEN).entity("CREATION FAILED").build();
        }
    }

    @GET
    @Path("/{username}/Series")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<seriesModel> getAllSeriesOfUser(@PathParam("username") String username) throws JsonProcessingException {
        List<seriesModel> tempList = new ArrayList<>();

        ArrayList<Series> serien = ss.getAllSeriesOfUser(username);
        for (Series s : serien) {
            seriesModel series = new seriesModel(s.getTitle(), s.getNumberOfSeasons(), s.getGenre().name(), s.getStreamedBy().name());
            tempList.add(series);
        }
        return tempList;
    }

    @POST
    @Path("/{username}/Series")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response addOrEditSeries(@PathParam("username") String username, addEditSeriesModel aesm) {

        ss.addOrModifySeries(aesm.getTitle(),
                aesm.getNumberOfSeasons(),
                Genre.valueOf(aesm.getGenre()),
                Streamingprovider.valueOf(aesm.getProvider()),
                username,
                Score.valueOf(aesm.getScore()),
                aesm.getScore());

        return Response.status(Status.CREATED)
                .build();
    }
}
