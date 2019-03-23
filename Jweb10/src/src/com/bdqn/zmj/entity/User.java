package src.com.bdqn.zmj.entity;

/*
 * 锟矫伙拷锟斤拷
 */
public class User {
	
	private int uid;
	private String uname;
	private String upwd;

	public void setUid(int uid) {
		this.uid = uid;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public int getUid() {
		return uid;
	}

	public String getUname() {
		return uname;
	}

	public String getUpwd() {
		return upwd;
	}
	
	@Override
	public String toString() {
		//返回一个json数据对象
		return "{uid:" + uid + ",uname:'" + uname + "',upwd:'" + upwd + "'}";
	}

}
