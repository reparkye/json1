package service;

import java.util.HashMap;
import java.util.Map;

import dao.DepartDAO;
import vo.DepartInfo;

public class DepartService {
	private DepartDAO ddao = new DepartDAO();
	
	public Map<String,Object> selectDepartList(DepartInfo depart){
		Map<String,Object> rMap = new HashMap<String,Object>();
		rMap.put("list", ddao.selectDepartInfoList(depart));
		return rMap;
	}
	
}
