package pro1.Customer_and_Staff;

import java.util.ArrayList;

public class Customer extends User{
	public String user_name;//�û���
	public String ID;//���֤��
	public String tele_number;//�绰����
	public String location;//סַ
	public double balance;//�˻����
	public int count;//�����ж�����������
	public String password;//����
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

	//(a),���
	public void Deposit(){
	//  to te implemented
	}
	
	//(b),ȡ��
	public void Withdraw(){
	//  to te implemented
	}
	//(c),��ѯ���
	public void Show_balance(){
	//  to te implemented
	}
	//(d),ת��
	public void Transit(){
	//  to te implemented
	}
	//(e),�޸ĸ�����Ϣ
	public void Reset_message(){
	//  to te implemented
	}
	//(f)���޸�����
	public void Reset_pass_user(){
	//  to te implemented
	}
}