package json;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;

public class Ttpro {
	
	public List<DepartIn> getInfo(){
		Connection con = DBCon.getCon();
		
		String sql = "select * from depart_info";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<DepartIn> dList = new ArrayList<DepartIn>();
			
			BeanProcessor bp =  new BeanProcessor();				
			
			while(rs.next()) {
				//System.out.println("r");
				dList.add(bp.toBean(rs, DepartIn.class));
				
			}
			
			return dList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
