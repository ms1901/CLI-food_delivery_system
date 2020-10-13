package advanced_prog_2;

public class Authentic extends Restraunt implements Restrauntclient{
	Authentic(String name,String address,String cat)
	{
		super(name,address,cat);
		
	}
	@Override
	public float offergiven_restraunt(float amount)
	{
		amount=amount*((float)(100-this.offer)/(float)100);
		if(amount>100)
		{
			amount=amount-50;
		}
		return amount;
		
	}
	@Override
	public float calreward(float amount)
	{
		int n=0;
		if(amount>=200)
		{
			 n=(int)(amount/200);
			
		}
		//calculaterewards(n*25);
		return n*25;
		
	}


}
