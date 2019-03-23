package src.com.bdqn.zmj.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.com.bdqn.zmj.entity.User;

public class UserDaotwo extends BaseDao {
	public  List<User> selet(int start,int pageSize) throws SQLException {
		List<User> userlist=new ArrayList<User>();
		conn=getConn();
		try {
			String sql="select * from news_users limit ?,?";
			if(pageSize==-1){//pagesize==-1��ʾ��ѯ�����е�����,�����Ǹ����ֿ��Ա�
				sql="select * from news_users ";
			}
			ppst=conn.prepareStatement(sql);
			if(pageSize!=-1){//������-1��ʱ��Ÿ�ֵ
				ppst.setInt(1, start);
				ppst.setInt(2, pageSize);
			}
			rs=ppst.executeQuery();
			while(rs.next()){
				User u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
				userlist.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userlist;
	}
}
