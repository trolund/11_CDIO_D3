package data.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Connector;
import data.dto.OperatorDTO;

public class SQLOperatorDAO implements IOperatorDAO {

	private final Connector connector;

	
	/*
	 * 
	 * 
	 * UPDATE THIS CLASS TO SUPPORT SHA256 PASSWORDS CORRECTLY!!!
	 */
	public SQLOperatorDAO(Connector connector) {
		this.connector = connector;
	}

	@Override
	public OperatorDTO getOperator(int oprId) throws DALException {
		String getOprSql = connector.getSQL("getOprSql");
		PreparedStatement getOprStmt = null;
		ResultSet rs = null;
		try {
			getOprStmt = connector.getConnection().prepareStatement(getOprSql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			getOprStmt.setInt(1, oprId);
			rs = getOprStmt.executeQuery();

			if (!rs.first()) throw new DALException("Operator id [" + oprId + "] does not exist!");

			return new OperatorDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"),
					rs.getString("cpr"), rs.getString("password"));
		} catch (SQLException e) {
			throw new DALException(e.getMessage(), e);
		} finally {
			try {
				connector.cleanup(getOprStmt, rs);
			} catch (SQLException e) {
				throw new DALException(e.getMessage(), e);
			}
		}
	}

	@Override
	public List<OperatorDTO> getOperatorList() throws DALException {
		String getOprListSql = connector.getSQL("getOprListSql");
		List<OperatorDTO> oprList = new ArrayList<>();
		PreparedStatement getOprListStmt = null;
		ResultSet rs = null;
		try {
			getOprListStmt = connector.getConnection().prepareStatement(getOprListSql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = getOprListStmt.executeQuery();
			while (rs.next()) {
				oprList.add(new OperatorDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"),
						rs.getString("cpr"), rs.getString("password")));
			}
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

	@Override
	public void createOperator(OperatorDTO opr) throws DALException {
		String createOprSql = connector.getSQL("createOprSql");
		PreparedStatement createOprStmt = null;
		try {
			createOprStmt = connector.getConnection().prepareStatement(createOprSql);
			createOprStmt.setInt(1, opr.getOprId());
			createOprStmt.setString(2, opr.getOprName());
			createOprStmt.setString(3, opr.getOprIni());
			createOprStmt.setString(4, opr.getOprCpr());
			createOprStmt.setString(5, opr.getOprPassword());
			createOprStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException(e.getMessage(), e);
		} finally {
			try {
				connector.cleanup(createOprStmt);
			} catch (SQLException e) {
				throw new DALException(e.getMessage(), e);
			}
		}
	}

	@Override
	public void updateOperator(OperatorDTO opr) throws DALException {
		String updateOprSql = connector.getSQL("updateOprSql");
		PreparedStatement updateOprStmt = null;
		try {
			updateOprStmt = connector.getConnection().prepareStatement(updateOprSql);
			updateOprStmt.setString(1, opr.getOprName());
			updateOprStmt.setString(2, opr.getOprIni());
			updateOprStmt.setString(3, opr.getOprCpr());
			updateOprStmt.setString(4, opr.getOprPassword());
			updateOprStmt.setInt(5, opr.getOprId());
			updateOprStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException(e.getMessage(), e);
		} finally {
			try {
				connector.cleanup(updateOprStmt);
			} catch (SQLException e) {
				throw new DALException(e.getMessage(), e);
			}
		}
	}

	@Override
	public void deleteOperator(int oprId) throws DALException {
		String deleteOprSql = connector.getSQL("deleteOprSql");
		PreparedStatement deleteOprStmt = null;
		try {
			deleteOprStmt = connector.getConnection().prepareStatement(deleteOprSql);
			deleteOprStmt.setInt(1, oprId);
			deleteOprStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException(e.getMessage(), e);
		} finally {
			try {
				connector.cleanup(deleteOprStmt);
			} catch (SQLException e) {
				throw new DALException(e.getMessage(), e);
			}
		}
	}

}