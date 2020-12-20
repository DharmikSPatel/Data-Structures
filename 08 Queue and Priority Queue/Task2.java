import java.io.*;
import java.util.*;
import java.text.*;

public class Task2{
	public static void main(String[]args){
		File file = new File("PassengerInfo.txt");
		Queue<Passenger> q = new LinkedList<Passenger>();
		PriorityQueue<Passenger> pq = new PriorityQueue<Passenger>();
		try{
			String line = "";
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine())!=null){
				String name = line;
				String city = br.readLine();
				String flightTime = br.readLine();
				Passenger p = new Passenger(name, city, flightTime);
				q.add(p);
				if(p.hrDiff() <= 0) //if you want all the passangers to be in pq, then take out this if statement
					pq.add(p);
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
		System.out.println("Regular Queue - all the passengers");
		while(!q.isEmpty()){
			System.out.println(q.poll());
		}
		System.out.println("\nPriorityQueue - passengers that must be moved to head of the line");
		while(!pq.isEmpty()){
			System.out.println(pq.poll());
		}
	}

	public static class Passenger implements Comparable<Passenger>{
		String fname;
		String lname;
		String city;
		String flightTime;
		SimpleDateFormat format = new SimpleDateFormat("h:mm a");
		Calendar curT = Calendar. getInstance();
		Calendar flightT = Calendar. getInstance();
		int hrDiff;
		int minDiff;
		public Passenger(String name, String city, String flightTime){
			String[] arr = name.split(" ");
			fname = arr[0];
			lname = arr[1];
			this.city = city;
			this.flightTime = flightTime;


			try{
				Date date1 = format.parse("9:03 AM");
				Date date2 = format.parse(flightTime);
				curT.setTime(date1);
				flightT.setTime(date2);
			}catch(ParseException e){
				System.out.println(e.toString());
			}
			hrDiff = flightT.get(Calendar.HOUR_OF_DAY) - curT.get(Calendar.HOUR_OF_DAY);
			minDiff = flightT.get(Calendar.MINUTE) - curT.get(Calendar.MINUTE);
			if(minDiff < 0){
				minDiff = 60 + minDiff;
				hrDiff--;
			}

		}
		public String getLastame(){
			return lname;
		}
		public String getFirstName(){
			return fname;
		}
		public String flightCity(){
			return city;
		}
		public String flightTime(){
			return flightTime;
		}
		public int hrDiff(){
			return hrDiff;
		}
		public String etdCalc(){ //returns hours and min diffrence ex: 01:23
			if(hrDiff <= 9)
				return "0"+hrDiff+":"+minDiff;
			return hrDiff+":"+minDiff;
		}
		public String toString(){
			return getLastame()+", "+getFirstName()+" - "+flightCity()+" - "+flightTime()+" - "+etdCalc();
		}
		public int compareTo(Passenger p2){
			return etdCalc().compareTo(p2.etdCalc());
		}

	}
}