package pro4.test;
import pro1.Customer_and_Staff.*;
import pro2.Database.*;
import pro3.Service.*;

public class test {
	public static void main(String[] args) throws Exception {
		Service Serve = new Service();//����һ��������
		User_database database = new User_database();//һ�����ݿ�
		//�������3���û�����ʾ�������Ѿ�����3���û�
		database.customer.add(new Customer("60000001","104221199011112341","13548329204","street1",5000,"123456"));
		database.customer.add(new Customer("60000002","104221199011112342","13548329205","street2",5000,"234567"));
		database.customer.add(new Customer("60000003","104221199011112343","13548329206","street3",5000,"345678"));
		//����2������Ա
		database.staff.add(new Staff("1201",2,"123456",false));//Ȩ��Ϊ2�Ĺ���Ա����߼���
		database.staff.add(new Staff("1202",1,"123456",false));//Ȩ��Ϊ1�Ĺ���Ա����һ������
		Serve.Login(Serve,database);
	}
}
