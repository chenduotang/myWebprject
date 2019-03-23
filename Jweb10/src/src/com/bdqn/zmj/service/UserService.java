package src.com.bdqn.zmj.service;

import java.sql.SQLException;
import java.util.List;

import src.com.bdqn.zmj.dao.UserDaotwo;
import src.com.bdqn.zmj.entity.Page;
import src.com.bdqn.zmj.entity.User;

public class UserService {
	UserDaotwo dao=new UserDaotwo(); 
	public Page<User> getList(int currentPage,int pageSize) throws SQLException{
		//计算索引样式：起始索引=每页大小*(当前页-1)
		int start=pageSize*(currentPage-1);
		List<User> list=dao.selet(start,pageSize);
		
		//开始封装page对象
		Page<User> page=new Page<User>();
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);

		
		int count=dao.selet(0,-1).size();//查询到所有的条数
		page.setCount(count);//设置总的数据
		page.setTotalPage((int)Math.ceil(count*1.0/pageSize));//总页数=总记录数/每页条数
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
