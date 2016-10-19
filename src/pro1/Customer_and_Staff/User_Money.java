package pro1.Customer_and_Staff;
 
/**
 * 
 * @author YoshitakaLiu
 * 用来形容“存款”，用户存的每笔钱其类型都不同，所以应该加以区分
 * 在实际应用中，同一个账户张可以有不同的存款类型
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
		case 0: rate = 0.01; classification = "活期存款" ;break;
		case 1: rate = 0.027 ; classification = "一年定期"; break;
		case 2: rate = 0.031 ; classification = "两年定期"; break;
		case 3: rate = 0.041 ; classification = "三年定期"; break;
		case 5: rate = 0.05 ; classification = "五年定期"; break;
		}
	}
	public void show(){
		System.out.println("金额："+money+"    利率："+rate+"    存款类别："+classification+"    存款年限："+year+"年");
	}
	public double get_money(){
		return money;
	}
	public void set_money(double x){//主要用来设置活期存款，活期存款可以随时存取；定期存款存一次就固定下来其各项信息
		money += x;
	}
}
