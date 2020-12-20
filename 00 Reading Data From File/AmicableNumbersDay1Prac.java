import java.io.*;
import java.util.*;
public class AmicableNumbersDay1Prac {
	File file = new File("AmicableNumFile.txt");


	public AmicableNumbersDay1Prac(){
		try{
			BufferedReader input = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = input.readLine())!=null){
				String[] pieces = line.split(" ");
				int num1 = Integer.parseInt(pieces[0]);
				int num2 = Integer.parseInt(pieces[1]);

				ArrayList<Integer> fact1 = getFactors(num1);
				ArrayList<Integer> fact2 = getFactors(num2);

				int sum1 = getSum(fact1);
				int sum2 = getSum(fact2);

				if(sum1 == num2 && sum2 == num1)
					resultText(num1, num2, fact1, fact2, sum1, sum2, true);
				else
					resultText(num1, num2, fact1, fact2, sum1, sum2, false);
			}
		}catch(IOException ioe){
			System.out.println("Error");
		}
	}
	public ArrayList<Integer> getFactors(int num){
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for(int x = 1; x < num; x++){
			if(num%x == 0){
				factors.add(x);
			}
		}
		return factors;
	}

	public int getSum(ArrayList<Integer> list){
		int sum = 0;
		for(int x = 0; x < list.size(); x++){
			sum+=list.get(x);
		}
		return sum;
	}
	public void resultText(int num1, int num2, ArrayList<Integer> fact1, ArrayList<Integer> fact2, int sum1, int sum2, boolean yes){
		if(yes == true)
			System.out.println("The numbers "+num1+" and "+num2+" are amicable.");
		else
			System.out.println("The numbers "+num1+" and "+num2+" are not amicable.");
		System.out.print("\tFactors of "+ num1+" are ");
		for(int x = 0; x < fact1.size(); x++){
			if(x == fact1.size()-1)
				System.out.print(fact1.get(x)+".");
			else if(x == fact1.size()-2)
				System.out.print(fact1.get(x)+" and ");
			else
				System.out.print(fact1.get(x)+", ");
		}
		System.out.println("The sum is "+sum1+".");
		System.out.print("\tFactors of "+ num2+" are ");
		for(int x = 0; x < fact2.size(); x++){
			if(x == fact2.size()-1)
				System.out.print(fact2.get(x)+".");
			else if(x == fact2.size()-2)
				System.out.print(fact2.get(x)+" and ");
			else
				System.out.print(fact2.get(x)+", ");
		}
		System.out.println("The sum is "+sum2+".");
	}

	public static void main(String[]args){
		AmicableNumbersDay1Prac app = new AmicableNumbersDay1Prac();
	}
}