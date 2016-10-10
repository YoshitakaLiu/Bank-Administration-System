package pro1.Customer_and_Staff;

import pro2.Database.User_database;
import pro3.Service.Service;

public class Staff extends User{
	public String work_ID;//员工的工号
	public int level;//操作等级,操作等级有 0,1,2这三个等级，2为最高级
	String password;//密码
	public boolean prohibit;//是否被禁用
	
	public Staff (String work_id,int l,String pass,boolean pro){
		work_ID = work_id;    level = l;    password = pass;   prohibit = pro;
	}
	
	public String get_password(){
		return password;
	}
	
	//(f),修改管理员自己信息
	public void reset_password(String pass){
		password = pass;
	}
	
	//(a),开户
	public void Create_account(Service sev_temp,User_database database){
		sev_temp.Create_account();
	}
	
	//(b),销户
	public void Delete_account(Service sev_temp,User_database database){
		sev_temp.Delete_account();
	}
	
	//(c)查询客户
	public void Show_user() {
	}
	
	//(d),存款
	public void Deposit(){
	//  to te implemented
	}
	
	//(e),取款
	public void Withdraw(){
	//  to te implemented
	}
	
	//(f),修改下级管理员密码
	public void Reset_info(){
	//  to te implemented
	}
	
	//(g)，重置用户密码
	public void Reset_pass(){
	//  to te implemented
	}
}