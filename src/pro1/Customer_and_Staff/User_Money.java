package pro1.Customer_and_Staff;
 
/**
 * 
 * @author YoshitakaLiu
 * �������ݡ������û����ÿ��Ǯ�����Ͷ���ͬ������Ӧ�ü�������
 * ��ʵ��Ӧ���У�ͬһ���˻��ſ����в�ͬ�Ĵ������
 *
 */
public class User_Money {
	public double rate;
	int year;
	String classification; 
	double money;
	public User_Money(int y, double m){ // constructor
		set_rate(y);
		money = m;
		year = y;
	}
	void set_rate(int y){
		switch(y)
		{
		case 0: rate = 0.01; classification = "���ڴ��" ;break;
		case 1: rate = 0.027 ; classification = "һ�궨��"; break;
		case 2: rate = 0.031 ; classification = "���궨��"; break;
		case 3: rate = 0.041 ; classification = "���궨��"; break;
		case 5: rate = 0.05 ; classification = "���궨��"; break;
		}
	}
	public void show(){
		System.out.println("��"+money+"    ���ʣ�"+rate+"    ������"+classification+"    ������ޣ�"+year+"��");
	}
	public double get_money(){
		return money;
	}
	public void set_money(double x){//��Ҫ�������û��ڴ����ڴ�������ʱ��ȡ�����ڴ���һ�ξ͹̶������������Ϣ
		money += x;
	}
}
