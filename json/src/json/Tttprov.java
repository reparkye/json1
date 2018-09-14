package json;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;

public class Tttprov {

	public List<DepartIn> getInfo(){
		Connection con = DBCon.getCon();
		String sql = "select * from depart_info";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<DepartIn> dList = new ArrayList<DepartIn>();
			/*BeanProcessor bp = new BeanProcessor();
			while(rs.next()) {
				dList.add(bp.toBean(rs, DepartIn.class));
			}*/
			BeanProcessor bp = new BeanProcessor();
			while(rs.next()) {
				dList.add(bp.toBean(rs, DepartIn.class));				//.class 모든
			}
			
			
			return dList;
		}catch (SQLException e) {
			e.printStackTrace();
	}
		return null;
}
}
