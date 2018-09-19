package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import json.DBCon;
import vo.UserInfo;

public class UserDAO {

	public List<UserInfo> selectUserInfiList(){
		String sql = "select * from user_info";
		Connection con = DBCon.getCon();
		List<UserInfo> uList = new ArrayList<UserInfo>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			UserInfo ui = new UserInfo(rs.getString("id")
						,rs.getString("pwd")
				,rs.getString("name"),rs.getInt("age"),
				rs.getInt("class_num"));
				uList.add(ui);
			}
			System.out.println(uList);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.closeCon();
		}
	return uList;
	}
}
