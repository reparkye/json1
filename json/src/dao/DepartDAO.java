package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.vo.TicketMovie;

import json.DBCon;
import vo.DepartInfo;

public class DepartDAO {
	
	public List<DepartInfo> selectDepartInfoList(){
		Connection con = DBCon.getCon();
		String sql = "select * from depart_info";
		List<DepartInfo> diList = new ArrayList<DepartInfo>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DepartInfo di = new DepartInfo(rs.getInt("dinum"),rs.getString("dicode"),rs.getString("diname"), rs.getString("didesc"));
				diList.add(di);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBCon.getCon();
		}
		return diList;
	}


	public DepartInfo selectDepartInfo() {
		String sql = "select * from depart_info where dinum=?";
		Connection con = DBCon.getCon();
		List<DepartInfo> dList = new ArrayList<DepartInfo>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, dinum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DepartInfo di = new DepartInfo(rs.getInt("dinum"),rs.getString("dicode"),
						rs.getString("diname"),rs.getString("didesc"));
				dList.add(di);
		}
			ps.close();
			rs.close();
		}catch(SQLException e) {
			throw e;
	}finally {
		DBCon.closeCon();
	}
		return dList;
	}
	public List<DepartInfo> deleteDepartList(){
		String sql = "delete from where dinum=?";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, dinum);
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.closeCon();
		}
	}
	
	public List<DepartInfo> updateDepartList(){
		
		
		
		
		
	}
	
	
	
	
	
}
