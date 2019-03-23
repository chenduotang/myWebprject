package src.com.bdqn.zmj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Dbutil {

	//鑾峰彇鏁版嵁搴撹繛鎺�
	public static Connection getConn() {
		try {
			Class.forName(ConfigMapper.get("driver"));
			String url = ConfigMapper.get("url");
			Connection conn = DriverManager.getConnection(url, ConfigMapper.get("username"), ConfigMapper.get("password"));
			
			//浠巎ndi鏁版嵁搴撹繛鎺ユ睜閲岄潰鑾峰彇鏁版嵁搴撹繛鎺�
			/*
			 * Context ctx = new InitialContext(); DataSource ds = (DataSource)
			 * ctx.lookup("java:comp/env/jdbc/news");
			 */
			
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//鍏抽棴杩炴帴
	public static void close(Connection conn,PreparedStatement ppst) {
		try {
			if (conn!=null && !conn.isClosed()) {
				ppst.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn,PreparedStatement ppst,ResultSet rs) {
		try {
			rs.close();
			ppst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
