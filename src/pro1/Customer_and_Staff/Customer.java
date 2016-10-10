package pro1.Customer_and_Staff;

import java.util.ArrayList;

public class Customer extends User{
	public String user_name;//用户名
	public String ID;//身份证号
	public String tele_number;//电话号码
	public String location;//住址
	public double balance;//账户余额
	public int count;//用来判断密码错误次数
	public String password;//密码
	public ArrayList<User_Money> money;
	public Customer(String u_name,String id,String tele,
			String loc,double m,String pass){
		balance = m;
		money = new ArrayList<User_Money>();
		User_Money temp = new User_Money();
		money.add(temp);
		user_name = u_name;   ID = id;   tele_number = tele;
		location = loc;  password = pass;
	}

	//(a),存款
	public void Deposit(){
	//  to te implemented
	}
	
	//(b),取款
	public void Withdraw(){
	//  to te implemented
	}
	//(c),查询余额
	public void Show_balance(){
	//  to te implemented
	}
	//(d),转账
	public void Transit(){
	//  to te implemented
	}
	//(e),修改个人信息
	public void Reset_message(){
	//  to te implemented
	}
	//(f)，修改密码
	public void Reset_pass_user(){
	//  to te implemented
	}
}