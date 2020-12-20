import java.util.Stack;
import java.io.*;
public class StackPractice{
	public static void main(String[] args){
		//Task 1
		Stack<Integer> stack = new Stack<Integer>();
		int num = 221;
		int qou = -1;
		int rem = -1;
		System.out.println("Task 1");
		System.out.print("The binary of "+num+": ");
		while(num != 0){
			rem = num % 2;
			num/=2;
			stack.push(rem);
		}
		if(stack.size()>1){
			while(!stack.empty()){
				System.out.print(stack.pop());
			}
		}
		else{
			System.out.print(0);
		}
		System.out.println("\n");

		//Task 2
		Stack<Character> stack2 = new Stack<Character>();
		String str = "Where there is a will, there are 500 relatives.";
		System.out.println("Task 2");
		System.out.println("The reverse of \""+str+"\" is:");
		for(int i = 0; i < str.length(); i++){
			stack2.push(str.charAt(i));
		}
		while(!stack2.empty()){
			System.out.print(stack2.pop());
		}
		System.out.println("\n");

		//Task 3
		System.out.println("Task 3");
		File file = new File("StarWarsCharacters.csv");
		String line = "";
		String gender;
		String type;
		String bday;
		Stack<Characters> males = new Stack<Characters>();
		Stack<Characters> females = new Stack<Characters>();
		Stack<Characters> droids = new Stack<Characters>();
		Stack<Characters> validBdays = new Stack<Characters>();

		try{
			BufferedReader input = new BufferedReader(new FileReader(file));
			while((line = input.readLine()) != null){
				String[] arr = line.split(",");

				if(arr.length!=9){
					gender = arr[7];
					type = arr[9];
					bday = arr[6];
					if(gender.equals("male")){
						males.push(new Characters(arr[0],arr[6],arr[7],arr[8],arr[9]));
					}
					else if(gender.equals("female")){
						females.push(new Characters(arr[0],arr[6],arr[7],arr[8],arr[9]));
					}
					if(type.equals("Droid")){
						droids.push(new Characters(arr[0],arr[6],arr[7],arr[8],arr[9]));
					}
					if(bday.contains("BBY")){
						validBdays.push(new Characters(arr[0],arr[6],arr[7],arr[8],arr[9]));
					}
				}
				else{

					gender = arr[6];
					type = arr[8];
					bday = arr[5];
					if(gender.equals("male")){
						males.push(new Characters(arr[0],arr[5],arr[6],arr[7],arr[8]));
					}
					else if(gender.equals("female")){
						females.push(new Characters(arr[0],arr[5],arr[6],arr[7],arr[8]));
					}
					if(type.equals("Droid")){
						droids.push(new Characters(arr[0],arr[5],arr[6],arr[7],arr[8]));
					}
					if(bday.contains("BBY")){
						validBdays.push(new Characters(arr[0],arr[5],arr[6],arr[7],arr[8]));
					}
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println("Male Characters");
		System.out.println(String.format("%-25s%-20s","Name","Home World"));

		while(!males.empty()){
			System.out.println(males.pop());
		}
		System.out.println("\n");
		System.out.println("Female Characters");
		System.out.println(String.format("%-25s%-20s","Name","Home World"));

		while(!females.empty()){
			System.out.println(females.pop());
		}
		System.out.println("\n");
		System.out.println("Droids");
		System.out.println(String.format("%-25s%-20s","Name","Home World"));
		while(!droids.empty()){
			System.out.println(droids.pop());
		}
		System.out.println("\n");
		System.out.println("Characters with valid bdays");
		System.out.println(String.format("%-25s%-20s%-20s","Name","Home World","Birth Year(BBY)"));

		while(!validBdays.empty()){
			System.out.println(validBdays.pop());
		}
		System.out.println("\n");
	}
	public static class Characters{
		static int counter = 0;
		private String name, gender, world, type;
		private String birth;
		public Characters(String name, String birth, String gender, String world, String type){
			counter++;
			this.name = name;
			if(!gender.equals("NA") || !gender.equals("none")){
				this.gender = gender;
			}
			else{
				this.gender = "Unknown";
			}
			if(!world.equals("NA")){
				this.world = world;
			}
			else{
				this.world = "Unknown";
			}
			if(!type.equals("NA")){
				this.type = type;
			}
			else{
				this.type = "Unknown";
			}
			if(!birth.equals("NA"))
				this.birth = birth.replace("BBY","");
			else
				this.birth = "Unknown";

		}
		public String toString(){
			if(!birth.equals("Unknown")){
				return String.format("%-25s%-20s%-20s",name,world,birth);
			}
			else
				return String.format("%-25s%-20s",name,world);
			}

	}
}