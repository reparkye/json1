package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import json.DBCon;
import vo.DepartInfo;

public class DepartDAO {
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection con;
	
	public void close() {
		try {
			if(ps!=null) {
				ps.close();
			}
			if(rs!=null) {
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
		DBCon.closeCon();
	}
	}
	
	public List<DepartInfo> selectDepartInfoList(DepartInfo depart){
		String sql = "select * from depart_info";
		con = DBCon.getCon();
		List<DepartInfo> dList = new ArrayList<DepartInfo>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) { // 한줄끝내면 다른줄로 이동~!!!
				depart = new DepartInfo(rs.getInt("dinum"), rs.getString("dicode"), rs.getString("diname"),
						rs.getString("didesc"));
				dList.add(depart);
			}
			
		}catch(SQLException e) {
			
		}finally {
			close();
		}
		return dList;
	}
	
	public DepartInfo selectDepartInfo (DepartInfo di) {
		con = DBCon.getCon();
		String sql = "select * from depart_info where dinum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, di.getDinum());
			rs = ps.executeQuery();
			while(rs.next()) {
				di = new DepartInfo(rs.getInt("dinum"), rs.getString("dicode"), rs.getString("diname"),
						rs.getString("didesc"));
			return di;
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}
	
	
	
	
	
	
}
