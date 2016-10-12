package pro2.Database;

import java.util.ArrayList;

import pro1.Customer_and_Staff.*;

public class User_database {
	public ArrayList<Customer> customer;//Ա���Ĺ���Ϊ4λ
	public ArrayList<Staff> staff;//�û��Ĺ�����600��ͷ����Ϊ8λ
	public User_database(){
		customer = new ArrayList<Customer>();
		staff = new ArrayList<Staff>();
	}
	
	//�ж���Ա�������û�
	public boolean get_cs(String temp){
		boolean cs = false;
		if(temp.matches("\\d{4}"))
			cs = false;//ΪԱ��
		else if(temp.matches("600\\d{5}"))
			cs = true;//Ϊ�û�
		return cs;
	}
	//ͨ�����֤�Ų�ѯ�û����
	public int get_order(String id,User_database database){
		int j=-1;
			for(int i=0;i<database.customer.size();i++){
				if(database.customer.get(i).ID.equals(id))
					j = i;
			}
		return j;
	}
	
	//ͨ���û�����ѯ�û���ţ����غ���
	public int get_order(User_database database,String u_name){
		int j=-1;
		if(get_cs(u_name)){//������û�
			for(int i=0;i<database.customer.size();i++){
				if(database.customer.get(i).user_name.equals(u_name))
					j = i;
			}
		}
		else{
			for(int i=0;i<database.staff.size();i++){
				if(database.staff.get(i).work_ID.equals(u_name))
					j = i;
			}
		}
		return j;
	}

}