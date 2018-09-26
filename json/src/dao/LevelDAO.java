package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import json.DBCon;
import vo.LevelInfo;

public class LevelDAO {
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection con;
	
	private void close() {
		DBCon.closeCon();
		try {
			if(ps!=null) {
			ps.close();
		}
			if(rs!=null) {
				rs.close();
			}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}

	public List<LevelInfo> selectLeveList(LevelInfo li){
		String sql = "select * from level_info";
		con = DBCon.getCon();
		List<LevelInfo> lList = new ArrayList<LevelInfo>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				li = new LevelInfo(rs.getInt("linum"),rs.getInt("lilevel"),
				rs.getString("liname"),rs.getString("lidesc"));				
				lList.add(li);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return lList;
		
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
