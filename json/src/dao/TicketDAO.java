package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import json.DBCon;
import vo.Ticket;

public class TicketDAO {
	 private Connection con;
	 private ResultSet rs;
	 private PreparedStatement ps;

	 private void close() {
		DBCon.closeCon();
		 try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
	 }
	 
	/* public int countList(Ticket ti) {
		 String sql = "select count(*) from ticket_movie";
		 Connection con = DBCon.getCon();
		 try {
			 ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
			 if(rs.next()) {
				 
			 }
		 }catch(SQLException e) {
			 
		 }
	 }
	 */
	 
	
	public List<Ticket> selectTicketList(Ticket ti){
		 List<Ticket> ticketList = new ArrayList<Ticket>();
		 con = DBCon.getCon();
		 try {
			 System.out.println(ti);
			 String sql = "select * from ticket_movie";
			 ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
			 System.out.println("dfsdf");
			 while(rs.next()) {
				 ti = new Ticket(rs.getInt("tmnum"),
						 rs.getString("tmname"), rs.getInt("tmprice"), rs.getString("tmstartdat"),
						 rs.getString("tmenddat"),rs.getString("tmcredat"),rs.getString("tmdesc"),
						 rs.getInt("tmcnt"),rs.getString("tmimg"));
				 
				 ticketList.add(ti);
			 }
			 
			 System.out.println(ticketList);
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 close();
		 }
		 
		 return ticketList;

	}
	
	
	public Ticket selectTicket(Ticket ticket) {
		con = DBCon.getCon();
		try {
			String sql = "select * from ticket_movie where tmnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ticket.getTmnum());
			rs = ps.executeQuery();
		while(rs.next()) {
			ticket = new Ticket(rs.getInt("tmnum"), rs.getString("tmname"), rs.getInt("tmprice"),
					rs.getString("tmstartdat"), rs.getString("tmenddat"), rs.getString("tmcredat"),
					rs.getString("tmdesc"),rs.getInt("tmcnt"),rs.getString("tmimg"));
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return ticket;
	
	}
	
	
	public int insertTicket(Ticket ticket){
		con = DBCon.getCon();
		
		String sql = "insert into ticket_movie(tmNum , tmName, tmPrice,"
				+ "tmStartdat,tmEnddat, tmCredat)" +
					" values(seq_tmnum.nextVal,?,?,?,?,to_char(sysdate,'YYYYMMDD'))";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ticket.getTmname());
			ps.setInt(2, ticket.getTmprice());
			ps.setString(3, ticket.getTmstartdat().replaceAll("-",""));
			ps.setString(4, ticket.getTmenddat().replaceAll("-",""));
			//ps.setString(5, ticket.getTmdesc());  두개를 추가하면 에러 발생해요 ㅎㅎ
			//ps.setString(6, ticket.getTmimg());
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}
		
	
	public int deleteTicket(Ticket ticket) {
		String sql = "delete from ticket_movie where tmnum=?";
		con = DBCon.getCon();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, ticket.getTmnum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}
	

	public int updateTicket(Ticket ticket) {
		con = DBCon.getCon();
		String sql = "update ticket_movie set tmname=?,";
				sql += " tmstartdat=?, tmenddat=?,";
				sql += " tmcnt = ?  where tmnum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ticket.getTmname());
			ps.setString(2, ticket.getTmstartdat());
			ps.setString(3, ticket.getTmenddat());
			ps.setInt(4, ticket.getTmcnt());
			ps.setInt(5, ticket.getTmnum());

			return ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}
}
