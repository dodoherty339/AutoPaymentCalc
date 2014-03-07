package calculator;

public class AutoLoanCalculator 
{
	public static void main(String[] args) 
	{
		CalculatorDisplay cd = new CalculatorDisplay(600, 750);
		
		cd.genInitValEntryPage();
		cd.openShell();
		cd.sleep();
		cd.close();
	}
}
