package service;

import java.util.HashMap;
import java.util.Map;

import dao.TticketDAO;
import vo.Tticket;

public class TticketService {
	
	private TticketDAO ttdao = new TticketDAO();
	
	public Map<String,Object> selectTticketList(Tticket tti){
		Map<String,Object> rMap = new HashMap<String,Object>();
		rMap.put("list", ttdao.selectTticketList(tti));
		rMap.put("page", 10);
		return rMap;
	}
	
	public Tticket selectTticket(Tticket tti) {
		return ttdao.selectTticket(tti);
	}
	
	public int insertTticket(Tticket tti) {
		return ttdao.insertTticket(tti); 
	}
	
	public int deleteTticket(Tticket tti) {
		return ttdao.deleteTticket(tti);
	}
	
	public int updateTticket(Tticket tti) {
		return ttdao.updateTticket(tti);
	}
	
}
