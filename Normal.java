package advanced_prog_2;

import java.util.*;

public class Normal extends Customer implements Customerclient{
	private float rewarding=0;
	Scanner s=new Scanner(System.in);
	private int quantity=0;
	//private int count=0;
	final int delivery=40;
	private int orders=0;
	Restrauntclient res=null;
	Normal(String name,String address,int account,String category)
	{
		super(name,address,account, category);
		///this.account=10000;
		
	}
	public float billitall()
	{
		float sum=0;
		quantity=0;
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
			float reward_customer=res.calreward(sum);
			rewarding=reward_customer;
			return sum;
		}
		else {
			return 0;
		}
		
		
	}
	@Override
	public String Itemsincart()
	{
		if(!cart.isEmpty()) {
			float sum=billitall();
			//float reward_customer=0;
			sum=sum+delivery;
			System.out.println("Delivery charge -  "+delivery+"/-");
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
					//addtorecentorder(cart);
					//res.orders();
					//clearing_cart();
					//cart.clear();
					//str=a+" "+delivery;	
					return str;
				}
				
				
			}
			
		}
		
		else {
			System.out.println("Empty cart");
			return "";	
			
		}
		//quantity=0;
		return "";
			
		
	}
	public void addtorecentorder(HashMap<Items,Integer> cart)
	{
		for (Map.Entry< Items,Integer> e : cart.entrySet()) 
		{	
			Menu m=new Menu(e.getKey(),e.getValue(),40);
			menu.put(orders++,m);
			
		}
	}

	
}
