package experiment2;

public class Solver {
	
	private double a,b,c;
	private Result result;
	public Solver(double a, double b, double c)
	{
		this.setA(a);
		this.setB(b);
		this.setC(c);
		this.setResult(new Result());
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result)
	{
		this.result=result;
	}
	public void SolvingEquation()
	{
		double d=b*b-4*a*c,x1,x2;
		boolean flag;
		if(d<0)
		{
			flag=false;
			this.result.setFlag(flag);
		}
		else
		{
			flag=true;
			x1=(-b+Math.sqrt(d))/2/a;
			x2=(-b-Math.sqrt(d))/2/a;
			this.result.setFlag(flag);
			this.result.setX1(x1);
			this.result.setX2(x2);
		}
	}
	
}
