package pro1.Customer_and_Staff;
 
import java.util.Scanner;

import pro2.Database.User_database;
import pro3.Service.Service;

public class Staff extends User{//���ȼ�֮���Ա��Ӧ�þ��м��ɹ�ϵ����ͼ���Ա����Ӧ���Ǹ��ࡣ��߼�Ȩ�޵�Ա�������࣬�Ҿ��и���û�еĺ�����
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
		sev_temp.Create_account(database);
	}
	
	//(b),����
	public void Delete_account(Service sev_temp,User_database database){
		sev_temp.Delete_account(database);
	}
	
	//(c)��ѯ�ͻ�
	public void Show_user(Service sev_temp,User_database database,Staff staff) throws Exception{
		System.out.println("��������Ҫ��ѯ�û����˺ţ�");
		Scanner sc = new Scanner(System.in);
		String u_name = sc.next();//�����û���
		sev_temp.Show_user(u_name,database,staff);
	}
	
	//(d),���
		public void Deposit(Service sev_temp,User_database database){
			System.out.println("�������˺ţ�");
			Scanner sc = new Scanner(System.in);
			String u_name = sc.next();//�����û���
			int x=database.get_order(database,u_name);//��ø��˺ŵ����к�
			while(x==-1){
				System.out.println("δ�鵽���û��������������˺��Ƿ���ȷ��");
				u_name = sc.next();
				x=database.get_order(database,u_name);
			}
			sev_temp.Deposit(u_name,database);
		}
	//(e),ȡ��
	public void Withdraw(Service sev_temp,User_database database){
		System.out.println("�������˺ţ�");
		Scanner sc = new Scanner(System.in);
		String u_name = sc.next();//�����û���
		
		int x=database.get_order(database,u_name);//��ø��˺ŵ����к�
		while(x==-1){
			System.out.println("δ�鵽���û��������������˺��Ƿ���ȷ��");
			u_name = sc.next();
			x=database.get_order(database,u_name);
		}
		sev_temp.Withdraw(u_name,database);
	}
	
	//(f),�޸��¼�����Ա����
		public void Reset_info(Service sev_temp,User_database database,Staff st){
			sev_temp.Reset_info(database, st);
		}
	
	//(g)�������û�����
	public void Reset_pass(Service sev_temp,String u_name,User_database database,Staff st){
		sev_temp.Reset_pass(database, st);
	}

}