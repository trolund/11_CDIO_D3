package test.data;

import data.Connector;
import data.dao.DALException;
import data.dao.SQLReceptComponentDAO;

public class ReceptComponentDriver {

	private static final SQLReceptComponentDAO dao = new SQLReceptComponentDAO(Connector.getInstance());

	public static void main(String[] args) {

		try {
			System.out.println(dao.getReceptComponent(1, 2));
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

}