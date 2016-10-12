package pro2.Database;

import java.util.ArrayList;

import pro1.Customer_and_Staff.*;

public class User_database {
	public ArrayList<Customer> customer;//员工的工号为4位
	public ArrayList<Staff> staff;//用户的工号以600开头，且为8位
	public User_database(){
		customer = new ArrayList<Customer>();
		staff = new ArrayList<Staff>();
	}
	
	//判断是员工还是用户
	public boolean get_cs(String temp){
		boolean cs = false;
		if(temp.matches("\\d{4}"))
			cs = false;//为员工
		else if(temp.matches("600\\d{5}"))
			cs = true;//为用户
		return cs;
	}
	//通过身份证号查询用户序号
	public int get_order(String id,User_database database){
		int j=-1;
			for(int i=0;i<database.customer.size();i++){
				if(database.customer.get(i).ID.equals(id))
					j = i;
			}
		return j;
	}
	
	//通过用户名查询用户序号，重载函数
	public int get_order(User_database database,String u_name){
		int j=-1;
		if(get_cs(u_name)){//如果是用户
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