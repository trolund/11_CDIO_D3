package RESTResources;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Connector;
import data.dao.DALException;
import data.dao.SQLOperatorDAO;
import data.dto.OperatorDTO;

@Path("/oprDTO")
public class OprDTO {
	
	
	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_PLAIN)
	public OperatorDTO verify(@FormParam("oprId") int oprId){
		SQLOperatorDAO oprDAO = new SQLOperatorDAO(Connector.getInstance());

		OperatorDTO oprDTO = null;
		try {
			oprDTO = oprDAO.getOperator(oprId);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return oprDTO;
	}

}
