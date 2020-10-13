package advanced_prog_2;

public class Menu {
	Items i;
	//String name;
	//float amount;
	private int quantity;
	private int delivery_cost;
	Menu(Items i,int quantity,int delivery_charge)
	{
		this.i=i;
		this.quantity=quantity;
		this.delivery_cost=delivery_charge;
	}
	public void displaylast()
	{
		System.out.println("Bought item "+this.i.getname()+" ,quantity "+this.quantity+" for Rs "+this.i.calculatesumafterproductdiscount(quantity)+"(item price after only product discount) from "+this.i.restrauntname().getname()+" Delivery Charge : "+this.delivery_cost);
	}
	

	
}
