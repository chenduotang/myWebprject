package src.com.bdqn.zmj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.com.bdqn.zmj.util.Dbutil;

public class BaseDao {
	
	Connection conn;
	ResultSet rs;
	PreparedStatement ppst;
	
	//鑾峰彇鏁版嵁搴撹繛鎺�
	//鎴戜滑閰嶇疆jndi鐨勭洰鐨勫氨鏄敼鍙樿幏鍙栨暟鎹繛鎺ョ殑鏂瑰紡
	public Connection getConn(){
		try {
			// 1銆佸姞杞介┍鍔�
			Class.forName("com.mysql.jdbc.Driver");
			// 2銆佽幏鍙栨暟鎹簱杩炴帴
			String url = "jdbc:mysql://localhost:3306/newsmanagersystem";
			conn = DriverManager.getConnection(url, "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	//澧炲垹鏀�
	public int executeUpdate(String sql,Object...objects) {
		try {
			ppst = Dbutil.getConn().prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				ppst.setObject(i+1, objects[i]);
			}
			int flag = ppst.executeUpdate();
			return flag;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return -1;	
	}
	
	public ResultSet executeQuery(String sql,Object...objects) {
		try {
			ppst = Dbutil.getConn().prepareStatement(sql);
			if (objects.length>0) {
				for (int i = 0; i < objects.length; i++) {
					ppst.setObject(i+1, objects[i]);
				}
			}
			rs = ppst.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return null;	
	}
}
