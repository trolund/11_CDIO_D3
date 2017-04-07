package data.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Connector;
import data.dto.ProductBatchComponentDTO;
import data.dto.ReceptComponentDTO;

public class SQLReceptComponentDAO implements IReceptComponentDAO {

	private final Connector connector;

	public SQLReceptComponentDAO(Connector connector) {
		this.connector = connector;
	}

	@Override
	public ReceptComponentDTO getReceptComponent(int receptId, int raavareId) throws DALException {
		String getRCSql = connector.getSQL("getRCSql");
		PreparedStatement getRCStmt = null;
		ResultSet rs = null;
		try {
			getRCStmt = connector.getConnection().prepareStatement(getRCSql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			getRCStmt.setInt(1, receptId);
			getRCStmt.setInt(2, raavareId);
			rs = getRCStmt.executeQuery();

			if (!rs.first()) throw new DALException("ReceptComponent with receptId [" + receptId + "] and raavareId [" + raavareId + "] does not exist!");

			return new ReceptComponentDTO(rs.getInt("recept_id"), rs.getInt("raavare_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance"));
		} catch (SQLException e) {
			throw new DALException(e.getMessage(), e);
		} finally {
			try {
				connector.cleanup(getRCStmt, rs);
			} catch (SQLException e) {
				throw new DALException(e.getMessage(), e);
			}
		}
	}

	@Override
	public List<ReceptComponentDTO> getReceptComponentList(int receptId) throws DALException {
		String getPBCListSql = connector.getSQL("getPBCListIdSql");
		List<ProductBatchComponentDTO> pbcList = new ArrayList<>();
		PreparedStatement getPBCListStmt = null;
		ResultSet rs = null;
		try {
			getPBCListStmt = connector.getConnection().prepareStatement(getPBCListSql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			getPBCListStmt.setInt(1, pbId);
			rs = getPBCListStmt.executeQuery();

			if (!rs.first()) throw new DALException("No ProductBatchComponent's exist with pbId: " + pbId + "!");

			while (rs.next()) {
				pbcList.add(new ProductBatchComponentDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
			}
			return pbcList;
		} catch (SQLException e) {
			throw new DALException(e.getMessage(), e);
		} finally {
			try {
				connector.cleanup(getPBCListStmt, rs);
			} catch (SQLException e) {
				throw new DALException(e.getMessage(), e);
			}
		}
	}

	@Override
	public List<ReceptComponentDTO> getReceptComponentList() throws DALException {
		return null;
	}

	@Override
	public void createReceptComponent(ReceptComponentDTO rc) throws DALException {

	}

	@Override
	public void updateReceptComponent(ReceptComponentDTO rc) throws DALException {

	}

	@Override
	public void deleteReceptComponent(int receptId, int raavareId) throws DALException {

	}

}