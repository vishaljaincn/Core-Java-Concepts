package calculatorapplication;

public class Add implements Operate
{

	@Override
	public Double getResult(Double... numbers)
	{
		Double sum=0.0;
		for(Double num:numbers)
		{
			sum=sum+num;
		}
	
		return sum;
	}
	
}
