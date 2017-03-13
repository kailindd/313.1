package app.exam.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.exam.dao.userDao;
import app.exam.util.ConnectionFactory;

public class userDaoImp implements userDao {

	@Override
	public int selectUser(String name) throws Exception {
		int isExit=0;
		
		String sql="select first_name from customer where 1=1 and first_name=? ;";
		
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setString(1, name);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			isExit=1;
		}		
		return isExit;
		
		

	}

}
