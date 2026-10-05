import java.util.Scanner;
public class TestFraction
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the numerator: ");
		int n = input.nextInt();
		System.out.print("Enter the denominator: ");
		int d = input.nextInt();


		try
		{
			//Test : Initialisation par un dénominaterur nul
			Fraction fraction1 = new Fraction(n,d);
			double result = fraction1.getDecimal();
			System.out.println(fraction1 + " = " + result);

			//Test : Division par une fraction nulle
			Fraction fraction2 = new Fraction(0);
			fraction1.divide( fraction2 );
			System.out.println(fraction1 + " = " + result);
		}
		catch (DivisionByZeroException e) //Exc.plus spécifique à l'intérieur
		{
			System.out.println("Error! Division by zero ...");
			//polymorph...
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage()); //polymorph...
		}
		
	}
}