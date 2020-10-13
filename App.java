package advanced_prog_2;

import java.util.*;

public class App {
	static float cost=0;
	static int deliverycharges=0;
	static Scanner s=new Scanner(System.in);
	static HashMap<Integer,User> cust=new HashMap<>();
	static HashMap<Integer,User> rest=new HashMap<>();
	//A/rrayList<Restraunt> rest=new ArrayList<>();
	public App()
	{
		
		cust.put(1,new Elitecustomer("Ram","Delhi",1000,"Elite"));
		
		cust.put(2,new Elitecustomer("Sam","Delhi",1000,"Elite"));
		cust.put(3,new Special("Tim","Delhi",1000,"Special"));
		cust.put(4,new Normal("Kim","Delhi",1000,""));
		cust.put(5,new Normal("Jim","Delhi",1000,""));
		//(String name,String address,,String cat)
		rest.put(1,new Authentic("Shah","Delhi","Authentic"));
		rest.put(2,new Rest("Ravi's","Delhi",""));
		rest.put(3,new Authentic("The Chinese","Delhi","Authentic"));
		rest.put(4,new Fastfood("Wang's","Delhi","Fast Food"));
		rest.put(5,new Rest("Paradise","Delhi",""));
		 
		
	}
	public void pay_app(float amount)
	{
		cost=cost+amount;
	}
	public void adddel(int delivery)
	{
		deliverycharges=deliverycharges+delivery;
	}
	public static void restlist()
	{
		System.out.println("***************************************************");
		System.out.println("Choose Restraunt");
		System.out.println("1) Shah (Authentic)\n" + 
				"2) Ravi’s\n" + 
				"3) The Chinese (Authentic)\n" + 
				"4) Wang’s (Fast Food)\n" + 
				"5) Paradise");
	}
	public static void query3()
	{
		System.out.println("1) Customer List\n" + 
				"2) Restaurant List");
		int optionbetween2=s.nextInt();
		if(optionbetween2==1)
		{
			System.out.println("***************************************************");
			System.out.println("1. Ram\n" + 
					"2. Sam\n" + 
					"3. Tim\n" + 
					"4. Kim\n" + 
					"5. Jim");
			int customer=s.nextInt();
			System.out.println(cust.get(customer).getname()+"("+((Customerclient) cust.get(customer)).returncategory()+") ,"+((Customerclient) cust.get(customer)).returnplace()+", "+((Customerclient) cust.get(customer)).returnamount()+"/-");
		}
		else
		{
			restlist();
			int restrauntchosen=s.nextInt();
			((Restrauntclient) rest.get(restrauntchosen)).detailsquery3();
			
		}
		
	}
	

	public static void main(String[] args) {
		User prev=null;
		boolean app_exit=false;
		App a=new App();
		while(!app_exit)
		{	System.out.println("***************************************************");
			System.out.println("Welcome to Zotato");
			System.out.println("	1)Enter as a Restraunt Owner");
			System.out.println("	2)Enter as a Customer");
			System.out.println("	3)Check User Details");
			System.out.println("	4)Comapny Account Details");
			System.out.println("	5)Exit");
			int query=s.nextInt();
			if(query==1)
			{
				
				restlist();
				int option=s.nextInt();
				User rneed=rest.get(option);
				rneed.display();
				boolean exit_menu_option=false;
				
				while(!exit_menu_option)
				{	int option_in_menu=s.nextInt();
					s.nextLine();
					if(option_in_menu==1)
					{
						System.out.println("Food Name:");
						String name=s.nextLine();
						System.out.println("item price:");
						int price=s.nextInt();
						System.out.println("item quantity:");
						int quantity=s.nextInt();
						s.nextLine();
						System.out.println("item category:");
						String category=s.nextLine();
						System.out.println("Offer:");
						int offer=s.nextInt();
						
						System.out.println(((Restrauntclient) rneed).addItems(name, price, quantity, category, offer));
						rneed.display();
						//rneed.display();
			
					}
					else if(option_in_menu==2)
					{
						System.out.println(((Restrauntclient) rneed).edit());
						rneed.display();
						//rneed.display();
					}
					else if(option_in_menu==3)
					{
						System.out.println("Reward Points :"+rneed.displayrewards());
						rneed.display();
					}
					else if(option_in_menu==4)
					{
						//add discount on bill value option //done
						System.out.println("Enter offer on total bill value-");
						int disc=s.nextInt();
						((Restrauntclient) rneed).setrestrauntoffer(disc);
						rneed.display();
					}
					
					else if(option_in_menu==5)
					{
						exit_menu_option=true;
					}
				
				}
				
				
		    } 
		

				
			
			else if(query==2)
			{
				System.out.println("***************************************************");
					System.out.println("1. Ram (Elite)\n"+
							"2. Sam (Elite)\n"+
							"3. Tim (Special)\n"+
							"4. Kim\n"+
							"5. Jim");
					int customersel=s.nextInt();
					User customerobj=cust.get(customersel);
					customerobj.display(); //welcome message
					int customermenusel=s.nextInt();
					//boolean flag=false;
					while(customermenusel!=5)
					{
						if(customermenusel==1)
						{
							restlist();
							int selectrest=s.nextInt();
							
							User wanted=rest.get(selectrest);
							
							if((((Customerclient) customerobj).getcart().isEmpty())||(!((Customerclient) customerobj).getcart().isEmpty() && prev.getname().contentEquals(wanted.getname())))
							{
								
							
							((Restrauntclient) wanted).menulist();  //menu
							int which_item=s.nextInt();
							Items addtolist=((Restrauntclient) wanted).returnItems().getOrDefault(which_item,null);
							while(addtolist==null)
							{
								System.out.println("This item is not in menu list,enter item again");
								
								which_item=s.nextInt();
								 addtolist=((Restrauntclient) wanted).returnItems().getOrDefault(which_item,null);
							}
								
							System.out.println("Enter item quantity");
							int item_quantity=s.nextInt();
							((Customerclient) customerobj).addtocart(addtolist,item_quantity);
							prev=wanted;
							}
							else
							{
								System.out.println("You should order from same restraunt as before");
							}
						
							customerobj.display(); 
							
						}
						else if(customermenusel==2)
						{
							String str=((Customerclient) customerobj).Itemsincart();
							if(str.length()!=0)
							{
								String[] arr=str.split(" ");
								a.pay_app(Float.parseFloat(arr[0])/100);
								a.adddel(Integer.parseInt(arr[1]));
								
								
							}
							customerobj.display(); 
						}
						else if(customermenusel==3)
						{
							System.out.println("Total reward:"+customerobj.displayrewards());
							
							customerobj.display(); 
						}
						else if(customermenusel==4)
						{
							((Customerclient) customerobj).displaylastorders();
							customerobj.display(); 
						}
						
						
						
						
						customermenusel=s.nextInt();
						
						
					}
	
				
			}
			else if(query==3)
			{
				query3();
			}
			else if(query==4)
			{
				System.out.println("Total company balance - INR "+cost+"/-\n"+"Total Delivery charges Collected -INR "+deliverycharges+"/-");
			}
			else if(query==5)
			{
				app_exit=true;
			}	
		}
	}
}
