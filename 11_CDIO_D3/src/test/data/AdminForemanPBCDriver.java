package test.data;

import data.Connector;
import data.dao.DALException;
import data.dao.SQLAdminForemanPBCDAO;

public class AdminForemanPBCDriver {

	private final static SQLAdminForemanPBCDAO dao = new SQLAdminForemanPBCDAO(Connector.getInstance());

	public static void main(String[] args) {
		try {
			System.out.println(dao.getVAdminForemanPBCList());
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

}