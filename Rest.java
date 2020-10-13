package advanced_prog_2;

public class Rest extends Restraunt implements Restrauntclient {
	final int offer=0;
	@Override
	public void setrestrauntoffer(int a)
	{
		System.out.println("Restraunt does not offer a discount,so cannot this value as discount");
	}
	Rest(String name,String address,String cat)
	{
		super(name,address,cat);
		
	}
	@Override
	public float offergiven_restraunt(float amount)
	{
		amount=amount*((100-this.offer)/100);
		
		return amount;
		
	}
	@Override
	public float calreward(float amount)
	{
		int n=0;
		if(amount>=100)
		{
			 n=(int)(amount/100);
			
		}
		//calculaterewards(n*5); //sets reward of restraunt
		return n*5;
		
	}


}
