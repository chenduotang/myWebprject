package src.com.bdqn.zmj.service;

import java.sql.SQLException;
import java.util.List;

import src.com.bdqn.zmj.dao.UserDaotwo;
import src.com.bdqn.zmj.entity.Page;
import src.com.bdqn.zmj.entity.User;

public class UserService {
	UserDaotwo dao=new UserDaotwo(); 
	public Page<User> getList(int currentPage,int pageSize) throws SQLException{
		//����������ʽ����ʼ����=ÿҳ��С*(��ǰҳ-1)
		int start=pageSize*(currentPage-1);
		List<User> list=dao.selet(start,pageSize);
		
		//��ʼ��װpage����
		Page<User> page=new Page<User>();
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);

		
		int count=dao.selet(0,-1).size();//��ѯ�����е�����
		page.setCount(count);//�����ܵ�����
		page.setTotalPage((int)Math.ceil(count*1.0/pageSize));//��ҳ��=�ܼ�¼��/ÿҳ����
		page.setData(list);
		return page;
	}
	/*public static void main(String[] args) throws SQLException {
		UserService userpage=new UserService();
		Page<User> userlist=userpage.getList(1, 3);
		List<User> list=userlist.getData();
		for(User user: list){
			System.out.println(user.toString());
		}
		int count=userlist.getTotalPage();
		int c=userlist.getCurrentPage();
		System.out.println(count);
		System.out.println(c);
	}*/
}
