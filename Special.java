package advanced_prog_2;

import java.util.*;

public class Special extends Customer implements Customerclient{
	Scanner s=new Scanner(System.in);
	final int delivery=20;
	private int quantity=0;
	
	private int orders=0;
	Restrauntclient res=null;
	private float rewarding=0;
	Special(String name,String address,int account,String category)
	{
		super(name,address,account, category);
		
		
	}
	public float calculate_bill_customertype(float price)
	{

		if(price>200)
		{
			price=price-25;
		}
		
		return price;
	}
	public float billitall()
	{
		float sum=0;
		System.out.println("Items in Cart -");
		
		for (Map.Entry< Items,Integer> e : cart.entrySet()) 
		{
			float original_price=0;
			e.getKey().cartdisplay(e.getValue());
			original_price=e.getKey().calculatesumafterproductdiscount(e.getValue());
			quantity=quantity+e.getValue();
			sum=sum+original_price;
			
			res=e.getKey().restraunt_where;
				
		}
		if(res!=null) {
			sum=res.offergiven_restraunt(sum);
			//this.restassociatedwithvart=res;
			sum=calculate_bill_customertype(sum);
			
			float reward_customer=res.calreward(sum);
			System.out.println(reward_customer);
			rewarding=reward_customer;
			return sum;
			
		}
		else
		{
			return 0;
		}
		
		
	}
	@Override
	public String Itemsincart()
	{
		if(!cart.isEmpty())
		{
			float sum=billitall();
			
			sum=sum+delivery;
			System.out.println("Delivery charge - + "+delivery+"/-");
			System.out.println("Total order value - INR "+sum+" /-\n"+
			"1)Procced to check out");
			float a=sum-delivery;
			String str="";
			int check_out=s.nextInt();
			if(check_out==1)
			{	boolean sufficient_amount=amounthandle(sum);
				if(sufficient_amount) 
				{
					this.setreward(rewarding);
					res.setreward(rewarding);
					System.out.println(quantity+" items successfully bought for INR "+sum+"/-");
					clearing_cart();
					cart.clear();
					res.orders();
					quantity=0;
					str=a+" "+delivery;	
					return str;
					
				}
				else
				{
					deletesumitems();
					quantity=0;
					Itemsincart();
					//res.orders();
					//clearing_cart();
					//cart.clear();
					//str=a+" "+delivery;	
					return str;
				}
				
				
			}
		}
		
		System.out.println("Empty cart");
		return "";		
		
	}
	public void addtorecentorder(HashMap<Items,Integer> cart)
	{
		for (Map.Entry< Items,Integer> e : cart.entrySet()) 
		{	
			Menu m=new Menu(e.getKey(),e.getValue(),20);
			menu.put(orders++,m);
			
		}
	}
}