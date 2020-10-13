package advanced_prog_2;

import java.util.*;

public class Elitecustomer extends Customer implements Customerclient{
	Scanner s=new Scanner(System.in);
	protected int count=0;
	 protected int delivery=0;
	protected int quantity=0;
	protected int orders=0;
	protected float rewarding=0;
	Restrauntclient res=null;
	Elitecustomer(String name,String address,int account,String category)
	{
		super(name,address,account, category);
		///this.account=10000;
		
	}


	public float calculate_bill_customertype(float price)
	{
		
		if(price>200)
		{
			price=price-50;
		}
		
		return price;
	}
	
	public float billitall()
	{
		float sum=0;
		
		System.out.println("Items in Cart -");
		//Restrauntclient res=null;
		for (Map.Entry< Items,Integer> e : cart.entrySet()) 
		{
			
			float original_price=0;
			e.getKey().cartdisplay(e.getValue());
			original_price=e.getKey().calculatesumafterproductdiscount(e.getValue());
			quantity=quantity+e.getValue();
			sum=sum+original_price;
	
			res=e.getKey().restraunt_where;
				
		}
		if(res!=null)
		{
			sum=res.offergiven_restraunt(sum);
			//this.restassociatedwithvart=res;
			sum=calculate_bill_customertype(sum);

			float reward_customer=res.calreward(sum);
			rewarding=reward_customer;
			return sum;
		}
		return 0;
		
		
	}
	@Override
	public String Itemsincart()
	{
		if(!cart.isEmpty()) {
			float sum=billitall();
			
			sum=sum+delivery;
			System.out.println("Delivery charge - "+delivery+"/-");
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
					addtorecentorder(cart);
					res.orders();
					clearing_cart();
					cart.clear();
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
					//addtorecentorder(cart);
					//clearing_cart();
					//cart.clear();
					//str=a+" "+delivery;	
					return str;
				}
				
				
			}
			
		}
		else
		{
			System.out.println("Empty cart");
			return "";
		}

		return "";
		
		
	}
	public void addtorecentorder(HashMap<Items,Integer> cart)
	{
		for (Map.Entry< Items,Integer> e : cart.entrySet()) 
		{	
			Menu m=new Menu(e.getKey(),e.getValue(),0);
			menu.put(orders++,m);
			
		}
	}

	
	

}
