package service;

import java.util.HashMap;
import java.util.Map;

import dao.DicketDAO;
import vo.Dicket;

public class DicketService {

	private DicketDAO ddao = new DicketDAO();
	
	public Map<String,Object> selectDicketList(Dicket dicket){
		Map<String,Object> rMap = new HashMap<String,Object>();
		rMap.put("list",ddao.selectDicketList(dicket));
		rMap.put("page", 10);
		return rMap;
	}
	
	public Dicket selectDicket(Dicket dicket) {
		return ddao.selectDicket(dicket);
	}
	
	public int insertDicket(Dicket dicket) {
		return ddao.insertDicket(dicket);
	}
	
	
	
	
	
}
