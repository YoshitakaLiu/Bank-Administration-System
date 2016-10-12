package pro3.Service;

import java.util.Scanner;

import pro1.Customer_and_Staff.*;
import pro2.Database.User_database;

public class Service {
	//��¼����
	public void Login(Service sev_temp,User_database database) throws Exception{
		Customer temp_c = null;
		Staff temp_s = null;
		boolean login = false;//������¼��¼�Ƿ�ɹ�
		char select;//����ѡ�����
		Scanner sc = new Scanner(System.in);
		String u_name = null;
//=======================================��¼����=====================================
		while(true)
		{
			while(!login)
			{
				System.out.println("========================��ӭ��������ϵͳ========================");
				System.out.println("������¼�������˺ţ�");
				sc = new Scanner(System.in);
				u_name = sc.next();
				int x=database.get_order(database,u_name);
				System.out.println("����������:");
				sc = new Scanner(System.in);
				String pass = sc.next();
				if(database.get_cs(u_name)){
					while(!database.customer.get(x).password.equals(pass)){
						if(database.customer.get(x).count == 3){
							System.out.println("����3��������������˺��ѱ����ᣡ����ϵ����Ա�ⶳ��");
							break;
						}
						System.out.println("������������!���������룺");
						sc = new Scanner(System.in);
						pass = sc.next();
						database.customer.get(x).count++;//���������1
					}
					database.customer.get(x).count=0;
					temp_c = database.customer.get(x);
					System.out.println("��¼�ɹ���");
					login = true;
				}
				else{
					while(!database.staff.get(x).get_password().equals(pass)){
						System.out.println("������������!���������룺");
						sc = new Scanner(System.in);
						pass = sc.next();
					}
					temp_s = database.staff.get(x);
					System.out.println("��¼�ɹ���");
					login = true;
				}
			}
	//===========================����ҵ�񲿷�=================================
			if(database.get_cs(u_name)){
				print_user();//��ӡ����	
				sc = new Scanner(System.in);
				select = sc.next().charAt(0);
				while(select!='g'){
					switch(select){
					case 'a':temp_c.Deposit(sev_temp, temp_c.user_name, database);print_user();sc = new Scanner(System.in);select = sc.next().charAt(0);break;
					case 'b':temp_c.Withdraw(sev_temp,temp_c.user_name, database);print_user();sc = new Scanner(System.in);select = sc.next().charAt(0);break;
					case 'c':temp_c.Show_balance(sev_temp,temp_c.user_name, database);print_user();sc = new Scanner(System.in);select = sc.next().charAt(0);break;
					case 'd':temp_c.Transit(sev_temp,temp_c.user_name, database);print_user();sc = new Scanner(System.in);select = sc.next().charAt(0);break;
					case 'e':temp_c.Reset_message(sev_temp,temp_c.user_name, database);print_user();sc = new Scanner(System.in);select = sc.next().charAt(0);break;
					case 'f':temp_c.Reset_pass_user(sev_temp,temp_c.user_name, database);print_user();sc = new Scanner(System.in);select = sc.next().charAt(0);break;
					default :System.out.println("����������������ȷ��ָ�");
					print_user();sc = new Scanner(System.in);select = sc.next().charAt(0);
					}
				}
				if(select=='g')
				{
					temp_s = null;
					login = false;
				}
			}
			else{
				print_staff();
				sc = new Scanner(System.in);
				select = sc.next().charAt(0);
				while(select!='i'){
					switch(select){
					case 'a':temp_s.Create_account(sev_temp,database);print_staff();sc = new Scanner(System.in);select = sc.next().charAt(0);break;
					case 'b':temp_s.Delete_account(sev_temp,database);print_staff();sc = new Scanner(System.in);select = sc.next().charAt(0);break;
					case 'c':temp_s.Show_user(sev_temp,database, temp_s);print_staff();sc = new Scanner(System.in);select = sc.next().charAt(0);break;
					case 'd':temp_s.Deposit(sev_temp, database);print_staff();sc = new Scanner(System.in);select = sc.next().charAt(0);break;
					case 'e':temp_s.Withdraw(sev_temp, database);print_staff();sc = new Scanner(System.in);select = sc.next().charAt(0);break;
					case 'f':temp_s.Reset_info(sev_temp, database, temp_s);print_staff();sc = new Scanner(System.in);select = sc.next().charAt(0);break;
					case 'g':temp_s.Reset_pass(sev_temp, u_name, database,temp_s);print_staff();sc = new Scanner(System.in);select = sc.next().charAt(0);break;
					default:System.out.println("��������ȷ��ָ�");print_staff();sc = new Scanner(System.in);select = sc.next().charAt(0);break;
					}
				}
				if(select=='i')
				{
					temp_c = null;
					login = false;
				}
			}
		}
	}
	
