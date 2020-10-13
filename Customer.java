package advanced_prog_2;

import java.util.*;
import java.util.Map;

public class Customer {
	Scanner s=new Scanner(System.in);
	private final String name;
	private final String address;
	private float account;
	private final String category;
	private float reward;
	HashMap<Items,Integer> cart=new HashMap<>();
	HashMap<Integer,Menu> menu=new HashMap<>();
	//Restrauntclient restassociatedwithvart=null;
	
	
	Customer(String name,String address,float account,String category)
	{
		this.name=name;
		this.address=address;
		this.account=account;
		this.category=category;
		this.reward=0;
		
	}
	/*public Restrauntclient returnv()
	{
		return this.restassociatedwithvart;
	}*/
	public HashMap<Items,Integer> getcart()
	{
		return this.cart;
	}
	public void display()
	{
		System.out.println("***************************************************");
		System.out.println("Welcome "+this.name);
		System.out.println("Customer Menu\n"+
				"1) Select Restaurant\n"+
		"2) checkout cart\n"+
		"3) Reward won\n"+
		"4) print the recent orders\n"+
		"5) Exit\n");
	}
	public void addtocart(Items i,int quantity)
	{
	
		cart.put(i,cart.getOrDefault(i,0)+quantity);
		System.out.println("Items added to cart");
		
	}
	public String returnplace()
	{
		return this.address;
	}
	public float returnamount()
	{
		return this.account;
	}

	public float setreward(float amount)
	{
		this.reward=this.reward+amount;
		return this.reward;
	}
	
	public float displayrewards()
	{
		
		return this.reward;
	}
	
	public String returncategory()
	{
		return this.category;
	}
	public String getname()
	{
		return this.name;
	}
	public boolean amounthandle(float amount)
	{
		if(amount<=this.reward+this.account)
		{
			if(amount<=this.reward)
			{
				this.reward=this.reward-amount;
				amount=0;
			}
			if(amount>this.reward)
			{
				amount=amount-this.reward;
				this.reward=0;
			}
			if(amount<this.account)
			{
				this.account=this.account-amount;
				amount=0;
			}
			return true;
		}
		else
		{
			return false;
			
		}
	
	}

	public void deletesumitems()
	{
		System.out.println("Delete some items from your cart as insufficient balance");
		for (Map.Entry< Items,Integer> e : cart.entrySet()) 
		{
			e.getKey().cartdisplay(e.getValue());
		}
		int deleted=s.nextInt();
		for (Map.Entry< Items,Integer> e : cart.entrySet()) 
		{
			if(deleted==e.getKey().getid())
			{
				cart.remove(e.getKey());
			}
			
		}
		
	}
	public void lastorderdisplay()
	{
		int count=0;
		for( Map.Entry<Integer,Menu> e : menu.entrySet())
		{
			if(count!=10)
			{
				e.getValue().displaylast();
				count++;
			}
			else
			{
				break;
			}
			
		}
	}
	public void clearing_cart()
	{
		for (Map.Entry< Items,Integer> e : cart.entrySet()) 
		{
			
			e.getKey().setquantity(e.getKey().getquantity()-e.getValue());
			
			
		}
	}
	public void displaylastorders()
	{
		Set<Map.Entry<Integer, Menu> > entrySet 
        = menu.entrySet(); 
		 ArrayList<Map.Entry<Integer, Menu> > listOfEntry 
         = new ArrayList<Map.Entry<Integer, Menu> >(entrySet); 
		 int a=0;
		 if(listOfEntry.size()>=10)
		 {
			 a=listOfEntry.size()-10;
		 }
		for (int i = listOfEntry.size()-1;i>=a; i--) 
		{
			
			listOfEntry.get(i).getValue().displaylast();
			
			
		}
	}
	

}
