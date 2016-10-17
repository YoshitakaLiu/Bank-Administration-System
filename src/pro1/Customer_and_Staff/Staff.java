package pro1.Customer_and_Staff;
 
import java.util.Scanner;

import pro2.Database.User_database;
import pro3.Service.Service;

public class Staff extends User{//各等级之间的员工应该具有集成关系，最低级的员工类应该是父类。最高级权限的员工是子类，且具有父类没有的函数。
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
		sev_temp.Create_account(database);
	}
	
	//(b),销户
	public void Delete_account(Service sev_temp,User_database database){
		sev_temp.Delete_account(database);
	}
	
	//(c)查询客户
	public void Show_user(Service sev_temp,User_database database,Staff staff) throws Exception{
		System.out.println("请输入所要查询用户的账号：");
		Scanner sc = new Scanner(System.in);
		String u_name = sc.next();//输入用户名
		sev_temp.Show_user(u_name,database,staff);
	}
	
	//(d),存款
		public void Deposit(Service sev_temp,User_database database){
			System.out.println("请输入账号：");
			Scanner sc = new Scanner(System.in);
			String u_name = sc.next();//输入用户名
			int x=database.get_order(database,u_name);//获得该账号的序列号
			while(x==-1){
				System.out.println("未查到该用户！请检查所输入账号是否正确！");
				u_name = sc.next();
				x=database.get_order(database,u_name);
			}
			sev_temp.Deposit(u_name,database);
		}
	//(e),取款
	public void Withdraw(Service sev_temp,User_database database){
		System.out.println("请输入账号：");
		Scanner sc = new Scanner(System.in);
		String u_name = sc.next();//输入用户名
		
		int x=database.get_order(database,u_name);//获得该账号的序列号
		while(x==-1){
			System.out.println("未查到该用户！请检查所输入账号是否正确！");
			u_name = sc.next();
			x=database.get_order(database,u_name);
		}
		sev_temp.Withdraw(u_name,database);
	}
	
	//(f),修改下级管理员密码
		public void Reset_info(Service sev_temp,User_database database,Staff st){
			sev_temp.Reset_info(database, st);
		}
	
	//(g)，重置用户密码
	public void Reset_pass(Service sev_temp,String u_name,User_database database,Staff st){
		sev_temp.Reset_pass(database, st);
	}

}