	//(a),����
	public void Create_account(User_database database){
		System.out.println("���뿪���˺ţ��ԡ�600����ͷ��8λ����");
		Scanner sc = new Scanner(System.in);
		String u_name = sc.next();//�����û���
		while((!u_name.matches("600\\d{5}"))||(search_account(database,u_name))){
			System.out.println("�����������������");
			sc= new Scanner(System.in);
			u_name = sc.next();
		}
		System.out.println("����6λ��������");
		sc = new Scanner(System.in);//��������
		String pass = sc.next();
		while(!pass.matches("\\d{6}")){
			System.out.println("�����������������");
			sc= new Scanner(System.in);
			pass = sc.next();
		}
		System.out.println("�������֤��");
		sc = new Scanner(System.in);//��������
		String id = sc.next();
		while(!id.matches("\\d{18}")){
			System.out.println("�����������������");
			sc= new Scanner(System.in);
			id = sc.next();
		}
		System.out.println("�����ֻ�����");//�����ֻ���
		sc = new Scanner(System.in);
		String tele = sc.next();
		while(!tele.matches("\\d{11}")){
			System.out.println("�����������������");
			sc= new Scanner(System.in);
			tele = sc.next();
		}
		System.out.println("�����ַ");//�����ַ
		sc = new Scanner(System.in);
		String loc = sc.next();
		System.out.println("���뿪�����");//���뿪�����
		sc = new Scanner(System.in);
		double mon = sc.nextDouble();
		Customer e = new Customer (u_name,id,tele,loc,mon,pass);
		database.customer.add(e);
		System.out.println("�����ɹ����û���Ϊ:"+u_name+"   ������"+mon);
	}
	
	
	//(b),����
	public void Delete_account(User_database database){
		System.out.println("�������֤��:");
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(System.in);//��������
		String id = sc.next();
		while(!id.matches("\\d{18}")){
			System.out.println("�����������������");
			sc= new Scanner(System.in);
			id = sc.next();
		}System.out.println("�������룺");
		sc = new Scanner(System.in);//��������
		String pass = sc.next();
		
		int x=database.get_order(id,database);//��ø��˺ŵ����к�
		if(database.customer.get(x).password.equals(pass)){
			database.customer.remove(x);
			System.out.println("�û���Ϊ"+database.customer.get(x).user_name+"���û������ɹ�");
		}
		else
			System.out.println("���������֤�Ų�ƥ�䣡�������룡");
		
	}
	
	//(c),��ѯ
	public void Show_user(String u_name,User_database database,Staff staff) throws Exception{
		int x=database.get_order(database,u_name);//��ø��˺ŵ����к�
		
		if(x==-1)
			System.out.println("δ�鵽���û��������������˺��Ƿ���ȷ��");
		else{
			if(staff.level<2)//�ж�Ȩ��
				System.out.println("Ȩ�޲��㣬�޷�������");
			else{
			System.out.println("�û�����"+database.customer.get(x).user_name+
					"    ���֤�ţ�"+database.customer.get(x).ID+
					"    �绰���룺"+database.customer.get(x).tele_number+
					"    סַ��"+database.customer.get(x).location+
					"    ��"+database.customer.get(x).balance);
			for(int i=0;i<database.customer.get(x).money.size();i++)//�����д����඼��ʾ����
				database.customer.get(x).money.get(i).show();
			}
		}
	}
	
