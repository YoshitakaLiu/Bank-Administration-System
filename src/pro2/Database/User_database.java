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
}