package advanced_prog_2;

import java.util.HashMap;

//import java.util.Map;

public interface Restrauntclient extends User {
	
	public void setrestrauntoffer(int a);
	//public void calculaterewards(float num);
	public String addItems(String name,int price,int quantity,String category,int offer);
	public void menulist();
	public String edit();
	//public void display(); //common
	public float calreward(float amount);
	public HashMap<Integer,Items> returnItems();
	//public float displayrewards(); //common
	//public String getname(); //common
	public float offergiven_restraunt(float sum);
	//public float setreward(float amount); //common
	public void detailsquery3();
	public void orders();
}