	//(d),���
	public void Deposit(String u_name,User_database database){

		Scanner sc = new Scanner(System.in);
		System.out.println("��������");
		sc = new Scanner(System.in);
		double m = sc.nextDouble();
		int x=database.get_order(database,u_name);//��ø��˺ŵ����к�

		System.out.println("������������");
		sc = new Scanner(System.in);
		int y = sc.nextInt();
		while(y==1&&y==2&&y!=3&&y!=5&&y!=0){
			System.out.println("��������ȷ�Ĵ�����ޣ�0������ڴ�!");
			sc = new Scanner(System.in);
			y = sc.nextInt();
		}
		
		User_Money temp = new User_Money(y,m);
		if(y!=0)
			database.customer.get(x).money.add(temp);//��Ǯ
		
		else
			database.customer.get(x).money.get(0).set_money(m);
		database.customer.get(x).Money_flush();//ˢ��һ��Ǯ
		database.customer.get(x).money.get(database.customer.get(x).money.size()-1).show();
	}
	
	//�жϽ���Ƿ��㹻
	public boolean money_adequate(String u_name,double m,User_database database){
		boolean w = false;
		int x=database.get_order(database,u_name);
		if(m<=database.customer.get(x).money.get(0).get_money())
			w = true;
		return w;
	}
	
	//(e),ȡ��
	public void Withdraw(String u_name,User_database database){
		int x=database.get_order(database,u_name);//��ø��˺ŵ����к�
		System.out.println("��������");
		Scanner sc = new Scanner(System.in);
		double m = sc.nextDouble();
		
		if(money_adequate(u_name,m,database))
			database.customer.get(x).money.get(0).set_money(-m);
		else
			System.out.println("���㣡");
		database.customer.get(x).Money_flush();//ˢ��һ��Ǯ
	}
	
	//(f),�޸��¼�����Ա����
	public void Reset_info(User_database database,Staff st){
		System.out.println("�������˺ţ�");
		Scanner sc = new Scanner(System.in);
		String work_id = sc.next();//�����û���
		while(!work_id.matches("\\d{4}")){
			System.out.println("��������!����������!");
			sc = new Scanner(System.in);
			work_id = sc.next();
		}
		
		int x=database.get_order(database,work_id);//��ø��˺ŵ����к�
		
		while(x==-1){
			System.out.println("δ�鵽�ù���Ա�������������˺��Ƿ���ȷ��");
			work_id = sc.next();
			x=database.get_order(database,work_id);
		}
		
		boolean t = database.staff.get(x).level < st.level;
		if(!t)
			System.out.println("Ȩ�޲������޷��޸�����");
		else if(database.staff.get(x).prohibit)
		{
			System.out.println("���������ú��6λ���룺");
			sc = new Scanner(System.in);
			String pass = sc.next();
			while(!pass.matches("\\d{6}")){
				System.out.println("�����������������");
				sc= new Scanner(System.in);
				pass = sc.next();
			}
			database.staff.get(x).reset_password(pass);
			System.out.println("�����޸ĳɹ���  ���޸Ĺ���Ա:"+work_id+"  �����ܣ�"+pass);
		}
		else
			System.out.println("�ù���Աδ�����ã��޷��޸�����");
		
	}
	
