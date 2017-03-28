package data.dao;

import data.dto.RoleDTO;

import java.util.List;

public interface IRoleDAO {
    List<RoleDTO> getOprRoles(int oprId) throws DALException;
    List<RoleDTO> getRoleList() throws DALException;
    void createRole(RoleDTO role) throws DALException;
    void updateRole(RoleDTO role) throws DALException;
    void deleteRole(RoleDTO role) throws DALException;
}