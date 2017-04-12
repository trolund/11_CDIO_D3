package RESTResources;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

/*
 * Application configuration class for the REST/JERSEY API.
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application {
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String Test() {
		return "If you see this, REST should be working correctly!";
	}

}