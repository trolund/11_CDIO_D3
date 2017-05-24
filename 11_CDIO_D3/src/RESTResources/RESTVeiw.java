package RESTResources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Connector;
import data.DALException;
import data.dao.SQLOperatorDAO;
import data.dao.view.IVAdminForemanPBCDAO;
import data.dao.view.IVAdminOperatorDAO;
import data.dao.view.SQLAdminForemanPBCDAO;
import data.dao.view.SQLAdminOperatorDAO;
import data.dto.OperatorDTO;
import data.dto.view.VAdminForemanPBCDTO;
import data.dto.view.VAdminOperatorDTO;

@Path("/View")
public class RESTVeiw {
	
	@GET
	@Path("/AdminForemanList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<VAdminForemanPBCDTO> AdminForemanList() {
		IVAdminForemanPBCDAO view = new SQLAdminForemanPBCDAO(Connector.getInstance());

		List<VAdminForemanPBCDTO> viewList = null;

		try {
			viewList = view.getVAdminForemanPBCList();
		} catch (DALException e) {
			e.printStackTrace();
		}
		return viewList;
	}
	
	@GET
	@Path("/AdminOperatorList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<VAdminOperatorDTO> AdminOperatorList() {
		IVAdminOperatorDAO view = new SQLAdminOperatorDAO(Connector.getInstance());

		List<VAdminOperatorDTO> viewList = null;

		try {
			viewList = view.getVAdminOperatorList();
		} catch (DALException e) {
			e.printStackTrace();
		}
		return viewList;
	}

}
