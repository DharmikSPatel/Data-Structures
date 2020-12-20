import java.io.*;
import java.util.*;
public class Football{

	public Football(){
		File file = new File("FFL Draft Averages.txt");
		ArrayList<Player> players = new ArrayList<Player>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			br.readLine();
			while((line = br.readLine())!=null){
				String[] parts = line.split(";");
				players.add(new Player(parts[1], Double.parseDouble(parts[5]), (parts[7]), (parts[8])));
			}
		}catch(Exception e){
			System.out.println("error");
		}
		Collections.sort(players);
		System.out.println("Name\t\t\tBestPick\tWorstPick\tDifference\tOverall\n");
		for(int x  = 0;  x < players.size(); x++){
			System.out.println(players.get(x));
		}

	}

	public static void main(String[]args){
		Football fb = new Football();
	}

	public class Player implements Comparable<Player>{
		private String name;
		private double overall;
		private int[] bestPos;
		private int[] worstPos;
		private double best;
		private double worst;
		private int diff;

		public Player(String name, double overall, String best, String worst){
			this.name = name;
			this.overall = overall;
			this.best = Double.parseDouble(best);
			this.worst = Double.parseDouble(worst);
			if(best.length()<=3){
				best+="0";
			}
			if(worst.length()<=3){
				worst+="0";
			}

			String[] bestSA = best.split("\\.");
			bestPos = new int[]{
					Integer.parseInt(bestSA[0]),
					Integer.parseInt(bestSA[1])
				};
			String[] worstSA = worst.split("\\.");
			worstPos = new int[]{
					Integer.parseInt(worstSA[0]),
					Integer.parseInt(worstSA[1])
				};
			int part1 = (worstPos[0]-bestPos[0])*12;
			int part2 = worstPos[1] - bestPos[1];
			diff = part1+part2;

		}


		public String toString(){
			if(name.length()<16)
				return name +"\t\t" + best +"\t\t" + worst+ "\t\t" + diff + "\t\t" + overall + "\n";
			else
				return name +"\t" + best +"\t\t" + worst+ "\t\t" + diff + "\t\t" + overall + "\n";
		}
		public int compareTo(Player player){
			int result = this.diff-player.diff;
			if(result == 0)
				return (int)(player.overall-this.overall);
			else
				return result;
		}
	}
}