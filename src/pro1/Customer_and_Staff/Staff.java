package pro1.Customer_and_Staff;

import pro2.Database.User_database;
import pro3.Service.Service;

public class Staff extends User{
	public String work_ID;//Ա���Ĺ���
	public int level;//�����ȼ�,�����ȼ��� 0,1,2�������ȼ���2Ϊ��߼�
	String password;//����
	public boolean prohibit;//�Ƿ񱻽���
	
	public Staff (String work_id,int l,String pass,boolean pro){
		work_ID = work_id;    level = l;    password = pass;   prohibit = pro;
	}
	
	public String get_password(){
		return password;
	}
	
	//(f),�޸Ĺ���Ա�Լ���Ϣ
	public void reset_password(String pass){
		password = pass;
	}
	
	//(a),����
	public void Create_account(Service sev_temp,User_database database){
		sev_temp.Create_account();
	}
	
	//(b),����
	public void Delete_account(Service sev_temp,User_database database){
		sev_temp.Delete_account();
	}
	
	//(c)��ѯ�ͻ�
	public void Show_user() {
	}
	
	//(d),���
	public void Deposit(){
	//  to te implemented
	}
	
	//(e),ȡ��
	public void Withdraw(){
	//  to te implemented
	}
	
	//(f),�޸��¼�����Ա����
	public void Reset_info(){
	//  to te implemented
	}
	
	//(g)�������û�����
	public void Reset_pass(){
	//  to te implemented
	}
}