package data.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Connector;
import data.dto.OperatorDTO;
import data.dto.VAdminForemanPBCDTO;

public class SQLAdminForemanPBCDAO implements IVAdminForemanPBCDAO {

	/* Database Connector object */
	private final Connector connector;

	/* Constructor to retrieve the Database Connector object */
	public SQLAdminForemanPBCDAO(Connector connector) {
		this.connector = connector;
	}

	@Override
	public VAdminForemanPBCDTO getVAdminForemanPBC(int oprId) throws DALException {
		String getVAdminForemanPBCSql = connector.getSQL("getVAdminForemanPBC");
		PreparedStatement getVAdminForemanPBCStmt = null;
		ResultSet rs = null;
		try {
			getVAdminForemanPBCStmt = connector.getConnection().prepareStatement(getVAdminForemanPBCSql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			getVAdminForemanPBCStmt.setInt(1, oprId);
			rs = getVAdminForemanPBCStmt.executeQuery();

			if (!rs.first()) throw new DALException("No entries with oprId [" + oprId + "] exist!");

			return new VAdminForemanPBCDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("status"));
		} catch (SQLException e) {
			throw new DALException(e.getMessage(), e);
		} finally {
			try {
				connector.cleanup(getVAdminForemanPBCStmt, rs);
			} catch (SQLException e) {
				throw new DALException(e.getMessage(), e);
			}
		}
	}

	@Override
	public List<VAdminForemanPBCDTO> getVAdminForemanPBCList() throws DALException {
		String getVAdminForemanPBCList = connector.getSQL("getVAdminForemanPBCListSql");
		List<VAdminForemanPBCDTO> vAdminForemanPBCList = new ArrayList<>();
		PreparedStatement getVAdminForemanPBCDTO = null;
		
		ResultSet rs = null;
		try {
			getOprListStmt = connector.getConnection().prepareStatement(getOprListSql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = getOprListStmt.executeQuery();

			if (!rs.first()) throw new DALException("No operators exist!");

			do {
				oprList.add(new OperatorDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password")));
			} while (rs.next());
			return oprList;
		} catch (SQLException e) {
			throw new DALException(e.getMessage(), e);
		} finally {
			try {
				connector.cleanup(getOprListStmt, rs);
			} catch (SQLException e) {
				throw new DALException(e.getMessage(), e);
			}
		}
	}

}