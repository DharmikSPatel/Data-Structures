import java.util.*;
import java.io.*;
public class CarTask{
	public static void main(String[] args){
		File file = new File("CarData.txt");
		Queue<Car> q = new LinkedList<Car>();
		Stack<Car> s = new Stack<Car>();
		PriorityQueue<Car> pq = new PriorityQueue<Car>();

		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			br.readLine();
			while((line = br.readLine())!=null){
				String[] arr = line.split("\\s+");
				Car car = new Car(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]), Integer.parseInt(arr[6]), Integer.parseInt(arr[7]));
				q.add(car);
			}
		}catch(Exception e){
			System.out.println("Error");
		}
		System.out.println("Regular Queue");
		System.out.println(String.format("%-10s%-15s%-15s%-15s%-10s%-15s%-10s%-20s", "ID", "Miles/Gallon", "Engine Size", "Horse Power", "Weight", "Acceleration", "Country", "Number of Cylinders"));
		while(!q.isEmpty()){  //this prints out the queue and adds them to the stack
			Car c = q.poll();
			System.out.println(c);
			s.push(c);
		}
		System.out.println("Stack");
		System.out.println(String.format("%-10s%-15s%-15s%-15s%-10s%-15s%-10s%-20s", "ID", "Miles/Gallon", "Engine Size", "Horse Power", "Weight", "Acceleration", "Country", "Number of Cylinders"));
		while(!s.isEmpty()){ //this prints out the stack and adds them to the priority queue
			Car c = s.pop();
			System.out.println(c);
			pq.add(c);
		}
		System.out.println("Priority Queue");
		System.out.println(String.format("%-10s%-15s%-15s%-15s%-10s%-15s%-10s%-20s", "ID", "Miles/Gallon", "Engine Size", "Horse Power", "Weight", "Acceleration", "Country", "Number of Cylinders"));
		while(!pq.isEmpty()){ //this prints out the priority queue
			System.out.println(pq.poll());
		}

	}
	public static class Car implements Comparable<Car>{
		private int id;
		private int mpg;
		private int engineSize;
		private int horsePower;
		private int weight;
		private int acer;
		private int origin;
		private int cylinders;
		public Car(int id, int mpg, int engineSize, int horsePower, int weight, int acer, int origin, int cylinders){
			this.id = id;
			this.mpg = mpg;
			this.engineSize = engineSize;
			this.horsePower = horsePower;
			this.weight = weight;
			this.acer = acer;
			this.origin = origin;
			this.cylinders = cylinders;
		}
		public Integer id(){
			return id;
		}
		public Integer mpg(){
			return mpg;
		}
		public Integer engineSize(){
			return engineSize;
		}
		public Integer horsePower(){
			return horsePower;
		}
		public Integer weight(){
			return weight;
		}
		public Integer acer(){
			return acer;
		}
		public Integer origin(){
			return origin;
		}
		public Integer cylinders(){
			return cylinders;
		}
		public String toString(){
			return String.format("%-10s%-15s%-15s%-15s%-10s%-15s%-10s%-20s", id, mpg, engineSize, horsePower, weight, acer, origin, cylinders);
		}
		public int compareTo(Car c){

			/*
			1. Acceleration
			2. Miles Per Gallon
			3. Horsepower
			4. Engine Size
			5. Weight
			6. Cylinders
			7. CarID
			*/
			if (acer().compareTo(c.acer()) == 0)
				if (mpg().compareTo(c.mpg()) == 0)
					if (horsePower().compareTo(c.horsePower()) == 0)
						if (engineSize().compareTo(c.engineSize()) == 0)
							if (weight().compareTo(c.weight()) == 0)
								if (cylinders().compareTo(c.cylinders()) == 0)
									if (id().compareTo(c.id()) == 0)
										return 0;
									else
										return id().compareTo(c.id());
								else
									return -(cylinders().compareTo(c.cylinders()));
							else
								return weight().compareTo(c.weight()); //smaller weight is better
						else
							return -(engineSize().compareTo(c.engineSize()));
					else
						return -(horsePower().compareTo(c.horsePower()));
				else
					return -(mpg().compareTo(c.mpg()));
			else
				return -(acer().compareTo(c.acer()));

		}
	}
}