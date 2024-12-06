package de.hsh.steam.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jannes
 */
@Path("javaxee")
public class JavaEE8Resource {

    @GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
}
