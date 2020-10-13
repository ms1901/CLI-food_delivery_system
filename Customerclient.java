package advanced_prog_2;

import java.util.HashMap;

public interface Customerclient extends User {
	
	//public void display();
	public void addtocart(Items i,int q);
	public String Itemsincart();
	public HashMap<Items,Integer> getcart();
	//public float setreward(float num);
	//public float displayrewards();
	public String  returncategory();
	//public String  getname(); 
	public String returnplace();
	public float returnamount();
	
	public boolean amounthandle(float amount);
	public void displaylastorders();
	
}
