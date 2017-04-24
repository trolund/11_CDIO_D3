package data.dao;

import java.util.ArrayList;
import java.util.List;

import data.DALException;
import data.dto.OperatorDTO;

public class ListOperatorDAO implements IOperatorDAO {

	private static List<OperatorDTO> oprList;

	public ListOperatorDAO() {
		oprList = new ArrayList<>();
		oprList.add(new OperatorDTO(101, "Stig", "HGH", "123456-6543", "givos12"));
		oprList.add(new OperatorDTO(102, "Finn", "FGS", "987654-4567", "givos12"));
	}

	@Override
	public OperatorDTO getOperator(int oprId) throws DALException {
		for (OperatorDTO dto : oprList) {
			if (oprId == dto.getOprId()) {
				return dto;
			}
		}
		throw new DALException("Operator with oprId [" + oprId + "] does not exist!");
	}

	@Override
	public List<OperatorDTO> getOperatorList() throws DALException {
		return oprList;
	}

	@Override
	public void createOperator(OperatorDTO opr) throws DALException {
		for (OperatorDTO dto : oprList) {
			if (dto.getOprId() == opr.getOprId()) {
				throw new DALException("Operator with oprId [" + opr.getOprCpr() + "] already exists!");
			}
		}
		oprList.add(opr);
	}

	@Override
	public void updateOperator(OperatorDTO opr) throws DALException {
		for (int i = 0; i < oprList.size(); i++) {
			if (opr.getOprId() == oprList.get(i).getOprId()) {
				oprList.remove(i);
				oprList.add(i, opr);
			}
		}
	}

	@Override
	public void deleteOperator(int oprId) throws DALException {
		for (int i = 0; i < oprList.size(); i++) {
			if (oprList.get(i).getOprId() == oprId) {
				oprList.remove(i);
			}
		}
	}

}