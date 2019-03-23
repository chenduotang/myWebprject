package src.com.bdqn.zmj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.com.bdqn.zmj.entity.User;

public class UserDao extends BaseDao {
    
	public  List<User> selet(User user,int start,int pageSize) throws SQLException {
		StringBuffer sql = new StringBuffer("select * from news_users where 1=1 ");// �ɱ���ַ���
		List<Object> par = new ArrayList<Object>();// װ����
		if (user.getUname() != null) {
			sql.append("and uname=?");//׷�ӵ�sql�����ȥ
			par.add(user.getUname());//Ȼ��ȥ�õ�uname��ֵ
		}
		if (user.getUid() > 0) {
			sql.append("and uid=?");
			par.add(user.getUid());
		}
		// ִ��sql��ѯ���
		ResultSet rs = executeQuery(sql.toString(), par.toArray());
		List<User> list = new ArrayList<User>();//�����ѯ�Ĺ���Ա����
		System.out.println(sql);
		try {
			while (rs.next()) {
				User u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
				list.add(u);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * public static void main(String[] args) { UserDao userdao=new UserDao(); User
	 * user=new User(); user.setUid(5); System.out.println(userdao.selet(user)); }
	 */
}
