package RESTResources;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Connector;
import data.dao.DALException;
import data.dao.SQLOperatorDAO;
import data.dto.OperatorDTO;

@Path("/opr")
public class Operator {

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUser() {
		return "If you see this, REST should be working correctly!";
	}

	@POST
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public String verify(@FormParam("oprId") int oprId, @FormParam("password") String password) {
		SQLOperatorDAO oprDAO = new SQLOperatorDAO(Connector.getInstance());

		OperatorDTO oprDTO = null;
		try {
			oprDTO = oprDAO.getOperator(oprId);
		} catch (DALException e) {
			e.printStackTrace();
		}

		if (password.equals(oprDTO.getOprPassword())) {
			return "Passworded er korrekt!";
		} else {
			return "Passworded er forkert!";
		}

	}

}