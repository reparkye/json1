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
	
	
	public List<LevelInfo> selectLevelList(){
		
		String sql = "select * from level_info";
		Connection con = DBCon.getCon();
		List<LevelInfo> lList = new ArrayList<LevelInfo>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LevelInfo li = new LevelInfo(rs.getInt("linum"),rs.getInt("lilevel"),rs.getString("liname"),rs.getString("lidesc"));
				lList.add(li);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return lList;
	}
	
}
