package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import json.DBCon;
import vo.Tticket;

public class TticketDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private void close() {
		
		try {
			if(ps!=null) {
				ps.close();
			}
			if(rs!=null) {
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.getCon();
		}
		
	}
	
	
	public List<Tticket> selectTticketList(Tticket tti){
		con = DBCon.getCon();
		String sql = "select * from ticket_movie";
		List<Tticket> ttList = new ArrayList<Tticket>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				tti = new Tticket(rs.getInt("tmnum"),rs.getString("tmname"), rs.getInt("tmprice"),
					rs.getString("tmstartdat"),rs.getString("tmenddat"), rs.getString("tmcredat"),
					rs.getString("tmdesc"), rs.getInt("tmcnt"), rs.getString("tmimg"));
				ttList.add(tti);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return ttList;
	}
	
	public Tticket selectTticket(Tticket tti) {
		con = DBCon.getCon();
		String sql = "select * from ticket_movie where tmnum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, tti.getTmnum());
			rs = ps.executeQuery();
			while(rs.next()) {
				tti = new Tticket(rs.getInt("tmnum"),rs.getString("tmname"), rs.getInt("tmprice"),
					rs.getString("tmstartdat"),rs.getString("tmenddat"), rs.getString("tmcredat"),
					rs.getString("tmdesc"), rs.getInt("tmcnt"), rs.getString("tmimg")); 	
				return tti;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}
	
	public int insertTticket(Tticket tti) {
		con = DBCon.getCon();
		String sql = "insert into ticket_movie(tmnum, tmname, tmprice, tmstartdat, tmenddat,tmcredat,tmcnt)";
			sql += "values(seq_tmnum.nextval,?,?,?,?,to_char(Sysdate,'YYYYDDDD'),0)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tti.getTmname());
			ps.setInt(2, tti.getTmprice());
			ps.setString(3, tti.getTmstartdat());
			ps.setString(4, tti.getTmenddat());
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
	}finally {
		close();
	}
		return 0;
}
	
	public int deleteTticket(Tticket tti) {
		con = DBCon.getCon();
		String sql = "delete from ticket_movie where tmnum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, tti.getTmnum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;	
	}


	public int updateTticket(Tticket tti) {
		con = DBCon.getCon();
		String sql = "update ticket_movie set tmname=?, tmprice=?, tmstartdat=?, tmenddat=?";
		sql += "where tmnum = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,	tti.getTmname());
			ps.setInt(2, tti.getTmprice());
			ps.setString(3, tti.getTmstartdat());
			ps.setString(4, tti.getTmenddat());
			ps.setInt(5, tti.getTmnum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}
	}



