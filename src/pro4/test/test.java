package pro4.test;
import pro1.Customer_and_Staff.*;
import pro2.Database.*;
import pro3.Service.*;

public class test {
	public static void main(String[] args) throws Exception {
		Service Serve = new Service();//设置一个服务器
		User_database database = new User_database();//一个数据库
		//首先添加3个用户，表示该银行已经有了3个用户
		database.customer.add(new Customer("60000001","104221199011112341","13548329204","street1",5000,"123456"));
		database.customer.add(new Customer("60000002","104221199011112342","13548329205","street2",5000,"234567"));
		database.customer.add(new Customer("60000003","104221199011112343","13548329206","street3",5000,"345678"));
		//创建2个管理员
		database.staff.add(new Staff("1201",2,"123456",false));//权限为2的管理员（最高级别）
		database.staff.add(new Staff("1202",1,"123456",false));//权限为1的管理员（次一级级别）
		Serve.Login(Serve,database);
	}
}
