package service;

import java.util.List;

import dao.LevelDAO;
import vo.LevelInfo;

public class LevelService {
	
	private LevelDAO ldao = new LevelDAO();
	
	public List<LevelInfo> selectgetLevel(LevelInfo level){
		
		return ldao.selectLeveList(level);
	}
	
	public LevelInfo selectLevel(LevelInfo level) {
		return null;
	}
	
	public int insertLevel(LevelInfo level) {
		return 0;
	}
	
	
	public int deleteLevel(LevelInfo level) {
		return 0;
	}
	
	public int updateLevel(LevelInfo level) {
		return 0;
	}
	
}