	//(g)�������û�����
	public void Reset_pass(User_database database,Staff st){
		System.out.println("�������˺ţ�");
		Scanner sc = new Scanner(System.in);
		String u_name = sc.next();//�����û���
		
		int x=database.get_order(database,u_name);//��ø��˺ŵ����к�
		while(x==-1){
			System.out.println("δ�鵽���û��������������˺��Ƿ���ȷ��");
			u_name = sc.next();
			x=database.get_order(database,u_name);
		}

		boolean t = st.level ==2;
		
		if(!t)
			System.out.println("Ȩ�޲������޷��޸�����");
		else if(database.customer.get(x).count==3)
		{
			System.out.println("���������ú��6λ���룺");
			sc = new Scanner(System.in);
			String pass = sc.next();
			while(!pass.matches("\\d{6}")){
				System.out.println("�����������������");
				sc= new Scanner(System.in);
				pass = sc.next();
			}
			database.customer.get(x).reset_password(pass);
			System.out.println("�����޸ĳɹ���  ���޸��û�:"+u_name+"  �����ܣ�"+pass);
		}
		else
			System.out.println("���û�δ�����ã��޷��޸�����");
	}
	//�Ƿ��ѯ�����û�
	public boolean search_account(User_database database,String u_name){
		boolean x = false;
		for(int i=0;i<database.customer.size();i++){
			if(u_name.equals(database.customer.get(i).user_name)){
				x = true;break;
			}
		}
		return x;
	}
	//��ѯ���======(c)
	public void Show_balance(String u_name,User_database database){
		int x=database.get_order(database,u_name);//��ø��˺ŵ����к�
		for(int i=0;i<database.customer.get(x).money.size();i++)//�����д����඼��ʾ����
			database.customer.get(x).money.get(i).show();
	}
	//ת��======(d)
	public void Transit(String u_name2,User_database database){//u_name2�ǻ��Ǯ��һ��
		System.out.println("�������˺ţ�");
		Scanner sc = new Scanner(System.in);
		String u_name = sc.next();//�����û���
		int x=database.get_order(database,u_name);//��ø��˺ŵ����к�
		int y=database.get_order(database,u_name2);//��ø��˺ŵ����к�

		while(x==-1){
			System.out.println("δ�鵽���û��������������˺��Ƿ���ȷ��");
			u_name = sc.next();
			x=database.get_order(database,u_name);
		}
		System.out.println("��������");
		sc = new Scanner(System.in);
		double m = sc.nextDouble();
		if(money_adequate(u_name2,m,database)){
			User_Money temp = new User_Money(0,m);
			database.customer.get(x).money.get(0).set_money(m);
			database.customer.get(y).money.get(0).set_money(-m);
		}
		else{
			System.out.println("�˻�����!");
		}
	}
	//�޸ĸ�����Ϣ======(e)
	public void Reset_message(String u_name,User_database database){
		int x=database.get_order(database,u_name);//��ø��˺ŵ����к�
		System.out.println("�������µĵ绰���룺");
		Scanner sc = new Scanner(System.in);
		String tele = sc.next();
		while(!tele.matches("\\d{11}")){
			System.out.println("�����������������");
			sc= new Scanner(System.in);
			tele = sc.next();
		}
		System.out.println("�������µ�סַ��");
		sc = new Scanner(System.in);
		String loc = sc.next();
		database.customer.get(x).reset_message(tele, loc);
		System.out.println("���óɹ���");
	}
	//�޸�����======(f)
	public void Reset_pass_user(String u_name,User_database database){
			int x=database.get_order(database,u_name);//��ø��˺ŵ����к�
		if(database.customer.get(x).count<3)
		{
			System.out.println("����������룺");
			Scanner sc = new Scanner(System.in);
			String pass = sc.next();
			while(!database.customer.get(x).password.equals(pass)){
				if(database.customer.get(x).count == 3){
					System.out.println("������������3�Σ������˺��ѱ����ᣡ����ϵ����Ա�ⶳ��");
					break;
				}
				System.out.println("������������!���������룺");
				sc = new Scanner(System.in);
				pass = sc.next();
				database.customer.get(x).count++;//���������1
			}
			database.customer.get(x).count = 0;//��������������
			System.out.println("���������ú��6λ���룺");//��һ������
			sc = new Scanner(System.in);
			String pass2 = sc.next();
			while(!pass2.matches("\\d{6}")){
				System.out.println("�����������������");
				sc= new Scanner(System.in);
				pass2 = sc.next();
			}
			
			System.out.println("���ٴ��������ú��6λ���룺");
			sc = new Scanner(System.in);
			String pass3 = sc.next();
			while(  (!pass3.matches("\\d{6}"))  ||  (!pass2.equals(pass3))  ){//�����벻��6λ���֣����������������벻��ͬʱ
				System.out.println("�����������������");
				sc= new Scanner(System.in);
				pass3 = sc.next();
			}
				database.customer.get(x).reset_password(pass2);
			System.out.println("�����޸ĳɹ���  ���޸��û�:"+u_name+"  �����ܣ�"+pass2);
		}
		if(database.customer.get(x).count == 3)
			System.out.println("������������3�Σ������˺��ѱ����ᣡ����ϵ����Ա�ⶳ��");
	}
	public void print_user(){
		System.out.println("============ѡ�����===========");
		System.out.println("��a��         ȡ�b��        ��ѯ��c��\nת�ˣ�d��        �޸ĸ�����Ϣ��e��        �޸����루f��\nע����g��");
		System.out.println("============================");	
	}
	public void print_staff(){
		System.out.println("============ѡ�����===========");
		System.out.println("������a��         ������b��       ��ѯ�ͻ���c��\n��d��        ȡ�e��        �޸Ĺ���Ա��Ϣ��f��\n�ⶳ�˻���g��        ע����i��");
		System.out.println("=============================");
	}
}
