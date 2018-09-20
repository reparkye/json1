package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import json.DBCon;
import vo.TestInfo;



public class TestDAO {

	public List<TestInfo> selectTestList(){
		Connection con = DBCon.getCon();
		String sql = "select * from test_info";
		List<TestInfo> teList = new ArrayList<TestInfo>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TestInfo ti = new TestInfo(rs.getInt("tinum"), rs.getString("tiname"),
						rs.getString("titext"), rs.getString("tiid"));
				teList.add(ti);
			}
			ps.close();
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.closeCon();
		}
		return teList;
	}
}
