package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import json.DBCon;
import vo.Dicket;

public class DicketDAO {
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection con;
		
	private void close() {
		try{
			if(ps!=null) {
				ps.close();
			}
			if(rs!=null) {
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.closeCon();
		}
		
	}

	public List<Dicket> selectDicketList(Dicket dicket) {
		con = DBCon.getCon();
		String sql = "select * from ticket_movie";
		List<Dicket> dicketList = new ArrayList<Dicket>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				dicket = new Dicket(rs.getInt("tmnum"),rs.getString("tmname"),rs.getInt("tmprice"),
						rs.getString("tmstartdat"), rs.getString("tmenddat"), rs.getString("tmcredat"),
						rs.getString("tmdesc"), rs.getInt("tmcnt"), rs.getString("tmimg"));
				dicketList.add(dicket);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dicketList;
	}
	
	public Dicket selectDicket(Dicket dicket) {
		con = DBCon.getCon();
		String sql = "select * from ticket_movie where tmnum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, dicket.getTmnum());
			rs = ps.executeQuery();
			while(rs.next()) {
				dicket = new Dicket(rs.getInt("tmnum"), rs.getString("tmname"), rs.getInt("tmprice"),
						rs.getString("tmstartdat"), rs.getString("tmenddat"), rs.getString("tmcredat"),
						rs.getString("tmdesc"), rs.getInt("tmcnt"), rs.getString("tmimg"));
				return dicket;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}
	
	public int insertDicket(Dicket dicket) {
		con = DBCon.getCon();
		String sql = "insert into ticket_movie()";
		sql += "values(seq_tmnum.nextval,?,?,?,?,to_char(sysdate,'yyyymmdd'),0)";
		try {
			ps = con.prepareStatement(sql);
			ps.set
			
		}
		
		return null;
	}
	
	
	
}
