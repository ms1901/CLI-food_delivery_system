package advanced_prog_2;

public class Items {
	 String itemname;
	private int price;
	private int quantity;
	private String category;
	private int offer;
	private final int id;
	Restrauntclient restraunt_where;
	

	Items(String name,int price,int quantity,String category,int offer,int id,Restrauntclient r)
	{
		this.itemname=name;
		this.price=price;
		this.quantity=quantity;
		this.category=category;
		this.offer=offer;
		this.id=id;
		this.restraunt_where=r;
			
	}
	public Restrauntclient restrauntname()
	{
		return restraunt_where;
	}
	public void setname(String name)
	{
		this.itemname=name;
	}
	public String getname()
	{
		return this.itemname;
	}
	public void setprice(int  price)
	{
		this.price=price;
	}
	public void setquantity(int quan)
	{
		this.quantity=quan;
	}
	public int getquantity()
	{
		return this.quantity;
	}
	public void setcategory(String category)
	{
		this.category=category;
	}
	public void setoffer(int offer)
	{
		this.offer=offer;
	}
	public int getid()
	{
		return this.id;
	}
	public String displayalldetails(Items i)
	{
		// only used after adding new items
		//System.out.println("in items");
		String str= i.id+" "+i.itemname+" "+i.price+" "+i.quantity+" "+i.offer+"% off "+i.category;
		return str;
	}
	public void cartdisplay(int quantity)
	{
		//display details of items in cart
		System.out.println(this.id+" "+this.restraunt_where.getname()+" - "+this.itemname+" - "+this.price+" - "+quantity+" - "+this.offer+"% off");
		//calculate_bill(this);
	}
	public float calculatesumafterproductdiscount(int quan)
	{
		float original_price=this.price*quan;
		original_price=original_price*(float)(100-this.offer)/(float)100;
		return original_price;    			//price after product discount
		
	}
	
}
