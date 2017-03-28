package data.dao;

import data.Connector;
import data.dto.RoleDTO;

import java.util.List;

public class SQLRoleDAO implements IRoleDAO {

    private final Connector connector;

    public SQLRoleDAO(Connector connector) {
        this.connector = connector;
    }

    @Override
    public List<RoleDTO> getOprRoles(int oprId) throws DALException {
        return null;
    }

    @Override
    public List<RoleDTO> getRoleList() throws DALException {
        return null;
    }

    @Override
    public void createRole(RoleDTO role) throws DALException {

    }

    @Override
    public void updateRole(RoleDTO role) throws DALException {

    }

    @Override
    public void deleteRole(RoleDTO role) throws DALException {

    }

}