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
}