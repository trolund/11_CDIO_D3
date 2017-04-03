package RESTResources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class User {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser() {
        return "Troels Lund";
    }

}