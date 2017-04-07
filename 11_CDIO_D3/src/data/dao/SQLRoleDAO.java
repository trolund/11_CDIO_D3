package data.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Connector;
import data.dto.RoleDTO;

public class SQLRoleDAO implements IRoleDAO {

	private final Connector connector;

	public SQLRoleDAO(Connector connector) {
		this.connector = connector;
	}

	@Override
	public List<RoleDTO> getOprRoles(int oprId) throws DALException {
		List<RoleDTO> roleList = new ArrayList<>();
		String getOprRolesSql = connector.getSQL("getOprRolesSql");
		PreparedStatement getOprRolesStmt = null;
		ResultSet rs = null;
		try {
			getOprRolesStmt = connector.getConnection().prepareStatement(getOprRolesSql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			getOprRolesStmt.setInt(1, oprId);
			rs = getOprRolesStmt.executeQuery();

			if (!rs.first()) throw new DALException("Operator id [" + oprId + "] has no roles or doesn't exist!");

			do {
				roleList.add(new RoleDTO(rs.getInt("opr_id"), rs.getString("rolle_navn")));
			} while (rs.next());
			return roleList;
		} catch (SQLException e) {
			throw new DALException(e.getMessage(), e);
		} finally {
			try {
				connector.cleanup(getOprRolesStmt, rs);
			} catch (SQLException e) {
				throw new DALException(e.getMessage(), e);
			}
		}
	}

	@Override
	public List<RoleDTO> getRoleList() throws DALException {
		List<RoleDTO> roleList = new ArrayList<>();
		String getRoleListSql = connector.getSQL("getRoleListSql");
		PreparedStatement getRoleListStmt = null;
		ResultSet rs = null;

		try {
			getRoleListStmt = connector.getConnection().prepareStatement(getRoleListSql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = getRoleListStmt.executeQuery();

			if (!rs.first()) throw new DALException("No roles exist!");

			do {
				roleList.add(new RoleDTO(rs.getInt("opr_id"), rs.getString("rolle_navn")));
			} while (rs.next());
			return roleList;
		} catch (SQLException e) {
			throw new DALException(e.getMessage(), e);
		} finally {
			try {
				connector.cleanup(getRoleListStmt, rs);
			} catch (SQLException e) {
				throw new DALException(e.getMessage(), e);
			}
		}
	}

	@Override
	public void createRole(RoleDTO roleDTO) throws DALException {
		String createRoleSql = connector.getSQL("createRoleSql");
		PreparedStatement createRoleStmt = null;
		try {
			createRoleStmt = connector.getConnection().prepareStatement(createRoleSql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			createRoleStmt.setInt(1, roleDTO.getOprId());
			createRoleStmt.setString(2, roleDTO.getRoleName());
			createRoleStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException(e.getMessage(), e);
		} finally {
			try {
				connector.cleanup(createRoleStmt);
			} catch (SQLException e) {
				throw new DALException(e.getMessage(), e);
			}
		}
	}

	@Override
	public void deleteRole(RoleDTO roleDTO) throws DALException {
		String deleteRoleSql = connector.getSQL("deleteRoleSql");
		PreparedStatement deleteRoleStmt = null;
		try {
			deleteRoleStmt = connector.getConnection().prepareStatement(deleteRoleSql);
			deleteRoleStmt.setInt(1, roleDTO.getOprId());
			deleteRoleStmt.setString(2, roleDTO.getRoleName());
			deleteRoleStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException(e.getMessage(), e);
		} finally {
			try {
				connector.cleanup(deleteRoleStmt);
			} catch (SQLException e) {
				throw new DALException(e.getMessage(), e);
			}
		}
	}

}