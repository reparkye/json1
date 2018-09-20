package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import json.DBCon;
import vo.Ticket;

public class testtesttest {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void close() {
		DBCon.closeCon();
		try {
			if(ps!=null) {
				ps.close();
			}if(rs!=null) {
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Ticket> selectTicketList(Ticket ti){
		String sql = "select * from ticket_movie";
		con = DBCon.getCon();
		List<Ticket> tList = new ArrayList<Ticket>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ti = new Ticket(rs.getInt("tmnum"),rs.getString("tmname"),rs.getInt("tmprice"),
						rs.getString("tmstartdat"),rs.getString("tmenddat"),rs.getString("tmcredat"),
						rs.getString("tmdesc"), rs.getInt("tmcnt"),rs.getString("tmimg"));
			}
			tList.add(ti);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return tList;		
	}
}
