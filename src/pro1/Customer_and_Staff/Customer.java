package pro1.Customer_and_Staff;

import java.util.ArrayList;

import pro2.Database.User_database;
import pro3.Service.Service;

public class Customer extends User{
	public String user_name;//�û���
	public String ID;//���֤��
	public String tele_number;//�绰����
	public String location;//סַ
	public double balance;//�˻����
	public int count;//�����ж�����������
	public String password;//����
	public ArrayList<User_Money> money;
	
	//����ʱʹ�õĹ��캯��
	public Customer(String u_name,String id,String tele,
			String loc,double m,String pass){
		balance = m;
		money = new ArrayList<User_Money>();
		User_Money temp = new User_Money(0,m);//����ʱĬ�ϴ��ǮΪ����
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
	//�����˻������
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
	
	//(a),���
	public void Deposit(Service sev_temp,String u_name,User_database database){
		sev_temp.Deposit(u_name,database);
	}
	
	//(b),ȡ��
	public void Withdraw(Service sev_temp,String u_name,User_database database){
		sev_temp.Withdraw(u_name, database);
	}
	//(c),��ѯ���
	public void Show_balance(Service sev_temp,String u_name,User_database database){
		sev_temp.Show_balance(u_name, database);
	}
	//(d),ת��
	public void Transit(Service sev_temp,String u_name2,User_database database){//u_name2�ǻ��Ǯ��һ��{
		sev_temp.Transit(u_name2, database);
	}
	//(e),�޸ĸ�����Ϣ
	public void Reset_message(Service sev_temp,String u_name,User_database database){
		sev_temp.Reset_message(u_name, database);
	}
	//(f)���޸�����
	public void Reset_pass_user(Service sev_temp,String u_name,User_database database){
		sev_temp.Reset_pass_user(u_name, database);
	}

}