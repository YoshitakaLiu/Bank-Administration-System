package pro2.Database;

import java.util.ArrayList;

import pro1.Customer_and_Staff.*;
 
public class User_database {
	public final int IS_NONE = 0;
	public final int IS_CUSTOMER = 1;
	public final int IS_STAFF = 2;
	
	public ArrayList<Customer> customer;//员工的工号为4位
	public ArrayList<Staff> staff;//用户的工号以600开头，且为8位
	public User_database(){
		customer = new ArrayList<Customer>();
		staff = new ArrayList<Staff>();
	}
	
	//判断是员工还是用户
	//To check whether the user is a customer or a staff
	public int get_cs(String temp){
		int cs = IS_NONE;
		if(temp.matches("\\d{4}"))
			cs = IS_STAFF;//为员工
		else if(temp.matches("600\\d{5}"))
			cs = IS_CUSTOMER;//为用户
		return cs;
	}
	//通过身份证号查询用户序号
	public int get_order(String id,User_database database){
		int j=-1;
		/*
		 *  TODO: 5. Use  ArrayList.contains(Object o)
		 */
		for(int i=0;i<database.customer.size();i++){
			if(database.customer.get(i).ID.equals(id))
				j = i;
		}
		return j;
	}
	
	//通过用户名查询用户序号，重载函数
	public int get_order(User_database database,String u_name){
		int j=-1;
		/*
		 *  TODO: 6. Use  ArrayList.indexOf(Object o)
		 */
		if(get_cs(u_name)==IS_CUSTOMER){//如果是用户
			for(int i=0;i<database.customer.size();i++){
				if(database.customer.get(i).user_name.equals(u_name))
					j = i;
			}
		}
		else if(get_cs(u_name)==IS_STAFF){
			for(int i=0;i<database.staff.size();i++){
				if(database.staff.get(i).work_ID.equals(u_name))
					j = i;
			}
		}
		return j;
	}
	
}