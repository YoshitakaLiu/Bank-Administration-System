package pro1.Customer_and_Staff;

import java.util.ArrayList;

import pro2.Database.User_database;
import pro3.Service.Service;

public class Customer extends User{
	public String user_name;//用户名
	public String ID;//身份证号
	public String tele_number;//电话号码
	public String location;//住址
	public double balance;//账户余额
	public int count;//用来判断密码错误次数
	public String password;//密码
	public ArrayList<User_Money> money;
	
	//开户时使用的构造函数
	public Customer(String u_name,String id,String tele,
			String loc,double m,String pass){
		balance = m;
		money = new ArrayList<User_Money>();
		User_Money temp = new User_Money(0,m);//开户时默认存的钱为活期
		money.add(temp);
		user_name = u_name;   ID = id;   tele_number = tele;
		location = loc;  password = pass;
	}
	public void reset_password(String pass){
		password = pass;
	}
	public void reset_message(String tele,String loc){
		location = loc; tele_number = tele;
	}
	//更新账户的余额
	public void Money_flush(){
		double t=0.0;
		for(int i=0;i<money.size();i++)
			t += money.get(i).money;
		balance = t;
	}
	
	public void Increase_Password_Wrong_Times(){
		if( count<3 )
			count++;
	}
	
	//(a),存款
	public void Deposit(Service sev_temp,String u_name,User_database database){
		sev_temp.Deposit(u_name,database);
	}
	
	//(b),取款
	public void Withdraw(Service sev_temp,String u_name,User_database database){
		sev_temp.Withdraw(u_name, database);
	}
	//(c),查询余额
	public void Show_balance(Service sev_temp,String u_name,User_database database){
		sev_temp.Show_balance(u_name, database);
	}
	//(d),转账
	public void Transit(Service sev_temp,String u_name2,User_database database){//u_name2是汇出钱的一方{
		sev_temp.Transit(u_name2, database);
	}
	//(e),修改个人信息
	public void Reset_message(Service sev_temp,String u_name,User_database database){
		sev_temp.Reset_message(u_name, database);
	}
	//(f)，修改密码
	public void Reset_pass_user(Service sev_temp,String u_name,User_database database){
		sev_temp.Reset_pass_user(u_name, database);
	}

}