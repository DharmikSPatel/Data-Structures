import java.io.*;
import java.util.*;
import java.text.*;
public class DateClassPrac{
	public static void main(String[]args){
		DateClassPrac date = new DateClassPrac();
	}
	public DateClassPrac(){
		File file = new File("TravelFile.txt");
		String line = "";
		ArrayList<Date> dates = new ArrayList<Date>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));

			while((line = br.readLine()) != null){
				String[] parts = line.split(" ");
				dates.add(calcualte(parts[0], parts[1], parts[2]));
			}
			Date now = Calendar.getInstance().getTime();
			for(int i = 0; i < dates.size(); i++){
				Date date = dates.get(i);
				SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a 'on' MM/dd/yyyy");
				int index = i+1;
				System.out.println(index);
				System.out.println("Trip "+index);
				System.out.println("\tDeparture Date and Time: "+dateFormat.format(now));
				System.out.println("\tArrival Date and Time: "+dateFormat.format(date));
			}
		}catch(Exception e){
			System.out.println("error");
		}
	}
	public Date calcualte(String gDays, String gHours, String gMin){
		int days = Integer.parseInt(gDays);
		int hours = Integer.parseInt(gHours);
		int min = Integer.parseInt(gMin);

		min = min + hours*60 + days*1440;


		Calendar future = Calendar.getInstance();

		future.add(Calendar.MINUTE, min);

		return future.getTime();
	}
}