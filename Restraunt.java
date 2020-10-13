package advanced_prog_2;
import java.util.*;


public class Restraunt {
	Scanner s=new Scanner(System.in);
	HashMap<Integer,Items> items=new HashMap<>();
	protected final String name;
	protected final String address;
	protected int no_of_orders=0;
	protected final String category;
	static int pid=0;
	static int item=1;
	protected float rewards=0;
	protected int offer=0;
	
	Restraunt(String name,String address,String cat)
	{
		this.name=name;
		this.address=address;
		
		this.category=cat;
		this.pid++;
		
	}
	public void detailsquery3()
	{
		System.out.println(this.name+" "+this.address+" "+this.no_of_orders);
	}
	public String getname()
	{
		return this.name;
	}
	public float  displayrewards()
	{
		return this.rewards;
	}
	public HashMap<Integer,Items> returnItems()
	{
		return this.items;
	}
	
	public void setrestrauntoffer(int a)
	{
		this.offer=a;
	}
	public void orders()
	{
		this.no_of_orders++;
	}
	public float setreward(float num)
	{
		//this.no_of_orders++;
		this.rewards=this.rewards+num;
		return this.rewards;
		
	}
	public String addItems(String name,int price,int quantity,String category,int offer)
	{
	
		Items Item=new Items(name,price,quantity,category,offer,item,(Restrauntclient)this);
		
		items.put(item,Item);
		item++;
		return Item.displayalldetails(Item);
	}
	public void menulist()
	{
		System.out.println("Choose item by code");
		for (Map.Entry< Integer,Items> e : items.entrySet()) 
		{
			System.out.println(e.getValue().displayalldetails(e.getValue()));
		}
	}
	public String edit()
	{
		
		menulist();
		int option_in=s.nextInt();

		Items required=items.get(option_in);
		if(required!=null)
		{
			System.out.println("Choose an attribute to edit:\n" + 
					"1) Name\n" + 
					"2) Price\n" + 
					"3) Quantity\n" + 
					"4) Category\n" + 
					"5) Offer");
			// add query input about which attribute they will edit
			int which_attribute=s.nextInt();
			if(which_attribute==1)
			{
				System.out.println("Enter new name:");
				s.nextLine();
				String name=s.nextLine();
				required.setname(name);
				
			}
			else if(which_attribute==2)
			{
				System.out.println("Enter new price:");
				//s.hasNextLine();
				int price=s.nextInt();
				required.setprice(price);
				
			}
			else if(which_attribute==3)
			{
				System.out.println("Enter new quantity:");
				//s.hasNextLine();
				int quan=s.nextInt();
				required.setquantity(quan);
				
			}
			else if(which_attribute==4)
			{
				System.out.println("Enter new category:");
				s.nextLine();
				String cat=s.nextLine();
				required.setcategory(cat);
				
			}
			else if(which_attribute==5)
			{
				System.out.println("Enter new offer:");
				//s.hasNextLine();
				int offer=s.nextInt();
				required.setoffer(offer);
				
			}
			
			return required.displayalldetails(required);
			
		}
		else
		{
			return "Item does not exist";
			}
		
		
	}
	public void display()
	{
		System.out.println("***************************************************");
		System.out.println("Welcome "+this.name);
		System.out.println( "1) Add item\n"+
		"2) Edit item\n"+
		"3) Print Rewards\n"+
		"4) Discount on bill value\n"+
		"5) Exit\n");
	
		
	}


	
}
