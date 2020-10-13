package advanced_prog_2;

public class Fastfood extends Restraunt implements Restrauntclient {
	Fastfood(String name,String address,String cat)
	{
		super(name,address,cat);
		
	}
	@Override
	public float offergiven_restraunt(float amount)
	{
		amount=amount*((float)(100-this.offer)/(float)100);
		
		return amount;
		
	}
	@Override
	public float calreward(float amount)
	{
		int n=0;
		if(amount>=150)
		{
			 n=(int)(amount/150);
			
		}
		//calculaterewards(n*10);  //set reward for restraunt
		return n*10;
		
	}
}
