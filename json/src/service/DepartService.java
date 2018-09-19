package service;

import java.util.List;

import dao.DepartDAO;
import vo.DepartInfo;

public class DepartService {
	private DepartDAO ddao = new DepartDAO();
	
	public List <DepartInfo> getDepartInfoList(){
		return ddao.selectDepartInfoList();
	}
}
