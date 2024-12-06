package de.hsh.steam.entities;

import de.hsh.steam.model.loginModel;
import de.hsh.steam.services.SteamService;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Jannes
 */
@Path("/Login")
@RequestScoped
public class LoginResource {

    SteamService ss = SteamService.getInstance();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginResource
     */
    public LoginResource() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response loginUser(loginModel lm) {
        if (ss.login(lm.getUsername(), lm.getPassword())) {
            return Response.status(Status.OK)
                    .entity("LOGIN SUCCESFULL")
                    .build();
        } else {
            return Response.status(Status.FORBIDDEN)
                    .entity("LOGIN REJECTED")
                    .build();
        }
    }
}
